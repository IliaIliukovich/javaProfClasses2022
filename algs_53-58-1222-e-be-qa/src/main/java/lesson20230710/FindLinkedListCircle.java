package lesson20230710;

public class FindLinkedListCircle {

// Определить, содержит ли связанный список цикл

    static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // Функция для обнаружения цикла в связанном списке с использованием
    // Алгоритм обнаружения циклов Флойда
    public static boolean detectCycle(Node head) {

    // взять две ссылки — `slow` и `fast`
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            // двигаться медленнее на один
            slow = slow.next;

            // двигаться быстрее на два
            fast = fast.next.next;

            // если они встречаются с каким-либо узлом, связанный список содержит цикл
            if (slow == fast) {
                return true;
            }
        }

        // мы доходим сюда, если медленное и быстрое не встречаются
        return false;
    }

    public static void main(String[] args) {
        // ключи ввода
        int[] keys = { 1, 2, 3, 4, 5 };

        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }

        // вставить цикл
        head.next.next.next.next.next = head.next.next;

        if (detectCycle(head)) {
            System.out.println("Cycle Found");
        }
        else {
            System.out.println("No Cycle Found");
        }
    }

}
