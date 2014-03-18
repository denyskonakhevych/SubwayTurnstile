package myutil;

public class MyLinkedList<E> {

	private int size = 0;
	
	private Node<E> first;
	
	private Node<E> last;
	
	public void add(E e) {
		
		final Node<E> lastBeforeAddition = last;
		final Node<E> newNode = new Node<>(lastBeforeAddition, e, null);
		
		last = newNode;
		if (lastBeforeAddition == null) {
			first = newNode;
		} else {
			lastBeforeAddition.next = newNode;
		}
		size++;
	}
	
	public void add(MyLinkedList<E> list) {
		if (list == null) {
			throw new IllegalArgumentException("Wrong collection type: " + list);
		}
		for (int index = 0; index < list.size(); index++) {
			add(list.get(index));
		}
	}
	
	public void add(int index, E e) {
		if (size == 0 && index == 0) {
			add(e);
			size++;
			return;
		}
		checkElementIndex(index);
		Node<E> elem = getNode(index);
		final Node<E> prev = elem.prev;
		final Node<E> newNode = new Node<>(prev, e, elem);
		elem.prev = newNode;
		if (prev == null) {
			first = newNode;
		} else {
			prev.next = newNode;
		}
		size++;
	}
	
	public void remove(int index) {
		checkElementIndex(index);
		Node<E> elem = getNode(index);
		final Node<E> predecessor = elem.prev;
		final Node<E> successor = elem.next;
		
		if (predecessor == null) {
			first = successor;
		} else {
			predecessor.next = successor;
			elem.prev = null;
		}
		if (successor == null) {
			last = predecessor;
		} else {
			successor.prev = predecessor;
			elem.next = null;
		}
		elem.item = null;
		size--;
	}
	
	public boolean remove(Object o) {
		if (o == null) {
			int index = 0;
            for (Node<E> current = first; current != null; current = current.next) {
                if (current.item == null) {
                	remove(index);
                	return true;
                }
                index++;
            }
        } else {
        	int index = 0;
        	for (Node<E> current = first; current != null; current = current.next) {
                if (o.equals(current.item)) {
                	remove(index);
                	return true;
                }
                index++;
            }
        }
		return false;
	}
	
	public E get(int index) {
		Node<E> node = getNode(index);
		return node.item;
	}
	
	public void set(int index, E item) {
		checkElementIndex(index);
		Node<E> node = getNode(index);
		node.item = item;
	}
	
	public Node<E> getNode(int index) {
		checkElementIndex(index);
		if(index < (size >> 1)) {
			Node<E> elem = first;
			for (int i = 0; i < index; i++) {
				elem = elem.next;
			}
			return elem;
		} else {
			Node<E> elem = last;
			for (int i = size - 1; i > index; i--) {
				elem = elem.prev;
			}
			return elem;
		}
	}
	
	private void checkElementIndex(int index) {
		if (!(index >= 0 && index < size)) {
			throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
		}
	}
	
	public int size() {
        return size;
    }
	
	private static class Node<E> {
		Node<E> prev;
        E item;
        Node<E> next;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
