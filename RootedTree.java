import java.io.DataOutputStream;
import java.io.IOException;

public class RootedTree {
    public GraphNode root;
    public RootedTree(){
        this.root = null;
    }

    /**
     * Receives a rooted tree, and print all keys by layer.
     *
     * Explaination : We maintain a queue by adding a node, and then adding all children in the next level.
     * We mark the end of the level with an element called "end" and when we reach it, the function will print
     * a new line, and will continue the proccess for the next level.
     * @param out : OutputStream to be printed.
     * @throws IOException : if the DataOutputStream object cannot be written into, throws an exception.
     */
    public void printByLayer(DataOutputStream out) throws IOException {
        GraphNode node = this.root;
        LinkedList<GraphNode> queue = new LinkedList<>();
        node.elemAlgorithm = queue.add(node);
        Element<GraphNode> end = queue.first;
        while(end != null){
            Element<GraphNode> elem = queue.remove();
            out.writeBytes(String.valueOf(elem.obj.key));
            node = elem.obj;
            if(node.leftChild != null){
                GraphNode nextNode = node.leftChild;
                nextNode.elemAlgorithm = queue.add(nextNode);
                while(nextNode.rightSibling != null){
                    nextNode = nextNode.rightSibling;
                    nextNode.elemAlgorithm = queue.add(nextNode);
                }
            }
            /* C5heck if we reached the end of current layer */
            if(elem == end){
                end = queue.first;
                if(end != null) {
                    out.writeBytes("\n");
                }
            }
            else {
                out.writeBytes(",");
            }
        }
        out.flush();
    }

    /**
     * Reccursive function for the preorderPrint function.
     * @param node : the key of this node will be added to the string, in every itteration.
     * @param string : String object. we concatnate all characters to it. the final string will be
     *               inputed into the DataOutputStream object in the preorderPrint function.
     * @return string with a line of all the keys in "pre-order" order.
     */
    public String preOrderRec(GraphNode node, String string){
        string = string + node.getKey() + ",";
        if(node.leftChild != null){
            string = preOrderRec(node.leftChild, string);
        }
        if(node.rightSibling != null){
            string = preOrderRec(node.rightSibling, string);
            }
        return string;
    }

    /**
     * Create a string that will use the preOrderRec function to have all the correct inputs.
     * Change the string content to match the printing requirements and input it to the DataOutputStream object. 
     * @param out : the DataOutputStream to be printed.
     * @throws IOException : raises an exception if the can't write into the data stream.
     */
    public void preorderPrint(DataOutputStream out) throws IOException {
        GraphNode node = this.root;
        String string = ("");
        string = preOrderRec(node, string);
        string = string.substring(0, string.length() - 1);
        out.writeBytes(string);
        out.flush();
    }
}
