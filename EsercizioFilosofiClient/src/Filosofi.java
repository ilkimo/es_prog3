class Filosofi {
    public static void main(String[] args) {
        Philosopher[] phil = new Philosopher[3];
        Chopstick left = new Chopstick();
        Chopstick right = new Chopstick();
        Chopstick first = left;
        int i = 0;
        while(i < phil.length - 1) {
            phil[i++] = new Philosopher(left, right);
            left = right;
            right = new Chopstick();
        }

// Questo programma può andare in deadlock quando
// tutti i filosofi hanno afferrato la bacchetta
// di sinistra e sono in attesa di quella di destra
// Per evitare il deadlock si possono scambiare i due
// parametri dell'ultimo filosofo: prima prende la
// bacchetta di destra e poi quella di sinistra
        
        phil[i] = new Philosopher(left,first);
    }
}

// la forchetta (Chopstick) deve garantire l'accesso corretto da parte dei filosofi
class Chopstick {
    private static int counter = 0;
    private int number = counter++;
    Philosopher owner = null;
    
    public int getNumber(){
        return number;
    }
} // end Chopstick


class Philosopher extends Thread {
    private static int counter = 0; //è uguale per tutti i filosofi
    private int number = counter++;
    private Chopstick left, right;

    public Philosopher(Chopstick l, Chopstick r) {
        left = l;
        right = r;
        start();
    }
    
    public void think() {
        System.out.println(this + " thinking");
        try {
            sleep((long)(Math.random() * 1000));
        } catch (InterruptedException e) {}
    }
    
    public void eat() {
        synchronized(left) {
            System.out.println(this + " has " + left.getNumber() +
                    " waiting for " + right.getNumber());
            
            synchronized(right) {
                try {
                    System.out.println(this + " takes " + right.getNumber());
                    //sleep((long)(Math.random() * 1000));
                    sleep(5000);
                } catch (InterruptedException e) {}
                System.out.println(this + " eating");
            }
        }
    }
    
    public String toString() {
        return "Philosoper " + number;
    }
    
    public void run() {
        while(true) {
            think();
            eat();
        }
    }
}