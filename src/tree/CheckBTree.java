package tree;

/**
 * 이진 검색트리인지 확인하라.
 */
public class CheckBTree {

    public static void main(String[] args) {
        Tree t = new Tree(10);
        System.out.println("Solution 1 - using inorder");
        System.out.println(t.isValidateBST1());
        System.out.println("Solution 2 - without array");
        System.out.println(t.isValidateBST2());
        System.out.println("Solution 3 - min/max");
        System.out.println(t.isValidateBST3());
    }

    static class Tree{
        class Node{
            int data;
            Node left;
            Node right;
            Node(int data){this.data = data;}
        }
        Node root;
        int size;
        Tree(int size){
            this.size = size;
            root = makeBSTree(0, size-1);
        }

        Node makeBSTree(int start, int end) {
            if(start > end) return null;

            int mid = (start + end) / 2;
            Node node = new Node(mid);
            node.left = makeBSTree(start, mid-1);
            node.right = makeBSTree(mid+1, end);
            return node;
        }

        boolean isValidateBST1(){
            int[] array = new int[size];
            inorder(root, array);
            for(int i = 1; i < array.length ; i++){
                if(array[i] < array[i-1]){
                    return false;
                }
            }
            return true;
        }
        int index = 0;
        void inorder(Node root, int[] array){
            if(root != null){
                inorder(root.left, array);
                array[index] = root.data;
                index++;
                inorder(root.right, array);
            }
        }

        Integer last_printed = null;
        boolean isValidateBST2(){
            return isValidateBST2(root);
        }
        boolean isValidateBST2(Node n){
            // 노드의 마지막을 지났으면 true를 반환
            if(n == null) return true;
            // 먼저 왼쪽 노드들을 돌며 결과를 받아 정렬되어있지 않은 결과면 false 반환.
            if(!isValidateBST2(n.left)) return false;
            // 전의 값과 현재의 값을 비교
            // 전의 값이 현재 값보다 크면 순서가 다르기때문에 false를 반환
            if(last_printed != null && n.data < last_printed){
                return false;
            }
            last_printed = n.data;
            if(!isValidateBST2(n.right)) return false;
            return true;
        }

        boolean isValidateBST3(){
            return isValidateBST3(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private boolean isValidateBST3(Node node, int min, int max) {
            if(node == null) return true;
            // 노드값이 최대, 최솟값을 벗어나면 false 반환
            if(node.data < min || node.data > max) return false;

            // 왼쪽 오른쪽 노드들로 함수 호출, 비교값을 줄여나간다.
            if(!isValidateBST3(node.left, min , node.data) ||
                    !isValidateBST3(node.right, node.data, max)){
                return false;
            }
            // 모든 조건을 통과했으면 true 반환
            return true;
        }
    }
}
