package example.synchronized;

public class RotiChef  extends Thread {

    Plate plate;

    public RotiChef(Plate plate) {
        super();
        this.plate = plate;
    }

    @Override
    public void run() {

        plate.addItem("Roti");

    }

}
