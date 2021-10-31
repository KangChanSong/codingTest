package tree;

/**
 * 이진검색트리에서 주어진 노드의 다음 노드를 찾는 함수를 구현하시ㅗ
 * 단, inorder 순회에 입각함
 */
public class InOrderTraverse {
    public static void main(String[] args) {
        Tree t = new Tree(10);
        t.findNext(t.root.left.right.right);
        t.findNext(t.root.left);
        t.findNext(t.root.left.left);
        t.findNext(t.root.right);
        t.findNext(t.root.right.left.right);
    }

    static class Tree{
        class Node{
            int data;
            Node left;
            Node right;
            Node parent;
            Node (int data){
                this.data = data;
            }
        }
        Node root;
        Tree(int size){
            root = makeBST(0, size-1, null);
        }
        private Node makeBST(int start, int end, Node parent) {
            if(start > end) return null;
            int mid = (start + end) / 2;
            Node node = new Node(mid);
            node.left = makeBST(start, mid-1, node);
            node.right = makeBST(mid+1, end, node);
            node.parent = parent;
            return node;
        }
        void findNext(Node node){
            // 오른쪽 자식이 없다면 자신과 자신의 다음을 출력
            if(node.right == null){
                System.out.println
                        (findAbove(node.parent, node).data + " is " + node.data + "'s next");
            // 오른쪽 자식이 있다면 자신과 자신의 다음을 출력
            } else {
                System.out.println
                        (findBelow(node.right).data + " is " + node.data + "'s next");
            }
        }

        Node findAbove(Node root, Node child){
            if(root == null) return null;
            // 부모의 왼쪽이 자기 자신이면 부모를 출력
            if(root.left == child) return root;
            // 아니면 계속 올라가면서 자신이 부모의 왼쪽인지 확인
            return findAbove(root.parent, root);
        }
        Node findBelow(Node root){
            // 자신의 왼쪽이 없다면 자신을 출력
            if( root.left == null) return root;
            // 왼쪽이 있다면 왼쪽을 계속 탐색
            return findBelow(root.left);
        }
    }
}
