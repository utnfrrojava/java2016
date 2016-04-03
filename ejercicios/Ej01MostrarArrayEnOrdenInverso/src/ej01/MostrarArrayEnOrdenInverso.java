package ej01;

import java.util.Scanner;

public class MostrarArrayEnOrdenInverso {
	
	public static void main(String[] args) {
		
		int[] nros = new int[10];
		
		Scanner s=new Scanner(System.in);
		
		for (int i = 0; i < nros.length; i++) {
			System.out.println("Ingrese un numero:");
			nros[i]=Integer.parseInt(s.nextLine());
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		for (int i = 9; i >= 0; i--) {
			System.out.println(nros[i]);
		}
		
		s.close();
	}

}
