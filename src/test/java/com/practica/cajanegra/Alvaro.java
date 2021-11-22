package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;

public class Alvaro {


    @Test
    public void testAddFirst(){

        assertAll("test addFirst",
                ()->{ SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B", "C", "D");assertThrows(IllegalArgumentException.class,()->{mylist.addFirst("@");});},
                ()->{ SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addFirst("A");assertEquals("[A, A, B, C, D]",mylist.toString());},//tostring
                ()->{ SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addFirst("B");assertEquals("[B, A, B, C, D]",mylist.toString());},
                ()->{ SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addFirst("M");assertEquals("[M, A, B, C, D]",mylist.toString());},
                ()->{ SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addFirst("Y");assertEquals("[Y, A, B, C, D]",mylist.toString());},
                ()->{ SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addFirst("Z");assertEquals("[Z, A, B, C, D]",mylist.toString());},
                ()->{ SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");assertThrows(IllegalArgumentException.class,()->{mylist.addFirst("[");});}
                );
    }
    //falta lista vacia
    @Test
    @DisplayName("Prueba addAtPos -1")
    public void testAddAtPos1(){
        SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");
        assertThrows(IllegalArgumentException.class,()->{mylist.addAtPos("M",-1);});
    }

    @Test
    @DisplayName("Prueba addAtPos 0")
    public void testAddAtPos2(){
        SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");
        assertAll("test addAtpos",
                ()->{assertThrows(IllegalArgumentException.class,()->mylist.addAtPos("@",0));},
                ()->{assertThrows(IllegalArgumentException.class,()->mylist.addAtPos("A",0));},
                ()->{assertThrows(IllegalArgumentException.class,()->mylist.addAtPos("B",0));},
                ()->{assertThrows(IllegalArgumentException.class,()->mylist.addAtPos("M",0));},
                ()->{assertThrows(IllegalArgumentException.class,()->mylist.addAtPos("Y",0));},
                ()->{assertThrows(IllegalArgumentException.class,()->mylist.addAtPos("Z",0));},
                ()->{assertThrows(IllegalArgumentException.class,()->mylist.addAtPos("[",0));}
        );


    }

    @Test
    @DisplayName("Prueba addAtPos 1")
    public void testAddAtPos3(){
        SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");
        assertAll("test addAtpos",
                ()->{mylist.addAtPos("@",1);assertEquals("@",mylist.getAtPos(1));},
                ()->{mylist.addAtPos("A",1);assertEquals("A",mylist.getAtPos(1));},
                ()->{mylist.addAtPos("B",1);assertEquals("B",mylist.getAtPos(1));},
                ()->{mylist.addAtPos("M",1);assertEquals("M",mylist.getAtPos(1));},
                ()->{mylist.addAtPos("Y",1);assertEquals("Y",mylist.getAtPos(1));},
                ()->{mylist.addAtPos("Z",1);assertEquals("Z",mylist.getAtPos(1));},
                ()->{mylist.addAtPos("[",1);assertEquals("[",mylist.getAtPos(1));}
        );
    }
    @Test
    @DisplayName("Prueba addAtPos 2")
    public void testAddAtPos4(){
        SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");
        assertAll("test addAtpos",
                ()->{mylist.addAtPos("@",2);assertEquals("@",mylist.getAtPos(2));},
                ()->{mylist.addAtPos("A",2);assertEquals("A",mylist.getAtPos(2));},
                ()->{mylist.addAtPos("B",2);assertEquals("B",mylist.getAtPos(2));},
                ()->{mylist.addAtPos("M",2);assertEquals("M",mylist.getAtPos(2));},
                ()->{mylist.addAtPos("Y",2);assertEquals("Y",mylist.getAtPos(2));},
                ()->{mylist.addAtPos("Z",2);assertEquals("Z",mylist.getAtPos(2));},
                ()->{mylist.addAtPos("[",2);assertEquals("[",mylist.getAtPos(2));}
        );
    }
    @Test
    @DisplayName("Prueba addAtPos 4")
    public void testAddAtPos5(){
        SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");
        assertAll("test addAtpos",
                ()->{mylist.addAtPos("@",4);assertEquals("@",mylist.getAtPos(4));},
                ()->{mylist.addAtPos("A",4);assertEquals("A",mylist.getAtPos(4));},
                ()->{mylist.addAtPos("B",4);assertEquals("B",mylist.getAtPos(4));},
                ()->{mylist.addAtPos("M",4);assertEquals("M",mylist.getAtPos(4));},
                ()->{mylist.addAtPos("Y",4);assertEquals("Y",mylist.getAtPos(4));},
                ()->{mylist.addAtPos("Z",4);assertEquals("Z",mylist.getAtPos(4));},
                ()->{mylist.addAtPos("[",4);assertEquals("[",mylist.getAtPos(4));}
        );
    }
    @Test
    @DisplayName("Prueba addAtPos 5")
    public void testAddAtPos6(){
        SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");
        assertAll("test addAtpos",
                ()->{mylist.addAtPos("@",5);assertEquals("@",mylist.getAtPos(5));},
                ()->{mylist.addAtPos("A",5);assertEquals("A",mylist.getAtPos(5));},
                ()->{mylist.addAtPos("B",5);assertEquals("B",mylist.getAtPos(5));},
                ()->{mylist.addAtPos("M",5);assertEquals("M",mylist.getAtPos(5));},
                ()->{mylist.addAtPos("Y",5);assertEquals("Y",mylist.getAtPos(5));},//tostring
                ()->{mylist.addAtPos("Z",5);assertEquals("Z",mylist.getAtPos(5));},
                ()->{mylist.addAtPos("[",5);assertEquals("[",mylist.getAtPos(5));}
        );
    }
    @Test
    @DisplayName("Prueba addAtPos 6")
    public void testAddAtPos7(){
        SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");
        assertAll("test addAtpos",
                ()->{mylist.addAtPos("@",6);assertEquals("@",mylist.getAtPos(5));},
                ()->{mylist.addAtPos("A",6);assertEquals("A",mylist.getAtPos(5));},
                ()->{mylist.addAtPos("B",6);assertEquals("B",mylist.getAtPos(5));},
                ()->{mylist.addAtPos("M",6);assertEquals("M",mylist.getAtPos(5));},
                ()->{mylist.addAtPos("Y",6);assertEquals("Y",mylist.getAtPos(5));},
                ()->{mylist.addAtPos("Z",6);assertEquals("Z",mylist.getAtPos(5));},
                ()->{mylist.addAtPos("[",6);assertEquals("[",mylist.getAtPos(5));}
        );
    }

}
