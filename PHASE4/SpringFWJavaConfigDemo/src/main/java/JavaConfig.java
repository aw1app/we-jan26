import com.sl.IProduct;
import com.sl.Product;
import com.sl.ProductV2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("com.sl")
public class JavaConfig {

    @Bean
    public IProduct getProduct1(){
        return new Product("Dell AI PC 1", 50000.0f);
    }

    @Bean
    @Primary
    public IProduct getProduct2(){
        return new ProductV2("HP AI PC 1", 55000.0f);
    }

//    @Bean
//    public com.sl.IBrand getBrand1(){
//        return new com.sl.Brand("Dell");
//    }

}
