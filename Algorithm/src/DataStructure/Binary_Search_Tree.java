package DataStructure;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.xml.internal.ws.util.StringUtils;
import sun.swing.StringUIClientPropertyKey;

/*
     * BST(Binary Search Tree)
     1. 이진 탐색 트리의 노드에 저장된 키는 유일
     2. 루트 노드의 키가 왼쪽 서브 트리를 구성하는 어떠한 노드의 키보다 크다
     3. 루트 노드의 키가 오른쪽 서브 트리를 구성하는 어떠한 노드의 키보다 작다
     4. 왼쪽과 오른쪽 서브트리도 이진 탐색 트리이다

     O(log n)의 시간복잡도르 가짐 - 정확히는 O(h)라고 표현하는 것이 맞음
 */
public class Binary_Search_Tree {
    public Node rootNode;

    public Binary_Search_Tree() {
        this.rootNode = null;
    }

    // 검색
    public Node findNode(int key) {
        if(rootNode == null) return  null;

        Node searchNode = rootNode;
        while (searchNode.getData() != key) {
            if(key < searchNode.getData()) {
                searchNode = searchNode.getLeft();
            } else {
                searchNode = searchNode.getRight();
            }
            if(searchNode == null) return null;
        }
        return  searchNode;
    }

    // 추가 - 1. 반복문 (재귀보다 효율이 좋음)
    public void addNode(int key) {
        if(findNode(key) != null) return; // 중복방지
        Node newNode = new Node(key);

        if(rootNode == null) {
            rootNode = newNode;
        } else {
            Node current = rootNode;
            Node parentNode = null;

            while(true) {
                parentNode = current;
                if(key > current.getData()) {
                    current = current.getRight();
                    if(current == null) {
                        parentNode.setRight(newNode);
                        return;
                    }
                } else if(key < current.getData()) {
                    current = current.getLeft();
                    if(current == null) {
                        parentNode.setLeft(newNode);
                        return;
                    }
                }
            }
        }
    }

    // 추가 - 2. 재귀
    public Node addNode_self(int key, Node node) {
        if(findNode(key) != null) return null; // 중복방지
        Node currentNode = rootNode;
        Node newNode = new Node(key);

        if(currentNode == null) {
            currentNode = newNode;
        } else if(currentNode.getData() > newNode.getData()) {
            currentNode.setLeft(addNode_self(key, currentNode.getLeft()));
            return  currentNode;
        } else if(currentNode.getData() < newNode.getData()) {
            currentNode.setRight(addNode_self(key, currentNode.getRight()));
        }
        return currentNode;
     }

    /*  삭제
        1. 자식이 없는 노드 삭제
        2. 자식이 있는 노드 삭제
            2-1. 자식이 1개 있는 노드
            2-2. 자식이 2개 있는 노드
     */
    public boolean deleteNode(int key) {
        if(findNode(key) == null) return false;
        Node currentNode = rootNode;
        Node parentNode = null;
        boolean isLeft = false;

        while(currentNode.getData() != key) {
            parentNode = currentNode;
            if(key < currentNode.getData()) {
                isLeft =  true;
                currentNode = currentNode.getLeft();
            } else if(key > currentNode.getData()) {
                currentNode = currentNode.getRight();
            }

            if(currentNode == null) {
                return false;
            }
        }

        // 1. 자식이 없는 노드
        if(currentNode.getLeft() == null && currentNode.getRight() == null) {
            if (currentNode == rootNode) {
                rootNode = null;
            } else if (isLeft) {
                parentNode.setLeft(null);
            } else {
                parentNode.setRight(null);
            }
        // 2. 자식이 있는 노드 (1개)
        } else if(currentNode.getRight() == null) {
            if(currentNode == rootNode) {
                rootNode = currentNode.getLeft();
            } else if(isLeft) {
                parentNode.setLeft(currentNode.getLeft());
            } else {
                parentNode.setRight(currentNode.getLeft());
            }
        } else if(currentNode.getLeft() == null) {
            if(currentNode == rootNode) {
                rootNode = currentNode.getRight();
            } else if(isLeft) {
                parentNode.setLeft(currentNode.getRight());
            } else {
                parentNode.setRight(currentNode.getRight());
            }
        // 3. 자식이 있는 노드 (2개)
        } else if(currentNode.getLeft() != null && currentNode.getRight() != null) {

        }
        return true;
    }
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
