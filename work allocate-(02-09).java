// Given an array of jobs where every job has a deadline and associated profit if the job is finished before the deadline. It is also given that every job takes a single unit of time, so the minimum possible deadline for any job is 1. Maximize the total profit if only one job can be scheduled at a time.

// Input Format

// a 4 20

// b 1 10

// c 1 40

// d 1 30

// Output Format

// c a

// Sample Input 0

// a 2 100
// b 1 19
// c 2 27
// d 1 25
// e 3 15
// Sample Output 0

// c a e
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);

        ArrayList<String[]> jobs = new ArrayList<>();

        // Read all input
        while (sc.hasNext()) {
            String name = sc.next();
            int deadline = sc.nextInt();
            int profit = sc.nextInt();
            jobs.add(new String[] { name, String.valueOf(deadline), String.valueOf(profit) });
        }

        jobs.sort((a, b) -> Integer.parseInt(b[2]) - Integer.parseInt(a[2]));

        int maxDeadline = 0;
        for (String[] job : jobs) {
            maxDeadline = Math.max(maxDeadline, Integer.parseInt(job[1]));
        }
        String[] schedule = new String[maxDeadline + 1];
        boolean[] occupied = new boolean[maxDeadline + 1];
 
        for (String[] job : jobs) {
            String name = job[0];
            int deadline = Integer.parseInt(job[1]);

            for (int t = deadline; t >= 1; t--) {
                if (!occupied[t]) {
                    occupied[t] = true;
                    schedule[t] = name;
                    break;
                }
            }
        }

        List<String> result = new ArrayList<>();
        for (int t = 1; t <= maxDeadline; t++) {
            if (occupied[t]) {
                result.add(schedule[t]);
            }
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i < result.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
        sc.close();
    }
}      


