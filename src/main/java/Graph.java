import java.util.NoSuchElementException;
import java.util.Set;

/**
 * An undirected and unweighted graph. A graph is defined by a set of vertices V and a set of edges E. A single
 * vertex is some arbitrary element often represented as a "node" and an edge is a pair of vertices from the set V
 * indicating some relationship between the vertices. Nodes are considered "neighbours" if they have an edge between
 * them. Consider the below example:
 * <p>
 * a - b - d
 * \ /
 * c
 * <p>
 * V = {a, b, c, d}
 * E = {(a, b), (a, c), (b, c), (b, d)}
 *
 * @param <T> The "node" objects
 */
public interface Graph<T> {

    /**
     * Adds the specified node to the graph. If the node already exists, the graph remains unchanged.
     *
     * @param node The node to be added to the graph
     * @return True if the node was added successfully, false otherwise
     */
    boolean addNode(T node);

    /**
     * Removes the specified node from the graph. All edges incident on the node are also removed.
     *
     * @param node The node to be removed from the graph
     * @return True if the node was removed successfully
     */
    boolean removeNode(T node);

    /**
     * Return a set of all the nodes within the graph.
     *
     * @return A set of the nodes within the graph
     */
    Set<T> getNodes();

    /**
     * Return a set of all the neighbouring nodes of the specified node.
     *
     * @param node The node to get the neighbours of
     * @return A set of the neighbouring nodes adjacent to the specified node
     * @throws NoSuchElementException If the specified node does not exist within the graph
     */
    Set<T> getNeighbours(T node);

    /**
     * Return a set of all the edges (Edge objects) within the graph.
     *
     * @return A set of the edges within the graph
     */
    Set<Edge<T>> getEdges();

    /**
     * Adds the specified edge to the graph between existing nodes. If the edge already exists, the graph remains
     * unchanged. If the graph is undirected, the edge will be added in both directions.
     *
     * @param edge The edge to be added to the graph
     * @return True if the edge was added, false otherwise
     * @throws IllegalArgumentException If the edge connects nonexistent nodes within the graph
     */
    boolean addEdge(Edge<T> edge);

    /**
     * Removes the specified edge from the graph. If the graph is undirected, the edge will be removed in both
     * directions.
     *
     * @param edge The edge to be removed from the graph
     * @return True if the edge was removed successfully
     */
    boolean removeEdge(Edge<T> edge);

    /**
     * Return a set of all the edges (Edge objects) incident on the specified node.
     *
     * @param node The node to get the edges of
     * @return A set of the edges incident on the specified node
     * @throws NoSuchElementException If the specified node does not exist within the graph
     */
    Set<Edge<T>> getEdges(T node);

    /**
     * Return the degree of the specified node. The degree is the number of edges the node has. If the specified node
     * has an edge to itself, that edge is counted twice.
     *
     * @param node The node to get the degree of
     * @return The degree of the specified node
     * @throws NoSuchElementException If the specified node does not exist within the graph
     */
    int getDegree(T node);
}
