/**
 *
 * @author Andrew Hyun
 */


import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class ClockGUI extends javax.swing.JFrame {
private boolean isThereAlarm;
private int count = 0;
private JDialog aDialog;
private int hour;
private int second;
private int minute;
private int AM_PM;
private int intAM_PM;
private int intHour;
private int intMinute;
private int intSecond;
private int intDay;
private int intMonth;
private int intYear;
private boolean alarmSound = false;
private String alarmDate;
private String alarmTime;
private String alarmReason;
        

    public ClockGUI() {
        initComponents();
        startUp();
        
        //create a thread
        new Thread(){
            //run function
            public void run(){
                //continuously loop to get hour/min/sec/am_pm
                while(true){
                    Calendar cal = new GregorianCalendar();
                    hour = cal.get(Calendar.HOUR);
                    minute = cal.get(Calendar.MINUTE);
                    second = cal.get(Calendar.SECOND);
                    AM_PM = cal.get(Calendar.AM_PM);
                    String day_or_night = "";
                    
                    if (hour == 0)
                        hour = 12;
                    
                    if (AM_PM == 1)
                        day_or_night = "PM";
                    else
                        day_or_night = "AM";
                    String time = String.format("%02d:%02d:%02d %s", hour, 
                                            minute, second, day_or_night);
                    
                    //Display String time in JLabel: Time_Display
                    Time_Display.setText(time);    
                    //obtain boolean of whetehr alarm is present or not
                    isThereAlarm = alarmDialog.alarmSet();
                    
                    //Alarm_Status label indicatse if alarm is set or not
                    if(isThereAlarm == false){
                        Alarm_Status.setForeground(Color.RED);
                        Alarm_Status.setText("No Alarm Set");
                    }
                    //Go through data to see if data value matches current time
                    else{
                        Alarm_Status.setForeground(Color.GREEN);
                        Alarm_Status.setText("Alarm Set");
                        for(int i = 0; i < alarmDialog.data.getRowCount(); i++){
                            alarmDate = alarmDialog.data.getValueAt(i, 0)
                                    .toString();
                            String[] alarmDateMMDDYYYY = alarmDate.split("/");
                                intMonth = Integer.parseInt(alarmDateMMDDYYYY[0]) - 1;
                                intDay = Integer.parseInt(alarmDateMMDDYYYY[1]);
                                intYear = Integer.parseInt(alarmDateMMDDYYYY[2]);
                            if(cal.get(Calendar.MONTH) == intMonth &&
                                    cal.get(Calendar.DATE) == intDay &&
                                    cal.get(Calendar.YEAR) == intYear){
                                alarmTime = alarmDialog.data.getValueAt(i, 1)
                                    .toString();
                                String[] alarmTimeHHMMSS = alarmTime.split((":"));
                                String[] alarmTimeSSAM_PM = alarmTimeHHMMSS[2].split(" ");
                                    intHour = Integer.parseInt(alarmTimeHHMMSS[0]);
                                    intMinute = Integer.parseInt(alarmTimeHHMMSS[1]);
                                    intSecond = Integer.parseInt(alarmTimeSSAM_PM[0]);
                                if(alarmTimeSSAM_PM[1].equals("AM") || alarmTimeSSAM_PM[1].equals("am")
                                   || alarmTimeSSAM_PM[1].equals("aM") || alarmTimeSSAM_PM[1].equals("Am"))
                                    intAM_PM = 0;
                                else
                                    intAM_PM = 1;
                                if(hour == intHour && minute == intMinute &&
                                        second == intSecond && AM_PM == intAM_PM){            
                                    alarmSound = true;
                                    alarmReason = alarmDialog.data.getValueAt(i, 2).toString();
                                    alarmDialog.data.removeRow(i);
                                    alarmDialog.data.fireTableDataChanged();

                                }
                            } 
                        }
                    }
                    if (alarmSound == true){
                        try {
                            //open alarmSound dialog box and set alarmSound to false
                            JDialog alarmSoundDialog = new alarmSoundDialog(alarmDate,
                                    alarmTime, alarmReason);
                        } catch (UnsupportedAudioFileException ex) {
                            Logger.getLogger(ClockGUI.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (LineUnavailableException ex) {
                            Logger.getLogger(ClockGUI.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(ClockGUI.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ClockGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        alarmSound = false;
                    }    
                }
            }
        }.start();
    }
    
    public void startUp(){
    aDialog = new alarmDialog();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Time_Display = new javax.swing.JLabel();
        Alarm = new javax.swing.JButton();
        Alarm_Status = new javax.swing.JLabel();
        BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Clock");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Time_Display.setFont(new java.awt.Font("DS-Digital", 0, 65)); // NOI18N
        Time_Display.setForeground(new java.awt.Color(255, 0, 0));
        Time_Display.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Time_Display, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 340, 160));

        Alarm.setFont(new java.awt.Font("DS-Digital", 0, 15)); // NOI18N
        Alarm.setText("Set Alarm");
        Alarm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AlarmMouseClicked(evt);
            }
        });
        getContentPane().add(Alarm, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, 30));

        Alarm_Status.setFont(new java.awt.Font("DS-Digital", 0, 20)); // NOI18N
        getContentPane().add(Alarm_Status, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 120, 30));

        BG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClockBG.PNG"))); // NOI18N
        getContentPane().add(BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, -6, 410, 310));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //When "Alarm" Button is pushed, it will create instance of JFrame alarmGUI
    private void AlarmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AlarmMouseClicked
        // TODO add your handling code here:
        //create new alarm dialog object when button is pushed
            aDialog.setVisible(true);
    }//GEN-LAST:event_AlarmMouseClicked

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
            java.util.logging.Logger.getLogger(ClockGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClockGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClockGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClockGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClockGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Alarm;
    private javax.swing.JLabel Alarm_Status;
    private javax.swing.JLabel BG;
    private javax.swing.JLabel Time_Display;
    // End of variables declaration//GEN-END:variables


}
