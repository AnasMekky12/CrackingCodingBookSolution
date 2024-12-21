package TreesAndGraph;

import java.util.*;

public class Q7 {

    public static void main(String[] args) {
        String[] projects = {"a", "b", "c", "d", "e", "f"};
        String[][] dependencies = {
                {"a", "d"},
                {"f", "b"},
                {"b", "d"},
                {"f", "a"},
                {"d", "c"}
        };

        List<String> result = findBuildOrder(projects, dependencies);

        if (result == null) {
            System.out.println("Error: No valid build order (cycle detected)");
        } else {
            System.out.println("Build Order: " + String.join(", ", result));
        }
    }

    public static List<String> findBuildOrder(String[] projects, String[][] dependencies) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> incomingEdges = new HashMap<>();

        for (String project : projects) {
            graph.put(project, new ArrayList<>());
            incomingEdges.put(project, 0);
        }

        for (String[] dependency : dependencies) {
            String parent = dependency[0];
            String child = dependency[1];
            graph.get(parent).add(child);
            incomingEdges.put(child, incomingEdges.get(child) + 1);
        }

        Queue<String> noIncoming = new LinkedList<>();
        for (String project : projects) {
            if (incomingEdges.get(project) == 0) {
                noIncoming.add(project);
            }
        }

        List<String> buildOrder = new ArrayList<>();

        while (!noIncoming.isEmpty()) {
            String current = noIncoming.poll();
            buildOrder.add(current);

            for (String child : graph.get(current)) {
                incomingEdges.put(child, incomingEdges.get(child) - 1);
                if (incomingEdges.get(child) == 0) {
                    noIncoming.add(child);
                }
            }
        }

        if (buildOrder.size() != projects.length) {
            return null;
        }

        return buildOrder;
    }
}