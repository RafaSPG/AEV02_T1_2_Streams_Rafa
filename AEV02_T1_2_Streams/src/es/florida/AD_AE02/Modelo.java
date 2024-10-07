package es.florida.AD_AE02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Modelo {
	
	
	
	public Modelo () {
				
	}
	
	File archivoF = new File ("AE02_T1_2_Streams_Groucho.txt");
	
	public ArrayList<String> leerTexto() {
		
		
		ArrayList<String> contenido = new ArrayList<>();
		try {
			FileReader fr = new FileReader(archivoF);
			BufferedReader br = new BufferedReader(fr);
			
			String linea = br.readLine();
			
			while (linea != null) {
				
				contenido.add(linea);
				linea = br.readLine();
				
			}	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return contenido;
			
	}

	public int buscarPalabra(String palabra) {
		
		int contador = 0;
		String[] comprobar;
		
		try {
			FileReader fr = new FileReader(archivoF);
			BufferedReader br = new BufferedReader(fr);
			
			String linea = br.readLine();
			while (linea != null) {
				
				comprobar = linea.split(" ");
				for (int i = 0; i<comprobar.length;i++) {
					if (comprobar[i].equals(palabra)) {
						contador++;
					}
				}
				
				linea = br.readLine();
				
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return contador;
		
		
		
	}

	public ArrayList<String> remplazarPalabra (String palabra, String palabra2) {
		
		int buscarPalabra = buscarPalabra(palabra);
		
        ArrayList<String> lineas = new ArrayList<>();

		
		if (buscarPalabra > 0) {
			
			
			try {
	            BufferedReader reader = new BufferedReader(new FileReader(archivoF));
	            String linea;
	            while ((linea = reader.readLine()) != null) {
	                lineas.add(linea.replace(palabra, palabra2));
	            }
	            reader.close();
	            
	            BufferedWriter bw = new BufferedWriter(new FileWriter(archivoF));
	            for (String lineaModificada : lineas) {
	            	bw.write(lineaModificada);
	            	bw.newLine();
	            }
	            bw.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	            return null;
	        }
		
	}
        return lineas;
	}
}
