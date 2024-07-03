package week03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA05 {

    private final static int CMD_INIT				= 1;
    private final static int CMD_HIRE				= 2;
    private final static int CMD_FIRE				= 3;
    private final static int CMD_UPDATE_SOLDIER		= 4;
    private final static int CMD_UPDATE_TEAM		= 5;
    private final static int CMD_BEST_SOLDIER		= 6;

    private final static UserSolution usersolution = new UserSolution();

    private static boolean run(BufferedReader br) throws Exception
    {
        StringTokenizer st;

        int numQuery;

        int mID, mTeam, mScore, mChangeScore;

        int userAns, ans;
        boolean isCorrect = false;

        numQuery = Integer.parseInt(br.readLine());

        for (int q = 0; q < numQuery; ++q)
        {
            st = new StringTokenizer(br.readLine(), " ");

            int cmd;
            cmd = Integer.parseInt(st.nextToken());

            switch(cmd)
            {
                case CMD_INIT:
                    usersolution.init();
                    isCorrect = true;
                    break;
                case CMD_HIRE:
                    mID = Integer.parseInt(st.nextToken());
                    mTeam = Integer.parseInt(st.nextToken());
                    mScore = Integer.parseInt(st.nextToken());
                    usersolution.hire(mID, mTeam, mScore);
                    break;
                case CMD_FIRE:
                    mID = Integer.parseInt(st.nextToken());
                    usersolution.fire(mID);
                    break;
                case CMD_UPDATE_SOLDIER:
                    mID = Integer.parseInt(st.nextToken());
                    mScore = Integer.parseInt(st.nextToken());
                    usersolution.updateSoldier(mID, mScore);
                    break;
                case CMD_UPDATE_TEAM:
                    mTeam = Integer.parseInt(st.nextToken());
                    mChangeScore = Integer.parseInt(st.nextToken());
                    usersolution.updateTeam(mTeam, mChangeScore);
                    break;
                case CMD_BEST_SOLDIER:
                    mTeam = Integer.parseInt(st.nextToken());
                    userAns = usersolution.bestSoldier(mTeam);
                    ans = Integer.parseInt(st.nextToken());
                    if (userAns != ans) {
                        isCorrect = false;
                    }
                    break;
                default:
                    isCorrect = false;
                    break;
            }
        }

        return isCorrect;
    }

    public static void main(String[] args) throws Exception
    {
        int TC, MARK;

        //System.setIn(new java.io.FileInputStream("res/sample_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        TC = Integer.parseInt(st.nextToken());
        MARK = Integer.parseInt(st.nextToken());

        for (int testcase = 1; testcase <= TC; ++testcase)
        {
            int score = run(br) ? MARK : 0;
            System.out.println("#" + testcase + " " + score);
        }

        br.close();
    }
}

class UserSolution
{
    public class Node {
        int id;
        int v;
        Node next;

        Node() {};
        Node(int id, Node next) {
            this.id = id;
            this.next = next;
        }
        Node(int id, int v, Node next) {
            this.id = id;
            this.v = v;
            this.next = next;
        }
    }

    Node[] node = new Node[200055];
    int cnt = 0;
    int[] num = new int[100055]; // 고유번호가 index인 사람의 팀 번호 저장
    int[] ver = new int[100055]; // 고유번호가 index인 사람의 version 저장

    public Node getNewNode(int id, Node next) {
        Node newNode = node[cnt++];
        newNode.id = id;
        newNode.v = ++ver[id];
        newNode.next = next;
        return newNode;
    }

    public class Team {
        Node[] head = new Node[6];
        Node[] tail = new Node[6];
    }

    Team[] t = new Team[6];

    void init()
    {
        cnt = 0;
        for (int i = 0; i < 200055; i++) {
            if (node[i] == null) node[i] = new Node();
        }
        for (int i = 1; i < 6; i++) {     // i: Team 넘버
            t[i] = new Team();
            for (int j = 1; j < 6; j++) { // j: 평판 점수
                t[i].head[j] = t[i].tail[j] = getNewNode(0, null); // LinkedList의 dummy node 생성
            }
        }

        for (int i = 0; i < 100055; i++) {
            num[i] = 0;
            ver[i] = 0;
        }
    }

    void hire(int mID, int mTeam, int mScore)
    {
        // 1. Team LinkedList 마지막에 추가
        Node newNode = getNewNode(mID, null); // version까지 setting됨.
        t[mTeam].tail[mScore].next = newNode;
        t[mTeam].tail[mScore] = newNode;
        // 2. num 배열에 team 넘버 넣기
        num[mID] = mTeam;
    }

    void fire(int mID)
    {
        ver[mID] = -1;
    }

    void updateSoldier(int mID, int mScore)
    {
        hire(mID, num[mID], mScore);
    }

    void updateTeam(int mTeam, int mChangeScore)
    {
        if (mChangeScore > 0) {
            for (int i = 5; i >= 1; i--) { // i: 평판 점수
                int j = i + mChangeScore;
                j = j < 1 ? 1 : (j > 5 ? 5 : j);
                if (i == j) continue;

                if (t[mTeam].head[i].next == null) continue;
                t[mTeam].tail[j].next = t[mTeam].head[i].next;
                t[mTeam].tail[j] = t[mTeam].tail[i];
                t[mTeam].head[i].next = null;
                t[mTeam].tail[i] = t[mTeam].head[i];
            }
        }
        if (mChangeScore < 0) {
            for (int i = 1; i <= 5; i++) {
                int j = i + mChangeScore;
                j = j < 1 ? 1 : (j > 5 ? 5 : j);
                if (i == j) continue;

                if (t[mTeam].head[i].next == null) continue;
                t[mTeam].tail[j].next = t[mTeam].head[i].next;
                t[mTeam].tail[j] = t[mTeam].tail[i];
                t[mTeam].head[i].next = null;
                t[mTeam].tail[i] = t[mTeam].head[i];
            }
        }
    }

    int bestSoldier(int mTeam)
    {
        // mTeam인 병사들 중 평판 점수 5 ~ 1 순회
        for (int i = 5; i > 0; i--) {
            Node currNode = t[mTeam].head[i].next;
            if (currNode == null) continue;

            int ans = 0;
            while (currNode != null) {
                // 1. 가장 큰 병사의 고유번호(mID) 찾기
                if (currNode.v == ver[currNode.id]) { // 만약 유효한 버전이면
                    ans = Math.max(ans, currNode.id);
                }

                // 3. currNode를 다음 연결 노드로 reset
                currNode = currNode.next;
            }

            if (ans != 0) return ans;
        }
        return 0;
    }
}

