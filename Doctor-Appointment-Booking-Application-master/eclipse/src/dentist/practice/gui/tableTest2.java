package dentist.practice.gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;
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
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

@SuppressWarnings("serial")
public class tableTest2 extends JFrame {

    private JPanel contentPane;  
    // Variables declaration
    private javax.swing.JPanel appointmentSlot1;
    private javax.swing.JPanel appointmentSlot2;
    private javax.swing.JPanel appointmentSlot3;
    private javax.swing.JPanel appointmentSlot4;
    private javax.swing.JPanel appointmentSlot5;
    private javax.swing.JPanel appointmentSlot6;
    private javax.swing.JPanel appointmentSlot7;
    private javax.swing.JPanel appointmentSlot8;
    private javax.swing.JPanel calendarMaster;
    private javax.swing.JLabel date1L;
    private javax.swing.JLabel date2L;
    private javax.swing.JLabel date3L;
    private javax.swing.JLabel date4L;
    private javax.swing.JLabel date5L;
    private javax.swing.JPanel hourSlot1;
    private javax.swing.JPanel hourSlot2;
    private javax.swing.JPanel hourSlot3;
    private javax.swing.JPanel hourSlot4;
    private javax.swing.JPanel hourSlot5;
    private javax.swing.JPanel hourSlot6;
    private javax.swing.JPanel hourSlot7;
    private javax.swing.JPanel hourSlot8;
    private javax.swing.JPanel navWrapper;
    private javax.swing.JButton nextWeek;
    private javax.swing.JButton prevWeek;
    private javax.swing.JLabel timeLBL1;
    private javax.swing.JLabel timeLBL2;
    private javax.swing.JLabel timeLBL3;
    private javax.swing.JLabel timeLBL4;
    private javax.swing.JLabel timeLBL5;
    private javax.swing.JLabel timeLBL6;
    private javax.swing.JLabel timeLBL7;
    private javax.swing.JLabel timeLBL8;
    private javax.swing.JPanel timetableWrapper;
    private javax.swing.JLabel weekDates;
    private javax.swing.JLabel yearDate;
    private Calendar calendar;
    private String weekStart;
    private String weekEnd;
    private String dateActual;
    private String displayMonth;
    private String displayYear;
    private final Date today;

    // Function to update the Nav bar, adjusting the date to the correct week etc.
    public void updateNav(){
        // Format and display the date values in the Nav bar
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

    // Function to update the dates for the days of the week, heading the day buttons
    public void updateDays(){
        DateFormat dFormat = new SimpleDateFormat("dd", Locale.getDefault());
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        date1L.setText("Mon - " + dFormat.format(calendar.getTime()));
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
        date2L.setText("Tues - " + dFormat.format(calendar.getTime()));
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
        date3L.setText("Wed - " + dFormat.format(calendar.getTime()));
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
        date4L.setText("Thurs - " + dFormat.format(calendar.getTime()));
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
        date5L.setText("Fri - " + dFormat.format(calendar.getTime()));
    }


    /**
     * Create the frame.
     */
    public tableTest2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        calendarMaster = new javax.swing.JPanel();
        navWrapper = new javax.swing.JPanel();
        nextWeek = new javax.swing.JButton();
        nextWeek.setFont(new Font("Tahoma", Font.BOLD, 20));
        prevWeek = new javax.swing.JButton();
        prevWeek.setFont(new Font("Tahoma", Font.BOLD, 20));
        weekDates = new javax.swing.JLabel();
        yearDate = new javax.swing.JLabel();
        timetableWrapper = new javax.swing.JPanel();
        hourSlot1 = new javax.swing.JPanel();
        timeLBL1 = new javax.swing.JLabel();
        appointmentSlot1 = new javax.swing.JPanel();
        hourSlot2 = new javax.swing.JPanel();
        timeLBL2 = new javax.swing.JLabel();
        appointmentSlot2 = new javax.swing.JPanel();
        hourSlot3 = new javax.swing.JPanel();
        timeLBL3 = new javax.swing.JLabel();
        appointmentSlot3 = new javax.swing.JPanel();
        hourSlot4 = new javax.swing.JPanel();
        timeLBL4 = new javax.swing.JLabel();
        appointmentSlot4 = new javax.swing.JPanel();
        hourSlot5 = new javax.swing.JPanel();
        timeLBL5 = new javax.swing.JLabel();
        appointmentSlot5 = new javax.swing.JPanel();
        hourSlot6 = new javax.swing.JPanel();
        timeLBL6 = new javax.swing.JLabel();
        appointmentSlot6 = new javax.swing.JPanel();
        hourSlot7 = new javax.swing.JPanel();
        timeLBL7 = new javax.swing.JLabel();
        appointmentSlot7 = new javax.swing.JPanel();
        hourSlot8 = new javax.swing.JPanel();
        timeLBL8 = new javax.swing.JLabel();
        appointmentSlot8 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        calendarMaster.setBackground(new java.awt.Color(255, 255, 255));

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
        date1L = new javax.swing.JLabel();
        date1L.setFont(new Font("Tahoma", Font.BOLD, 13));

        date1L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        date1L.setText("jLabel1");
        date2L = new javax.swing.JLabel();
        date2L.setFont(new Font("Tahoma", Font.BOLD, 13));

        date2L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        date2L.setText("jLabel1");
        date3L = new javax.swing.JLabel();
        date3L.setFont(new Font("Tahoma", Font.BOLD, 13));

        date3L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        date3L.setText("jLabel1");
        date4L = new javax.swing.JLabel();
        date4L.setFont(new Font("Tahoma", Font.BOLD, 13));

        date4L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        date4L.setText("jLabel1");
        date5L = new javax.swing.JLabel();
        date5L.setFont(new Font("Tahoma", Font.BOLD, 13));

        date5L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        date5L.setText("jLabel1");

        javax.swing.GroupLayout navWrapperLayout = new javax.swing.GroupLayout(navWrapper);
        navWrapperLayout.setHorizontalGroup(
            navWrapperLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(navWrapperLayout.createSequentialGroup()
                    .addGroup(navWrapperLayout.createParallelGroup(Alignment.TRAILING)
                        .addGroup(Alignment.LEADING, navWrapperLayout.createSequentialGroup()
                            .addGap(53)
                            .addComponent(prevWeek, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                            .addGap(43)
                            .addComponent(weekDates, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE))
                        .addGroup(Alignment.LEADING, navWrapperLayout.createSequentialGroup()
                            .addGap(87)
                            .addComponent(date1L)
                            .addGap(76)
                            .addComponent(date2L)
                            .addGap(64)
                            .addComponent(date3L)))
                    .addGroup(navWrapperLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(navWrapperLayout.createSequentialGroup()
                            .addGap(39)
                            .addComponent(yearDate))
                        .addGroup(navWrapperLayout.createSequentialGroup()
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(date4L)))
                    .addGroup(navWrapperLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(navWrapperLayout.createSequentialGroup()
                            .addPreferredGap(ComponentPlacement.UNRELATED)
                            .addComponent(date5L, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                            .addGap(61))
                        .addGroup(Alignment.TRAILING, navWrapperLayout.createSequentialGroup()
                            .addGap(70)
                            .addComponent(nextWeek, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(22))))
        );
        navWrapperLayout.setVerticalGroup(
            navWrapperLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(navWrapperLayout.createSequentialGroup()
                    .addGap(19)
                    .addGroup(navWrapperLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(yearDate)
                        .addComponent(prevWeek, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(weekDates, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nextWeek, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(navWrapperLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(date1L, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(date2L, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(date3L, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(date4L, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(date5L, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
        );
        navWrapper.setLayout(navWrapperLayout);

        timetableWrapper.setBackground(new java.awt.Color(153, 153, 153));

        hourSlot1.setBackground(new java.awt.Color(204, 204, 204));

        timeLBL1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLBL1.setText("9:00");

        appointmentSlot1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 10));

        javax.swing.GroupLayout hourSlot1Layout = new javax.swing.GroupLayout(hourSlot1);
        hourSlot1.setLayout(hourSlot1Layout);
        hourSlot1Layout.setHorizontalGroup(
                hourSlot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(hourSlot1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(timeLBL1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(appointmentSlot1, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                );
        hourSlot1Layout.setVerticalGroup(
                hourSlot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(hourSlot1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(timeLBL1)
                        .addContainerGap(33, Short.MAX_VALUE))
                .addGroup(hourSlot1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(appointmentSlot1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                );

        hourSlot2.setBackground(new java.awt.Color(204, 204, 204));

        timeLBL2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLBL2.setText("10:00");

        appointmentSlot2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        javax.swing.GroupLayout hourSlot2Layout = new javax.swing.GroupLayout(hourSlot2);
        hourSlot2.setLayout(hourSlot2Layout);
        hourSlot2Layout.setHorizontalGroup(
                hourSlot2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(hourSlot2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(timeLBL2)
                        .addGap(18, 18, 18)
                        .addComponent(appointmentSlot2, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                );
        hourSlot2Layout.setVerticalGroup(
                hourSlot2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(hourSlot2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(timeLBL2)
                        .addContainerGap(33, Short.MAX_VALUE))
                .addGroup(hourSlot2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(appointmentSlot2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                );

        hourSlot3.setBackground(new java.awt.Color(204, 204, 204));

        timeLBL3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLBL3.setText("11:00");

        appointmentSlot3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        javax.swing.GroupLayout hourSlot3Layout = new javax.swing.GroupLayout(hourSlot3);
        hourSlot3.setLayout(hourSlot3Layout);
        hourSlot3Layout.setHorizontalGroup(
                hourSlot3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(hourSlot3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(timeLBL3)
                        .addGap(18, 18, 18)
                        .addComponent(appointmentSlot3, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                );
        hourSlot3Layout.setVerticalGroup(
                hourSlot3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(hourSlot3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(timeLBL3)
                        .addContainerGap(33, Short.MAX_VALUE))
                .addGroup(hourSlot3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(appointmentSlot3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                );

        hourSlot4.setBackground(new java.awt.Color(204, 204, 204));

        timeLBL4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLBL4.setText("12:00");

        appointmentSlot4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        javax.swing.GroupLayout hourSlot4Layout = new javax.swing.GroupLayout(hourSlot4);
        hourSlot4.setLayout(hourSlot4Layout);
        hourSlot4Layout.setHorizontalGroup(
                hourSlot4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(hourSlot4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(timeLBL4)
                        .addGap(18, 18, 18)
                        .addComponent(appointmentSlot4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                );
        hourSlot4Layout.setVerticalGroup(
                hourSlot4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(hourSlot4Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(timeLBL4)
                        .addContainerGap(33, Short.MAX_VALUE))
                .addGroup(hourSlot4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(appointmentSlot4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                );

        hourSlot5.setBackground(new java.awt.Color(204, 204, 204));

        timeLBL5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLBL5.setText("13:00");

        appointmentSlot5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        javax.swing.GroupLayout hourSlot5Layout = new javax.swing.GroupLayout(hourSlot5);
        hourSlot5.setLayout(hourSlot5Layout);
        hourSlot5Layout.setHorizontalGroup(
                hourSlot5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(hourSlot5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(timeLBL5)
                        .addGap(18, 18, 18)
                        .addComponent(appointmentSlot5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                );
        hourSlot5Layout.setVerticalGroup(
                hourSlot5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(hourSlot5Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(timeLBL5)
                        .addContainerGap(33, Short.MAX_VALUE))
                .addGroup(hourSlot5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(appointmentSlot5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                );

        hourSlot6.setBackground(new java.awt.Color(204, 204, 204));

        timeLBL6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLBL6.setText("14:00");

        appointmentSlot6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        javax.swing.GroupLayout hourSlot6Layout = new javax.swing.GroupLayout(hourSlot6);
        hourSlot6.setLayout(hourSlot6Layout);
        hourSlot6Layout.setHorizontalGroup(
                hourSlot6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(hourSlot6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(timeLBL6)
                        .addGap(18, 18, 18)
                        .addComponent(appointmentSlot6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                );
        hourSlot6Layout.setVerticalGroup(
                hourSlot6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(hourSlot6Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(timeLBL6)
                        .addContainerGap(33, Short.MAX_VALUE))
                .addGroup(hourSlot6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(appointmentSlot6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                );

        hourSlot7.setBackground(new java.awt.Color(204, 204, 204));

        timeLBL7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLBL7.setText("15:00");

        appointmentSlot7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        javax.swing.GroupLayout hourSlot7Layout = new javax.swing.GroupLayout(hourSlot7);
        hourSlot7.setLayout(hourSlot7Layout);
        hourSlot7Layout.setHorizontalGroup(
                hourSlot7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(hourSlot7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(timeLBL7)
                        .addGap(18, 18, 18)
                        .addComponent(appointmentSlot7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                );
        hourSlot7Layout.setVerticalGroup(
                hourSlot7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(hourSlot7Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(timeLBL7)
                        .addContainerGap(33, Short.MAX_VALUE))
                .addGroup(hourSlot7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(appointmentSlot7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                );

        hourSlot8.setBackground(new java.awt.Color(204, 204, 204));

        timeLBL8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLBL8.setText("16:00");

        appointmentSlot8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        javax.swing.GroupLayout hourSlot8Layout = new javax.swing.GroupLayout(hourSlot8);
        hourSlot8.setLayout(hourSlot8Layout);
        hourSlot8Layout.setHorizontalGroup(
                hourSlot8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(hourSlot8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(timeLBL8)
                        .addGap(18, 18, 18)
                        .addComponent(appointmentSlot8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                );
        hourSlot8Layout.setVerticalGroup(
                hourSlot8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(hourSlot8Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(timeLBL8)
                        .addContainerGap(33, Short.MAX_VALUE))
                .addGroup(hourSlot8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(appointmentSlot8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                );

        javax.swing.GroupLayout timetableWrapperLayout = new javax.swing.GroupLayout(timetableWrapper);
        timetableWrapper.setLayout(timetableWrapperLayout);
        timetableWrapperLayout.setHorizontalGroup(
                timetableWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(timetableWrapperLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(timetableWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(hourSlot1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(hourSlot2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(hourSlot3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(hourSlot4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(hourSlot5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(hourSlot6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(hourSlot7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(hourSlot8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                );
        timetableWrapperLayout.setVerticalGroup(
                timetableWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(timetableWrapperLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(hourSlot1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hourSlot2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hourSlot3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hourSlot4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hourSlot5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hourSlot6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hourSlot7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hourSlot8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(16, Short.MAX_VALUE))
                );

        javax.swing.GroupLayout calendarMasterLayout = new javax.swing.GroupLayout(calendarMaster);
        calendarMasterLayout.setHorizontalGroup(
                calendarMasterLayout.createParallelGroup(Alignment.TRAILING)
                .addGroup(calendarMasterLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(calendarMasterLayout.createParallelGroup(Alignment.LEADING)
                                .addComponent(navWrapper, GroupLayout.PREFERRED_SIZE, 750, Short.MAX_VALUE)
                                .addComponent(timetableWrapper, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                );
        calendarMasterLayout.setVerticalGroup(
                calendarMasterLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(calendarMasterLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(navWrapper, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addComponent(timetableWrapper, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(68, Short.MAX_VALUE))
                );
        calendarMaster.setLayout(calendarMasterLayout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
                layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(calendarMaster, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(34, Short.MAX_VALUE))
                );
        layout.setVerticalGroup(
                layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(calendarMaster, GroupLayout.PREFERRED_SIZE, 915, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
        getContentPane().setLayout(layout);

        pack();      

        // Initialise the calendar
        calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        Date now = new Date();
        calendar.setTime(now);
        DateFormat dateAct = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        today = calendar.getTime();
        dateActual = dateAct.format(calendar.getTime());

        // Update individual UI elements, pinging the SQL database
        updateNav();
        updateDays();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.setTime(today);

    }

    // Code below here is functions related to GUI specific elements //

    // Function to advance to the next week
    private void nextWeekActionPerformed(java.awt.event.ActionEvent evt) {
        // Set date to monday, and add 7 Days
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.add(Calendar.DATE, +7);
        // Update the UI elements
        updateNav();
        updateDays();
        // Default the displayed day to monday
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
    }

    // Same as above, but for previous weeks
    private void prevWeekActionPerformed(java.awt.event.ActionEvent evt) {
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.add(Calendar.DATE, -7);

        updateNav();
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
                    tableTest2 frame = new tableTest2();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }   
}
