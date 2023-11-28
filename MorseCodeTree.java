import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
    protected TreeNode<String> root;

    /**
     * Initializes the MorseCodeTree by creating an empty root and building the tree structure.
     */
    public MorseCodeTree() {
        root = new TreeNode<String>("");
        buildTree();
    }

    
    /**
     * Retrieves a reference to the root.
     *
     * @return Reference to the root.
     */
    @Override
    public TreeNode<String> getRoot() {
        return root;
    }

    /**
     * Sets the root of the Tree.
     *
     * @param newNode A TreeNode<T> that will be the new root.
     */
    @Override
    public void setRoot(TreeNode<String> newNode) {
        this.root = newNode;
    }

    /**
     *
     * @param code   The code for the new node to be added.
     * @param result The data of the new TreeNode to be added.
     */
    @Override
    public void insert(String code, String result) {
        addNode(root, code, result);
    }

    
    
    /**
     * Recursive method that adds an element to the correct position in the tree based on the code.
     *
     * @param root   The root of the tree for this particular recursive instance of addNode.
     * @param code   The code for this particular recursive instance of addNode.
     * @param letter The data of the new TreeNode to be added.
     */
    @Override
    public void addNode(TreeNode<String> root, String code, String letter) {
        if (code.isEmpty()) {
            return; // Invalid code, do nothing
        }

        char firstChar = code.charAt(0);

        if (code.length() == 1) {
            if (firstChar == '.') {
                root.left = new TreeNode<String>(letter);
            } else if (firstChar == '-') {
                root.right = new TreeNode<String>(letter);
            }
        } else {
            TreeNode<String> childNode;
            if (firstChar == '.') {
                if (root.left == null) {
                    root.left = new TreeNode<String>("");
                }
                childNode = root.left;
            } else if (firstChar == '-') {
                if (root.right == null) {
                    root.right = new TreeNode<String>("");
                }
                childNode = root.right;
            } else {
                return; // Invalid character, do nothing
            }

            addNode(childNode, code.substring(1), letter);
        }
    }

    /**
     * Fetches the data in the tree based on the code.
     * This method will call the recursive method fetchNode.
     *
     * @param code The code that describes the traversals within the tree.
     * @return The result that corresponds to the code.
     */
    @Override
    public String fetch(String code) {
        return fetchNode(root, code);
    }

    /**
     * Recursive method that fetches the data of the TreeNode that corresponds with the code.
     *
     * @param root The root of the tree for this particular recursive instance of addNode.
     * @param code The code for this particular recursive instance of fetchNode.
     * @return The data corresponding to the code.
     */
    @Override
    public String fetchNode(TreeNode<String> root, String code) {
        TreeNode<String> currentNode = root;
        String result = "";
        for (char c : code.toCharArray()) {
            if (c == '.') {
                currentNode = currentNode.left;
            } else if (c == '-') {
                currentNode = currentNode.right;
            }
            if (currentNode == null) {
                break; // Invalid code, return an empty string or handle appropriately
            }
        }
        
        
        if (currentNode != null) {
            result = currentNode.getData();
        }
        return result;
    }

    
    /**
     * This operation is not supported for a LinkedConverterTree.
     *
     * @param data Data of the node to be deleted.
     * @return Reference to the current tree.
     * @throws UnsupportedOperationException UnsupportedOperationException
     */
    @Override
    public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Delete operation is not supported in MorseCodeTree.");
    }

    /**
     * This operation is not supported for a LinkedConverterTree.
     *
     * @return Reference to the current tree.
     * @throws UnsupportedOperationException UnsupportedOperationException
     */
    @Override
    public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Update operation is not supported in MorseCodeTree.");
    }

    /**
     * Builds the LinkedConverterTree by inserting TreeNodes<T> into their proper locations.
     */
    @Override
    public void buildTree() {
        insert(".", "e"); insert("-", "t"); insert("..", "i"); insert(".-", "a"); insert("-.", "n");
        insert("--", "m"); insert("...", "s"); insert("..-", "u"); insert(".-.", "r");
        insert(".--", "w"); insert("-..", "d"); insert("-.-", "k"); insert("--.", "g");
        insert("---", "o"); insert("....", "h"); insert("...-", "v"); insert("..-.", "f");
        insert(".-..", "l"); insert(".--.", "p"); insert(".---", "j"); insert("-...", "b");
        insert("-..-", "x"); insert("-.-.", "c"); insert("-.--", "y"); insert("--..", "z"); insert("--.-", "q");
    }

    /**
     *
     * @return An ArrayList of the items in the linked Tree.
     */
    @Override
    public ArrayList<String> toArrayList() {
        ArrayList<String> result = new ArrayList<>();
        LNRoutputTraversal(root, result);
        return result;
    }

    /**
     *
     * @param root The root of the tree for this particular recursive instance.
     * @param list The ArrayList that will hold the contents of the tree in LNR order.
     */
    @Override
    public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            LNRoutputTraversal(root.left, list);
        }

        list.add(root.getData());

        if (root.right != null) {
            LNRoutputTraversal(root.right, list);
        }
    }
}
