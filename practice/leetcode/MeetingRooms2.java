package practice.leetcode;

/*
Question
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example, Given [[0, 30],[5, 10],[15, 20]], return 2.
*/

import java.util.Arrays;
import java.util.PriorityQueue;

class MeetingRooms2 {

    //Approach:
    //We can pair up meetings in such a manner so that least ocnflicts occur.
    //Meetings overlapping will require a new conference room
            /*
        Min Heap to address ending times of the meeting (earliest ending meetings)
        delete ended meetings from heap and add to the heap*/

    public int solve(int[][] meetings) {

        //Sort the array based on starting times
        //Create a min heap based on earliest ending times

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        //Add the first meeting
        minHeap.add(meetings[0]);
        int rooms = 1;

        for (int i = 1; i < meetings.length; i++) {
            int currStart = meetings[i][0];

            //If current meeting starts before the earlier ends then we will increase the room count
            if (currStart < minHeap.peek()[1]) {
                rooms++;
            }
            //If the current meeting start time is after the previous meeting has ended, use the same room
            else {
                minHeap.poll();
            }
            minHeap.add(meetings[i]);
        }
        return rooms;
    }

    public static void main() {
        MeetingRooms2 meetingRooms2 = new MeetingRooms2();

        int[][] meetings = {{0, 30}, {5, 10}, {15, 20}};

        int confRooms = meetingRooms2.solve(meetings);
        System.out.println(confRooms);
    }

}


