/*
Problem Description
You are given a network of major and minor cities. The cities have bridges connecting them, with each bridge having a distance of 1. Major cities have police stations and fall under their own jurisdiction. Jurisdiction of a minor city falls under the nearest major city. Your task is to report the minimum distance between each city and it's nearest major city. Note: For a major city, this distance will be 0.

Note: All cities are connected, but maybe not directly.

Input format
First line will contain two space separated integers, N and B, representing the number of cities and the number of bridges between them, respectively.

Next B lines contain two space separated integers, X and Y, representing a bridge between city X and city Y. Cities are numbered from 1 to N.

Next line contains an integer S representing the number of major cities

Next line contains S space separated integers, representing major cities

Output format
N lines, each representing the (i)th city, with the minimum distance of the (i)th city from its nearly major city.

Constraints
1 <= N <= 100000

N-1 <= B <= 100000

1 <= S <= 100000

Sample Input 1
3 2

1 2

2 3

1

2

Sample Output 1
1

0

1

Explanation 1
The second city is a major city and falls under its own jurisdiction. 
The first and third cities are connected to the second city and their distance is 1.

Sample Input 2
4 5

1 2

2 3

3 4

4 2

1 3

2

1 4

Sample Output 2
0

1

1

0

Explanation 2
The first and fourth cities are major cities and fall under their own jurisdiction. 
The second and third cities are connected to the first (or to fourth city also) and their distance is 1.
*/

import java.util.*;

public class TownsAndPoliceStations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < m; i++) {
            edges.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = sc.nextInt();
            y = sc.nextInt();
            edges.get(i).add(x);
            edges.get(i).add(y);
        }
        int s = sc.nextInt();
        ArrayList<Integer> sources = new ArrayList<>();
        for (int i = 0; i < s; i++) {
            sources.add(sc.nextInt());
        }
        ArrayList<Integer> ans = TownsAndPoliceStations.townsAndPoliceStations(n, edges, sources);
        for (int distance : ans) {
            System.out.println(distance + " ");
        }
        sc.close();
    }

    public static ArrayList<Integer> townsAndPoliceStations(int n, ArrayList<ArrayList<Integer>> edges,
            ArrayList<Integer> sources) {
        ArrayList<ArrayList<Integer>> graph = buildGraph(edges, n);
        Queue<Integer> queue = new LinkedList<>();

        int[] distance = new int[n];

        for (int i = 0; i < n; i++) {
            distance[i] = -1;
        }

        for (int source : sources) {
            distance[source - 1] = 0;
            queue.add(source - 1);
        }

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            List<Integer> adjNodes = graph.get(node);
            for (Integer adjNode : adjNodes) {
                if (distance[adjNode] == -1) {
                    distance[adjNode] = distance[node] + 1;
                    queue.add(adjNode);
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int d : distance) {
            result.add(d);
        }

        return result;
    }

    private static ArrayList<ArrayList<Integer>> buildGraph(ArrayList<ArrayList<Integer>> edges, int nodes) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
        }

        for (ArrayList<Integer> edge : edges) {
            graph.get(edge.get(0) - 1).add(edge.get(1) - 1);
            graph.get(edge.get(1) - 1).add(edge.get(0) - 1);
        }

        return graph;
    }
}