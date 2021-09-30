package app.guiSwing.state;

import app.command.AddSlotCommand;
import app.repository.Page;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

public class CircleState extends State {

    private final Page mediator;

    public CircleState(Page mediator) {
        this.mediator = mediator;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        Point2D position = e.getPoint();

        if(e.getButton()==MouseEvent.BUTTON1){
            mediator.getCmdManager().addCommand(new AddSlotCommand(mediator,position,"Circle"));
        }
    }
}
