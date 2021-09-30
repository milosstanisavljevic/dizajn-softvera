package app.guiSwing.view;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class AboutView extends JDialog {

    public AboutView() {
        BoxLayout box = new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS);
        setLayout(box);
        add(Box.createHorizontalStrut(30));
        add(split1());
        add(Box.createHorizontalStrut(30));
        add(split2());
        add(Box.createHorizontalStrut(30));
        this.setSize(800, 500);
    }

    private JPanel split1() {
        JPanel panel = new JPanel();
        BoxLayout box = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(box);
        URL link = getClass().getResource("/pictures/Milos.jpeg");
        ImageIcon image = new ImageIcon(link);
        JLabel image1 = new JLabel(image);
        image1.setPreferredSize(new Dimension(50, 50));
        panel.add(image1);
        panel.add(Box.createVerticalStrut(30));
        JLabel name = new JLabel("Milos Stanisavljevic");
        panel.add(name);
        JLabel index = new JLabel("RN82/2020");
        panel.add(index);
        return panel;

    }

    private JPanel split2() {
        JPanel panel = new JPanel();
        BoxLayout box = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(box);
        URL link = getClass().getResource("/pictures/Ivan.png");
        ImageIcon image = new ImageIcon(link);
        JLabel image1 = new JLabel(image);
        image1.setPreferredSize(new Dimension(50, 50));
        panel.add(image1);
        panel.add(Box.createVerticalStrut(30));
        JLabel name = new JLabel("Ivan Petrovic");
        panel.add(name);
        JLabel index = new JLabel("RN63/2019");
        panel.add(index);
        return panel;
    }
}
