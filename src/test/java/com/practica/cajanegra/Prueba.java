package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.NoSuchElementException;


import static org.junit.jupiter.api.Assertions.*;

public class Prueba {

    SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<>("A", "B", "C", "D", "E",
            "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
            "Y", "Z");
    SingleLinkedListImpl<String> badlist = new SingleLinkedListImpl<>("@", "B", "C", "D", "E",
            "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "o", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
            "Y", "1");
    SingleLinkedListImpl<String> emptyList = new SingleLinkedListImpl<>();

    @BeforeAll
    public static void startUp (){
        System.out.println("Inicializando test ------------------------------------------------\n");
        System.out.println("\tEjecutando test de cada método --------------------------------\n");
    }

    @Test
    @DisplayName("Método \"getAtPos\"")
    public void pruebaGetAtPos(){

        assertAll("Test \"indexOf\" lista completa y correcta",
                () -> assertThrows(IllegalArgumentException.class, () ->
                        mylist.getAtPos(0), "La predicción de la excepción ha fallado"),
                () -> assertEquals("A", mylist.getAtPos(1)),
                () -> assertEquals("B", mylist.getAtPos(2)),
                () -> assertEquals("O", mylist.getAtPos(16)),
                () -> assertEquals("Y", mylist.getAtPos(mylist.size() - 1)),
                () -> assertEquals("Z", mylist.getAtPos(mylist.size())),
                () -> assertThrows(IllegalArgumentException.class, () ->
                        mylist.getAtPos((mylist.size() + 1)), "La predicción de la excepción ha fallado")
        );

        assertThrows(IllegalArgumentException.class, () ->                  //excepción con lista vacía
                emptyList.getAtPos((1)), "La predicción de la excepción ha fallado"
        );
    }

    @Test
    @DisplayName("Método \"indexOf\"")
    public void pruebaIndexOf(){             //excepción: NoSuchElementException

        assertAll("Test \"indexOf\" lista completa y correcta",
                () -> assertThrows(NoSuchElementException.class, () ->
                        mylist.indexOf("@"), "La predicción de la excepción ha fallado"),
                () -> assertEquals(1, mylist.indexOf("A")),
                () -> assertEquals(2, mylist.indexOf("B")),
                () -> assertEquals(16, mylist.indexOf("O")),
                () -> assertEquals(mylist.size() - 1, mylist.indexOf("Y")),
                () -> assertEquals(mylist.size(), mylist.indexOf("Z")),
                () -> assertThrows(NoSuchElementException.class, () ->
                        mylist.indexOf("["), "La predicción de la excepción ha fallado")
        );

        assertThrows(NoSuchElementException.class, () ->
                emptyList.indexOf("A"), "La predicción de la excepción ha fallado"
        );

        assertThrows(NoSuchElementException.class, () ->
                badlist.indexOf("@"), "La predicción de la excepción ha fallado para un caracter ilegal"
        );

    }

    @AfterAll
    public static void shutDown(){
        System.out.println("\nTest finalizado ---------------------------------------------------\n");
    }
}
