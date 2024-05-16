package Views;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.border.Border;
import Models.Product;
import javax.swing.JOptionPane;
import Component.ListProduct;
import Component.ReadWriteProduct;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static  Views.DienThongTInSanPham.danhsachsanpham;
public class QLSP extends javax.swing.JPanel {

    static String[] columnName = {"Mã sản phẩm", "Sản phẩm", "Loại", "Tình trạng", "Giá bán"};
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
        dtmProduct.setRowCount(0);// Xóa tất cả các dòng hiện tại
        for (Product product : danhsachsanpham) {
            Object[] rowData = {product.getProductID(), product.getProductName(), product.getProductCategory(), product.getProductStock(), product.getProductPrice()};
            dtmProduct.addRow(rowData);
        }
        TableProduct.setModel(dtmProduct);
    }

    static void loadDataIntoTableModel() {
        XoaDLTrenBang();

    }

    static void XoaDLTrenBang() {
        int rowCount = dtmProduct.getRowCount();
        for (int i = rowCount; i > 0; i--) {
            dtmProduct.removeRow(i - 1);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Header = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        AddProduct = new javax.swing.JButton();
        JLength = new javax.swing.JLabel();
        JDisplayProduct = new javax.swing.JPanel();
        JFeature = new javax.swing.JPanel();
        JSearch = new javax.swing.JPanel();
        SearchText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        Products = new javax.swing.JScrollPane();
        TableProduct = new javax.swing.JTable();

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

        JLength.setText("jLabel1");

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(Title)
                .addGap(198, 198, 198)
                .addComponent(JLength, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AddProduct)
                .addGap(34, 34, 34))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HeaderLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(JLength, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(HeaderLayout.createSequentialGroup()
                        .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AddProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        JDisplayProduct.setBackground(new java.awt.Color(102, 102, 102));
        JDisplayProduct.setBorder(getBorder());

        JFeature.setBackground(new java.awt.Color(255, 255, 255));

        JSearch.setBackground(new java.awt.Color(236, 236, 236));
        JSearch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));

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
                .addGap(34, 34, 34)
                .addComponent(SearchText, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addContainerGap())
        );
        JSearchLayout.setVerticalGroup(
            JSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SearchText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                .addComponent(jButton1)
                .addGap(101, 101, 101))
        );
        JFeatureLayout.setVerticalGroup(
            JFeatureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JFeatureLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(JFeatureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(JSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        Products.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        TableProduct.setAutoCreateRowSorter(true);
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

    private void AddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddProductActionPerformed
        // Add product

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
    }//GEN-LAST:event_AddProductActionPerformed

    private void SearchTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchTextActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        JLength.setText("length: " + danhsachsanpham.size());
    }//GEN-LAST:event_jButton1ActionPerformed
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
    private javax.swing.JPanel JDisplayProduct;
    private javax.swing.JPanel JFeature;
    private javax.swing.JLabel JLength;
    private javax.swing.JPanel JSearch;
    private javax.swing.JScrollPane Products;
    private javax.swing.JTextField SearchText;
    private javax.swing.JTable TableProduct;
    private javax.swing.JLabel Title;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
