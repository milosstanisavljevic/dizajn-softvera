package app.guiSwing.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyActionManager {

    private ExitAction exitAction;
    private NewProjectAction newProjectAction;
    private AboutController aboutController;
    private ShareDocumentAction shareDocumentAction;
    private CircleAction circleAction;
    private RectangleAction rectangleAction;
    private TriangleAction triangleAction;
    private RotateAction rotateAction;
    private ScaleAction scaleAction;
    private SelectAction selectAction;
    private MoveAction moveAction;
    private DeleteAction deleteAction;
    private SaveProjectAction saveProjectAction;
    private OpenProjectAction openProjectAction;
    private UndoAction undoAction;
    private RedoAction redoAction;
    private MultimediaSlotAction multimediaSlotAction;
    private TextButtonListener textButtonListener;
    private ImageButtonListener imageButtonListener;
    private EditTextListener editTextListener;
    private ChooseImageAction chooseImageAction;
    private SwitchWs switchWs;

    public MyActionManager() {
        exitAction = new ExitAction();
        newProjectAction = new NewProjectAction();
        aboutController = new AboutController();
        selectAction = new SelectAction();
        shareDocumentAction = new ShareDocumentAction();
        circleAction = new CircleAction();
        rectangleAction = new RectangleAction();
        triangleAction = new TriangleAction();
        rotateAction = new RotateAction();
        scaleAction = new ScaleAction();
        moveAction = new MoveAction();
        deleteAction = new DeleteAction();
        saveProjectAction = new SaveProjectAction();
        openProjectAction = new OpenProjectAction();
        undoAction = new UndoAction();
        redoAction = new RedoAction();
        multimediaSlotAction = new MultimediaSlotAction();
        textButtonListener = new TextButtonListener();
        imageButtonListener = new ImageButtonListener();
        chooseImageAction = new ChooseImageAction();
        editTextListener = new EditTextListener();
        switchWs = new SwitchWs();
    }
}
