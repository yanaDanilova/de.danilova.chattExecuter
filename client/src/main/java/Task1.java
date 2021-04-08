

public class Task1 {
    private Object mon = new Object();
    private char currentLetter = 'A';

    public static void main(String[] args) {
        Task1 task = new Task1();
        Thread t1 = new Thread(()->{
            task.printA();
        });
        t1.start();
        Thread t2 = new Thread(()->{
            task.printB();
        });
        t2.start();
        Thread t3 = new Thread(()->{
            task.printC();
        });
        t3.start();


    }

    public void printA(){
        synchronized (mon){
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter!='A'){
                        mon.wait();
                    }
                    System.out.print('A');
                    currentLetter = 'B';
                    mon.notify();
                }
            }catch (InterruptedException exception){
                exception.printStackTrace();
            }

        }

    }
    public void printB() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'B') {
                        mon.wait();
                    }
                    System.out.print('B');
                    currentLetter = 'C';
                    mon.notify();
                }
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }

    public void printC(){
            synchronized (mon){
                try {
                    for (int i = 0; i < 5; i++) {
                        while (currentLetter!='C'){
                            mon.wait();
                        }
                        System.out.print('C');
                        currentLetter = 'A';
                        mon.notifyAll();
                    }
                }catch (InterruptedException exception){
                    exception.printStackTrace();
                }
            }
    }
    }

