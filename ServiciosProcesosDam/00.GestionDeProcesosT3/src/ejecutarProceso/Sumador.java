package ejecutarProceso;

public class Sumador {

	/**
	 * Este metodo suma todos los numeros que hay  en un intervalo
	 * @param numero1 Inicio del intervalo
	 * @param numero2 fin del intervalo
	 * @return Suma de todos los numeros del intervalo definido
	 */
	public static int sumar(int numero1, int numero2) {
		
		int suma = 0;
		
		for(int i = numero1; i<= numero2; i++) {
			suma += i;
		}
		return suma;
	}
	//creamos un nuevo metodo main que llama al metodo (sumar) que queremos ejecutar
	public static void main(String[] args) {

		//Obtenemos los parametros pasados al crear el proceso
		int numero1 = Integer.valueOf(args[0]);
		int numero2 = Integer.valueOf(args[1]);
		
		int suma = sumar(numero1, numero2);
		System.out.println("El resultado de la suma de los numeros "+ numero1 + " y "+ numero2 + " es: " + suma);
		
	}

}
