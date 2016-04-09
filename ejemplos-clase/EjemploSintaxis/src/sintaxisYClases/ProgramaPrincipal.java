package sintaxisYClases;

import java.util.Scanner;
import clases.*;

public class ProgramaPrincipal {

	public static void main(String[] args) {

		System.out.println("Ejemplos Sintaxis");

		System.out.println("Ingrese un nro:");
		Scanner en = new Scanner(System.in);
		int numero=en.nextInt();


		int sumat=EjemploForEIf.sumatoria(numero);
		en.close();

		System.out.println(sumat);

		if(EjemploForEIf.esPar(sumat)){
			System.out.println("Es PAR");
		}
		else {
			System.out.println("Es IMPAR");
		}

		int[] nrosAleat=EjemploForEIf.getValoresAleatorios();
		for (int i = 0; i < nrosAleat.length; i++) {
			System.out.println(nrosAleat[i]);
		}
		System.out.println("");
		for (int nro : nrosAleat) {
			System.out.println(nro);
		}

	}

}
