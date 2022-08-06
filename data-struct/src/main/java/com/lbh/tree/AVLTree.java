package com.lbh.tree;

import java.time.OffsetDateTime;

/**
 * @Description: TODO
 * @Author lbh
 * @Date 2020/3/14 21:13
 * @Version V1.0
 **/
public class AVLTree<E extends Comparable<E>> {

    private Node root;
    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }

    private class Node {
        private int height;
        private E e;
        private Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
            height = 1;
        }
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    public void add(E e) {
        root = add(root, e);
    }

    public Node add(Node node, E e) {
        if (node == null) {
            size++;
            node = new Node(e);
        } else if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
            if (height(node.left) - height(node.right) == 2) {
                if (e.compareTo(node.left.e) < 0) {
                    node = rightRotate(node);
                } else {
                    node = DoubleRightRotate(node);
                }
            }
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
            if (height(node.right) - height(node.left) == 2) {
                if (e.compareTo(node.right.e) > 0) {
                    node = leftRotate(node);
                } else {
                    node = DoubleLeftRotate(node);
                }
            }
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    public Node remove(Node node, E e) {
        Node tmpCell;
        if (node == null) {
            return null;
        }
        if ((e.compareTo(node.e)) < 0) {
            node.left = remove(node.left, e);
            if (height(node.right) - height(node.left) == 2) {
                if (height(node.right.right) >= height(node.right.left)) {
                    node = leftRotate(node);
                } else {
                    node = DoubleLeftRotate(node);
                }
            }
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            if (height(node.left) - height(node.right) == 2) {
                if (height(node.left.left) >= height(node.left.right)) {
                    node = rightRotate(node);
                } else {
                    node = DoubleRightRotate(node);
                }
            }
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
        if (node != null) {
            node.height = Math.max(height(node.left), height(node.right)) + 1;
        }
        return node;
    }

    public int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return Math.abs(height(node.left) - height(node.right));
    }

    //左转
    public Node leftRotate(Node k2) {
        Node k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        return k1;
    }

    //右转
    public Node rightRotate(Node k2) {
        Node k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        return k1;
    }

    //双旋转
    public Node DoubleLeftRotate(Node k3) {
        k3.right = rightRotate(k3.right);
        return leftRotate(k3);
    }

    public Node DoubleRightRotate(Node k3) {
        k3.left = leftRotate(k3.left);
        return rightRotate(k3);
    }

    //前序遍历
    public void preOrder() {
        preOrder(root);
    }

    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.e + " ");
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

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        AVLTree bst = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            bst.add(arr[i]);
        }
        bst.preOrder();
        System.out.println("size: " + bst.size());
        System.out.println("height: " + bst.root.height);

        bst.remove(1);
        bst.remove(5);
        bst.preOrder();
        System.out.println("size: " + bst.size());
        System.out.println("height: " + bst.root.height);

    }

}
