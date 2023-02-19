package controller;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class LoaderMenu {
	
	public static Map<String, List<String>> cargarCombos(String nombreArchivo) throws FileNotFoundException, IOException{
		Map<String, List<String>> combos = new HashMap<>();
		
		BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
		String linea;
		
		linea = br.readLine();
		while (linea != null) {
			String[] partes = linea.split(";");
			String nombreCombo = partes[0];
			List<String> elementosCombo = new ArrayList<>();
			elementosCombo.add(partes[1]); // descuento
			elementosCombo.add(partes[2]); // hamburguesa
			elementosCombo.add(partes[3]); // papas
			elementosCombo.add(partes[4]); // bebida
			
			combos.put(nombreCombo, elementosCombo);
			
			linea = br.readLine(); // Leer la siguiente línea
			
		}
		br.close();
		
		return combos;
	}
	
	public static Map<String, Integer> cargarIngredientes(String nombreArchivo) throws FileNotFoundException, IOException{
		Map<String, Integer> ingredientes = new HashMap<>();
		
		BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
		String linea;
		
		linea = br.readLine();
		while (linea != null) {
			String[] partes = linea.split(";");
			String nombreIngredeinte = partes[0];
			Integer precioIngrediente = Integer.parseInt(partes[1]);
			
			ingredientes.put(nombreIngredeinte, precioIngrediente);
			
			linea = br.readLine();
		}
		br.close();
		return ingredientes;
	}
	
	public static Map<String, Integer> cargarMenu(String nombreArchivo) throws FileNotFoundException, IOException{
		Map<String, Integer> menu = new HashMap<>();
		
		BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
		String linea;
		
		linea = br.readLine();
		while (linea != null) {
			String[] partes = linea.split(";");
			String nombreProducto = partes[0];
			Integer precioProducto = Integer.parseInt(partes[1]);
			
			menu.put(nombreProducto, precioProducto);
			
			linea = br.readLine();
		}
		br.close();
		return menu;
	}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Map<String, Integer> menu = cargarMenu("./data/menu.txt");
		System.out.println("Menu\n");
		for (Entry<String, Integer> entry : menu.entrySet()) {
		    String key = entry.getKey();
		    Object value = entry.getValue();
		    System.out.printf(key + "-"+value+"\n");
		}

	}
}