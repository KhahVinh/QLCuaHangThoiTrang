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
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class QLSP extends javax.swing.JPanel {
    static int index = -1;
    static int checkFuntions;
    static String[] columnName = {"Mã sản phẩm", "Tên Sản phẩm", "Loại","Số lượng", "Giá bán"};
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
            Object[] rowData = {product.getProductID(), product.getProductName(), product.getProductCategory(),product.getProductQuantity(), price};
            dtmProduct.addRow(rowData);
        }
        TableProduct.setModel(dtmProduct);
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
//                dtmProduct = new DefaultTableModel(columnName, 0);
                TableRowSorter<TableModel> sorter = new TableRowSorter<>(dtmProduct);
                TableProduct.setRowSorter(sorter);
                sorter.setRowFilter(RowFilter.regexFilter(name));
                
//                danhsachsanphamtimkiem = listProduct.searchProduct(danhsachsanpham, name);
//                listProduct.displayData(dtmProduct, danhsachsanphamtimkiem);
//                if (danhsachsanphamtimkiem.isEmpty()) {
//                    JOptionPane.showMessageDialog(TableProduct, "Không tìm thấy sản phẩm " + name, "Thông báo", JOptionPane.WARNING_MESSAGE);
//                    danhsachsanphamtimkiem = listProduct.findAll(danhsachsanpham, name);
//                    listProduct.displayData(dtmProduct, danhsachsanphamtimkiem);
//                }
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
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn sản phẩm xóa", "Thông báo", JOptionPane.OK_OPTION);
        } else {
            int select = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (select == 0) {
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
                vitri--;
                updateTable();
                JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private void displayFunctions(String name) {
        JFrame newFrame = new JFrame(name);
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newFrame.setSize(720, 600);
        JPanel dienthongtin = new DienThongTInSanPham();
        newFrame.add(dienthongtin);
        newFrame.setVisible(true);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        Header = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        JDisplayProduct = new javax.swing.JPanel();
        JFeature = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        JSearch = new javax.swing.JPanel();
        ButtonSearch = new javax.swing.JButton();
        SearchText = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        ButtonDelete = new javax.swing.JButton();
        ButtonAdd = new javax.swing.JButton();
        ButtonModify = new javax.swing.JButton();
        Products = new javax.swing.JScrollPane();
        TableProduct = new javax.swing.JTable();

        jButton1.setText("jButton1");

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(204, 204, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Header.setBackground(new java.awt.Color(204, 204, 204));

        Title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Title.setText("Quản Lí Sản Phẩm");

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(Title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        JDisplayProduct.setBackground(new java.awt.Color(255, 255, 255));
        JDisplayProduct.setBorder(getBorder());

        JFeature.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        JSearch.setBackground(new java.awt.Color(236, 236, 236));
        JSearch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));

        ButtonSearch.setBackground(new java.awt.Color(102, 204, 255));
        ButtonSearch.setForeground(new java.awt.Color(255, 255, 255));
        ButtonSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/icon/Search__Icon.png"))); // NOI18N
        ButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSearchActionPerformed(evt);
            }
        });

        SearchText.setBackground(new java.awt.Color(239, 239, 239));
        SearchText.setBorder(null);
        SearchText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchTextActionPerformed(evt);
            }
        });
        SearchText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchTextKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout JSearchLayout = new javax.swing.GroupLayout(JSearch);
        JSearch.setLayout(JSearchLayout);
        JSearchLayout.setHorizontalGroup(
            JSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JSearchLayout.createSequentialGroup()
                .addComponent(SearchText, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        JSearchLayout.setVerticalGroup(
            JSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ButtonSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(SearchText, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jButton2.setBackground(new java.awt.Color(15, 149, 224));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/icon/reload-arrow.png"))); // NOI18N
        jButton2.setText("Làm mới");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel2.setLayout(new java.awt.GridLayout(1, 3, 60, 0));

        ButtonDelete.setBackground(new java.awt.Color(255, 102, 102));
        ButtonDelete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ButtonDelete.setForeground(new java.awt.Color(255, 255, 255));
        ButtonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/icon/rubbish-bin (1).png"))); // NOI18N
        ButtonDelete.setText("Xóa");
        ButtonDelete.setMargin(new java.awt.Insets(2, 10, 2, 10));
        ButtonDelete.setPreferredSize(new java.awt.Dimension(70, 30));
        ButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(ButtonDelete);

        ButtonAdd.setBackground(new java.awt.Color(4, 190, 79));
        ButtonAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ButtonAdd.setForeground(new java.awt.Color(255, 255, 255));
        ButtonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/icon/add (1).png"))); // NOI18N
        ButtonAdd.setText("Thêm sản phẩm");
        ButtonAdd.setMargin(new java.awt.Insets(10, 10, 10, 10));
        ButtonAdd.setPreferredSize(new java.awt.Dimension(120, 40));
        ButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAddActionPerformed(evt);
            }
        });
        jPanel2.add(ButtonAdd);

        ButtonModify.setBackground(new java.awt.Color(255, 185, 46));
        ButtonModify.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ButtonModify.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/icon/edit-v2 (2).png"))); // NOI18N
        ButtonModify.setText("Sửa");
        ButtonModify.setMaximumSize(new java.awt.Dimension(70, 32));
        ButtonModify.setMinimumSize(new java.awt.Dimension(0, 0));
        ButtonModify.setPreferredSize(new java.awt.Dimension(50, 20));
        ButtonModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonModifyActionPerformed(evt);
            }
        });
        jPanel2.add(ButtonModify);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 512, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 79, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout JFeatureLayout = new javax.swing.GroupLayout(JFeature);
        JFeature.setLayout(JFeatureLayout);
        JFeatureLayout.setHorizontalGroup(
            JFeatureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JFeatureLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JFeatureLayout.setVerticalGroup(
            JFeatureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JFeatureLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(JFeatureLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
        TableProduct.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        TableProduct.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Products.setViewportView(TableProduct);

        javax.swing.GroupLayout JDisplayProductLayout = new javax.swing.GroupLayout(JDisplayProduct);
        JDisplayProduct.setLayout(JDisplayProductLayout);
        JDisplayProductLayout.setHorizontalGroup(
            JDisplayProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Products, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(JFeature, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JDisplayProductLayout.setVerticalGroup(
            JDisplayProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JDisplayProductLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(JFeature, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(Products, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JDisplayProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(JDisplayProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SearchTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchTextActionPerformed

    }//GEN-LAST:event_SearchTextActionPerformed

    private void ButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSearchActionPerformed
        searchProduct();
    }//GEN-LAST:event_ButtonSearchActionPerformed

    private void ButtonModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonModifyActionPerformed
        index = TableProduct.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn sản phẩm để sửa", "Thông báo", JOptionPane.OK_OPTION);
        } else {
            
        try {
            checkFuntions =2;
            displayFunctions("Sửa thông tin sản phẩm");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        }
    }//GEN-LAST:event_ButtonModifyActionPerformed

    private void ButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAddActionPerformed

        try {
            checkFuntions =1;
            displayFunctions("Điền thông tin sản phẩm");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_ButtonAddActionPerformed

    private void ButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDeleteActionPerformed
        deleteProduct();
    }//GEN-LAST:event_ButtonDeleteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    }//GEN-LAST:event_jButton2ActionPerformed

    private void SearchTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchTextKeyReleased
        searchProduct();
    }//GEN-LAST:event_SearchTextKeyReleased
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
