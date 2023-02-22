package Inventario;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GestionConcecionariaTest {
    private Concecionaria concecionaria;
    private Auto auto;
    private int resta;
    private int cantidadAutos=10;
    private int descuento=5;
    @DisplayName("Añadir Concecionaria")
    @Test
    public void addConcecionaria(){
        concecionaria = new Concecionaria("Fiat", "Av.Cordoba 1500", 1990, 200);
        System.out.println("Test ok " + concecionaria);
    }

    @DisplayName("Añadir Auto")
    @Test
    public void addAuto(){
        auto = new Auto( "Cronos", 5,150,10);
        System.out.println("Test ok "+auto);
    }
    @DisplayName("Elimar Auto")
    @Test
    public void eliminarAuto(){
        resta = cantidadAutos - descuento;
        System.out.println("Test ok, "+cantidadAutos+ " autos - " +descuento+ " = " +resta + " Autos.");
    }
//revisar spanglish
}
