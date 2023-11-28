public class TreeNode<T> {
    protected TreeNode<T> left;
    protected TreeNode<T> right;
    private T data;

    /**
     * Creates a new TreeNode with left and right child set to null and data set to the specified dataNode.
     *
     * @param dataNode the data to be stored in the TreeNode
     */
    public TreeNode(T dataNode) {
        this.left = null;
        this.right = null;
        this.data = dataNode;
    }

    /**
     * Creates a new TreeNode by making a deep copy of the provided node.
     *
     * @param node the TreeNode to make a copy of
     */
    public TreeNode(TreeNode<T> node) {
        this.left = node.left;
        this.right = node.right;
        this.data = node.getData();
    }

    /**
     * Gets the data stored in this TreeNode.
     *
     * @return the data within the TreeNode
     */
    public T getData() {
        return data;
    }

    /**
     * Gets the right child of this TreeNode.
     *
     * @return the right child of this TreeNode
     */
    public TreeNode<T> getRightChild() {
        return right;
    }

    /**
     * Sets the right child of this TreeNode.
     *
     * @param right the TreeNode to set as the right child
     */
    public void setRightChild(TreeNode<T> right) {
        this.right = right;
    }

    /**
     * Gets the left child of this TreeNode.
     *
     * @return the left child of this TreeNode
     */
    public TreeNode<T> getLeftChild() {
        return left;
    }

    /**
     * Sets the left child of this TreeNode.
     *
     * @param left the TreeNode to set as the left child
     */
    public void setLeftChild(TreeNode<T> left) {
        this.left = left;
    }
}
