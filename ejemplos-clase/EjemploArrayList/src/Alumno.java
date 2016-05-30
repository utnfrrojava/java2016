

public class Alumno {
	String nombre;
	
	public Alumno(String nombre){
		setNombre(nombre);
	
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
	
	@Override
	public boolean equals(Object a){
		/*if (a instanceof Alumno){
			return this.getNombre().equals(((Alumno)a).getNombre());
		}else{
			return false;
		}*/
		return (a instanceof Alumno) && this.getNombre().equals(((Alumno)a).getNombre());
	}
	
	
}
