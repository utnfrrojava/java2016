package ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Saludar extends JInternalFrame {
	private JTextField txtNombre;

	/**
	 * Create the frame.
	 */
	public Saludar() {
		super("Saludar",true,true,true,true);
		setBounds(100, 100, 240, 115);
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(12, 12, 70, 15);
		getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(97, 10, 114, 19);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JButton btnSaludar = new JButton("Saludar");
		btnSaludar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				saludar();
			}
		});
		btnSaludar.setBounds(42, 39, 117, 25);
		getContentPane().add(btnSaludar);

	}
	
	public void saludar(){
		JOptionPane.showMessageDialog(this, "Hola "+txtNombre.getText(), "Venimos en son de paz", JOptionPane.INFORMATION_MESSAGE);
	}

}
