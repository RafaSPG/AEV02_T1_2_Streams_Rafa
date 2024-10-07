package es.florida.AD_AE02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class Controlador { 

	protected Vista vista = new Vista();
	protected Modelo modelo = new Modelo();
	
	public Controlador () {}
	
	public Controlador(Vista vista, Modelo modelo) {
		
		this.vista = vista;
		this.modelo = modelo;
		
		mostrarArchivo();

		
	}


	public void mostrarArchivo () {
				
		ArrayList<String> contenido = modelo.leerTexto();
				
		String resultado = String .join("\n", contenido);
		
		vista.getTextAreaOriginal().setText(resultado);
		
		vista.getBtnBuscar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (vista.getTextFieldBuscar().getText().isEmpty()) {
					
				}
			}
		});
		
	}
	
}
