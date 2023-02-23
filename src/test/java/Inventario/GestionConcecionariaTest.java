package Inventario;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GestionConcecionariaTest {
    private Concecionaria concecionaria;
    private Auto auto;
    private int resta;
    private int cantidadAutos=10;
    private int descuento=5;
    @DisplayName("Añadir Concecionaria")
    @Test
    @Order(1)
    public void añadirConcecionaria(){
        concecionaria = new Concecionaria("Fiat", "Av.Cordoba 1500", 1990, 200);
        Assertions.assertEquals(concecionaria, concecionaria);
        System.out.println("Test Ok, " + concecionaria);
    }

    @DisplayName("Añadir Auto")
    @Test
    @Order(2)
    public void añadirAuto(){
        auto = new Auto( "Cronos", 5,150,10);
        Assertions.assertEquals(new Auto("Argo", 5,100,20), auto);
        System.out.println("Test Ok, "+auto);
    }
    @DisplayName("Elimar Auto")
    @Test
    @Order(3)
    public void eliminarAuto(){
        resta = cantidadAutos - descuento;
        Assertions.assertEquals(5, resta);
        System.out.println("Test Ok, "+cantidadAutos+ " autos - " +descuento+ " = " +resta + " Autos.");
    }

}
