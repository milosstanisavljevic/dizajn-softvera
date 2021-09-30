package app.repository.elements;

import app.guiSwing.rightPanelView.graphics2d.painters.ElementPainter;
import app.repository.serialization.SerializableStrokeAdapter;

import java.awt.*;
import java.io.Serializable;

public class SlotElement implements Serializable {

    protected SerializableStrokeAdapter stroke;
    protected String name;
    protected Paint paint;


    protected ElementPainter elementPainter;

    public SlotElement(String name,Paint paint){

        this.name = name;
        this.paint = paint;

    }

    public SlotElement(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public ElementPainter getPainter() {
        return elementPainter;
    }

    public void setElementPainter(ElementPainter elementPainter) {
        this.elementPainter = elementPainter;

    }

    public Stroke getStroke() {
        return stroke;
    }

    public void setStroke(Stroke stroke) {
        this.stroke = new SerializableStrokeAdapter(stroke);
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public String toString(){
        return name;
    }


}
