package _2_juc._3_atomics;

import java.util.concurrent.atomic.AtomicReference;

public class TraiberStack<E> {
    private AtomicReference<Node<E>> tail = null;

    public void push(E elem) {
//        tail = new Node<>(elem, tail?);
        Node<E> newTail = new Node<>(elem, null);
        while (true) {
            Node<E> oldTail = tail.get();
            newTail.next = oldTail;
            if (tail.compareAndSet(oldTail, newTail)) {
                break;

            }
        }
    }

    public E pop() {
//        E result = tail.value;
//        tail = tail.next;
//        return result;
        while (true) {
            Node<E> oldTail = tail.get();
            Node<E> newTail = oldTail.next;
            if (tail.compareAndSet(oldTail, newTail)) {
                return oldTail.value;
            }
        }
    }

    private static class Node<E> {
        E value;
        Node<E> next;

        private Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }
}
