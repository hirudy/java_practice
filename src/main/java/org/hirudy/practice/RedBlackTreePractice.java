package org.hirudy.practice;

/**
 * @author: rudy
 * @date: 2016/08/13
 *
 * 红黑树实现
 *
 */
public class RedBlackTreePractice {

    /**
     * 红黑数节点
     * @param <T>
     */
    private static class Node<T> {
        public static final boolean RED_NODE = true;
        public static final boolean BLACK_NODE = false;

        public boolean nodeColor; // 节点颜色
        public Comparable key; // 当前节点搜索key
        public T value; // 当前节点存储值

        public int nodeNumber = 0; // 以当前节点为根节点的子树的节点个数
        public Node leftNode,rightNode; // 当前节点的左右子节点

        public Node(Comparable key, T value,int number, boolean color){
            this.key = key;
            this.value = value;
            this.nodeNumber = number;
            this.nodeColor = color;
        }

        /**
         * 判断当前节点类型
         * @return boolean
         */
        public boolean isRed(){
            return this.nodeColor == RED_NODE;
        }

        /**
         * 获取当前节点及其子节点个数
         * @return int
         */
        public int getSize(){
            return nodeNumber;
        }

        /**
         * 计算当前节点及其子节点个数
         * @return int
         */
        protected int size(){
            int nodeNumber = 1;
            if (leftNode != null){
                nodeNumber += leftNode.getSize();
            }
            if (rightNode != null){
                nodeNumber += rightNode.getSize();
            }
            return nodeNumber;
        }
    }

    /**
     * 红黑数
     * @param <T>
     */
    public static class RedBlackTree<T> {
        private Node<T> root; // 根节点

        /**
         * 红黑树基本操作-左旋转
         * @param Node<T> node
         * @return Node<T>
         */
        protected Node rotateLeft(Node node){
            Node tmp = node.rightNode;
            node.rightNode = tmp.leftNode;
            tmp.leftNode = node;
            tmp.nodeColor = node.nodeColor;
            node.nodeColor = Node.RED_NODE;
            tmp.nodeNumber = node.nodeNumber;
            node.nodeNumber = node.size();
            return tmp;
        }

        /**
         * 红黑树基本操作-右旋转
         * @param Node<T> node
         * @return Node<T>
         */
        protected Node rotateRight(Node node){
            Node tmp = node.leftNode;
            node.leftNode = tmp.rightNode;
            tmp.rightNode = node;
            tmp.nodeColor = node.nodeColor;
            node.nodeColor = Node.RED_NODE;
            tmp.nodeNumber = node.nodeNumber;
            node.nodeNumber = node.size();
            return tmp;
        }

        /**
         * 红黑树基本操作-颜色旋转
         * @param Node<T> node
         * @return Node<T>
         */
        protected Node rotateColor(Node node){
            node.nodeColor = Node.RED_NODE;
            node.leftNode.nodeColor = Node.BLACK_NODE;
            node.rightNode.nodeColor = Node.BLACK_NODE;
            return node;
        }

        /**
         * 判断节点是否为红节点
         * @param node
         * @return
         */
        protected boolean isRed(Node node){
            if (node == null){
                return false;
            }
            return node.isRed();
        }

        public Node<T> search(Comparable key){
            return search(key,this.root);
        }

        /**
         * 查询
         * @param key 查询关键字
         * @param node 开始查询的根节点
         * @return Node 查找到的节点
         */
        public Node<T> search(Comparable key, Node node){
            if (node == null){
                return null;
            }
            int cmp = key.compareTo(node.key);
            if (cmp < 0){
                return search(key,node.leftNode);
            }else if (cmp > 0){
                return search(key,node.rightNode);
            }else{
                return node;
            }
        }

        /**
         * 从根节点插入
         * @param key
         * @param value
         */
        public void insert(Comparable key, T value){
            Node<T> node = insertSubTree(this.root, key, value);
            node.nodeColor = Node.BLACK_NODE;
            this.root = node;
        }

        /**
         * 从某个节点插入
         * @param key 插入key
         * @param value 插入值
         */
        protected Node insertSubTree(Node node, Comparable key, T value){
            if (node == null){
                return new Node<T>(key, value, 1, Node.RED_NODE);
            }

            // 比较各个节点
            int cmp = key.compareTo(node.key);
            if (cmp < 0){
                node.leftNode = insertSubTree(node.leftNode, key, value);
            }else if (cmp > 0){
                node.rightNode = insertSubTree(node.rightNode, key, value);
            }else{
                node.value = value;
            }

            if (!isRed(node.leftNode) && isRed(node.rightNode)){
                node = rotateLeft(node);
            }

            if (isRed(node.leftNode) && isRed(node.leftNode.leftNode)){
                node = rotateRight(node);
            }

            if (isRed(node.leftNode) && isRed(node.rightNode)){
                node = rotateColor(node);
            }
            node.nodeNumber = node.size();

            return node;
        }
    }


    public static void main(String[] args){
        RedBlackTree<String> tree = new RedBlackTree<String>();

        int[] insertValue = new int[]{12,1,9,10,77,2,38,8,4};
        for (int value : insertValue){
            tree.insert(value,"value_" + value);
        }

        Node node = tree.search(77);
        System.out.println(node.value);
        System.out.println("end");
    }
}
