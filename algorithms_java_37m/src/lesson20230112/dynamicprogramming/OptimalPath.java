package lesson20230112.dynamicprogramming;

public class OptimalPath {


    public static void main(String[] args) {
        int[][] costs = new int[][] {
                {9, 2, 4, 1, 6, 0, 1, 6, 0, 1, 6, 0},
                {9, 2, 4, 1, 6, 0, 1, 6, 0, 1, 6, 0},
                {9, 2, 4, 1, 6, 0, 1, 6, 0, 1, 6, 0},
                {9, 2, 4, 1, 6, 0, 1, 6, 0, 1, 6, 0},
                {9, 2, 4, 1, 6, 0, 1, 6, 0, 1, 6, 0},
                {9, 2, 4, 1, 6, 0, 1, 6, 0, 1, 6, 0},
                {9, 2, 4, 1, 6, 0, 1, 6, 0, 1, 6, 0}
        };

        System.out.println(minimalCost(costs, 0, 0));
        System.out.println(minimalCostMemo(costs));

    }

    private static int minimalCost(int[][] costs, int i, int j) {
        if (i >= costs.length || j >= costs[0].length) return 1000000;
        if (i == costs.length - 1 && j == costs[0].length - 1) return costs[i][j];
        int minCost = costs[i][j] + Math.min(minimalCost(costs, i + 1, j), minimalCost(costs, i, j + 1));
        return minCost;
    }

    private static int minimalCostMemo(int[][] costs) {
        // cache array init
        int[][] minCache = new int[costs.length][costs[0].length];
        for (int i = 0; i < costs.length; i++) {
            for (int j = 0; j < costs[0].length; j++) {
                minCache[i][j] = -1;
            }
        }
        return minCostMemo(costs, minCache, 0, 0);
    }

    private static int minCostMemo(int[][] costs, int[][] minCache, int i, int j) {
        // some big number to avoid going beyond the boundaries of the array
        if (i >= costs.length || j >= costs[0].length) return 100000;
        // check if the min cost value present in cache
        if (minCache[i][j] != -1) return minCache[i][j];
        // lower right corner case
        if ((i == costs.length - 1) && (j == costs[0].length - 1)) {
            minCache[i][j] = costs[i][j];
        } else // recursion formula fills the minCache array
            minCache[i][j] = costs[i][j] + Math.min(minCostMemo(costs, minCache, i + 1, j), minCostMemo(costs, minCache,
                i, j + 1));
        return minCache[i][j];
    }


}
