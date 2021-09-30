package app.command;

import app.guiSwing.rightPanelView.graphics2d.painters.CirclePainter;
import app.guiSwing.rightPanelView.graphics2d.painters.DevicePainter;
import app.guiSwing.rightPanelView.graphics2d.painters.RectanglePainter;
import app.guiSwing.rightPanelView.graphics2d.painters.TrianglePainter;
import app.repository.Page;
import app.repository.elements.RectangleElement;
import app.repository.elements.SlotDevice;
import app.repository.elements.TriangleElement;
import java.util.ArrayList;

public class RotateCommand extends AbstractCommand{

    private Page page;
    private ArrayList<SlotDevice> selectedSlots;
    private ArrayList<Double> oldAngles;
    private ArrayList<Double> angles;

    public RotateCommand(Page page) {

        this.page = page;
        selectedSlots = new ArrayList<>(page.getSelectedSlots());
        oldAngles = new ArrayList<>();
        angles = new ArrayList<>();

        for(SlotDevice p: selectedSlots) {
            oldAngles.add(p.getAngle());
        }
    }

    @Override
    public void doCommand() {
        if(!page.getSelectedSlots().isEmpty()) {

            for(int i = 0; i <selectedSlots.size(); i++) {

                SlotDevice slot = selectedSlots.get(i);
                ((DevicePainter)slot.getPainter()).setShape(((DevicePainter)slot.getPainter()).getShape());
                slot.setAngle(slot.getAngle() + slot.getAngle());
                angles.add(slot.getAngle());
                slot.setAngle(angles.get(i));

                if(slot instanceof RectangleElement)
                    slot.setElementPainter(new RectanglePainter(slot));
                else if(slot instanceof TriangleElement)
                    slot.setElementPainter(new TrianglePainter(slot));
                else
                    slot.setElementPainter(new CirclePainter(slot));
            }
        }
        page.notifyListeners(this);
    }

    @Override
    public void undoCommand() {

        for(int i = 0; i < selectedSlots.size(); i++) {
            SlotDevice s = selectedSlots.get(i);
            s.setAngle(oldAngles.get(i));
            s.setAngle(s.getAngle());

            if(s instanceof RectangleElement)
                s.setElementPainter(new RectanglePainter(s));
            else if(s instanceof TriangleElement)
                s.setElementPainter(new TrianglePainter(s));
            else
                s.setElementPainter(new CirclePainter(s));
            System.out.println(s.getPosition().toString());
        }
        page.notifyListeners(this);
    }
}
