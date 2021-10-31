package Inflearn.treegraph;

public class BTreeTraverse {

    public static void main(String[] args) {
        BTree bTree = new BTree(1);
        System.out.println("=== inodrer ===");
        bTree.inorder();
        System.out.println();

        bTree.reset();
        System.out.println("=== preodrer ===");
        bTree.preorder();
        System.out.println();

        bTree.reset();
        System.out.println("=== postodrer ===");
        bTree.postorder();
    }

    static class BTree{
        static class Node{
            int data;
            Node left;
            Node right;
            boolean isMarked = false;
            Node(int data){
                this.data = data;
            }
        }
        Node root;
        BTree(int data){
            root = makeBTree(data);
        }

        private Node makeBTree(int data) {
            if(data > 5) return new Node(data);
            Node node = new Node(data);
            node.left = makeBTree(data + data);
            node.right = makeBTree(data + data + 1);
            return node;
        }

        void reset(){
            reset(root);
        }
        private void reset(Node node){
            if(node == null) return;
            node.isMarked = false;
            reset(node.left);
            reset(node.right);
        }
        void inorder(){
            inorder(root);
        }
        void inorder(Node node){
            if(node == null) return;
            inorder(node.left);
            if(node.isMarked == false){
                System.out.print(node.data + " ");
                node.isMarked = true;
            }
            inorder(node.right);
        }

        void preorder(){
            preorder(root);
        }
        void preorder(Node node){
            if(node == null) return;
            if(node.isMarked == false){
                System.out.print(node.data + " ");
                node.isMarked = true;
            }
            preorder(node.left);
            preorder(node.right);
        }

        void postorder(){
            postorder(root);
        }

        void postorder(Node node){
            if(node == null) return;
            postorder(node.left);
            postorder(node.right);
            if(node.isMarked == false){
                System.out.print(node.data + " ");
                node.isMarked = true;
            }
        }
    }
}
