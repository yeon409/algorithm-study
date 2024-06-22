package week01;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ17143 {

    private static int numRows, numCols;
    private static Shark[][] currentSharks, nextSharks;
    private static int [][] directions = {{0,0}, {-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        numRows = Integer.parseInt(tokenizer.nextToken()) + 1;
        numCols = Integer.parseInt(tokenizer.nextToken()) + 1;
        int sharkCount = Integer.parseInt(tokenizer.nextToken());

        int totalSizeCaught = 0;
        currentSharks = new Shark[numRows][numCols];

        for(int i = 0; i < sharkCount; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int row = Integer.parseInt(tokenizer.nextToken());
            int col = Integer.parseInt(tokenizer.nextToken());
            int speed = Integer.parseInt(tokenizer.nextToken());
            int direction = Integer.parseInt(tokenizer.nextToken());
            int size = Integer.parseInt(tokenizer.nextToken());
            currentSharks[row][col] = new Shark(speed, direction, size);
        }

        for(int fisherPosition = 1; fisherPosition < numCols; fisherPosition++) {

            for(int depth = 1; depth < numRows; depth++) {
                if(currentSharks[depth][fisherPosition] != null) {
                    totalSizeCaught += currentSharks[depth][fisherPosition].size;
                    currentSharks[depth][fisherPosition] = null;
                    break;
                }
            }

            nextSharks = new Shark[numRows][numCols];

            for(int r = 1; r < numRows; r++) {
                for(int c = 1; c < numCols; c++) {

                    if(currentSharks[r][c] != null) {
                        int direction = currentSharks[r][c].direction;
                        int speed = currentSharks[r][c].speed;
                        int size = currentSharks[r][c].size;
                        int newRow = r;
                        int newCol = c;

                        if(direction == 1 || direction == 2) {
                            speed %= 2 * (numRows - 1) - 2;
                        } else {
                            speed %= 2 * (numCols - 1) - 2;
                        }

                        for(int s = 0; s < speed; s++) {
                            newRow += directions[direction][0];
                            newCol += directions[direction][1];

                            if(!withinBounds(newRow, newCol)) {
                                direction = reverseDirection(direction);
                                newRow += directions[direction][0] * 2;
                                newCol += directions[direction][1] * 2;
                            }
                        }

                        if(nextSharks[newRow][newCol] != null) {
                            if(nextSharks[newRow][newCol].size < size) {
                                nextSharks[newRow][newCol] = new Shark(speed, direction, size);
                            }
                        } else {
                            nextSharks[newRow][newCol] = new Shark(speed, direction, size);
                        }
                    }

                }
            }

            for(int i = 1; i < numRows; i++) {
                for(int j = 1; j < numCols; j++) {
                    currentSharks[i][j] = nextSharks[i][j];
                }
            }

        }

        System.out.println(totalSizeCaught);

    }

    private static boolean withinBounds(int r, int c) {
        return r > 0 && c > 0 && r < numRows && c < numCols;
    }

    private static int reverseDirection(int dir) {
        switch (dir) {
            case 1:
                return 2;
            case 2:
                return 1;
            case 3:
                return 4;
            case 4:
                return 3;
            default:
                return -1;
        }
    }

    private static class Shark {
        int speed, direction, size;

        public Shark(int speed, int direction, int size) {
            this.speed = speed;
            this.direction = direction;
            this.size = size;
        }
    }
}
