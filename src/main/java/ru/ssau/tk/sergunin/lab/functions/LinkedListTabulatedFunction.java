package ru.ssau.tk.sergunin.lab.functions;

public class LinkedListTabulatedFunction extends AbstractTabulatedFunction {
    private Node head;
    private Node last;

    private class Node {
        public int index;
        public Node next;
        public Node prev;
        public double x;
        public double y;

    }

    void addNode(double x, double y) {
        Node newNode = new Node();
        if (head == null) {
            head = newNode;
            newNode.next = head;
            newNode.prev = head;
            newNode.x = x;
            newNode.y = y;
            last = newNode;
            newNode.index = 0;
        } else {
            newNode.next = head;
            newNode.prev = last;
            head.prev = newNode;
            last.next = newNode;
            newNode.x = x;
            newNode.y = y;
            last = newNode;
            newNode.index++;
        }
    }

    public LinkedListTabulatedFunction(double[] xValues, double[] yValues) {
        for (int i = 0; i < xValues.length; i++) {
            this.addNode(xValues[i], yValues[i]);
        }
    }

    public LinkedListTabulatedFunction(MathFunction source, double xFrom, double xTo, int count) {

        if (xFrom > xTo) {
            xFrom = xFrom - xTo;
            xTo = xFrom + xTo;
            xFrom = -xFrom + xTo;
        }
        double buff = xFrom;
        for (int i = 0; i < (count + 1); i++) {
            this.addNode(buff, source.apply(buff));
            buff += (xTo - xFrom) / count;
        }
        ;
    }

    int getCount() {
        return last.index;
    }

    Node leftBound() {
        return head;
    }

    Node rightBound() {
        return last;
    }

    Node getNode(int index) {
        if (index > (getCount() / 2)) {
            Node buff = last;
            for (int i = getCount() + 1; i > 0; i--) {
                if (buff.index == i) {
                    return buff;
                } else {
                    buff = buff.prev;
                }
            }
        } else {
            Node buff = head;
            for (int i = 0; i < (index + 1); i++) {
                if (buff.index == i) {
                    return buff;
                } else {
                    buff = buff.next;
                }
            }
        }
        return null;
    }

    double getX(int index) {
        return getNode(index).x;
    }

    double getY(int index) {
        return getNode(index).y;
    }

    void setY(int index, double value) {
        getNode(index).y = value;
    }

    int indexOfX(double x) {
        Node buff = head;
        for (int i = 0; i <= getCount(); i++) {
            if (buff.x == x) {
                return buff.index;
            } else {
                buff = buff.next;
            }
        }
        return -1;
    }

    int indexOfY(double y) {
        Node buff = head;
        for (int i = 0; i <= getCount(); i++) {
            if (buff.y == y) {
                return buff.index;
            } else {
                buff = buff.next;
            }
        }
        return -1;
    }
}