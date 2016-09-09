package negocio;

import java.io.InvalidClassException;
import java.util.ArrayList;

import data.DataPersona;
import entidades.*;
import utils.ApplicationException;

public class CtrlABMCPersona {

	private ArrayList<Persona> personas;
	
	private data.DataPersona dataPer;
	
	
	public CtrlABMCPersona(){
		personas = new ArrayList<Persona>();
		dataPer=new DataPersona();
	}
	
	public void add(Persona p) throws ApplicationException {
		dataPer.add(p);
		
		/*if(!personas.contains(p)){
			personas.add(p);
		} else {
			throw new ApplicationException("La persona ya existe");
		}*/
	}
	
	public void update(Persona p) throws ApplicationException{
		/*if(personas.contains(p)){
			Persona perEnc=this.getPersona(p);
			perEnc.setApellido(p.getApellido());
			perEnc.setNombre(p.getNombre());
			perEnc.setHabilitado(p.isHabilitado());
			//int a=0;
			//int b=a/a;
		}else{
			throw new ApplicationException("La persona no existe");
		}*/
		
		dataPer.update(p);
	}
	
	public void delete(Persona p){
		dataPer.delete(p);;
	}
	
	public Persona getPersona(Persona p){
		/*Persona perEnc=null;
		int i=personas.indexOf(p);
		if(i>=0){
			perEnc=personas.get(i);
		}
		return perEnc;*/
		return dataPer.getByDni(p);
	}
}
