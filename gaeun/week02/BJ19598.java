package week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ19598 {
    static int N;
    static List<Meeting> meetings;
    public static class Meeting implements Comparable<Meeting>{
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Meeting{" +
                    "start=" + start +
                    ", finish=" + end +
                    '}';
        }

        @Override
        public int compareTo(Meeting o) {
            return this.end - o.end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        meetings = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings.add(new Meeting(start, end));
        }

        Collections.sort(meetings);
        int prev_end = -1;
        int room = 1;
        for (Meeting meeting : meetings) {
            if (prev_end > meeting.start) {
                room++;
                continue;
            }
             prev_end = meeting.end;
        }
        System.out.println(room);
    }
}
