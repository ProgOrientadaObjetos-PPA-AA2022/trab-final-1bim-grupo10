/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete01;

import java.util.Scanner;
import paquete02.ArchivoEscrituraPropietario;
import paquete02.ArchivoLecturaPropietario;
import paquete02.Propietario;
import paquete03.ArchivoEscrituraBarrio;
import paquete03.ArchivoLecturaBarrio;
import paquete03.Barrio;
import paquete04.ArchivoEscrituraCiudad;
import paquete04.ArchivoLecturaCiudad;
import paquete04.Ciudad;
import paquete05.ArchivoEscrituraConstructora;
import paquete05.ArchivoLecturaConstructora;
import paquete05.Constructora;
import paquete06.ArchivoEscrituraCasa;
import paquete06.ArchivoEscrituraDepartamento;
import paquete06.ArchivoLecturaCasa;
import paquete06.ArchivoLecturaDepartamento;
import paquete06.Casa;
import paquete06.Departamento;

/**
 *
 * @author Joe
 */
public class Ejecutor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op;
        boolean bandera = true;

        System.out.println("\t\tBIENVENIDO");
        System.out.println("\t---GESTION INMOBILIARIA---");
        System.out.println("INGRESE EL NUMERO DE LA ACCION QUE DESEA REALIZAR");
        while (bandera) {
            System.out.println("\t(1) Para iniciar el programa");
            System.out.println("\t(0) Para salir");
            op = sc.nextInt();
            if (op == 1) {
                System.out.println("INGRESE EL NUMERO DE LA ACCION QUE DESEA REALIZAR");
                menuPrincipal();
                bandera = false;
            } else {
                if (op == 0) {
                    System.out.println("------------------------ ADIOS :( ------------------------");
                    bandera = false;
                } else {
                    System.out.println("OPCION FUERA DE RANGO, intente nuevamente\n");
                    System.out.println("----------------------------------------------------------");
                }
            }

        }
    }

    public static void menuPrincipal() {
        int opciones;
        Scanner sc = new Scanner(System.in);
        boolean bandera = true;
        System.out.println("\t(1) Ingresar Casa");
        System.out.println("\t(2) Ingresar Departamento");
        System.out.println("\t(3) Ingresar Propietario");
        System.out.println("\t(4) Ingresar Barrio");
        System.out.println("\t(5) Ingresar Ciudad");
        System.out.println("\t(6) Ingresar Costructora");
        System.out.println("\t(7) Visualizar");
        System.out.println("\t(8) Cerrar");
        opciones = sc.nextInt();
        System.out.println("----------------------------------------------------------------------");
        if (opciones == 1) {
            menuCasa();
        } else {
            if (opciones == 2) {
                menuDepartamento();
            } else {
                if (opciones == 3) {
                    menuPropietario();
                } else {
                    if (opciones == 4) {
                        menuBarrio();
                    } else {
                        if (opciones == 5) {
                            menuCiudad();
                        } else {
                            if (opciones == 6) {
                                menuConstructora();
                            } else {
                                if (opciones == 7) {
                                    menuImpresion();
                                } else {
                                    if (opciones == 8) {
                                        System.out.println("PROGRAMA FINALIZADO");
                                    } else {
                                        System.out.println("OPCION FUERA DE RANGO, INTENTE NUEVAMENTE\n");
                                        menuPrincipal();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void menuCasa() {
        Scanner sc = new Scanner(System.in);
        int opPropietario;
        System.out.println("\t GESTION INMOBILIARIA");
        System.out.println(" ---------------------------INGRESANDO CASA---------------------------");
        Propietario pro = identificadorPropietario();
        Barrio bar = identificadorBarrio();
        Ciudad ciu = identificadorCiudad();
        Constructora con = identificadorConstructora();
        System.out.println("Ingrese el valor del metro cuadrado: ");
        Double precioMetroCuadrado = sc.nextDouble();
        System.out.println("Ingrese el numero de metros cuadrados de la casa: ");
        Double metrosCuadrados = sc.nextDouble();
        System.out.println("Ingrese el numero de cuartos de la casa: ");
        int numeroCuartos = sc.nextInt();
        System.out.println("----------------------------------------------------------------------");
        Casa casa = new Casa(precioMetroCuadrado, metrosCuadrados, numeroCuartos, pro, bar, ciu, con);
        casa.establecerCostoFinal();
        ArchivoEscrituraCasa archivocasa = new ArchivoEscrituraCasa("datos/casas.dat");
        archivocasa.establecerRegistro(casa);
        archivocasa.establecerSalida();
        System.out.println("\t¿DESEA VOLVER AL MENU PRINCIPAL?");
        System.out.println("Para volver al menu principal pulse_____(1)");
        System.out.println("Para salir del programa pulse___________(2)");
        int atras = sc.nextInt();
        System.out.println("----------------------------------------------------------------------");
        if (atras == 1) {
            System.out.println("\t     GESTION INMOBILIARIA");
            System.out.println("\t-------ELIJA UNA OPCION-------");
            menuPrincipal();
        } else {
            if (atras == 2) {
                System.out.println("GRACIAS POR USAR EL PROGRAMA :)");
            } else {
                System.out.println("ERROR..Opcion Incorrecta");
            }
        }
    }

    public static void menuDepartamento() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\tGESTION INMOBILIARIA");
        System.out.println(" -----------------------INGRESANDO DEPARTAMENTO-----------------------");
        Propietario pro = identificadorPropietario();
        Barrio bar = identificadorBarrio();
        Ciudad ciu = identificadorCiudad();
        Constructora con = identificadorConstructora();
        System.out.println("Ingrese el precio por metro cuadrado: ");
        double pMCuadrado = sc.nextDouble();
        System.out.println("Ingrese el numero de metros cuadrados: ");
        double mCuadrados = sc.nextDouble();
        System.out.println("Ingrese valor alicuota mensual: ");
        Double vAlicuota = sc.nextDouble();
        sc.nextLine();
        System.out.println("Ingrese el nombre del edificio: ");
        String nEdificio = sc.nextLine();
        System.out.println("Ingrese la ubicacion en el edificio: ");
        String uEdificio = sc.nextLine();
        System.out.println("----------------------------------------------------------------------");
        Departamento departamento = new Departamento(pro, pMCuadrado, mCuadrados, vAlicuota, bar, ciu, nEdificio, uEdificio, con);
        departamento.establecerValorFinal();
        ArchivoEscrituraDepartamento archivodepar = new ArchivoEscrituraDepartamento("datos/departamentos.dat");
        archivodepar.establecerRegistro(departamento);
        archivodepar.establecerSalida();
        System.out.println("\t¿DESEA VOLVER AL MENU PRINCIPAL?");
        System.out.println("Para volver al menu principal pulse_____(1)");
        System.out.println("Para salir del programa pulse___________(2)");
        int atras = sc.nextInt();
        System.out.println("----------------------------------------------------------------------");
        if (atras == 1) {
            System.out.println("\t     GESTION INMOBILIARIA");
            System.out.println("\t-------ELIJA UNA OPCION-------");
            menuPrincipal();
        } else {
            if (atras == 2) {
                System.out.println("GRACIAS POR USAR EL PROGRAMA :)");
            } else {
                System.out.println("ERROR..Opcion Incorrecta");
            }
        }
    }

    public static void menuPropietario() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\tGESTION INMOBILIARIA");
        System.out.println("-------INGRESANDO PROPIETARIO-------");
        System.out.println("Ingrese nombres del propietario: ");
        String nPropietario = sc.nextLine();
        System.out.println("Ingrese apellidos del propietario: ");
        String aPropietario = sc.nextLine();
        System.out.println("Ingrese identificacion del propietario(dni): ");
        String cPropietario = sc.nextLine();
        System.out.println("----------------------------------------------------------------------");
        Propietario pro
                = new Propietario(nPropietario, aPropietario, cPropietario);
        ArchivoEscrituraPropietario archivop
                = new ArchivoEscrituraPropietario("datos/propietarios.dat");
        System.out.println(pro);
        archivop.establecerRegistro(pro);
        archivop.establecerSalida();
        System.out.println("\t¿DESEA VOLVER AL MENU PRINCIPAL?");
        System.out.println("Para volver al menu principal pulse_____(1)");
        System.out.println("Para salir del programa pulse___________(2)");
        int atras = sc.nextInt();
        System.out.println("----------------------------------------------------------------------");
        if (atras == 1) {
            System.out.println("\t     GESTION INMOBILIARIA");
            System.out.println("\t-------ELIJA UNA OPCION-------");
            menuPrincipal();
        } else {
            if (atras == 2) {
                System.out.println("GRACIAS POR USAR EL PROGRAMA :)");
            } else {
                System.out.println("ERROR..Opcion Incorrecta");
            }
        }
    }

    public static void menuBarrio() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\t GESTION INMOBILIARIA");
        System.out.println("----------INGRESANDO BARRIO----------");
        System.out.println("Ingrese nombre del barrio: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese referencia del barrio: ");
        String referencia = sc.nextLine();
        System.out.println("----------------------------------------------------------------------");
        Barrio bar = new Barrio(nombre, referencia);
        ArchivoEscrituraBarrio archivob = new ArchivoEscrituraBarrio("datos/barrios.dat");
        System.out.println(archivob.toString());
        archivob.establecerRegistro(bar);
        archivob.establecerSalida();
        System.out.println("\t¿DESEA VOLVER AL MENU PRINCIPAL?");
        System.out.println("Para volver al menu principal pulse_____(1)");
        System.out.println("Para salir del programa pulse___________(2)");
        int atras = sc.nextInt();
        System.out.println("----------------------------------------------------------------------");
        if (atras == 1) {
            System.out.println("\t     GESTION INMOBILIARIA");
            System.out.println("\t-------ELIJA UNA OPCION-------");
            menuPrincipal();
        } else {
            if (atras == 2) {
                System.out.println("GRACIAS POR USAR EL PROGRAMA :)");
            } else {
                System.out.println("ERROR..Opcion Incorrecta");
            }
        }
    }

    public static void menuCiudad() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\t GESTION INMOBILIARIA");
        System.out.println("----------INGRESANDO CIUDAD----------");
        System.out.println("Ingrese nombre de la ciudad: ");
        String nCiudad = sc.nextLine();
        System.out.println("Ingrese nombre de la provincia: ");
        String nProvincia = sc.nextLine();
        System.out.println("----------------------------------------------------------------------");
        Ciudad ciu = new Ciudad(nCiudad, nProvincia);
        ArchivoEscrituraCiudad archivociu = new ArchivoEscrituraCiudad("datos/ciudades.dat");
        archivociu.establecerRegistro(ciu);
        archivociu.establecerSalida();
        System.out.println("\t¿DESEA VOLVER AL MENU PRINCIPAL?");
        System.out.println("Para volver al menu principal pulse_____(1)");
        System.out.println("Para salir del programa pulse___________(2)");
        int atras = sc.nextInt();
        System.out.println("----------------------------------------------------------------------");
        if (atras == 1) {
            System.out.println("\t     GESTION INMOBILIARIA");
            System.out.println("\t-------ELIJA UNA OPCION-------");
            menuPrincipal();
        } else {
            if (atras == 2) {
                System.out.println("GRACIAS POR USAR EL PROGRAMA :)");
            } else {
                System.out.println("ERROR..Opcion Incorrecta");
            }
        }
    }

    public static void menuConstructora() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\t GESTION INMOBILIARIA");
        System.out.println("-------INGRESANDO CONSTRUCTORA-------");
        System.out.println("Ingrese nombre de la constructora: ");
        String nConstructora = sc.nextLine();
        System.out.println("Ingrese id de la constructora:");
        String idEmpresa = sc.nextLine();
        System.out.println("----------------------------------------------------------------------");
        Constructora con = new Constructora(nConstructora, idEmpresa);
        ArchivoEscrituraConstructora archivocons = new ArchivoEscrituraConstructora("datos/constructoras.dat");
        archivocons.establecerRegistro(con);
        archivocons.establecerSalida();
        System.out.println("\t¿DESEA VOLVER AL MENU PRINCIPAL?");
        System.out.println("Para volver al menu principal pulse_____(1)");
        System.out.println("Para salir del programa pulse___________(2)");
        int atras = sc.nextInt();
        System.out.println("----------------------------------------------------------------------");
        if (atras == 1) {
            System.out.println("\t     GESTION INMOBILIARIA");
            System.out.println("\t-------ELIJA UNA OPCION-------");
            menuPrincipal();
        } else {
            if (atras == 2) {
                System.out.println("GRACIAS POR USAR EL PROGRAMA :)");
            } else {
                System.out.println("ERROR..Opcion Incorrecta");
            }
        }
    }

    public static void menuImpresion() {
        Scanner sc = new Scanner(System.in);
        int imp;
        int atras;
        System.out.println("\t     GESTION INMOBILIARIA");
        System.out.println("INGRESE EL NUMERO DE LA ACCION QUE DESEA REALIZAR");
        System.out.println("\t(1) Ver casas");
        System.out.println("\t(2) Ver departamentos");
        System.out.println("\t(3) Ver propietarios");
        System.out.println("\t(4) Ver barrios");
        System.out.println("\t(5) Ver ciudades");
        System.out.println("\t(6) Ver constructoras");
        System.out.println("\t(7) Regresar menu anterior");
        System.out.println("\t(0) Para salir");
        imp = sc.nextInt();
        System.out.println("----------------------------------------------------------------------");
        if (imp == 1) {
            ArchivoLecturaCasa lecturac = new ArchivoLecturaCasa("datos/casas.dat");
            lecturac.establecerCasa();
            System.out.printf("%s", lecturac.toString());
            lecturac.cerrarArchivo();
            System.out.println("\t¿DESEA VOLVER AL MENU PRINCIPAL?");
            System.out.println("Para volver al menu principal pulse_____(1)");
            System.out.println("Para salir del programa pulse___________(2)");
            atras = sc.nextInt();
            System.out.println("------------------------------------------------------------------");
            if (atras == 1) {
                System.out.println("\t     GESTION INMOBILIARIA");
                System.out.println("\t-------ELIJA UNA OPCION-------");
                menuPrincipal();
            } else {
                if (atras == 2) {
                    System.out.println("GRACIAS POR USAR EL PROGRAMA :)");
                } else {
                    System.out.println("ERROR..Opcion Incorrecta");
                }
            }
        } else {
            if (imp == 2) {
                ArchivoLecturaDepartamento lecturad = new ArchivoLecturaDepartamento("datos/departamentos.dat");
                lecturad.establecerDepartamento();
                System.out.printf("%s", lecturad.toString());
                lecturad.cerrarArchivo();
                System.out.println("\t¿DESEA VOLVER AL MENU PRINCIPAL?");
                System.out.println("Para volver al menu principal pulse_____(1)");
                System.out.println("Para salir del programa pulse___________(2)");
                atras = sc.nextInt();
                System.out.println("--------------------------------------------------------------");
                if (atras == 1) {
                    System.out.println("\t     GESTION INMOBILIARIA");
                    System.out.println("\t-------ELIJA UNA OPCION-------");
                    menuPrincipal();
                } else {
                    if (atras == 2) {
                        System.out.println("GRACIAS POR USAR EL PROGRAMA :)");
                    } else {
                        System.out.println("ERROR..Opcion Incorrecta");
                    }
                }
            } else {
                if (imp == 3) {
                    ArchivoLecturaPropietario lecturap = new ArchivoLecturaPropietario("datos/propietarios.dat");
                    lecturap.establecerPropietarios();
                    System.out.printf("%s", lecturap.toString());
                    lecturap.cerrarArchivo();
                    System.out.println("\t¿DESEA VOLVER AL MENU PRINCIPAL?");
                    System.out.println("Para volver al menu principal pulse_____(1)");
                    System.out.println("Para salir del programa pulse___________(2)");
                    atras = sc.nextInt();
                    System.out.println("----------------------------------------------------------");
                    if (atras == 1) {
                        System.out.println("\t     GESTION INMOBILIARIA");
                        System.out.println("\t-------ELIJA UNA OPCION-------");
                        menuPrincipal();
                    } else {
                        if (atras == 2) {
                            System.out.println("GRACIAS POR USAR EL PROGRAMA :)");
                        } else {
                            System.out.println("ERROR..Opcion Incorrecta");
                        }
                    }
                } else {
                    if (imp == 4) {
                        ArchivoLecturaBarrio lecturab = new ArchivoLecturaBarrio("datos/barrios.dat");
                        lecturab.establecerBarrios();
                        System.out.printf("%s", lecturab.toString());
                        lecturab.cerrarArchivo();
                        System.out.println("\t¿DESEA VOLVER AL MENU PRINCIPAL?");
                        System.out.println("Para volver al menu principal pulse_____(1)");
                        System.out.println("Para salir del programa pulse___________(2)");
                        atras = sc.nextInt();
                        System.out.println("------------------------------------------------------");
                        if (atras == 1) {
                            System.out.println("\t     GESTION INMOBILIARIA");
                            System.out.println("\t-------ELIJA UNA OPCION-------");
                            menuPrincipal();
                        } else {
                            if (atras == 2) {
                                System.out.println("GRACIAS POR USAR EL PROGRAMA :)");
                            } else {
                                System.out.println("ERROR..Opcion Incorrecta");
                            }
                        }
                    } else {
                        if (imp == 5) {
                            ArchivoLecturaCiudad lecturaciu = new ArchivoLecturaCiudad("datos/ciudades.dat");
                            lecturaciu.establecerCiudades();
                            System.out.printf("%s", lecturaciu.toString());
                            lecturaciu.cerrarArchivo();
                            System.out.println("\t¿DESEA VOLVER AL MENU PRINCIPAL?");
                            System.out.println("Para volver al menu principal pulse_____(1)");
                            System.out.println("Para salir del programa pulse___________(2)");
                            atras = sc.nextInt();
                            System.out.println("--------------------------------------------------");
                            if (atras == 1) {
                                System.out.println("\t     GESTION INMOBILIARIA");
                                System.out.println("\t-------ELIJA UNA OPCION-------");
                                menuPrincipal();
                            } else {
                                if (atras == 2) {
                                    System.out.println("GRACIAS POR USAR EL PROGRAMA :)");
                                } else {
                                    System.out.println("ERROR..Opcion Incorrecta");
                                }
                            }
                        } else {
                            if (imp == 6) {
                                ArchivoLecturaConstructora lecturaco = new ArchivoLecturaConstructora("datos/constructoras.dat");
                                lecturaco.establecerConstructoras();
                                System.out.printf("%s", lecturaco.toString());
                                lecturaco.cerrarArchivo();
                                System.out.println("\t¿DESEA VOLVER AL MENU PRINCIPAL?");
                                System.out.println("Para volver al menu principal pulse_____(1)");
                                System.out.println("Para salir del programa pulse___________(2)");
                                atras = sc.nextInt();
                                System.out.println("----------------------------------------------");
                                if (atras == 1) {
                                    System.out.println("\t     GESTION INMOBILIARIA");
                                    System.out.println("\t-------ELIJA UNA OPCION-------");
                                    menuPrincipal();
                                } else {
                                    if (atras == 2) {
                                        System.out.println("GRACIAS POR USAR EL PROGRAMA :)");
                                    } else {
                                        System.out.println("ERROR..Opcion Incorrecta");
                                    }
                                }
                            } else {
                                if (imp == 7) {
                                    System.out.println("\t     GESTION INMOBILIARIA");
                                    System.out.println("\t-------ELIJA UNA OPCION-------");
                                    menuPrincipal();
                                }
                                if (imp == 0) {
                                    System.out.println("----------ADIOS :( ----------");
                                } else {
                                    System.out.println("OPCION FUERA DE RANGO, INTENTE NUEVAMENTE\n");
                                    System.out.println("----------------------------------------------------------");
                                    menuImpresion();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static Propietario identificadorPropietario() {
        Scanner sc = new Scanner(System.in);
        String identificacion;
        String nombres;
        String apellidos;
        String nombreArchivo = "datos/propietarios.dat";
        System.out.println(" -------INGRESANDO PROPIETARIO-------");
        System.out.println("Ingrese la cedula del propietario: ");
        identificacion = sc.nextLine();
        System.out.println("----------------------------------------------------------------------");
        Propietario propietarioEncontrado;

        ArchivoLecturaPropietario lecturaP = new ArchivoLecturaPropietario(nombreArchivo);

        lecturaP.establecerIdentificador(identificacion);

        lecturaP.establecerPropietarioBuscado();

        propietarioEncontrado = lecturaP.obtenerPropietarioBuscado();

        if (propietarioEncontrado != null) {
            System.out.printf("Propietario encontrado: %s\n", propietarioEncontrado);
            return propietarioEncontrado;
        } else {
            System.out.println("No se ha encontrado ese propietario, ingrese nuevo propietario");
            System.out.println("------------------------------------------------------------------\n");
            System.out.println("---INGRESE UN NUEVO PROPIETARIO---");
            System.out.println("Ingrese nombres del propietario: ");
            nombres = sc.nextLine();
            System.out.println("Ingrese apellidos del propietario: ");
            apellidos = sc.nextLine();
            System.out.println("Ingrese identificacion del propietario: ");
            identificacion = sc.nextLine();
            System.out.println("--NUEVO PROPIETARIO GUARDADO--");
            Propietario propietario = new Propietario(nombres, apellidos, identificacion);
            ArchivoEscrituraPropietario archivop = new ArchivoEscrituraPropietario(nombreArchivo);
            archivop.establecerRegistro(propietario);
            archivop.establecerSalida();
            return propietario;
        }
    }

    public static Barrio identificadorBarrio() {
        Scanner sc = new Scanner(System.in);
        String nombreBarrio;
        String referencia;
        String nombreArchivo = "datos/barrios.dat";
        System.out.println(" ---------INGRESANDO BARRIO---------");
        System.out.println("Ingrese nombre del barrio: ");
        nombreBarrio = sc.nextLine();
        Barrio barrioEncontrado;
        ArchivoLecturaBarrio lecturaB = new ArchivoLecturaBarrio(nombreArchivo);
        lecturaB.establecerIdentificador(nombreBarrio);
        lecturaB.establecerBarrioBuscado();
        barrioEncontrado = lecturaB.obtenerBarrioBuscado();
        if (barrioEncontrado != null) {
            System.out.printf("Barrio encontrado %s\n", barrioEncontrado);
            return barrioEncontrado;
        } else {
            System.out.println("No se ha encontrado ese barrio, ingrese nuevo barrio");
            System.out.println("------------------------------------------------------------------");
            System.out.println(" ---INGRESE NUEVO BARRIO---");
            System.out.println("Ingrese nombre del barrio: ");
            nombreBarrio = sc.nextLine();
            System.out.println("Ingrese referencia: ");
            referencia = sc.nextLine();
            System.out.println("--NUEVO BARRIO GUARDADO--");
            Barrio barrio = new Barrio(nombreBarrio, referencia);
            ArchivoEscrituraBarrio archivob = new ArchivoEscrituraBarrio(nombreArchivo);
            archivob.establecerRegistro(barrio);
            archivob.establecerSalida();
            return barrio;
        }
    }

    public static Ciudad identificadorCiudad() {
        Scanner sc = new Scanner(System.in);
        String nombreCiudad;
        String nombreProvincia;
        String nombreArchivo = "datos/ciudades.dat";
        System.out.println(" -------INGRESANDO CIUDAD-------");
        System.out.println("Ingrese nombre ciudad: ");
        nombreCiudad = sc.nextLine();
        Ciudad ciudadEncontrada;
        ArchivoLecturaCiudad lecturaC = new ArchivoLecturaCiudad(nombreArchivo);
        lecturaC.establecerIdentificador(nombreCiudad);
        lecturaC.establecerCiudadBuscada();
        ciudadEncontrada = lecturaC.obtenerCiudadBuscada();
        if (ciudadEncontrada != null) {
            System.out.printf("Ciudad encontrada %s\n", ciudadEncontrada);
            return ciudadEncontrada;
        } else {
            System.out.println("No se ha encontrado esa ciudad, ingrese nueva ciudad");
            System.out.println("------------------------------------------------------------------");
            System.out.println(" ----INGRESE NUEVA CIUDAD----");
            System.out.println("Ingrese nombre de la ciudad: ");
            nombreCiudad = sc.nextLine();
            System.out.println("Ingrese nombre de la provincia: ");
            nombreProvincia = sc.nextLine();
            System.out.println("--NUEVA CIUDAD GUARDADA--");
            Ciudad ciudad = new Ciudad(nombreCiudad, nombreProvincia);
            ArchivoEscrituraCiudad archivociu = new ArchivoEscrituraCiudad(nombreArchivo);
            archivociu.establecerRegistro(ciudad);
            archivociu.establecerSalida();
            return ciudad;
        }
    }

    public static Constructora identificadorConstructora() {
        Scanner sc = new Scanner(System.in);
        String nombreConstructora;
        String idEmpresa;
        String nombreArchivo = "datos/constructoras.dat";
        System.out.println("-------INGRESANDO CONSTRUCTORA-------");
        System.out.println("Ingrese id de la constructora: ");
        idEmpresa = sc.nextLine();
        Constructora constructoraEncontrada;
        ArchivoLecturaConstructora lecturaCo = new ArchivoLecturaConstructora(nombreArchivo);
        lecturaCo.establecerIdentificador(idEmpresa);
        lecturaCo.establecerConstructoraBuscada();
        constructoraEncontrada = lecturaCo.obtenerConstructoraBuscada();
        if (constructoraEncontrada != null) {
            System.out.printf("Constructora encontrada %s\n", constructoraEncontrada);
            return constructoraEncontrada;
        } else {
            System.out.println("No se ha encontrado esa constructora, ingrese nueva constructora");
            System.out.println("----------------------------------------------------------------");
            System.out.println("--INGRESE NUEVA CONSTRUCTORA--");
            System.out.println("Ingrese nombre constructora: ");
            nombreConstructora = sc.nextLine();
            System.out.println("Ingrese id constructora: ");
            idEmpresa = sc.nextLine();
            System.out.println("--NUEVA CONSTRUCTORA GUARDADA--");
            Constructora constructora = new Constructora(nombreConstructora, idEmpresa);
            ArchivoEscrituraConstructora archivoco = new ArchivoEscrituraConstructora(nombreArchivo);
            archivoco.establecerRegistro(constructora);
            archivoco.establecerSalida();
            return constructora;
        }
    }
}
