package Upgrade_Level.Lesson4;

import java.sql.SQLOutput;

public class MyTreeMap<K,V> {
    private class Node{
        public K key;//ключ
        public V value;//значение
        public Node left;//левый элемент/левая ветка
        public Node right;//правый элемент/правая ветка

        public Node(K key,V value){//сам элемент хранящийся по типу ключ/значение и какие элементы от него идут
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private int size = 0;
    private Node root = null;
//ищем ноду через ключ
    private Node findNode(Object key){
        Node curNode = root;
        Comparable<K> cKey = (Comparable<K>) key;

        while(curNode != null){
            //cmp - результат от compareTo
            int cmp = cKey.compareTo(curNode.key);
            if(cmp < 0){
                curNode = curNode.left;
            }
            if(cmp > 0){
                curNode = curNode.right;
            }
            if(cmp == 0){
                return curNode;
            }
        }
        return null;
    }

    private Node findParents(Object key){
        Comparable<K> cKey =(Comparable<K>) key;
        Node child = null;
        Node parent = null;
        while(child != null){
            int cmp = cKey.compareTo(child.key);
            if(cmp < 0){
                parent = child;
                child = child.left;
            }
            if(cmp > 0){
                parent = child;
                child = child.right;
            }
            if(cmp == 0){
                return parent;
            }
        }
        return null;
    }

    //Геттер для ноды
    public V get(Object key){
        Node curNode = findNode(key);
        if (curNode == null) return null;
        return curNode.value;
    }
    //добавление элемента
    public V put(K key,V value){
        if(root == null){
            root = new Node(key,value);
            size++;
            return null;
        }
        return putHelper(key,value,root);
    }
    //добавление элемента апгрейд
    private V putHelper(K key,V value,Node node){
        Comparable<K> cKey = (Comparable<K>) key;
        int cmp = cKey.compareTo(node.key);
        if(cmp < 0){
            if(node.left == null){
                node.left = new Node(key,value);
                size++;
                return null;
            }
            return putHelper(key,value,node.left);
        }
        if(cmp > 0){
            if(node.right == null){
                node.right = new Node(key,value);
                size++;
                return null;
            }
            return putHelper(key,value,node.right);
        }
        if(cmp == 0){
            V oldValue = node.value;
            node.value = value;
            return oldValue;
        }
        return null;
    }

    public V remove(Object key){
        Node child = findNode(key);
        if(child == null) return null;
        if(size == 1){
            root = null;
            size++;
            return child.value;
        }
        Node parent = findParents(key);
        if (child.left != null && child.right != null){
            Node preemnik = findPreemnik(child.right);
            Node preParent = findParents(preemnik.key);
            removeHelper(preemnik,parent);
            child.key = preemnik.key;
            V oldValue = child.value;
            child.value = preemnik.value;
            return oldValue;
        }else{
            return removeHelper(child,parent);
        }
    }
    private V removeHelper(Node child,Node parent){
        if(child.left == null && child.right == null){
            if(parent.left == child) parent.left = null;
            if(parent.right == child) parent.right = null;
            size--;
            return child.value;
        }
        if(child.right == null){
            if(parent.left == child) parent.left = child.left;
            if(parent.right == child) parent.right = child.left;
            size--;
            return child.value;
        }
        if(child.left == null){
            if(parent.left == child) parent.left = child.right;
            if(parent.right == child) parent.right = child.right;
            size--;
            return child.value;
        }
        return null;
    }
    private Node findPreemnik(Node node){
        while (node.left != null){
            node = node.left;
        }
        return node;
    }
    public void printTree(){
        if(root == null){
            System.out.println("Tree is empty");
        }
        System.out.println("Root is " + root.value);
        LER(root);
    }
    private void LER(Node node){
        if(node.left != null) LER(node.left);
        System.out.println(node.value);
        if(node.right != null) LER(node.right);
    }
}
