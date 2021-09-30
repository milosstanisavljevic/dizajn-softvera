package app.guiSwing.view;

import app.core.Repository;
import app.errorHandler.Error;
import app.guiSwing.controller.MyActionManager;
import app.guiSwing.controller.MyWindowListener;
import app.guiSwing.rightPanelView.DocumentView;
import app.guiSwing.rightPanelView.PageView;
import app.guiSwing.rightPanelView.ProjectView;
import app.guiSwing.tree.Tree;
import app.guiSwing.tree.view.TreeImplementation;
import app.repository.Project;
import app.repository.Workspace;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {

    private static MainFrame instance;
    private MyActionManager actionManager;
    private Repository documentRepository;
    private Tree tree;
    private JTree workspaceTree;
    private MyJMenuBar menuBar;
    private MyJToolBar toolBar;
    private Palette palette;
    private JSplitPane splitPane;
    private JPanel pWork;
    private ProjectView projectView;

    private MainFrame() {
    }

    private void initialiseActionManager() {
        actionManager = new MyActionManager();
    }

    public void initialiseWorkspaceTree() {
        tree = new TreeImplementation();
        workspaceTree = tree.generateTree(documentRepository.getWorkspace());

        initialiseGUI();
    }

    private void initialiseGUI() {

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height / 2;
        int screenWidth = screenSize.width / 2;
        setSize(screenWidth, screenHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(new MyWindowListener());
        addWindowListener(new OpenWs(this));
        addWindowListener(new SaveWs(this));
        // URL link = getClass().getResource("/pictures/icon.png");
        // ImageIcon image = new ImageIcon(link);
        // setIconImage(image.getImage());
        setTitle("RuDok");
        setLocationRelativeTo(null);

        menuBar = new MyJMenuBar();
        setJMenuBar(menuBar);

        toolBar = new MyJToolBar();
        add(toolBar, BorderLayout.NORTH);

        palette = new Palette();
        add(palette, BorderLayout.EAST);

        JScrollPane scrollPane = new JScrollPane(workspaceTree);

        pWork = new JPanel();
        pWork.setLayout(new BorderLayout());
        pWork.setBackground(Color.WHITE);
        JScrollPane pane = new JScrollPane(pWork);

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane, pane);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(200);

        add(splitPane, BorderLayout.CENTER);
    }

    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
        }
        return instance;
    }

    public MyActionManager getActionManager() {
        return actionManager;
    }

    public void setDocumentRepository(Repository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public JTree getWorkspaceTree() {
        return workspaceTree;
    }

    public void setWorkspaceTree(JTree workspaceTree) {
        this.workspaceTree = workspaceTree;
    }

    public Tree getTree() {
        return tree;
    }

    public void createProjectView(Project project) {
        this.projectView = new ProjectView(project);
        this.pWork.removeAll();
        this.pWork.add(projectView);
        this.pWork.updateUI();
    }

    public JPanel getpWork() {
        return pWork;
    }

    public Workspace getWorkspace(){
        return documentRepository.getWorkspace();
    }

    public JSplitPane getSplitPane() {
        return splitPane;
    }

    public void setSplitPane(JSplitPane splitPane) {
        this.splitPane = splitPane;
    }

    public void showError(Error notification) {
        JOptionPane.showMessageDialog(this, notification.getMessage(), notification.getTitle(), JOptionPane.WARNING_MESSAGE);
    }

    public ProjectView getProjectView() {
        return projectView;
    }
}