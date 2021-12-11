package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;


public class Add {

    private SingleLinkedListImpl<String> mylist;
    private SingleLinkedListImpl<String> listvacia;

    @BeforeEach
    public void iniciarLista(){
        mylist = new SingleLinkedListImpl<String>("A", "B", "C", "D");
    }
    /*--------------------------Test AddFirst-----------------------*/
    @ParameterizedTest(name = "Añade {0} al inicio de la lista")
    @ValueSource( strings ={"A","B","M","N","Z"})
    public void testAddFirstValid(String elem){
        mylist.addFirst(elem);
        assertEquals("[" + elem+", A, B, C, D]",mylist.toString());
    }

    @ParameterizedTest(name = "Añade {0} al inicio de la lista")
    @ValueSource( strings ={"[","@"})
    public void testAddFirstInvalid(String elem){
        assertThrows(IllegalArgumentException.class,()->{mylist.addFirst(elem);});
    }

    /*--------------------------Test AddLast-----------------------*/
    @ParameterizedTest(name = "Añade {0} al final de la lista")
    @ValueSource( strings ={"A","B","M","N","Z"})
    public void testAddLastValid(String elem){
        mylist.addLast(elem);
        assertEquals("[A, B, C, D, "+ elem+ "]",mylist.toString());
    }

    @ParameterizedTest(name = "Añade {0} al inicio de la lista")
    @ValueSource( strings ={"[","@"})
    public void testAddLastInvalid(String elem){
        mylist.addFirst(elem);
        assertThrows(IllegalArgumentException.class,()->{mylist.addLast(elem);});
    }

    /*--------------------------Test AddAtPos-----------------------*/
    @ParameterizedTest(name = "Añade en la posicion {0} de la lista: {1}")
    @CsvSource(value = {
            "1: A: [A, A, B, C, D]",
            "1: B: [B, A, B, C, D]",
            "1: M: [M, A, B, C, D]",
            "1: Y: [Y, A, B, C, D]",
            "1: Z: [Z, A, B, C, D]",

            "2: A: [A, A, B, C, D]",
            "2: B: [A, B, B, C, D]",
            "2: M: [A, M, B, C, D]",
            "2: Y: [A, Y, B, C, D]",
            "2: Z: [A, Z, B, C, D]",

            "4: A: [A, B, C, A, D]",
            "4: B: [A, B, C, B, D]",
            "4: M: [A, B, C, M, D]",
            "4: Y: [A, B, C, Y, D]",
            "4: Z: [A, B, C, Z, D]",

            "5: A: [A, B, C, D, A]",
            "5: B: [A, B, C, D, B]",
            "5: M: [A, B, C, D, M]",
            "5: Y: [A, B, C, D, Y]",
            "5: Z: [A, B, C, D, Z]",

            "6: A: [A, B, C, D, A]",
            "6: B: [A, B, C, D, B]",
            "6: M: [A, B, C, D, M]",
            "6: Y: [A, B, C, D, Y]",
            "6: Z: [A, B, C, D, Z]"

    }, delimiter=':')
    public void testAddAtPosValid(int pos, String elem, String expected){
        mylist.addAtPos(elem,pos);
        assertEquals(expected,mylist.toString());
    }

    @ParameterizedTest(name = "Error al añadir en la posicion {0} de la lista: {1}")
    @CsvSource(value = {
            "0: A",
            "0: B",
            "0: M",
            "0: Y",
            "0: Z",
            "-1: M"
    }, delimiter = ':')
    public void testAddAtPosInvalidPos(int pos,String elem) {

        assertThrows(IllegalArgumentException.class, () -> {
            mylist.addAtPos(elem, pos);
        });
    }

    @ParameterizedTest(name = "Error al añadir en la posicion {0} de la lista: {1}")
    @CsvSource(value = {
            "1: @",
            "1: ]",
            "2: @",
            "2: ]",
            "4: @",
            "4: ]",
            "5: @",
            "5: ]",
            "6: @",
            "6: ]"
    }, delimiter = ':')
    public void testAddAtPosInvalidElem(int pos,String elem) {

        assertThrows(IllegalArgumentException.class, () -> {
            mylist.addAtPos(elem, pos);
        });
    }

    /*--------------------------Test AddNTimes----------------------*/
    @ParameterizedTest(name = "Añade {0} veces al final de la lista: {1}")
    @CsvSource(value = {
            "0: A: [A, B, C, D]",
            "0: B: [A, B, C, D]",
            "0: M: [A, B, C, D]",
            "0: Y: [A, B, C, D]",
            "0: Z: [A, B, C, D]",

            "1: A: [A, B, C, D, A]",
            "1: B: [A, B, C, D, B]",
            "1: M: [A, B, C, D, M]",
            "1: Y: [A, B, C, D, Y]",
            "1: Z: [A, B, C, D, Z]",

            "2: A: [A, B, C, D, A, A]",
            "2: B: [A, B, C, D, B, B]",
            "2: M: [A, B, C, D, M, M]",
            "2: Y: [A, B, C, D, Y, Y]",
            "2: Z: [A, B, C, D, Z, Z]",

            "5: A: [A, B, C, D, A, A, A, A, A]",
            "5: B: [A, B, C, D, B, B, B, B, B]",
            "5: M: [A, B, C, D, M, M, M, M, M]",
            "5: Y: [A, B, C, D, Y, Y, Y, Y, Y]",
            "5: Z: [A, B, C, D, Z, Z, Z, Z, Z]",

    }, delimiter=':')
    public void testAddNTimesValid(int n, String elem, String expected){
        mylist.addNTimes(elem,n);
        assertEquals(expected,mylist.toString());
    }

    @ParameterizedTest(name = "Error al añadir {0} veces en la lista: {1}")
    @CsvSource(value = {
            "-1: A",
            "-1: B",
            "-1: M",
            "-1: Y",
            "-1: Z"
    }, delimiter = ':')
    public void testAddNTimesInvalidN(int n,String elem) {

        assertThrows(IllegalArgumentException.class, () -> {
            mylist.addNTimes(elem, n);
        });
    }

    @ParameterizedTest(name = "Error al añadir {0} veces en la lista: {1}")
    @CsvSource(value = {
            "1: @",
            "1: ]",
            "2: @",
            "2: ]",
            "5: @",
            "5: ]"
    }, delimiter = ':')
    public void testAddNTimesInvalidElem(int pos,String elem) {

        assertThrows(IllegalArgumentException.class, () -> {
            mylist.addNTimes(elem, pos);
        });
    }
}
