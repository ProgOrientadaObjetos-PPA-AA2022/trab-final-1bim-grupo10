/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete06;

/**
 *
 * @author Joe
 */
import java.io.*;
import java.util.*;
public class EscrituraArchivoSecuencialDepartamento {
    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Departamento registro;
    private ArrayList<Departamento> departamentos;
    public EscrituraArchivoSecuencialDepartamento(String n) {
        nombreArchivo = n;
        establecerDepartamentos();
        
        try {
            
            salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            if (departamentos.size() > 0) {
                for (int i = 0; i < departamentos.size(); i++) {
                    establecerRegistro(departamentos.get(i));
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
    
    public void establecerRegistro(Departamento n) {
        registro = n;
    }
    
    public void establecerDepartamentos() {
        EscrituraArchivoSecuencialDepartamento d = 
                new EscrituraArchivoSecuencialDepartamento(nombreArchivo);
        d.establecerDepartamentos();
        departamentos = d.obtenerDepartamentos();
    }
    
    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }
    
    public ObjectOutputStream obtenerSalida() {
        return salida;
    }
    
    public ArrayList<Departamento> obtenerDepartamentos() {
        return departamentos;
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
