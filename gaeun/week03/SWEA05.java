package week03;

//1. Node
//- 병사
//- field: id(고유번호), v(버전), nxt(연결리스트 next Node)
//2. Team
//- 소속팀
//- field: head(Node[6]), tail(Node[6])
//    - head: 각 팀별(1~5) 시작 노드. 맨 처음 노드는 id==0으로 동일.
//    - tail: 각 팀별(1~5) 마지막 노드. 추가할 때마다 update.

public class SWEA05 {

    public class Node {
        int id;
        int v;
        Node nxt;

        Node() {};

        Node(int id, int v) {
            this.id = id;
            this.v = v;
            this.nxt = null;
        }

        Node(int id, int v, Node nxt) {
            this.id = id;
            this.v = v;
            this.nxt = nxt;
        }
    }

    Node[] nodes = new Node[200002];
    int cnt = 0;
    int[] version = new int[100001]; // 버전
    int[] num = new int[100001];     // 팀 넘버

    public Node getNewNode(int id, Node nxt) {
        Node ret = nodes[cnt++];
        ret.id = id;
        ret.v = ++version[id];
        ret.nxt = nxt;
        return ret;
    }

    public class Team {
        Node[] heads = new Node[6];
        Node[] tails = new Node[6];
    }

    public Team[] t = new Team[6];

    void init()
    {
        for (int i = 0; i < 200002; i++) {
            if (nodes[i] != null) {
                nodes[i] = new Node(i, 0);
            }
        }

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                t[i].heads[j] = t[i].tails[j] = getNewNode(0, null);
            }
        }
    }

    void hire(int mID, int mTeam, int mScore)
    {
        Node node = getNewNode(mID, null);
        // 1. 팀 넘버 set
        t[mTeam].tails[mScore].nxt = node;

        // 2. Team에 추가

    }

    void fire(int mID)
    {
    }

    void updateSoldier(int mID, int mScore)
    {
    }

    void updateTeam(int mTeam, int mChangeScore)
    {
    }

    int bestSoldier(int mTeam)
    {
        return 0;
    }
}

