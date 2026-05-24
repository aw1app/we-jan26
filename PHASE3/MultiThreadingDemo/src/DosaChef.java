package example.synchronized;

public class DosaChef extends Thread {

    example.Plate plate;

    public DosaChef(example.Plate plate) {
        super();
        this.plate = plate;
    }

    @Override
    public void run() {

        plate.addItem("Dosa");

    }

}
