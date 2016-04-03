package ejemplos;

import java.util.Scanner;

public class LeerPorTeclado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		System.out.println("Ingrese dato");
		String dato = s.nextLine();
		
		System.out.println("El dato ingresado es: "+dato);
		
		s.close();
		
	}

}
