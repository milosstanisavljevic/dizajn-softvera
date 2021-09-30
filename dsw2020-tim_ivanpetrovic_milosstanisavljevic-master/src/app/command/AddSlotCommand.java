package app.command;

import app.repository.Page;
import app.repository.elements.SlotDevice;
import app.repository.factory.CircleFactory;
import app.repository.factory.RectangleFactory;
import app.repository.factory.SlotFactory;
import app.repository.factory.TriangleFactory;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class AddSlotCommand extends AbstractCommand{

    Page model;
    Point2D lastPosition;
    SlotDevice device;
    ArrayList<SlotDevice> redoModels;
    String name;
    SlotFactory circleFactory;
    SlotFactory triangleFactory;
    SlotFactory rectangleFactory;

    public AddSlotCommand(Page model, Point2D lastPosition, String name) {
        this.model = model;
        this.lastPosition = lastPosition;
        this.redoModels = new ArrayList<>();
        this.name = name;
        this.circleFactory = new CircleFactory();
        this.triangleFactory = new TriangleFactory();
        this.rectangleFactory = new RectangleFactory();
    }

    @Override
    public void doCommand() {

        if (device == null){

            if (name.equals("Circle")){

                device = circleFactory.makeSlot(lastPosition);
                model.addSlotElement(device);

            }else if(name.equals("Triangle")){

                device = triangleFactory.makeSlot(lastPosition);
                model.addSlotElement(device);

            }else if(name.equals("Rectangle")) {

                device = rectangleFactory.makeSlot(lastPosition);
                model.addSlotElement(device);
            }
        }else{
            model.addSlotElement(device);
        }
    }

    @Override
    public void undoCommand() {
        model.removeSlot(device);
        model.removeAllSelectedSlots();
    }
}
