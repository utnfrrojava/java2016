package negocio;

import java.util.ArrayList;
import entidades.*;

public class CtrlABMCPersona {

	private ArrayList<Persona> personas;
	
	public CtrlABMCPersona(){
		personas = new ArrayList<Persona>();
	}
	
	public void add(Persona p){
		if(!personas.contains(p)){
			personas.add(p);
		}
	}
	
	public void update(Persona p){
		if(personas.contains(p)){
			Persona perEnc=this.getPersona(p);
			perEnc.setApellido(p.getApellido());
			perEnc.setNombre(p.getNombre());
			perEnc.setHabilitado(p.isHabilitado());
		}
		
	}
	
	public void delete(Persona p){
		personas.remove(p);
	}
	
	public Persona getPersona(Persona p){
		Persona perEnc=null;
		int i=personas.indexOf(p);
		if(i>=0){
			perEnc=personas.get(i);
		}
		return perEnc;
	}
}
