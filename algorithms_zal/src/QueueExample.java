public class QueueExample {

    public static void main(String[] args) {
    }

    private static class IntQueue {
        private final int[] data;
        private int headIndex;
        private int tailIndex;

        public IntQueue(int size) {
            data = new int[size];
            headIndex = -1;
            tailIndex = -1;
        }

        boolean isFull() {
            return headIndex == 0 && tailIndex == data.length - 1;
        }

        boolean isEmpty() {
            return headIndex == -1;
        }

        void addToTail(int element) {
            if (isFull()) {
                throw new RuntimeException("Queue is full");
            }
            if (headIndex == -1) {
                headIndex = 0;
            }
            tailIndex++;
            data[tailIndex] = element;

        }

        public int removeFromHead() {
            if (isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            int element = data[headIndex];
            if (headIndex >= tailIndex) {
                headIndex = -1;
                tailIndex = -1;
            } else {
                headIndex++;
            }
            return element;
        }

        public void printElements() {
            if (isEmpty()) {
                System.out.println("[ ]");
            } else {
                System.out.print("[ ");
                for (int i = headIndex; i <= tailIndex; i++) {
                    System.out.print(data[i] + " ");
                }

                System.out.print("]\n");
            }
        }
    }
}
