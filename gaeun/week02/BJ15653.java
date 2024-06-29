package week02;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Objects;

public class BJ15653 {
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    static class Marble {
        private int row, col;
        public boolean isInHole;

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Marble marble = (Marble) obj;
            return row == marble.row &&
                    col == marble.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }

        @Override
        public String toString() {
            return "row = " + this.row + " col = " + this.col;
        }

        Marble(int r, int c) {
            row = r;
            col = c;
            this.isInHole = false;
        }

        Marble(Marble m) {
            row = m.row;
            col = m.col;
            isInHole = false;
        }

        public void moveLeft() {
            this.col--;
        }

        public void moveRight() {
            this.col++;
        }

        public void moveUp() {
            this.row--;
        }

        public void moveDown() {
            this.row++;
        }
    }

    static class Board {
        private int rows, cols;
        private int holeRow, holeCol;
        private Character[][] grid;
        private Marble red, blue;
        private int[][][][] visited = new int[11][11][11][11];

        Board(int r, int c) {
            rows = r;
            cols = c;
            grid = new Character[r][c];

            for (int i = 0; i < 11; i++) {
                for (int j = 0; j < 11; j++) {
                    for (int k = 0; k < 11; k++) {
                        for (int l = 0; l < 11; l++) {
                            visited[i][j][k][l] = Integer.MAX_VALUE;
                        }
                    }
                }
            }
        }

        public void initializeBoard() throws IOException {
            for (int i = 0; i < rows; i++) {
                StringTokenizer st = new StringTokenizer(input.readLine());
                String line = st.nextToken();
                for (int j = 0; j < cols; j++) {
                    grid[i][j] = line.charAt(j);
                    if (grid[i][j] == 'R') {
                        red = new Marble(i, j);
                    } else if (grid[i][j] == 'B') {
                        blue = new Marble(i, j);
                    } else if (grid[i][j] == 'O') {
                        holeCol = j;
                        holeRow = i;
                    }
                }
            }
        }

        public boolean hasNoMove(Marble m1, Marble m2, Marble t1, Marble t2){
            return m1.equals(t1) && m2.equals(t2);
        }

        public boolean isNextMoveValid(Marble nm1, Marble nm2, Marble m1, Marble m2, int steps){
            return !hasNoMove(nm1, nm2, m1, m2) && (visited[nm1.row][nm1.col][nm2.row][nm2.col] > steps);
        }

        public int checkHole(Marble m, Marble b){
            if (isHole(b)) {
                return -1;
            } else if (isHole(m)) {
                return 0;
            } else {
                return 1;
            }
        }

        public int tilt(Marble m, Marble b, int steps) {
            int minSteps = Integer.MAX_VALUE;
            Marble newM, newB;

            newM = new Marble(m);
            newB = new Marble(b);
            if (newM.row < newB.row) {
                tiltUp(newM, newB);
            } else {
                tiltUp(newB, newM);
            }
            if(newM.isInHole && !newB.isInHole) {
                return steps;
            }
            if (!newB.isInHole && isNextMoveValid(newM, newB, m, b, steps)) {
                visited[newM.row][newM.col][newB.row][newB.col] = steps;
                int result = tilt(newM, newB, steps + 1);
                if (result != -1)
                    minSteps = Math.min(minSteps, result);
            }

            newM = new Marble(m);
            newB = new Marble(b);
            if (newM.row > newB.row) {
                tiltDown(newM, newB);
            } else {
                tiltDown(newB, newM);
            }
            if(newM.isInHole && !newB.isInHole) {
                return steps;
            }
            if (!newB.isInHole && isNextMoveValid(newM, newB, m, b, steps)) {
                visited[newM.row][newM.col][newB.row][newB.col] = steps;
                int result = tilt(newM, newB, steps + 1);
                if (result != -1)
                    minSteps = Math.min(minSteps, result);
            }

            newM = new Marble(m);
            newB = new Marble(b);
            if (newM.col > newB.col) {
                tiltLeft(newB, newM);
            } else {
                tiltLeft(newM, newB);
            }
            if(newM.isInHole && !newB.isInHole) {
                return steps;
            }
            if (!newB.isInHole && isNextMoveValid(newM, newB, m, b, steps)) {
                visited[newM.row][newM.col][newB.row][newB.col] = steps;
                int result = tilt(newM, newB, steps + 1);
                if (result != -1)
                    minSteps = Math.min(minSteps, result);
            }

            newM = new Marble(m);
            newB = new Marble(b);
            if (newM.col > newB.col) {
                tiltRight(newM, newB);
            } else {
                tiltRight(newB, newM);
            }
            if(newM.isInHole && !newB.isInHole) {
                return steps;
            }
            if (!newB.isInHole && isNextMoveValid(newM, newB, m, b, steps)) {
                visited[newM.row][newM.col][newB.row][newB.col] = steps;
                int result = tilt(newM, newB, steps + 1);
                if (result != -1)
                    minSteps = Math.min(minSteps, result);
            }

            return minSteps;
        }

        public boolean isValidMove(Marble m) {
            return m.row >= 0 && m.row < rows && m.col >= 0 && m.col < cols && (grid[m.row][m.col] != '#');
        }

        public boolean isHole(Marble m) {
            return m.row == holeRow && m.col == holeCol;
        }

        public boolean isCollision(Marble m, Marble b) {
            return ((m.row == b.row) && (m.col == b.col));
        }

        public void tiltLeft(Marble m, Marble b) {
            while (true) {
                m.moveLeft();
                if (!isValidMove(m)) {
                    m.moveRight();
                    break;
                }
                if (isHole(m)) {
                    m.row = m.col = -1;
                    m.isInHole = true;
                    break;
                }
            }
            while (true) {
                b.moveLeft();
                if (!isValidMove(b) || isCollision(b, m)) {
                    b.moveRight();
                    break;
                }
                if (isHole(b)) {
                    b.row = b.col = -1;
                    b.isInHole = true;
                    break;
                }
            }
        }

        public void tiltRight(Marble m, Marble b) {
            while (true) {
                m.moveRight();
                if (!isValidMove(m)) {
                    m.moveLeft();
                    break;
                }
                if (isHole(m)) {
                    m.row = m.col = -1;
                    m.isInHole = true;
                    break;
                }
            }
            while (true) {
                b.moveRight();
                if (!isValidMove(b) || isCollision(b, m)) {
                    b.moveLeft();
                    break;
                }
                if (isHole(b)) {
                    b.row = b.col = -1;
                    b.isInHole = true;
                    break;
                }
            }
        }

        public void tiltUp(Marble m, Marble b) {
            while (true) {
                m.moveUp();
                if (!isValidMove(m)) {
                    m.moveDown();
                    break;
                }
                if (isHole(m)) {
                    m.row = m.col = -1;
                    m.isInHole = true;
                    break;
                }
            }
            while (true) {
                b.moveUp();
                if (!isValidMove(b) || isCollision(b, m)) {
                    b.moveDown();
                    break;
                }
                if (isHole(b)) {
                    b.row = b.col = -1;
                    b.isInHole = true;
                    break;
                }
            }
        }

        public void tiltDown(Marble m, Marble b) {
            while (true) {
                m.moveDown();
                if (!isValidMove(m)) {
                    m.moveUp();
                    break;
                }
                if (isHole(m)) {
                    m.row = m.col = -1;
                    m.isInHole = true;
                    break;
                }
            }
            while (true) {
                b.moveDown();
                if (!isValidMove(b) || isCollision(b, m)) {
                    b.moveUp();
                    break;
                }
                if (isHole(b)) {
                    b.row = b.col = -1;
                    b.isInHole = true;
                    break;
                }
            }
        }
    }

    static int rows, cols;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        rows = Integer.parseInt(st.nextToken());
        cols = Integer.parseInt(st.nextToken());
        Board board = new Board(rows, cols);
        board.initializeBoard();
        int result = board.tilt(board.red, board.blue, 1);
        output.write((result == Integer.MAX_VALUE ? -1 : result) + "\n");
        output.flush();
    }
}
