package entidades;

import java.io.Serializable;

public class Persona implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int dni;
	private String nombre;
	private String apellido;
	private boolean habilitado;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}public Persona(){
		
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public boolean isHabilitado() {
		return habilitado;
	}
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	@Override
	public boolean equals(Object per){
		return per instanceof Persona && ((Persona)per).getDni() == this.getDni();
	}
	
}
