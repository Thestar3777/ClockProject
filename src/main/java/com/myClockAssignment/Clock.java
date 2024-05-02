package com.myClockAssignment;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class Clock extends JFrame {
    private SimpleDateFormat timeFormat;
    JLabel timeLabel;
    String time;

    Clock() {
        //this creates the layout for the clock
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Clock");
        this.setSize(435,200);
        this.setLayout(null);

        //this part of the code sets the background image
        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setIcon(new ImageIcon("C:\\GradientImage.png"));
        backgroundLabel.setBounds(0,0,435,200);
        this.add(backgroundLabel);

        //Set the format for the time and style
        timeFormat = new SimpleDateFormat("HH:mm:ss / dd-MM-yyyy");
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Algerian", Font.BOLD, 30));
        timeLabel.setForeground(Color.BLACK);
        timeLabel.setBounds(20, 60, 370, 50);
        timeLabel.setBorder(new EmptyBorder(0, 25, 0, 0));
        backgroundLabel.add(timeLabel);


        //makes the clock visible and not resizable
        this.setResizable(false);
        this.setVisible(true);
    }

    //Starts the clock and sets priority for the printer
    public void startClock() {
        ClockUpdater updater = new ClockUpdater();
        Thread updaterThread = new Thread(updater);
        updaterThread.setPriority(Thread.MIN_PRIORITY);
        updaterThread.start();

        TimePrinter printer = new TimePrinter();
        Thread printerThread = new Thread(printer);
        printerThread.setPriority(Thread.MAX_PRIORITY);
        printerThread.start();
    }

    //Updates the time of the clock
    public class ClockUpdater implements Runnable{
        @Override
        public void run() {
            while (true) {
                updateTime();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        private void updateTime() {
            time = timeFormat.format(Calendar.getInstance().getTime());
            SwingUtilities.invokeLater(() -> timeLabel.setText(time));
        }
    }

    //The function is to print the time
    private class TimePrinter implements Runnable {
        private SimpleDateFormat timeFormat;
        public TimePrinter(){
            this.timeFormat = new SimpleDateFormat("HH:mm:ss / dd-MM-yyyy");
        }
        @Override
        public void run() {
            while (true) {
                printTime();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        private void printTime() {
            System.out.println(timeFormat.format(Calendar.getInstance().getTime()));
        }
    }
}