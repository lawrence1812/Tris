import java.awt.*;
import javax.swing.*;



class Main {
    
    public static void main(String[] args) {

        Tris tris = new Tris();
        MainFrame m = new MainFrame();
        JPanel panel = new JPanel(new GridLayout(tris.field.length, tris.field[0].length));

        Player p1 = new Bot(tris, tris.X);
        Player p2 = new Bot(tris, tris.O);
        Player p = p2;
        
        

        GUI(m,panel);

        while (tris.verifica() == tris.PARTITA_IN_CORSO) {

            
            if (p == p1)
                p = p2;
            else
                p = p1;
            
            m.setCurrentPlayer(p);
            giocaMain(p,tris);
            m.updateField(tris);
            System.out.println(tris.trisToString());
            
        }
        System.out.println("conclusione partita: " + tris.singToChar(tris.verifica()));
    }
    public static void GUI(MainFrame m, JPanel panel) {
        
        m.createButton(panel);
        m.add(panel);
        m.initialize();
    } 

    public static void giocaMain(Player p, Tris tris)  {   
        p.move();
        int x = p.getX();
        int y = p.getY();
        int sign = p.getSign();

        if (tris.isPlayable(x, y)) {
            tris.play(x, y, sign);
        } else {
            //System.out.println("mossa invalida");
            giocaMain(p,tris);
        }
    }
}
