package lesson20230914;

import lesson20230905.Cat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PlayGround {


    public static void main(String[] args) {

        Playable footballPlayer = new FootballPlayer();
        Playable volleyballPlayer = new VolleyballPlayer();

        // anonymous class
        int count = 10; // effectively final
//        count++;
        Playable chessPlayer = new Playable() {
            @Override
            public void play(){
//                count++;
                System.out.println("I play chess");
                System.out.println("Count = " + count);
            }
        };

        Playable badmintonPlayer = () -> System.out.println("I play badminton");

        playAll(footballPlayer, volleyballPlayer, chessPlayer, badmintonPlayer);

        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat("Tom", 2, "black", true));
        catList.add(new Cat("Tom", 1, "black", false));


//        Comparator<Cat> catComparator = new Comparator<Cat>() {
//            @Override
//            public int compare(Cat o1, Cat o2) {
//                return o1.getAge() - o2.getAge();
//            }
//        };

        Comparator<Cat> catComparator = (cat1, cat2) -> cat1.getAge() - cat2.getAge();
        catList.sort(catComparator);
        System.out.println(catList);

    }

    public static void playAll(Playable... playables) {
        for (Playable p : playables) {
            p.play();
        }
    }


}
