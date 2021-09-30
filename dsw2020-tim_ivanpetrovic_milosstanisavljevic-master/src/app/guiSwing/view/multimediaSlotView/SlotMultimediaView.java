package app.guiSwing.view.multimediaSlotView;

import app.guiSwing.controller.*;
import app.repository.elements.SlotDevice;
import app.repository.elements.SlotType;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class SlotMultimediaView extends JDialog {

    String imagePath = "";
    String text = "no text";
    SlotDevice mySlot;
    JTextArea textArea;

    public SlotMultimediaView(Frame owner, boolean modal, SlotDevice selectedSlot) {

        super(owner, modal);
        this.mySlot = selectedSlot;
        System.out.println(selectedSlot.toString());

            Dimension size = new Dimension(600,300);
            int windowWidth = size.width;
            int windowHeight = size.height;
            setSize(windowWidth,windowHeight);
            setLocationRelativeTo(owner);
            setTitle("Choose type");

            JButton imageButton = new JButton("Image");
            imageButton.addActionListener(new ImageButtonListener());
            JButton textButton = new JButton("Text");
            textButton.addActionListener(new TextButtonListener());

            JPanel panel = new JPanel();
            panel.setPreferredSize(new Dimension(windowWidth/2, windowHeight));
            panel.add(imageButton, BorderLayout.WEST);
            panel.add(textButton,BorderLayout.EAST);

            add(panel);
    }

   /* public SlotMultimediaView(Frame frame, boolean modal, SlotDevice slotDevice) {
        super(frame, modal);
        this.device = slotDevice;
        if(device.getType() == SlotType.NONE){
            this.setTitle("Slot Multimedia");
            this.setSize(400,300);
            JButton imgButton = new JButton("Image");
            JButton textButton = new JButton("text");
            //
            textButton.addActionListener(new SlotTextAction());
            imgButton.addActionListener(new SlotImageAction());

            JPanel panel = new JPanel();
            panel.add(imgButton,BorderLayout.WEST);
            panel.add(textButton,BorderLayout.EAST);
            this.add(panel);
        }
        if(device.getType() == SlotType.TYPE_TEXT){
           JToolBar toolBar = new JToolBar();
            JTextPane textPane = new JTextPane();

            this.add(textPane,BorderLayout.CENTER);
            this.add(toolBar,BorderLayout.NORTH);
            JButton bold = new JButton(new StyledEditorKit.BoldAction());
            JButton italic = new JButton(new StyledEditorKit.ItalicAction());
            JButton underline = new JButton(new StyledEditorKit.UnderlineAction());
            toolBar.add(bold);
            toolBar.add(italic);
            toolBar.add(underline);

            this.setSize(300, 250);
        }
        if(device.getType() == SlotType.TYPE_IMAGE){
//            JLabel label = new JLabel("choose image");
//            this.add(label,BorderLayout.NORTH);
//            this.setSize(500, 250);
            JButton save = new JButton("Save");
            JButton chooseImage = new JButton("choose image");
            JPanel panel = new JPanel();
            JLabel slika = new JLabel("slika");
            ImageIcon image;
            Dimension d = new Dimension(500, 350);
            this.setSize(d);
            //image.setImage1(device.getFile());
            panel.add(slika,BorderLayout.NORTH);
            panel.add(chooseImage,BorderLayout.SOUTH);
            chooseImage.addActionListener(new ChooseImageAction());
            this.add(panel);


        }
    }
    public Image setImage1(File file) {
        Image image = null;
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {

            URL imageURL = getClass().getResource("/pictures/Milos.jpeg");
            try {
                image = ImageIO.read(imageURL);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
//image = (Image) image.getScaledInstance(view.getWidth(), view.getHeight(), Image.SCALE_SMOOTH);
        return image;
    }
*/
   public void setImagePath(String imagePath) {
       this.imagePath = imagePath;
   }

    public String getImagePath() {
        return imagePath;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public JTextArea getTextArea() {
        return textArea;
    }
}
