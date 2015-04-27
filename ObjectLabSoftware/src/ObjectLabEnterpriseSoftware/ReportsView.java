package ObjectLabEnterpriseSoftware;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ReportsView extends javax.swing.JFrame 
{
    private static final String NAME_OF_PAGE = "Reports";

    private static DefaultTableModel model;
    private FileManager inst;
    private String selectedPrinter;
    private UtilController controller;
    private String[] headers;
    private ArrayList<String> printers;
    
    
    /**
     * Creates new form Reports
     */
    public ReportsView() 
    {
        this.controller = new UtilController();
        printers = UtilController.getListOfAllDevices();
        if(printers.size() > 0){
            selectedPrinter = printers.get(0);
            headers = UtilController.getReportColumnHeaders(selectedPrinter);
        }
        else{
            headers = new String[1];
        }
        addWindowListener
        (
            new WindowAdapter() 
            {
                @Override
                public void windowClosing(WindowEvent we) 
                {
                    /* If they close the program then close out the window properly */
                    MainView home = new MainView();
                    home.setVisible(true);
                    home.setDevicesVisible(true);
                    dispose();                    
                }
            }
        );
    }

    public void ReportsPage() 
    {
        initComponents();
        model = (DefaultTableModel) reportsTable.getModel();
        for (ArrayList<Object> retval1 : UtilController.updateReportTableData(selectedPrinter)){ 
            model.addRow(retval1.toArray());
        }
	setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchFilter = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        searchKey = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        reportsTable = new javax.swing.JTable();
        exportBtn = new javax.swing.JButton();
        closeBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle(UtilController.getPageName(NAME_OF_PAGE));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchFilter.setModel(new javax.swing.DefaultComboBoxModel(headers));
        searchFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFilterActionPerformed(evt);
            }
        });
        getContentPane().add(searchFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 44, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Object Lab Search");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jLabel2.setText("Search:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 44, 43, 21));
        getContentPane().add(searchKey, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 44, 451, -1));

        searchBtn.setText("Search");
        searchBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });
        getContentPane().add(searchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 44, 77, 20));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 76, 682, 10));

        jButton1.setText("Export Master Report");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Reports");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 92, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(printers.toArray()));
        jComboBox1.setName("PrinterSelection"); // NOI18N
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        reportsTable.setAutoCreateRowSorter(true);
        reportsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            headers
        )
    );
    jScrollPane1.setViewportView(reportsTable);

    getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 118, 682, 203));

    exportBtn.setText("Export");
    exportBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
    exportBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            exportBtnActionPerformed(evt);
        }
    });
    getContentPane().add(exportBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, 61, 20));

    closeBtn.setText("Close");
    closeBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
    closeBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            closeBtnActionPerformed(evt);
        }
    });
    getContentPane().add(closeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(634, 330, 60, 20));

    jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ObjectLabEnterpriseSoftware/images/white_bg.jpg"))); // NOI18N
    jLabel5.setText("jLabel5");
    getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, -8, 710, 370));

    jMenu1.setText("File");
    jMenuBar1.add(jMenu1);

    jMenu2.setText("Help");

    jMenuItem1.setText("Contents");
    jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem1ActionPerformed(evt);
        }
    });
    jMenu2.add(jMenuItem1);

    jMenuBar1.add(jMenu2);

    setJMenuBar(jMenuBar1);

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        dispose();
        MainView home = new MainView();
        home.setVisible(true);
        home.setDevicesVisible(true);
    }//GEN-LAST:event_closeBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        
        /* All of the data that is being displayed and exported is found in the completedjobs table and retrieved here
            depending on what filter is triggered
        */
        //System.out.println(searchFilter.getSelectedItem().toString());
        //System.out.println(searchKey.getText().trim().length() > 0);
        if(searchKey.getText().trim().length() > 0){
            while (model.getRowCount() > 0) {
                model.removeRow(0);
            }
            
            model = (DefaultTableModel) reportsTable.getModel();
            System.out.println(searchFilter.getSelectedItem().toString());
            for (ArrayList<Object> retval1 : UtilController.updateReportTableData(searchFilter.getSelectedItem().toString(), searchKey.getText().trim(), selectedPrinter)){ 
                model.addRow(retval1.toArray());
            }

        }

    }//GEN-LAST:event_searchBtnActionPerformed

    private void exportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportBtnActionPerformed
        
        //Exports the grid plus headers to an excel file
        controller.exportReportToFile(model, headers);
        
    }//GEN-LAST:event_exportBtnActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + inst.getPDFAdmin());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error");  //print the error
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void searchFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFilterActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        
        //System.out.println(evt.getItem().toString());
        selectedPrinter = evt.getItem().toString();
        //System.out.println(report);
        
        headers = UtilController.getReportColumnHeaders(selectedPrinter);
        while (model.getRowCount() > 0) {
                model.removeRow(0);
            }
            reportsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            headers));
            model = (DefaultTableModel) reportsTable.getModel();
            searchFilter.setModel(new javax.swing.DefaultComboBoxModel(headers));
            for (ArrayList<Object> retval1 : UtilController.updateReportTableData(selectedPrinter)){ 
                model.addRow(retval1.toArray());
            }
        
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        UtilController.exportReportsForPrinters();
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton closeBtn;
    private javax.swing.JButton exportBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable reportsTable;
    private javax.swing.JButton searchBtn;
    private javax.swing.JComboBox searchFilter;
    private javax.swing.JTextField searchKey;
    // End of variables declaration//GEN-END:variables
}
