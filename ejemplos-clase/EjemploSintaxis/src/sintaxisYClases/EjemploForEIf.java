package sintaxisYClases;

public class EjemploForEIf {
	public static int sumatoria(int nro){
		int acu=0;
		
		for (int inc = 1; inc <= nro; inc++) {
			acu+=inc;
		}

		return acu;

	}

	public static boolean esPar(int nro){
		return (nro%2==0);
	}

	public static int[] getValoresAleatorios(){
		int[] nros= new int[5];

		for (int i = 0; i < nros.length; i++) {
			nros[i]=((Long)Math.round(Math.random()*10)).intValue();
		}
		return nros;
	}

}
