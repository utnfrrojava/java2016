package uiDesktop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import entidades.*;
import negocio.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ABMCPersona {
	
	private CtrlABMCPersona ctrl;

	private JFrame frame;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtDni;
	private JCheckBox chckbxHabilitado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCPersona window = new ABMCPersona();
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
	public ABMCPersona() {
		initialize();
		ctrl= new CtrlABMCPersona();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDni = new JLabel("Dni:");
		lblDni.setBounds(12, 12, 70, 15);
		frame.getContentPane().add(lblDni);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(12, 58, 70, 15);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(12, 113, 70, 15);
		frame.getContentPane().add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(82, 111, 114, 19);
		frame.getContentPane().add(txtApellido);
		txtApellido.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(82, 56, 114, 19);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setBounds(82, 10, 114, 19);
		frame.getContentPane().add(txtDni);
		txtDni.setColumns(10);
		
		chckbxHabilitado = new JCheckBox("Habilitado");
		chckbxHabilitado.setBounds(8, 172, 129, 23);
		frame.getContentPane().add(chckbxHabilitado);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				agregar();
			}
		});
		btnAgregar.setBounds(244, 79, 117, 25);
		frame.getContentPane().add(btnAgregar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificar();
			}
		});
		btnModificar.setBounds(244, 108, 117, 25);
		frame.getContentPane().add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				eliminar();
			}
		});
		btnEliminar.setBounds(244, 141, 117, 25);
		frame.getContentPane().add(btnEliminar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				buscar();
			}
		});
		btnBuscar.setBounds(244, 7, 117, 25);
		frame.getContentPane().add(btnBuscar);
	}
	
	protected void eliminar() {
		ctrl.delete(MapearDeFormulario());
		limpiarCampos();
	}

	protected void modificar() {
		ctrl.update(MapearDeFormulario());
		limpiarCampos();
	}

	protected void agregar() {
		ctrl.add(MapearDeFormulario());
		limpiarCampos();
	}

	private void limpiarCampos() {
		txtDni.setText("");
		txtApellido.setText("");
		txtNombre.setText("");
		chckbxHabilitado.setSelected(false);
	}

	protected void buscar() {
		Persona p = ctrl.getPersona(MapearDeFormulario());
		if(p!=null){
			MapearAFormulario(p);
		}
	}

	public void MapearAFormulario(Persona p){
		txtDni.setText(String.valueOf( p.getDni()));
		txtNombre.setText(p.getNombre());
		txtApellido.setText(p.getApellido());
		chckbxHabilitado.setSelected(p.isHabilitado());
	}
	
	public Persona MapearDeFormulario(){
		Persona p = new Persona();
		p.setDni(Integer.parseInt(txtDni.getText()));
		p.setApellido(txtApellido.getText());
		p.setNombre(txtNombre.getText());
		p.setHabilitado(chckbxHabilitado.isSelected());
		
		return p;
	}
}
