package com.practica.cajanegra;

import com.cajanegra.EmptyCollectionException;
import com.cajanegra.SingleLinkedList;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

public class RemoveTest {

    SingleLinkedListImpl<String>mylist = new SingleLinkedListImpl<>("A", "B", "M", "Y", "Z");
    SingleLinkedListImpl<String>badlist = new SingleLinkedListImpl<>("A", "B", "@", "[", "Z");
    SingleLinkedListImpl<String>emptyList = new SingleLinkedListImpl<>();

    @BeforeEach
    public void iniciarLista(){
        mylist = new SingleLinkedListImpl<String>("A", "B", "M", "Y", "Z");
    }

    @ParameterizedTest(name = "Elimina el ultimo elemento de la lista")
    @ValueSource( strings ={"A","B","M","Y","Z"})
    public void testRemoveLastValid() throws EmptyCollectionException {
        mylist.removeLast();
        assertEquals("[A, B, M, Y]",mylist.toString());
    }

    @ParameterizedTest(name = "Elimina el ultimo elemento de la lista")
    @ValueSource( strings ={"A","B","M","Y","Z"})
    public void testRemoveLastInvalid() throws EmptyCollectionException {
        emptyList.removeLast();
        assertEquals("[]",emptyList.toString());
    }

    /*--------------------------Test RemoveLast (String elem)-----------------------*/
    @ParameterizedTest(name = "Elimina la última aparición de {0}")
    @CsvSource(value = {
            "A:  [B, M, Y, Z]",
            "B:  [A, M, Y, Z]",
            "M:  [A, B, Y, Z]",
            "Y:  [A, B, M, Z]",
            "Z:  [A, B, M, Y]",
    }, delimiter=':')

    public void testRemoveLastValid(String elem, String expected) throws NoSuchElementException, EmptyCollectionException {
        mylist.removeLast(elem);
        assertEquals(expected,mylist.toString());
    }

    @ParameterizedTest(name = "Error al eliminar el elemento no valido {0}")
    @ValueSource( strings ={"@","["})
    public void testRemoveLastInvalid(String elem) {
        assertThrows(IllegalArgumentException.class, () -> {
            badlist.removeLast(elem);
        });
    }

}

