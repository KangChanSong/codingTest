package tree;

/**
 * 주어진 이진트리의 Balance가 맞는지 확인하는 함수를 구현하시오
 * 여기서 Balance가 맞다는 의미는 어떤 노드의 양쪽 서브트리의 길이가 1 이상 차이가 나지 않는 것.
 */
public class CheckTreeBalance {
    public static void main(String[] args) {
        Tree t = new Tree(10);
        boolean balanced = t.isBalanced(t.root);
        System.out.println(balanced);
        boolean balanced2 = t.isBalanced2(t.root);
        System.out.println(balanced2);
    }

    static class Tree {
        class Node{
            int data;
            Node left;
            Node right;
            Node(int data){
                this.data = data;
            }
        }
        Node root;
        Tree(int size){
            root = makeBST(0, size - 1);
        }
        Node makeBST(int start, int end){
            if(start > end) return null;
            int mid = (start + end) / 2;
            Node node = new Node(mid);
            node.left = makeBST(start, mid-1);
            node.right = makeBST(mid+1, end);
            return node;
        }
        boolean isBalanced(Node root){
            if(root == null) return true;
            // 양쪽 서브트리의 길이를 받아서 차이를 계산
            int heightDiff = getHeight(root.left) - getHeight(root.right);
            // 차이가 1 이상이면 false
            if(Math.abs(heightDiff) > 1 ){
                return false;
            // 차이가 2 이상이면 왼쪽과 오른쪽이 모두 균형잡혓는지 확인하고 true return
            } else {
                return isBalanced(root.left) && isBalanced(root.right);
            }
        }
        // 서브트리의 가장 깊은 깊이를 구하는 함수.
        int getHeight(Node root){
            if(root == null) return -1; // 트리의 마지막 노드를 지났으면 -1을 반환해서 level 에서 1을 뺀다.
            return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        }
        // MIN_VALUE = false
        int checkHeight(Node root){
            if(root == null) return -1;
            // 왼쪽 노드를 돌면서 서브트리의 길이를 잰다.
            int leftHeight = checkHeight(root.left);
            if(leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
            // 오른쪽 노드를 돌면서 서브트리의 길이를 잰다.
            int rightHeight = checkHeight(root.right);
            if(rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
            int heightDiff = leftHeight - rightHeight;
            if(Math.abs(heightDiff) > 1){
                return Integer.MIN_VALUE;
            } else {
                return Math.max(leftHeight, rightHeight) + 1;
            }
        }
        boolean isBalanced2(Node root){
            return checkHeight(root) != Integer.MIN_VALUE;
        }

        class Level{
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
        }
        boolean isBalanced3(Node root){
            Level obj = new Level();
            // 루트노드, 레벨 객체, 시작 레벨
            checkBalanced(root, obj, 0);
            if(Math.abs(obj.min - obj.max )> 1) return false;
            else return true;
        }

        void checkBalanced(Node node, Level obj, int level) {
            if(node == null){
                if(level < obj.min) obj.min = level;
                else if(level > obj.max) obj.max = level;
                return;
            }
            checkBalanced(node.left, obj, level + 1);
            checkBalanced(node.right, obj, level + 1);
        }
    }
}
