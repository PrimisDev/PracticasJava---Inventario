package Inventario;

public class Auto {
    private static int id_automerado = 1;
    private String modelo;
    private int nroAsientos;
    private double velocidadMaxima;
    private int cantidadAutos;
    public int idAuto;

    public Auto(String modelo, int nroAsientos, double velocidadMaxima, int cantidadAutos) {
        this.idAuto = id_automerado++;
        this.modelo = modelo;
        this.nroAsientos = nroAsientos;
        this.velocidadMaxima = velocidadMaxima;
        this.cantidadAutos= cantidadAutos;
    }

    public int getId() {
        return idAuto;
    }

    public static int getId_automerado() {
        return id_automerado;
    }

    public static void setId_automerado(int id_automerado) {
        Auto.id_automerado = id_automerado;
    }

    public void setId(int id) {
        this.idAuto = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getNroAsientos() {
        return nroAsientos;
    }

    public void setNroAsientos(int nroAsientos) {
        this.nroAsientos = nroAsientos;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public int getCantidadAutos() {
        return cantidadAutos;
    }

    public void setCantidadAutos(int cantidadAutos) {
        this.cantidadAutos = cantidadAutos;
    }

    @Override
    public boolean equals(Object u) {
        if (this == u) return true;
        if (u == null || getClass() != u.getClass()) return false;
        Auto that = (Auto) u;
        return idAuto == that.idAuto;
    }

    @Override
    public String toString() {
        return "Auto con id " + this.idAuto + ": "+
                "modelo " + modelo +
                ", con " + nroAsientos + " asientos"+
                ", y una velocidad maxima de " + velocidadMaxima +
                " km/h." +
                " Y un stock de: " +cantidadAutos+ " autos";
    }
}

