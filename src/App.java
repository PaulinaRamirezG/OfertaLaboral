import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static Scanner scn = new Scanner(System.in);
    static ArrayList<OfertaLaboral> ofertasLaboralesList = new ArrayList<>();
    static ArrayList<Aplicante> aplicanteList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        System.out.println("Bienvenido a la oferta laboral");
        escogerOpcionesIngreso();
    }

    private static void escogerOpcionesIngreso() {
        System.out.println("1. Eres empleador");
        System.out.println("2. Eres candidato");
        System.out.println("0. salir");
        int opcion = scn.nextInt();
        scn.nextLine(); // <---- Para corregir error del Scanner

        switch (opcion) {
            case 1:
                opcionesEmpleador();
                break;
            case 2:
                escogerOpcionEmpleo();
                break;
            default:
                scn.close();
                break;
        }
    }

    // Metodo que determina si el empleador quiere crear una oferta o ver quiénes
    // han aplicado
    private static void opcionesEmpleador() {
        System.out.println("1. Crear oferta");
        System.out.println("2. Ver quiénes han aplicado");
        System.out.println("0. salir");
        int opcion = scn.nextInt();
        scn.nextLine(); // <---- Para corregir error del Scanner

        switch (opcion) {
            case 1:
                crearOferta();
                break;
            case 2:
                verAplicantes();
            default:
                escogerOpcionesIngreso();
                break;
        }
    }

    /**
     * Método que crea la oferta laboral
     */
    private static void crearOferta() {
        System.out.println("Ingresa la industria");
        String industria = scn.nextLine();
        System.out.println("Ingresa la ubicación");
        String ubicacion = scn.nextLine();
        System.out.println("Ingresa el tipo de contrato");
        String tipoContrato = scn.nextLine();
        System.out.println("Ingresa la oferta");
        String oferta = scn.nextLine();

        // se guarda en la clase de ofertas
        OfertaLaboral ofertaLaboral = new OfertaLaboral(industria.toLowerCase(), ubicacion.toLowerCase(),
                tipoContrato.toLowerCase(), oferta);

        // Se guarda en la lista de ofertas
        ofertasLaboralesList.add(ofertaLaboral);
        System.out.println("Se ha guardado exitosamente");
        System.out.println();

        System.out.println("Desea crear otra oferta? (y/n)");
        String respuesta = scn.nextLine();
        if (respuesta.toLowerCase().equals("y")) {
            crearOferta();
        } else {
            escogerOpcionesIngreso();
        }

    }

    /**
     * Método que lista los posibles candidatos
     */
    private static void verAplicantes() {
        if (aplicanteList.size() == 0) {
            System.out.println("Nadie ha aplicado aún");
            return;
        }

        for (Aplicante aplicante : aplicanteList) {
            System.out.println(aplicante.getCodigoOferta() + " Nombre:" + aplicante.getNombre() + " Experiencia:"
                    + aplicante.getExperiencia() + " Calificaciones:" + aplicante.getCalificaciones());
        }
    }

    /**
     * Método de busqueda de opciones de empleo
     */
    private static void escogerOpcionEmpleo() {
        String valorABuscar = "";
        System.out.println("Deseas buscar por:");
        System.out.println("1. Industria");
        System.out.println("2. Ubicacion");
        System.out.println("3. Tipo contrato");
        System.out.println("4. Muestrame todas las ofertas");
        System.out.println("0. Salir");
        int opcion = scn.nextInt();
        scn.nextLine(); // <---- Para corregir error del Scanner

        if (opcion == 0) {
            return;
        } else if (opcion != 4) {
            System.out.println("Ingresa la palabra a buscar");
            valorABuscar = scn.nextLine();
        }

        buscarEmpleo(opcion, valorABuscar);
    }

    /**
     * Metodo que busca el empleo
     * 
     * @param opcion       - Opcion de busqueda
     * @param valorABuscar - Valor de busqueda
     */
    private static void buscarEmpleo(int opcion, String valorABuscar) {
        boolean encontro = false;
        // se recorre la lista
        for (OfertaLaboral ofertaLaboral : ofertasLaboralesList) {
            switch (opcion) {
                case 1:
                    if (valorABuscar.toLowerCase().equals(ofertaLaboral.getIndustria())) {
                        System.out.println(
                                "Código:" + ofertaLaboral.getCodigoOferta() + " - " + ofertaLaboral.getOferta());
                        encontro = true;
                    }
                    break;
                case 2:
                    if (valorABuscar.toLowerCase().equals(ofertaLaboral.getUbicacion())) {
                        System.out.println(
                                "Código:" + ofertaLaboral.getCodigoOferta() + " - " + ofertaLaboral.getOferta());
                        encontro = true;
                    }
                    break;
                case 3:
                    if (valorABuscar.toLowerCase().equals(ofertaLaboral.getTipoContrato())) {
                        System.out.println(
                                "Código:" + ofertaLaboral.getCodigoOferta() + " - " + ofertaLaboral.getOferta());
                        encontro = true;
                    }
                    break;
                default:
                    System.out.println("Código:" + ofertaLaboral.getCodigoOferta() + " - " + ofertaLaboral.getOferta());
                    encontro = true;
                    break;
            }
        }
        if (!encontro) {
            System.out.println("Lo sentimos, no hay ofertas laborales\n");
        } else {
            System.out.println("¿Deseas aplicar a esta oferta? (y/n)");
            String respuesta = scn.nextLine();
            if (respuesta.toLowerCase().equals("y")) {
                System.out.println("Ingresa el código de oferta");
                String codigoOferta = scn.nextLine();
                System.out.println("Ingresa tus calificaciones");
                String calificaciones = scn.nextLine();
                System.out.println("Ingresa tu experiencia");
                String experiencia = scn.nextLine();
                System.out.println("Ingresa tu nombre");
                String nombre = scn.nextLine();

                Aplicante aplicante = new Aplicante(codigoOferta, calificaciones, experiencia, nombre);
                // Se adiciona a la lista
                aplicanteList.add(aplicante);
                System.out.println("Gracias, pronto sabrás de nosotros");
            }
        }

        System.out.println("¿Deseas realizar otra búsqueda? (y/n)");
        String respuesta = scn.nextLine();
        if (respuesta.toLowerCase().equals("y")) {
            escogerOpcionEmpleo();
        } else {
            escogerOpcionesIngreso();
        }
    }

}
