public class ProductV2 implements IProduct{

    String name;
    float price;

    public ProductV2(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public float getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String getName() {
        return "----";
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
