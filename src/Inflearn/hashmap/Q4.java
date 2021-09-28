package Inflearn.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q4 {

    private static Map<Character, Integer> createMap(char[] chars) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0 ; i < chars.length; i++){
            if(map.get(chars[i]) == null){
                map.put(chars[i], 1);
            } else {
                map.put(chars[i], map.get(chars[i]) + 1);
            }
        }
        return map;
    }

    private static int solution(String s, String t){

        int k = t.length();
        Map<Character, Integer> sMap = createMap(s.substring(0, k).toCharArray());
        // T 에 해당하는 Map 생성
        Map<Character, Integer> tMap = createMap(t.toCharArray());

        // S 를 Looping 하며 Map 생성
        char[] chars = s.toCharArray();

        int count = 0;
        if(sMap.equals(tMap)) count = 1;

        for(int i = t.length() ; i < chars.length ; i++){

            // 맨 앞 원소 제거
            Character bChar = chars[i-k];
            if(sMap.get(bChar) == 1){
                sMap.remove(bChar);
            } else {
                sMap.put(bChar, sMap.get(bChar) - 1);
            }

            if(sMap.get(chars[i]) == null){
                sMap.put(chars[i], 1);
            } else {
                sMap.put(chars[i], sMap.get(chars[i]) + 1);
            }
            // S Map 과 T Map 비교
            if(sMap.equals(tMap)) count++;
        }

        // 같으면 카운트 ++
        return count;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String t = scanner.next();
        System.out.println(solution(s,t));
    }
}
