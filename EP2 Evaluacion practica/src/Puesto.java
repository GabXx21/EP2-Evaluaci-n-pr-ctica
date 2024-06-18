public class Puesto {
    private int numero;
    private Carro carro;

    public Puesto(int numero) {
        this.numero = numero;
        this.carro = null;
    }

    public void ocuparPuesto(String placa, int horaEntrada) {
        this.carro = new Carro(placa, horaEntrada);
        System.out.println("El carro con placa " + placa + " ha sido estacionado en el puesto " + numero);
    }

    public void desocuparPuesto() {
        this.carro = null;
    }

    public boolean estaOcupado() {
        return carro != null;
    }

    public Carro getCarro() {
        return carro;
    }

    public int getHoraEntrada() {
        if (carro != null) {
            return carro.getHoraEntrada();
        }
        return -1;
    }
}
