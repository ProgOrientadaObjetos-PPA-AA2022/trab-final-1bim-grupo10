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
public class ArchivoLecturaDepartamento {
    private ObjectInputStream entrada;
    private ArrayList<Departamento> departamentos;
    private String nombreArchivo;
    
    
    public ArchivoLecturaDepartamento(String n) {
        nombreArchivo = n;
        File f = new File(nombreArchivo);
        if (f.exists()) {
            try {
                entrada = new ObjectInputStream(
                        new FileInputStream(nombreArchivo));
            } catch (IOException ioException) {
                System.out.println("Error al abrir el archivo" + ioException);
            } 
        }
    }
    
    public void establecerDepartamento() {
        departamentos = new ArrayList<>();
        File f = new File(nombreArchivo);
        if (f.exists()) {
            while (true) {
                
                try {
                    Departamento registro = (Departamento) entrada.readObject();
                    departamentos.add(registro);
                } catch (EOFException endOfFileException) {
                    break;
                } catch (IOException ex) {
                    System.out.println("Error al leer el archivo");
                } catch (ClassNotFoundException ex) {
                    System.out.println("No se pudo crear el objeto" + ex);
                }
            }
        }

    }
    
    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }
    
    public ArrayList<Departamento> obtenerDepartamentos() {
        return departamentos;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }
    
    @Override
    public String toString() {
        String cadena = "Departamentos:\n";
        for (int i = 0; i < departamentos.size(); i++) {
            cadena = String.format("%s(%d) Informacion del Departamento\n"
                    + "PROPIETARIO----------------------------------------------\n"
                    + "\tNombres: %s\n\tApellidos: %s\n\tCedula: %s\n"
                    + "ESPECIFICACIONES-----------------------------------------\n"
                    + "\tEdificio: %s\n\tUbicación del Edificio: %s\n"
                    + "\tPrecio por metro cuadrado: %.2f\n\tNumero de metros cuadrados: %.2f\n"
                    + "\tValor Alícuota Mensual: %.2f\n\tCosto final: %.2f\n"
                    + "BARRIO---------------------------------------------------\n"
                    + "\tBarrio: %s\n\tReferencia%s\n"
                    + "CIUDAD---------------------------------------------------\n"
                    + "\tCiudad: %s\n\tNombre Provincia: %s\n"
                    + "CONSTRUCTORA---------------------------------------------\n"
                    + "\tNombre Constructora: %s\n\tID: %s\n"
                    + "----------------------------------------------------------\n", cadena, (i + 1),
                    departamentos.get(i).obtenerPropietario().obtenerNombre(), departamentos.get(i).obtenerPropietario().obtenerApellido(), departamentos.get(i).obtenerPropietario().obtenerCedula(),
                    departamentos.get(i).obtenerNombreEdificio(), departamentos.get(i).obtenerUbicacionEdificio(),
                    departamentos.get(i).obtenerPrecioMetroCuadrado(), departamentos.get(i).obtenerNumeroMetrosCuadrados(),
                    departamentos.get(i).obtenerAlicuotaMensual(), departamentos.get(i).obtenerValorFinal(),
                    departamentos.get(i).obtenerBarrio().obtenerNombreBarrio(), departamentos.get(i).obtenerBarrio().obtenerReferencia(),
                    departamentos.get(i).obtenerCiudad().obtenerNombreCiudad(), departamentos.get(i).obtenerCiudad().obtenerNombreProvincia(),
                    departamentos.get(i).obtenerConstructora().obtenerNombreConstructora(), departamentos.get(i).obtenerConstructora().obtenerId());
        }

        return cadena;
    }
    
    public void cerrarArchivo() {
        try {
            if (entrada != null) {
                entrada.close();
            }
        } catch (IOException ioException) {
            System.out.println("Error al cerrar el archivo");
        }
    }
}
