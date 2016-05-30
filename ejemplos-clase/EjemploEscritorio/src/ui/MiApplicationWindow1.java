package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MiApplicationWindow1 {

	private JFrame frmMiPrimerFrame;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MiApplicationWindow1 window = new MiApplicationWindow1();
					window.frmMiPrimerFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MiApplicationWindow1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMiPrimerFrame = new JFrame();
		frmMiPrimerFrame.setTitle("Mi Primer Frame");
		frmMiPrimerFrame.setBounds(100, 100, 686, 472);
		frmMiPrimerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		desktopPane = new JDesktopPane();
		GroupLayout groupLayout = new GroupLayout(frmMiPrimerFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
					.addContainerGap())
		);
		frmMiPrimerFrame.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frmMiPrimerFrame.setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmNuevoSaludo = new JMenuItem("Nuevo Saludo");
		mntmNuevoSaludo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirNuevoSaludo();
			}
		});
		mnArchivo.add(mntmNuevoSaludo);
	}

	protected void abrirNuevoSaludo() {
		Saludo s = new Saludo();
		desktopPane.add(s);
		//s.pack();
		
		s.setVisible(true);
		
	}
}
