package intrnshp_08_MultiThreads;

// смотрим как работает
//  - synchronized
//      - в сигнатуре метода и в блоке
//      - для статич и не статич методов
//  - yield
//  - .setName()
//  -

public class Main3 {

    public static void main(String[] args) throws InterruptedException {

        Resource resource = new Resource();
        resource.i = 0;
        Resource.j = 0;

        MyThread myThread1 = new MyThread();
        myThread1.setName("one");

        MyThread myThread2 = new MyThread();
        myThread2.setName("two");

        myThread1.setResource(resource);
        myThread2.setResource(resource);

        System.out.println("Сейчас работает поток " + Thread.currentThread().getName()); // поток под именем "main"

        myThread1.start();
        myThread2.start();

        myThread1.join(); // тормазиться только main
        myThread2.join(); // тормазиться только main

        System.out.println("i = " + resource.i);
        System.out.println("j = " + Resource.j);
    }

}

class MyThread extends Thread {
    Resource resource;

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        System.out.println("Запустился поток Name = " + Thread.currentThread().getName() + "; id = " + Thread.currentThread().getId());
//        resource.changeI();
        Resource.changeStaticJ();
        System.out.println("Завершился поток Name = " + Thread.currentThread().getName() + "; id = " + Thread.currentThread().getId());
    }
}

class Resource {
    static int j;
    int i;

    public void changeI() {
//    public synchronized void changeI() {
//        synchronized (this) {
        int i = this.i;
        if (Thread.currentThread().getName().equals("one")) {
            System.out.println("    Поток one прекращает работу и возвращается в пул");
            Thread.yield();
        }
        i++;
        this.i = i;
//        }
    }

    //    public synchronized static void changeStaticJ() {
    public static void changeStaticJ() {

        synchronized (Resource.class) { // лок на КЛАСС!
            int j = Resource.j;
            if (Thread.currentThread().getName().equals("one")) {
                System.out.println("    Поток one прекращает работу и возвращается в пул");
                Thread.yield();
            }
            j++;
            Resource.j = j;
        }
    }
}