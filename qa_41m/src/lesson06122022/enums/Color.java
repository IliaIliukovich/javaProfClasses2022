package lesson06122022.enums;

public enum Color {
    BLUE {
        @Override
        void specialMethod() {
           System.out.println("specialBlueMethod");
        }
    },
    GREEN {
        @Override
        void specialMethod() {
            System.out.println("specialGreenMethod");
        }
    },
    YELLOW {
        @Override
        void specialMethod() {
            System.out.println("specialYellowMethod");
        }
    },
    RED {
        @Override
        void specialMethod() {
            System.out.println("specialRedMethod");
        }
    };

    Color() {
        System.out.println("This is constuctor of " + this.name());
    }

    public void someMethod() {
        System.out.println("This is enum method in " + this.name());
    }

    abstract void specialMethod();

}
