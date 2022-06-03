/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete01;

/**
 *
 * @author reroes
 */
import java.util.Scanner;
import paquete02.*;
import paquete03.*;
import paquete04.*;
import paquete05.*;
import paquete06.*;

public class Ejecutor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nEdificio;
        String uEdificio;
        Propietario p;
        Barrio b;
        Ciudad cd;
        Constructora ct;
        double pMCuadrado;
        double nMCuadrados;
        int x;
        int nCuartos;
        System.out.println("Administracion Inmobiliaria");
        do {
            x = opciones();
            switch (x) {

                // ------CASA-------
                case 1:
                    p = encontrarPropietarioBuscado();
                    b = encontrarBarrio();
                    cd = encontrarCiudad();
                    ct = encontrarConstructora();
                    System.out.println(
                            "Ingrese el valor del metro cuadrado: ");
                    pMCuadrado = sc.nextDouble();
                    System.out.println(
                            "Ingrese el numero de metros cuadrados de la casa: ");
                    nMCuadrados = sc.nextDouble();
                    System.out.println(
                            "Ingrese el numero de cuartos de la casa: ");
                    nCuartos = sc.nextInt();
                    Casa casa
                            = new Casa(pMCuadrado, nMCuadrados, nCuartos, p, b, cd, ct);
                    casa.establecerCostoFinal();
                    EscrituraArchivoSecuencialCasa archivocasa
                            = new EscrituraArchivoSecuencialCasa("datos/casas.dat");
                    archivocasa.establecerRegistro(casa);
                    archivocasa.establecerSalida();
                    break;

                // -----DEPARTAMENTO-----
                case 2:
                    p = encontrarPropietarioBuscado();
                    b = encontrarBarrio();
                    cd = encontrarCiudad();
                    ct = encontrarConstructora();
                    System.out.println(
                            "Ingrese el precio por metro cuadrado: ");
                    pMCuadrado = sc.nextDouble();
                    System.out.println(
                            "Ingrese el numero de metros cuadrados: ");
                    nMCuadrados = sc.nextDouble();
                    System.out.println(
                            "Ingrese valor alicuota mensual: ");
                    Double valorAlicuota = sc.nextDouble();
                    sc.nextLine();
                    System.out.println(
                            "Ingrese el nombre del edificio: ");
                    nEdificio = sc.nextLine();
                    System.out.println(
                            "Ingrese la ubicacion del edificio: ");
                    uEdificio = sc.nextLine();
                    Departamento departamento
                            = new Departamento(p, pMCuadrado, nMCuadrados, valorAlicuota,
                                    b, cd, nEdificio, uEdificio, ct);
                    departamento.establecerValorFinal();
                    EscrituraArchivoSecuencialDepartamento archivodepartamento
                            = new EscrituraArchivoSecuencialDepartamento("datos/departamentos.dat");
                    archivodepartamento.establecerRegistro(departamento);
                    archivodepartamento.establecerSalida();
                    break;

                // -----PROPIETARIO-----
                case 3:
                    System.out.println("Ingrese nombres del propietario: ");
                    String nPropietario = sc.nextLine();
                    System.out.println("Ingrese apellidos del propietario: ");
                    String aPropietario = sc.nextLine();
                    System.out.println("Ingrese la cedula del propietario: ");
                    String cPropietario = sc.nextLine();
                    p = new Propietario(nPropietario, aPropietario, cPropietario);
                    EscrituraArchivoSecuencialPropietario archivopropietario
                            = new EscrituraArchivoSecuencialPropietario("datos/propietarios.dat");
                    System.out.println(p);
                    archivopropietario.establecerRegistro(p);
                    archivopropietario.establecerSalida();
                    break;

                // -----BARRIO-----
                case 4:
                    System.out.println("Ingrese nombre del barrio: ");
                    String nBarrio = sc.nextLine();
                    System.out.println("Ingrese referencia del barrio: ");
                    String rBarrio = sc.nextLine();
                    b = new Barrio(nBarrio, rBarrio);
                    EscrituraArchivoSecuencialBarrio archivobarrio
                            = new EscrituraArchivoSecuencialBarrio("datos/barrios.dat");
                    System.out.println(archivobarrio.toString());
                    archivobarrio.establecerRegistro(b);
                    archivobarrio.establecerSalida();
                    break;
                // -----CIUDAD-----
                case 5:
                    System.out.println("Ingrese nombre de la ciudad: ");
                    String nCiudad = sc.nextLine();
                    System.out.println("Ingrese nombre de la provincia: ");
                    String pCiudad = sc.nextLine();
                    cd = new Ciudad(nCiudad, pCiudad);
                    EscrituraArchivoSecuencialCiudad archivociudad
                            = new EscrituraArchivoSecuencialCiudad("datos/ciudades.dat");
                    archivociudad.establecerRegistro(cd);
                    archivociudad.establecerSalida();
                    break;
                case 6:

                    // -----CONSTRUCTORA-----
                    System.out.println("Ingrese nombre de la constructora: ");
                    String nConstructora = sc.nextLine();
                    System.out.println("Ingrese id de la constructora:");
                    String idEmpresa = sc.nextLine();
                    ct = new Constructora(nConstructora, idEmpresa);
                    EscrituraArchivoSecuencialConstructora archivoconstructora
                            = new EscrituraArchivoSecuencialConstructora("datos/constructoras.dat");
                    archivoconstructora.establecerRegistro(ct);
                    archivoconstructora.establecerSalida();
                    break;

                // -----VER LISTAS-----
                case 7:
                    do {
                        x = opciones2();
                        imprimirListas(x);
                    } while (x != 0);
                    x = 7;
                    break;

                // -----SALIR-----
                case 0:
                    System.out.println("ADIOS :)");
            }
        } while (x != 0);
    }

    // -----ESCOGER QUE INGRESAR, MENU 1-----
    public static int opciones() {
        Scanner sc = new Scanner(System.in);
        int x;
        System.out.println("Escoja que desea ingresar");
        System.out.println("1)Ingresar Casa:");
        System.out.println("2)Ingresar Departamento:");
        System.out.println("3)Ingresar Propietario:");
        System.out.println("4)Ingresar Barrio:");
        System.out.println("5)Ingresar Ciudad:");
        System.out.println("6)Ingresar Constructora:");
        System.out.println("7)Ver Listas:");
        System.out.println("0)Salir del Programa:");
        x = sc.nextInt();
        return x;
    }

    // -----ESCOGER QUE LISTA IMPRIMIR-----
    public static int opciones2() {
        Scanner sc = new Scanner(System.in);
        int x;
        System.out.println("Escoja la lista que desea ver");
        System.out.println("1)Ver casas:");
        System.out.println("2)Ver departamentos:");
        System.out.println("0)Atras:");
        x = sc.nextInt();
        return x;
    }
// -----BUSCAR PROPIETARIO-----

    public static Propietario encontrarPropietarioBuscado() {
        Scanner sc = new Scanner(System.in);
        String cPropietario;
        String nPropietario;
        String aPropietario;
        String nombreArchivo = "datos/propietarios.dat";
        System.out.println("Ingrese cedula del propietario: ");
        cPropietario = sc.nextLine();
        Propietario propietarioEncontrado;
        LecturaArchivoSecuencialPropietario lecturaP
                = new LecturaArchivoSecuencialPropietario(nombreArchivo);
        lecturaP.establecerIdentificador(cPropietario);
        lecturaP.establecerPropietarioBuscado();
        propietarioEncontrado = lecturaP.obtenerPropietarioBuscado();
        if (propietarioEncontrado != null) {
            System.out.printf(
                    "Propietario: %s\n", propietarioEncontrado);
            return propietarioEncontrado;
        } else {
            System.out.println(
                    "No se ha encontrado el propietario, ingrese nuevo propietario");
            System.out.println("Ingrese el nombre del propietario: ");
            nPropietario = sc.nextLine();
            System.out.println("Ingrese el apellido del propietario: ");
            aPropietario = sc.nextLine();
            System.out.println("Ingrese la cedula del propietario: ");
            cPropietario = sc.nextLine();

            Propietario propietario
                    = new Propietario(nPropietario, aPropietario, cPropietario);
            EscrituraArchivoSecuencialPropietario archivop
                    = new EscrituraArchivoSecuencialPropietario(nombreArchivo);
            archivop.establecerRegistro(propietario);
            archivop.establecerSalida();
            return propietario;
        }
    }
// -----BUSCAR BARRIO-----

    public static Barrio encontrarBarrio() {
        Scanner sc = new Scanner(System.in);
        String nBarrio;
        String rBarrioa;
        String nombreArchivo = "datos/barrios.dat";
        System.out.println("Ingrese nombre del barrio: ");
        nBarrio = sc.nextLine();
        Barrio barrioEncontrado;
        LecturaArchivoSecuencialBarrio lecturaB
                = new LecturaArchivoSecuencialBarrio(nombreArchivo);
        lecturaB.establecerIdentificador(nBarrio);
        lecturaB.establecerBarrioBuscado();
        barrioEncontrado = lecturaB.obtenerBarrioBuscado();
        if (barrioEncontrado != null) {
            System.out.printf("Barrio: %s\n", barrioEncontrado);
            return barrioEncontrado;
        } else {
            System.out.println(
                    "No se ha encontrado barrio, ingrese nuevo barrio");
            System.out.println("Ingrese nombre del barrio: ");
            nBarrio = sc.nextLine();
            System.out.println("Ingrese referencia: ");
            rBarrioa = sc.nextLine();
            Barrio barrio = new Barrio(nBarrio, rBarrioa);
            EscrituraArchivoSecuencialBarrio archivob
                    = new EscrituraArchivoSecuencialBarrio(nombreArchivo);
            archivob.establecerRegistro(barrio);
            archivob.establecerSalida();
            return barrio;
        }
    }

// -----BUSCAR CIUDAD-----
    public static Ciudad encontrarCiudad() {
        Scanner sc = new Scanner(System.in);
        String nCiudad;
        String nProvincia;
        String nombreArchivo = "datos/ciudades.dat";
        System.out.println("Ingrese nombre ciudad: ");
        nCiudad = sc.nextLine();
        Ciudad ciudadEncontrada;
        LecturaArchivoSecuencialCiudad lecturaC = new LecturaArchivoSecuencialCiudad(nombreArchivo);
        lecturaC.establecerIdentificador(nCiudad);
        lecturaC.establecerCiudadBuscada();
        ciudadEncontrada = lecturaC.obtenerCiudadBuscada();
        if (ciudadEncontrada != null) {
            System.out.printf("Ciudad: %s\n", ciudadEncontrada);
            return ciudadEncontrada;
        } else {
            System.out.println(
                    "No se ha encontrado la ciudad, ingrese nueva ciudad");
            System.out.println("Ingrese nombre de la ciudad: ");
            nCiudad = sc.nextLine();
            System.out.println("Ingrese nombre de la provincia: ");
            nProvincia = sc.nextLine();
            Ciudad ciudad
                    = new Ciudad(nCiudad, nProvincia);
            EscrituraArchivoSecuencialCiudad archivociu
                    = new EscrituraArchivoSecuencialCiudad(nombreArchivo);
            archivociu.establecerRegistro(ciudad);
            archivociu.establecerSalida();
            return ciudad;
        }
    }

    // -----BUSCAR CONSTRUCTORA-----
    public static Constructora encontrarConstructora() {
        Scanner sc = new Scanner(System.in);
        String nConstructora;
        String idEmpresa;
        String nombreArchivo = "datos/constructoras.dat";
        System.out.println("Ingrese id de la constructora: ");
        idEmpresa = sc.nextLine();
        Constructora constructoraEncontrada;
        LecturaArchivoSecuencialConstructora lecturaCo
                = new LecturaArchivoSecuencialConstructora(nombreArchivo);
        lecturaCo.establecerIdentificador(idEmpresa);
        lecturaCo.establecerConstructoraBuscada();
        constructoraEncontrada = lecturaCo.obtenerConstructoraBuscada();
        if (constructoraEncontrada != null) {
            System.out.printf("Constructora: %s\n", constructoraEncontrada);
            return constructoraEncontrada;
        } else {
            System.out.println(
                    "No se ha encontrado la constructora, ingrese nueva constructora");
            System.out.println("Ingrese nombre constructora: ");
            nConstructora = sc.nextLine();
            System.out.println("Ingrese id constructora: ");
            idEmpresa = sc.nextLine();
            Constructora constructora
                    = new Constructora(nConstructora, idEmpresa);
            EscrituraArchivoSecuencialConstructora archivoco
                    = new EscrituraArchivoSecuencialConstructora(nombreArchivo);
            archivoco.establecerRegistro(constructora);
            archivoco.establecerSalida();
            return constructora;
        }
    }

// -----IMPRIR LISTAS-----
    public static void imprimirListas(int x2) {
        switch (x2) {
            case 1:
                LecturaArchivoSecuencialCasa ImprimirCasa
                        = new LecturaArchivoSecuencialCasa("datos/casas.dat");
                ImprimirCasa.establecerCasa();
                System.out.printf("%s", ImprimirCasa.toString());
                ImprimirCasa.cerrarArchivo();
                break;
            case 2:
                LecturaArchivoSecuencialDepartamento imprimirDepto
                        = new LecturaArchivoSecuencialDepartamento("datos/departamentos.dat");
                imprimirDepto.establecerDepartamento();
                System.out.printf("%s", imprimirDepto.toString());
                imprimirDepto.cerrarArchivo();
                break;
        }
    }
}
