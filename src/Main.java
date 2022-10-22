import java.awt.*;
import javax.swing.*;

class Main {
    public static void main(String[] args) {
        Tris tris = new Tris();
        //MainFrame m = new MainFrame();

        //JPanel panel = new JPanel(new GridLayout(tris.field.length, tris.field[0].length));

        Player p1 = new Bot(tris, tris.X);
        Player p2 = new Bot(tris, tris.O);
        Player p = p2;

        //m.createButton(panel);
        //m.add(panel);
        //m.initialize();

        while (tris.verifica() == tris.PARTITA_IN_CORSO) {
            if (p == p1)
                p = p2;
            else
                p = p1;
            p.gioca();
            System.out.println(tris.trisToString());
            
        }
        System.out.println("concluesione partita: " + tris.singToChar(tris.verifica()));
    }
}
