
package Component;

public class Menu extends javax.swing.JPanel {

    public Menu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu__header = new javax.swing.JPanel();
        user__name = new javax.swing.JLabel();
        menu__body = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(600, 600));
        setOpaque(false);

        user__name.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        user__name.setText("Admin");

        javax.swing.GroupLayout menu__headerLayout = new javax.swing.GroupLayout(menu__header);
        menu__header.setLayout(menu__headerLayout);
        menu__headerLayout.setHorizontalGroup(
            menu__headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu__headerLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(user__name)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        menu__headerLayout.setVerticalGroup(
            menu__headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu__headerLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(user__name)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout menu__bodyLayout = new javax.swing.GroupLayout(menu__body);
        menu__body.setLayout(menu__bodyLayout);
        menu__bodyLayout.setHorizontalGroup(
            menu__bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        menu__bodyLayout.setVerticalGroup(
            menu__bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 199, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu__header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu__body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu__header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menu__body, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 175, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel menu__body;
    private javax.swing.JPanel menu__header;
    private javax.swing.JLabel user__name;
    // End of variables declaration//GEN-END:variables
}
