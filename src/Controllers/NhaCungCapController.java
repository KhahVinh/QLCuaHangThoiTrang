
package Controllers;

import Services.NhaCungCapService;
import Views.NhaCungCapView;
import java.util.ArrayList;
import Models.NhaCungCap;

public class NhaCungCapController {
    private NhaCungCapView nhaCungCapView;
    private NhaCungCapService nhaCungCapService ;
    
    public NhaCungCapController(NhaCungCapView nccView) {
        this.nhaCungCapView = nccView;
        this.nhaCungCapService = new NhaCungCapService();
    }
    
    public void showNhaCungCapView() {
        ArrayList<NhaCungCap> list = this.nhaCungCapService.getListNhaCungCap();
        nhaCungCapView.setVisible(true);
        nhaCungCapView.showListData(list);
    }
    
    
}
