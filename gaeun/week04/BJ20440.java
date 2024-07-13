package week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ20440 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numIntervals = Integer.parseInt(br.readLine());
        Map<Integer, Integer> eventMap = new HashMap<>();
        Map<Integer, Integer> activeIntervalsMap = new HashMap<>();
        StringTokenizer st;

        for (int i = 0; i < numIntervals; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            eventMap.put(start, eventMap.get(start) != null ? eventMap.get(start) + 1 : 1);
            eventMap.put(end, eventMap.get(end) != null ? eventMap.get(end) - 1 : -1);
        }

        ArrayList<Integer> eventPoints = new ArrayList<>(eventMap.keySet());
        Collections.sort(eventPoints);

        int currentActiveIntervals = 0;
        int maxActiveIntervals = 0;
        int maxStartTime = 0;
        int maxEndTime = 0;
        int maxStartIdx = 0;

        for (int i = 0; i < eventPoints.size(); i++) {
            int point = eventPoints.get(i);
            currentActiveIntervals += eventMap.get(point);
            activeIntervalsMap.put(point, currentActiveIntervals);

            if (maxActiveIntervals < currentActiveIntervals) {
                maxActiveIntervals = currentActiveIntervals;
                maxStartTime = point;
                maxStartIdx = i;
            }
        }

        while (true) {
            if (activeIntervalsMap.get(eventPoints.get(++maxStartIdx)) != maxActiveIntervals) {
                maxEndTime = eventPoints.get(maxStartIdx);
                break;
            }
        }

        System.out.println(maxActiveIntervals);
        System.out.println(maxStartTime + " " + maxEndTime);
    }
}

