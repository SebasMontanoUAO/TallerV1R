/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbol;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.lang.reflect.Type;

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
            postOrderTraversalToString(rootNode.left, recorrido);
            postOrderTraversalToString(rootNode.right, recorrido);
            recorrido.append(rootNode.data.toString()).append("");
        }
    }

    public static <T extends Comparable<T>> TreeNodeJson<T> convertToJsonStructure(Node<T> rootNode) {
        if (rootNode == null) {
            return null;
        }

        TreeNodeJson<T> jsonNode = new TreeNodeJson<>(rootNode.data);
        jsonNode.setLeft(convertToJsonStructure(rootNode.left));
        jsonNode.setRight(convertToJsonStructure(rootNode.right));

        return jsonNode;
    }

    public static <T extends Comparable<T>> void saveTreeToJson(Node<T> root, String filePath) {
        // Convertir el árbol a una estructura JSON
        TreeNodeJson<T> jsonRoot = convertToJsonStructure(root);

        // Crear una instancia de Gson
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Convertir a JSON
        String json = gson.toJson(jsonRoot);

        // Guardar el JSON en un archivo
        try (java.io.FileWriter writer = new java.io.FileWriter(filePath)) {
            writer.write(json);
            System.out.println("Árbol guardado en: " + filePath);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public static <T extends Comparable<T>> Node<T> loadTreeFromJson(String filePath, Class<T> clase) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
            // Definir el tipo genérico para Gson
            Type type = TypeToken.getParameterized(TreeNodeJson.class, clase).getType();

            // Leer el JSON y convertirlo a TreeNodeJson
            TreeNodeJson<T> jsonRoot = gson.fromJson(reader, type);

            // Convertir TreeNodeJson a Node<T>
            return convertFromJsonStructure(jsonRoot);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static <T extends Comparable<T>> Node<T> convertFromJsonStructure(TreeNodeJson<T> jsonNode) {
        if (jsonNode == null) {
            return null;
        }

        // Crear el nodo actual
        Node<T> node = new Node<>(jsonNode.getData());

        // Convertir los hijos recursivamente
        node.left = convertFromJsonStructure(jsonNode.getLeft());
        node.right = convertFromJsonStructure(jsonNode.getRight());

        return node;
    }
}
