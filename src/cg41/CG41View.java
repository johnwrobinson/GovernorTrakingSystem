package cg41;

import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * The application's main frame.
 */
public class CG41View extends FrameView {

    int i;

    public CG41View(SingleFrameApplication app) {
        super(app);

        initComponents();

        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = CG41App.getApplication().getMainFrame();
            aboutBox = new CG41AboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        CG41App.getApplication().show(aboutBox);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        mainTabs = new javax.swing.JTabbedPane();
        govPanel = new javax.swing.JPanel();
        addGovBtn = new javax.swing.JButton();
        remGovBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        remGovBtn1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        addCompletedCourseBtn = new javax.swing.JButton();
        removeCompletedCourseBtn = new javax.swing.JButton();
        viewCompCourseByGov = new javax.swing.JButton();
        viewCompCourseByCourse = new javax.swing.JButton();
        corCatPanel = new javax.swing.JPanel();
        addCouseBtn = new javax.swing.JButton();
        removeCourseBtn = new javax.swing.JButton();
        removeCatBtn = new javax.swing.JButton();
        addCatBtn = new javax.swing.JButton();
        viewCoursesBtn = new javax.swing.JButton();
        viewCatBtn = new javax.swing.JButton();
        editCatBtn = new javax.swing.JButton();
        editCourseBtn = new javax.swing.JButton();
        coursesLbl = new javax.swing.JLabel();
        categoriesLbl = new javax.swing.JLabel();
        reportPanel = new javax.swing.JPanel();
        exitBtn = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();

        mainPanel.setName("mainPanel"); // NOI18N

        mainTabs.setName("mainTabs"); // NOI18N

        govPanel.setName("govPanel"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(cg41.CG41App.class).getContext().getResourceMap(CG41View.class);
        addGovBtn.setText(resourceMap.getString("addGovBtn.text")); // NOI18N
        addGovBtn.setName("addGovBtn"); // NOI18N
        addGovBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addGovBtnActionPerformed(evt);
            }
        });

        remGovBtn.setText(resourceMap.getString("remGovBtn.text")); // NOI18N
        remGovBtn.setName("remGovBtn"); // NOI18N
        remGovBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remGovBtnActionPerformed(evt);
            }
        });

        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        remGovBtn1.setText(resourceMap.getString("remGovBtn1.text")); // NOI18N
        remGovBtn1.setName("remGovBtn1"); // NOI18N
        remGovBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remGovBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout govPanelLayout = new javax.swing.GroupLayout(govPanel);
        govPanel.setLayout(govPanelLayout);
        govPanelLayout.setHorizontalGroup(
            govPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(govPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(govPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addGovBtn)
                    .addComponent(remGovBtn1)
                    .addComponent(remGovBtn)
                    .addComponent(jButton1))
                .addContainerGap(185, Short.MAX_VALUE))
        );
        govPanelLayout.setVerticalGroup(
            govPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(govPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addGovBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(remGovBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(remGovBtn1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        mainTabs.addTab(resourceMap.getString("govPanel.TabConstraints.tabTitle"), govPanel); // NOI18N

        jPanel1.setName("jPanel1"); // NOI18N

        addCompletedCourseBtn.setText(resourceMap.getString("addCompletedCourseBtn.text")); // NOI18N
        addCompletedCourseBtn.setName("addCompletedCourseBtn"); // NOI18N
        addCompletedCourseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCompletedCourseBtnActionPerformed(evt);
            }
        });

        removeCompletedCourseBtn.setText(resourceMap.getString("removeCompletedCourseBtn.text")); // NOI18N
        removeCompletedCourseBtn.setName("removeCompletedCourseBtn"); // NOI18N
        removeCompletedCourseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCompletedCourseBtnActionPerformed(evt);
            }
        });

        viewCompCourseByGov.setText(resourceMap.getString("viewCompCourseByGov.text")); // NOI18N
        viewCompCourseByGov.setName("viewCompCourseByGov"); // NOI18N
        viewCompCourseByGov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCompCourseByGovActionPerformed(evt);
            }
        });

        viewCompCourseByCourse.setText(resourceMap.getString("viewCompCourseByCourse.text")); // NOI18N
        viewCompCourseByCourse.setName("viewCompCourseByCourse"); // NOI18N
        viewCompCourseByCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCompCourseByCourseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(removeCompletedCourseBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addCompletedCourseBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(viewCompCourseByCourse)
                    .addComponent(viewCompCourseByGov))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addCompletedCourseBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removeCompletedCourseBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(viewCompCourseByCourse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(viewCompCourseByGov)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        mainTabs.addTab(resourceMap.getString("jPanel1.TabConstraints.tabTitle"), jPanel1); // NOI18N

        corCatPanel.setName("corCatPanel"); // NOI18N

        addCouseBtn.setText(resourceMap.getString("addCouseBtn.text")); // NOI18N
        addCouseBtn.setName("addCouseBtn"); // NOI18N
        addCouseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCouseBtnActionPerformed(evt);
            }
        });

        removeCourseBtn.setText(resourceMap.getString("removeCourseBtn.text")); // NOI18N
        removeCourseBtn.setName("removeCourseBtn"); // NOI18N
        removeCourseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCourseBtnActionPerformed(evt);
            }
        });

        removeCatBtn.setText(resourceMap.getString("removeCatBtn.text")); // NOI18N
        removeCatBtn.setName("removeCatBtn"); // NOI18N
        removeCatBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCatBtnActionPerformed(evt);
            }
        });

        addCatBtn.setText(resourceMap.getString("addCatBtn.text")); // NOI18N
        addCatBtn.setName("addCatBtn"); // NOI18N
        addCatBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCatBtnActionPerformed(evt);
            }
        });

        viewCoursesBtn.setText(resourceMap.getString("viewCoursesBtn.text")); // NOI18N
        viewCoursesBtn.setName("viewCoursesBtn"); // NOI18N
        viewCoursesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCoursesBtnActionPerformed(evt);
            }
        });

        viewCatBtn.setText(resourceMap.getString("viewCatBtn.text")); // NOI18N
        viewCatBtn.setName("viewCatBtn"); // NOI18N
        viewCatBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCatBtnActionPerformed(evt);
            }
        });

        editCatBtn.setText(resourceMap.getString("editCatBtn.text")); // NOI18N
        editCatBtn.setName("editCatBtn"); // NOI18N
        editCatBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCatBtnActionPerformed(evt);
            }
        });

        editCourseBtn.setText(resourceMap.getString("editCourseBtn.text")); // NOI18N
        editCourseBtn.setName("editCourseBtn"); // NOI18N
        editCourseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCourseBtnActionPerformed(evt);
            }
        });

        coursesLbl.setText(resourceMap.getString("coursesLbl.text")); // NOI18N
        coursesLbl.setName("coursesLbl"); // NOI18N

        categoriesLbl.setText(resourceMap.getString("categoriesLbl.text")); // NOI18N
        categoriesLbl.setName("categoriesLbl"); // NOI18N

        javax.swing.GroupLayout corCatPanelLayout = new javax.swing.GroupLayout(corCatPanel);
        corCatPanel.setLayout(corCatPanelLayout);
        corCatPanelLayout.setHorizontalGroup(
            corCatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(corCatPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(corCatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(corCatPanelLayout.createSequentialGroup()
                        .addGroup(corCatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(viewCoursesBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(removeCourseBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addGroup(corCatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(viewCatBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(removeCatBtn)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, corCatPanelLayout.createSequentialGroup()
                        .addGroup(corCatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(corCatPanelLayout.createSequentialGroup()
                                .addGroup(corCatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(addCouseBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                    .addComponent(editCourseBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                                .addGap(58, 58, 58))
                            .addGroup(corCatPanelLayout.createSequentialGroup()
                                .addComponent(coursesLbl)
                                .addGap(132, 132, 132)))
                        .addGroup(corCatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(categoriesLbl)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, corCatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(editCatBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                .addComponent(addCatBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        corCatPanelLayout.setVerticalGroup(
            corCatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, corCatPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(corCatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coursesLbl)
                    .addComponent(categoriesLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(corCatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addCatBtn)
                    .addComponent(addCouseBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(corCatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editCatBtn)
                    .addComponent(editCourseBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(corCatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removeCourseBtn)
                    .addComponent(removeCatBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(corCatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viewCatBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewCoursesBtn))
                .addContainerGap())
        );

        mainTabs.addTab(resourceMap.getString("corCatPanel.TabConstraints.tabTitle"), corCatPanel); // NOI18N

        reportPanel.setName("reportPanel"); // NOI18N

        javax.swing.GroupLayout reportPanelLayout = new javax.swing.GroupLayout(reportPanel);
        reportPanel.setLayout(reportPanelLayout);
        reportPanelLayout.setHorizontalGroup(
            reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 324, Short.MAX_VALUE)
        );
        reportPanelLayout.setVerticalGroup(
            reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );

        mainTabs.addTab(resourceMap.getString("reportPanel.TabConstraints.tabTitle"), reportPanel); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(cg41.CG41App.class).getContext().getActionMap(CG41View.class, this);
        exitBtn.setAction(actionMap.get("quit")); // NOI18N
        exitBtn.setText(resourceMap.getString("exitBtn.text")); // NOI18N
        exitBtn.setName("exitBtn"); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainTabs, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(268, Short.MAX_VALUE)
                .addComponent(exitBtn)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(mainTabs, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exitBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setComponent(mainPanel);
        setMenuBar(menuBar);
    }// </editor-fold>//GEN-END:initComponents

private void addGovBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addGovBtnActionPerformed
    AddGovernor addGovWindow = new AddGovernor();
    addGovWindow.setVisible(true);
}//GEN-LAST:event_addGovBtnActionPerformed

private void addCouseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCouseBtnActionPerformed
    AddCourse addCourseWindow = new AddCourse();
    addCourseWindow.setVisible(true);
}//GEN-LAST:event_addCouseBtnActionPerformed

private void addCatBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCatBtnActionPerformed
    AddCategory addCategoryWindow = new AddCategory();
    addCategoryWindow.setVisible(true);
}//GEN-LAST:event_addCatBtnActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    ViewGovernors viewGovsWindow = new ViewGovernors();
    viewGovsWindow.setVisible(true);
}//GEN-LAST:event_jButton1ActionPerformed

private void addCompletedCourseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCompletedCourseBtnActionPerformed
    AddCompletedCourse addCompCourseWindow = new AddCompletedCourse();
    addCompCourseWindow.setVisible(true);
}//GEN-LAST:event_addCompletedCourseBtnActionPerformed

private void viewCoursesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCoursesBtnActionPerformed
    ViewCourses viewCourseWindow = new ViewCourses();
    viewCourseWindow.setVisible(true);
}//GEN-LAST:event_viewCoursesBtnActionPerformed

private void viewCatBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCatBtnActionPerformed
    ViewCategories viewCategoryWindow = new ViewCategories();
    viewCategoryWindow.setVisible(true);
}//GEN-LAST:event_viewCatBtnActionPerformed

private void remGovBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remGovBtn1ActionPerformed
    EditGovernor editGovernorWindow = new EditGovernor();
    editGovernorWindow.setVisible(true);
}//GEN-LAST:event_remGovBtn1ActionPerformed

private void removeCompletedCourseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCompletedCourseBtnActionPerformed
    RemoveCompletedCourse removeCompCourseWindow = new RemoveCompletedCourse();
    removeCompCourseWindow.setVisible(true);
}//GEN-LAST:event_removeCompletedCourseBtnActionPerformed

private void viewCompCourseByGovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCompCourseByGovActionPerformed
    ViewCompletedCoursesByGovernor viewCompCourseGovWindow = new ViewCompletedCoursesByGovernor();
    viewCompCourseGovWindow.setVisible(true);
}//GEN-LAST:event_viewCompCourseByGovActionPerformed

private void viewCompCourseByCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCompCourseByCourseActionPerformed
    ViewCompletedCoursesByCourse viewCompCourseCourseWindow = new ViewCompletedCoursesByCourse();
    viewCompCourseCourseWindow.setVisible(true);
}//GEN-LAST:event_viewCompCourseByCourseActionPerformed

private void removeCatBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCatBtnActionPerformed
    RemoveCategory removeCategoryWindow = new RemoveCategory();
    removeCategoryWindow.setVisible(true);
}//GEN-LAST:event_removeCatBtnActionPerformed

private void removeCourseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCourseBtnActionPerformed
    RemoveCourse removeCourseWindow = new RemoveCourse();
    removeCourseWindow.setVisible(true);
}//GEN-LAST:event_removeCourseBtnActionPerformed

private void remGovBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remGovBtnActionPerformed
    RemoveGovernor removeGovernorWindow = new RemoveGovernor();
    removeGovernorWindow.setVisible(true);
}//GEN-LAST:event_remGovBtnActionPerformed

private void editCatBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCatBtnActionPerformed
    EditCategory editCategoryWindow = new EditCategory();
    editCategoryWindow.setVisible(true);
}//GEN-LAST:event_editCatBtnActionPerformed

private void editCourseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCourseBtnActionPerformed
    EditCourse editCourseWindow = new EditCourse();
    editCourseWindow.setVisible(true);
}//GEN-LAST:event_editCourseBtnActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCatBtn;
    private javax.swing.JButton addCompletedCourseBtn;
    private javax.swing.JButton addCouseBtn;
    private javax.swing.JButton addGovBtn;
    private javax.swing.JLabel categoriesLbl;
    private javax.swing.JPanel corCatPanel;
    private javax.swing.JLabel coursesLbl;
    private javax.swing.JButton editCatBtn;
    private javax.swing.JButton editCourseBtn;
    private javax.swing.JButton exitBtn;
    private javax.swing.JPanel govPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTabbedPane mainTabs;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton remGovBtn;
    private javax.swing.JButton remGovBtn1;
    private javax.swing.JButton removeCatBtn;
    private javax.swing.JButton removeCompletedCourseBtn;
    private javax.swing.JButton removeCourseBtn;
    private javax.swing.JPanel reportPanel;
    private javax.swing.JButton viewCatBtn;
    private javax.swing.JButton viewCompCourseByCourse;
    private javax.swing.JButton viewCompCourseByGov;
    private javax.swing.JButton viewCoursesBtn;
    // End of variables declaration//GEN-END:variables
    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;
    private JDialog aboutBox;
}
