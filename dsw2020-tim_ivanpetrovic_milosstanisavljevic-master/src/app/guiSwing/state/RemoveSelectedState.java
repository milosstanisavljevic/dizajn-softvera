package app.guiSwing.state;

import app.command.DeleteCommand;
import app.guiSwing.rightPanelView.PageView;
import app.guiSwing.rightPanelView.graphics2d.painters.DevicePainter;
import app.repository.Page;
import app.repository.elements.SlotDevice;
import app.repository.elements.SlotElement;
import app.repository.node.Node;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

public class RemoveSelectedState extends State{

    private Page mediator;

    public RemoveSelectedState(Page mediator) {
        this.mediator = mediator;
    }

    @Override
    public void mousePressed(MouseEvent e) {

        mediator.getCmdManager().addCommand(new DeleteCommand(mediator));
        mediator.notifyListeners(this);
    }
}