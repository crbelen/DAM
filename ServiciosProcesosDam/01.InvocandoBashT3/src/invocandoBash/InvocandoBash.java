/**
 * Realiza un programa que pida una ruta al usuario y muestre el 
 * resultado de ejecutar el comando del CMD 'dir/A'de ese directorio
 * HAY QUE CREAR UN PROCESO CON CMD
 * ej: para ver el contenido de la carpeta Download habra que poner -> dir/A Download
 * 
 */
package invocandoBash;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author crbel
 *
 */
public class InvocandoBash {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String ruta;
		Scanner teclado = new Scanner (System.in);
		
		System.out.println("Introduce la ruta a la que quieres hacer un 'dir': ");
		ruta = teclado.nextLine();
		
		try {
			//creo el proceso
			ProcessBuilder builder_dir = new ProcessBuilder ("CMD");
			Process proceso_dir = builder_dir.start();
			
			//indico la salida del proceso que ejecuta la consola de comandos
			final Scanner in = new Scanner(proceso_dir.getInputStream());
			new Thread(){
				@Override
				public void run() {
					while(in.hasNextLine()) {
						System.out.println(in.nextLine());
					}
				}
				
			}.start();
		
			//obtengo la salida del proceso
			PrintWriter salida = new PrintWriter(proceso_dir.getOutputStream());
			
			//hacemos la llamada
			salida.println("dir/A " + ruta);
			salida.flush();
			
			//cerramos flujo
			salida.close();
		}catch(IOException ex) {
			System.out.println("Excepcion de E/S" + ex.toString());
			
		}
		
	}

}
