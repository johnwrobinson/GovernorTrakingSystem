package cg41;

import java.sql.SQLException;
import javax.swing.WindowConstants;

public class EditCourse extends javax.swing.JFrame {

    boolean myLocalError = false;
    String myLocalString, myLocalString2 = null;
    String course, myCourse, catName, errorMessage, category, myCat = "";
    String myCourseArray[], myCategoryArray[];
    int thisError, thisError2, i, numRecords, catID = 0;

    /** Creates new form EditCourse */
    public EditCourse() {
        initComponents();
        loadCourses();
    }

    /**
     * This method loads the courses into a combo box for the user to select
     * from
     */
    private void loadCourses() {
        CG41App.dbObject.sqlString = "select COUNT(*) from course"; //set sql query
        thisError = CG41App.dbObject.getCountBySelect(); //execute query
        numRecords = CG41App.dbObject.NumberOfRecords; //get number of records
        //set and exectue a search query
        CG41App.dbObject.sqlString = "select CourseID, CatID, CourseName from course";
        thisError = CG41App.dbObject.getRecordSetBySelect();
        if (thisError == 0) {
            try {
                //for each number of records add each course to the combo box
                for (i = 0; i < numRecords; i++) {
                    CG41App.dbObject.rs.next();
                    course = CG41App.dbObject.rs.getString(1) + ", "
                            + CG41App.dbObject.rs.getString(3)
                            + ", " + getCategoryName(Integer.parseInt(CG41App.dbObject.rs.getString(2)));
                    courseCombox.addItem(course);
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
     * This method is for loading the categories into the combo box for the
     * user to select when the course is edited
     */
    private void loadCategories() {
        /**set SQL queries for counting the amount of records and then selecting
         * the records from the database
         */
        CG41App.dbObject.sqlString = "select COUNT(*) from category";
        thisError = CG41App.dbObject.getCountBySelect();
        numRecords = CG41App.dbObject.NumberOfRecords;
        CG41App.dbObject.sqlString = "select CatID, CategoryName from category";
        thisError = CG41App.dbObject.getRecordSetBySelect();
        if (thisError == 0) {
            try {
                //for the amount of records found, add them to the combo box
                for (i = 0; i < numRecords; i++) {
                    CG41App.dbObject.rs.next();
                    category = CG41App.dbObject.rs.getString(1) + ", "
                            + CG41App.dbObject.rs.getString(2);
                    catEditCombox.addItem(category);
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
     * This method will take an integer ID for the category as an input
     * and will return the name of the category associated with the ID as a
     * string
     */
    public String getCategoryName(int catID) {
        myLocalString2 = ""; //rest variables
        thisError2 = 0;
        myLocalString2 = "select * from category where CatID = '"
                + catID + "'"; //set SQL statement for searching
        CG41App.dbObject2.sqlString = myLocalString2;
        thisError2 = CG41App.dbObject2.getRecordSetBySelect(); //select the record I need
        try { //get the category name and prepare it for the return
            CG41App.dbObject2.rs.next();
            catName = CG41App.dbObject2.rs.getString("CategoryName");
        } catch (SQLException ex) {
            // Show errors in console
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            thisError2 = ex.getErrorCode();
            UserMessageBox MyMessage = new UserMessageBox();
            MyMessage.setMessage("SQLException: " + ex.getMessage());
            MyMessage.setVisible(true);
        }
        return catName;
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
        editCourseBtn = new javax.swing.JButton();
        courseNamEditFld = new javax.swing.JTextField();
        exitBtn = new javax.swing.JButton();
        courseCombox = new javax.swing.JComboBox();
        loadCourseBtn = new javax.swing.JButton();
        catIDLbl = new javax.swing.JLabel();
        courseIDOutLbl = new javax.swing.JLabel();
        courseLbl = new javax.swing.JLabel();
        courseNameLbl = new javax.swing.JLabel();
        catEditCombox = new javax.swing.JComboBox();
        catLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(cg41.CG41App.class).getContext().getResourceMap(EditCourse.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel1.border.title"))); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N

        editCourseBtn.setText(resourceMap.getString("editCourseBtn.text")); // NOI18N
        editCourseBtn.setName("editCourseBtn"); // NOI18N
        editCourseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCourseBtnActionPerformed(evt);
            }
        });

        courseNamEditFld.setName("courseNamEditFld"); // NOI18N

        exitBtn.setText(resourceMap.getString("exitBtn.text")); // NOI18N
        exitBtn.setName("exitBtn"); // NOI18N
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        courseCombox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        courseCombox.setName("courseCombox"); // NOI18N

        loadCourseBtn.setText(resourceMap.getString("loadCourseBtn.text")); // NOI18N
        loadCourseBtn.setName("loadCourseBtn"); // NOI18N
        loadCourseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadCourseBtnActionPerformed(evt);
            }
        });

        catIDLbl.setText(resourceMap.getString("catIDLbl.text")); // NOI18N
        catIDLbl.setName("catIDLbl"); // NOI18N

        courseIDOutLbl.setText(resourceMap.getString("courseIDOutLbl.text")); // NOI18N
        courseIDOutLbl.setName("courseIDOutLbl"); // NOI18N

        courseLbl.setText(resourceMap.getString("courseLbl.text")); // NOI18N
        courseLbl.setName("courseLbl"); // NOI18N

        courseNameLbl.setText(resourceMap.getString("courseNameLbl.text")); // NOI18N
        courseNameLbl.setName("courseNameLbl"); // NOI18N

        catEditCombox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        catEditCombox.setName("catEditCombox"); // NOI18N

        catLbl.setText(resourceMap.getString("catLbl.text")); // NOI18N
        catLbl.setName("catLbl"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(courseNameLbl)
                    .addComponent(courseLbl)
                    .addComponent(catLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(courseNamEditFld)
                    .addComponent(courseCombox, 0, 247, Short.MAX_VALUE)
                    .addComponent(catEditCombox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(catIDLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(courseIDOutLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(loadCourseBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(322, Short.MAX_VALUE)
                .addComponent(editCourseBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitBtn)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(catIDLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(courseIDOutLbl)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(courseLbl)
                            .addComponent(loadCourseBtn)
                            .addComponent(courseCombox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(courseNameLbl)
                            .addComponent(courseNamEditFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(catEditCombox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(catLbl))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editCourseBtn)
                    .addComponent(exitBtn))
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
     * This method will wait for the edit button to be pressed and then
     * will collect all the information needed for the edit
     */
private void editCourseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCourseBtnActionPerformed
    myLocalError = false; //rest the variables
    thisError = 0;
    myLocalString = "";

    // Check if all fields are filled in.  If not, then print an error
    // message and don't do any more processing
    if (courseNamEditFld.getText().equals("")) {
        myLocalError = true;

        UserMessageBox MyMessage = new UserMessageBox();
        MyMessage.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        MyMessage.setMessage("Please Enter All Fields.");
        MyMessage.setTitle("Error Editing Course");
        MyMessage.setVisible(true);
    }

    if (catEditCombox.getSelectedItem().toString().equals("-")) {
        myLocalError = true;

        UserMessageBox MyMessage = new UserMessageBox();
        MyMessage.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        MyMessage.setMessage("Please Select a Category.");
        MyMessage.setTitle("Error Editing Course");
        MyMessage.setVisible(true);
    }

    errorMessage = "Please check the following: \n\n";
    if (!myLocalError) {
        //validation of course name
        if (!CG41App.validateObject.validateCourseName(courseNamEditFld.getText())) {
            myLocalError = true;
            errorMessage = errorMessage + "The course name should begin with"
                    + "a letter and be followed by up to 20 letters, numbers"
                    + "apostophes, spaces and dashes.";
        }
        if (myLocalError) {
        //One of the validation checks failed
        UserMessageBox MyMessage = new UserMessageBox();
        MyMessage.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        MyMessage.setMessage(errorMessage);
        MyMessage.setTitle("Error Editing Course");
        MyMessage.setVisible(true);
        }
    }
    if (!myLocalError) {
        // TODO Check if already in database
    }
    if (!myLocalError) { //this will collect the information and amend the course
        myCat = catEditCombox.getSelectedItem().toString(); 
        myCategoryArray = myCat.split(","); //get category name and split it
        catID = Integer.parseInt(myCategoryArray[0]); //get category ID
        myLocalString = "update course set " + "CourseName= '" //create string
                + courseNamEditFld.getText().toString() + "', CatID = '" + catID
                + "' where CourseID= " + courseIDOutLbl.getText();
        CG41App.dbObject.sqlString = myLocalString; //set SQL string
        thisError = CG41App.dbObject.insertRecord();//execute query
    }
    if (0 == thisError && !myLocalError) {
        //if edit is successful
        UserMessageBox MyMessage = new UserMessageBox();
        MyMessage.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        MyMessage.setMessage("Course edited successfully");
        MyMessage.setTitle("Edit Successful");
        MyMessage.setVisible(true);
    }
}//GEN-LAST:event_editCourseBtnActionPerformed
/**
 * This method closes the window
 */
private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
    dispose();
}//GEN-LAST:event_exitBtnActionPerformed
/**
 * This method waits for the load button to be pressed and will load the selected
 * course into the fields for editing
 */
private void loadCourseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadCourseBtnActionPerformed
    myLocalString = ""; //reset variables
    myCourse = "";
    thisError = 0;
    
    myCourse = courseCombox.getSelectedItem().toString(); //get course infromation
    myCourseArray = myCourse.split(","); //split it to get the ID
    myLocalString = "select * from course where CourseID = '"
            + myCourseArray[0] + "'"; //find the course where the ID matches
    CG41App.dbObject.sqlString = myLocalString; //set the SQL string
    thisError = CG41App.dbObject.getRecordSetBySelect(); //execute
    try { //get and set the course name as well as ID for later
        CG41App.dbObject.rs.next();
        courseNamEditFld.setText(CG41App.dbObject.rs.getString("CourseName"));
        courseIDOutLbl.setText((myCourseArray[0]));
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
    loadCategories(); //need to load the categories for the user to choose from
}//GEN-LAST:event_loadCourseBtnActionPerformed

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
            java.util.logging.Logger.getLogger(EditCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new EditCourse().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox catEditCombox;
    private javax.swing.JLabel catIDLbl;
    private javax.swing.JLabel catLbl;
    private javax.swing.JComboBox courseCombox;
    private javax.swing.JLabel courseIDOutLbl;
    private javax.swing.JLabel courseLbl;
    private javax.swing.JTextField courseNamEditFld;
    private javax.swing.JLabel courseNameLbl;
    private javax.swing.JButton editCourseBtn;
    private javax.swing.JButton exitBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loadCourseBtn;
    // End of variables declaration//GEN-END:variables
}
