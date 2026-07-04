public class ProductV3 implements IProduct{

    String name;
    float price;
    int initialStockQuantity;

    public ProductV3() {
    }

    public ProductV3(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public ProductV3(String name, float price, int initialStockQuantity) {
        this.name = name;
        this.price = price;
        this.initialStockQuantity = initialStockQuantity;
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
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
