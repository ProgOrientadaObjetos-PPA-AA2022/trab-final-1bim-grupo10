/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete02;

/**
 *
 * @author reroes
 */
import java.io.Serializable;

public class Propietario implements Serializable{
    String nombre;
    String apellido;
    String identificacion;
    public Propietario(String n,String a,String i){
        nombre = n;
        apellido = a;
        identificacion = i;
    }
    public void establecerNombre(String n){
        nombre = n;
    }
    public void establecerApellido(String n){
        apellido = n;
    }
    public void establecerCedula(String n){
        identificacion = n;
    }
    public String obtenerNombre(){
        return nombre;
    }
    public String obtenerApellido(){
        return apellido;
    }
    public String obtenerCedula(){
        return identificacion;
    }
    @Override
    public String toString(){
        String valor = String.format("%s - %s - %s\n"
                , obtenerNombre(), 
                 obtenerApellido(), obtenerCedula());
        return valor;
    }
}
