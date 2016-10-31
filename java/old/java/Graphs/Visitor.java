package old.java.Graphs;

/**
 * Created by pandita on 9/9/2015.
 */
interface Visitor<T> {
    /**
     * Called by the graph traversal methods when a vertex is first visited.
     *
     * @param g -
     *          the graph
     * @param v -
     *          the vertex being visited.
     */
    public void visit(Graph<T> g, Vertex<T> v);
}