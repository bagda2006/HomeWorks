package Upgrade_Level.Lesson2;

public class ClassWork2 {
    public static class MyArrayList<E>{
        private E[] array;

        private int size;

        public MyArrayList(){
            this.array = (E[]) new Object[10];
            this.size = 0;
        }
        //Добавление в конец элемента
        public boolean add(E element){
            if(size == array.length){
            E[] bigger = (E[]) new Object[array.length*2];
                for(int i = 0; i <array.length; i++){
                    bigger[i] = array[i];
                }
                array = bigger;
            }
            array[size] = element;
            size++;
            return true;
        }
        //Добавление элемента по индексу
        public void add(int index, E element){
            if (index < 0  || index > size){
                throw new ArrayIndexOutOfBoundsException();
            }
            add(element);
            for (int i = size-1; i > index; i--) {
                array[i] = array[i-1];
            }
            array[index] = element;
        }
        //возвращение элемента по индексу
        public E get(int index){
            if (index < 0  || index >= size){
                throw new ArrayIndexOutOfBoundsException();
            }
            return array[index];
        }
        //возвращение индекса по элементу
        public int indexOf(Object element){
            for(int i = 0;i < size;i++){
                if(array[i].equals(element)){
                    return 1;
                }
            }
            return -1;
        }
        //удаление элемента по индексу
        public E remove(int index){
            if (index < 0  || index > size){
                throw new ArrayIndexOutOfBoundsException();
            }
            E temp = array[index];
            for(int i = index;i < size - 1;i++){
                array[i] = array[i+1];
            }
            size--;
            return temp;
        }
        //удаление по элементу
        public boolean remove(Object obj){
            int index = indexOf(obj);
            if (index ==  -1){
                return false;
            }
            remove(index);
            return true;
        }
        public String toString(){
            String str = "[";
            for (int i = 0; i < size-1; i++) {
                str = str + array[i] + ", ";
            }
            str = str + array[size-1] + "]";
            return str;
        }
    }
    public static class MyList<E>{
        private class Node{
            public E element;
            public Node next;
            public Node(E element){
                this.element = element;
                next = null;
            }
            public Node(E element, Node next){
                this.element = element;
                this.next = next;
            }
        }
        private int size;
        private Node head;

        public MyList(){
            this.size = 0;
            this.head = null;
        }
       private Node getNode(int index){
            if(index < 0 || index >= size){
                throw new IndexOutOfBoundsException();
            }
            Node currentNode = head;
            for(int i = 0; i < index; i++){
                currentNode = currentNode.next;
            }
            return currentNode;
       }
        //Добавление
       public boolean add(E element){
            //Добавление в пустой список
           Node currentNode = head;
           for (; currentNode.next != null; currentNode = currentNode.next) {
                //Загадка
           }
           currentNode.next = new Node(element);
           return  true;
       }
       //Добавление по индексу
        public void add(int index,E element){
            //Добавление в пустой список
            Node currentNode = getNode(index - 1);
            Node newNode = new Node(element, currentNode.next);
            currentNode.next = newNode;
        }
    }
}
