package basePackage.jpmnbackend;

public class ThreadsAreCool extends Thread{

    public void run(){
        System.out.println(Thread.currentThread().getName() + " is running!");
    }
}
