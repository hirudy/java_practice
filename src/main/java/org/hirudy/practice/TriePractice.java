package org.hirudy.practice;

/**
 * @author: rudy
 * @date: 2016/08/15
 * <p>
 * 单词树,三向单词树
 */
public class TriePractice {

    /**
     * 单词树类
     */
    public static class SimpleTrie{
        public static final int R = 256; // R向单词查找数的next数组大小
        private Node root = new Node();

        public class Node {
            boolean isContain = false; // 是否包含当前节点
            public Node[] next = new Node[R]; // R向数组
        }

        public boolean insert(String word){
            return insert(word, root, 0);
        }

        /**
         * 向单词树中插入单词
         * @param word
         * @param node
         * @param deepth
         * @return
         */
        protected boolean insert(String word, Node node, int deepth){
            if (word == null){
                return false;
            }

            if (deepth == word.length()){
                node.isContain = true;
                return true;
            }

            char tmp = word.charAt(deepth);
            if(node.next[tmp] == null){
                node.next[tmp] = new Node();
            }

            return insert(word, node.next[tmp], deepth + 1);
        }

        /**
         * 判断单词是否存在于单词树中
         * @param word
         * @return
         */
        public boolean isExist(String word){
            int wordLength = word.length();
            Node tmpNode = this.root;
            int deepth;
            for (deepth=0; deepth < wordLength; deepth++){
                char tmpChar = word.charAt(deepth);
                if (tmpNode.next[tmpChar] == null){
                    break;
                }
                tmpNode = tmpNode.next[tmpChar];
            }

            if (deepth == wordLength && tmpNode.isContain){
                return true;
            }
            return false;
        }
    }

    /**
     * 三向单词树类
     */
    public static class TernaryTrie{
        private Node root; // 根节点

        public class Node {
            public boolean isContain = false; // 是否包含当前节点
            public char currentChar; //当前节点包含的字符
            public Node left,middle,right; // 三个方向的节点链接
        }

        public void insert(String word){
            if (word.length() <= 0){
                return;
            }
            this.root = insert(word, this.root, 0);
        }

        protected Node insert(String word, Node node, int deepth){
            char tmpChar = word.charAt(deepth);
            if (node == null){
                node = new Node();
                node.currentChar = tmpChar;
            }

            if (tmpChar < node.currentChar){
                node.left = insert(word, node.left,deepth);
            }else if (tmpChar > node.currentChar){
                node.right = insert(word, node.right,deepth);
            }else if(deepth < word.length()-1){
                node.middle = insert(word,node.middle, deepth+1);
            }else{
                node.isContain = true;
            }

            return node;
        }

        public boolean isExist(String word){
            int wordLength = word.length();
            int deepth = 0;
            Node tmpNode = root;
            boolean isLastNode = false;

            while (deepth < wordLength){
                if (tmpNode == null){
                    break;
                }
                char tmpChar = word.charAt(deepth);
                if (tmpChar == tmpNode.currentChar){
                    deepth ++;
                    if (deepth == wordLength){
                        isLastNode = tmpNode.isContain;
                    }
                    tmpNode = tmpNode.middle;
                }else if (tmpChar < tmpNode.currentChar){
                    tmpNode = tmpNode.left;
                }else if (tmpChar > tmpNode.currentChar){
                    tmpNode = tmpNode.right;
                }
            }

            if (deepth == wordLength && isLastNode){
                return true;
            }

            return false;
        }
    }

    public static void main(String[] args){
        // 简单的字典树验证
        System.out.println("simple trie check:");
        String[] wordList = new String[]{"aaa","bba","test","trie","test1","term","hello","hello_world"};
        SimpleTrie simpleTrie = new SimpleTrie();
        for (String word : wordList){
            simpleTrie.insert(word);
        }

        System.out.println(simpleTrie.isExist("trie"));
        System.out.println(simpleTrie.isExist("term"));
        System.out.println(simpleTrie.isExist("tes"));
        System.out.println(simpleTrie.isExist("hello"));
        System.out.println(simpleTrie.isExist("hello_"));

        // 三向字典树验证
        System.out.println("ternary trie check:");
        String[] wordList2 = new String[]{"aaa","b中a","test","tr文ie","test1","term","hello","hello_world"};
        TernaryTrie ternaryTrie = new TernaryTrie();
        for (String word : wordList2){
            ternaryTrie.insert(word);
        }

        System.out.println(ternaryTrie.isExist("trie"));
        System.out.println(ternaryTrie.isExist("term"));
        System.out.println(ternaryTrie.isExist("tr文ie"));
        System.out.println(ternaryTrie.isExist("hello"));
        System.out.println(ternaryTrie.isExist("hello_"));
    }
}
