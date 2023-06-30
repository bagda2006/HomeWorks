package Upgrade_Level.Lesson6;


public class MyQueue {
    int size;
    int items[];
    int front, rear;

    public MyQueue(int size) {
        this.size = size;
        items = new int[this.size];
        front = -1;
        rear = -1;
    }

    public static void quickSort(int[] source, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = source[(leftMarker + rightMarker) / 2];

        do {
            while (source[leftMarker] < pivot) {
                leftMarker++;
            }

            while (source[rightMarker] > pivot) {
                rightMarker--;
            }
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    int tmp = source[leftMarker];
                    source[leftMarker] = source[rightMarker];
                    source[rightBorder] = tmp;
                }

                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);
        if (leftMarker < rightBorder) {
            quickSort(source, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSort(source, leftBorder, rightMarker);
        }
    }

    private boolean isFull() {
        if (front == 0 && rear == size - 1) {
            return true;
        }
        return false;
    }

    private boolean isEmpty() {
        if (front == -1) {
            return true;
        }
        return false;
    }

    public void enQueue(int element) {
        if (isFull()) {
            System.out.println("Очередь заполнена");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear++;
            items[rear] = element;
            quickSort(items,front,rear);
            System.out.println("Добавлен элемент " + element);
        }
    }

    public int deQueue() {
        int element;
        if (isEmpty()) {
            System.out.println("Очередь пустая");
            return (-1);
        } else {
            element = items[front];
            if (front >= rear) {
                front = -1;
                rear = -1;
            } else {
                front++;
            }
            System.out.println("Удален элемент " + element);
            return element;
        }
    }

    public void display() {
        int i;
        if (isEmpty()) {
            System.out.println("Очередь пустая");
        } else {
            System.out.println("Индекс FRONT " + front);
            System.out.println("Элементы ->");
            for (i = front; i <= rear; i++) {
                System.out.println(items[i] + " ");
            }
            System.out.println("Индекс REAR " + rear);
        }
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue(5);
        q.deQueue();
        q.enQueue(4);//добавление элемента в очередь
        q.enQueue(51);
        q.enQueue(16);
        q.enQueue(73);
        q.enQueue(8);
        q.deQueue();//удаление элемента
        q.display();
    }
}
