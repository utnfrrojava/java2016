package ejemploOO;

public class Padre {
	
	public static String texto;
	
	public static String getTexto() {
		return texto;
	}

	public static void setTexto(String texto) {
		Padre.texto = texto;
	}

	public Padre(String nombre, String descripcion){
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		this.setTexto("Metodo Estático");
	}
	
	private String nombre;
	private String descripcion;
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre=nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getDatos(){
		return this.getNombre()+": "+this.getDescripcion();
	}
	
}
