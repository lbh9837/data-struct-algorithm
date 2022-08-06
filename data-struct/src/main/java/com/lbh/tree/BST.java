package com.lbh.tree;

/**
 * @Description: TODO
 * @Author lbh
 * @Date 2020/3/14 21:13
 * @Version V1.0
 **/
public class BST<E extends Comparable<E>> {

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    private class Node {
        private E e;
        private Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    public void add(E e) {
        root = add(root, e);
    }

    public Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        } else if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    public Node remove(Node node, E e) {
        //找到被删除节点
        Node tmpCell;
        if (node == null) {
            return null;
        }
        if ((e.compareTo(node.e)) < 0) {
            node.left = remove(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
        }
        //找到节点
        // 如果节点有两个子节点
        else if (node.left != null && node.right != null) {
            //找到右子树中最小的节点
            tmpCell = findMin(node.right);
            //把当前节点的值改为右子树中最小的节点的值
            node.e = tmpCell.e;
            //删除右子树中最小的节点
            node.right = remove(node.right, node.e);
        }//只有一个或者零个字节点
        else {
            if (node.left == null) {
                node = node.right;
                if (node != null) {
                    node.right = null;
                }
            } else if (node.right == null) {
                node = node.left;
                node.left = null;
            }
            size--;
        }
        return node;
    }

    //前序遍历
    public void preOrder() {
        preOrder(root);
    }

    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.e);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public Node findMin(Node node) {
        if (node == null) {
            return null;
        } else if (node.left == null) {
            return node;
        } else {
            return findMin(node.left);
        }
    }

    public Node findMax(Node node) {
        Node maxNode = node;
        if (maxNode != null) {
            while (maxNode.right != null) {
                maxNode = maxNode.right;
            }
        }
        return maxNode;
    }

    public int size() {
        return size;
    }

    public Node test(Node node) {
        node = null;
        return node;
    }

    public static void main(String[] args) {
        BST bst = new BST<Integer>();
        int[] arr = {1, 5, 4, 3, 2, 6};
        for (int i = 0; i < arr.length; i++) {
            bst.add(arr[i]);
        }
        bst.preOrder();
        System.out.println("----size: " + bst.size());
        bst.remove(5);
        bst.preOrder();
        System.out.println("------" + bst.size());
    }
}
