package cg41;

import java.sql.SQLException;
import javax.swing.JTable;

public class ViewCourses extends javax.swing.JFrame {

    String myLocalString, courseID, catID, courseName, catName;
    int thisError, numRecords = 0;

    public ViewCourses() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        refreshBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        courseScrlPane = new javax.swing.JScrollPane();
        courseTbl = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(cg41.CG41App.class).getContext().getResourceMap(ViewCourses.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel1.border.title"))); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N

        refreshBtn.setText(resourceMap.getString("refreshBtn.text")); // NOI18N
        refreshBtn.setName("refreshBtn"); // NOI18N
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        exitBtn.setText(resourceMap.getString("exitBtn.text")); // NOI18N
        exitBtn.setName("exitBtn"); // NOI18N
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        courseScrlPane.setName("courseScrlPane"); // NOI18N

        courseTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Course ID", "Category Name", "Course Name"
            }
        ));
        courseTbl.setName("courseTbl"); // NOI18N
        courseScrlPane.setViewportView(courseTbl);
        courseTbl.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("courseTbl.columnModel.title0")); // NOI18N
        courseTbl.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("courseTbl.columnModel.title1")); // NOI18N
        courseTbl.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("courseTbl.columnModel.title2")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(refreshBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(exitBtn))
                    .addComponent(courseScrlPane))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(courseScrlPane, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exitBtn)
                    .addComponent(refreshBtn))
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

        jPanel1.getAccessibleContext().setAccessibleName(resourceMap.getString("jPanel1.AccessibleContext.accessibleName")); // NOI18N

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * This method closes the window
     */
private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
    dispose();
}//GEN-LAST:event_exitBtnActionPerformed

    /**
     * This method will take a category ID as an input and will return
     * the category name linked to the category ID from the database
     */
    public String getCategoryName(int catID){
        myLocalString = ""; //reset variables
        thisError = 0;
        //create search statement to find the name by the given ID
        myLocalString = "select * from category where CatID = '"
                + catID + "'";
        CG41App.dbObject2.sqlString = myLocalString; //set the statement
        thisError = CG41App.dbObject2.getRecordSetBySelect(); //execute
        try{
            CG41App.dbObject2.rs.next(); //get the name from the record set
            catName = CG41App.dbObject2.rs.getString ("CategoryName");
        }catch (SQLException ex){
                // Show errors in console
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
                thisError = ex.getErrorCode ();
                UserMessageBox MyMessage = new UserMessageBox ();
                MyMessage.setMessage ("SQLException: " + ex.getMessage());
                MyMessage.setVisible (true);
        }
        return catName;
    }

    /**
    * this method refreshes the table for when courses have been added, edited
    * or removed elsewhere
    */
private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
    //count the amount of records
    CG41App.dbObject.sqlString = "select COUNT(*) from course";
    thisError = CG41App.dbObject.getCountBySelect();

    numRecords = CG41App.dbObject.NumberOfRecords; //save number of records

    // Construct an SQL statment to find all the categories
    CG41App.dbObject.sqlString =
            "select CourseID, CatID, CourseName from course";
    // Execute the query
    thisError = CG41App.dbObject.getRecordSetBySelect();
    if (thisError == 0) {
        // No error on execution of statement
        // In order to make a table, you need to create an array of objects
        // It must be as long as the number of records you've counted and
        // must be as wide as the number of columns you've asked for
        Object[][] myTableData = new Object[numRecords][3];
        String[] myColumnNames = {"Course ID", "Category ID", "Course Name"};
        try {
            int row = 0;
            while (CG41App.dbObject.rs.next()){ // For each record
                //get each part of the record from the record set
                courseID = CG41App.dbObject.rs.getString("CourseID");
                catID = CG41App.dbObject.rs.getString("CatID");
                //get the category name with the category ID
                catName = getCategoryName(Integer.parseInt(catID));
                courseName = CG41App.dbObject.rs.getString("CourseName");
                myTableData[row][0] = courseID;
                myTableData[row][1] = catName;
                myTableData[row][2] = courseName;
                row = row + 1;           // Next row in table
            }

            // Have the table data, so make a new table with it
            JTable jtblAllCustomers = new JTable(myTableData, myColumnNames);
            jtblAllCustomers.setFillsViewportHeight(true);
            courseScrlPane.getViewport().add(jtblAllCustomers);
            courseScrlPane.repaint();
         }catch (SQLException ex){
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
}//GEN-LAST:event_refreshBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewCourses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCourses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCourses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCourses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ViewCourses().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane courseScrlPane;
    private javax.swing.JTable courseTbl;
    private javax.swing.JButton exitBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton refreshBtn;
    // End of variables declaration//GEN-END:variables
}