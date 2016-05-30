import java.util.ArrayList;
import java.util.Scanner;

public class Ppal {

	public static void main(String[] args) {

		// Definir una nuevo ArrayList de tipo String e inicializarlo
		ArrayList<String> colStrings = new ArrayList<String>();
		
		Scanner s = new Scanner(System.in);
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Ingrese mensaje "+i);
			String str=s.nextLine();
			
			//el método add es para agregar un nuevo elemento al final del ArrayList
			colStrings.add(str);
		}
		
		//add también sirve para insertar un nuevo elemento en la posición 3 (4to lugar ya que empieza en 0)
		colStrings.add(3,"Elemento insertado");
		
		//remove quita un elemento del ArrayList
		//los siguientes elementos se "mueven" un lugar hacia arriba 
		colStrings.remove(1); //elimina el elemento en el segundo lugar
		
		System.out.println("\n\n#####################");
		System.out.print("Tercer elemento: ");
		System.out.println(colStrings.get(2)); //muestra el elemento del tercer lugar
		
		s.close();
		
		//size() es el método que indica el tamaño del ArrayList
		System.out.println("\n#####################");
		System.out.print("Tamaño del ArrayList: ");
		System.out.println(colStrings.size());
		
		System.out.println("\n#####################");
		System.out.print("¿ArrayList contiene \"Elemento insertado\"?: ");
		System.out.println(colStrings.contains("Elemento insertado"));
		
		System.out.println("\n#####################");
		System.out.println("Lista de elementos:");
		for (int i = 0; i < colStrings.size(); i++) {
			System.out.println(colStrings.get(i));
		}
		/* aquí se pudo observar que el segundo elemento fue elimindo y
		 * "Elemento insertado" fue insertado en el 4 lugar pero al eliminar el
		 * segundo elemento del ArrayList se movió al tercer lugar
		 * usamos el método size para conocer el tamaño del ArrayList y 
		 * get para recuperar el mismo elemento 
		 */
		
		//Así puede convertirse un ArrayList de un tipo puntual a un array de ese mismo tipo
		String[] algoString = colStrings.toArray(new String[colStrings.size()]);
		
		
		
		// Ahora definimos un ArrayList de una clase creada por nosotros
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		
		//Agregamos 3 elementos
		alumnos.add(new Alumno("Juan"));
		alumnos.add(new Alumno("Pedro"));
		alumnos.add(new Alumno("Andrés"));
		
		/* para determinar si un elemento se encuentra dentro del ArrayList
		 * usamos el método contains que internamente comprará los elementos
		 * con el pasado por parámetro usando el método equals
		 * 
		 * Para que el nuevo Alumno Juan resulte igual al que ingresamos arriba
		 * fue necesario sobreescribir el método equals de la clase alumno,
		 * para comprobarlo puede comentar dicho método
		 */
		System.out.println("#####################");
		System.out.println("¿Contiene al \"new Alumno(\"Juan\")\"?");
		System.out.println(alumnos.contains(new Alumno("Juan")));
		
	}

}
