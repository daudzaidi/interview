package Hackerrank.CrackingTheCodingInterview;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ShortestreachBFS {

    public static class Edge{
        int source;
        int dest;
        int weight;
        public Edge(int u, int v){
            this.source = u ;
            this.dest = v;
            this.weight = 6;
        }

    }

    public static class Graph {

        int size;
        List<Integer> nodes;
        List<Edge> edges;
        public Graph(int size) {
            this.size = size;
            this.nodes = new ArrayList<Integer>();
            this.edges = new ArrayList<Edge>();
            for(int i = 1 ; i<= size ; i++){
                nodes.add(i);
            }
        }

        public void addEdge(int first, int second) {

            Edge edge = new Edge (first+1,second+1);
            edges.add(edge);
        }

        public int[] shortestReach(int startId) { // 0 indexed
            startId++;
            //int index = nodes.indexOf(startId);
            int[] distance = new int[this.size -1];
            int counter = 0 ;
            for(int i = 1 ; i <= nodes.size() ; i++){
                if(i == startId)
                    continue;

                int dist = getDistance (startId,i);
                distance[counter++] = dist;
            }
            return distance;
        }

        public int getDistance(int source, int dest){
            int dist = isEdgePresent(source, dest);
            if(dist != -1){
                return dist;
            }
            //Try to find indirect path if exists
            int[] visitied = new int[this.size+1];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(source);
            visitied[source]=1;

            queue.add(null);

            //int lenMin = Integer.MAX_VALUE;
            int len = 0;
            while(!queue.isEmpty()){
                Integer get = queue.poll();
                if(get == null && !queue.isEmpty()){

                    get = queue.poll();
                    len++;
                    if(get == dest){
                        break;
                    }
                }
                if(get == null && queue.isEmpty()){
                    break;
                }


                boolean addNull = false;
                for(int i = 1 ; i<=nodes.size() ; i++){
                    if(i == get || visitied[i] ==1)
                        continue;
                    int d = isEdgePresent(get,i);
                   /* if(d!=-1 && i == source){
                        len++;
                        return len*6;
                    }*/
                    if(d!=-1){
                        queue.add(i);
                        addNull = true;
                    }
                }
                if(addNull)
                    queue.add(null);
                /*if(lenMin > len && len!=0)
                    lenMin = len;*/
                visitied[get] = 1;
            }
            return (len == 0) ? -1 : (len)*6;
        }

        private int isEdgePresent(int source, int dest){
            for(int i = 0 ; i < edges.size(); i++){
                if((edges.get(i).source == source && edges.get(i).dest == dest) || (edges.get(i).source == dest && edges.get(i).dest == source) ){
                    return edges.get(i).weight;
                }
            }
            return -1;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int queries = scanner.nextInt();

        for (int t = 0; t < queries; t++) {

            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();

            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;

                // add each edge to the graph
                graph.addEdge(u, v);
            }

            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);

            for (int i = 0; i < distances.length; i++) {
                //if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                //}
            }
            System.out.println();
        }

        scanner.close();
    }
}
