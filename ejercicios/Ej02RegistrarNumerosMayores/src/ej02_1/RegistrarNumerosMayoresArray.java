package ej02_1;

import java.util.Scanner;

public class RegistrarNumerosMayoresArray {

	public static void main(String[] args) {
		
		int[] nros = new int[5];
		int cantMayores=0;
		Scanner s = new Scanner(System.in);
		
		System.out.println("Ingrese el número base");
		int base = Integer.parseInt(s.nextLine());
		
		for (int i = 0; i < nros.length; i++) {
			System.out.println("Ingrese un número");
			int num = Integer.parseInt(s.nextLine());
			if (num > base) {
				nros[i] = num;
				cantMayores++;
			}
		}
		
		System.out.println("");
		System.out.print("Nros mayores: ");
		
		for (int i = 0; i < cantMayores; i++) {
			System.out.print(nros[i]+" ");
		}
		
		s.close();
	}
	
}
