/*
package Amazon.Telephonic;

import java.util.*;

public class NKVersion {

    public static void main(String... args) {
        System.out.println("Minimum number of steps required for converting 1033 to 3739 are = "
                + getMinSteps(1033, 3739));
    }

    public static int getMinSteps(int a, int b) {
        if (a == b)
            return 0;

        List<Integer> primes = new ArrayList<>();

        // get all the 4 digit prime numbers
        primes = getPrimeNumbers();

        // consists of graph with vertices as all the prime numbers
        Graph graph = addNumbersToGraph(primes);

        // adding edges to the graph vertices
        Graph finalGraph = addWeightToGraph(graph);

        // min number of steps required
        int result = findShortestRoute(finalGraph.getVertex(a), finalGraph.getVertex(b));

        return result;
    }

    // Target simplicity, Refer https://www.youtube.com/watch?v=DiVh8MxP9OY
    private static int findShortestRoute(Vertex source, Vertex dest) {
        if (source.getVertexValue() == dest.getVertexValue())
            return 0;

        // step 1 Initialize the queue. Also Map to store path
        Queue<Vertex> visitedQueue = new LinkedList<>();
        Map<Vertex, Vertex> currentPrevMap = new HashMap<Vertex, Vertex>();

        // step 2 start from visiting S (starting node), and mark it visited, add to queue
        Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
        visited.put(source.getVertexValue(), true);
        visitedQueue.add(source);

        int level = 0;
        // step 3 Repeat until queue is empty
        while (!visitedQueue.isEmpty()) {
            // step 4 remove from queue
            Vertex current = visitedQueue.remove();
            if (current.getVertexValue() == dest.getVertexValue()) {
                printPath(source, dest, currentPrevMap);
                return level;
            } else if (current.getAdjacentVertices().size() > 0) {
                level++;
            }
            // step 5 add each of the unvisited neighbour and mark visited
            for (Vertex adjacentVertex : current.getAdjacentVertices()) {
                Integer value = adjacentVertex.getVertexValue();
                if (value == dest.getVertexValue()) {
                    currentPrevMap.put(adjacentVertex, current);
                    printPath(source, dest, currentPrevMap);
                    return level;
                }
                if (visited.get(value) == null) {
                    currentPrevMap.put(adjacentVertex, current);
                    // mark visited and enqueue it
                    visited.put(value, true);
                    visitedQueue.add(adjacentVertex);
                }
            }
        }
        // not found
        System.out.println("Dest vertex not found");
        return -1;
    }

    private static void printPath(Vertex source, Vertex dest, Map<Vertex, Vertex> currentPrevMap) {
        Vertex node = dest;
        System.out.println("Reverse Path from source: " + source.getVertexValue() + " to dest: "
                + dest.getVertexValue());
        while (node != source) {
            System.out.println(node.getVertexValue());
            node = currentPrevMap.get(node);
        }
        System.out.println(source.getVertexValue());
    }

    private static Graph addWeightToGraph(Graph graph) {
        List<Vertex> vertices = graph.getAllVertices();
        for (Vertex i : vertices) {
            for (Vertex j : vertices) {
                if (i.equals(j))
                    continue;

                if (distance(i, j) == 1) {
                    i.getAdjacentVertices().add(j);
                    // i.addEdge(new Edge(i, j, 1));
                }
            }
        }
        return graph;
    }

    private static int distance(Vertex source, Vertex dest) {
        if (source.getVertexValue() == dest.getVertexValue()) {
            return 0;
        }

        char[] numA = extractIntegers(source.getVertexValue());
        char[] numB = extractIntegers(dest.getVertexValue());

        int len1 = numA.length;

        int tracker = 0;

        for (int i = 0; i < len1; i++) {

            if (numA[i] != numB[i]) {
                numA[i] = numB[i];
                tracker++;
                String sA = String.copyValueOf(numA);
                String sB = String.copyValueOf(numB);
                // if we have reached destination
                if (Integer.parseInt(sA) == Integer.parseInt(sB)) {
                    return tracker;
                }
            }

        }
        return tracker;
    }

    private static char[] extractIntegers(int i) {
        char[] arr = Integer.toString(i).toCharArray();
        return arr;
    }

    private static Graph addNumbersToGraph(List<Integer> primes) {
        Graph g = new Graph();
        for (Integer prime : primes) {
            g.addVertex(new Vertex(prime));
        }
        return g;
    }

    private static List<Integer> getPrimeNumbers() {
        List<Integer> fourDigitPrimes = new ArrayList<>();
        fourDigitPrimes.add(1033);
        fourDigitPrimes.add(1733);
        fourDigitPrimes.add(3733);
        fourDigitPrimes.add(3739);

        // for (int i = 1000; i < 9999; i++) {
        // if (isPrime(i))
        // fourDigitPrimes.add(i);
        // }

        return fourDigitPrimes;
    }

    private static boolean isPrime(int i) {

        for (int k = 2; k < Math.sqrt(i); k++) {
            if (i % k == 0)
                return false;
        }

        return true;
    }
}


class Graph {
    public List<Vertex> vertexList = new ArrayList<Vertex>();

    public void addVertex(Vertex V) {
        vertexList.add(V);
    }


    public List getAllAdjacentNodes(Vertex V) {
        return V.getAdjacentVertices();
    }

    public List getAllVertices() {
        return vertexList;
    }

    public Vertex getVertex(int val) {
        Iterator<Vertex> keys = vertexList.iterator();
        while (keys.hasNext()) {
            Vertex v = keys.next();
            if (v.getVertexValue() == val)
                return v;
        }
        return null;
    }
}


class Vertex {
    int value;
    private List<Vertex> adjacentVertices = new ArrayList<Vertex>();

    public Vertex(int v) {
        this.value = v;
    }

    public List<Vertex> getAdjacentVertices() {
        return adjacentVertices;
    }


    public int getVertexValue() {
        return value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Vertex vertex = (Vertex) o;

        return value == vertex.value;

    }

    @Override
    public int hashCode() {
        return value;
    }
}
*/
