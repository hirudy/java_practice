package NoFuck;

import java.io.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: rudy
 * @date: 2016/10/18
 *
 * 基于hashmap实现的树形单词存储结构(DFA?)
 */

public class DFAMapTree {
    // 定义节点
    public static class Node<K, V> {
        public boolean isEnd = false;  // 是否为结束节点
        public Map<K, V> nextNodeList = null; // 子节点列表
    }

    private Node<Character,Node> root; // 定义根节点

    /**
     * 从文件中读取敏感词
     * @return Set<String>
     */
    private Set<String> readWordsFromFile(){
        String wordsPath = System.getProperty("user.dir","/usr/local") + "/src/main/resources/CensorWords.txt";
        Set<String> words = new HashSet<>();
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(new FileInputStream(wordsPath)));
            while (true){
                String line = in.readLine();
                if (line == null){
                    break;
                }
                words.add(line.trim());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try{
                in.close();
            }catch (Exception ignore){

            }
        }

        return words;
    }

    /**
     * 加载敏感词到hash树形结构中
     * @param words
     */
    private void loadWords(Set<String> words){
        Node<Character,Node> root = new Node<>();

        for(String word : words){
            Node<Character, Node> temp = root;
            int wordLength = word.length();
            for (int i = 0; i < wordLength; i++ ){
                char currentChar = word.charAt(i);
                if (temp.nextNodeList == null){
                    temp.nextNodeList = new HashMap<>();
                }
                if (!temp.nextNodeList.containsKey(currentChar)){
                    temp.nextNodeList.put(currentChar, new Node<Character, Node>());
                }
                temp = temp.nextNodeList.get(currentChar);
            }
            temp.isEnd = true;
        }

        this.root = root;
    }

    /**
     * 初始化树
     */
    public synchronized void init(){
        Set<String> words = readWordsFromFile();
        loadWords(words);
    }

    public Node<Character, Node> getRoot() {
        return root;
    }
}
