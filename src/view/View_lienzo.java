package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Logic_view_lienzo;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;

public class View_lienzo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btn_select;
	public JLabel lbl_player2;
	public JLabel lbl_player3;
	public JLabel lbl_player1;
	public JButton btn_pause;
	public JButton btn_Start;
	public Lienzo lienzo;
	public JLabel lbl_winner;
	public JButton btn_bet3;
	public JButton btn_bet2;
	public JButton btn_bet1;
	public JLabel lbl_bet;
	public JLabel lbl_state;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_lienzo frame = new View_lienzo();
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
	public View_lienzo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 934, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(196, 11, 574, 88);
		panel.setBackground(new Color(192, 192, 192));
		contentPane.add(panel);
		panel.setLayout(null);
		
		btn_Start = new JButton("Inicio");
		btn_Start.setBounds(106, 11, 107, 66);
		panel.add(btn_Start);
		
		btn_pause = new JButton("Pausa");
		btn_pause.setBounds(380, 11, 107, 66);
		panel.add(btn_pause);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(196, 457, 574, 88);
		panel_1.setBackground(new Color(192, 192, 192));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Apostar por el 1");
		lblNewLabel_2.setBounds(39, 11, 109, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Apostar por el 2");
		lblNewLabel_2_1.setBounds(254, 11, 109, 14);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Apostar por el 3");
		lblNewLabel_2_2.setBounds(434, 11, 109, 14);
		panel_1.add(lblNewLabel_2_2);
		
		btn_bet2 = new JButton("Press");
		btn_bet2.setBounds(246, 42, 89, 23);
		panel_1.add(btn_bet2);
		
		btn_bet3 = new JButton("Press");
		btn_bet3.setBounds(434, 42, 89, 23);
		panel_1.add(btn_bet3);
		
		btn_bet1 = new JButton("Press");
		btn_bet1.setBounds(39, 42, 89, 23);
		panel_1.add(btn_bet1);
		
		Lienzo pn_lienzo = new Lienzo(this);
		pn_lienzo.setBackground(new Color(0, 255, 255));
		pn_lienzo.setBounds(196, 110, 574, 336);
		contentPane.add(pn_lienzo);
		pn_lienzo.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBounds(10, 6, 182, 539);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		btn_select = new JButton("Seleccionar");
		btn_select.setBounds(21, 99, 123, 66);
		panel_2.add(btn_select);
		
		JLabel lblNewLabel = new JLabel("Jugador 1:");
		lblNewLabel.setBounds(10, 204, 104, 14);
		panel_2.add(lblNewLabel);
		
		lbl_player1 = new JLabel("Desconocido");
		lbl_player1.setBounds(10, 241, 104, 14);
		panel_2.add(lbl_player1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Jugador 2:");
		lblNewLabel_1_1.setBounds(10, 277, 104, 14);
		panel_2.add(lblNewLabel_1_1);
		
		lbl_player2 = new JLabel("Desconocido");
		lbl_player2.setBounds(10, 314, 104, 14);
		panel_2.add(lbl_player2);
		
		JLabel lblDesconocido_1_1 = new JLabel("Jugador 3:");
		lblDesconocido_1_1.setBounds(10, 353, 104, 14);
		panel_2.add(lblDesconocido_1_1);
		
		lbl_player3 = new JLabel("Desconocido");
		lbl_player3.setBounds(10, 393, 104, 14);
		panel_2.add(lbl_player3);
		
		this.lienzo = pn_lienzo;
		View_Dates vd = new View_Dates();
		View_choose vc = new View_choose();
		Logic_view_lienzo lv = new Logic_view_lienzo(this, vd, vc, pn_lienzo);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(192, 192, 192));
		panel_3.setBounds(780, 11, 138, 534);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Ganador");
		lblNewLabel_1.setBounds(21, 11, 107, 14);
		panel_3.add(lblNewLabel_1);
		
		lbl_winner = new JLabel("Desconocido");
		lbl_winner.setBounds(10, 53, 118, 14);
		panel_3.add(lbl_winner);
		
		JLabel lblNewLabel_1_2 = new JLabel("Bolsa");
		lblNewLabel_1_2.setBounds(21, 106, 107, 14);
		panel_3.add(lblNewLabel_1_2);
		
		lbl_bet = new JLabel("Desconocido");
		lbl_bet.setBounds(10, 156, 107, 14);
		panel_3.add(lbl_bet);
		
		JLabel lbl_bet_1 = new JLabel("Estado apuesta");
		lbl_bet_1.setBounds(21, 204, 107, 14);
		panel_3.add(lbl_bet_1);
		
		lbl_state = new JLabel("Desconocido");
		lbl_state.setBounds(10, 253, 128, 14);
		panel_3.add(lbl_state);
	}
}
