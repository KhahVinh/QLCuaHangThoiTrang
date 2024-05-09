
package Component;

import Models.DanhMuc;
import Views.QLSP;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChangeController {
    private ArrayList<DanhMuc> danhmuc = new ArrayList<>();
    private JPanel jpnRoot;
    private String kindSelected = "";

    public ChangeController() {
    }

    public ChangeController(JPanel jpnRoot) {
        this.jpnRoot = jpnRoot;
    }
    
    public void setQLSP(JPanel jpn, JLabel jpl) {
        kindSelected = "QLSP";
        jpnRoot.removeAll();
        jpnRoot.setLayout(new BorderLayout());
        jpnRoot.add(new QLSP());
        jpnRoot.validate();
        jpnRoot.repaint();
    }
}
