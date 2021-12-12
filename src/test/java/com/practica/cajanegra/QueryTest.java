package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.*;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

public class QueryTest {

    SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<>("A", "B", "C", "D", "E",
            "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
            "Y", "Z");
    SingleLinkedListImpl<String> badlist = new SingleLinkedListImpl<>("@", "B", "C", "D", "E",
            "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "o", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
            "Y", "1");
    SingleLinkedListImpl<String> emptyList = new SingleLinkedListImpl<>();
    SingleLinkedListImpl<String> list = new SingleLinkedListImpl<>("A");
    SingleLinkedListImpl<String> list1 = new SingleLinkedListImpl<>("A", "B");

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
                badlist.indexOf("@"), "La predicción de la excepción ha fallado para caracter ilegal"
        );

    }

    @Test
    @DisplayName("Metodo isEmpty")
    public void testisEmpty(){

        assertAll("test isEmpty",
                ()-> assertFalse(list.isEmpty()),
                ()-> assertFalse(list1.isEmpty()),
                ()-> assertFalse(mylist.isEmpty()),
                ()-> assertTrue(emptyList.isEmpty())
        );
    }

    @Test
    @DisplayName("Método size")
    public void testSize(){

        assertAll("test size",
                ()-> assertEquals(1,list.size()),
                ()-> assertEquals(2,list1.size()),
                ()->{ SingleLinkedListImpl<String> list2 = new SingleLinkedListImpl<>("A", "B", "C", "D", "E",
                        "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O"); assertEquals(16,list2.size());},
                ()->{ SingleLinkedListImpl<String> list3 = new SingleLinkedListImpl<>("A", "B", "C", "D", "E",
                        "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
                        "Y"); assertEquals(26,list3.size());},
                ()-> assertEquals(27,mylist.size()),
                ()-> assertEquals(0,emptyList.size())
        );
    }

    @Test
    @DisplayName("Método isSubList")
    public void testisSubList(){

        assertAll("test isSubList",
                ()->{ SingleLinkedListImpl<String> parte = new SingleLinkedListImpl<>("@"); assertEquals(-1,mylist.isSubList(parte));},
                ()->{ SingleLinkedListImpl<String> parte1 = new SingleLinkedListImpl<>("A");  assertEquals(1,mylist.isSubList(parte1));},
                ()->{ SingleLinkedListImpl<String> parte2 = new SingleLinkedListImpl<>("B"); assertEquals(2,mylist.isSubList(parte2));},
                ()->{ SingleLinkedListImpl<String> parte3 = new SingleLinkedListImpl<>("O", "P"); assertEquals(16,mylist.isSubList(parte3));},
                ()->{ SingleLinkedListImpl<String> parte4 = new SingleLinkedListImpl<>("Y"); assertEquals(26,mylist.isSubList(parte4));},
                ()->{ SingleLinkedListImpl<String> parte5 = new SingleLinkedListImpl<>("Z"); assertEquals(27,mylist.isSubList(parte5)); },
                ()->{ SingleLinkedListImpl<String> parte6 = new SingleLinkedListImpl<>("["); assertEquals(-1,mylist.isSubList(parte6));},
                ()-> assertEquals(0,mylist.isSubList(emptyList))
        );
    }

    @Test
    @DisplayName("Método toString")
    public void testtoString(){
        SingleLinkedListImpl<String> part = new SingleLinkedListImpl<>("@");

        assertAll("test toString",
                ()-> assertEquals("[@]", part.toString()),
                ()-> assertEquals("[A]",list.toString()),
                ()-> assertEquals("[A, B]",list1.toString()),
                ()-> assertEquals("[]",emptyList.toString())
        );
    }

    @AfterAll
    public static void shutDown(){
        System.out.println("\nTest finalizado ---------------------------------------------------\n");
    }
}
