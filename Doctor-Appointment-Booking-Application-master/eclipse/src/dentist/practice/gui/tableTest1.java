package dentist.practice.gui;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class tableTest1 extends JFrame {
 
    private javax.swing.JPanel appointments1;
    private javax.swing.JPanel appointments2;
    private javax.swing.JPanel appointments3;
    private javax.swing.JPanel appointments4;
    private javax.swing.JPanel appointments5;
    private javax.swing.JPanel appointments6;
    private javax.swing.JPanel appointments7;
    private javax.swing.JPanel appointments8;
    private javax.swing.JPanel calendarMaster;
    private javax.swing.JLabel mon;
    private javax.swing.JLabel tue;
    private javax.swing.JLabel wen;
    private javax.swing.JLabel thu;
    private javax.swing.JLabel fri;
    private javax.swing.JPanel navWrapper;
    private javax.swing.JButton nextWeek;
    private javax.swing.JButton prevWeek;
    private javax.swing.JLabel hour1;
    private javax.swing.JLabel hour2;
    private javax.swing.JLabel hour3;
    private javax.swing.JLabel hour4;
    private javax.swing.JLabel hour5;
    private javax.swing.JLabel hour6;
    private javax.swing.JLabel hour7;
    private javax.swing.JLabel hour8;
    private javax.swing.JLabel weekDates;
    private javax.swing.JLabel yearDate;
    private Calendar calendar;
    private String weekStart;
    private String weekEnd;
    private String dateActual;
    private String displayMonth;
    private String displayYear;
    private final Date today;

    // Update Dates
    public void updateDate(){
        // Format
        DateFormat dFormat = new SimpleDateFormat("MMMM", Locale.getDefault());
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        displayMonth = dFormat.format(calendar.getTime());

        DateFormat dFormat2 = new SimpleDateFormat("dd", Locale.getDefault());
        weekStart = dFormat2.format(calendar.getTime());
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
        weekEnd = dFormat2.format(calendar.getTime());
        weekDates.setText("| " + displayMonth + " | Week: " + weekStart + " - " + weekEnd + " |");

        DateFormat yFormat = new SimpleDateFormat("yyyy", Locale.getDefault());
        displayYear = yFormat.format(calendar.getTime());
        yearDate.setText(" | " + displayYear + " |");
    }

    // Update The Days
    public void updateDays(){
        DateFormat dFormat = new SimpleDateFormat("dd", Locale.getDefault());
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        mon.setText("Mon - " + dFormat.format(calendar.getTime()));
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
        tue.setText("Tues - " + dFormat.format(calendar.getTime()));
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
        wen.setText("Wed - " + dFormat.format(calendar.getTime()));
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
        thu.setText("Thurs - " + dFormat.format(calendar.getTime()));
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
        fri.setText("Fri - " + dFormat.format(calendar.getTime()));
    }

    // Next Week Button
    private void nextWeekActionPerformed(java.awt.event.ActionEvent evt) {
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.add(Calendar.DATE, +7);
        updateDate();
        updateDays();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
    }

    // Previous Week Button
    private void prevWeekActionPerformed(java.awt.event.ActionEvent evt) {
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.add(Calendar.DATE, -7);
        updateDate();
        updateDays();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    tableTest1 frame = new tableTest1();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }  

    /**
     * Create the frame.
     */
    public tableTest1() {
        calendarMaster = new javax.swing.JPanel();
        navWrapper = new javax.swing.JPanel();
        nextWeek = new javax.swing.JButton();
        nextWeek.setFont(new Font("Tahoma", Font.BOLD, 20));
        prevWeek = new javax.swing.JButton();
        prevWeek.setFont(new Font("Tahoma", Font.BOLD, 20));
        weekDates = new javax.swing.JLabel();
        yearDate = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        calendarMaster.setBackground(new java.awt.Color(204, 204, 204));
        navWrapper.setBackground(new java.awt.Color(204, 204, 204));

        nextWeek.setText(">");
        nextWeek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextWeekActionPerformed(evt);
            }
        });

        prevWeek.setText("<");
        prevWeek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevWeekActionPerformed(evt);
            }
        });

        weekDates.setFont(new Font("Tahoma", Font.BOLD, 18)); // NOI18N
        weekDates.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        weekDates.setText("jLabel1");

        yearDate.setFont(new Font("Tahoma", Font.BOLD, 18)); // NOI18N
        yearDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yearDate.setText("jLabel1");
        mon = new javax.swing.JLabel();
        mon.setFont(new Font("Tahoma", Font.BOLD, 13));

        mon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mon.setText("jLabel1");
        tue = new javax.swing.JLabel();
        tue.setFont(new Font("Tahoma", Font.BOLD, 13));

        tue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tue.setText("jLabel1");
        wen = new javax.swing.JLabel();
        wen.setFont(new Font("Tahoma", Font.BOLD, 13));

        wen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wen.setText("jLabel1");
        thu = new javax.swing.JLabel();
        thu.setFont(new Font("Tahoma", Font.BOLD, 13));

        thu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        thu.setText("jLabel1");
        fri = new javax.swing.JLabel();
        fri.setFont(new Font("Tahoma", Font.BOLD, 13));

        fri.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fri.setText("jLabel1");
        hour1 = new javax.swing.JLabel();
        
                hour1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                hour1.setText("9:00");
        appointments1 = new javax.swing.JPanel();
        
                appointments1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 10));
        appointments2 = new javax.swing.JPanel();
        
                appointments2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        hour2 = new javax.swing.JLabel();
        
                hour2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                hour2.setText("10:00");
        hour3 = new javax.swing.JLabel();
        
                hour3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                hour3.setText("11:00");
        appointments3 = new javax.swing.JPanel();
        
                appointments3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        hour4 = new javax.swing.JLabel();
        
                hour4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                hour4.setText("12:00");
        appointments4 = new javax.swing.JPanel();
        
                appointments4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        hour5 = new javax.swing.JLabel();
        
                hour5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                hour5.setText("13:00");
        appointments5 = new javax.swing.JPanel();
        
                appointments5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        hour6 = new javax.swing.JLabel();
        
                hour6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                hour6.setText("14:00");
        appointments6 = new javax.swing.JPanel();
        
                appointments6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        hour7 = new javax.swing.JLabel();
        
                hour7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                hour7.setText("15:00");
        appointments7 = new javax.swing.JPanel();
        
                appointments7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        hour8 = new javax.swing.JLabel();
        
                hour8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                hour8.setText("16:00");
        appointments8 = new javax.swing.JPanel();
        
                appointments8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        javax.swing.GroupLayout navWrapperLayout = new javax.swing.GroupLayout(navWrapper);
        navWrapperLayout.setHorizontalGroup(
            navWrapperLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(navWrapperLayout.createSequentialGroup()
                    .addGap(28)
                    .addGroup(navWrapperLayout.createParallelGroup(Alignment.TRAILING)
                        .addComponent(hour7)
                        .addComponent(hour8)
                        .addComponent(hour5)
                        .addComponent(hour6)
                        .addComponent(hour4)
                        .addComponent(hour3)
                        .addComponent(hour2)
                        .addComponent(hour1))
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addGroup(navWrapperLayout.createParallelGroup(Alignment.LEADING, false)
                        .addComponent(appointments2, GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
                        .addComponent(appointments7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(appointments6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(appointments5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(appointments4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(appointments3, GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
                        .addComponent(appointments1, GroupLayout.PREFERRED_SIZE, 649, GroupLayout.PREFERRED_SIZE)
                        .addComponent(appointments8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(46, Short.MAX_VALUE))
                .addGroup(navWrapperLayout.createSequentialGroup()
                    .addContainerGap(53, Short.MAX_VALUE)
                    .addGroup(navWrapperLayout.createParallelGroup(Alignment.TRAILING, false)
                        .addGroup(navWrapperLayout.createSequentialGroup()
                            .addComponent(prevWeek, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                            .addGap(43)
                            .addComponent(weekDates, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE)
                            .addGap(39))
                        .addGroup(navWrapperLayout.createSequentialGroup()
                            .addComponent(mon)
                            .addGap(84)
                            .addComponent(tue)
                            .addGap(66)
                            .addComponent(wen)
                            .addGap(67)))
                    .addGroup(navWrapperLayout.createParallelGroup(Alignment.TRAILING)
                        .addGroup(navWrapperLayout.createSequentialGroup()
                            .addComponent(thu)
                            .addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                            .addComponent(fri, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                            .addGap(66))
                        .addGroup(navWrapperLayout.createSequentialGroup()
                            .addComponent(yearDate)
                            .addGap(70)
                            .addComponent(nextWeek, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addGap(22))))
        );
        navWrapperLayout.setVerticalGroup(
            navWrapperLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(navWrapperLayout.createSequentialGroup()
                    .addGap(17)
                    .addGroup(navWrapperLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(yearDate)
                        .addComponent(prevWeek, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(weekDates, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nextWeek, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                    .addGroup(navWrapperLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(fri, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(thu, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(wen, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(tue, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(mon, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
                    .addGap(26)
                    .addGroup(navWrapperLayout.createParallelGroup(Alignment.TRAILING, false)
                        .addGroup(navWrapperLayout.createSequentialGroup()
                            .addComponent(appointments1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                            .addGap(18)
                            .addComponent(appointments2, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                            .addGap(18))
                        .addGroup(navWrapperLayout.createSequentialGroup()
                            .addGap(22)
                            .addComponent(hour1)
                            .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hour2)
                            .addGap(39)))
                    .addGroup(navWrapperLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(appointments3, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                        .addGroup(navWrapperLayout.createSequentialGroup()
                            .addGap(21)
                            .addComponent(hour3)))
                    .addGroup(navWrapperLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(navWrapperLayout.createSequentialGroup()
                            .addGap(36)
                            .addComponent(hour4))
                        .addGroup(navWrapperLayout.createSequentialGroup()
                            .addGap(18)
                            .addComponent(appointments4, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(navWrapperLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(navWrapperLayout.createSequentialGroup()
                            .addGap(37)
                            .addComponent(hour5))
                        .addGroup(navWrapperLayout.createSequentialGroup()
                            .addGap(18)
                            .addComponent(appointments5, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(navWrapperLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(navWrapperLayout.createSequentialGroup()
                            .addGap(34)
                            .addComponent(hour6))
                        .addGroup(navWrapperLayout.createSequentialGroup()
                            .addGap(18)
                            .addComponent(appointments6, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(navWrapperLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(navWrapperLayout.createSequentialGroup()
                            .addGap(38)
                            .addComponent(hour7))
                        .addGroup(navWrapperLayout.createSequentialGroup()
                            .addGap(18)
                            .addComponent(appointments7, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(navWrapperLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(navWrapperLayout.createSequentialGroup()
                            .addGap(38)
                            .addComponent(hour8))
                        .addGroup(navWrapperLayout.createSequentialGroup()
                            .addGap(18)
                            .addComponent(appointments8, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)))
                    .addGap(57))
        );
        navWrapper.setLayout(navWrapperLayout);

        javax.swing.GroupLayout calendarMasterLayout = new javax.swing.GroupLayout(calendarMaster);
        calendarMasterLayout.setHorizontalGroup(
            calendarMasterLayout.createParallelGroup(Alignment.TRAILING)
                .addGroup(Alignment.LEADING, calendarMasterLayout.createSequentialGroup()
                    .addComponent(navWrapper, GroupLayout.PREFERRED_SIZE, 770, Short.MAX_VALUE))
        );
        calendarMasterLayout.setVerticalGroup(
            calendarMasterLayout.createParallelGroup(Alignment.TRAILING)
                .addGroup(Alignment.LEADING, calendarMasterLayout.createSequentialGroup()
                    .addComponent(navWrapper, GroupLayout.PREFERRED_SIZE, 737, GroupLayout.PREFERRED_SIZE))
        );
        calendarMaster.setLayout(calendarMasterLayout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
                layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(calendarMaster, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                );
        layout.setVerticalGroup(
                layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(calendarMaster, GroupLayout.PREFERRED_SIZE, 915, GroupLayout.PREFERRED_SIZE))
                );
        getContentPane().setLayout(layout);

        pack();      

        // Initialize
        calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        Date now = new Date();
        calendar.setTime(now);
        DateFormat dateAct = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        today = calendar.getTime();
        dateActual = dateAct.format(calendar.getTime());

        // Update
        updateDate();
        updateDays();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.setTime(today);

    } 
}
