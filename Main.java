import java.awt.*;
import java.text.*;
import java.util.*;
import javax.swing.*;

public class Main {

 public static void main(String[] args) {
  
  new ClockApp();
 }
}
class ClockApp extends JFrame{
 
    Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    ImageIcon icon;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String day;
    String date;
   
    ClockApp(){
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     this.setTitle("Clock App");
     this.setLayout(new FlowLayout());
     this.setSize(350,200);
     this.setResizable(false);
     this.setLocationRelativeTo(null);
     
     icon = new ImageIcon("clock-icon.png");

     timeFormat = new SimpleDateFormat("hh:mm:ss a");
     dayFormat = new SimpleDateFormat("EEEE");
     dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");
     
     timeLabel = new JLabel();
     timeLabel.setFont(new Font("Serif",Font.PLAIN,50));
     timeLabel.setForeground(new Color(102, 205, 170));
     timeLabel.setBackground(Color.black);
     timeLabel.setOpaque(true);
     
     dayLabel = new JLabel();
     dayLabel.setFont(new Font("Serif",Font.PLAIN,35));
     
     dateLabel = new JLabel();
     dateLabel.setFont(new Font("Serif",Font.PLAIN,25));

     this.setIconImage(icon.getImage());
     this.add(timeLabel);
     this.add(dayLabel);
     this.add(dateLabel);
     this.setVisible(true);
     
     setTime();
    }
    
    public void setTime() {
     while(true) {
     time = timeFormat.format(Calendar.getInstance().getTime());
     timeLabel.setText(time);
     
     day = dayFormat.format(Calendar.getInstance().getTime());
     dayLabel.setText(day);
     
     date = dateFormat.format(Calendar.getInstance().getTime());
     dateLabel.setText(date);
     
     try {
      Thread.sleep(1000);
     } catch (InterruptedException e) {
      e.printStackTrace();
     }
     }
    }
   }