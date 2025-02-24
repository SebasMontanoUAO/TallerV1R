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

    public static <T extends Comparable<T>> Node<T> insert(Node<T> rootNode, T data) {
        if (rootNode == null) {
            return new Node(data);
        }

        if (data.compareTo(rootNode.data) < 0) {
            rootNode.left = insert(rootNode.left, data);
        } else if (data.compareTo(rootNode.data) > 0) {
            rootNode.right = insert(rootNode.right, data);
        }

        return rootNode;
    }

    public static <T extends Comparable<T>> Node<T> search(Node<T> rootNode, T data) {
        if (rootNode == null || rootNode.data == data) {
            return rootNode;
        }

        if (data.compareTo(rootNode.data) < 0) {
            return search(rootNode.left, data);
        }

        return search(rootNode.right, data);
    }

    public static <T extends Comparable<T>> String inOrderTraversal(Node<T> rootNode) {
        StringBuilder recorrido = new StringBuilder();
        inOrderTraversalToString(rootNode, recorrido);
        return recorrido.toString();
    }

    private static <T extends Comparable<T>> void inOrderTraversalToString(Node<T> rootNode, StringBuilder recorrido) {
        if (rootNode != null) {
            inOrderTraversalToString(rootNode.left, recorrido);
            recorrido.append(rootNode.data.toString()).append("");
            inOrderTraversalToString(rootNode.right, recorrido);
        }
    }

    public static <T extends Comparable<T>> String preOrderTraversal(Node<T> rootNode) {
        StringBuilder recorrido = new StringBuilder();
        preOrderTraversalToString(rootNode, recorrido);
        return recorrido.toString();
    }

    private static <T extends Comparable<T>> void preOrderTraversalToString(Node<T> rootNode, StringBuilder recorrido) {
        if (rootNode != null) {
            recorrido.append(rootNode.data.toString()).append("");
            preOrderTraversalToString(rootNode.left, recorrido);
            preOrderTraversalToString(rootNode.right, recorrido);
        }
    }

    public static <T extends Comparable<T>> String postOrderTraversal(Node<T> rootNode) {
        StringBuilder recorrido = new StringBuilder();
        postOrderTraversalToString(rootNode, recorrido);
        return recorrido.toString();
    }
    
    private static <T extends Comparable<T>> void postOrderTraversalToString(Node<T> rootNode, StringBuilder recorrido) {
        if (rootNode != null) {
            recorrido.append(rootNode.data.toString()).append("");
            postOrderTraversalToString(rootNode.left, recorrido);
            postOrderTraversalToString(rootNode.right, recorrido);
        }
    }
}
