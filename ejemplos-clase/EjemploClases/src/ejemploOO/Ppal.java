package ejemploOO;

public class Ppal {

	public static void mainOrig(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("p");
		Padre p=new Padre("Papá", "Es un objeto padre");
		
		System.out.println(p.getDatos());
		//System.out.println(p.getCantCaracteresDescYNombre());
		/*
		 * no funciona porque el método getCantCaracteresDescYNombre
		 * está definido en Hijo y no en Padre
		 */
		System.out.println(Padre.getTexto());
		
		
		System.out.println("\n\nh");
		Hijo h=new Hijo();
		h.setNombre("Hijo");
		h.setDescripcion("Es un objeto hijo");
		
		System.out.println(h.getDatos());
		System.out.println(h.getCantCaracteresDescYNombre());
		System.out.println(Hijo.getTexto());
		
		
		System.out.println("\n\nh2");
		Padre h2=new Hijo();
		h2.setNombre("Hijo2");
		h2.setDescripcion("Es un objeto hijo en una variable padre");
		
		System.out.println(h2.getDatos());
		//System.out.println(h2.getCantCaracteresDescYNombre());
		/*
		 * no funciona porque el método getCantCaracteresDescYNombre
		 * está definido en Hijo y no en Padre y la variable h2 es de tipo Padre
		 */
		
		System.out.println(((Hijo)h2).getCantCaracteresDescYNombre());
		
		System.out.println("\n\nh3");
		
		Hijo h3 = new Hijo();
		System.out.println(h3.getDatos());
		
	}

}
