package ObjectLabEnterpriseSoftware;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class DeviceBuildView extends javax.swing.JFrame 
{
    private static final String NAME_OF_PAGE = "Build File Creator";	
    private static MainView home;    
    private static DefaultTableModel fileTableModel;
    private static int countNumOfModels;
    private static String BuildDevice;
    private static ArrayList buildInfo;
    private static DefaultTableModel modelA;

    FileManager inst;
        
    private void clearEntries(DefaultTableModel fileTableModel) 
    {
        while (fileTableModel.getRowCount() > 0)
            fileTableModel.removeRow(0);
    }
    
    private boolean valididateUserInput() 
    {
        /* filepathToSelectedDeviceBuild is the file location to the build file */
        if (filepathToSelectedDeviceBuild.getText().isEmpty()) 
        {
            ErrorText.setText("Choose a build file above!");
            ErrorText.setVisible(true);
            return false;
        } 
        else 
        {
            //checks to see if any sleections in table exist to prevent no file submit case
            for (int z = 0; z < fileTableModel.getRowCount(); z++) 
            {
                if ((Boolean) fileTableModel.getValueAt(z, 0)) 
                {
                    return true;
                }
            }
            
            ErrorText.setText("Select Files used for build!");
            ErrorText.setVisible(true);
            
            return false;
        }
    }

    public void startMakeBuildProcess() 
    {
        inst = new FileManager();
        home = new MainView();
        initComponents();
        try 
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) 
            {
                if ("Windows".equals(info.getName())) 
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } 
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) 
        {
            java.util.logging.Logger.getLogger(DeviceBuildView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        countNumOfModels = 0;
        fileTableModel = (DefaultTableModel) stlFileTable.getModel();
        ErrorText.setVisible(false);
        this.setVisible(true);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // close sockets, etc
               returnHome();
               dispose();
            }
        });
    }

    private boolean submit() 
    {
        countNumOfModels = 0;
        if (valididateUserInput()) 
        {
            ErrorText.setVisible(false);

            //int z;
            //ArrayList selected = new ArrayList();
            for (int z = 0; z < fileTableModel.getRowCount(); z++) 
            {
                if ((Boolean) fileTableModel.getValueAt(z, 0)) 
                {
                    UtilController.updateRecordInPendingJobsTable(filepathToSelectedDeviceBuild.getText(), (String) fileTableModel.getValueAt(z, 1));
                    countNumOfModels++;
                }
            }
            dispose();
            return true;
        }
        
        return false;
    }
    
    /**
     * This method is used to return to the homescreen after exiting select windows

 It is called from the following methods:
      DeviceBuildView.startMakingBuildProcess.windowClosing
      DeviceBuildView.closeBtnActionPerformed
      ObjetDialogView.ObjetDialogStart.windowClosing
      ObjetDialogView.submitBtnActionPerformed
      ZCorpDialogView.ZCorpDialogStart.windowClosing
      ZCorpDialogView.submitBtnActionPerformed
      SolidscapeDialogView.SolidscapeDialogStart.windowClosing
      SolidscapeDialogView.submitBtnActionPerformed
     */
    public void returnHome() {
        
        home.setDevicesVisible(true);
        home.setVisible(true);
        dispose();
    }
	
	private static void updateView(ArrayList<ArrayList<Object>> view)
    {
        System.out.println("ROW COUNT: " + fileTableModel.getRowCount());
        /* Clears up the rows in the view's model. */
        for(int rows = fileTableModel.getRowCount() - 1; rows >= 0; rows--)
            fileTableModel.removeRow(rows);
        
        /* Inserts data found in (ArrayList -> listOfRows) by row into the UI model to display */
        for (ArrayList<Object> row : view) 
            fileTableModel.addRow(row.toArray());
        System.out.println("ROW COUNT AFTER: " + fileTableModel.getRowCount());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     *
     * Checks if files were selected to submit
     * 
     * @return boolean statement
     *         returns true if a build file is selected
     *         returns false if there isn't a build file selected and aborts submit
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jSeparator1 = new javax.swing.JSeparator();
        Submit_Button = new javax.swing.JButton();
        closeBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        buildLbl = new javax.swing.JLabel();
        filepathToSelectedDeviceBuild = new javax.swing.JTextField();
        browseBtn = new javax.swing.JButton();
        ErrorText = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        stlFileTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        deviceNameComboBox = new javax.swing.JComboBox();
        jScrollPane4 = new javax.swing.JScrollPane();
        deviceInputTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        confirmBuildButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        reportsMenu = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        userGuide = new javax.swing.JMenuItem();

        jList1.setModel(new javax.swing.AbstractListModel()
        {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Art 101-001\nArt 201-002\nArt 401-004\nArt 501-005\nArt 601-006\nArt 701-007\nArt 801-009");
        jScrollPane1.setViewportView(jTextArea1);

        jScrollPane5.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle(UtilController.getPageName(NAME_OF_PAGE));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 380, 10));

        Submit_Button.setText("Submit");
        Submit_Button.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                Submit_ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(Submit_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 470, 90, 20));

        closeBtn.setText("Close");
        closeBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                closeBtnActionPerformed(evt);
            }
        });
        getContentPane().add(closeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 470, 80, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Choose STL files from build: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 200, 19));

        buildLbl.setText("Build File Name:");
        getContentPane().add(buildLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 20));

        filepathToSelectedDeviceBuild.setEditable(false);
        filepathToSelectedDeviceBuild.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                filepathToSelectedDeviceBuildActionPerformed(evt);
            }
        });
        getContentPane().add(filepathToSelectedDeviceBuild, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 200, -1));

        browseBtn.setText("Browse");
        browseBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                browseBtnActionPerformed(evt);
            }
        });
        getContentPane().add(browseBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 70, 20));

        ErrorText.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        ErrorText.setForeground(new java.awt.Color(255, 0, 0));
        ErrorText.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ErrorText.setText("Error Text");
        getContentPane().add(ErrorText, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 180, -1));

        stlFileTable.setAutoCreateRowSorter(true);
        stlFileTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "", "Project Title", "Date Submitted"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean []
            {
                true, false, false
            };

            public Class getColumnClass(int columnIndex)
            {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(stlFileTable);
        if (stlFileTable.getColumnModel().getColumnCount() > 0)
        {
            stlFileTable.getColumnModel().getColumn(0).setMinWidth(30);
            stlFileTable.getColumnModel().getColumn(0).setMaxWidth(30);
            stlFileTable.getColumnModel().getColumn(1).setResizable(false);
            stlFileTable.getColumnModel().getColumn(2).setResizable(false);
        }

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 360, 190));

        jLabel2.setText("Select Device:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        deviceNameComboBox.setModel(new javax.swing.DefaultComboBoxModel(UtilController.arrayListToStringArray(UtilController.getListOfCurrentDevices())));
        deviceNameComboBox.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                deviceNameComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(deviceNameComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 110, -1));

        deviceInputTable.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        deviceInputTable.setModel(new javax.swing.table.DefaultTableModel(new Object[]{}, 1)
        );
        deviceInputTable.setRowHeight(24);
        jScrollPane4.setViewportView(deviceInputTable);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 360, 90));

        jLabel3.setText("Enter Build Data");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        confirmBuildButton.setText("Confirm Build");
        confirmBuildButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                confirmBuildButtonActionPerformed(evt);
            }
        });
        getContentPane().add(confirmBuildButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ObjectLabEnterpriseSoftware/images/white_bg.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, -26, 410, 540));

        fileMenu.setText("File");

        reportsMenu.setText("Reports");
        reportsMenu.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                reportsMenuActionPerformed(evt);
            }
        });
        fileMenu.add(reportsMenu);

        jMenuBar1.add(fileMenu);

        helpMenu.setText("Help");

        userGuide.setText("User Guide");
        userGuide.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                userGuideActionPerformed(evt);
            }
        });
        helpMenu.add(userGuide);

        jMenuBar1.add(helpMenu);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void Submit_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Submit_ButtonActionPerformed
        //add stl information to build table zcorp and create incomplete entry
        if(!submit())
              JOptionPane.showMessageDialog(new JPanel(), "Submit failed.", "Warning", 
					  JOptionPane.WARNING_MESSAGE);  
         buildInfo = new ArrayList();

        //making sure a device was selected before enter build is alowed to function
        if (deviceNameComboBox.getSelectedItem().equals(""))
        {
            JOptionPane.showMessageDialog(null, "You must select a device before you complete build", 
					"You done GOOFED", JOptionPane.PLAIN_MESSAGE);
            return;
        }
        Vector buildData = (Vector) modelA.getDataVector().elementAt(0);

        if (buildData.contains(null))
        {
            JOptionPane.showMessageDialog(null, "All fields must be filled before Submitting", 
					"You done GOOFED", JOptionPane.PLAIN_MESSAGE);
        } else
        {
            for (int i = 0; i < buildData.size(); i++)
            {

                //error checking for values not entered
                /*if(deviceInputTable.getValueAt(1, i+1).equals(null)){
                 JOptionPane.showMessageDialog(null, "All fields must be filled before Submitting", "You done GOOFED", JOptionPane.PLAIN_MESSAGE);
                 return;
                 }*/
                buildInfo.add((String) buildData.elementAt(i));
            }
        }


    }//GEN-LAST:event_Submit_ButtonActionPerformed

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        // TODO add your handling code here:
        returnHome();
        dispose();
    }//GEN-LAST:event_closeBtnActionPerformed

    private void filepathToSelectedDeviceBuildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filepathToSelectedDeviceBuildActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filepathToSelectedDeviceBuildActionPerformed

    /**
     * Handles creating the file browser when browsing
     * @param evt 
     */
    private void browseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseBtnActionPerformed
        JFileChooser chooser = new JFileChooser();//Select Default
        chooser.setPreferredSize(new Dimension(800, 500));
        int returnVal = chooser.showDialog(null, "Select");

        if (returnVal == chooser.APPROVE_OPTION) 
        {
            File myFile = chooser.getSelectedFile();
            //String fileName = myFile.getName();
            filepathToSelectedDeviceBuild.setText(myFile.getAbsolutePath().replaceAll("'", ""));
        }
        
        if (!filepathToSelectedDeviceBuild.getText().isEmpty())
            updateView(UtilController.returnApprovedBuildsForPrinter((String) deviceNameComboBox.getSelectedItem()));
        
    }//GEN-LAST:event_browseBtnActionPerformed
   
    private void reportsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportsMenuActionPerformed
        // TODO add your handling code here:
        ReportsView reports = new ReportsView();
        reports.ReportsPage();
    }//GEN-LAST:event_reportsMenuActionPerformed

    private void userGuideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userGuideActionPerformed
        // TODO add your handling code here:
        UtilController.openAdminHelpPage();
    }//GEN-LAST:event_userGuideActionPerformed

    private void confirmBuildButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_confirmBuildButtonActionPerformed
    {//GEN-HEADEREND:event_confirmBuildButtonActionPerformed
        if (deviceNameComboBox.getSelectedItem().equals(""))
        {
            JOptionPane.showMessageDialog(null, "You must select a device before you complete build", 
					"You done GOOFED", JOptionPane.PLAIN_MESSAGE);
            return;
        }
        
        ArrayList<ArrayList<Object>> deviceHeaders;
        try
        {
            deviceHeaders = UtilController.returnTableHeader(BuildDevice);
           // deviceInputTable.setModel(new javax.swing.table.DefaultTableModel(deviceHeaders.toArray(), 1));

        } catch (SQLException ex)
        {
            Logger.getLogger(DeviceBuildView.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }//GEN-LAST:event_confirmBuildButtonActionPerformed

    private void deviceNameComboBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_deviceNameComboBoxActionPerformed
    {//GEN-HEADEREND:event_deviceNameComboBoxActionPerformed
        updateView(UtilController.returnApprovedBuildsForPrinter((String) deviceNameComboBox.getSelectedItem()));
        BuildDevice = (String) deviceNameComboBox.getSelectedItem();
        Object[] deviceFields;
        System.out.println(BuildDevice);
        ArrayList<ArrayList<Object>> deviceHeaders = new <ArrayList<Object>>ArrayList();
        try
        {
            deviceHeaders = UtilController.returnTableHeader(BuildDevice);
            deviceInputTable.setModel(new javax.swing.table.DefaultTableModel(deviceHeaders.toArray(), 1));
        } catch (SQLException ex)
        {
            Logger.getLogger(DeviceBuildView.class.getName()).log(Level.SEVERE, null, ex);
        }
//        for(int i = 0; i<printerHeaders.size(); i++){
//            System.out.println(deviceHeaders.get(i).toString());
//        }
        deviceFields = deviceHeaders.get(0).toArray();
        for(int i= 0; i<deviceFields.length;i++){
            System.out.println(deviceFields[i]);
        }
        deviceInputTable.setModel(new javax.swing.table.DefaultTableModel(deviceFields, 1));

    }//GEN-LAST:event_deviceNameComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ErrorText;
    private javax.swing.JButton Submit_Button;
    private javax.swing.JButton browseBtn;
    private javax.swing.JLabel buildLbl;
    private javax.swing.JButton closeBtn;
    private javax.swing.JButton confirmBuildButton;
    private javax.swing.JTable deviceInputTable;
    private javax.swing.JComboBox deviceNameComboBox;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JTextField filepathToSelectedDeviceBuild;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList jList1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JMenuItem reportsMenu;
    private javax.swing.JTable stlFileTable;
    private javax.swing.JMenuItem userGuide;
    // End of variables declaration//GEN-END:variables
}