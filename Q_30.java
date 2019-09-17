package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// 串联所有单词的字串
public class Q_30 {

	public static void main(String[] args) {
		String[] words = {"foo","bar"};
		System.out.println(findSubstring("barfoothefoobarman",words));

	}
	public static List<Integer> findSubstring(String s, String[] words){
		List<Integer> substringList = new ArrayList<Integer>();
		int everyWordLength = words[0].length();
		int wordsLength = words.length;
		int strLength = s.length();
		// 构建words数组的hashmap,key为每一个单词，value为该单词的个数:
		Map<String, Integer> wordsMap = new HashMap<String, Integer>(); 
		for(int i = 0; i < wordsLength; i++){
			if(wordsMap.containsKey(words[i])){
				int temp = wordsMap.get(words[i]);
				wordsMap.remove(words[i]);
				wordsMap.put(words[i], temp + 1);
			}else{
				wordsMap.put(words[i], 1);
			}
		}
//		System.out.println("the wordsMap is " + wordsMap.get("str"));
		
		int index = 0;
		while(index + everyWordLength * wordsLength <= strLength) {
			String temp_s = s.substring(index, index + everyWordLength * wordsLength);
//			System.out.println();
//			System.out.println("本次字串为：" + temp_s);
			if(wordsMap.equals(getStrMap(temp_s, everyWordLength, wordsLength))){
//				System.out.println("it is true" + index);
				substringList.add(index);
			}
			index += 1;
		}
		return substringList;
	}
	
	public static HashMap<String,Integer> getStrMap(String str,int everyWordLength,int wordsLength){
		HashMap<String,Integer> strMap= new HashMap<String,Integer>();
		for(int i = 0; i < wordsLength; i++){
			String temp_spitWord = str.substring(i*everyWordLength,(i+1)*everyWordLength);
//			System.out.println("the temp_spitWord is "+ temp_spitWord);
			if(strMap.containsKey(temp_spitWord)){
				int temp = strMap.get(temp_spitWord);
				strMap.remove(temp_spitWord);
				strMap.put(temp_spitWord, temp + 1);
			}else{
				strMap.put(temp_spitWord, 1);
			}
		}
		return strMap;
	}

}
