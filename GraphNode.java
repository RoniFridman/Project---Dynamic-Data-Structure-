public class GraphNode {
    public int key;
    public GraphNode parent = null;
    public GraphNode leftChild;
    public GraphNode rightSibling;
    public LinkedList<GraphEdge> edgesIn;
    public LinkedList<GraphEdge> edgesOut;
    public Element<GraphNode> elemDG;
    public Element<GraphNode> elemAlgorithm;
    public String color;
    public int d;
    public int f;

    /**
     * a graph node constructor, gets a new key and initializes all featured attributes
     * @param key : key of node.
     */
    GraphNode(int key){
        this.key = key;
        this.leftChild = null;
        this.rightSibling = null;
        this.edgesIn = new LinkedList<>();
        this.edgesOut = new LinkedList<>();
        this.elemDG = null;
        this.elemAlgorithm = null;
        this.color = null;
        this.d = 0;
        this.f = 0;
    }

    /**
     * computes out degree of graph
     * @return  out degree number of graph
     */
    public int getOutDegree(){
        int outDegree = 0;
        Element<GraphEdge> elem = edgesOut.first;
        while(elem != null){
            outDegree++;
            elem = elem.next;
            }
        return outDegree;
    }

    /**
     * computes in degree of graph
     * @return in degree number of graph
     */
    public int getInDegree(){
        int InDegree = 0;
        Element<GraphEdge> elem = edgesIn.first;
        while(elem != null){
            InDegree++;
            elem = elem.next;
        }
        return InDegree;
    }

    /**
     * return node`s key
     * @return node key
     */
    public int getKey(){
        return this.key;
    }

    /**
     * adds new node into graph node, if node has no childern it adds the new child as the left child, else it adds it
     * as a right sibling.
     * @param child : the new node to be added
     */
    public void addChild(GraphNode child){
        if(this.leftChild == null){
            this.leftChild = child;
        }
        else {
            GraphNode node = this.leftChild;
            while (node.rightSibling != null) {
                node = node.rightSibling;
            }
            node.rightSibling = child;
        }
    }
    }
