package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DepthFirstSearch {
        public static void main(String[] args) {

                System.out.println("====== DFS ======");
                createGraph().dfs();
                System.out.println();
                System.out.println("====== BFS ======");
                createGraph().bfs();
                System.out.println();
                System.out.println("====== DFS recursive ======");
                createGraph().dsfR(0);

        }

        static Graph createGraph(){
                Graph g = new Graph(9);
                g.addEdge(0, 1);
                g.addEdge(1, 2);
                g.addEdge(1, 3);
                g.addEdge(2, 4);
                g.addEdge(2, 3);
                g.addEdge(3, 4);
                g.addEdge(3, 5);
                g.addEdge(5, 6);
                g.addEdge(5, 7);
                g.addEdge(6, 8);
                return g;
        }
}

class Graph{

        Node[] nodes;
        Graph(int size){
                nodes = new Node[size];
                for(int i = 0; i < size ; i++){
                        // 데이터와 인덱스가 같음
                        nodes[i] = new Node(i);
                }
        }

        class Node{
                int data;
                LinkedList<Node> adjacent; // 인접한 노드들 간의 관계
                boolean marked; // 방문했는지 확인
                Node(int data){
                        this.data = data;
                        this.marked = false;
                        adjacent = new LinkedList<>();
                }
        }

        // 두 노드의 관계를 저장하는 함수.
        void addEdge(int i1, int i2){
                Node n1 = nodes[i1];
                Node n2 = nodes[i2];
                if( !n1.adjacent.contains(n2)){
                        n1.adjacent.add(n2);
                }
                if( !n2.adjacent.contains(n1)){
                        n2.adjacent.add(n1);
                }
        }

        void dfs(){
                dfs(0);
        }
        void dfs(int index){
                // 루트 노드를 꺼낸다
                Node root = nodes[index];
                Stack<Node> stack = new Stack<>();
                stack.push(root);
                root.marked = true;
                // 스택이 비어질때까지
                while (!stack.isEmpty()){
                        // 스택에서 노드 하나를 꺼낸다
                        Node r = stack.pop();
                        // 꺼낸 노드의 자식들을 모두 마킹하고 다시 스택에 넣는다.
                        for(Node n : r.adjacent){
                                if(n.marked == false){
                                        n.marked = true;
                                        stack.push(n);
                                }
                        }
                        // 꺼냇던 노드를 출력한다.
                        visit(r);
                }
        }

        void bfs(){
                bfs(0);
        }

        void bfs(int index){
                //루트 노드를 가져온다.
                Node root = nodes[index];
                Queue<Node> queue = new LinkedList<>();
                // 큐에 루트노드를 넣는다.
                queue.add(root);
                // 큐에 들어갔었다고 마킹한다.
                root.marked = true;
                // 큐가 비어질때까지 큐에서 노드를 꺼내고 그 자식들을 마킹 후 큐에 넣는 작업을 한다.
                while (!queue.isEmpty()){
                        Node r = queue.poll();
                        for(Node n : r.adjacent){
                                if(n.marked == false){
                                        n.marked = true;
                                        queue.add(n);
                                }
                        }
                        visit(r);
                }
        }
        void dfsR(){
                dsfR(0);
        }
        void dfsR(Node r){
                if(r == null) return;
                r.marked = true;
                visit(r);
                for(Node n : r.adjacent){
                        // 큐에 넣어진 적이 없는 자식들에 대해 재귀 호출한다.
                        if(n.marked == false){
                                dfsR(n);
                        }
                }
        }
        void dsfR(int index){
                Node r = nodes[index];
                dfsR(r);
        }

        void visit(Node n){
                System.out.print(n.data + " ");
        }
}
