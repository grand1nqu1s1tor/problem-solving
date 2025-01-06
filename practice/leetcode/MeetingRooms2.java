package leetcode;
/*
Question
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
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

/*        int[][] meetings = new int[start.length][2];
        for(int i = 0; i < start.length; i++){
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }*/

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

        int prevEndTime = meetings[0][1];
        minHeap.offer(prevEndTime);

        //[1, 3], [4, 6] [5, 8]
        for(int i = 1; i < meetings.length; i++){
            //If the current meeting starts after the earliest ending meeting, Occupy THE SAME ROOM
            if(meetings[i][0] >= minHeap.peek()){
                minHeap.poll();
            }
            minHeap.offer(meetings[i][1]);
        }
        return minHeap.size();
    }

    public static void main(String args[]) {
        MeetingRooms2 meetingRooms2 = new MeetingRooms2();

        int[][] meetings = {{0, 30}, {5, 10}, {15, 20}};

        int confRooms = meetingRooms2.solve(meetings);
        System.out.println(confRooms);
    }

}


