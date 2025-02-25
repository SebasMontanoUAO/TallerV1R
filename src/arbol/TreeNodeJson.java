/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbol;

/**
 *
 * @author Familia
 */
public class TreeNodeJson<T extends Comparable<T>> {
    private T data;
    private TreeNodeJson<T> left;
    private TreeNodeJson<T> right;

    public TreeNodeJson(T data) {
        this.data = data;
    }
    
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeNodeJson<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNodeJson<T> left) {
        this.left = left;
    }

    public TreeNodeJson<T> getRight() {
        return right;
    }

    public void setRight(TreeNodeJson<T> right) {
        this.right = right;
    }
}
