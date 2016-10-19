package NoFuck;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: rudy
 * @date: 2016/10/18
 *
 * 基于hashmap实现的树形单词存储结构的具体工具类
 */
public class DFAMapTreeFilter {
    private DFAMapTree tree = new DFAMapTree();

    public DFAMapTreeFilter(){
        tree.init();
    }

    /**
     * 检测字符串一个字符后面是否有敏感词
     * @param content
     * @param indexStart
     * @return
     */
    private Pair<Integer, String>  checkOneChar(String content, int indexStart){
        Pair<Integer, String> result = new Pair<>(-1, "");
        DFAMapTree.Node temp = tree.getRoot();
        int length = content.length();
        StringBuilder builder = new StringBuilder();
        for (int i = indexStart; i < length; i++ ){
            char tempChar = content.charAt(i);
            if (temp.nextNodeList == null){
                break;
            }
            if (temp.nextNodeList.containsKey(tempChar)){
                builder.append(tempChar);
                temp = (DFAMapTree.Node) temp.nextNodeList.get(tempChar);
            }else{
                break;
            }
        }
        if (temp.isEnd){
            result = new Pair<>(indexStart,builder.toString());
        }
        return result;
    }

    /**
     * 判断是否存在关键词
     * @param content
     * @return
     */
    public boolean scanCensorWordsExist(String content){
        int contentLength = content.length();
        boolean result = false;
        for(int i = 0; i < contentLength; i++ ){
            Pair<Integer, String> temp = checkOneChar(content, i);
            if (temp.getKey() >= 0) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * 找出一句话中所有敏感词
     * @param content
     * @return
     */
    public List<Pair<Integer, String>> scanCensorWords(String content){
        int contentLength = content.length();
        List<Pair<Integer,String>> result = new LinkedList<>();
        for(int i = 0; i < contentLength; i++ ){
            Pair<Integer, String> temp = checkOneChar(content, i);
            if (temp.getKey() >= 0) {
                result.add(temp);
                i = temp.getKey() + temp.getValue().length() - 1;
            }
        }
        return result;
    }

    /**
     * 替换找到的敏感词
     * @param content
     * @param replace
     * @return
     */
    public String scanCensorWordsAndReplace(String content, char replace){
        int contentLength = content.length();
        List<Pair<Integer,String>> words = scanCensorWords(content);
        StringBuilder builder = new StringBuilder(content);

        StringBuilder tempBuilder = new StringBuilder();
        int wordLength;
        for(Pair<Integer, String> word: words){
            tempBuilder.setLength(0);
            wordLength = word.getValue().length();
            for(int i=0; i < wordLength; i++){
                tempBuilder.append(replace);
            }
            builder.replace(word.getKey(),word.getKey() + wordLength, tempBuilder.toString());
        }
        return builder.toString();
    }

    public static void main(String[] args){
        DFAMapTreeFilter filter = new DFAMapTreeFilter();
        String rawContent = "太多的伤感情怀也许只局限于饲养基地 荧幕中的情节，主人公尝试着去用某种方式渐渐的很潇洒地释自杀指南怀那些自己经历的伤感。然后法轮功 我们的扮演的角色就是跟随着主人公的喜红客联盟 怒哀乐而过于牵强的把自己的情感也附加于银幕情节中，然后感动就流泪，难过就躺在某一个人的怀里尽情的阐述心扉或者手机卡复制器一个人一杯红酒一部电影在夜三级片 深人静的晚上，关上电话静静的发呆着口交";
//        String rawContent = "三1级片triangleboy成都aa版本";
        System.out.println(rawContent);

        // 判断是否存在关键词
        boolean isExist = filter.scanCensorWordsExist(rawContent);
        System.out.println(isExist);

        // 查找
        List<Pair<Integer, String>> wordList = filter.scanCensorWords(rawContent);
        System.out.println(wordList);

        // 替换
        String replaceString = filter.scanCensorWordsAndReplace(rawContent,'*');
        System.out.println(replaceString);
    }
}
