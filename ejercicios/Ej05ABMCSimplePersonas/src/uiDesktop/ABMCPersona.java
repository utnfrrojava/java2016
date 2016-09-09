package uiDesktop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.apache.logging.log4j.Level;

import javax.swing.JCheckBox;
import javax.swing.JButton;

import entidades.*;
import negocio.*;
import utils.ApplicationException;
import utils.SuperLogger;

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
	private JTextField txtId;

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
		lblDni.setBounds(12, 68, 70, 15);
		frame.getContentPane().add(lblDni);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(12, 114, 70, 15);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(12, 169, 70, 15);
		frame.getContentPane().add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(82, 167, 114, 19);
		frame.getContentPane().add(txtApellido);
		txtApellido.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(82, 112, 114, 19);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setBounds(82, 66, 114, 19);
		frame.getContentPane().add(txtDni);
		txtDni.setColumns(10);
		
		chckbxHabilitado = new JCheckBox("Habilitado");
		chckbxHabilitado.setBounds(8, 228, 129, 23);
		frame.getContentPane().add(chckbxHabilitado);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				agregar();
			}
		});
		btnAgregar.setBounds(244, 135, 117, 25);
		frame.getContentPane().add(btnAgregar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificar();
			}
		});
		btnModificar.setBounds(244, 164, 117, 25);
		frame.getContentPane().add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				eliminar();
			}
		});
		btnEliminar.setBounds(244, 197, 117, 25);
		frame.getContentPane().add(btnEliminar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				buscar();
			}
		});
		btnBuscar.setBounds(244, 63, 117, 25);
		frame.getContentPane().add(btnBuscar);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(12, 28, 70, 15);
		frame.getContentPane().add(lblId);
		
		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setBounds(82, 26, 114, 19);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);
	}
	
	protected void eliminar() {
		ctrl.delete(MapearDeFormulario());
		limpiarCampos();
	}

	protected void modificar() {
		try {
			ctrl.update(MapearDeFormulario());
			limpiarCampos();
		} catch (ApplicationException appe) {
			notifyUser(appe.getMessage(),appe, Level.DEBUG);
		} catch (ArithmeticException are){
			notifyUser("Ha ocurrido algo inesperado, consulte al administrador de sistemas.", are, Level.ERROR);
		} catch (Exception e){
			notifyUser("Ha ocurrido algo totalmente inesperado, consulte al administrador de sistemas.",e, Level.FATAL);
		} 
	}

	protected void agregar() {
		if(datosValidos()){
			try {
				Persona p=MapearDeFormulario();
				ctrl.add(p);
				MapearAFormulario(p);
				//limpiarCampos();
			} catch (ApplicationException ae) {
				notifyUser(ae.getMessage(),ae, Level.DEBUG);
			}
		}
	}

	private void limpiarCampos() {
		txtId.setText("");
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
		if(p.getId()>0) txtId.setText(String.valueOf(p.getId()));
		txtDni.setText(String.valueOf( p.getDni()));
		txtNombre.setText(p.getNombre());
		txtApellido.setText(p.getApellido());
		chckbxHabilitado.setSelected(p.isHabilitado());
	}
	
	public Persona MapearDeFormulario(){
		Persona p = new Persona();
		if(!txtId.getText().isEmpty()) p.setId(Integer.parseInt(txtId.getText()));
		p.setDni(Integer.parseInt(txtDni.getText()));
		p.setApellido(txtApellido.getText());
		p.setNombre(txtNombre.getText());
		p.setHabilitado(chckbxHabilitado.isSelected());
		
		return p;
	}
	
	public boolean datosValidos(){
		boolean valido=true;
		if(txtDni.getText().trim().length()==0
			|| txtNombre.getText().trim().length()==0
			|| txtApellido.getText().trim().length()==0){
			valido=false;
			notifyUser("Complete todos los campos");
		}
		if(valido && !txtDni.getText().matches("[0-9]*")){
			valido=false;
			notifyUser("DNI inválido");
		}
			
		return valido;
	}
	
	private void notifyUser(String mensaje) {
		JOptionPane.showMessageDialog(this.frame, mensaje);
	}

	private void notifyUser(String mensaje, Exception e, Level l) {
		notifyUser(mensaje);
		SuperLogger.logger.log(l, mensaje, e);
	}
}
