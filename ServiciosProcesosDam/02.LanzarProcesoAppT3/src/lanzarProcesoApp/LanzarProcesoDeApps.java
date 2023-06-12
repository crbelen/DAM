/**
 * PROGRAMA QUE DA A ELEGIR PARA LANZAR UN PROCESO DE CIERTAS APPS MEDIANTE UN MENU
 */
package lanzarProcesoApp;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author crbel
 *
 */
public class LanzarProcesoDeApps {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int opciones = 0;
		String ruta = "";
		
		Scanner teclado = new Scanner (System.in);
		
		System.out.println("Elige la APP que quieres abrir:\n "
				+"1. Calculadora\n"
				+"2. LibreOffice writer\n"
				+"3. Bloc de Notas");
		
		opciones = teclado.nextInt();
		
		switch (opciones) {
			case 1:
				//indicamos la ruta del ejecutable de la calculadora
				ruta = "C:\\Windows\\WinSxS\\wow64_microsoft-windows-calc_31bf3856ad364e35_10.0.22621.1_none_15a8774142daea37\\calc.exe";
				break;
			case 2:
				ruta = "C:\\Program Files\\LibreOffice\\program\\swriter.exe";
				break;
			case 3:
				ruta = "C:\\Users\\crbel\\AppData\\Local\\Microsoft\\WindowsApps\\Microsoft.WindowsNotepad_8wekyb3d8bbwe\\notepad.exe";
				break;
		}
		
		//creamos el proceso
		ProcessBuilder abrirApp = new ProcessBuilder (ruta);
		try 
		{
			Process process = abrirApp.start();
			int retorno = process.waitFor();
			if (retorno == 0) {
				System.out.println("La ejecucion es correcta");
			}
		}	
		catch(IOException ex) 
		{
			System.err.println("Error: "+ ex.toString());
			System.exit(-1);
		}
		catch(InterruptedException ex) 
		{
			System.err.println("El proceso finalizo de forma incorrecta.");
			System.exit(-1);
			/*
			 * salir (0) : Indica terminación exitosa.
			 * salir (1) o salir (-1) o cualquier valor distinto de cero - indica terminación fallida .
			 */
		}
				
		
	}

}
