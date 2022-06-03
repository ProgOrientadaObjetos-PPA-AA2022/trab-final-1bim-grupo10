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
public class Departamento implements Serializable {
    private Propietario propietario;
    private double precioMetroCuadrado;
    private double metrosCuadrados;
    private double alicuotaMensual;
    private double vFinal;
    private Barrio barrio;
    private Ciudad ciudad;
    private String nEdificio;
    private String uEdificio;
    private Constructora constructora;
    public Departamento(Propietario p, double pmc,double mc,double am, Barrio b,Ciudad c,String ne,String ue,Constructora co){
        propietario = p;
        precioMetroCuadrado = pmc;
        metrosCuadrados = mc;
        alicuotaMensual = am;
        barrio = b;
        ciudad = c;
        nEdificio = ne;
        uEdificio = ue;
        constructora = co;
    }
    public void establecerPropietario(Propietario n){
        propietario = n;
    }
    
    public void establecerPrecioMetroCuadrado(double n){
        precioMetroCuadrado = n;
    }
    
    public void establecerMetrosCuadrados(double n){
        metrosCuadrados = n;
    }
    
    public void establecerAlicuotaMensual(double n){
        alicuotaMensual = n;
    }
    
    public void establecerValorFinal(){
        vFinal = ((metrosCuadrados * precioMetroCuadrado) 
                + (alicuotaMensual * 12));
    }
    
    public void establecerBarrio(Barrio n){
        barrio = n;
    }
    
    public void establecerCuidad(Ciudad n){
        ciudad = n;
    }
    
    public void establecerNombreEdificios(String n){
        nEdificio = n;
    }
    
    public void establecerUbicacionEdificio(String n){
        uEdificio = n;
    }
    
    public void establecerConstructora(Constructora n){
        constructora = n;
    }
    
    public Propietario obtenerPropietario(){
        return propietario;
    }
    
    public double obtenerPrecioMetroCuadrado(){
        return precioMetroCuadrado;
    }
    
    public double obtenerNumeroMetrosCuadrados(){
        return metrosCuadrados;
    }
    
    public double obtenerAlicuotaMensual(){
        return alicuotaMensual;
    }
    
    public double obtenerValorFinal(){
        return vFinal;
    }
    
    public Barrio obtenerBarrio(){
        return barrio;
    }
    
    public Ciudad obtenerCiudad(){
        return ciudad;
    }
    
    public String obtenerNombreEdificio(){
        return nEdificio;
    }
    
    public String obtenerUbicacionEdificio(){
        return uEdificio;
    }
    
    public Constructora obtenerConstructora(){
        return constructora;
    }
}

