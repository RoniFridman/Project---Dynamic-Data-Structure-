public class GraphEdge {
    public GraphNode from;
    public GraphNode to;
    public Element<GraphEdge> elemTo;
    public Element<GraphEdge> elemFrom;

    GraphEdge(GraphNode from, GraphNode to){
        this.from = from;
        this.to = to;
        this.elemTo = null;
        this.elemFrom = null;
    }
}
