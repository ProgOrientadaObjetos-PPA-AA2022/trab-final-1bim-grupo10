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

public class ArchivoLecturaCasa {

    private ObjectInputStream entrada;
    private ArrayList<Casa> casas;
    private String nombreArchivo;

    public ArchivoLecturaCasa(String n) {
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

    public void establecerCasa() {
        casas = new ArrayList<>();
        File f = new File(nombreArchivo);
        if (f.exists()) {
            while (true) {

                try {
                    Casa registro = (Casa) entrada.readObject();
                    casas.add(registro);
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

    public ArrayList<Casa> obtenerCasas() {
        return casas;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "Casas\n";
        for (int i = 0; i < casas.size(); i++) {
            Casa ca = casas.get(i);
            cadena = String.format("%s\t\t----DATOS DE LA CASA Nº %d----\n"
                    + "PROPIETARIO----------------------------------------------\n"
                    + "\tNombres: %s\n\tApellidos: %s \n\tCedula: %s\n"
                    + "DATOS----------------------------------------------------\n"
                    + "\tPrecio metro cuadrado: %.2f\n\tNumero metros Cuadrados: %.2f\n\tNumero Cuartos: %d\n\tCosto final: %.2f\n"
                    + "BARRIO---------------------------------------------------\n"
                    + "\tNombre barrio: %s\n\tReferencia: %s\n"
                    + "CIUDAD---------------------------------------------------\n"
                    + "\tNombre Ciudad: %s\n\tNombre Provincia: %s \n"
                    + "CONSTRUCTORA---------------------------------------------\n"
                    + "\tNombre Constructora: %s\n\tIdEmpresa: %s\n"
                    + "----------------------------------------------------------\n",
                    cadena, (i + 1),
                    casas.get(i).obtenerPropietario().obtenerNombre(), casas.get(i).obtenerPropietario().obtenerApellido(), casas.get(i).obtenerPropietario().obtenerCedula(),
                    casas.get(i).obtenerPrecioMetroCuadrado(), casas.get(i).obtenerNumeroMetrosCuadrados(), casas.get(i).obtenerNumeroCuartos(), casas.get(i).obtenerCostoFinal(),
                    casas.get(i).obtenerBarrio().obtenerNombreBarrio(), casas.get(i).obtenerBarrio().obtenerReferencia(),
                    casas.get(i).obtenerCiudad().obtenerNombreCiudad(), casas.get(i).obtenerCiudad().obtenerNombreProvincia(),
                    casas.get(i).obtenerConstructoras().obtenerNombreConstructora(), casas.get(i).obtenerConstructoras().obtenerId());
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
