/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbol;

/**
 *
 * @author Familia
 */
public class Node<T extends Comparable<T>> {
    T data;
    Node left;
    Node right;
    
    public Node(T value){
        data = value;
        left = null;
        right = null;
    }
}
