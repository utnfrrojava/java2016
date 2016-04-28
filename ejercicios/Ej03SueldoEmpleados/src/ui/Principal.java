package ui;

import java.util.Scanner;
import entidades.*;

public class Principal {

	private static Scanner scan;
	
	public static void main(String[] args) {
		scan= new Scanner(System.in);
		Empleado[] emps = new Empleado[20];
		int cantEmp=0;
		
		String continuar="";
		
		do{
			System.out.println("¿Desea registrar un vendedor o un administrativo? (V/A)");
			String rta=scan.nextLine();
			if(rta.equals("A")){
				Administrativo adm=new Administrativo();
				cargaDatosAdministrativo(adm);
				emps[cantEmp]=adm;
			} else{
				Vendedor ven=new Vendedor();
				cargaDatosVendedor(ven);
				emps[cantEmp]=ven;
			}
			
			
			cantEmp++;
			
			System.out.println("¿Desea cargar un nuevo empleado? (S/N)");
			continuar=scan.nextLine();
		} while(continuar.equals("S"));
		
		scan.close();
		
		muestraEmpleados(emps, cantEmp);
	}
	
	private static void muestraEmpleados(Empleado[] emps, int cant) {
		for (int i = 0; i < cant; i++) {
			System.out.println("DNI: "+emps[i].getDni());
			System.out.println("Nombre: "+emps[i].getNombre());
			System.out.println("Apellido: "+emps[i].getApellido());
			System.out.println("Sueldo: "+emps[i].getSueldo());
			System.out.println("\n");
		}
		
	}

	private static void cargaDatosVendedor(Vendedor ven) {
		cargaDatosEmpleado(ven);
		
		System.out.print("Comisión (%): ");
		ven.setPorcenComision(Double.parseDouble(scan.nextLine()));
		
		System.out.print("Total de Ventas: ");
		ven.setTotalVtas(Double.parseDouble(scan.nextLine()));
		
	}

	private static void cargaDatosAdministrativo(Administrativo adm) {
		cargaDatosEmpleado(adm);
			
		System.out.print("Hs extra: ");
		adm.setHsExtra(Integer.parseInt(scan.nextLine()));
		
		System.out.print("Hs del mes: ");
		adm.setHsMes(Integer.parseInt(scan.nextLine()));		
	}

	public static void cargaDatosEmpleado(Empleado emp){
		System.out.print("DNI: ");
		emp.setDni(scan.nextLine());
		
		System.out.print("Nombre: ");
		emp.setNombre(scan.nextLine());
		
		System.out.print("Apellido: ");
		emp.setApellido(scan.nextLine());
		
		System.out.print("Email: ");
		emp.setEmail(scan.nextLine());
		
		System.out.print("Sueldo Base: ");
		emp.setSueldoBase(Double.parseDouble(scan.nextLine()));
		
	}

}
