package tree;

import java.util.LinkedList;

class HashTable{
    class Node{
        String key;
        String value;
        Node(String key, String value){
            this.key = key;
            this.value = value;
        }
        String value(){
            return value;
        }
        void value(String value){
            this.value = value;
        }
    }
    LinkedList<Node>[] data;
    HashTable(int size){
        this.data = new LinkedList[size];
    }
    int getHashCode(String key){
        int hashcode = 0;
        for(char c : key.toCharArray()){
            hashcode += c;
        }
        return hashcode;
    }
    int convertToIndex(int hashcode){
        return hashcode % data.length;
    }
    // key 가 있는지 확인하는 함수
    Node searchKey(LinkedList<Node> list, String key){
        if(list == null) return null;
        for(Node node : list){
            if(node.key.equals(key)) return node;
        }
        return null;
    }
    void put(String key, String value){
        int hashcode = getHashCode(key);
        int index = convertToIndex(hashcode);
        LinkedList<Node> list = data[index];
        if(list == null){
            list = new LinkedList<>();
            data[index] = list;
        }
        Node node = searchKey(list, key);
        // 링크드 리스트에 키에 해당하는 노드가 없으면 추가, 있으면 value 변경
        if(node == null){
            list.addLast(new Node(key,value));
        } else {
            node.value(value);
        }
    }
    String get(String key){
        int hashcode = getHashCode(key);
        int index = convertToIndex(hashcode);
        LinkedList<Node> list = data[index];
        Node node = searchKey(list, key);
        return node == null ? "Not found" : node.value();
    }
}
public class HashTableImpl {
    public static void main(String[] args) {
        HashTable h = new HashTable(3);
        h.put("sung", "She is pretty");
        h.put("jin", "She is a model");
        h.put("hee", "She is an angel");
        h.put("min", "She is cute");
        System.out.println("h.get(\"sung\") = " + h.get("sung"));
        System.out.println("h.get(\"jin\") = " + h.get("jin"));
        System.out.println("h.get(\"hee\") = " + h.get("hee"));
        System.out.println("h.get(\"min\") = " + h.get("min"));
    }
}
