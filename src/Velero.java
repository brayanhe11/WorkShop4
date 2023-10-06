public class Velero extends Embarcacion implements Validacion {
    private int cantidadMastiles;

    public Velero(Capitan capitan, double precioBase, int añoFabricacion, double eslora, int cantidadMastiles) {
        super(capitan, precioBase, añoFabricacion, eslora);
        this.cantidadMastiles = cantidadMastiles;
    }

    // Implementación de la interfaz Validacion para Velero
    public void validar() {
        if (cantidadMastiles > 4) {
            System.out.println("Este velero es grande.");
        } else {
            System.out.println("Este velero es estándar.");
        }
    }

    public int getCantidadMastiles() {
        return cantidadMastiles;
    }

    public void setCantidadMastiles(int cantidadMastiles) {
        this.cantidadMastiles = cantidadMastiles;
    }
}
