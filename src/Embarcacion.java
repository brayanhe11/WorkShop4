public class Embarcacion {
    private Capitan capitan;
    private double precioBase;
    private int añoFabricacion;
    private double eslora;

    public Embarcacion(Capitan capitan, double precioBase, int añoFabricacion, double eslora) {
        this.capitan = capitan;
        this.precioBase = precioBase;
        this.añoFabricacion = añoFabricacion;
        this.eslora = eslora;
    }

    // Método para calcular el monto del alquiler
    public double calcularMontoAlquiler() {
        double montoAlquiler = precioBase;
        if (añoFabricacion > 2020) {
            montoAlquiler += 20000;
        }
        return montoAlquiler;
    }

    public Capitan getCapitan() {
        return capitan;
    }

    public void setCapitan(Capitan capitan) {
        this.capitan = capitan;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public int getAñoFabricacion() {
        return añoFabricacion;
    }

    public void setAñoFabricacion(int añoFabricacion) {
        this.añoFabricacion = añoFabricacion;
    }

    public double getEslora() {
        return eslora;
    }

    public void setEslora(double eslora) {
        this.eslora = eslora;
    }
}
