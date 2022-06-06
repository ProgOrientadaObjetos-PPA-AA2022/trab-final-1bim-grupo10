/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete03;

/**
 *
 * @author reroes
 */
import java.io.Serializable;
public class Barrio implements Serializable{
    String nombreBarrio;
    String referencia;
    public Barrio(String nb,String r){
        nombreBarrio = nb;
        referencia = r;
    }
    public void establecerNombreBarrio(String n){
        nombreBarrio = n;
    }
    public void establecerReferencia(String n){
        referencia = n;
    }
    public String obtenerNombreBarrio(){
        return nombreBarrio;
    }
    public String obtenerReferencia(){
        return referencia;
    }
    @Override
    public String toString(){
        String valor = String.format("%s - %s\n"
                , obtenerNombreBarrio(), 
                 obtenerReferencia());
        return valor;
    }
}