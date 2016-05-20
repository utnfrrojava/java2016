package ej02_2;

import java.util.ArrayList;
import java.util.Scanner;

public class RegistrarNumerosMayoresArray {

	public static void main(String[] args) {
		
		//int[] nros = new int[5];
		ArrayList<Integer> nros =new ArrayList<Integer>();
		//int cantMayores=0;
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Ingrese el número base");
		int base = Integer.parseInt(s.nextLine());
		
		//for (int i = 0; i < nros.length; i++) {
		String rta="";
		do{
			System.out.println("Ingrese un número");
			int num = Integer.parseInt(s.nextLine());
			if (num > base) {
				//nro[cantMayores]=num;
				nros.add(num);
				//cantMayores++;
			}
			
			System.out.println("¿Desea continuar? (S/N)");
			rta=s.nextLine();
		} while(!rta.equalsIgnoreCase("N"));
		
		System.out.println("");
		System.out.print("Nros mayores: ");
		
		//for (int i = 0; i < cantMayores; i++) {
		for (int i = 0; i < nros.size(); i++) {
			//System.out.print(nros[i]+" ");
			System.out.print(nros.get(i)+" ");
		}
		
		s.close();
	}
	
}
