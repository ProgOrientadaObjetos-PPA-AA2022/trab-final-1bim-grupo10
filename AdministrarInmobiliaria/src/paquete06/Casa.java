/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete06;

/**
 *
 * @author reroes
 */
import java.io.Serializable;
import paquete02.Propietario;
import paquete03.Barrio;
import paquete04.Ciudad;
import paquete05.Constructora;

public class Casa implements Serializable {

    private Propietario propietario;
    private double precioMetroCuadrado;
    private double metrosCuadrados;
    private double costoFinal;
    private Barrio barrio;
    private Ciudad ciudad;
    private int numeroCuartos;
    private Constructora constructora;

    public Casa(double pmc, double mc, int nc, Propietario p, Barrio b, Ciudad c, Constructora co) {
        precioMetroCuadrado = pmc;
        metrosCuadrados = mc;
        numeroCuartos = nc;
        propietario = p;
        barrio = b;
        ciudad = c;
        constructora = co;
    }

    public void establecerPropietario(Propietario p) {
        propietario = p;
    }

    public void establecerPrecioMetroCuadrado(double n) {
        precioMetroCuadrado = n;
    }

    public void establecerMetrosCuadrados(double n) {
        metrosCuadrados = n;
    }

    public void establecerCostoFinal() {
        costoFinal = precioMetroCuadrado * metrosCuadrados;
    }

    public void establecerBarrio(Barrio b) {
        barrio = b;
    }

    public void establecerCiudad(Ciudad c) {
        ciudad = c;
    }

    public void establecerNumeroCuartos(int n) {
        numeroCuartos = n;
    }

    public void establecerConstructora(Constructora n) {
        constructora = n;
    }

    public Propietario obtenerPropietario() {
        return propietario;
    }

    public double obtenerPrecioMetroCuadrado() {
        return precioMetroCuadrado;

    }

    public double obtenerNumeroMetrosCuadrados() {
        return metrosCuadrados;
    }

    public double obtenerCostoFinal() {
        return costoFinal;
    }

    public Barrio obtenerBarrio() {
        return barrio;
    }

    public Ciudad obtenerCiudad() {
        return ciudad;
    }

    public int obtenerNumeroCuartos() {
        return numeroCuartos;
    }

    public Constructora obtenerConstructoras() {
        return constructora;
    }

    @Override
    public String toString() {

        String cadena = String.format("Informacion casa:\n"
                + "\nPROPIETARIO\n"
                + "Nombres: %s Apellidos: %s Identificacion: %s\n"
                + "Precio metro cuadrado: %.2f Numero metros Cuadrados: %.2f Numero Cuartos: %d Costo final: %.2f\n"
                + "\nBARRIO\n"
                + "Nombre barrio: %s Referencia: %s\n"
                + "\nCIUDAD\n"
                + "Nombre Ciudad: %s Nombre Provincia: %s \n"
                + "\nCONSTRUCTORA\n"
                + "Nombre Constructora: %s Id Empresa: %s\n",
                propietario.obtenerNombrePropietario(),
                propietario.obtenerApellidoPropietario(),
                propietario.obtenerCedulaPropietario(),
                precioMetroCuadrado, metrosCuadrados, numeroCuartos, costoFinal,
                barrio.obtenerNombreBarrio(),
                barrio.obtenerReferencia(),
                ciudad.obtenerNombreCiudad(),
                ciudad.obtenerNombreProvincia(),
                constructora.obtenerNombreConstructora(),
                constructora.obtenerId());
        return cadena;
    }
}
