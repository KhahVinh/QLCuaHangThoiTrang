package Views;
import Component.ListProduct;
import Component.ReadWriteProduct;
import Models.Product;
import javax.swing.JOptionPane;
import java.util.ArrayList;
public class DienThongTInSanPham extends javax.swing.JPanel {
static ArrayList<Product> danhsachsanpham = new ArrayList<>();
    static Product product;
    private QLSP qlsp;
    private ReadWriteProduct rwp = new ReadWriteProduct();
    private ListProduct listProduct = new ListProduct();
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
        ProductStock = new javax.swing.JComboBox<>();
        ProductPrice = new javax.swing.JTextField();
        JDelete = new javax.swing.JButton();
        JConfirm = new javax.swing.JButton();
        JDelete1 = new javax.swing.JButton();
        ProductCategory = new javax.swing.JComboBox<>();

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

        ProductCategory.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ProductCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Áo nam", "Quần nam ", "Áo nữ", "Quần nữ", "Áo Unisex", "Váy ", "Chân váy ", "Phụ kiện", "Giày nam", "Giày nữ" }));

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
                    .addComponent(ProductID)
                    .addComponent(ProductCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
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
        ProductCategory.setSelectedIndex(0);
        ProductStock.setSelectedIndex(0);
        ProductPrice.setText("");
        ProductID.requestFocus(); 
    }
    private void JDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JDeleteActionPerformed
        deleteFile();
    }//GEN-LAST:event_JDeleteActionPerformed
    
    public void AddProduct(ArrayList<Product> danhsachsanpham) {
        String id = "";
        String name = "";
        String category = "";
        String stock = "";
        long price = 0;
        boolean check = true;
        category = ProductCategory.getSelectedItem().toString();
        stock = ProductStock.getSelectedItem().toString();
        try {
            id = ProductID.getText();
            if (id.trim().length() == 0) {
                JOptionPane.showConfirmDialog(null, "ID Không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
                check = false;
                ProductID.requestFocus();
            } else if (listProduct.checkIDSame(id, danhsachsanpham)) {
                JOptionPane.showMessageDialog(ProductID, "ID đã tồn tại", "Thông báo", JOptionPane.WARNING_MESSAGE);
                check = false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            name = ProductName.getText();
            if (name.trim().length() == 0) {
                JOptionPane.showConfirmDialog(ProductName, "Tên Không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
                check = false;
                ProductName.requestFocus();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            price = Long.parseLong(ProductPrice.getText());
            if (price == 0) {
                check = false;
            }
        } catch (NumberFormatException e) {
            check = false;
            ProductPrice.requestFocus();
            JOptionPane.showMessageDialog(ProductPrice, "Giá tiền không đúng", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(ProductPrice, "Giá phải lớn hơn 0", "Thông báo", JOptionPane.WARNING_MESSAGE);
            ProductPrice.requestFocus();
        }

        if (check) {
            qlsp = new QLSP();
            product = new Product(id, name, category, stock, price);
            rwp.writeFile(product, fileName, danhsachsanpham);
            deleteFile();
            qlsp.addProduct(product);
            JOptionPane.showMessageDialog(ProductCategory, "Thêm thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
        }

    }
    private void JConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JConfirmActionPerformed
        AddProduct(danhsachsanpham);
    }//GEN-LAST:event_JConfirmActionPerformed

    private void JDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JDelete1ActionPerformed
        
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
    private javax.swing.JComboBox<String> ProductCategory;
    private javax.swing.JTextField ProductID;
    private javax.swing.JTextField ProductName;
    private javax.swing.JTextField ProductPrice;
    private javax.swing.JComboBox<String> ProductStock;
    private javax.swing.JLabel Stock;
    private javax.swing.JLabel Title;
    // End of variables declaration//GEN-END:variables
}
