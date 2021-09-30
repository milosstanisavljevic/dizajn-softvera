package app.guiSwing.rightPanelView;

import app.guiSwing.controller.ActionEnum;
import app.observer.IListener;
import app.repository.Document;
import app.repository.Page;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.util.ArrayList;

@Getter
@Setter
public class DocumentView extends JPanel implements IListener {

    private Document document;
    private JLabel docName;
    private ArrayList<PageView> pageViews;
    private PageView pageView;
    private JPanel panel;
    private JScrollPane scrollPane;
    private JSplitPane splitPane;


    public DocumentView(Document document) {
        this.document = document;
        this.document.addListener(this);
        //this.setLayout(new FlowLayout());
        pageViews = new ArrayList<>();
        docName = new JLabel(document.getName());
        this.pageView = pageView;
    }

    @Override
    public void update(Object update) {
        System.out.println("ulazi u update document");
        if (update == ActionEnum.ACTION_ADD) {
            addPage();
        }
        if (update == ActionEnum.ACTION_RENAME) {
            docName.setText(document.getName());

        }
    }

    public void addPage() {
        System.out.println("add PAGE");

        Page page = (Page) document.getChildAt(document.getChildCount() - 1);
        PageView pageView = new PageView(page);
        pageViews.add(pageView);
        this.add(page.getName(), pageView);


    }

    public ArrayList<PageView> getPageViews() {
        return pageViews;
    }

    public PageView getPageView() {
        return pageView;
    }

}
