public class Yate extends Embarcacion implements Validacion{
    private int cantidadCamarotes;

    public Yate(Capitan capitan, double precioBase, int añoFabricacion, double eslora, int cantidadCamarotes) {
        super(capitan, precioBase, añoFabricacion, eslora);
        this.cantidadCamarotes = cantidadCamarotes;
    }

    // Implementación de la interfaz Validacion para Yate
    public void validar() {
        if (cantidadCamarotes > 7) {
            System.out.println("Este yate es de lujo.");
        } else {
            System.out.println("Este yate es estándar.");
        }
    }

    public int getCantidadCamarotes() {
        return cantidadCamarotes;
    }

    public void setCantidadCamarotes(int cantidadCamarotes) {
        this.cantidadCamarotes = cantidadCamarotes;
    }
}
