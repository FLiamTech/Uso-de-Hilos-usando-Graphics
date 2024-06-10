package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

public class View_Dates extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txt_player1;
	public JTextField txt_player2;
	public JTextField txt_player3;
	public JButton btn_choose3;
	public JButton btn_choose2;
	public JButton btn_choose1;
	public JButton btn_acceptPlayers;
	public JButton btn_return;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Dates frame = new View_Dates();
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
	public View_Dates() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Dates", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 11, 438, 254);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Jugador 1:");
		lblNewLabel.setBounds(10, 31, 117, 14);
		panel.add(lblNewLabel);
		
		JLabel lblJugador = new JLabel("Jugador 2:");
		lblJugador.setBounds(10, 89, 117, 14);
		panel.add(lblJugador);
		
		JLabel lblJugador_2 = new JLabel("Jugador 3:");
		lblJugador_2.setBounds(10, 152, 117, 14);
		panel.add(lblJugador_2);
		
		txt_player1 = new JTextField();
		txt_player1.setBounds(124, 28, 222, 20);
		panel.add(txt_player1);
		txt_player1.setColumns(10);
		
		txt_player2 = new JTextField();
		txt_player2.setColumns(10);
		txt_player2.setBounds(124, 86, 222, 20);
		panel.add(txt_player2);
		
		txt_player3 = new JTextField();
		txt_player3.setColumns(10);
		txt_player3.setBounds(124, 149, 222, 20);
		panel.add(txt_player3);
		
		btn_choose1 = new JButton("New button");
		btn_choose1.setBounds(356, 27, 72, 23);
		panel.add(btn_choose1);
		
		btn_choose2 = new JButton("New button");
		btn_choose2.setBounds(356, 85, 72, 23);
		panel.add(btn_choose2);
		
		btn_choose3 = new JButton("New button");
		btn_choose3.setBounds(356, 148, 72, 23);
		panel.add(btn_choose3);
		
		btn_acceptPlayers = new JButton("Accept");
		btn_acceptPlayers.setBounds(10, 220, 150, 23);
		panel.add(btn_acceptPlayers);
		
		btn_return = new JButton("Return");
		btn_return.setBounds(278, 220, 150, 23);
		panel.add(btn_return);
	}
}
