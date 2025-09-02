// Given an array of jobs where every job has a deadline and associated profit if the job is finished before the deadline. It is also given that every job takes a single unit of time, so the minimum possible deadline for any job is 1. Maximize the total profit if only one job can be scheduled at a time.

// Input Format

// 4
// 4 20
// 1 10
// 1 40
// 1 30

// Output Format

// 60

// Sample Input 0

// 4
// 4 20   
// 1 10
// 1 40  
// 1 30
// Sample Output 0

// 60












import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); 
        
        ArrayList<int[]> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int deadline = sc.nextInt();
            int profit = sc.nextInt();
            jobs.add(new int[]{deadline, profit});  
        }

        jobs.sort((a,b)->b[1]-a[1]);
        int max=0;
        for (int[] job : jobs) {
            if (job[0] > max) {
                max = job[0];
            }
        }
        boolean[] slots = new boolean[max + 1];
        int totalProfit = 0;

        
        for (int[] job : jobs) {
            int deadline = job[0];
            int profit = job[1];

            
            for (int t = deadline; t >= 1; t--) {
                if (!slots[t]) {  
                    slots[t] = true;
                    totalProfit += profit;
                    break;  
                }
            }
        }
        System.out.print(totalProfit);
        sc.close();
        
    }  
        
}
