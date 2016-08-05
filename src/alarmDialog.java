
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Andrew Hyun
 */
public class alarmDialog extends javax.swing.JDialog {
    //delRow array containing row indices of rows to be deleted
    private int delRows[];
    //table data - make public to obtain information in ClockGUI
    public static DefaultTableModel data;
    //create regex string for date
    private final String dateRegexMonth = "((0\\d)|(\\d)|(1[012]))";
    private final String dateRegexDay = "(([012]\\d)|(\\d)|(3[01]))";
    private final String dateRegexYear = "((19\\d\\d)|(2\\d\\d\\d))";
    private final String dateRegex = dateRegexMonth + "/" + dateRegexDay + 
                                     "/" + dateRegexYear;
    //create regex string for time
    private final String timeRegexHour = "((0\\d)|(\\d)|1[012])";
    private final String timeRegexMinute = "((\\d)|([0-5]\\d))";
    private final String timeRegexSecond = "((\\d)|([0-5]\\d))";
    private final String timeRegexAM_PM = "((AM)|(PM)|(am)|(pm)|(aM)|"
                                            + "(pM)|(Am)|(Pm))";
    private final String timeRegex = timeRegexHour + ":" + timeRegexMinute +
                                ":" + timeRegexSecond + " " + timeRegexAM_PM;
    //define variables
                        
    private String date, time, reason;
    
    //get screen dimension
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    
    public alarmDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    alarmDialog(){
        initComponents();
        //center dialog and make visible
        this.setLocation(dim.width/2-200, dim.height/2-150);
        this.setVisible(false);
        if(data != null)
            Alarm_Log.setModel(data);
    }
    
    public static boolean alarmSet(){
        if(data != null && data.getRowCount() != 0)
            return true;
        else
            return false;
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        goBack = new javax.swing.JButton();
        addEntry = new javax.swing.JButton();
        deleteEntry = new javax.swing.JButton();
        Alarm_Log_Container = new javax.swing.JScrollPane();
        Alarm_Log = new javax.swing.JTable(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            };
        };
        dateField = new javax.swing.JTextField();
        timeField = new javax.swing.JTextField();
        reasonField = new javax.swing.JTextField();
        textFieldLabels = new javax.swing.JLabel();
        BG_alarmDialog = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Set Alarm");
        setAlwaysOnTop(true);
        setIconImage(null);
        setModal(true);
        setUndecorated(true);
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        goBack.setFont(new java.awt.Font("DS-Digital", 0, 15)); // NOI18N
        goBack.setText("Go Back");
        goBack.setMaximumSize(new java.awt.Dimension(150, 25));
        goBack.setMinimumSize(new java.awt.Dimension(150, 25));
        goBack.setPreferredSize(new java.awt.Dimension(150, 25));
        goBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackActionPerformed(evt);
            }
        });
        getContentPane().add(goBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 250, -1, -1));

        addEntry.setFont(new java.awt.Font("DS-Digital", 0, 15)); // NOI18N
        addEntry.setText("Add");
        addEntry.setMaximumSize(new java.awt.Dimension(81, 25));
        addEntry.setMinimumSize(new java.awt.Dimension(81, 25));
        addEntry.setPreferredSize(new java.awt.Dimension(81, 25));
        addEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEntryActionPerformed(evt);
            }
        });
        getContentPane().add(addEntry, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 80, -1));

        deleteEntry.setFont(new java.awt.Font("DS-Digital", 0, 15)); // NOI18N
        deleteEntry.setText("Delete");
        deleteEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEntryActionPerformed(evt);
            }
        });
        getContentPane().add(deleteEntry, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 80, -1));

        Alarm_Log.setAutoCreateRowSorter(true);
        Alarm_Log.setFont(new java.awt.Font("DS-Digital", 0, 11)); // NOI18N
        Alarm_Log.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Time", "Reason"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Alarm_Log.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Alarm_Log.setSelectionForeground(new java.awt.Color(153, 153, 255));
        Alarm_Log.setShowVerticalLines(false);
        Alarm_Log.getTableHeader().setResizingAllowed(false);
        Alarm_Log.getTableHeader().setReorderingAllowed(false);
        Alarm_Log.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Alarm_LogMouseDragged(evt);
            }
        });
        Alarm_Log.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Alarm_LogMousePressed(evt);
            }
        });
        Alarm_Log_Container.setViewportView(Alarm_Log);
        Alarm_Log.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        getContentPane().add(Alarm_Log_Container, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 350, 100));

        dateField.setFont(new java.awt.Font("DS-Digital", 0, 15)); // NOI18N
        dateField.setPreferredSize(new java.awt.Dimension(90, 20));
        dateField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                dateFieldFocusLost(evt);
            }
        });
        dateField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dateFieldKeyTyped(evt);
            }
        });
        getContentPane().add(dateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 190, -1, 30));

        timeField.setFont(new java.awt.Font("DS-Digital", 0, 15)); // NOI18N
        timeField.setPreferredSize(new java.awt.Dimension(90, 20));
        timeField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                timeFieldFocusLost(evt);
            }
        });
        timeField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                timeFieldKeyTyped(evt);
            }
        });
        getContentPane().add(timeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, -1, 30));

        reasonField.setFont(new java.awt.Font("DS-Digital", 0, 15)); // NOI18N
        reasonField.setPreferredSize(new java.awt.Dimension(160, 20));
        getContentPane().add(reasonField, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 190, 160, 30));

        textFieldLabels.setFont(new java.awt.Font("DS-Digital", 1, 15)); // NOI18N
        textFieldLabels.setForeground(new java.awt.Color(255, 0, 0));
        textFieldLabels.setText("      Date                   time                          reason");
        textFieldLabels.setMaximumSize(new java.awt.Dimension(50, 20));
        textFieldLabels.setMinimumSize(new java.awt.Dimension(50, 20));
        textFieldLabels.setPreferredSize(new java.awt.Dimension(50, 20));
        getContentPane().add(textFieldLabels, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 370, -1));

        BG_alarmDialog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClockBG.PNG"))); // NOI18N
        getContentPane().add(BG_alarmDialog, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void goBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackActionPerformed
        //close the JDialog and send data to clockGUI
        this.setVisible(false);
    }//GEN-LAST:event_goBackActionPerformed

    private void dateFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateFieldKeyTyped
        //set character variable c
        char c = evt.getKeyChar();
        //any key aside from '/' and numerics are disabled
        if(!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE ||
           c == KeyEvent.VK_DELETE) ){
            if(c == KeyEvent.VK_SLASH){}
            else{
            evt.consume();
            getToolkit().beep();
            }
        }
    }//GEN-LAST:event_dateFieldKeyTyped

    private void timeFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_timeFieldKeyTyped

        //set character variable c
        char c = evt.getKeyChar();
        //any key pressed aside from ':', ' ', 'a', 'p', and 'm' are disabled.
        if(!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE ||
           c == KeyEvent.VK_DELETE) ){
            if(c == ':' || c == ' ' || c == 'p' || c == 'm' || c == 'a'){}
            else{
            getToolkit().beep();
            evt.consume();
            }
        }
    }//GEN-LAST:event_timeFieldKeyTyped

    private void addEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEntryActionPerformed
        //add text inside textFields into private String variables
        date = dateField.getText();
        time = timeField.getText();
        reason = reasonField.getText();
        
        //convert dateRegex and timeRegex into pattern
        Pattern datePattern = Pattern.compile(dateRegex);
        Pattern timePattern = Pattern.compile(timeRegex);
        //compare date, time, and reason to see if null
        if (date.equals("") || time.equals("")){
            JOptionPane.showMessageDialog(this, "One of the fields is empty.\n"
                    + "Please double-check the field in red.");
        }
        // else if entry in either dateField or timeField do not match regex
        else if (datePattern.matcher(date).matches() == false || 
                timePattern.matcher(time).matches() == false)
            JOptionPane.showMessageDialog(this, "Incorrect format was used."
                    + " Please double-check the field in red.\nNOTE: 'Date' is in"
                    + " the format 'MM/DD/YYYY' and 'Time' is in the format"
                    + " 'HH:MM:SS AM/PM'.\nDo not forget to put the appropriate"
                    + " ':' or ' ' or '/' or 'AM' or 'PM'");
        //else add it into the table
        else{
            if(reason.equals(""))
                reason = "NULL";
            DefaultTableModel model = (DefaultTableModel)Alarm_Log.getModel();
            model.addRow(new Object[] { date, time, reason});
            model.fireTableDataChanged();
            data = model;
            Alarm_Log.setModel(data);
            
        }
    }//GEN-LAST:event_addEntryActionPerformed

    private void dateFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dateFieldFocusLost
        //turn background of dateField green if correct, red if incorrect
        String check = dateField.getText();
        Pattern datePattern = Pattern.compile(dateRegex);
        if(datePattern.matcher(check).matches()== true)
            dateField.setBackground(Color.green);
        else
            dateField.setBackground(Color.red);
    }//GEN-LAST:event_dateFieldFocusLost

    private void timeFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_timeFieldFocusLost
        //turn background of timeField green if correct, red if incorrect
        String check = timeField.getText();
        Pattern datePattern = Pattern.compile(timeRegex);
        if(datePattern.matcher(check).matches()== true)
            timeField.setBackground(Color.green);
        else
            timeField.setBackground(Color.red);
    }//GEN-LAST:event_timeFieldFocusLost

    private void deleteEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEntryActionPerformed
        //when user pushes delete, if delRow is not null, then delete selected rows
        if (delRows == null){}
        else {
            for(int i = 0; i < delRows.length; i++){
                DefaultTableModel model = (DefaultTableModel)Alarm_Log.getModel();
                model.removeRow(delRows[i]);
                model.fireTableDataChanged();
                data = model;
                Alarm_Log.setModel(data);
            }
        }   
    }//GEN-LAST:event_deleteEntryActionPerformed

    private void Alarm_LogMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Alarm_LogMousePressed
        delRows = Alarm_Log.getSelectedRows();
        Alarm_Log.setSelectionBackground(Color.BLUE);
    }//GEN-LAST:event_Alarm_LogMousePressed

    private void Alarm_LogMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Alarm_LogMouseDragged
        delRows = Alarm_Log.getSelectedRows();
        Alarm_Log.setSelectionBackground(Color.BLUE);
    }//GEN-LAST:event_Alarm_LogMouseDragged

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
            java.util.logging.Logger.getLogger(alarmDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(alarmDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(alarmDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(alarmDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                alarmDialog dialog = new alarmDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Alarm_Log;
    private javax.swing.JScrollPane Alarm_Log_Container;
    private javax.swing.JLabel BG_alarmDialog;
    private javax.swing.JButton addEntry;
    private javax.swing.JTextField dateField;
    private javax.swing.JButton deleteEntry;
    private javax.swing.JButton goBack;
    private javax.swing.JTextField reasonField;
    private javax.swing.JLabel textFieldLabels;
    private javax.swing.JTextField timeField;
    // End of variables declaration//GEN-END:variables
}
