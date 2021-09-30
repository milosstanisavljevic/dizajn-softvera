package app.repository.elements;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.*;

public class SlotDevice extends SlotElement implements Serializable {

    protected Dimension size;
    private Dimension oldSize = null;
    private double angle;
    private double originalAngle;
    protected Point2D position;
    protected Point2D oldPosition = null;
    private double scale;
    private SlotType type = SlotType.NONE;
    private File file = null;
    private String text = "";

    public SlotDevice(String name,Paint paint, Dimension size,
                      Point2D position) {
        super(name,paint);
        this.size = size;
        this.position = position;
        //this.angle = 0;
        this.originalAngle = 0;
        setOldSize(size);
        setOldPosition(position);
    }

    public SlotDevice(String name) {
        super(name);
    }

    public Dimension getSize() {
        return size;
    }

    public void setSize(Dimension size) {
        this.size = size;
    }

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }

    public double getScale() { return scale; }

    public void setScale(double scale) {
        this.scale = scale;
        setPosition(position);
    }

    public Dimension getOldSize() { return oldSize; }

    public void setOldSize(Dimension oldSize) {

        if (!(oldSize == null)){
            this.oldSize = oldSize;
        }else{
            this.oldSize = size;
        }
    }

    public SlotType getType() {
        return type;
    }

    public void setType(SlotType type) {
        this.type = type;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public double getAngle() {return angle;}

    public void setAngle(double angle) {this.angle = angle;}

    public double getOriginalAngle() {
        return originalAngle;
    }

    public void setOriginalAngle(double originalAngle) {
        this.originalAngle = originalAngle;
    }

    public Point2D getOldPosition() {
        return oldPosition;
    }

    public void setOldPosition(Point2D oldPosition) {

        if (!(oldPosition == null)){
            this.oldPosition = oldPosition;
        }else {
            this.oldPosition = position;
        }
    }

    public void writeInFile(String text){

        try {
            PrintWriter out = new PrintWriter(file.getAbsolutePath());
            out.println(text);
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fajl nije ucitan");
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
