package Views;
import Component.ChangeController;
import Models.DanhMuc;
import java.util.ArrayList;
public class GiaoDien extends javax.swing.JFrame {
    public GiaoDien() {
        initComponents();
        changeController();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JMenu = new javax.swing.JPanel();
        JQLSP = new javax.swing.JPanel();
        QLSP = new javax.swing.JLabel();
        JQLDM = new javax.swing.JPanel();
        QLDM = new javax.swing.JLabel();
        JQLNH = new javax.swing.JPanel();
        QLNH = new javax.swing.JLabel();
        JQLXH = new javax.swing.JPanel();
        QLXH = new javax.swing.JLabel();
        JUser = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JDisplay = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JMenu.setBackground(new java.awt.Color(102, 102, 102));

        QLSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        QLSP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        QLSP.setText("Quản lý sản phẩm");

        javax.swing.GroupLayout JQLSPLayout = new javax.swing.GroupLayout(JQLSP);
        JQLSP.setLayout(JQLSPLayout);
        JQLSPLayout.setHorizontalGroup(
            JQLSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JQLSPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(QLSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        JQLSPLayout.setVerticalGroup(
            JQLSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JQLSPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(QLSP, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        QLDM.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        QLDM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        QLDM.setText("Quản lí danh mục");

        javax.swing.GroupLayout JQLDMLayout = new javax.swing.GroupLayout(JQLDM);
        JQLDM.setLayout(JQLDMLayout);
        JQLDMLayout.setHorizontalGroup(
            JQLDMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JQLDMLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(QLDM, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addContainerGap())
        );
        JQLDMLayout.setVerticalGroup(
            JQLDMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JQLDMLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(QLDM, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        QLNH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        QLNH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        QLNH.setText("Quản lí nhập hàng");

        javax.swing.GroupLayout JQLNHLayout = new javax.swing.GroupLayout(JQLNH);
        JQLNH.setLayout(JQLNHLayout);
        JQLNHLayout.setHorizontalGroup(
            JQLNHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JQLNHLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(QLNH, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addContainerGap())
        );
        JQLNHLayout.setVerticalGroup(
            JQLNHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JQLNHLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(QLNH, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        QLXH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        QLXH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        QLXH.setText("Quản lí xuất hàng");

        javax.swing.GroupLayout JQLXHLayout = new javax.swing.GroupLayout(JQLXH);
        JQLXH.setLayout(JQLXHLayout);
        JQLXHLayout.setHorizontalGroup(
            JQLXHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JQLXHLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(QLXH, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addContainerGap())
        );
        JQLXHLayout.setVerticalGroup(
            JQLXHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JQLXHLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(QLXH, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout JUserLayout = new javax.swing.GroupLayout(JUser);
        JUser.setLayout(JUserLayout);
        JUserLayout.setHorizontalGroup(
            JUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        JUserLayout.setVerticalGroup(
            JUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout JMenuLayout = new javax.swing.GroupLayout(JMenu);
        JMenu.setLayout(JMenuLayout);
        JMenuLayout.setHorizontalGroup(
            JMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JQLSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JQLDM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JQLNH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JQLXH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        JMenuLayout.setVerticalGroup(
            JMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JQLSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(JQLDM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(JQLNH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(JQLXH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 267, Short.MAX_VALUE)
                .addComponent(JUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        JDisplay.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout JDisplayLayout = new javax.swing.GroupLayout(JDisplay);
        JDisplay.setLayout(JDisplayLayout);
        JDisplayLayout.setHorizontalGroup(
            JDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 703, Short.MAX_VALUE)
        );
        JDisplayLayout.setVerticalGroup(
            JDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GiaoDien().setVisible(true);
                new GiaoDien().setDefaultCloseOperation(EXIT_ON_CLOSE);
            }
        });
    }
    public void changeController() {
        ChangeController ccl = new ChangeController(JDisplay);
        ccl.setQLSP(JQLSP, QLDM);
        ArrayList<DanhMuc> danhmuc = new ArrayList<>();
//        danhmuc.add(new DanhMuc("QLSP", JQLSP, QLSP));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JDisplay;
    private javax.swing.JPanel JMenu;
    private javax.swing.JPanel JQLDM;
    private javax.swing.JPanel JQLNH;
    private javax.swing.JPanel JQLSP;
    private javax.swing.JPanel JQLXH;
    private javax.swing.JPanel JUser;
    private javax.swing.JLabel QLDM;
    private javax.swing.JLabel QLNH;
    private javax.swing.JLabel QLSP;
    private javax.swing.JLabel QLXH;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
