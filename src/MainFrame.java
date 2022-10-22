
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {

    int width = 500;
    int height = 500;


    JButton[] jb = new JButton[9];

    public void initialize() {
        setTitle("Tris");
        setSize(width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setBackground(Color.blue);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null); //per centrarlo nello schermo
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
        for (int i = 0; i < jb.length; i++) {
            
                
            
        }

    }

    public static void main(String[] args) {
        MainFrame m = new MainFrame();
        JPanel panel = new JPanel(new GridLayout(3, 3));

        m.createButton(panel);
        m.add(panel);
        m.initialize();
    }
}
