package entidades;

public class Vendedor extends Empleado{

	private double porcenComision;
	private double totalVtas;
	
	public double getPorcenComision() {
		return porcenComision;
	}
	public void setPorcenComision(double porcenComision) {
		this.porcenComision = porcenComision;
	}
	public double getTotalVtas() {
		return totalVtas;
	}
	public void setTotalVtas(double totalVtas) {
		this.totalVtas = totalVtas;
	}
	
	@Override
	public double getSueldo(){
		//sueldoBase + (porcenComision*totalVtas/100)
		return getSueldoBase()+(getPorcenComision()*getTotalVtas()/100);
	}
	
}
