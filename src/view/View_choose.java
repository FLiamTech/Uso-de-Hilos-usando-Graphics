package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.Color;

public class View_choose extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JList lst_catalogue;
	public JButton btn_acceptVehicle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_choose frame = new View_choose();
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
	public View_choose() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 11, 274, 391);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lst_catalogue = new JList();
		lst_catalogue.setBounds(10, 11, 264, 367);
		panel.add(lst_catalogue);
		
		LienzoCars pn_imagesCatalogue = new LienzoCars();
		pn_imagesCatalogue.setBackground(new Color(255, 128, 0));
		pn_imagesCatalogue.setBounds(284, 11, 251, 463);
		contentPane.add(pn_imagesCatalogue);
		pn_imagesCatalogue.setLayout(null);
		
		btn_acceptVehicle = new JButton("Accept");
		btn_acceptVehicle.setBounds(64, 413, 145, 50);
		contentPane.add(btn_acceptVehicle);
		
	}
}
