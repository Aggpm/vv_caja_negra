package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.NoSuchElementException;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class Add {


    @Test
    public void testAddFirst(){

        assertAll("test addFirst",
                ()->{ SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B", "C", "D");assertThrows(IllegalArgumentException.class,()->{mylist.addFirst("@");});},
                ()->{ SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addFirst("A");assertEquals("[A, A, B, C, D]",mylist.toString());},
                ()->{ SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addFirst("B");assertEquals("[B, A, B, C, D]",mylist.toString());},
                ()->{ SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addFirst("M");assertEquals("[M, A, B, C, D]",mylist.toString());},
                ()->{ SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addFirst("Y");assertEquals("[Y, A, B, C, D]",mylist.toString());},
                ()->{ SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addFirst("Z");assertEquals("[Z, A, B, C, D]",mylist.toString());},
                ()->{ SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");assertThrows(IllegalArgumentException.class,()->{mylist.addFirst("[");});},
                ()->{ SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>();mylist.addFirst("A");assertEquals("[A]",mylist.toString());}
                );
    }

    @Test
    @DisplayName("Prueba addAtPos ")
    public void testAddAtPos(){
        assertAll("Test addAtPos",
                ()-> assertAll("test addAtPos con p=-1 y p=0",
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");assertThrows(IllegalArgumentException.class,()->{mylist.addAtPos("M",-1);});},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");assertThrows(IllegalArgumentException.class,()->mylist.addAtPos("@",0));},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");assertThrows(IllegalArgumentException.class,()->mylist.addAtPos("A",0));},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");assertThrows(IllegalArgumentException.class,()->mylist.addAtPos("B",0));},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");assertThrows(IllegalArgumentException.class,()->mylist.addAtPos("M",0));},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");assertThrows(IllegalArgumentException.class,()->mylist.addAtPos("Y",0));},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");assertThrows(IllegalArgumentException.class,()->mylist.addAtPos("Z",0));},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");assertThrows(IllegalArgumentException.class,()->mylist.addAtPos("[",0));}
                    ),
                ()-> assertAll("test addAtpos con p=1",
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");assertThrows(IllegalArgumentException.class,()->{mylist.addAtPos("@",1);});},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addAtPos("A",1);assertEquals("[A, A, B, C, D]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addAtPos("B",1);assertEquals("[B, A, B, C, D]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addAtPos("M",1);assertEquals("[M, A, B, C, D]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addAtPos("Y",1);assertEquals("[Y, A, B, C, D]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addAtPos("Z",1);assertEquals("[Z, A, B, C, D]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");assertThrows(IllegalArgumentException.class,()->{mylist.addAtPos("[",1);});}
                    ),
                ()-> assertAll("test addAtpos con p=2",
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");assertThrows(IllegalArgumentException.class,()->{mylist.addAtPos("@",2);});},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addAtPos("A",2);assertEquals("[A, A, B, C, D]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addAtPos("B",2);assertEquals("[A, B, B, C, D]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addAtPos("M",2);assertEquals("[A, M, B, C, D]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addAtPos("Y",2);assertEquals("[A, Y, B, C, D]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addAtPos("Z",2);assertEquals("[A, Z, B, C, D]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");assertThrows(IllegalArgumentException.class,()->{mylist.addAtPos("[",2);});}
                    ),
                ()-> assertAll("test addAtpos con p=4",
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");assertThrows(IllegalArgumentException.class,()->{mylist.addAtPos("@",4);});},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addAtPos("A",4);assertEquals("[A, B, C, A, D]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addAtPos("B",4);assertEquals("[A, B, C, B, D]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addAtPos("M",4);assertEquals("[A, B, C, M, D]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addAtPos("Y",4);assertEquals("[A, B, C, Y, D]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addAtPos("Z",4);assertEquals("[A, B, C, Z, D]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");assertThrows(IllegalArgumentException.class,()->{mylist.addAtPos("[",4);});}
                    ),
                ()-> assertAll("test addAtpos con p=5",
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");assertThrows(IllegalArgumentException.class,()->{mylist.addAtPos("@",5);});},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addAtPos("A",5);assertEquals("[A, B, C, D, A]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addAtPos("B",5);assertEquals("[A, B, C, D, B]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addAtPos("M",5);assertEquals("[A, B, C, D, M]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addAtPos("Y",5);assertEquals("[A, B, C, D, Y]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addAtPos("Z",5);assertEquals("[A, B, C, D, Z]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");assertThrows(IllegalArgumentException.class,()->{mylist.addAtPos("[",5);});}
                    ),
                ()-> assertAll("test addAtpos con p=6",
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");assertThrows(IllegalArgumentException.class,()->{mylist.addAtPos("@",6);});},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addAtPos("A",6);assertEquals("[A, B, C, D, A]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addAtPos("B",6);assertEquals("[A, B, C, D, B]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addAtPos("M",6);assertEquals("[A, B, C, D, M]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addAtPos("Y",6);assertEquals("[A, B, C, D, Y]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addAtPos("Z",6);assertEquals("[A, B, C, D, Z]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");assertThrows(IllegalArgumentException.class,()->{mylist.addAtPos("[",6);});}
                    ),
                ()->assertAll("test addAtpos con lista vacia",
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>();mylist.addAtPos("A",1);assertEquals("[A]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>();mylist.addAtPos("B",2);assertEquals("[B]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>();assertThrows(IllegalArgumentException.class,()->mylist.addAtPos("A",0));}
                )

        );
    }
    @Test
    public void testAddLast(){

        assertAll("test addLast",
                ()->{ SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addLast("@");assertEquals("[A, B, C, D]",mylist.toString());},
                ()->{ SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B", "C", "D");assertThrows(IllegalArgumentException.class,()->{mylist.addLast("@");});},
                ()->{ SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addLast("A");assertEquals("[A, B, C, D, A]",mylist.toString());},
                ()->{ SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addLast("B");assertEquals("[A, B, C, D, B]",mylist.toString());},
                ()->{ SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addLast("M");assertEquals("[A, B, C, D, M]",mylist.toString());},
                ()->{ SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addLast("Y");assertEquals("[A, B, C, D, Y]",mylist.toString());},
                ()->{ SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addLast("Z");assertEquals("[A, B, C, D, Z]",mylist.toString());},
                ()->{ SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addLast("[");assertEquals("[A, B, C, D]",mylist.toString());},
                ()->{ SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");assertThrows(IllegalArgumentException.class,()->{mylist.addLast("[");});},
                ()->{ SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");assertThrows(IllegalArgumentException.class,()->{mylist.addLast("");});}
        );
    }
    @Test
    @DisplayName("Prueba addNTimes")
    public void pruebaT(){
        SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String > ("A", "B","C","D");
        System.out.println(mylist.toString());
        mylist.addNTimes("@",5);
        System.out.println(mylist.toString());
    }
    @Test
    @DisplayName("Prueba addNTimes")
    public void testAddNTimes(){
        assertAll("Test addAtPos",

                ()-> assertAll("test addNtimes con n=0",
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");assertThrows(IllegalArgumentException.class,()->{mylist.addNTimes("",0);});},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");assertThrows(IllegalArgumentException.class,()->{mylist.addNTimes("@",0);});},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");assertThrows(IllegalArgumentException.class,()->{mylist.addNTimes("A",0);});},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");assertThrows(IllegalArgumentException.class,()->{mylist.addNTimes("B",0);});},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");assertThrows(IllegalArgumentException.class,()->{mylist.addNTimes("M",0);});},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");assertThrows(IllegalArgumentException.class,()->{mylist.addNTimes("Y",0);});},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");assertThrows(IllegalArgumentException.class,()->{mylist.addNTimes("Z",0);});},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");assertThrows(IllegalArgumentException.class,()->{mylist.addNTimes("[",0);});}
                ),
                ()-> assertAll("test addNtimes con n=1",
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");assertThrows(IllegalArgumentException.class,()->{mylist.addNTimes("",1);});},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addNTimes("@",1);assertEquals("[A, B, C, D]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");assertThrows(IllegalArgumentException.class,()->{mylist.addNTimes("@",1);});},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addNTimes("A",1);assertEquals("[A, B, C, D, A]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addNTimes("B",1);assertEquals("[A, B, C, D, B]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addNTimes("M",1);assertEquals("[A, B, C, D, M]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addNTimes("Y",1);assertEquals("[A, B, C, D, Y]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addNTimes("Z",1);assertEquals("[A, B, C, D, Z]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addNTimes("[",1);assertEquals("[A, B, C, D]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");assertThrows(IllegalArgumentException.class,()->{mylist.addNTimes("[",1);});}
                ),
                ()-> assertAll("test addNTimes para n=2",
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");assertThrows(IllegalArgumentException.class,()->{mylist.addNTimes("",2);});},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addNTimes("@",2);assertEquals("[A, B, C, D]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");assertThrows(IllegalArgumentException.class,()->{mylist.addNTimes("@",2);});},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addNTimes("A",2);assertEquals("[A, B, C, D, A, A]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addNTimes("B",2);assertEquals("[A, B, C, D, B, B]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addNTimes("M",2);assertEquals("[A, B, C, D, M, M]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addNTimes("Y",2);assertEquals("[A, B, C, D, Y, Y]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addNTimes("Z",2);assertEquals("[A, B, C, D, Z, Z]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addNTimes("[",2);assertEquals("[A, B, C, D]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");assertThrows(IllegalArgumentException.class,()->mylist.addNTimes("[",2));}
                ),
                ()-> assertAll("test addNtimes con n=5",
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");assertThrows(IllegalArgumentException.class,()->{mylist.addNTimes("",5);});},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addNTimes("@",5);assertEquals("[A, B, C, D]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");assertThrows(IllegalArgumentException.class,()->{mylist.addNTimes("@",5);});},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addNTimes("A",5);assertEquals("[A, B, C, D, A, A, A, A, A]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addNTimes("B",5);assertEquals("[A, B, C, D, B, B, B, B, B]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addNTimes("M",5);assertEquals("[A, B, C, D, M, M, M, M, M]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addNTimes("Y",5);assertEquals("[A, B, C, D, Y, Y, Y, Y, Y]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addNTimes("Z",5);assertEquals("[A, B, C, D, Z, Z, Z, Z, Z]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");mylist.addNTimes("[",5);assertEquals("[A, B, C, D]",mylist.toString());},
                        ()->{SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<String>("A", "B","C","D");assertThrows(IllegalArgumentException.class,()->{mylist.addNTimes("[",5);});}
                )
        );
    }


}
