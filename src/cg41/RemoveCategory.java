package cg41;

import java.sql.SQLException;

public class RemoveCategory extends javax.swing.JFrame {

    int thisError, numRecords, i;
    String category, myLocalString, myCatArray[], myCat;
    boolean removeCategory;

    /** Creates new form RemoveCompletedCourse */
    public RemoveCategory() {
        initComponents();
        loadCategories();
    }

    /**
     * Method used to load the categories into the combo box
     */
    private void loadCategories() {
        CG41App.dbObject.sqlString = "select COUNT(*) from category"; //count categories
        thisError = CG41App.dbObject.getCountBySelect(); //execute
        numRecords = CG41App.dbObject.NumberOfRecords;
        CG41App.dbObject.sqlString = "select CatID, CategoryName from category";
        thisError = CG41App.dbObject.getRecordSetBySelect(); //execute query
        if (thisError == 0) { //as long as there is no error
            try {
                for (i = 0; i < numRecords; i++) {
                    CG41App.dbObject.rs.next(); //concatonate a category string
                    category = CG41App.dbObject.rs.getString(1) + ", "
                            + CG41App.dbObject.rs.getString(2);
                    categoryCombox.addItem(category); //add it to the combobox
                }
            } catch (SQLException ex) {
                // Show errors in console
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
                thisError = ex.getErrorCode();

                UserMessageBox MyMessage = new UserMessageBox();
                MyMessage.setMessage("SQLException: " + ex.getMessage());
                MyMessage.setVisible(true);
            }
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        categoryCombox = new javax.swing.JComboBox();
        exitBtn = new javax.swing.JButton();
        removeCategoryBtn = new javax.swing.JButton();
        hintLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(cg41.CG41App.class).getContext().getResourceMap(RemoveCategory.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel1.border.title"))); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N

        categoryCombox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        categoryCombox.setName("categoryCombox"); // NOI18N

        exitBtn.setText(resourceMap.getString("exitBtn.text")); // NOI18N
        exitBtn.setName("exitBtn"); // NOI18N
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        removeCategoryBtn.setText(resourceMap.getString("removeCategoryBtn.text")); // NOI18N
        removeCategoryBtn.setName("removeCategoryBtn"); // NOI18N
        removeCategoryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCategoryBtnActionPerformed(evt);
            }
        });

        hintLbl.setText(resourceMap.getString("hintLbl.text")); // NOI18N
        hintLbl.setName("hintLbl"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(removeCategoryBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(exitBtn))
                    .addComponent(categoryCombox, 0, 261, Short.MAX_VALUE)
                    .addComponent(hintLbl))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(hintLbl)
                .addGap(11, 11, 11)
                .addComponent(categoryCombox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exitBtn)
                    .addComponent(removeCategoryBtn))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Method used to close the window on button click
     */
    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        dispose();
}//GEN-LAST:event_exitBtnActionPerformed

    /**
     * Removes the selected governor from the database on press of button
     */
    private void removeCategoryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCategoryBtnActionPerformed
        myLocalString = ""; //reset used variables
        myCat = "";
        thisError = 0;
        removeCategory = false;

        myCat = categoryCombox.getSelectedItem().toString(); //get category info
        if (myCat.equals("-")) { //check to make sure the user has selected a category
            removeCategory = false;
            //show an error to the user
            UserMessageBox MyMessage = new UserMessageBox();
            MyMessage.setMessage("Please select a category to remove.");
            MyMessage.setVisible(true);
        } else { //if there's no error
            UserConfirmationBox userConfirm = new UserConfirmationBox(this, true);
            //make sure the user knows what they're removing
            userConfirm.setMessage("Removing Category:\n"
                    + "The category that you wish to remove is:\n"
                    + myCat
                    + ".\nUpon deleting this category,\nany course or completed"
                    + "\ncourses that require this category\nwill also be"
                    + "deleted.\nAre you sure you want to continue?");
            userConfirm.setVisible(true);
            removeCategory = userConfirm.removeConfirmation; //take the result from the confirm window
            userConfirm.dispose(); //make sure we close it
            if (removeCategory == false) { //if they don't want to delete
                UserMessageBox MyMessage = new UserMessageBox();
                MyMessage.setMessage("The Category:\n"
                        + myCat
                        + ".\nWas not removed.");
                MyMessage.setVisible(true);
            }
            if (removeCategory == true) { //if they want to delete
                myCatArray = myCat.split(","); //split the category information
                //make a string to delete the category by the given ID
                myLocalString = "delete from category where CatID=" + myCatArray[0];
                CG41App.dbObject.sqlString = myLocalString; //set the query
                thisError = CG41App.dbObject.deleteRecord(); //execute

                //reset the UI for the user to remove another category
                categoryCombox.removeAllItems();
                categoryCombox.addItem("-");
                categoryCombox.setSelectedIndex(0);
                loadCategories();

                // Report completiton to the user
                if (thisError == 0) { //if there's no error
                    UserMessageBox MyMessage = new UserMessageBox();
                    MyMessage.setMessage("Category Successfully Deleted");
                    MyMessage.setVisible(true);
                } else { //if there's an error
                    UserMessageBox MyMessage = new UserMessageBox();
                    MyMessage.setMessage("There was an Error deleting the Category.");
                    MyMessage.setVisible(true);
                }
            }
        }
}//GEN-LAST:event_removeCategoryBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new RemoveCategory().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox categoryCombox;
    private javax.swing.JButton exitBtn;
    private javax.swing.JLabel hintLbl;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton removeCategoryBtn;
    // End of variables declaration//GEN-END:variables
}