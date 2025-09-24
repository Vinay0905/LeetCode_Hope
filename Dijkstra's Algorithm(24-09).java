// Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges. Find and print the shortest distance from the source vertex (i.e. Vertex 0) to all other vertices (including source vertex also) using Dijkstra's Algorithm.

// Input Format

// Line 1: Two Integers V and E (separated by space) Next E lines : Three integers ei, ej and wi, denoting that there exists an edge between vertex ei and vertex ej with weight wi (separated by space)

// Constraints

// 2 <= V, E <= 10^5 Time Limit: 1 sec

// Output Format

// For each vertex, print its vertex number and its distance from source, in a separate line. The vertex number and its distance needs to be separated by a single space.

// Sample Input 0

// 4 4
// 0 1 3
// 0 3 5
// 1 2 1
// 2 3 8
// Sample Output 0

// 0 0
// 1 3
// 2 4
// 3 5
// Sample Input 1

// 3 3
// 1 2 6
// 2 0 2
// 1 0 2
// Sample Output 1

// 0 0
// 1 2
// 2 2



import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    static int min(int[] dis,boolean[] vis, int v){
        int m_v=Integer.MAX_VALUE;
        int m_index=-1;
        for(int i=0;i<v;i++){
            if(dis[i]<m_v && vis[i]==false){
                m_v=dis[i];
                m_index=i;
            }
        }
        return m_index;
    }
    
    
    static void dij(int[][] g , int v){
        int[] dis=new int[v];
        boolean vis[]=new boolean[v];
        
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[0]=0;
        for(int i=0;i<v-1;i++){
            int sv=min(dis,vis,v);
            if(sv==-1)break;
            vis[sv]=true;
            for (int ev = 0; ev < v; ev++) {
                if (!vis[ev] && g[sv][ev] != 0 && dis[sv] != Integer.MAX_VALUE
                    && dis[sv] + g[sv][ev] < dis[ev]) {
                    dis[ev] = dis[sv] + g[sv][ev];
                }
            }
        }
        for(int i=0;i<v;i++){
            System.out.println(i+ " " +dis[i]);
        }
        
    }
    
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();
        int E=sc.nextInt();
        int[][] g =new int[V][V];
        for(int i=0;i<E;i++){
            int sv=sc.nextInt();
            int ev=sc.nextInt();
            int w=sc.nextInt();
            g[sv][ev]=w;
            g[ev][sv]=w;
            
            
            
        }
        dij(g,V);
          
        
    }
}
