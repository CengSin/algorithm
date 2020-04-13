package com.company.simple.datastruct;

/**
 * @description: JDK linkedlist 双向链表实现
 * @author: 15262
 * @date: 2020/4/13
 */

public class LinkedList<E> {

    int size = 0;

    Node<E> first;

    Node<E> last;

    public LinkedList() {
    }

    public int size() {
        return this.size;
    }

    /**
     * 新增一个元素到链表结尾
     *
     * @param e 新增元素
     * @return 是否添加成功
     */
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    /**
     * 在指定位置添加元素，如果指定位置不为空，则将该位置以及之后的元素往后移
     *
     * @param index   元素下标
     * @param element 要新增的元素
     * @return 是否新增成功
     */
    public boolean add(int index, E element) {
        checkPositionIndex(index);

        if (index == size) {
            linkLast(element);
        } else {
            linkedBefore(element, node(index));
        }
        return true;
    }

    /**
     * 连接到前一个元素
     * @param element 新的元素值
     * @param succ 后驱节点
     */
    private void linkedBefore(E element, Node<E> succ) {
        final Node<E> pred = succ.pre;
        final Node<E> newNode = new Node<>(element, succ, pred);
        succ.pre = newNode;
        if (pred == null) {
            first = newNode;
        } else {
            pred.next = newNode;
        }
        size++;
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) throw new IndexOutOfBoundsException("index " + index + " size " + size);
    }

    private boolean isPositionIndex(int index) {
        return 0 <= index && index <= size;
    }

    /**
     * 删除首个出现的指定元素
     *
     * @param o 要删除的元素
     * @return 删除成功 true 删除失败 false
     */
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 删除指定下标的元素
     *
     * @param index 元素下标
     * @return 是否删除成功的boolean
     */
    public E remove(int index) {
        checkElementIndex(index);
        return unlink(node(index));
    }

    public E set(int index, E element) {
        checkElementIndex(index);
        Node<E> x = node(index);
        E oldVale = x.item;
        x.item = element;
        return oldVale;
    }

    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    private Node<E> node(int index) {
        Node<E> x;
        if (index < (size >> 1)) {
            x = this.first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
        } else {
            x = this.last;
            for (int i = size - 1; i > index; i--) {
                x = x.pre;
            }
        }
        return x;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) throw new IndexOutOfBoundsException("index " + index + " size " + size);
    }

    private boolean isElementIndex(int index) {
        return 0 <= index && index < size;
    }

    private E unlink(Node<E> x) {
        Node<E> pre = x.pre;
        Node<E> next = x.next;
        E item = x.item;

        if (pre == null) {
            first = next;
        } else {
            pre.next = next;
            x.pre = null;
        }

        if (next == null) {
            last = pre;
        } else {
            next.pre = pre;
            x.next = null;
        }

        x.item = null;
        size--;
        return item;
    }

    void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(e, null, l);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    /**
     * LinkedList节点数据结构
     *
     * @param <E> 存储数据类型
     */
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> pre;

        public Node(E item, Node<E> next, Node<E> pre) {
            this.item = item;
            this.next = next;
            this.pre = pre;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node<E> x = first; x != null; x = x.next) {
            sb.append(x.item).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        list.set(2, 5);
        System.out.println(list);
        System.out.println(list.get(2));
        System.out.println(list.size);
    }

}
