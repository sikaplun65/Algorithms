package Lesson6;

import lombok.Data;

@Data
public class Node <T extends Comparable<? super T>>{
    private final T value;
    private Node<T> leftChild;
    private Node<T> rightChild;

    public Node(T value) {
        this.value = value;
    }

    public boolean isLeftChild(T value) {
        return value.compareTo(getValue()) < 0;
    }

    public boolean isList() {
        return leftChild == null && rightChild == null;
    }

    public boolean hasOnlyOneChild() {
//        return (leftChild != null && rightChild == null) || (leftChild == null && rightChild != null);
        return leftChild != null ^ rightChild != null;
    }
}
