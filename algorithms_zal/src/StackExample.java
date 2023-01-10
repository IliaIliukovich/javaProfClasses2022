import java.util.EmptyStackException;

public class StackExample {

    public static void main(String[] args) {
    }

    private static class IntStack {
        private final int capacity;
        private final int[] data;
        private int top;

        public IntStack(int size) {
            data = new int[size];
            capacity = size;
            top = -1;
        }

        public void push(int value) {
            if (isFull()) {
                throw new StackOverflowError();
            }
            data[++top] = value;
        }

        public int pop() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            return data[top--];
        }

        public int peek() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            return data[top];
        }

        public int search(int element) {
            for (int i = top; i >= 0; i--) {
                if (element == data[i]) {
                    return top - i;
                }
            }
            return -1;
        }

        public Boolean isEmpty() {
            return top == -1;
        }

        public Boolean isFull() {
            return top == capacity - 1;
        }

        public void printStack() {
            System.out.print("[ ");
            for (int i = 0; i <= top; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.print("]\n");
        }
    }
}
