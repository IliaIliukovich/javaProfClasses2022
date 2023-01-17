package lesson20230117.dynamicprogramming;

public class OptimalPath {

    public static void main(String[] args) {

        // 2. На вершине лесенки, содержащей N ступенек, находится мячик, который начинает прыгать по ним вниз, к
        // основанию. Мячик может прыгнуть на следующую ступеньку, на ступеньку через одну или через 2.
        //(То есть, если мячик лежит на 8-ой ступеньке, то он может переместиться на 5-ую, 6-ую или 7-ую.)
        //Определить число всевозможных «маршрутов» мячика с вершины на землю.

        System.out.println(ballPath(8));
        System.out.println(ballPathTabOptimized(8));

        // 3. Самый дешёвый путь
        //В каждой клетке прямоугольной таблицы N*M записано некоторое число.
        //Изначально игрок находится в левой верхней клетке.
        //За один ход ему разрешается перемещаться в соседнюю клетку либо вправо, либо вниз (влево и вверх
        // перемещаться запрещено).
        //При проходе через клетку игрок платит определенную сумму, какое число записано в этой клетке.
        //Требуется найти минимальную стоимость пути, отдав которую игрок может попасть в правый нижний угол.

        int[][] pathCost = new int[][] {
                {0, 11, 0, 0, 0, 0},
                {10, 10, 10, 10, 10, 0},
                {10, 10, 10, 4, 10, 0},
        };

        int[][] pathCost2 = new int[][] {
                {0, 1, 1, 0, 3, 9, 0, 3, 9, 0, 3, 9, 0, 3, 9, 0, 3, 9},
                {1, 1, 1, 3, 5, 1, 3, 5, 1, 3, 5, 1, 3, 5, 1, 3, 5, 1},
                {7, 8, 2, 4, 2, 0, 4, 2, 0, 4, 2, 0, 4, 2, 0, 4, 2, 0},
                {7, 8, 2, 4, 2, 0, 4, 2, 0, 4, 2, 0, 4, 2, 0, 4, 2, 0},
                {7, 8, 2, 4, 2, 0, 4, 2, 0, 4, 2, 0, 4, 2, 0, 4, 2, 0},
                {7, 8, 2, 4, 2, 0, 4, 2, 0, 4, 2, 0, 4, 2, 0, 4, 2, 0},
                {7, 8, 2, 4, 2, 0, 4, 2, 0, 4, 2, 0, 4, 2, 0, 4, 2, 0},
                {7, 8, 2, 4, 2, 0, 4, 2, 0, 4, 2, 0, 4, 2, 0, 4, 2, 0},
                {7, 8, 2, 4, 2, 0, 4, 2, 0, 4, 2, 0, 4, 2, 0, 4, 2, 0},
                {7, 8, 2, 4, 2, 0, 4, 2, 0, 4, 2, 0, 4, 2, 0, 4, 2, 0},
                {7, 8, 2, 4, 2, 0, 4, 2, 0, 4, 2, 0, 4, 2, 0, 4, 2, 0},
                {7, 8, 2, 4, 2, 0, 4, 2, 0, 4, 2, 0, 4, 2, 0, 4, 2, 0},
                {7, 8, 2, 4, 2, 0, 4, 2, 0, 4, 2, 0, 4, 2, 0, 4, 2, 0},
        };

        long start = System.currentTimeMillis();
        System.out.println(minimalCost(pathCost2));
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        System.out.println(minimalCostMemo(pathCost2));
        System.out.println(System.currentTimeMillis() - start);
    }

    private static int ballPath(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        return ballPath(n - 1) + ballPath(n - 2 ) + ballPath(n - 3);
    }

    private static int ballPathTabOptimized(int n){
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        int cache1 = 1;
        int cache2 = 2;
        int cache3 = 4;
        int cache4 = 7;

        for (int i = 4; i <= n; i++) {
            cache4 = cache1 + cache2 + cache3;
            cache1 = cache2;
            cache2 = cache3;
            cache3 = cache4;
        }
        return cache4;
    }

    private static int minimalCost(int[][] pathCost) {
        return findMin(pathCost, 0, 0);
    }

    private static int findMin(int[][] pathCost, int i, int j) {

        int totalCost = pathCost[i][j];

        if ((i < pathCost.length - 1) && (j < pathCost[0].length - 1)) {
            totalCost = totalCost + Math.min(findMin(pathCost, i + 1, j), findMin(pathCost, i, j + 1));
        } else if (i < pathCost.length - 1) {
            totalCost = totalCost + findMin(pathCost, i + 1, j);
        } else if (j < pathCost[0].length - 1) {
            totalCost = totalCost + findMin(pathCost, i, j + 1);
        }
        return totalCost;
    }


    private static int minimalCostMemo(int[][] pathCost) {
        int[][] cacheMin = new int[pathCost.length][pathCost[0].length];
        fillCache(cacheMin);
        return findMinMemo(pathCost, cacheMin, 0, 0);
    }

    private static void fillCache(int[][] cacheMin) {
        for (int i = 0; i < cacheMin.length; i++) {
            for (int j = 0; j < cacheMin[0].length; j++) {
                cacheMin[i][j] = -1;
            }
        }
    }

    private static int findMinMemo(int[][] pathCost, int[][] cacheMin, int i, int j) {
        if (cacheMin[i][j] != -1) return cacheMin[i][j];

        cacheMin[i][j] = pathCost[i][j];

        if ((i < pathCost.length - 1) && (j < pathCost[0].length - 1)) {
            cacheMin[i][j] = cacheMin[i][j] + Math.min(findMinMemo(pathCost, cacheMin,i + 1, j),
                    findMinMemo(pathCost, cacheMin, i, j + 1));
        } else if (i < pathCost.length - 1) {
            cacheMin[i][j] = cacheMin[i][j] + findMinMemo(pathCost, cacheMin, i + 1, j);
        } else if (j < pathCost[0].length - 1) {
            cacheMin[i][j] = cacheMin[i][j] + findMinMemo(pathCost, cacheMin, i, j + 1);
        }
        return cacheMin[i][j];
    }

}
