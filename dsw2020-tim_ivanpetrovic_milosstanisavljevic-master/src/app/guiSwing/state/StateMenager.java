package app.guiSwing.state;

import app.repository.Page;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class StateMenager implements Serializable {

    private State currentState;
    CircleState circleState;
    RectangleState rectangleState;
    TriangleState triangleState;
    SelectState selectState;
    LassoState lassoState;
    MoveState moveState;
    ResizeState resizeState;
    RotateState rotateState;
    RemoveSelectedState removeSelectedState;

    public StateMenager(Page mediator) {

        this.circleState = new CircleState(mediator);
        this.rectangleState = new RectangleState(mediator);
        this.triangleState = new TriangleState(mediator);
        this.selectState = new SelectState(mediator);
        this.lassoState = new LassoState(mediator);
        this.moveState = new MoveState(mediator);
        this.resizeState = new ResizeState(mediator);
        this.rotateState = new RotateState(mediator);
        this.removeSelectedState = new RemoveSelectedState(mediator);

        currentState = selectState;
    }

    public State getCurrentState() {
        return currentState;
    }

    public SelectState getSelectState() {
        return selectState;
    }

    public void setCircleState() { currentState = circleState; }
    public void setRectangleState(){ currentState = rectangleState; }
    public void setTriangleState(){ currentState = triangleState;}
    public void setSelectState(){ currentState = selectState;}
    public void setLassoState() { currentState = lassoState;}
    public void setMoveState(){ currentState = moveState;}
    public void setResizeState(){ currentState = resizeState;}
    public void setRotateState(){ currentState = rotateState;}
    public void setDeleteAction(){ currentState = removeSelectedState;}
}
