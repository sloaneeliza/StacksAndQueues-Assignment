import java.util.Deque;
import java.util.LinkedList;

public class Question3 {
    public static int findPosition(Deque<Integer> deque, int x) {
        Integer[] arr = deque.toArray(new Integer[0]);

        int frontIndex = 0;
        int backIndex = arr.length - 1;

        while (frontIndex <= backIndex) {
            if (arr[frontIndex] == x) {
                return frontIndex;
            }
            if (arr[backIndex] == x) {
                return backIndex;
            }
            frontIndex++;
            backIndex--;
        }
        return -1; 
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.add(10);
        deque.add(20);
        deque.add(30);
        deque.add(40);
        deque.add(50);
        deque.add(60);
        deque.add(70);
        deque.add(80);

        int x = 50;
        int position = findPosition(deque, x);
        System.out.println("Element " + x + " is at index: " + position);
    }
}
