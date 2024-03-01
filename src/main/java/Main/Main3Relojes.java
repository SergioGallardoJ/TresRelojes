package Main;

import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class Main3Relojes {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main3Relojes window = new Main3Relojes();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main3Relojes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 286, 236);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel reloj1 = new JLabel("");
		reloj1.setForeground(Color.BLACK);
		reloj1.setFont(new Font("Rockwell Condensed", Font.BOLD, 15));
		reloj1.setHorizontalAlignment(SwingConstants.CENTER);
		reloj1.setBounds(10, 11, 246, 50);
		frame.getContentPane().add(reloj1);
		
		JLabel reloj2 = new JLabel("");
		reloj2.setForeground(Color.BLACK);
		reloj2.setFont(new Font("Rockwell Condensed", Font.BOLD, 15));
		reloj2.setHorizontalAlignment(SwingConstants.CENTER);
		reloj2.setBounds(10, 72, 246, 50);
		frame.getContentPane().add(reloj2);
		
		JLabel reloj3 = new JLabel("");
		reloj3.setFont(new Font("Rockwell Condensed", Font.BOLD, 15));
		reloj3.setHorizontalAlignment(SwingConstants.CENTER);
		reloj3.setBounds(10, 133, 246, 50);
		frame.getContentPane().add(reloj3);
		
		Timer timer = new Timer(1000, e -> {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

            // Zona horaria de España (UTC+1)
            sdf.setTimeZone(TimeZone.getTimeZone("Europe/Madrid"));
            reloj1.setText("Hora en España: " + sdf.format(cal.getTime()));

            // Zona horaria de Argentina (UTC-3)
            sdf.setTimeZone(TimeZone.getTimeZone("America/Argentina/Buenos_Aires"));
            reloj2.setText("Hora en Argentina: " + sdf.format(cal.getTime()));

            // Zona horaria de Miami (UTC-5)
            sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
            reloj3.setText("Hora en Miami: " + sdf.format(cal.getTime()));
        });
        timer.start();
	}

}
