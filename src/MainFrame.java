
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {
    Main main = new Main();
    int width = 500;
    int height = 500;
    Player currentPlayer;

    JButton[] jb = new JButton[9];

    public void initialize() {
        setTitle("Tris");
        setSize(width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setBackground(Color.blue);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null); // per centrarlo nello schermo
        setAlwaysOnTop(true);
    }

    public void createButton(JPanel panel) {
        for (int i = 0; i < 9; i++) {
            jb[i] = new JButton();
            jb[i].setText("");
            jb[i].setFont(new Font("JetBrains mono", Font.PLAIN, 75));
            jb[i].setBackground(Color.GRAY);
            panel.add(jb[i]);
            jb[i].addActionListener(this);
            jb[i].setFocusable(false);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == jb[i]) {
                
                //jb[i].setText(arrNumConv(i)[0] + ", " + arrNumConv(i)[1]);
                currentPlayer.newMove(arrNumConv(i)[0], arrNumConv(i)[1]);
            }
        }
    }

    public void updateField(Tris tris) {
        int y;
        int z;
        for (int i = 0; i < jb.length; i++) {
            y = arrNumConv(i)[0];
            z = arrNumConv(i)[1];
            if (tris.field[y][z] != tris.E) {
                
                if(tris.field[y][z] == -1) 
                    jb[i].setForeground(Color.blue);
                else 
                    jb[i].setForeground(Color.red);
                
                jb[i].setText(""+tris.singToChar(tris.field[y][z]));
                if(tris.verifica() != tris.PARTITA_IN_CORSO) jb[i].setEnabled(false);
            } else {
                jb[i].setText("");
            }
        }       
    }

    public void setCurrentPlayer(Player p) {
        currentPlayer = p;
    }

    /**
     * Converte il numero da 0-8
     * int un array da usare per matrici 3x3
     * Es 8 -> x = 2, y = 2
     * 
     * @param n int numero da cambiare
     */
    public int[] arrNumConv(int n) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            x++;
            if (x == 3) {
                x = 0;
                y++;
            }
        }
        return new int[] { x, y };
    }

    public static void main(String[] args) {
        MainFrame m = new MainFrame();
        JPanel panel = new JPanel(new GridLayout(3, 3));

        m.createButton(panel);
        m.add(panel);
        m.initialize();
    }
}
