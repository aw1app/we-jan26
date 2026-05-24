import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemoMain {

    public static void main(String[] args) {

        // Create an ExecutorService with a fixed thread pool
        ExecutorService executor = Executors.newFixedThreadPool(2);


        Callable<Integer> callable1 = new ComplexCalculation("task1");
        Future<Integer> future1 = executor.submit(callable1);

        System.out.println("Tasks submitted, continuing with other work...");
        System.out.println(Thread.currentThread().getName() + " m1");
        System.out.println(Thread.currentThread().getName() + " m2");

        try {
            Integer res = future1.get();
            System.out.println(" Result from the future : " + res);
        }catch (Exception e){}

    }
}




//Class representing a complex calculation task
class ComplexCalculation implements Callable<Integer> {
    private String taskName;
    private Random random;

    public ComplexCalculation(String taskName) {
        this.taskName = taskName;
        this.random = new Random();
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(taskName + " starting calculation...");

        // Simulate complex work
        int calculationTime = random.nextInt(3000) + 1000; // 1-4 seconds
        Thread.sleep(calculationTime);

        // Simulate result calculation
        int result = random.nextInt(100) + 1;

        System.out.println(taskName + " completed after " + calculationTime + "ms");
        return result;
    }
}
