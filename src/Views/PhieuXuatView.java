package Views;

import javax.swing.table.DefaultTableModel;
import IO.PhieuXuatIO;
import Models.PhieuXuat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Models.Product;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JFrame;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
public class PhieuXuatView extends javax.swing.JPanel {
    static int checkFeature;
    static int vitrisuaphieu;
    static String[] ColumnName = {"Mã phiếu xuất","Tên khách hàng", "Số điện thoại", "Ngày tạo","Địa chỉ", "Tổng tiền"};
    static DefaultTableModel dtmPhieuXuat = new DefaultTableModel(ColumnName, 0);
    private PhieuXuatIO phieuxuatIO = new PhieuXuatIO();
    private String FILE_NAME_XH = "QuanLyPhieuXuat.txt";
    private String PHIEU_XUAT_PDF = "PhieuXuat.pdf";
    private ArrayList<PhieuXuat> listPhieuXuat = new ArrayList<>();

    public PhieuXuatView() {
        initComponents();
        Init();
        this.updateTable();
    }

    private void Init() {
        try {
            phieuxuatIO.readFilePX(FILE_NAME_XH);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Lỗi", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
        updateTable();
    }

    public void addPhieu(PhieuXuat phieuxuat) {
        listPhieuXuat.add(phieuxuat);
        updateTable();
    }
    
    private void showMessage(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE);
    }
    
    public void updateTable() {
        NumberFormat format = NumberFormat.getInstance(Locale.US);
        this.listPhieuXuat.clear();
        this.listPhieuXuat = phieuxuatIO.readFilePX(FILE_NAME_XH);
        dtmPhieuXuat.setRowCount(0);
        for (PhieuXuat phieuxuat : listPhieuXuat) {
            String formattedNumber = format.format(phieuxuat.getTien());
            String price = formattedNumber;
            Object[] rowData = {phieuxuat.getMaPhieu(),phieuxuat.getTenKH(), phieuxuat.getSdtKH(), phieuxuat.getNgayTao(),phieuxuat.getDiaChi(), price};
            dtmPhieuXuat.addRow(rowData);
        }
        TablePhieuXuat.setModel(dtmPhieuXuat);
    }

    private void displayFunctions(String name, JPanel jpl,int width, int height) {
        JFrame newFrame = new JFrame(name);
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newFrame.setSize(width, height);
        newFrame.add(jpl);
        newFrame.setVisible(true);
        newFrame.setLocationRelativeTo(null);
    }
    
    public void getListSPDetail(int index){
        ArrayList<PhieuXuat> listPhieuXuat = new ArrayList<>();
        listPhieuXuat = phieuxuatIO.readFilePX(FILE_NAME_XH);
        ArrayList<Product> listDetailSP = new ArrayList<>();
        PhieuXuat px = null;
        if(index == -1 ){
            showMessage("Bạn chưa chọn phiếu để xem", "Thông báo");
        }
        else {
            NumberFormat format = NumberFormat.getInstance(Locale.US);
            String maPhieuCheck = (String) TablePhieuXuat.getValueAt(index, 0);
            for (int i = 0; i < listPhieuXuat.size(); i++) {
                if(listPhieuXuat.get(index).getMaPhieu().equals(maPhieuCheck)){
                    String maPhieu = listPhieuXuat.get(index).getMaPhieu();
                    String tenKH = listPhieuXuat.get(index).getTenKH();
                    String sdtKH = listPhieuXuat.get(index).getSdtKH();
                    String diaChi = listPhieuXuat.get(index).getDiaChi();
                    long tongtien = listPhieuXuat.get(index).getTien();
                    String formattedNumber = format.format(tongtien);
                    String totalPrice = formattedNumber;
                    listDetailSP = listPhieuXuat.get(index).getDanhsachsanphamxuat();  
                    PhieuXuatDetail phieuXuatDetail = new PhieuXuatDetail(index,maPhieu, tenKH, sdtKH, (String)TablePhieuXuat.getValueAt(index, 2), listDetailSP, diaChi,totalPrice);
                    displayFunctions("Chi tiết phiếu xuất", phieuXuatDetail,825,520);                 
                    break;
                }
            }
        }
    }

    private void delete() {
        ArrayList<PhieuXuat> danhsachhientai = new ArrayList<>();
        danhsachhientai = phieuxuatIO.readFilePX(FILE_NAME_XH);
        ArrayList<PhieuXuat> listphieuxuatsauxoa = new ArrayList<>();
        int index = -1;
        index = TablePhieuXuat.getSelectedRow();
        if(index == -1) {
            showMessage("Bạn chưa chọn phiếu để xóa", "Thông báo");
        } else {
            int select = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if(select == 0){
                danhsachhientai.remove(index);
                listphieuxuatsauxoa = danhsachhientai;
                PrintWriter writer;
                try {
                    writer = new PrintWriter(FILE_NAME_XH);
                    writer.print("");
                    writer.close();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(QLSP.class.getName()).log(Level.SEVERE, null, ex);
                }
                for (PhieuXuat phieuxuat : listphieuxuatsauxoa) {
                    phieuxuatIO.writePhieuXuat(phieuxuat, listphieuxuatsauxoa);
                }
            index --;
            updateTable();
            JOptionPane.showMessageDialog(null,"Xóa thành công" , "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    private void Modify () {
        DefaultTableModel dtmThongTin;
        DefaultTableModel dtmXuat;
        
        ArrayList<PhieuXuat> danhsachhientai = new ArrayList<>();
        danhsachhientai = phieuxuatIO.readFilePX(FILE_NAME_XH);
        ArrayList<PhieuXuat> listphieuxuatsauxoa = new ArrayList<>();
        ArrayList<Product> listsanpham = new ArrayList<>();
        vitrisuaphieu = -1;
        vitrisuaphieu = TablePhieuXuat.getSelectedRow();
        if(vitrisuaphieu == -1){
            showMessage("Bạn chưa chọn sản phẩm để sửa", "Thông báo");
        } else {
            String maPhieu = danhsachhientai.get(vitrisuaphieu).getMaPhieu();
            String tenKH = danhsachhientai.get(vitrisuaphieu).getTenKH();
            String sdtKH = danhsachhientai.get(vitrisuaphieu).getSdtKH();
            String diaChi = danhsachhientai.get(vitrisuaphieu).getDiaChi();
            long tongTien = danhsachhientai.get(vitrisuaphieu).getTien();
            listsanpham = danhsachhientai.get(vitrisuaphieu).getDanhsachsanphamxuat();
            QLXH qlxh = new QLXH(maPhieu,tenKH, sdtKH, diaChi, listsanpham, tongTien);
            qlxh.btnXuat.setText("Cập nhật");
            qlxh.updateTableModifyPX();
            displayFunctions(FILE_NAME_XH,qlxh,1000,800 );
        }
    }
    
    private void searchPhieu() {
    ArrayList<Product> danhsachsanphamtimkiem = new ArrayList<>();
    danhsachsanphamtimkiem = phieuxuatIO.readFilePX(FILE_NAME_XH);
    String name = JtfSearch.getText();
    try {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(dtmPhieuXuat);
        TablePhieuXuat.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + name, 1));
    } catch (Exception e) {
        showMessage("Lỗi", "Thông báo");
    }
}

    private void exportPDF() {
    Document doc = new Document();
    File f = new File(PHIEU_XUAT_PDF);
    ArrayList<PhieuXuat> listPhieuXuat = new ArrayList<>();
    listPhieuXuat = phieuxuatIO.readFilePX(FILE_NAME_XH);
    int viTriXuat = -1;
    viTriXuat = TablePhieuXuat.getSelectedRow();
    if (viTriXuat == -1) {
        showMessage("Bạn chưa chọn sản phẩm để in phiếu xuất", "Thông báo");
    } else {
        try {
            if (!f.exists()) {
                f.createNewFile();
            } else {
                f.delete();
                f.createNewFile();
            }

            PdfWriter.getInstance(doc, new FileOutputStream(f));
            doc.open();

            BaseFont bf = BaseFont.createFont("c:\\windows\\fonts\\times.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font f1 = new Font(bf, 18, Font.BOLD);
            Font f2 = new Font(bf, 12);

            Paragraph p1 = new Paragraph("THÔNG TIN PHIẾU XUẤT\n\n", f1);
            p1.setAlignment(Element.ALIGN_CENTER);
            doc.add(p1);

            Paragraph p2 = new Paragraph("Mã phiếu: " + listPhieuXuat.get(viTriXuat).getMaPhieu()
                    + "\nTên khách hàng: " + listPhieuXuat.get(viTriXuat).getTenKH()
                    + "\nSố điện thoại: " + listPhieuXuat.get(viTriXuat).getSdtKH()
                    + "\nĐịa chỉ: " + listPhieuXuat.get(viTriXuat).getDiaChi() + "\n\n", f2);
            doc.add(p2);

            PdfPTable tb = new PdfPTable(5);

            tb.addCell(new Paragraph("Mã sản phẩm", f2));
            tb.addCell(new Paragraph("Tên sản phẩm", f2));
            tb.addCell(new Paragraph("Loại", f2));
            tb.addCell(new Paragraph("Số lượng", f2));
            tb.addCell(new Paragraph("Giá bán", f2));
            ArrayList<Product> listSP = new ArrayList<>();
            listSP = listPhieuXuat.get(viTriXuat).getDanhsachsanphamxuat();
            for (int i = 0; i < listSP.size(); i++) {

                String Ma = listSP.get(i).getProductID();
                String Ten = listSP.get(i).getProductName();
                String Loai = listSP.get(i).getProductCategory();
                int soLuong = listSP.get(i).getProductQuantity();
                long giaBan = listSP.get(i).getProductPrice();

                tb.addCell(new Paragraph(Ma, f2));
                tb.addCell(new Paragraph(Ten, f2));
                tb.addCell(new Paragraph(Loai, f2));
                tb.addCell(new Paragraph(String.valueOf(soLuong), f2));
                tb.addCell(new Paragraph(String.valueOf(giaBan), f2));
            }

            doc.add(tb);

            Paragraph p3 = new Paragraph("\nTổng tiền: " + listPhieuXuat.get(viTriXuat).getTien(), f2);
            doc.add(p3);

            doc.close();
            JOptionPane.showMessageDialog(this, "Xuất thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

        } catch (FileNotFoundException | DocumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        ButtonExportPDF = new javax.swing.JButton();
        ButtonDetail = new javax.swing.JButton();
        ButtonModify = new javax.swing.JButton();
        ButtonDelete = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        JtfSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablePhieuXuat = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.GridLayout(1, 3, 16, 0));

        ButtonExportPDF.setBackground(new java.awt.Color(75, 174, 79));
        ButtonExportPDF.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ButtonExportPDF.setForeground(new java.awt.Color(255, 255, 255));
        ButtonExportPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/icon/pdf (1).png"))); // NOI18N
        ButtonExportPDF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonExportPDF.setLabel("Xuất phiếu");
        ButtonExportPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonExportPDFActionPerformed(evt);
            }
        });
        jPanel5.add(ButtonExportPDF);

        ButtonDetail.setBackground(new java.awt.Color(15, 149, 224));
        ButtonDetail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ButtonDetail.setForeground(new java.awt.Color(255, 255, 255));
        ButtonDetail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/icon/eye (1).png"))); // NOI18N
        ButtonDetail.setText("Chi tiết");
        ButtonDetail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDetailActionPerformed(evt);
            }
        });
        jPanel5.add(ButtonDetail);

        ButtonModify.setBackground(new java.awt.Color(255, 185, 46));
        ButtonModify.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ButtonModify.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/icon/edit-v2 (2).png"))); // NOI18N
        ButtonModify.setText("Chỉnh sửa");
        ButtonModify.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonModifyActionPerformed(evt);
            }
        });
        jPanel5.add(ButtonModify);

        ButtonDelete.setBackground(new java.awt.Color(225, 47, 64));
        ButtonDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ButtonDelete.setForeground(new java.awt.Color(255, 255, 255));
        ButtonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/icon/rubbish-bin (1).png"))); // NOI18N
        ButtonDelete.setText("Xóa");
        ButtonDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDeleteActionPerformed(evt);
            }
        });
        jPanel5.add(ButtonDelete);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        JtfSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchPhieuXH(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JtfSearch)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JtfSearch)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TablePhieuXuat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TablePhieuXuat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TablePhieuXuat.setRowHeight(25);
        jScrollPane1.setViewportView(TablePhieuXuat);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonModifyActionPerformed
        checkFeature = 1;
        Modify();
    }//GEN-LAST:event_ButtonModifyActionPerformed

    private void ButtonDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDetailActionPerformed
        int index = -1;
        index = TablePhieuXuat.getSelectedRow();
        getListSPDetail(index);
    }//GEN-LAST:event_ButtonDetailActionPerformed

    private void ButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDeleteActionPerformed
        delete();
    }//GEN-LAST:event_ButtonDeleteActionPerformed

    private void SearchPhieuXH(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchPhieuXH
        searchPhieu();
    }//GEN-LAST:event_SearchPhieuXH

    private void ButtonExportPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonExportPDFActionPerformed
        exportPDF();
    }//GEN-LAST:event_ButtonExportPDFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonDelete;
    private javax.swing.JButton ButtonDetail;
    private javax.swing.JButton ButtonExportPDF;
    private javax.swing.JButton ButtonModify;
    private javax.swing.JTextField JtfSearch;
    private javax.swing.JTable TablePhieuXuat;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
