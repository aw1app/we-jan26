import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProjectMain {

    public static void main(String[] args) {
        //IProduct p1 = new ProductV3("Dell AI PC", 100000f);

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //IProduct p1 = context.getBean("product2" , IProduct.class); //

        IProduct p1 = context.getBean(IProduct.class); //

        System.out.println(" Product name is " + p1.getName());
        p1.setPrice(200000f);
        System.out.println(" Product price is " + p1.getPrice());

    }
}
