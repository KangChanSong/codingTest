package Inflearn.hashmap;

import java.util.*;

public class Q1 {
    public static Character A = 'A';
    public static Character B = 'B';
    public static Character C = 'C';
    public static Character D = 'D';
    public static Character E = 'E';

    private static Map<Character, Integer> createMap(){
        Map<Character, Integer> map = new HashMap<>();
        map.put(A, 0);
        map.put(B, 0);
        map.put(C, 0);
        map.put(D, 0);
        map.put(E, 0);
        return map;
    }

    private static Character soluition(String s){
        Map<Character, Integer> map = createMap();

        char[] arr = s.toCharArray();
        Set<Character> keySets = map.keySet();

        for(int i = 0; i < arr.length ; i++){
            final Character e = arr[i];
            keySets.forEach(c -> {
                if(e.equals(c)){
                    int value = map.get(c);
                    map.put(c, value+1);
                }
            });
        }
        char res = ' ';
        int score = 0;

        for(Character key : keySets){
            int value = map.get(key);
            if(value > score) {
                score = value;
                res = key;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String string = scanner.next();
        System.out.println(soluition(string));
    }
}
