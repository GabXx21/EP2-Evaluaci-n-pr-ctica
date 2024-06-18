import java.util.ArrayList;

public class Parqueadero {
    private int cantidadPuestos;
    private ArrayList<Puesto> puestos;
    private double tarifaHora;
    private double TarifaMinuto;
    private int horaActual;

    public Parqueadero(int cantidadPuestos) {
        this.cantidadPuestos = cantidadPuestos;
        this.puestos = new ArrayList<>();
        for (int i = 1; i <= cantidadPuestos; i++) {
            this.puestos.add(new Puesto(i));
        }
    }

    public void setTarifa(double tarifaHora) {
        this.tarifaHora = tarifaHora + TarifaMinuto;
    }
    public void Tarifanueva(double TarifaMinuto){
        this.TarifaMinuto = TarifaMinuto;
    }

    public void setHoraActual(int horaActual) {
        this.horaActual = horaActual;
    }

    public void ingresarCarro(String placa, int horaEntrada) {
        if (getPuestosDisponibles() > 0 | getPuestosDisponibles() <= 5 ) {
            for (Puesto puesto : puestos) {
                if (!puesto.estaOcupado()) {
                    puesto.ocuparPuesto(placa, horaEntrada);
                    break;
                }
            }
        } else {
            System.out.println("No hay puestos disponibles en este momento.");
        }
    }

    public void darSalidaCarro(String placa, int horaSalida) {
        for (Puesto puesto : puestos) {
            if (puesto.getCarro() != null && puesto.getCarro().getPlaca().equals(placa)) {
                int tiempoParqueo = horaSalida - puesto.getHoraEntrada();
                double costo = calcularCosto(tiempoParqueo);
                puesto.desocuparPuesto();
                System.out.println("El carro con placa " + placa + " salió del parqueadero. Total a pagar: $" + costo);
                break;
            }
        }
    }

    private double calcularCosto(int tiempoParqueo) {
        double costo = Math.ceil(tiempoParqueo * tarifaHora + TarifaMinuto);
        return costo;
    }

    public void avanzarReloj(int nuevaHora) {
        if (nuevaHora < horaActual) {
            System.out.println("Error: La nueva hora no puede ser menor que la hora actual.");
        } else {
            horaActual = nuevaHora;
            System.out.println("Reloj del parqueadero avanzado a las " + horaActual + " horas.");
        }
    }

    public int getPuestosDisponibles() {
        int disponibles = 0;
        for (Puesto puesto : puestos) {
            if (!puesto.estaOcupado()) {
                disponibles++;
            }
        }
        return disponibles;
    }

    public double getIngresos() {
        double ingresos = 0;
        for (Puesto puesto : puestos) {
            if (puesto.getCarro() != null) {
                int tiempoParqueo = horaActual - puesto.getHoraEntrada();
                ingresos += calcularCosto(tiempoParqueo);
            }
        }
        return ingresos;
    }
}
