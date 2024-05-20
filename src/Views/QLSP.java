package Views;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.border.Border;
import javax.swing.JOptionPane;
import Component.ListProduct;
import Component.ReadWriteProduct;
import Models.Product;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static Views.DienThongTInSanPham.danhsachsanpham;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
public class QLSP extends javax.swing.JPanel {
static String[] columnName = {"Mã sản phẩm", "Tên Sản phẩm", "Loại", "Tình trạng", "Giá bán"};
    static DefaultTableModel dtmProduct = new DefaultTableModel(columnName, 0);
    static ListProduct listProduct = new ListProduct();
    ReadWriteProduct rwp = new ReadWriteProduct();
    String fileName = "QuanLySanPham.txt"; 
    public QLSP() {
        initComponents();
        Init();
    }

    private void Init() {
       try {
            rwp.readFile(fileName, danhsachsanpham);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Danh sach hien tai rong");
        }
        updateTable();
    }

    public void addProduct(Product product) {
        danhsachsanpham.add(product);
        updateTable();
    }

    public void updateTable() {
        NumberFormat format = NumberFormat.getInstance(Locale.US);
        dtmProduct.setRowCount(0);
        for (Product product : danhsachsanpham) {
            String formattedNumber = format.format(product.getProductPrice());
            String price = formattedNumber;
            Object[] rowData = {product.getProductID(), product.getProductName(), product.getProductCategory(), product.getProductStock(), price};
            dtmProduct.addRow(rowData);
        }
        TableProduct.setModel(dtmProduct);
//        jlbQuanlityProduct.setText("Tổng số sản phẩm " + danhsachsanpham.size());
    }
    
    private void searchProduct() {
        ArrayList<Product> danhsachsanphamtimkiem = new ArrayList<>();;
        String name = SearchText.getText();
        try {
            if (name.trim().length() == 0) {
                dtmProduct = new DefaultTableModel(columnName, 0);
                danhsachsanphamtimkiem = listProduct.findAll(danhsachsanpham, name);
                listProduct.displayData(dtmProduct, danhsachsanphamtimkiem);
            } else {
                dtmProduct = new DefaultTableModel(columnName, 0);
                danhsachsanphamtimkiem = listProduct.searchProduct(danhsachsanpham, name);
                listProduct.displayData(dtmProduct, danhsachsanphamtimkiem);
                if (danhsachsanphamtimkiem.isEmpty()) {
                    JOptionPane.showMessageDialog(TableProduct, "Không tìm thấy sản phẩm " + name, "Thông báo", JOptionPane.WARNING_MESSAGE);
                    danhsachsanphamtimkiem = listProduct.findAll(danhsachsanpham, name);
                    listProduct.displayData(dtmProduct, danhsachsanphamtimkiem);
                }
            }
            TableProduct.setModel(dtmProduct);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void deleteProduct() {
        ArrayList<Product> danhsachsauxoa = new ArrayList<>();
        int vitri = -1;
        vitri = TableProduct.getSelectedRow();
        if (vitri == -1) {
            JOptionPane.showMessageDialog(TableProduct, "Bạn chưa chọn sản phẩm xóa", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else {
            int a = JOptionPane.showConfirmDialog(TableProduct, "Bạn có muốn xóa không", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (a == 0) {
                danhsachsanpham.remove(vitri);
                danhsachsauxoa = danhsachsanpham;
                PrintWriter writer;
                try {
                    writer = new PrintWriter(fileName);
                    writer.print("");
                    writer.close();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(QLSP.class.getName()).log(Level.SEVERE, null, ex);
                }
                for (Product product : danhsachsauxoa) {

                    rwp.writeFile(product, fileName, danhsachsauxoa);
                }
                updateTable();
                vitri--;
                updateTable();
                JOptionPane.showMessageDialog(TableProduct, "Xóa thành công", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
   private void ModifyProduct(){
       int index = TableProduct.getSelectedRow();
       System.out.println(danhsachsanpham.get(index).getProductName());
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Header = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        ButtonAdd = new javax.swing.JButton();
        JDisplayProduct = new javax.swing.JPanel();
        JFeature = new javax.swing.JPanel();
        JSearch = new javax.swing.JPanel();
        SearchText = new javax.swing.JTextField();
        ButtonSearch = new javax.swing.JButton();
        ButtonModify = new javax.swing.JButton();
        ButtonDelete = new javax.swing.JButton();
        Products = new javax.swing.JScrollPane();
        TableProduct = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(204, 204, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Title.setText("Quản Lí Sản Phẩm");

        ButtonAdd.setBackground(new java.awt.Color(0, 51, 255));
        ButtonAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ButtonAdd.setForeground(new java.awt.Color(255, 255, 255));
        ButtonAdd.setText("+ Thêm sản phẩm");
        ButtonAdd.setMargin(new java.awt.Insets(10, 10, 10, 10));
        ButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(Title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonAdd)
                .addGap(34, 34, 34))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JDisplayProduct.setBackground(new java.awt.Color(102, 102, 102));
        JDisplayProduct.setBorder(getBorder());

        JFeature.setBackground(new java.awt.Color(255, 255, 255));

        JSearch.setBackground(new java.awt.Color(236, 236, 236));
        JSearch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));

        SearchText.setBackground(new java.awt.Color(239, 239, 239));
        SearchText.setBorder(null);
        SearchText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchTextActionPerformed(evt);
            }
        });

        ButtonSearch.setBackground(new java.awt.Color(153, 255, 255));
        ButtonSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/icon/Search__Icon.png"))); // NOI18N
        ButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JSearchLayout = new javax.swing.GroupLayout(JSearch);
        JSearch.setLayout(JSearchLayout);
        JSearchLayout.setHorizontalGroup(
            JSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JSearchLayout.createSequentialGroup()
                .addComponent(SearchText, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        JSearchLayout.setVerticalGroup(
            JSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SearchText, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(ButtonSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ButtonModify.setText("Sửa");
        ButtonModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonModifyActionPerformed(evt);
            }
        });

        ButtonDelete.setText("Xóa");
        ButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JFeatureLayout = new javax.swing.GroupLayout(JFeature);
        JFeature.setLayout(JFeatureLayout);
        JFeatureLayout.setHorizontalGroup(
            JFeatureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JFeatureLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(JSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonModify)
                .addGap(30, 30, 30)
                .addComponent(ButtonDelete)
                .addGap(151, 151, 151))
        );
        JFeatureLayout.setVerticalGroup(
            JFeatureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JFeatureLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(JFeatureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JFeatureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ButtonModify)
                        .addComponent(ButtonDelete))
                    .addComponent(JSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        Products.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        TableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Sản phẩm", "Đã bán", "Loại", "Tình trạng", "Giá bán"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TableProduct.setRowHeight(25);
        Products.setViewportView(TableProduct);

        javax.swing.GroupLayout JDisplayProductLayout = new javax.swing.GroupLayout(JDisplayProduct);
        JDisplayProduct.setLayout(JDisplayProductLayout);
        JDisplayProductLayout.setHorizontalGroup(
            JDisplayProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JFeature, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Products, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1051, Short.MAX_VALUE)
        );
        JDisplayProductLayout.setVerticalGroup(
            JDisplayProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JDisplayProductLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JFeature, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(Products, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JDisplayProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(JDisplayProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAddActionPerformed

        try {
            JFrame newFrame = new JFrame("Thông tin sản phẩm");
            newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            newFrame.setSize(720, 600);
            JPanel dienthongtin = new DienThongTInSanPham();
            newFrame.add(dienthongtin);
            newFrame.setVisible(true);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_ButtonAddActionPerformed

    private void SearchTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchTextActionPerformed

    }//GEN-LAST:event_SearchTextActionPerformed

    private void ButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSearchActionPerformed
        searchProduct();
    }//GEN-LAST:event_ButtonSearchActionPerformed

    private void ButtonModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonModifyActionPerformed
        ModifyProduct();
    }//GEN-LAST:event_ButtonModifyActionPerformed

    private void ButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDeleteActionPerformed
        deleteProduct();
    }//GEN-LAST:event_ButtonDeleteActionPerformed
    public static class RoundedBorder implements Border {

        private int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }

        public boolean isBorderOpaque() {
            return true;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAdd;
    private javax.swing.JButton ButtonDelete;
    private javax.swing.JButton ButtonModify;
    private javax.swing.JButton ButtonSearch;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel JDisplayProduct;
    private javax.swing.JPanel JFeature;
    private javax.swing.JPanel JSearch;
    private javax.swing.JScrollPane Products;
    private javax.swing.JTextField SearchText;
    private javax.swing.JTable TableProduct;
    private javax.swing.JLabel Title;
    // End of variables declaration//GEN-END:variables
}
