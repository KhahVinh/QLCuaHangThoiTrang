package Views;

import Models.Product;
import javax.swing.JOptionPane;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.border.Border;
import Models.Product;
import javax.swing.JOptionPane;
import Component.ListProduct;
import Component.ReadWriteProduct;
import java.io.*;
import javax.swing.table.DefaultTableModel;

public class QLSP extends javax.swing.JPanel {

    private DefaultTableModel dtmProduct;
    private int indexSelect = -1;
    Product pd;
    ReadWriteProduct rwp = new ReadWriteProduct();
    String fileName = "QLCHTT.txt";
    ArrayList<Product> product = new ArrayList<Product>();
    ListProduct listProduct = new ListProduct();
    int dongChon = -1;

    public QLSP() {
        initComponents();
    }

    private void Init() {
        try {
            listProduct = (ListProduct) rwp.readFile(fileName);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "danh sach hien tai rong");
        }
        TableProduct.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Classroom", "ID Student", "Full Name", "Birthday", "Address"
                }
        ));
        dtmProduct = (DefaultTableModel) TableProduct.getModel();
        TableProduct.setModel(dtmProduct);
//        setLocationRelativeTo(null);
    }

    private void luuFile() {
        try {
            rwp.writeFile(fileName, listProduct);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void loadDataIntoTableModel() {
        XoaDLTrenBang();
        deleteTxtField();
        luuFile();
        listProduct.displayData(dtmProduct);
    }

    private void XoaDLTrenBang() {
        int rowCount = dtmProduct.getRowCount();
        for (int i = rowCount; i > 0; i--) {
            dtmProduct.removeRow(i - 1);
        }
    }

    private void deleteTxtField() {
        //cbbLop.setSelectedIndex(0);
        JID.setText("");
        JName.setText("");
        JSoid.setText("");
        JCategory.setText("");
        JProductStock.setSelectedItem("Còn hàng");
        JPrice.setText("");
        JID.requestFocus();//dua con tro ve day
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Header = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        AddProduct = new javax.swing.JButton();
        JDisplayProduct = new javax.swing.JPanel();
        JFeature = new javax.swing.JPanel();
        JSearch = new javax.swing.JPanel();
        SearchIcon = new javax.swing.JLabel();
        SearchText = new javax.swing.JTextField();
        Products = new javax.swing.JScrollPane();
        TableProduct = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JID = new javax.swing.JTextField();
        JName = new javax.swing.JTextField();
        JSoid = new javax.swing.JTextField();
        JPrice = new javax.swing.JTextField();
        JCategory = new javax.swing.JTextField();
        JProductStock = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(204, 204, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Title.setText("Quản Lí Sản Phẩm");

        AddProduct.setBackground(new java.awt.Color(0, 51, 255));
        AddProduct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AddProduct.setForeground(new java.awt.Color(255, 255, 255));
        AddProduct.setText("+ Thêm sản phẩm");
        AddProduct.setMargin(new java.awt.Insets(10, 10, 10, 10));
        AddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddProductActionPerformed(evt);
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
                .addComponent(AddProduct)
                .addGap(34, 34, 34))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JDisplayProduct.setBackground(new java.awt.Color(102, 102, 102));
        JDisplayProduct.setBorder(getBorder());

        JFeature.setBackground(new java.awt.Color(255, 255, 255));

        JSearch.setBackground(new java.awt.Color(236, 236, 236));
        JSearch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));

        SearchIcon.setBackground(new java.awt.Color(204, 204, 204));
        SearchIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/icon/iconSearch.png"))); // NOI18N

        SearchText.setBackground(new java.awt.Color(239, 239, 239));
        SearchText.setText("Search anything");
        SearchText.setBorder(null);
        SearchText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JSearchLayout = new javax.swing.GroupLayout(JSearch);
        JSearch.setLayout(JSearchLayout);
        JSearchLayout.setHorizontalGroup(
            JSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SearchIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(SearchText, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addContainerGap())
        );
        JSearchLayout.setVerticalGroup(
            JSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SearchIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(SearchText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout JFeatureLayout = new javax.swing.GroupLayout(JFeature);
        JFeature.setLayout(JFeatureLayout);
        JFeatureLayout.setHorizontalGroup(
            JFeatureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JFeatureLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(JSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JFeatureLayout.setVerticalGroup(
            JFeatureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JFeatureLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(JSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        Products.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        TableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        Products.setViewportView(TableProduct);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("ID");

        jLabel2.setText("Tên");

        jLabel3.setText("Đã bán");

        jLabel4.setText("Tình trạng");

        jLabel5.setText("Loại");

        jLabel6.setText("Giá bán");

        JProductStock.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Còn hàng", "Hết hàng" }));
        JProductStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JProductStockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(JName, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(JID)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JCategory)
                            .addComponent(JSoid)
                            .addComponent(JPrice)
                            .addComponent(JProductStock, 0, 148, Short.MAX_VALUE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JSoid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JProductStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout JDisplayProductLayout = new javax.swing.GroupLayout(JDisplayProduct);
        JDisplayProduct.setLayout(JDisplayProductLayout);
        JDisplayProductLayout.setHorizontalGroup(
            JDisplayProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JFeature, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Products, javax.swing.GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE)
            .addGroup(JDisplayProductLayout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JDisplayProductLayout.setVerticalGroup(
            JDisplayProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JDisplayProductLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JFeature, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(Products, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(175, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JDisplayProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddProductActionPerformed
        // TODO add your handling code here:
        // Add product
        try {
            pd = new Product(JID.getText(), JName.getText(), Integer.parseInt(JSoid.getText()), JCategory.getText(), JProductStock.getSelectedItem().toString(), Float.parseFloat(JPrice.getText()));
            if (JName.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Tên không được bỏ trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else if (listProduct.addProduct(pd)) {
                product.add(pd);
                listProduct.displayData(dtmProduct);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_AddProductActionPerformed

    private void SearchTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchTextActionPerformed

    private void JProductStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JProductStockActionPerformed
        // TODO add your handling code here:
        JProductStock.addItem("Còn hàng");
        JProductStock.addItem("Hết hàng");
        JProductStock.addItem("Đang nhập");
    }//GEN-LAST:event_JProductStockActionPerformed
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
    private javax.swing.JButton AddProduct;
    private javax.swing.JPanel Header;
    private javax.swing.JTextField JCategory;
    private javax.swing.JPanel JDisplayProduct;
    private javax.swing.JPanel JFeature;
    private javax.swing.JTextField JID;
    private javax.swing.JTextField JName;
    private javax.swing.JTextField JPrice;
    private javax.swing.JComboBox<String> JProductStock;
    private javax.swing.JPanel JSearch;
    private javax.swing.JTextField JSoid;
    private javax.swing.JScrollPane Products;
    private javax.swing.JLabel SearchIcon;
    private javax.swing.JTextField SearchText;
    private javax.swing.JTable TableProduct;
    private javax.swing.JLabel Title;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
