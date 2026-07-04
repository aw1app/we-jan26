import com.sl.BankAccount;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@ComponentScan("com.sl")
@Configuration
public class ProjectMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectMain.class);
        BankAccount acct1 = (BankAccount) context.getBean(BankAccount.class);

        acct1.deposit(1000f);

        acct1.withdraw(500f);

        System.out.println("Balance is " + acct1.getBalance()); // 500
    }
}