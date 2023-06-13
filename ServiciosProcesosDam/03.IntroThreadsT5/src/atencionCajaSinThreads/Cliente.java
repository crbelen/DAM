/**
 * 
 */
package atencionCajaSinThreads;

/**
 * @author crbel
 *
 */
public class Cliente {
	
	/**
	 * @param String es el nombre del cliente
	 * @param int[] es un array de enteros, representando el tiempo necesario para su atencion.
	 */
	private String nombre;
	private int[] carroCompra;
	
	//Constructor, getters y setters
	public Cliente(String nombre, int[] carroCompra) {
		this.nombre = nombre;
		this.carroCompra = carroCompra;
	}
	public String getNombre() {
		return nombre;
	}
	public int[] getCarroCompra() {
		return carroCompra;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setCarroCompra(int[] carroCompra) {
		this.carroCompra = carroCompra;
	}
}
