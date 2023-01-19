public class BallLadderRoutes {



    //  Task: At the top of the ladder containing N steps, there is a ball that starts jumping down them to the base.
    //  The ball can jump to the next step, to the step through one or through 2.
    //  (That is, if the ball lies on the 8th step, then it can move to the 5th, 6th or 7th.)
    //  Determine the number of possible "routes" of the ball from the top to the ground.
    public static void main(String[] args) {

        System.out.println(possibleRoutes(5));
        System.out.println(possibleRoutesTabOptimized(5));

    }

    private static int possibleRoutes(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        return possibleRoutes(n - 1) + possibleRoutes(n - 2) + possibleRoutes(n - 3);
    }

    private static int possibleRoutesTabOptimized(int n){
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        int cache1 = 1;
        int cache2 = 2;
        int cache3 = 4;
        int cache4 = 0;

        for (int i = 4; i <= n; i++) {
            cache4 = cache1 + cache2 + cache3;
            cache1 = cache2;
            cache2 = cache3;
            cache3 = cache4;
        }
        return cache4;
    }

}
