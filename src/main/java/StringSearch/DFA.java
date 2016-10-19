package StringSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: rudy
 * @date: 2016/10/18
 *
 * 基于确定有限自动机的字符串搜索
 */
public class DFA {
    int stat[][]; // dfa 状态表
    String pattern; // 匹配字符串

    Map<Character, Integer> charMap; // 字符映射表

    public void buildPatternDFA(String pattern){
        this.pattern = pattern;

        int patternLength = pattern.length();

        // 创建字符映射
        int number = 0;
        Map<Character, Integer> tempMap = new HashMap<>();
        for(int i = 0; i< patternLength; i++){
            if(!tempMap.containsKey(pattern.charAt(i))){
                tempMap.put(pattern.charAt(i),number++);
            }
        }
        this.charMap = tempMap;

        // 初始化dfa状态表
        stat = new int[charMap.size()][];
        for (int r = 0; r < charMap.size(); r++)
            stat[r] = new int[patternLength];

        // 构造dfa状态表
        stat[charMap.get(pattern.charAt(0))][0] = 1;
        for(int X = 0, j = 1;j < patternLength; j++){
            // 没有命中
            for (int c = 0; c < charMap.size(); c++)
                stat[c][j] = stat[c][X];

            // 命中
            stat[charMap.get(pattern.charAt(j))][j] = j + 1;

            // update X
            X = stat[charMap.get(pattern.charAt(j))][X];
        }
    }

    public List<Integer> search(String docs) {
        int patternLength = pattern.length();
        int searchLength = docs.length();
        List<Integer> result = new ArrayList<>();

        // 运行自动机
        for(int i = 0, j = 0; i < searchLength; i++) {
            char currentChar = docs.charAt(i);
            if (charMap.containsKey(currentChar)) {
                j = stat[charMap.get(currentChar)][j];
            } else {
                j = 0;
            }

            // 找到一个插入
            if (j >= patternLength) {
                result.add(i - patternLength+1);
                j = 0;
            }
        }

        return result;
    }

    public static void main(String[] args){
        DFA dfa = new DFA();
        String searchString = "中华人民共和国成都中央人民政府中";
        String pattern = "成都";
        dfa.buildPatternDFA(pattern);
        List<Integer> result = dfa.search(searchString);
        System.out.println(result);
    }
}
