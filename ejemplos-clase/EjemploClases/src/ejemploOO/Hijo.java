package ejemploOO;

public class Hijo extends Padre {
	
	public Hijo(){
		super("Default","Default");
	}
	
	public String getDescripcion(){
		return "Descripción: "+super.getDescripcion();
	}
	
	public String getDatos(){
		return "Nombre: "+this.getNombre()+"\n"+this.getDescripcion();
	}
	
	public int getCantCaracteresDescYNombre(){
		return getNombre().length()+super.getDescripcion().length();
	}

}
