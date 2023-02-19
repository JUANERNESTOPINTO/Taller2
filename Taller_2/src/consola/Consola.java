package consola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.LoaderMenu;






public class Consola 

{
	private Map<String, Integer> elMenu;
	
	public void ejecutarAplicacion() throws FileNotFoundException, IOException
	{
		

		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				if (opcion_seleccionada == 1)
					ejecutarCargarMenu();
				else if (opcion_seleccionada == 2 )
					System.out.println("Opcion 2");
				else if (opcion_seleccionada == 3 )
					System.out.println("Opcion 3");
				else if (opcion_seleccionada == 4)
					System.out.println("Opcion 4");
				else if (opcion_seleccionada == 5 )
					System.out.println("Opcion 5");
				else if (opcion_seleccionada == 6 )
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}

	/**
	 * Muestra al usuario el menú con las opciones para que escoja la siguiente
	 * acción que quiere ejecutar.
	 */
	public void mostrarMenu()
	{
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Mostrar el menú");
		System.out.println("2. Iniciar un nuevo pedido");
		System.out.println("3. Agregar un elemento a un pedido");
		System.out.println("4. Cerrar un pedido y guardar la factura");
		System.out.println("5. Consultar la información de un pedido dado su id");
		System.out.println("6. Salir de la aplicacion");
	}
	
	private void ejecutarCargarMenu() throws FileNotFoundException, IOException
	{
		System.out.println("\n" + "Cargar el menu" + "\n");

		
		
			elMenu = LoaderMenu.cargarMenu("./data/menu.txt");
			for (java.util.Map.Entry<String, Integer> entry : elMenu.entrySet()) {
			    String key = entry.getKey();
			    Object value = entry.getValue();
			    System.out.printf(key + "-"+value+"\n");
			}
			
	
	}
	
	
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		Consola consola = new Consola();
		consola.ejecutarAplicacion();
	}
	
}
