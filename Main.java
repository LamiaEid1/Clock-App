import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class Main {
    public static void main(String[] args) {
        new ClockApp();
    }
}

class ClockApp extends JFrame {
    
    // Instance variables for time formatting and UI components
    Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    ImageIcon icon;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    JTextField alarmInputField;
    JLabel alarmLabel;
    
    // Alarm related variables
    String alarmTime;
    boolean alarmSet = false;

    ClockApp() {
        // Frame setup
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Clock App");
        this.setLayout(new FlowLayout());
        this.setSize(400, 250);  // Adjusted size for alarm input
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        // Set up the clock icon
        icon = new ImageIcon("clock-icon.png");

        // Initialize SimpleDateFormat for time, day, and date
        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("MMMM dd, yyyy");

        // Initialize labels
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Serif", Font.PLAIN, 50));
        timeLabel.setForeground(new Color(102, 205, 170));
        timeLabel.setBackground(Color.black);
        timeLabel.setOpaque(true);

        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Serif", Font.PLAIN, 35));

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Serif", Font.PLAIN, 25));

        alarmInputField = new JTextField(10);
        alarmInputField.setFont(new Font("Serif", Font.PLAIN, 20));

        alarmLabel = new JLabel("Set Alarm Time (HH:mm:ss a):");
        alarmLabel.setFont(new Font("Serif", Font.PLAIN, 20));

        // Add components to frame
        this.setIconImage(icon.getImage());
        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.add(alarmLabel);
        this.add(alarmInputField);

        // Make the frame visible
        this.setVisible(true);

        // Create a Timer to update time every second and check for alarm
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTime();
                checkAlarm();
            }
        });
        timer.start();  // Start the timer

        // Allow user to set alarm via Enter key
        alarmInputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alarmTime = alarmInputField.getText().trim();
                alarmSet = true;
                JOptionPane.showMessageDialog(null, "Alarm set for " + alarmTime);
            }
        });
    }

    // Method to update the time and date labels
    public void updateTime() {
        String time = timeFormat.format(Calendar.getInstance().getTime());
        timeLabel.setText(time);

        String day = dayFormat.format(Calendar.getInstance().getTime());
        dayLabel.setText(day);

        String date = dateFormat.format(Calendar.getInstance().getTime());
        dateLabel.setText(date);
    }

    // Method to check if the current time matches the alarm time
    public void checkAlarm() {
        String currentTime = timeFormat.format(Calendar.getInstance().getTime());
        if (alarmSet && currentTime.equals(alarmTime)) {
            // Trigger alarm action
            JOptionPane.showMessageDialog(this, "ALARM! Time's up!", "Alarm", JOptionPane.INFORMATION_MESSAGE);
            alarmSet = false;  // Reset the alarm after it triggers
        }
    }
}
