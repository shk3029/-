package DataStructure;

/*
     * BST(Binary Search Tree)
     1. 이진 탐색 트리의 노드에 저장된 키는 유일
     2. 루트 노드의 키가 왼쪽 서브 트리를 구성하는 어떠한 노드의 키보다 크다
     3. 루트 노드의 키가 오른쪽 서브 트리를 구성하는 어떠한 노드의 키보다 작다
     4. 왼쪽과 오른쪽 서브트리도 이진 탐색 트리이다

     O(log n)의 시간복잡도르 가짐 - 정확히는 O(h)라고 표현하는 것이 맞음
 */
public class Binary_Search_Tree {
    Node rootNoe = new Node(10);


}

class Node {
    private int data;
    private Node left;
    private Node right;

    public Node(int data) {
        this.data = data;
        setLeft(null);
        setRight(null);
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
