//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();

        MyThread t2 = new MyThread();
        t2.start();

        //Thread Objects of Runnable implementation
        MyThreadUsingRunnable r1 = new MyThreadUsingRunnable();
        Thread rt1 = new Thread(r1);
        rt1.start();

        MyThreadUsingRunnable r2 = new MyThreadUsingRunnable();
        Thread rt2 = new Thread(r2);
        rt2.start();

        System.out.println(Thread.currentThread().getName() + " m1");
        System.out.println(Thread.currentThread().getName() + " m2");
        System.out.println(Thread.currentThread().getName() + " m3");
        System.out.println(Thread.currentThread().getName() + " m4");
        System.out.println(Thread.currentThread().getName() + " m5");
    }
}