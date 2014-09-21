package cg41;

import java.sql.SQLException;
import java.util.Date;
import javax.swing.JTable;

public class ViewCompletedCoursesByGovernor extends javax.swing.JFrame {

    String myLocalString, courseID, myGovernorArray[], courseName, governorName,
            governor, myGovernor;
    int thisError, numRecords, myGovernorID, i = 0;
    Date dateTaken;

    public ViewCompletedCoursesByGovernor() {
        initComponents();
        loadGovernors();
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
        compGovCombox = new javax.swing.JComboBox();
        selectLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(cg41.CG41App.class).getContext().getResourceMap(ViewCompletedCoursesByGovernor.class);
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
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Governor Name", "Course ID", "Course Name", "Date Taken"
            }
        ));
        courseTbl.setName("courseTbl"); // NOI18N
        courseScrlPane.setViewportView(courseTbl);
        courseTbl.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("courseTbl.columnModel.title0")); // NOI18N
        courseTbl.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("courseTbl.columnModel.title1")); // NOI18N
        courseTbl.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("courseTbl.columnModel.title2")); // NOI18N
        courseTbl.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("courseTbl.columnModel.title3")); // NOI18N

        compGovCombox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        compGovCombox.setToolTipText(resourceMap.getString("compGovCombox.toolTipText")); // NOI18N
        compGovCombox.setName("compGovCombox"); // NOI18N

        selectLbl.setText(resourceMap.getString("selectLbl.text")); // NOI18N
        selectLbl.setName("selectLbl"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(courseScrlPane, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(refreshBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(exitBtn))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(selectLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(compGovCombox, 0, 185, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(compGovCombox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(courseScrlPane, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
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
     * This method loads the governors into the combo box
     */
    private void loadGovernors() {
        CG41App.dbObject.sqlString = "select COUNT(*) from governor"; //get count
        thisError = CG41App.dbObject.getCountBySelect(); //execute count query
        numRecords = CG41App.dbObject.NumberOfRecords; //get number of records
        CG41App.dbObject.sqlString = "select GovID, Firstname, Surname from governor";
        thisError = CG41App.dbObject.getRecordSetBySelect(); //execute query
        if (thisError == 0) {
            try {
                for (i = 0; i < numRecords; i++) {
                    //concatonate governor and add to the combo box for amount of records
                    CG41App.dbObject.rs.next();
                    governor = CG41App.dbObject.rs.getString(1) + ", "
                            + CG41App.dbObject.rs.getString(2) + " "
                            + CG41App.dbObject.rs.getString(3);
                    compGovCombox.addItem(governor);
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

    /**
     * this method refreshes the table for when courses have been added, edited
     * or removed elsewhere
     */
private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
    myGovernor = compGovCombox.getSelectedItem().toString();//get selected course
    if(myGovernor.equals("-")){
        //show an error to the user
        UserMessageBox MyMessage = new UserMessageBox();
        MyMessage.setMessage("Please select a Governor to search by.");
        MyMessage.setVisible(true);
    }else{
        myGovernorArray = myGovernor.split(","); //get the ID out
        myGovernorID = Integer.parseInt(myGovernorArray[0]); //store the ID

        //count the amount of records where the selected ID is concerned
        myLocalString = "select COUNT(*) from coursetaken where GovID = "
                + myGovernorID;
        CG41App.dbObject.sqlString = myLocalString;
        thisError = CG41App.dbObject.getCountBySelect();//execute

        numRecords = CG41App.dbObject.NumberOfRecords; //save number of records

        // Construct an SQL statment to find all the information we need:
        //The information that we're pulling here is the course name, datetaken,
        //course ID, Governor ID and Governor First/Last names but only where the
        //governor ID selected and coursetaken gocernor ID match.
        //The joins allow us to pull the information from the three tables
        myLocalString = "SELECT course.CourseName, coursetaken.DateTaken, "
                + "coursetaken.GovID, governor.Firstname, governor.Surname, "
                + "coursetaken.CourseID FROM (coursetaken "
                + "INNER JOIN course ON course.CourseID = coursetaken.CourseID) "
                + "INNER JOIN governor ON governor.GovID = coursetaken.GovID "
                + "WHERE (coursetaken.GovID = " + myGovernorID + ")";
        CG41App.dbObject.sqlString = myLocalString;

        // Execute the query
        thisError = CG41App.dbObject.getRecordSetBySelect();
        if (thisError == 0) {
            // No error on execution of statement
            // In order to make a table, you need to create an array of objects
            // It must be as long as the number of records you've counted and
            // must be as wide as the number of columns you've asked for
            Object[][] myTableData = new Object[numRecords][4];
            String[] myColumnNames = {"Governor Name", "Course ID",
                "Course Name", "Date Taken"};
            try {
                int row = 0;
                while (CG41App.dbObject.rs.next()) { // For each record
                    //get each part of the record from the record set
                    courseName = CG41App.dbObject.rs.getString("CourseName");
                    courseID = CG41App.dbObject.rs.getString("CourseID");
                    //concatonate the governor name
                    governorName = CG41App.dbObject.rs.getString("Firstname") + " "
                            + CG41App.dbObject.rs.getString("Surname");
                    dateTaken = CG41App.dbObject.rs.getDate("DateTaken");
                    myTableData[row][0] = governorName;
                    myTableData[row][1] = courseID;
                    myTableData[row][2] = courseName;
                    myTableData[row][3] = String.valueOf(dateTaken);
                    row = row + 1;           // Next row in table
                }

                // Have the table data, so make a new table with it
                JTable jtblAllCustomers = new JTable(myTableData, myColumnNames);
                jtblAllCustomers.setFillsViewportHeight(true);
                courseScrlPane.getViewport().add(jtblAllCustomers);
                courseScrlPane.repaint();
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
            java.util.logging.Logger.getLogger(ViewCompletedCoursesByGovernor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCompletedCoursesByGovernor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCompletedCoursesByGovernor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCompletedCoursesByGovernor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ViewCompletedCoursesByGovernor().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox compGovCombox;
    private javax.swing.JScrollPane courseScrlPane;
    private javax.swing.JTable courseTbl;
    private javax.swing.JButton exitBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JLabel selectLbl;
    // End of variables declaration//GEN-END:variables
}