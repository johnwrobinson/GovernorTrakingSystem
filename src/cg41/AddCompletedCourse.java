package cg41;

import java.sql.SQLException;
import java.util.Date;
import javax.swing.WindowConstants;

public class AddCompletedCourse extends javax.swing.JFrame {

    boolean myLocalError = false;
    String myLocalString = "";
    String governor, courseCompDateString, course;
    String compGov, completedCourse;
    String compCourseIDArray[], compGovIDArray[];
    Date courseDate;
    int thisError, numRecords, courseID, govID, i = 0;

    /**
     * This method loads the courses into the combo box
     */
    private void loadCourses() {
        CG41App.dbObject.sqlString = "select COUNT(*) from course"; //set query
        thisError = CG41App.dbObject.getCountBySelect(); //execute query
        numRecords = CG41App.dbObject.NumberOfRecords; //get number of records
        CG41App.dbObject.sqlString = "select CourseID, CourseName from course";
        thisError = CG41App.dbObject.getRecordSetBySelect(); //execute query
        if (thisError == 0) {
            try {
                for (i = 0; i < numRecords; i++) {
                    //for amount of records, add each one to the combo box
                    CG41App.dbObject.rs.next();
                    course = CG41App.dbObject.rs.getString(1) + ", "
                           + CG41App.dbObject.rs.getString(2);
                    compCourseCombox.addItem(course);
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
     * Constructor for AddCompletedCourse class
     */
    public AddCompletedCourse() {
        initComponents();
        loadCourses();
        loadGovernors();
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
        clrFldsBtn = new javax.swing.JButton();
        addCompletedCourseBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        courseCompletedIDLbl = new javax.swing.JLabel();
        courseCompletedIDOutLbl = new javax.swing.JLabel();
        compGovLbl = new javax.swing.JLabel();
        compGovCombox = new javax.swing.JComboBox();
        compCourseCombox = new javax.swing.JComboBox();
        compCourseLbl = new javax.swing.JLabel();
        compDateLbl = new javax.swing.JLabel();
        compCourseDateChooser = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(cg41.CG41App.class).getContext().getResourceMap(AddCompletedCourse.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel1.border.title"))); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N

        clrFldsBtn.setText(resourceMap.getString("clrFldsBtn.text")); // NOI18N
        clrFldsBtn.setName("clrFldsBtn"); // NOI18N

        addCompletedCourseBtn.setText(resourceMap.getString("addCompletedCourseBtn.text")); // NOI18N
        addCompletedCourseBtn.setName("addCompletedCourseBtn"); // NOI18N
        addCompletedCourseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCompletedCourseBtnActionPerformed(evt);
            }
        });

        exitBtn.setText(resourceMap.getString("exitBtn.text")); // NOI18N
        exitBtn.setName("exitBtn"); // NOI18N
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        courseCompletedIDLbl.setText(resourceMap.getString("courseCompletedIDLbl.text")); // NOI18N
        courseCompletedIDLbl.setName("courseCompletedIDLbl"); // NOI18N

        courseCompletedIDOutLbl.setText(resourceMap.getString("courseCompletedIDOutLbl.text")); // NOI18N
        courseCompletedIDOutLbl.setName("courseCompletedIDOutLbl"); // NOI18N

        compGovLbl.setText(resourceMap.getString("compGovLbl.text")); // NOI18N
        compGovLbl.setName("compGovLbl"); // NOI18N

        compGovCombox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        compGovCombox.setName("compGovCombox"); // NOI18N

        compCourseCombox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        compCourseCombox.setToolTipText(resourceMap.getString("compCourseCombox.toolTipText")); // NOI18N
        compCourseCombox.setName("compCourseCombox"); // NOI18N

        compCourseLbl.setText(resourceMap.getString("compCourseLbl.text")); // NOI18N
        compCourseLbl.setName("compCourseLbl"); // NOI18N

        compDateLbl.setText(resourceMap.getString("compDateLbl.text")); // NOI18N
        compDateLbl.setName("compDateLbl"); // NOI18N

        compCourseDateChooser.setName("compCourseDateChooser"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(compGovLbl)
                            .addComponent(compCourseLbl)
                            .addComponent(compDateLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(compCourseDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(compCourseCombox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(compGovCombox, javax.swing.GroupLayout.Alignment.LEADING, 0, 197, Short.MAX_VALUE))
                                .addGap(28, 28, 28)
                                .addComponent(courseCompletedIDLbl))
                            .addComponent(courseCompletedIDOutLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(clrFldsBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addCompletedCourseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(exitBtn)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(compGovCombox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(compGovLbl))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(compCourseCombox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(compCourseLbl))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(compCourseDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(compDateLbl)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(courseCompletedIDLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(courseCompletedIDOutLbl)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exitBtn)
                    .addComponent(addCompletedCourseBtn)
                    .addComponent(clrFldsBtn))
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
     * When the Add Comp Course button is pressed, the fields are checked
     * and then the information is added to the database
     */
private void addCompletedCourseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCompletedCourseBtnActionPerformed
    myLocalError = false; //set used variables to null
    thisError = 0;
    myLocalString = "";
    
    courseDate = compCourseDateChooser.getDate(); //get date and format
    courseCompDateString = String.format("%1$tY-%1$tm-%1$td", courseDate);
    //This if statement will check to make sure the user has selected everything
    if(courseCompDateString.equals("null-null-null")
            || compGovCombox.getSelectedItem().equals("-")
            || compCourseCombox.getSelectedItem().equals("-")){

        myLocalError = true;
        //error message for the user
        UserMessageBox MyMessage = new UserMessageBox();
        MyMessage.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        MyMessage.setMessage("Error adding completed course.\n"
                + "Please make sure you have selected something\nin all fields.\n"
                + "Please try again.");
        MyMessage.setTitle("Error Adding Completed Course");
        MyMessage.setVisible(true);

    }
    else { //if all is okay
        compGov = compGovCombox.getSelectedItem().toString(); //get governor
        compGovIDArray = compGov.split(",", 2); //split string
        govID = Integer.parseInt(compGovIDArray[0]); //get the gov ID
        //same as with the gov but with the course
        completedCourse = compCourseCombox.getSelectedItem().toString();
        compCourseIDArray = completedCourse.split(",", 2);
        courseID = Integer.parseInt(compCourseIDArray[0]);
    }

    if(myLocalError == false){ //add the comp course if there's no error
        myLocalString = "insert into coursetaken ("
                + "GovID, CourseID, DateTaken)"
                + "values ('" + govID + "', "
                + "'" + courseID + "', "
                + "'" + courseCompDateString + "')";//concatonate string
        CG41App.dbObject.sqlString = myLocalString; //set string
        thisError = CG41App.dbObject.insertRecord(); //execute query
    }
    if (0 == thisError && myLocalError == false) {
        //if there's no error, show confirmation box to user
        courseCompletedIDOutLbl.setText(Integer.toString(CG41App.dbObject.LastInsertedKey));
        UserMessageBox MyMessage = new UserMessageBox();
        MyMessage.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        MyMessage.setMessage("Completed Coruse successfully added.");
        MyMessage.setTitle("Completed Course Added");
        MyMessage.setVisible(true);
    }
    else{
        //if there's an error then show an error
        UserMessageBox MyMessage = new UserMessageBox();
        MyMessage.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        MyMessage.setMessage("There was an error adding the completed course.");
        MyMessage.setTitle("Error Adding Completed Course");
        MyMessage.setVisible(true);
    }
}//GEN-LAST:event_addCompletedCourseBtnActionPerformed
/**
 * This method disposes the window
 */
private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
    dispose();
}//GEN-LAST:event_exitBtnActionPerformed

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
            java.util.logging.Logger.getLogger(AddCompletedCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCompletedCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCompletedCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCompletedCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AddCompletedCourse().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCompletedCourseBtn;
    private javax.swing.JButton clrFldsBtn;
    private javax.swing.JComboBox compCourseCombox;
    private com.toedter.calendar.JDateChooser compCourseDateChooser;
    private javax.swing.JLabel compCourseLbl;
    private javax.swing.JLabel compDateLbl;
    private javax.swing.JComboBox compGovCombox;
    private javax.swing.JLabel compGovLbl;
    private javax.swing.JLabel courseCompletedIDLbl;
    private javax.swing.JLabel courseCompletedIDOutLbl;
    private javax.swing.JButton exitBtn;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}