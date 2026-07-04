import com.sl.IBrand;
import com.sl.IProduct;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


public class ProjectMain {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

        IProduct p1 = context.getBean(IProduct.class); // DI

//        IBrand b1 = context.getBean(IBrand.class); // DI
//        p1.setBrand(b1);

        System.out.println(" com.sl.Product name is " + p1.getName());
        System.out.println(" com.sl.Product price is " + p1.getPrice());

        IBrand p1Brand  = p1.getBrand();
        System.out.println("\n\n com.sl.Brand name is " +p1Brand.getName());

    }
}