import com.sl.BankAccount;
import com.sl.IAccount;
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
        IAccount acct1 = context.getBean( "bankAcct1", IAccount.class);
        System.out.println("acct1 object ref is " + acct1);
        System.out.println("acct1 object ref is " + acct1.getAddr().getAddress());


        acct1.deposit(1000f); // Before,  After

        acct1.withdraw(500f); //  Before,  After

        System.out.println("Balance is " + acct1.getBalance()); //  Before,  After, Around


//        IAccount acct2 = context.getBean("poAcct1", IAccount.class);
//        System.out.println("acct2 object ref is " + acct2);
//
//        IAccount acct3 = context.getBean("insuranceAcct1", IAccount.class);
//        System.out.println("acct3 object ref is " + acct3);
    }
}