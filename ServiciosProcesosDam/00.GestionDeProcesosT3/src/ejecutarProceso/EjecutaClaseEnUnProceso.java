/**
 * 
 */
package ejecutarProceso;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.Scanner;

/**
 * @author crbel
 *
 */
public class EjecutaClaseEnUnProceso {

	/**
	 * @param args los argumentos de la linea de comando
	 */
	public static void main(String[] args) {

		try (Scanner teclado = new Scanner(System.in)) {
			int numero1, numero2;
			
			System.out.println("Escribe un numero: ");
			numero1 = teclado.nextInt();
			
			System.out.println("Escribe otro numero: ");
			numero2 = teclado.nextInt();
			try 
			{
				int estado_ejecucion = ejecutarClaseProceso(Sumador.class, numero1, numero2);
				if (estado_ejecucion == 0) {
				System.out.println("Soy el proceso padre: Proceso ejecutado correctamente.");
				}
				else {
				System.out.println("Error ejecutando el proceso.");
				}
			}
			catch ( IOException | InterruptedException ex)
			{
				System.out.println("Error: "+ ex.toString());
				System.exit(-1);
			}
		}
	}
	/**
	 * 
	 * @param clase Clase a ejecutar
	 * @param n1 numero 1
	 * @param n2 numero 2
	 * @return Resultado de haber ejecutado el proceso
	 * @throws IOException Esta excepcion se lanzara si ocurre algun error en la ejecucion del proceso
	 * @throws InterruptedException Esta excepcion se lanzara si ocurre algun error en la ejecucion del proceso
	 * 
	 * La clase a ejecutar tiene que tener un metodo main que es el que se ejecutara
	 */
	
	
	private static int ejecutarClaseProceso(Class<Sumador> clase, int n1, int n2)throws IOException, InterruptedException {
		//Defino donde esta el Home de Java
		String javaHome = System.getProperty("java.home");
		
		//Defino donde esta el bin de Java
		String javaBin = javaHome
				+File.separator + "bin"
				+File.separator + "java";
		
		//Defino el path de Java
		String classpath = System.getProperty("java.class.path");
		
		//Obtengo el nombre canonico de la clase que se va a ejecutar
		String className = clase.getCanonicalName();
		
		//Creo el proceso a ejecutar
		//Los dos ultimos parametros son los parametros del metodo main de la clase
		ProcessBuilder builder = new ProcessBuilder(javaBin, "-cp", classpath, className, 
				String.valueOf(n1), String.valueOf(n2));
		
		//Indico cual va a ser el fichero de errores de salida del proceso
		builder.redirectError(Redirect.INHERIT);//salida por defecto
		//Indico cual va a ser el fichero de salida del proceso
		builder.redirectOutput(Redirect.INHERIT);//salida por defecto
		
		
		Process process = builder.start();
		//Espero a que se ejecute el proceso
		process.waitFor();
		return process.exitValue();
		
	}

}
