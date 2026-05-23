public class MyThreadUsingRunnable implements  Runnable{

    // Define the task for this thread
    @Override
    public void run() {
        for (int j = 0; j < 100; j++) {
            System.out.println(Thread.currentThread().getName() + " j = " + j);

            // voluntarily release the CPU
            try {
                Thread.sleep(100);// sleep for 100 ms
            } catch (InterruptedException e) {
            }
        }
    }
}
