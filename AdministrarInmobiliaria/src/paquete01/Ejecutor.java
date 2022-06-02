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
        double pMCuadrado, nMCuadrados;
        int op;
        int nCuartos;
        System.out.println("Administracion Inmobiliaria");
        do {
            op = menu();
            switch (op) {
                case 1:
                    p = encontrarPropietarioBuscado();
                    b = encontrarBarrioBuscado();
                    cd = encontrarCiudadBuscada();
                    ct = encontrarConstructoraBuscada();
                    System.out.println(
                            "Ingrese el valor del metro cuadrado: ");
                    pMCuadrado = sc.nextDouble();
                    System.out.println(
                            "Ingrese el numero de metros cuadrados de la casa: ");
                    nMCuadrados = sc.nextDouble();
                    System.out.println(
                            "Ingrese el numero de cuartos de la casa: ");
                    nCuartos = sc.nextInt();
                    Casa casa = 
                            new Casa(pMCuadrado, nMCuadrados, nCuartos, p, b, cd, ct);
                    casa.establecerCostoFinal();
                    ArchivoEscrituraCasa archivocasa = 
                            new ArchivoEscrituraCasa("datos/casas.dat");
                    archivocasa.establecerRegistro(casa);
                    archivocasa.establecerSalida();
                    break;
                case 2:
                    p = encontrarPropietarioBuscado();
                    b = encontrarBarrioBuscado();
                    cd = encontrarCiudadBuscada();
                    ct = encontrarConstructoraBuscada();
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
                    Departamento departamento = 
                            new Departamento(p, pMCuadrado, nMCuadrados, valorAlicuota, 
                                    b, cd, nEdificio, uEdificio, ct);
                    departamento.establecerValorFinal();
                    ArchivoEscrituraDepartamento archivodepar = 
                            new ArchivoEscrituraDepartamento("datos/departamentos.dat");
                    archivodepar.establecerRegistro(departamento);
                    archivodepar.establecerSalida();
                    break;
                case 3:
                    System.out.println("Ingrese nombres del propietario: ");
                    String nPropietario = sc.nextLine();
                    System.out.println("Ingrese apellidos del propietario: ");
                    String aPropietario = sc.nextLine();
                    System.out.println("Ingrese identificacion del propietario(dni): ");
                    String cPropietario = sc.nextLine();
                    p = new Propietario(nPropietario, aPropietario, cPropietario);
                    ArchivoEscrituraPropietario archivop = 
                            new ArchivoEscrituraPropietario("datos/propietarios.dat");
                    System.out.println(p);
                    archivop.establecerRegistro(p);
                    archivop.establecerSalida();
                    break;
                case 4:
                    System.out.println("Ingrese nombre del barrio: ");
                    String nBarrio = sc.nextLine();
                    System.out.println("Ingrese referencia del barrio: ");
                    String rBarrio = sc.nextLine();
                    b = new Barrio(nBarrio, rBarrio);
                    ArchivoEscrituraBarrio archivob = 
                            new ArchivoEscrituraBarrio("datos/barrios.dat");
                    System.out.println(archivob.toString());
                    archivob.establecerRegistro(b);
                    archivob.establecerSalida();
                    break;
                case 5:
                    System.out.println("Ingrese nombre de la ciudad: ");
                    String nCiudad = sc.nextLine();
                    System.out.println("Ingrese nombre de la provincia: ");
                    String pCiudad = sc.nextLine();
                    cd = new Ciudad(nCiudad, pCiudad);
                    ArchivoEscrituraCiudad archivociu = 
                            new ArchivoEscrituraCiudad("datos/ciudades.dat");
                    archivociu.establecerRegistro(cd);
                    archivociu.establecerSalida();
                    break;
                case 6:
                    System.out.println("Ingrese nombre de la constructora: ");
                    String nConstructora = sc.nextLine();
                    System.out.println("Ingrese id de la constructora:");
                    String idEmpresa = sc.nextLine();
                    ct = new Constructora(nConstructora, idEmpresa);
                    ArchivoEscrituraConstructora archivocons = 
                            new ArchivoEscrituraConstructora("datos/constructoras.dat");
                    archivocons.establecerRegistro(ct);
                    archivocons.establecerSalida();
                    break;
                case 7:
                    do {
                        op = menu2();
                        mostrarListas(op);
                    } while (op != 0);
                    op = 7;
                    break;
                case 0:
                    System.out.println("Fin del programa");
            }
        } while (op != 0);
    }

    public static int menu() {
        Scanner sc = new Scanner(System.in);
        int op;
        System.out.println("1)Ingresar Casa:");
        System.out.println("2)Ingresar Departamento:");
        System.out.println("3)Ingresar Propietario:");
        System.out.println("4)Ingresar Barrio:");
        System.out.println("5)Ingresar Ciudad:");
        System.out.println("6)Ingresar Constructora:");
        System.out.println("7)Ver Listas:");
        System.out.println("0)Salir del Programa:");
        op = sc.nextInt();
        return op;
    }

    public static int menu2() {
        Scanner sc = new Scanner(System.in);
        int op;
        System.out.println("1)Ver Lista de casas:");
        System.out.println("2)Ver Lista de departamentos:");
        System.out.println("3)Ver Lista de propietarios:");
        System.out.println("4)Ver Lista de barrios: ");
        System.out.println("5)Ver Lista de ciudades:");
        System.out.println("6)Ver Lista de constructoras:");
        System.out.println("0)Regresar menu anterior:");
        op = sc.nextInt();
        return op;
    }

    public static Propietario encontrarPropietarioBuscado() {
        Scanner sc = new Scanner(System.in);
        String cPropietario;
        String nPropietario;
        String aPropietario;
        String nombreArchivo = "datos/propietarios.dat";
        System.out.println("Ingrese identifiacion del propietario: ");
        cPropietario = sc.nextLine();
        Propietario propietarioEncontrado;
        ArchivoLecturaPropietario lecturaP = 
                new ArchivoLecturaPropietario(nombreArchivo);
        lecturaP.establecerIdentificador(cPropietario);
        lecturaP.establecerPropietarioBuscado();
        propietarioEncontrado = lecturaP.obtenerPropietarioBuscado();
        if (propietarioEncontrado != null) {
            System.out.printf(
                    "Propietario encontrado %s\n", propietarioEncontrado);
            return propietarioEncontrado;
        } else {
            System.out.println(
                    "No se ha encontrado ese propietario, ingrese nuevo propietario");
            System.out.println("Ingrese el nombre del propietario: ");
            nPropietario = sc.nextLine();
            System.out.println("Ingrese el apellido del propietario: ");
            aPropietario = sc.nextLine();
            System.out.println("Ingrese la cedula del propietario: ");
            cPropietario = sc.nextLine();
            Propietario propietario = 
                    new Propietario(nPropietario, aPropietario, cPropietario);
            ArchivoEscrituraPropietario archivop = 
                    new ArchivoEscrituraPropietario(nombreArchivo);
            archivop.establecerRegistro(propietario);
            archivop.establecerSalida();
            return propietario;
        }
    }

    public static Barrio encontrarBarrioBuscado() {
        Scanner sc = new Scanner(System.in);
        String nBarrio;
        String rBarrioa;
        String nombreArchivo = "datos/barrios.dat";
        System.out.println("Ingrese nombre del barrio: ");
        nBarrio = sc.nextLine();
        Barrio barrioEncontrado;
        ArchivoLecturaBarrio lecturaB = 
                new ArchivoLecturaBarrio(nombreArchivo);
        lecturaB.establecerIdentificador(nBarrio);
        lecturaB.establecerBarrioBuscado();
        barrioEncontrado = lecturaB.obtenerBarrioBuscado();
        if (barrioEncontrado != null) {
            System.out.printf("Barrio encontrado %s\n", barrioEncontrado);
            return barrioEncontrado;
        } else {
            System.out.println(
                    "No se ha encontrado ese barrio, ingrese nuevo barrio");
            System.out.println("Ingrese nombre del barrio: ");
            nBarrio = sc.nextLine();
            System.out.println("Ingrese referencia: ");
            rBarrioa = sc.nextLine();
            Barrio barrio = new Barrio(nBarrio, rBarrioa);
            ArchivoEscrituraBarrio archivob = 
                    new ArchivoEscrituraBarrio(nombreArchivo);
            archivob.establecerRegistro(barrio);
            archivob.establecerSalida();
            return barrio;
        }
    }

    public static Ciudad encontrarCiudadBuscada() {
        Scanner sc = new Scanner(System.in);
        String nCiudad;
        String nProvincia;
        String nombreArchivo = "datos/ciudades.dat";
        System.out.println("Ingrese nombre ciudad: ");
        nCiudad = sc.nextLine();
        Ciudad ciudadEncontrada;
        ArchivoLecturaCiudad lecturaC = new ArchivoLecturaCiudad(nombreArchivo);
        lecturaC.establecerIdentificador(nCiudad);
        lecturaC.establecerCiudadBuscada();
        ciudadEncontrada = lecturaC.obtenerCiudadBuscada();
        if (ciudadEncontrada != null) {
            System.out.printf("Ciudad encontrada %s\n", ciudadEncontrada);
            return ciudadEncontrada;
        } else {
            System.out.println(
                    "No se ha encontrado esa ciudad, ingrese nueva ciudad");
            System.out.println("Ingrese nombre de la ciudad: ");
            nCiudad = sc.nextLine();
            System.out.println("Ingrese nombre de la provincia: ");
            nProvincia = sc.nextLine();
            Ciudad ciudad = 
                    new Ciudad(nCiudad, nProvincia);
            ArchivoEscrituraCiudad archivociu = 
                    new ArchivoEscrituraCiudad(nombreArchivo);
            archivociu.establecerRegistro(ciudad);
            archivociu.establecerSalida();
            return ciudad;
        }
    }

    public static Constructora encontrarConstructoraBuscada() {
        Scanner sc = new Scanner(System.in);
        String nConstructora;
        String idEmpresa;
        String nombreArchivo = "datos/constructoras.dat";
        System.out.println("Ingrese id de la constructora: ");
        idEmpresa = sc.nextLine();
        Constructora constructoraEncontrada;
        ArchivoLecturaConstructora lecturaCo = 
                new ArchivoLecturaConstructora(nombreArchivo);
        lecturaCo.establecerIdentificador(idEmpresa);
        lecturaCo.establecerConstructoraBuscada();
        constructoraEncontrada = lecturaCo.obtenerConstructoraBuscada();
        if (constructoraEncontrada != null) {
            System.out.printf("Constructora encontrada %s\n", constructoraEncontrada);
            return constructoraEncontrada;
        } else {
            System.out.println("No se ha encontrado esa constructora, ingrese nueva constructora");
            System.out.println("Ingrese nombre constructora: ");
            nConstructora = sc.nextLine();
            System.out.println("Ingrese id constructora: ");
            idEmpresa = sc.nextLine();
            Constructora constructora = 
                    new Constructora(nConstructora, idEmpresa);
            ArchivoEscrituraConstructora archivoco = 
                    new ArchivoEscrituraConstructora(nombreArchivo);
            archivoco.establecerRegistro(constructora);
            archivoco.establecerSalida();
            return constructora;
        }
    }

    public static void mostrarListas(int op2) {
        switch (op2) {
            case 1:
                ArchivoLecturaCasa lecturac = 
                        new ArchivoLecturaCasa("datos/casas.dat");
                lecturac.establecerCasa();
                System.out.printf("%s", lecturac.toString());
                lecturac.cerrarArchivo();
                break;
            case 2:
                ArchivoLecturaDepartamento lecturad = 
                        new ArchivoLecturaDepartamento("datos/departamentos.dat");
                lecturad.establecerDepartamento();
                System.out.printf("%s", lecturad.toString());
                lecturad.cerrarArchivo();
                break;
            case 3:
                ArchivoLecturaPropietario lecturap = 
                        new ArchivoLecturaPropietario("datos/propietarios.dat");
                lecturap.establecerPropietarios();
                System.out.printf("%s", lecturap.toString());
                lecturap.cerrarArchivo();
                break;
            case 4:
                ArchivoLecturaBarrio lecturab = 
                        new ArchivoLecturaBarrio("datos/barrios.dat");
                lecturab.establecerBarrios();
                System.out.printf("%s", lecturab.toString());
                lecturab.cerrarArchivo();
                break;
            case 5:
                ArchivoLecturaCiudad lecturaciu = 
                        new ArchivoLecturaCiudad("datos/ciudades.dat");
                lecturaciu.establecerCiudades();
                System.out.printf("%s", lecturaciu.toString());
                lecturaciu.cerrarArchivo();
                break;
            case 6:
                ArchivoLecturaConstructora lecturaco = 
                        new ArchivoLecturaConstructora("datos/constructoras.dat");
                lecturaco.establecerConstructoras();
                System.out.printf("%s", lecturaco.toString());
                lecturaco.cerrarArchivo();
                break;
        }
    }
}
