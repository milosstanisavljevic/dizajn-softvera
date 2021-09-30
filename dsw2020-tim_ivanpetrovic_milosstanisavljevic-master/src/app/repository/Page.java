package app.repository;

import app.command.CommandManager;
import app.guiSwing.controller.ActionEnum;
import app.repository.elements.SlotDevice;
import app.repository.elements.SlotElement;
import app.repository.node.Node;
import app.repository.node.NodeComposite;
import app.guiSwing.state.StateMenager;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Page extends NodeComposite implements Serializable {

    private transient StateMenager manager= new StateMenager(this);
    private transient CommandManager cmdManager = new CommandManager();
    protected ArrayList<SlotDevice>slotElements = new ArrayList<>();
    private SlotDevice selectedSlot;
    protected ArrayList<SlotDevice> selectedSlots = new ArrayList<>();
    private Rectangle lassoRec;
    private Point oldPoint;
    private Point newPoint;
    private boolean startLasso = false;
    
    public Page(String name, Node parent) {
        super(name, parent);
    }

    @Override
    public NodeComposite getChildAt(int index) {

        return (NodeComposite) this.getChildren().get(index);
    }

    @Override
    public int getChildCount() {
        return this.getChildren().size();

    }

    @Override
    public void addChild(Node child) {
        if (child != null && child instanceof Slot) {
            Slot slot = (Slot) child;
            if (!this.getChildren().contains(slot)) {
                this.getChildren().add(slot);
                this.notifyListeners(ActionEnum.ACTION_ADD);
                this.notifyListeners(ActionEnum.ACTION_RENAME);
            }
        }
    }

   public StateMenager getManager() {
        return manager;
    }
    public void startRectangleState(){
        manager.setRectangleState();
   }
   public void startCircleState(){ manager.setCircleState(); }
   public void startTriangleState(){
        manager.setTriangleState();
   }
   public void startSelectState(){manager.setSelectState();}
   public void startMoveState(){manager.setMoveState();}
   public void startResizeState(){manager.setResizeState();}
   public void startRotateState(){manager.setRotateState();}
   public void startDeleteAction(){manager.setDeleteAction();}
   public void startLassoState(){manager.setLassoState();}

   public int getDeviceAtPosition(Point2D point) {
        for(int i=getDeviceCount()-1;i>=0;i--){
            SlotElement element = getDeviceAt(i);
            if(element.getPainter().elementAt(point)){
                return i;
            }
        }
        return -1;
    }

    public int getDeviceCount(){
        return slotElements.size();
    }

    public SlotDevice getDeviceAt(int i){
        return slotElements.get(i);
    }

    public int getElementCount(){
        return slotElements.size();
    }

    public Iterator<SlotDevice> getDeviceIterator(){
        return slotElements.iterator();
    }

    public void addSlotElement(SlotDevice element){

        if (!(slotElements.contains(element))){
            slotElements.add(element);
        }
        notifyListeners(element);
    }

    public void addSlotElements(ArrayList<SlotDevice> elements){

        if (!(slotElements.contains(elements))) {
            slotElements.addAll(elements);
        }
        notifyListeners(elements);
    }

    public SlotDevice getSelectedSlot() {
        return selectedSlot;
    }

    public void setSelectedSlot(SlotDevice selectedSlot) {
        this.selectedSlot = selectedSlot;
    }

    public ArrayList<SlotDevice> getSlotElements() {
        return slotElements;
    }
    
    public void removeSlot(SlotDevice s){
        this.slotElements.remove(s);
        notifyListeners(s);
    }
    public void removeSlots(ArrayList<SlotDevice> s){
        this.slotElements.removeAll(s);
        notifyListeners(s);
    }

    public ArrayList<SlotDevice> getSelectedSlots() {
        return selectedSlots;
    }

    public void setSelectedSlots(ArrayList<SlotDevice> selectedSlots) {
        this.selectedSlots = selectedSlots;
    }

    public void addSelectedSlot(SlotDevice element){
        selectedSlots.add(element);
        notifyListeners(element);
    }

    public void addSelectedSlots (ArrayList<SlotDevice> elements){
        selectedSlots.addAll(elements);
        notifyListeners(elements);
    }
    public void removeAllSelectedSlots(){

        for (int i=0;i<selectedSlots.size();i++){
           selectedSlots.get(i).setPaint(Color.RED);
           selectedSlots.remove(i);
        }
        notifyListeners(this);
    }

    public void deleteAllSelectedSlots(){
        slotElements.removeAll(selectedSlots);
        selectedSlots.clear();
        notifyListeners(this);
    }

    public Rectangle getLassoRec() {
        return lassoRec;
    }

    public void setLassoRec(Rectangle lassoRec) {
        this.lassoRec = lassoRec;
    }

    public Point getOldPoint() {
        return oldPoint;
    }

    public void setOldPoint(Point oldPoint) {
        this.oldPoint = oldPoint;
    }

    public Point getNewPoint() {
        return newPoint;
    }

    public void setNewPoint(Point newPoint) {
        this.newPoint = newPoint;
    }

    public boolean isStartLasso() {
        return startLasso;
    }

    public void setStartLasso(boolean startLasso) {
        this.startLasso = startLasso;
    }

    public CommandManager getCmdManager() {
        return cmdManager;
    }

    public void setCmdManager(CommandManager cmdManager) {
        this.cmdManager = cmdManager;
    }
}
