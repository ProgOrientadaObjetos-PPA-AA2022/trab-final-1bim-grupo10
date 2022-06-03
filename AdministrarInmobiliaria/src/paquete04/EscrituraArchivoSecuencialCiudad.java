/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete04;

/**
 *
 * @author Joe
 */
import java.io.*;
import java.util.*;
public class EscrituraArchivoSecuencialCiudad {
    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Ciudad registro;
    private ArrayList<Ciudad> ciudades;
    public EscrituraArchivoSecuencialCiudad(String n) {
        nombreArchivo = n;
        establecerCiudades();
        
        try {
            
            salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            if (ciudades.size() > 0) {
                for (int i = 0; i < ciudades.size(); i++) {
                    establecerRegistro(ciudades.get(i));
                    establecerSalida();
                }
            }
            
        } catch (IOException IOexception) {
            System.out.println("Error al abrir el archivo");
        }
    }
    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }
    
    public void establecerSalida() {
        try {
            salida.writeObject(registro);
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo");
        }
    }
    
    public void establecerRegistro(Ciudad n) {
        registro = n;
    }
    
    public void establecerCiudades() {
        LecturaArchivoSecuencialCiudad c = 
                new LecturaArchivoSecuencialCiudad(nombreArchivo);
        c.establecerCiudades();
        ciudades = c.obtenerCiudades();
    }
    
    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }
    
    public ObjectOutputStream obtenerSalida() {
        return salida;
    }
    
    public ArrayList<Ciudad> obtenerCiudades() {
        return ciudades;
    }
    
    public void cerrarArchivo() {
        try {
            if (salida != null) {
                salida.close();
            }
        } 
        catch (IOException ioException) {
            System.out.println("Error al cerrar el archivo");
        } 
    } 
}
