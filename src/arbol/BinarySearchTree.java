/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbol;

/**
 *
 * @author Familia
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public Node<T> insert(Node<T> rootNode, T data) {
        if (rootNode == null) {
            rootNode = new Node<T>(data);
            return rootNode;
        }

        if (data.compareTo(rootNode.data) < 0) {
            rootNode.left = insert(rootNode.left, data);
        } else if (data.compareTo(rootNode.data) > 0) {
            rootNode.right = insert(rootNode.right, data);
        }

        return root;
    }

    public boolean search(Node<T> rootNode, T data) {
        if (rootNode == null) {
            return false;
        }

        if (data.compareTo(rootNode.data) == 0) {
            return true;
        }

        if (data.compareTo(rootNode.data) < 0) {
            return search(rootNode.left, data);
        } else {
            return search(rootNode.right, data);
        }
    }

    public void inOrderTraversal(Node<T> rootNode) {
        if (rootNode == null) {
            return;
        }
        
        inOrderTraversal(rootNode.left);
        System.out.println(rootNode.data + " ");
        inOrderTraversal(rootNode.right);
    }

    public void preOrderTraversal(Node<T> rootNode) {
        if(rootNode == null){
            return;
        }
        
        System.out.println(rootNode.data + " ");
        preOrderTraversal(rootNode.left);
        preOrderTraversal(rootNode.right);
    }
    
    public void postOrderTraversal(Node<T> rootNode){
        if(rootNode == null){
            return;
        }
        
        postOrderTraversal(rootNode.left);
        postOrderTraversal(rootNode.right);
        System.out.println(rootNode.data + " ");
    }
}
