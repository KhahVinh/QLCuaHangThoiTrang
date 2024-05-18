package Views;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class QLTKhoan extends javax.swing.JPanel {

    String filePassword = "password.dat";
    File f = new File(filePassword);

    public QLTKhoan() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Header = new javax.swing.JPanel();
        titleDoiMatKhau = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        titleTK = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        titleMKCu = new javax.swing.JLabel();
        txtMKC = new javax.swing.JTextField();
        titleMKMoi = new javax.swing.JLabel();
        txtMKM = new javax.swing.JTextField();
        titleNhapLai = new javax.swing.JLabel();
        txtNhapLai = new javax.swing.JTextField();
        btnCapNhap = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 102, 102));
        setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 1, new java.awt.Color(0, 0, 0)));

        titleDoiMatKhau.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        titleDoiMatKhau.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleDoiMatKhau.setText("ĐỔI MẬT KHẨU");
        titleDoiMatKhau.setToolTipText("");

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleDoiMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
                .addContainerGap())
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleDoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleTK.setText("TÀI KHOẢN");
        jPanel2.add(titleTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 70, 170, 28));

        jTextField5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField5.setText("admin");
        jTextField5.setToolTipText("");
        jPanel2.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 100, 245, 30));

        titleMKCu.setText("MẬT KHẨU CŨ");
        jPanel2.add(titleMKCu, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 160, 170, 28));

        txtMKC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.add(txtMKC, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 190, 245, 30));

        titleMKMoi.setText("MẬT KHẨU MỚI");
        jPanel2.add(titleMKMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 250, 170, 28));

        txtMKM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.add(txtMKM, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 280, 245, 30));

        titleNhapLai.setText("NHẬP LẠI MẬT KHẨU");
        jPanel2.add(titleNhapLai, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 340, 170, 28));

        txtNhapLai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.add(txtNhapLai, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 370, 245, 30));

        btnCapNhap.setText("CẬP NHẬP");
        btnCapNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhapActionPerformed(evt);
            }
        });
        jPanel2.add(btnCapNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, 110, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCapNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhapActionPerformed
        String mkCu = txtMKC.getText();
        String mkMoi = txtMKM.getText();
        String nhaplai = txtNhapLai.getText();

        StringBuilder sb = new StringBuilder();

        if (mkCu.trim().equals("")) {
            sb.append("Mật khẩu cũ đang bị rỗng\n");
        }
        if (mkMoi.trim().equals("")) {
            sb.append("Mật khẩu mới đang bị rỗng\n");
        }
        if (nhaplai.trim().equals("")) {
            sb.append("Mật khẩu nhập lại đang bị rỗng\n");
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this,
                    sb.toString(),
                    "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String cu = br.readLine();
            if(evt.getSource() == btnCapNhap){
                while (cu != null) {                    
                    if(mkCu.equals(cu)){
                        if(!nhaplai.equals(mkMoi) )
                        {
                            JOptionPane.showMessageDialog(this, "Nhập mật khẩu lại không đúng", "Thông báo", JOptionPane.ERROR_MESSAGE);
                        }else{
                            br.close();
                            fr.close();
                            PrintWriter pw = new PrintWriter(f);
                            pw.println(mkMoi);
                            pw.flush();
                            pw.close();
                            JOptionPane.showMessageDialog(this, "Cập nhập thành công");
                        }
                    }else{
                        JOptionPane.showMessageDialog(this, "Nhập sai mật khẩu cũ", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnCapNhapActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JButton btnCapNhap;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel titleDoiMatKhau;
    private javax.swing.JLabel titleMKCu;
    private javax.swing.JLabel titleMKMoi;
    private javax.swing.JLabel titleNhapLai;
    private javax.swing.JLabel titleTK;
    private javax.swing.JTextField txtMKC;
    private javax.swing.JTextField txtMKM;
    private javax.swing.JTextField txtNhapLai;
    // End of variables declaration//GEN-END:variables
}
