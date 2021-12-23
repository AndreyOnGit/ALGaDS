package lesson4;

import lombok.NoArgsConstructor;

import java.util.Iterator;

public class SimpleLinkedListImpl<E> implements LinkedList<E>, Iterable<E> {

    protected int size;
    protected Node<E> first;

    @Override
    public void insertFirst(E value) {
        first = new Node<>(value, first);

/*        Node<E> actualFirst = first;
        Node<E> newFirst = new Node<>(value, actualFirst);
        this.first = newFirst;*/

        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node<E> removedNode = first;
        first = removedNode.next;
        removedNode.next = null;
        size--;

        return removedNode.item;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = first;
        Node<E> prev = null;

        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            prev = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        } else if (current == first) {
            removeFirst();
            return true;
        }

        prev.next = current.next;
        current.next = null;
        size--;

        return true;
    }

    @Override
    public boolean contains(E value) {
        Node<E> current = first;
        while (current != null) {
            if (current.item.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = first;

        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }

        return sb.append("]").toString();
    }

    @Override
    public E getFirst() {
        return first.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator<E>(this);
    }

    private class ListIterator<E> implements Iterator<E> {
        private SimpleLinkedListImpl<E> simpleLinkedList;
        private Node<E> current;


        private ListIterator(SimpleLinkedListImpl<E> simpleLinkedList) {
            this.simpleLinkedList = simpleLinkedList;
            this.current = new Node<>(null, simpleLinkedList.first);
        }

        @Override
        public boolean hasNext() {
            if (current.next != null)
                return true;
            else
                return false;
        }

        @Override
        public E next() {
            current = current.next;
            return current.item;
        }
    }

    public void insert(E value, int index) {
        Node<E> current = first;
        Node<E> prev = null;
        int counter = 0;

        if (index < 0 || index > size) throw new IndexOutOfBoundsException();

        if (index == size) {
            current = get(size-1);
            current.next = new Node<>(value, null);
            size++;
            return;
        }

        while (counter != index) {
            counter++;
            if (current == null)
                break;
            prev = current;
            current = current.next;
        }
        if (index == 0) insertFirst(value);
        else {
            prev.next = new Node<>(value, current);
            size++;
        }
    }

    public Node get (int index){
        Node<E> current = first;
        int counter = 0;

        if (index < 0 || index > size-1) throw new IndexOutOfBoundsException();

        while (counter != index) {
            counter++;
            if (current == null)
                break;
            current = current.next;
        }
        return current;
    }
}
