package com.lbh.tree;

/**
 * @Description: 哈夫曼树
 * @Author lbh
 * @Date 2020/4/5 23:42
 * @Version V1.0
 **/
public class HuffmanTree {


    public class Node<E> {
        private E data;
        private double weight;
        Node left, right;

        public Node(E data, double weight) {
            this.data = data;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", weight=" + weight +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
