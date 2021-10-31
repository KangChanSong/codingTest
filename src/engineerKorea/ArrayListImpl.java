package engineerKorea;

import java.util.Arrays;

public class ArrayListImpl {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(10);
        list.add(10);
        list.add(10);
        System.out.println(list);
        list.remove(3);
        System.out.println(list);
        list.remove(3);
        System.out.println(list);
        list.remove(3);
        System.out.println(list);
    }
}

class MyArrayList{
    int[] data;
    int current;
    public MyArrayList(){
        data = new int[10];
        current = -1;
    }
    public MyArrayList(int size){
        data = new int[size];
        current = -1;
    }
    public void add(int n){
        if(current == data.length-1){
            int[] newData = new int[data.length*2];
            for(int i = 0 ; i < data.length ; i++){
                newData[i] = data[i];
            }
            data = newData;
        }
        data[++current] = n;
    }
    public int get(int index){
        return data[index];
    }
    public void remove(int index){
        for(int i = index; i < data.length ; i++){
            if(i == data.length-1) data[i] = 0;
            else data[i] = data[i+1];
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
