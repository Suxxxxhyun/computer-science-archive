import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class main {
    public static void main(String[] args){
        Number number = new Number();

        Counter counter1 = new Counter(number, true);
        Counter counter2 = new Counter(number, false);

        counter1.start();
        counter2.start();

        //thread종료될때까지 기다리기
        while(counter1.isAlive() || counter2.isAlive()){

        }

        System.out.println(counter1.getState() + " " + counter2.getState());
        System.out.println(number.count);
    }
}

class Number{
    int count;

    public Number(){
        this.count = 0;
    }

    Lock lock = new ReentrantLock();

    public void increase(){
        lock.lock();
        this.count++;
        lock.unlock();
    }

    public void decrease(){
        lock.lock();
        this.count--;
        lock.unlock();
    }
}

class Counter extends Thread{
    private final Number number;

    private boolean flag;

    public Counter(Number number, boolean flag){
        this.number = number;
        this.flag = flag;
    }

    @Override
    public void run(){
        for(int i=0; i<10000000; i++){
            if(flag){
                number.increase();
            } else {
                number.decrease();
            }
        }
    }
}

