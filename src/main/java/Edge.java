/**
 * An edge for an undirected and unweighted graph. An edge connects two "node" objects. Each edge has two nodes: u and
 * v. The order of the elements u and v in the edge is arbitrary but consistent.
 *
 * @param <T> The "node" objects attached to the endpoints of the edge.
 */
public interface Edge<T> {

    /**
     * Return the u node of the edge.
     *
     * @return The u node
     */
    T getU();

    /**
     * Return the v node of the edge.
     *
     * @return The v node
     */
    T getV();
}
