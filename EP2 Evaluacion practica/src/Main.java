import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Parqueadero parqueadero = new Parqueadero(5);

        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    ingresarTarifaInicial(parqueadero, scanner);
                    break;
                case 2:
                    ingresarHoraInicial(parqueadero, scanner);
                    break;
                case 3:
                    ingresarCarro(parqueadero, scanner);
                    break;
                case 4:
                    darSalidaCarro(parqueadero, scanner);
                    break;
                case 5:
                    mostrarIngresos(parqueadero);
                    break;
                case 6:
                    mostrarPuestosDisponibles(parqueadero);
                    break;
                case 7:
                    avanzarReloj(parqueadero, scanner);
                    break;
                case 8:
                    cambiarTarifa(parqueadero, scanner);
                    break;
                case 9:

                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor ingrese un número del 0 al 9.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n------ MENÚ DE OPCIONES ------");
        System.out.println("1. Ingresar la tarifa inicial");
        System.out.println("2. Ingresar la hora inicial del parqueadero");
        System.out.println("3. Ingresar un carro al parqueadero");
        System.out.println("4. Dar salida a un carro del parqueadero");
        System.out.println("5. Informar los ingresos del parqueadero");
        System.out.println("6. Consultar la cantidad de puestos disponibles");
        System.out.println("7. Avanzar el reloj del parqueadero");
        System.out.println("8. Cambiar la tarifa del parqueadero");
        System.out.println("9. Realizar cálculos de tiempo");
        System.out.println("0. Salir");
        System.out.print("Ingrese su opción: ");
    }

    private static void ingresarTarifaInicial(Parqueadero parqueadero, Scanner scanner) {
        System.out.print("Ingrese la tarifa inicial por hora: ");
        double  tarifaInicial = scanner.nextDouble();
        parqueadero.setTarifa(tarifaInicial);
    }

    private static void ingresarHoraInicial(Parqueadero parqueadero, Scanner scanner) {
        System.out.print("Ingrese la hora inicial del parqueadero (formato 24 horas): ");
        int horaInicial = scanner.nextInt();
        parqueadero.setHoraActual(horaInicial);
    }

    private static void ingresarCarro(Parqueadero parqueadero, Scanner scanner) {
        System.out.print("Ingrese la placa del carro: ");
        String placa = scanner.nextLine();
        System.out.print("Ingrese la hora de entrada del carro (formato 24 horas): ");
        int horaEntrada = scanner.nextInt();
        parqueadero.ingresarCarro(placa, horaEntrada);
    }

    private static void darSalidaCarro(Parqueadero parqueadero, Scanner scanner) {
        System.out.print("Ingrese la placa del carro que va a salir: ");
        String placa = scanner.nextLine();
        System.out.print("Ingrese la hora de salida del carro (formato 24 horas): ");
        int horaSalida = scanner.nextInt();
        parqueadero.darSalidaCarro(placa, horaSalida);
    }

    private static void mostrarIngresos(Parqueadero parqueadero) {
        System.out.println("Los ingresos totales del parqueadero son: $" + parqueadero.getIngresos());
    }

    private static void mostrarPuestosDisponibles(Parqueadero parqueadero) {
        System.out.println("Cantidad de puestos disponibles: " + parqueadero.getPuestosDisponibles());
    }

    private static void avanzarReloj(Parqueadero parqueadero, Scanner scanner) {
        System.out.print("Ingrese la nueva hora del parqueadero (formato 24 horas): ");
        int nuevaHora = scanner.nextInt();
        parqueadero.avanzarReloj(nuevaHora);

    }

    private static void cambiarTarifa(Parqueadero parqueadero, Scanner scanner) {
        System.out.print("Ingrese la nueva tarifa por hora: ");
        double nuevaTarifa = scanner.nextDouble();
        parqueadero.setTarifa(nuevaTarifa);
    }
}