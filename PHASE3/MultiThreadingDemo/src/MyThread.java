public class MyThread extends Thread {

    // Define the task for this thread
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " i = " + i);

//            if(i==50){
//                this.stop();
//            }

            // voluntarily release the CPU
            try {
                Thread.sleep(10);// sleep for 100 ms
            } catch (InterruptedException e) {
            }
        }
    }
}
