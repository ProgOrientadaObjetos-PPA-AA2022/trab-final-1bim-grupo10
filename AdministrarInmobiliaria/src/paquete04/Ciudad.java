/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete04;

/**
 *
 * @author reroes
 */
import java.io.Serializable;
public class Ciudad implements Serializable{
    String nombreCiudad;
    String nombreProvincia;
    public Ciudad(String nc,String np){
        nombreCiudad = nc;
        nombreProvincia = np;
    }
    public void establecerNombreCiudad(String n){
        nombreCiudad = n;
    }
    public void establecerNombreProvincia(String n){
        nombreProvincia = n;
    }
    public String obtenerNombreCiudad(){
        return nombreCiudad;
    }
    public String obtenerNombreProvincia(){
        return nombreProvincia;
    }
    @Override
    public String toString(){
        String valor = String.format("%s - %s\n"
                , obtenerNombreCiudad(), 
                 obtenerNombreProvincia());
        return valor;
    }
}
