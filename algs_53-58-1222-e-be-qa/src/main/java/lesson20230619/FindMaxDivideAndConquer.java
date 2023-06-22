package lesson20230619;

public class FindMaxDivideAndConquer {

    public static void main(String[] args) {
        int[] ints = new int[] {0, 10, 22, 0, 1300, 14, 40, 21, 3000, 150};
        System.out.println(findMax(ints, 0));
    }

    private static int findMax(int[] ints, int currentInd) {
        if (currentInd == ints.length) return 0;
        return Math.max(ints[currentInd], findMax(ints, currentInd + 1));
    }

    private static int findMaxInLoop(int[] ints) {
        int tmpMax = ints[0];
        for (int i = 1; i < ints.length; i++) {
            tmpMax = Math.max(tmpMax, ints[i]);
        }
        return tmpMax;
    }




}
