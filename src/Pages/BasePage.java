package Pages;

import javax.swing.*;
import java.awt.*;

public class BasePage extends JFrame{

    final static int HEIGHT = 600;
    final static int WIDTH = 800;

    final private static Color BG_COLOR = new Color(230, 230, 236);

    public BasePage(String pageTitle){
        setTitle(pageTitle);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(BG_COLOR);

        setVisible(true);
    }
}
