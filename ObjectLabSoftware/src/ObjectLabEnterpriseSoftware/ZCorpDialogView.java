/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectLabEnterpriseSoftware;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ZCorpDialogView extends javax.swing.JFrame 
{
	private static final String NAME_OF_PAGE = "ZCorp Data Entry";

    private static final MainView home = new MainView();
    static String fileName = "";
    static String buildName = "";
    static String dateRun = "";
    static Double monoBinder = 0.0;
    static Double yellowBinder = 0.0;
    static Double magentaBuilder = 0.0;
    static Double cyanBuilder = 0.0;
    static Double cubicInches = 0.0;
    static Integer modelAmount = 0;
    static String buildTime = "";
    static String comments = "";

    static double monoPrice = 0;
    static double yellowPrice = 0;
    static double magentaPrice = 0;
    static double cyanPrice = 0;
    static double buildCost = 0;
    static boolean errFree = true;
    static boolean closing;

    /**
     * Creates new form ZCorpDialog
     */
    public ZCorpDialogView(java.awt.Frame parent, boolean modal, String build, int count) {
        //super(parent, modal);
        //par = parent;

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
            java.util.logging.Logger.getLogger(ZCorpDialogView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        setUp(build, count);
    }

    public void ZCorpDialogStart() 
    {
        setTitle("Add Information about" + new File(BPath.getText()).getName());
        hideErrorFields();
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        this.dateRunTxt.setText(sdf.format(date));
        this.setLocationRelativeTo(null);
        //search database for buildName
        //File BPathfile = new File(BPath.getText().replace("\\", "\\\\"));
        setVisible(true);

        addWindowListener
        (
            new WindowAdapter() 
            {
                @Override
                public void windowClosing(WindowEvent we) 
                {
                    UtilController.revertBuild(new File(BPath.getText()).getName(), "zcorp");
                    returnHome();
                    dispose();
                }
            }
        );
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BPath = new javax.swing.JTextField();
        dateRunTxt = new javax.swing.JTextField();
        mono = new javax.swing.JTextField();
        yellow = new javax.swing.JTextField();
        magenta = new javax.swing.JTextField();
        cyan = new javax.swing.JTextField();
        volume = new javax.swing.JTextField();
        numOfModels = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        submitBtn = new javax.swing.JButton();
        monoError = new javax.swing.JLabel();
        yellowError = new javax.swing.JLabel();
        magentaError = new javax.swing.JLabel();
        cyanError = new javax.swing.JLabel();
        volumeError = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        comment = new javax.swing.JTextArea();
        minStar = new javax.swing.JLabel();
        hourStar = new javax.swing.JLabel();
        dayStar = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        minutes = new javax.swing.JComboBox();
        days = new javax.swing.JComboBox();
        hours = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        runTimeError = new javax.swing.JLabel();
        closeBtn2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle(UtilController.getPageName(NAME_OF_PAGE));
        setMinimumSize(new java.awt.Dimension(370, 542));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BPath.setEditable(false);
        BPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BPathActionPerformed(evt);
            }
        });
        getContentPane().add(BPath, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 61, 220, -1));

        dateRunTxt.setEditable(false);
        getContentPane().add(dateRunTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 72, -1));
        getContentPane().add(mono, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 72, -1));
        getContentPane().add(yellow, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 178, 72, -1));
        getContentPane().add(magenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 208, 72, -1));
        getContentPane().add(cyan, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 238, 72, -1));
        getContentPane().add(volume, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 268, 70, -1));

        numOfModels.setEditable(false);
        getContentPane().add(numOfModels, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 117, 72, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Build Name:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 61, 95, 20));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Date Run:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 91, 95, 20));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Mono Binder:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 148, 95, 20));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Yellow Binder:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 178, 80, 20));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Magenta Binder:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 208, 95, 20));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Cyan Binder:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 238, 95, 20));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Volume (Cubic Inches):");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 268, -1, 20));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("No. of Models:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 117, 95, 20));

        submitBtn.setText("Submit");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });
        getContentPane().add(submitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 470, -1, -1));

        monoError.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        monoError.setForeground(new java.awt.Color(255, 0, 0));
        monoError.setText("Error Text");
        getContentPane().add(monoError, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 148, 140, 20));

        yellowError.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        yellowError.setForeground(new java.awt.Color(255, 0, 0));
        yellowError.setText("Error Text");
        getContentPane().add(yellowError, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 178, 140, -1));

        magentaError.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        magentaError.setForeground(new java.awt.Color(255, 0, 0));
        magentaError.setText("Error Text");
        getContentPane().add(magentaError, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 208, 140, 20));

        cyanError.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cyanError.setForeground(new java.awt.Color(255, 0, 0));
        cyanError.setText("Error Text");
        getContentPane().add(cyanError, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 238, 140, -1));

        volumeError.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        volumeError.setForeground(new java.awt.Color(255, 0, 0));
        volumeError.setText("Error Text");
        getContentPane().add(volumeError, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 268, 140, -1));

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("Comment (Optional):");
        jLabel26.setToolTipText("");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 359, -1, 20));

        comment.setColumns(20);
        comment.setRows(5);
        comment.setMinimumSize(new java.awt.Dimension(169, 94));
        jScrollPane1.setViewportView(comment);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 359, 220, -1));

        minStar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        minStar.setForeground(new java.awt.Color(255, 0, 0));
        minStar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minStar.setText("*");
        getContentPane().add(minStar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 319, 40, -1));

        hourStar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        hourStar.setForeground(new java.awt.Color(255, 0, 0));
        hourStar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hourStar.setText("*");
        getContentPane().add(hourStar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 319, 40, -1));

        dayStar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        dayStar.setForeground(new java.awt.Color(255, 0, 0));
        dayStar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dayStar.setText("*");
        getContentPane().add(dayStar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 319, 40, -1));

        jLabel11.setText("Days:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 299, -1, 20));

        jLabel12.setText("Hrs:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 299, 30, 20));

        jLabel10.setText("Min:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 299, -1, 20));

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Run Time:");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 299, 95, 20));

        minutes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        getContentPane().add(minutes, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 299, 40, -1));

        days.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10" }));
        getContentPane().add(days, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 299, 40, -1));

        hours.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        getContentPane().add(hours, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 299, 40, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Zcorp Data Entry");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 450, 10));

        runTimeError.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        runTimeError.setForeground(new java.awt.Color(255, 0, 0));
        runTimeError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        runTimeError.setText("Error Text");
        getContentPane().add(runTimeError, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 329, 220, 20));

        closeBtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ObjectLabEnterpriseSoftware/images/back_arrow_button.png"))); // NOI18N
        closeBtn2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        closeBtn2.setBorderPainted(false);
        closeBtn2.setContentAreaFilled(false);
        closeBtn2.setFocusPainted(false);
        closeBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtn2ActionPerformed(evt);
            }
        });
        getContentPane().add(closeBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 40));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ObjectLabEnterpriseSoftware/images/white_bg.jpg"))); // NOI18N
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 480, 520));

        jMenu1.setText("File");

        jMenuItem2.setText("Reports");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private boolean validateForm() 
    {
        try 
        {
            monoBinder = Double.parseDouble(mono.getText());
            monoError.setVisible(false);
        } 
        catch (NumberFormatException e) 
        {
            if (mono.getText().isEmpty()) 
            {
                monoError.setText("*Empty Field");
                monoError.setVisible(true);
            } 
            else 
            {
                monoError.setText("*Numbers only");
                monoError.setVisible(true);
            }
            return false;
        }
        
        try 
        {
            yellowBinder = Double.parseDouble(yellow.getText());
            yellowError.setVisible(false);
        } 
        catch (NumberFormatException e) 
        {
            if (yellow.getText().equals("")) 
            {
                yellowError.setText("*Empty Field");
                yellowError.setVisible(true);
            } 
            else 
            {
                yellowError.setText("*Numbers only");
                yellowError.setVisible(true);
            }
            return false;
        }
        
        try 
        {
            magentaBuilder = Double.parseDouble(magenta.getText());
            magentaError.setVisible(false);
        } 
        catch (NumberFormatException e) 
        {
            if (magenta.getText().equals("")) 
            {
                magentaError.setText("*Empty Field");
                magentaError.setVisible(true);
            } 
            else 
            {
                magentaError.setText("*Numbers only");
                magentaError.setVisible(true);
            }
            return false;
        }
        
        try 
        {
            cyanBuilder = Double.parseDouble(cyan.getText());
            cyanError.setVisible(false);
        } 
        catch (NumberFormatException e) 
        {
            if (cyan.getText().equals("")) 
            {
                cyanError.setText("*Empty Field");
                cyanError.setVisible(true);
            } 
            else 
            {
                cyanError.setText("*Numbers only");
                cyanError.setVisible(true);
            }
            return false;
        }
        
        try 
        {
            cubicInches = Double.parseDouble(volume.getText());
            volumeError.setVisible(false);
        } 
        catch (NumberFormatException e) 
        {
            if (volume.getText().equals("")) 
            {
                volumeError.setText("*Empty Field");
                volumeError.setVisible(true);
            } 
            else 
            {
                volumeError.setText("*Numbers only");
                volumeError.setVisible(true);
            }
            return false;
        }
        return true;
    }
    
    public static void returnHome() 
    {
        home.setPrintersVisible(false);
        home.setVisible(true);
    }

    
    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        if (validateForm()) 
        {
            Integer day = Integer.parseInt(days.getSelectedItem().toString());
            Integer hr = Integer.parseInt(hours.getSelectedItem().toString());
            Integer min = Integer.parseInt(minutes.getSelectedItem().toString());
            buildTime = day + ":" + hr + ":" + min;

            String buildPath = BPath.getText();
            buildName = new File(buildPath).getName();
            buildPath = buildPath.replace("\\", "\\\\");
            //File file = new File(buildPath);
            //buildName = file.getName();
            modelAmount = Integer.parseInt(numOfModels.getText());
            comments = comment.getText();

            if(!UtilController.submitBuildInfoToDB(buildName, "zcorp"))
              JOptionPane.showMessageDialog(new JPanel(), "Build was not created.", "Warning", JOptionPane.WARNING_MESSAGE);  
            
            returnHome();
            dispose();
            
        } 
        else 
        {
                System.out.println("ERRORS");
                JOptionPane.showMessageDialog(null, "There were errors that prevented your build information from being submitted to the database. \nPlease consult the red error text on screen.");
        }
    }//GEN-LAST:event_submitBtnActionPerformed

    private void hideErrorFields() 
    {
        monoError.setVisible(false);
        yellowError.setVisible(false);
        magentaError.setVisible(false);
        cyanError.setVisible(false);
        volumeError.setVisible(false);
        runTimeError.setVisible(false);
        dayStar.setVisible(false);
        hourStar.setVisible(false);
        minStar.setVisible(false);
    }
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        ReportsView rpr = new ReportsView();
        rpr.ReportsPage();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void BPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BPathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BPathActionPerformed

    private void closeBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtn2ActionPerformed
        dispose();
        home.resetAdminMode();
    }//GEN-LAST:event_closeBtn2ActionPerformed
    public static void setUp(String buildName, int countNumOfModels) {
        BPath.setText(buildName);
        numOfModels.setText("" + countNumOfModels);
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField BPath;
    private static javax.swing.JButton closeBtn2;
    private javax.swing.JTextArea comment;
    private javax.swing.JTextField cyan;
    private javax.swing.JLabel cyanError;
    private javax.swing.JTextField dateRunTxt;
    private javax.swing.JLabel dayStar;
    private javax.swing.JComboBox days;
    private javax.swing.JLabel hourStar;
    private javax.swing.JComboBox hours;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField magenta;
    private javax.swing.JLabel magentaError;
    private javax.swing.JLabel minStar;
    private javax.swing.JComboBox minutes;
    private javax.swing.JTextField mono;
    private javax.swing.JLabel monoError;
    public static javax.swing.JTextField numOfModels;
    private javax.swing.JLabel runTimeError;
    private javax.swing.JButton submitBtn;
    private javax.swing.JTextField volume;
    private javax.swing.JLabel volumeError;
    private javax.swing.JTextField yellow;
    private javax.swing.JLabel yellowError;
    // End of variables declaration//GEN-END:variables
}
