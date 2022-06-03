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

public class Propietario implements Serializable {

    String nPropietario;
    String aPropietario;
    String cPropietario;

    public Propietario(String n, String a, String i) {
        nPropietario = n;
        aPropietario = a;
        cPropietario = i;
    }

    public void establecerNombrePropietario(String n) {
        nPropietario = n;
    }

    public void establecerApellidoPropietario(String n) {
        aPropietario = n;
    }

    public void establecerCedulaPropietario(String n) {
        cPropietario = n;
    }

    public String obtenerNombrePropietario() {
        return nPropietario;
    }

    public String obtenerApellidoPropietario() {
        return aPropietario;
    }

    public String obtenerCedulaPropietario() {
        return cPropietario;
    }

    @Override
    public String toString() {
        String cadenaFinal = String.format("%s - %s - %s\n",
                obtenerNombrePropietario(),
                obtenerApellidoPropietario(), obtenerCedulaPropietario());
        return cadenaFinal;
    }
}
