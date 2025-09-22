// Given an undirected and disconnected graph G(V, E), print its BFS traversal.
// Note:
// Here you need to consider that you need to print BFS path starting from vertex 0 only.
// V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
// E is the number of edges present in graph G.
// Take graph input in the adjacency matrix.
// Handle for Disconnected Graphs as well

// Input Format

// The first line of input contains two integers, that denote the value of V and E.
// Each of the following E lines contains space separated two integers, that denote that there exists an edge between vertex a and b.

// Constraints

// 0 <= V <= 1000
// 0 <= E <= (V * (V - 1)) / 2
// 0 <= a <= V - 1
// 0 <= b <= V - 1
// Time Limit: 1 second

// Output Format

// Print the BFS Traversal, as described in the task.

// Sample Input 0

// 4 4
// 0 1
// 0 3
// 1 2
// 2 3
// Sample Output 0

// 0 1 3 2



import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void bfs (ArrayList<ArrayList<Integer>> adj,int s,int v){
        boolean[] visit=new boolean[v];
        Queue<Integer> q=new LinkedList<>();
        visit[s]=true;
        q.add(s);
        while(!q.isEmpty()){
            int curr=q.poll();
            System.out.print(curr+" ");
            for(int neigh:adj.get(curr)){
                if(!visit[neigh]){
                    visit[neigh]=true;
                    q.add(neigh);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<Integer>());
        }
        for (int i=0;i<e;i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a); 
        }
        if(v>0){
            bfs(adj,0,v);
        }
    }
}
