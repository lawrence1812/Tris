import java.util.Random;
import java.util.Scanner;

abstract class Player {
    protected int sign;
    Tris tris; // da togliere
    protected int x;
    protected int y;
    public int getSign() {
        return sign;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    abstract public void move();

    public void newMove(int i, int j) {
    }

}


class Bot extends Player {
    Random r = new Random();
    public Bot(Tris tris, int sign) {
        this.tris = tris;
        this.sign = sign;
    }

    @Override
    public void move() {
        x = r.nextInt(3);
        y = r.nextInt(3);
    }
}

class Human extends Player {
    Scanner s = new Scanner(System.in);
    public Human(Tris tris, int sign) {
        this.tris = tris;
        this.sign = sign;
    }

    @Override
    public void move() {
        System.out.print("\nx: ");
        x = s.nextInt();
        System.out.print("\ny: ");
        y = s.nextInt();
    }
}
// creare la giocata dall'interfaccia 
// il problema è l'attesa del UI 
// si può sistemare con un ciclo che aspetta la risposta
class UI extends Player {
    boolean ready = false;
    public UI(Tris tris, int sign) {
        this.tris = tris;
        this.sign = sign;
    }

    @Override
    public void move() {
        while(ready) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ciclo");
            ready = false;
        }
        
        
    }

    public void newMove(int x, int y) {
        ready = true;
        x =  this.x;
        y = this.y;
    }
}
