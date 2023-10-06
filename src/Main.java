import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Embarcacion> embarcaciones = new ArrayList<>();
        ArrayList<Capitan> capitanes = new ArrayList<>();

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar una embarcación");
            System.out.println("2. Agregar un capitán");
            System.out.println("3. Ver embarcaciones disponibles");
            System.out.println("4. Calcular valor del alquiler");
            System.out.println("5. Asignar capitán a una embarcación");
            System.out.println("6. Ver especificaciones y justificación del precio");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la línea en blanco

            switch (opcion) {
                case 1:
                    System.out.println("Seleccione el tipo de embarcación:");
                    System.out.println("1. Velero");
                    System.out.println("2. Yate");
                    int tipoEmbarcacion = scanner.nextInt();
                    scanner.nextLine(); // Consumir la línea en blanco

                    if (tipoEmbarcacion == 1 || tipoEmbarcacion == 2) {
                        System.out.print("Ingrese el nombre del capitán: ");
                        String nombreCapitan = scanner.nextLine();
                        System.out.print("Ingrese el apellido del capitán: ");
                        String apellidoCapitan = scanner.nextLine();
                        System.out.print("Ingrese la matrícula de navegación del capitán: ");
                        String matriculaCapitan = scanner.nextLine();

                        System.out.print("Ingrese el precio base de la embarcación: ");
                        double precioBase = scanner.nextDouble();
                        System.out.print("Ingrese el año de fabricación de la embarcación: ");
                        int añoFabricacion = scanner.nextInt();
                        System.out.print("Ingrese la eslora de la embarcación en metros: ");
                        double eslora = scanner.nextDouble();

                        Capitan capitan = new Capitan(nombreCapitan, apellidoCapitan, matriculaCapitan);
                        capitanes.add(capitan);

                        if (tipoEmbarcacion == 1) {
                            System.out.print("Ingrese la cantidad de mástiles del velero: ");
                            int cantidadMastiles = scanner.nextInt();
                            Velero velero = new Velero(capitan, precioBase, añoFabricacion, eslora, cantidadMastiles);
                            embarcaciones.add(velero);
                            System.out.println("Velero agregado con éxito.");
                        } else {
                            System.out.print("Ingrese la cantidad de camarotes del yate: ");
                            int cantidadCamarotes = scanner.nextInt();
                            Yate yate = new Yate(capitan, precioBase, añoFabricacion, eslora, cantidadCamarotes);
                            embarcaciones.add(yate);
                            System.out.println("Yate agregado con éxito.");
                        }
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del capitán: ");
                    String nombreCapitan = scanner.nextLine();
                    System.out.print("Ingrese el apellido del capitán: ");
                    String apellidoCapitan = scanner.nextLine();
                    System.out.print("Ingrese la matrícula de navegación del capitán: ");
                    String matriculaCapitan = scanner.nextLine();

                    Capitan capitan = new Capitan(nombreCapitan, apellidoCapitan, matriculaCapitan);
                    capitanes.add(capitan);
                    System.out.println("Capitán agregado con éxito.");
                    break;
                case 3:
                    System.out.println("Embarcaciones disponibles:");
                    for (int i = 0; i < embarcaciones.size(); i++) {
                        System.out.println(i + 1 + ". " + embarcaciones.get(i).getClass().getSimpleName());
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el número de la embarcación: ");
                    int numEmbarcacion = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consumir la línea en blanco

                    if (numEmbarcacion >= 0 && numEmbarcacion < embarcaciones.size()) {
                        Embarcacion embarcacion = embarcaciones.get(numEmbarcacion);
                        double montoAlquiler = embarcacion.calcularMontoAlquiler();

                        System.out.println("Especificaciones de la embarcación:");
                        System.out.println("Tipo: " + embarcacion.getClass().getSimpleName());
                        System.out.println("Eslora: " + embarcacion.getEslora() + " metros");

                        System.out.println("Justificación del precio:");
                        System.out.println("Precio base: $" + embarcacion.getPrecioBase());
                        System.out.println("Año de fabricación: " + embarcacion.getAñoFabricacion());
                        if (embarcacion.getAñoFabricacion() > 2020) {
                            System.out.println("Valor adicional por año de fabricación (2021 o posterior): $20,000");
                        }

                        System.out.println("Monto del alquiler total: $" + montoAlquiler);
                    } else {
                        System.out.println("Número de embarcación no válido.");
                    }
                    break;
                case 5:
                    System.out.print("Ingrese el número de la embarcación: ");
                    int numEmbarcacionAsignar = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consumir la línea en blanco

                    if (numEmbarcacionAsignar >= 0 && numEmbarcacionAsignar < embarcaciones.size()) {
                        if (capitanes.isEmpty()) {
                            System.out.println("No hay capitanes disponibles.");
                        } else {
                            System.out.println("Capitanes disponibles:");
                            for (int i = 0; i < capitanes.size(); i++) {
                                System.out.println(i + 1 + ". " + capitanes.get(i).getNombre() + " " + capitanes.get(i).getApellido());
                            }
                            System.out.print("Seleccione el número del capitán a asignar: ");
                            int numCapitan = scanner.nextInt() - 1;
                            scanner.nextLine(); // Consumir la línea en blanco

                            if (numCapitan >= 0 && numCapitan < capitanes.size()) {
                                embarcaciones.get(numEmbarcacionAsignar).setCapitan(capitanes.get(numCapitan));
                                System.out.println("Capitán asignado con éxito.");
                            } else {
                                System.out.println("Número de capitán no válido.");
                            }
                        }
                    } else {
                        System.out.println("Número de embarcación no válido.");
                    }
                    break;
                case 6:
                    System.out.print("Ingrese el número de la embarcación: ");
                    int numEmbarcacionMostrar = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consumir la línea en blanco

                    if (numEmbarcacionMostrar >= 0 && numEmbarcacionMostrar < embarcaciones.size()) {
                        Embarcacion embarcacionMostrar = embarcaciones.get(numEmbarcacionMostrar);

                        System.out.println("Especificaciones de la embarcación:");
                        System.out.println("Tipo: " + embarcacionMostrar.getClass().getSimpleName());
                        System.out.println("Eslora: " + embarcacionMostrar.getEslora() + " metros");

                        System.out.println("Justificación del precio:");
                        System.out.println("Precio base: $" + embarcacionMostrar.getPrecioBase());
                        System.out.println("Año de fabricación: " + embarcacionMostrar.getAñoFabricacion());
                        if (embarcacionMostrar.getAñoFabricacion() > 2020) {
                            System.out.println("Valor adicional por año de fabricación (2021 o posterior): $20,000");
                        }

                    } else {
                        System.out.println("Número de embarcación no válido.");
                    }
                    break;
                case 7:
                    System.out.println("¡Hasta luego!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
