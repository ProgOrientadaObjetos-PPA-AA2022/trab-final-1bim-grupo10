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
    String nBarrio;
    String rBarrio;
    public Barrio(String nB,String rB){
        nBarrio = nB;
        rBarrio = rB;
    }
    public void establecerNombreBarrio(String nB){
        nBarrio = nB;
    }
    public void establecerReferencia(String rB){
        rBarrio = rB;
    }
    public String obtenerNombreBarrio(){
        return nBarrio;
    }
    public String obtenerReferencia(){
        return rBarrio;
    }
    @Override
    public String toString(){
        String valor = String.format("%s - %s\n"
                , obtenerNombreBarrio(), 
                 obtenerReferencia());
        return valor;
    }
}
