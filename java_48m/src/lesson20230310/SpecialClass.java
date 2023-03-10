package lesson20230310;

import java.util.Random;

public class SpecialClass {

    private int count;
    private String name;
    private boolean flag;

    private SpecialClass(int count, String name, boolean flag) {
        this.count = count;
        this.name = name == null ? "Default" : name;
        this.flag = flag;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "SpecialClass{" + "count=" + count + ", name='" + name + '\'' + ", flag=" + flag + '}';
    }


    public static SpecialClass generateClass(String name) {
        return new SpecialClass(0, name, false);
    }

    public static SpecialClass generateRandomClass() {
        String[] names = {"Peter", "John", "Mark", "Mary"};
        Random random = new Random();
        return new SpecialClass(0, names[random.nextInt(4)], false);
    }


    public static class StaticClass {

        private String name;

        public void setName(String name) {
            this.name = name;
        }
    }
}
