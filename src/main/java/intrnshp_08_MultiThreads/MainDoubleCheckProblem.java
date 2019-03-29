package intrnshp_08_MultiThreads;

// дабл чек проблем

public class MainDoubleCheckProblem {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
    }


    // просто синглетон
/*
    static class Singleton {
        private static Singleton singleton = new Singleton();
        private Singleton() {}
        public static Singleton getInstance() {
            return singleton;
        }
    }*/

    // ленивый синглетон (инициализация при первом обращении)
    // как бы его сделать потокобезопасным?

/*
    static class Singleton {
        private static Singleton singleton;
        private Singleton() {}
        public static Singleton getInstance() {
            if (singleton == null) {
                singleton = new Singleton();
            }
            return singleton;
        }
    }*/

    // а вот так вот
    static class Singleton {
        private static Singleton singleton;
//        private volatile static Singleton singleton; // а это решение проблемы - добавить volatile
        private Singleton() {}

        public synchronized static Singleton getInstance() {
            if (singleton == null) {            // проверка номер 1
                synchronized (Singleton.class) {
                    if (singleton == null) {    // проверка номер 2
                        // вот тут проблемка может возникнуть! (проделки JIT)
                        // вначале в singleton пишется null
                        // а потом создаётся уже создаётся сам объект
                        // хотя надо то наоборот
                        singleton = new Singleton();
                     }
                }
            }
            return singleton;
        }
    }
}