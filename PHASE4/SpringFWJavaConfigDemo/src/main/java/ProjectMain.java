import com.sl.IBrand;
import com.sl.IProduct;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


public class ProjectMain {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

        IProduct p1 = context.getBean(IProduct.class); // DI

        System.out.println(" com.sl.Product name is " + p1.getName());
        System.out.println(" com.sl.Product price is " + p1.getPrice());
        p1.setPrice(200000f);
        System.out.println(" After changing price ... ");
        System.out.println(" com.sl.Product name is " + p1.getName());
        System.out.println(" com.sl.Product price is " + p1.getPrice());

        //com.sl.Brand obj creation
        IBrand b1 = context.getBean(IBrand.class);
        System.out.println("\n\n com.sl.Brand name is " + b1.getName());

    }
}