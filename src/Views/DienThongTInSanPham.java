package Views;
import java.util.ArrayList;
import Models.Product;
import Component.ReadWriteProduct;
import Component.ListProduct;
import static Views.QLSP.loadDataIntoTableModel;
import static Views.QLSP.listProduct;
import static Views.QLSP.selectIndex;
public class DienThongTInSanPham extends javax.swing.JPanel {
    static ArrayList<Product> danhsachsanpham = new ArrayList<>(); ;
    static Product product;
//    static ListProduct listProduct;
    private ReadWriteProduct rwp = new ReadWriteProduct();
    private ListProduct listproduct = new ListProduct();
    private String fileName = "QuanLySanPham.txt";

    public DienThongTInSanPham() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JTitle = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        ID = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        Category = new javax.swing.JLabel();
        Stock = new javax.swing.JLabel();
        Price = new javax.swing.JLabel();
        ProductID = new javax.swing.JTextField();
        ProductName = new javax.swing.JTextField();
        ProductCategory = new javax.swing.JTextField();
        ProductStock = new javax.swing.JComboBox<>();
        ProductPrice = new javax.swing.JTextField();
        JDelete = new javax.swing.JButton();
        JConfirm = new javax.swing.JButton();
        JDelete1 = new javax.swing.JButton();

        JTitle.setBackground(new java.awt.Color(51, 153, 255));

        Title.setBackground(new java.awt.Color(255, 255, 255));
        Title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Title.setForeground(new java.awt.Color(255, 255, 255));
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("Thêm thông tin sản phẩm");

        javax.swing.GroupLayout JTitleLayout = new javax.swing.GroupLayout(JTitle);
        JTitle.setLayout(JTitleLayout);
        JTitleLayout.setHorizontalGroup(
            JTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        JTitleLayout.setVerticalGroup(
            JTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        ID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ID.setText("ID");

        Name.setBackground(new java.awt.Color(153, 204, 255));
        Name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Name.setText("Tên sản phẩm");

        Category.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Category.setText("Loại");

        Stock.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Stock.setText("Tình trạng");

        Price.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Price.setText("Giá bán");

        ProductName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ProductName.setPreferredSize(new java.awt.Dimension(64, 30));

        ProductStock.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ProductStock.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Còn hàng", "Hết hàng", "Đang nhập", "Dừng bán" }));
        ProductStock.setPreferredSize(new java.awt.Dimension(110, 30));

        ProductPrice.setMinimumSize(new java.awt.Dimension(64, 30));

        JDelete.setBackground(new java.awt.Color(255, 51, 51));
        JDelete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        JDelete.setForeground(new java.awt.Color(255, 255, 255));
        JDelete.setText("Đặt lại");
        JDelete.setPreferredSize(new java.awt.Dimension(90, 27));
        JDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JDeleteActionPerformed(evt);
            }
        });

        JConfirm.setBackground(new java.awt.Color(102, 153, 255));
        JConfirm.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        JConfirm.setForeground(new java.awt.Color(255, 255, 255));
        JConfirm.setText("Xác nhận");
        JConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JConfirmActionPerformed(evt);
            }
        });

        JDelete1.setBackground(new java.awt.Color(0, 0, 0));
        JDelete1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        JDelete1.setForeground(new java.awt.Color(255, 255, 255));
        JDelete1.setText("Đóng");
        JDelete1.setPreferredSize(new java.awt.Dimension(90, 27));
        JDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JDelete1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Name)
                    .addComponent(Category, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Stock, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ID))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ProductStock, 0, 264, Short.MAX_VALUE)
                    .addComponent(ProductName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ProductPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ProductCategory)
                    .addComponent(ProductID))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(138, Short.MAX_VALUE)
                .addComponent(JDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(JDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(JConfirm)
                .addGap(150, 150, 150))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ID)
                    .addComponent(ProductID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Category, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProductCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Stock, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProductStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents
    public void Init() {
        
    }
    public void deleteFile() {
        ProductID.setText("");
        ProductName.setText("");
        ProductCategory.setText("");
        ProductStock.setSelectedIndex(0);
        ProductPrice.setText("");
        ProductID.requestFocus(); 
    }
    private void JDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JDeleteActionPerformed
        deleteFile();
    }//GEN-LAST:event_JDeleteActionPerformed

    private void JConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JConfirmActionPerformed
//        try {
//            dtmProduct = new DefaultTableModel();
//            danhsachsanpham = new ArrayList<>();
//            float productPrice = Float.parseFloat(ProductPrice.getText());
//            if (ProductPrice.getText().length() == 0) {
//                productPrice = 0;
//            }
//            product = new Product(ProductID.getText(), ProductName.getText(), ProductCategory.getText(), ProductStock.getSelectedItem().toString(), productPrice);
//            if (ProductName.getText().trim().length() == 0) {
//                JOptionPane.showMessageDialog(null, "Tên không được bỏ trống", "Thông báo", HEIGHT);
//            }
//            if (listproduct.addProduct(product,danhsachsanpham)) {
//                danhsachsanpham.add(product);
//                rwp.writeFile(danhsachsanpham,fileName);
//                deleteFile();
////                listProduct.displayData(dtmProduct, danhsachsanpham);
//            }
//            
//        } catch (NumberFormatException numberF) {
//            System.out.println(numberF.getMessage());
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
        selectIndex = danhsachsanpham.size() + 1;
        if(selectIndex != -1) {
            try {
                if(listProduct.correctProduct(fileName, danhsachsanpham)){
                    product = listProduct.SanPham(selectIndex, danhsachsanpham);
                    product.setProductID(ProductID.getText());
                    product.setProductName(ProductName.getText());
                    product.setProductCategory(ProductCategory.getText());
                    product.setProductStock(ProductStock.getSelectedItem().toString());
                    product.setProductPrice(Float.parseFloat(ProductPrice.getText()));
                    loadDataIntoTableModel();
                }
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_JConfirmActionPerformed

    private void JDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JDelete1ActionPerformed
        new DienThongTInSanPham().remove(Name);
    }//GEN-LAST:event_JDelete1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Category;
    private javax.swing.JLabel ID;
    private javax.swing.JButton JConfirm;
    private javax.swing.JButton JDelete;
    private javax.swing.JButton JDelete1;
    private javax.swing.JPanel JTitle;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel Price;
    private javax.swing.JTextField ProductCategory;
    private javax.swing.JTextField ProductID;
    private javax.swing.JTextField ProductName;
    private javax.swing.JTextField ProductPrice;
    private javax.swing.JComboBox<String> ProductStock;
    private javax.swing.JLabel Stock;
    private javax.swing.JLabel Title;
    // End of variables declaration//GEN-END:variables
}
