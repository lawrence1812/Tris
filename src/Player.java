import java.util.Random;

abstract class Player {
    Random r = new Random();
    protected int segno;
    Tris tris;
    int x;
    int y;
    public int getSegno() {
        return segno;
    }

    abstract public void gioca();

}


class Bot extends Player {
    public Bot(Tris tris, int segno) {
        this.tris = tris;
        this.segno = segno;
    }

    @Override
    public void gioca() {
        x = r.nextInt(3);
        y = r.nextInt(3);
        if (tris.isPlayable(x, y)) {
            tris.play(x, y, segno);
        } else { 
            gioca();
        }
    }
}
