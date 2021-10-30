package tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;

/**
 * 이진트리의 노드들을 각 레벨별로 링크드 리스트에 담는 알고리즘을 구현하시오
 * 예를들어, 5개의 레벨을 가지는 트리라면 5개의 링크드 리스트를 만들어야함.
 */
public class BTreeToList {
    public static void main(String[] args) {

        Tree t = new Tree(10);
        System.out.println("=== SOLUTION 1 (RECURSIVE)===");
        t.printList(t.BSTtoList());
        System.out.println("=== SOLUTION 2 (BFS)===");
        t.printList(t.BSTtoList2());
    }
    static class Tree {
        class Node {
            int data;
            Node left;
            Node right;

            Node(int data) {
                this.data = data;
            }
        }
        Node root;
        Tree(int size){
            root = makeBST(0, size-1);
        }

        private Node makeBST(int start, int end) {
            if(start > end) return null;
            int mid = (start + end) / 2;
            Node node = new Node(mid);
            node.left = makeBST(start, mid - 1);
            node.right = makeBST(mid + 1, end);
            return node;
        }

        ArrayList<LinkedList<Node>> BSTtoList(){
            ArrayList<LinkedList<Node>> lists = new ArrayList<>();
            BSTtoList(root, lists, 0);
            return lists;
        }

        void BSTtoList(Node root, ArrayList<LinkedList<Node>> lists, int level) {
            if(root == null) return;
            LinkedList<Node> list = null;
            // 배열에 해당 레벨의 리스트가 존재하지 않으면 배열에 추가한다.
            if(lists.size() == level){
                list = new LinkedList<>();
                lists.add(list);
            // 배열에 해당 레벨의 리스트가 존재하면 가져온다.
            } else {
                list = lists.get(level);
            }
            // 리스트에 현재 노드를 담는다.
            list.add(root);
            BSTtoList(root.left, lists, level+1);
            BSTtoList(root.right, lists, level+1);
        }

        ArrayList<LinkedList<Node>> BSTtoList2(){
            ArrayList<LinkedList<Node>> result = new ArrayList<>();
            LinkedList<Node> current = new LinkedList<>();
            if(root != null){
                current.add(root);
            }
            while (current.size() > 0){
                // 현재 레벨을 리스트 배열에 추가한다.
                result.add(current);
                // 현재 레벨을 parents 에 담는다.
                LinkedList<Node> parents = current;
                // 현재 레벨 초기화
                current = new LinkedList<>();
                // 부모 레벨을 모두 돌며 자식이 있다면 현재 레벨에 추가한다.
                for(Node parent : parents){
                    if(parent.left != null) current.add(parent.left);
                    if(parent.right != null) current.add(parent.right);
                }
            }

            // 마지막 레벨, 즉 current 에 자식이 더이상 없다면 결과 반환.
            return result;
        }
        void printList(ArrayList<LinkedList<Node>> arr){
            for(LinkedList<Node> list : arr){
                for(Node node : list){
                    System.out.print(node.data + " ");
                }
                System.out.println();
            }
        }
    }
}
