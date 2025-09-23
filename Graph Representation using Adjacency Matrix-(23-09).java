// **You are given a graph in terms of its number of vertices and edges. Your task is to construct its adjacency matrix representation.

// The graph can be directed or undirected, and each edge has a weight.e a program to implement a graph using an adjacency Matrix.**

// ** - first2 inputs are number of vertices and edges
// - Then graph is directed or un directed followed by edges.**

// image

// Input Format

// First line:
// An integer V — the number of vertices in the graph.
// Second line:
// An integer E — the number of edges.
// Third line:
// A string — "yes" if the graph is directed, "no" if the graph is undirected.
// Next E lines:
// Each line contains three integers: u v w, denoting an edge from node u to node v with weight w.

// 5
// 6
// no
// 0 1 1
// 1 4 1
// 2 4 1
// 0 2 1
// 3 4 1
// 0 3 1

// Constraints

// 1 ≤ V ≤ 100
// 0 ≤ E ≤ V*(V-1)
// 0 ≤ u, v < V
// 0 ≤ w ≤ 100
// The graph may have self-loops (i.e., u == v is allowed).

// Output Format

// Print the V x V adjacency matrix.
// Each row should contain V space-separated integers.
// If there is no edge between two vertices, the value should be 0.

// 0 1 1 1 0
// 1 0 0 0 1
// 1 0 0 0 1
// 1 0 0 0 1
// 0 1 1 1 0

// Sample Input 0

// 5
// 6
// no
// 0 1 1
// 1 4 1
// 2 4 1
// 0 2 1
// 3 4 1
// 0 3 1
// Sample Output 0

// 0 1 1 1 0
// 1 0 0 0 1
// 1 0 0 0 1
// 1 0 0 0 1
// 0 1 1 1 0
// Explanation 0

// The graph is undirected, so every edge u v w implies both matrix[u][v] = w and matrix[v][u] = w.

// The matrix represents edge weights; 0 means no edge.

// For instance, the edge 0 1 1 creates both matrix[0][1] = 1 and matrix[1][0] = 1.

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc= new Scanner(System.in);
        int V=sc.nextInt();
        int e=sc.nextInt();
        sc.nextLine();
        String graphType = sc.nextLine().trim();
        boolean isDirected = graphType.equals("yes");
        int[][] mat=new int[V][V];        
        for(int i=0;i<e;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            int w=sc.nextInt();
            mat[u][v]=w;
            if(!isDirected){
                mat[v][u]=w;
            }
        }
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(mat[i][j]);
                if (j < V - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        
        sc.close();
        
    }
}
