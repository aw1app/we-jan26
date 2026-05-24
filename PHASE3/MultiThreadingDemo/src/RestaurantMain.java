public class RestaurantMain {

    public static void main(String[] args) {

        Plate p1 = new Plate();

        Thread dosachef = new DosaChef(p1);

        Thread rotichef = new RotiChef(p1);

        Thread dosachef2 = new DosaChef(p1);

        Thread rotichef2 = new RotiChef(p1);

        dosachef.start();
        rotichef.start();

//        dosachef2.start();
//        rotichef2.start();
    }
}
