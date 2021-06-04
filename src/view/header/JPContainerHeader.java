package view.header;

import presenter.Presenter;

import javax.swing.*;
import java.awt.*;

public class JPContainerHeader extends JPanel {

    private JMenuAllMenus menuAllMenus;
    private Presenter myPresenter;

    public JPContainerHeader(Presenter presenter){
        myPresenter = presenter;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.white);
        initComponents();
    }

    private void initComponents() {
        menuAllMenus = new JMenuAllMenus(myPresenter);
        this.add(menuAllMenus);
    }
}
