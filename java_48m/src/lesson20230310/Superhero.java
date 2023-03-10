package lesson20230310;

import java.util.Random;

public class Superhero {

    private String name;
    private int health;
    private int force;
    private Weapon weapon;
    private Protection protection;

    @Override
    public String toString() {
        return "Superhero{" + "name='" + name + '\'' + ", health=" + health + ", force=" + force + ", weapon=" + weapon + ", protection=" + protection + '}';
    }

    public Superhero(String name, int health, int force, Weapon weapon, Protection protection) {
        this.name = name;
        this.health = health;
        this.force = force;
        this.weapon = weapon;
        this.protection = protection;
    }

    public static Superhero generateRandomSuperHero(){
        Random random = new Random();
        String[] names = {"Batman", "Superman", "Spiderman"};

        return new Superhero(names[random.nextInt(3)], 100, random.nextInt(50),
                new Weapon("Weapon", random.nextInt(100)),
                new Protection("Protection", random.nextInt(1,6)));
    }


    public static void fight(Superhero one, Superhero two){
        int force1 = one.force + one.weapon.force;
        int force2 = two.force + two.weapon.force;
        if (force1 > force2) {
            two.health = two.health - (force1 - force2) / two.protection.level;
            System.out.println(one.name + " wins");
            System.out.println(two);
        } else if (force1 < force2) {
            one.health = one.health - (force2 - force1) / one.protection.level;
            System.out.println(two.name + " wins");
            System.out.println(one);
        } else {
            System.out.println("Nobody wins. Try again");
        }
    }


    public static void main(String[] args) {
        Superhero superhero1 = generateRandomSuperHero();
        Superhero superhero2 = generateRandomSuperHero();
        System.out.println(superhero1);
        System.out.println(superhero2);
        fight(superhero1, superhero2);
    }

    private static class Weapon {
        String name;
        int force;

        public Weapon(String name, int force) {
            this.name = name;
            this.force = force;
        }

        @Override
        public String toString() {
            return "Weapon{" + "name='" + name + '\'' + ", force=" + force + '}';
        }
    }

    private static class Protection {
        String name;
        int level;

        public Protection(String name, int level) {
            this.name = name;
            this.level = level;
        }

        @Override
        public String toString() {
            return "Protection{" + "name='" + name + '\'' + ", level=" + level + '}';
        }
    }
}
