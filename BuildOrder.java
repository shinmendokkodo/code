/*
Problem Description
You are given a list of projects and a list of dependencies, which is a list of pairs of projects, where the second project is dependent on the first project. All of a project's dependencies must be built before the project is.

Find a build order that will allow the projects to be built according to their dependencies. If there is no valid build order, print -1.

Input format
First line contains two space separated integers N and D, where N is the number of projects and D is the number of dependencies, respectively.

Second line contains N space separated strings which are the names of the N projects.

Next D lines contain two space separated strings P and Q, which says project Q depends on project P (P and Q will be among the project names specified on the second line).

Output format
Print the space separated project names in the order they should be built.

If there are multiple such orders possible, you can print any one of them.

If there is no possible way to build, print -1.

Constraints
N <= 500

1 <= D <= min(N*(N-1)/2,100000)

1 <= Project name string length <= 10

Sample Input 1
5 3

A xy a c b

a xy

b A

xy c

Sample Output 1
a b xy A c

Explanation 1
In this example, there are 3 dependencies. The projects can be built in any order satisfying these 3 dependencies i.e. a should be built before xy, b should be built before A, and xy should be built before c.

The order "a b xy A c" is one such order.
*/

import java.util.*;

public class BuildOrder {

    static Map<String, ArrayList<String>> map = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sc.nextInt();
        int d = sc.nextInt();

        sc.nextLine();
        ArrayList<String> project = new ArrayList<>();
        for (String val : sc.nextLine().split(" ")) {
            // System.out.print(val+" ");
            project.add(val);
        }

        ArrayList<ArrayList<String>> dependencies = new ArrayList<>();
        for (int i = 0; i < d; i++) {
            ArrayList<String> dependency = new ArrayList<>();
            for (String dep : sc.nextLine().split(" ")) {
                dependency.add(dep);
            }
            dependencies.add(dependency);
        }
        ArrayList<String> ans = buildOrder(project, dependencies);

        for (String proj : ans) {
            System.out.print(proj + " ");
        }
        sc.close();
    }

    public static ArrayList<String> buildOrder(ArrayList<String> projects, ArrayList<ArrayList<String>> dependencies) {
        MakeAjdacencyList(dependencies, projects);

        Map<String, Integer> inDegreeMap = new HashMap<>();

        for (String project : projects) {
            inDegreeMap.put(project, 0);
        }

        for (Map.Entry<String, ArrayList<String>> m : map.entrySet()) {
            List<String> adjNodes = m.getValue();
            for (String adjNode : adjNodes) {
                inDegreeMap.put(adjNode, inDegreeMap.getOrDefault(adjNode, 0) + 1);
            }
        }

        Queue<String> q = new LinkedList<>();
        for (Map.Entry<String, Integer> m : inDegreeMap.entrySet()) {
            if (m.getValue() == 0) {
                q.add(m.getKey());
            }
        }
        int count = 0;

        ArrayList<String> topOrder = new ArrayList<>();
        while (!q.isEmpty()) {
            String node = q.poll();
            topOrder.add(node);
            ArrayList<String> adjNodes = map.get(node);
            for (String adjNode : adjNodes) {
                inDegreeMap.put(adjNode, inDegreeMap.get(adjNode) - 1);
                if (inDegreeMap.get(adjNode) == 0) {
                    q.add(adjNode);
                }
            }
            count++;
        }

        if (count != projects.size()) {
            return new ArrayList<String>(Arrays.asList("-1"));
        }

        return topOrder;
    }

    static void MakeAjdacencyList(ArrayList<ArrayList<String>> edges, ArrayList<String> nodes) {
        map = new HashMap<>();

        for (String node : nodes) {
            map.putIfAbsent(node, new ArrayList<>());
        }

        for (ArrayList<String> edge : edges) {
            map.get(edge.get(0)).add(edge.get(1));
        }
    }
}