package app.command;

import app.repository.Page;
import app.repository.elements.SlotDevice;
import app.repository.factory.CircleFactory;
import app.repository.factory.RectangleFactory;
import app.repository.factory.SlotFactory;
import app.repository.factory.TriangleFactory;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class DeleteCommand extends AbstractCommand{

    private Page page;
    private ArrayList<SlotDevice> group;


    public DeleteCommand(Page page) {
        this.page = page;
        this.group = new ArrayList<>(this.page.getSelectedSlots());
    }

    @Override
    public void doCommand() {
        page.deleteAllSelectedSlots();
    }

    @Override
    public void undoCommand() {
        page.addSlotElements(group);
        page.getSelectedSlots().addAll(group);
    }
}
