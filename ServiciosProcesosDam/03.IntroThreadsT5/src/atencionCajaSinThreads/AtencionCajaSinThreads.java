/**
 * Simula la atencion de una clase Caja, a mi clase Cliente, sin usar Threads:
 * 
 * La clase Cliente lleva una serie de productos, cada uno de los cuales su atencion demora 
 * un numero de segundos.
 * 
 * La clase Caja atiende cada producto el numero de segundos especificado y lo muestra por pantalla.
 */
package atencionCajaSinThreads;

/**
 * @author crbel
 *
 */
public class AtencionCajaSinThreads {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		Cliente cliente1 = new Cliente("Paco1", new int[] {2, 2, 3, 1, 5, 2});
		Cliente cliente2 = new Cliente("Paco2", new int[] {1, 1, 2, 5, 3});
		
		Caja caja1 = new Caja("Caja 1");
		Caja caja2 = new Caja("Caja 2");
		
		//Tiempo inicial de referencia
		long initialTime = System.currentTimeMillis();
		
		
		caja1.procesarCompra(cliente1, initialTime);
		caja2.procesarCompra(cliente2, initialTime);
	}

}
