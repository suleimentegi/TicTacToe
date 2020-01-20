import res.code.Coord;
import res.code.Game;
import res.code.Ranges;
import res.code.Box;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TicTacToe extends JFrame {

    private Game game;
    private JPanel panel;
    private JLabel label;

    private final int IMAGE_SIZE = 30;
    private final int ROWS = 20;
    private final int COLS = 20;

    public static void main(String[] args) {
        new TicTacToe();
    }

    private TicTacToe(){
        game = new Game();
        game.start(ROWS,COLS);
        setImages();
        initPanel();
        initLabel();
        initFrame();
    }

    private void initFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("TicTacToe");
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initLabel() {
        label = new JLabel(getMessage());
        Font font = new Font("Arial", Font.BOLD,21);
        label.setFont(font);
        add(label,BorderLayout.NORTH);
    }

    private void initPanel() {
        panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Coord coord : Ranges.getAllCoords())
                    g.drawImage((Image)game.getBox(coord).image,
                            coord.x * IMAGE_SIZE,
                            coord.y * IMAGE_SIZE,this);
            }
        };

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX() / IMAGE_SIZE;
                int y = e.getY() / IMAGE_SIZE;
                Coord coord = new Coord(x,y);
                switch (e.getButton()){
                    case MouseEvent.BUTTON1 : game.pressLeftButton(coord); break;
                    case MouseEvent.BUTTON2 : game.start(ROWS,COLS);break;
                }
                panel.repaint();
                label.setText(getMessage());
            }
        });

        panel.setPreferredSize(new Dimension(
                Ranges.getSize().x * IMAGE_SIZE,
                Ranges.getSize().y * IMAGE_SIZE));
        add(panel);
    }

    private void setImages() {
        for (Box box : Box.values())
            box.image = getImage(box.name().toLowerCase());
        setIconImage(getImage("zero"));
    }

    private Image getImage(String name) {
        String filename = "res/img/" + name + ".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(filename));
        return icon.getImage();
    }

    private String getMessage(){
        switch (game.getState()){
            case WINX: return "X win";
            case WINO: return "O win";
            case DRAW: return "DRAW";
            case PLAYED:
            default: return "Welcome!";
        }
    }
}

