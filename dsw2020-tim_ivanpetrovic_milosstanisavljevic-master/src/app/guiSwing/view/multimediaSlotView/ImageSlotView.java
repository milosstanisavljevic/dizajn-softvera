package app.guiSwing.view.multimediaSlotView;

import app.guiSwing.controller.ChooseImageAction;
import app.repository.elements.SlotDevice;

import javax.swing.*;
import java.awt.*;

public class ImageSlotView extends JDialog {

    String imagePath = "";
    SlotDevice mySlot;

    public ImageSlotView(SlotDevice selectedSlot){

        this.mySlot = selectedSlot;

        if(mySlot.getFile()!=null){
            setImagePath(mySlot.getFile().getPath());
        }

        Dimension size = new Dimension(600,300);
        int windowWidth = size.width;
        int windowHeight = size.height;
        setSize(windowWidth,windowHeight);
        setLocationRelativeTo(null);
        setTitle("Image slot");

        JPanel IPanel = new JPanel();
        IPanel.setPreferredSize(new Dimension(windowWidth/2, windowHeight));
        IPanel.setLayout(new BorderLayout(20,20));

        JButton IButton = new JButton("Edit Image");
        IButton.addActionListener(new ChooseImageAction());

        IPanel.add(IButton, BorderLayout.NORTH);

        JLabel label = new JLabel(new ImageIcon(imagePath));
        label.setPreferredSize(new Dimension(80, 80));
        label.setHorizontalAlignment(0);
        label.setVerticalAlignment(0);
        IPanel.add(label);
        add(IPanel);
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }
}

