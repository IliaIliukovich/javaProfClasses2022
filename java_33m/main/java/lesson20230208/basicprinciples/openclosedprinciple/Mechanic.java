package lesson20230208.basicprinciples.openclosedprinciple;

public class Mechanic {

    public void service(Car c) {
        commonService();
        c.getCarService().service();
        wash();
    }

    private void commonService() {
        System.out.println("Common service");
    }


    public void wash() {
        System.out.println("Washing the car");
    }

    public static void main(String[] args) {
        Mechanic mechanic = new Mechanic();
        mechanic.service(new BMW());
        mechanic.service(new Volwo());

        // Liskov substitution principle violation
        BMW bmw = new BMW2();
        mechanic.service(bmw);
    }


}
