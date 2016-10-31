package Amazon.Tagged;

import TusharRoyVideos.Graph.Graph;
import TusharRoyVideos.Graph.Vertex;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by shyamsunderpandita on 25/10/16.
 */
public class TopologicalSorting {

    public Deque<Integer> sort(Graph<Integer> graph){
        Set<Vertex<Integer>> visited = new HashSet<>();
        Deque<Integer> sorted = new ArrayDeque<>();
        for(Vertex<Integer> vertex: graph.getAllVertex()){
            if(visited.contains(vertex))
                continue;
            topologicalSort(vertex,sorted,visited);
        }
        return sorted;
    }

    private void topologicalSort(Vertex<Integer> vertex, Deque<Integer> sorted, Set<Vertex<Integer>> visited) {
        visited.add(vertex);
        for(Vertex v : vertex.getAdjacentVertexes()){
            if(visited.contains(v))
                continue;
            topologicalSort(v,sorted,visited);
        }
        sorted.push((int)vertex.getId());
    }

    public static void main(String... args){
        System.out.println("SET 1");
        Graph<Integer> graph = new Graph<>(true);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 1);
        graph.addEdge(4, 0);
        graph.addEdge(2, 3);
        graph.addEdge(1, 3);

        TopologicalSorting sorting = new TopologicalSorting();
        Deque<Integer> result = sorting.sort(graph);

        while(!result.isEmpty()){
            System.out.println(result.pop());
        }

        System.out.println("SET 2");
        Graph<Integer> graph2 = new Graph<>(true);
        graph2.addEdge(1, 3);
        graph2.addEdge(2, 3);
        graph2.addEdge(3, 5);
        graph2.addEdge(5, 8);
        graph2.addEdge(5, 6);
        graph2.addEdge(2, 4);
        graph2.addEdge(4, 6);
        graph2.addEdge(6, 7);

        Deque<Integer> result2 = sorting.sort(graph2);

        while(!result2.isEmpty()){
            System.out.println(result2.pop());
        }
    }
}
