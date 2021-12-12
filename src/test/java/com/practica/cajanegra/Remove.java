package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.*;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

public class Remove {

    SingleLinkedListImpl<String> mylist = new SingleLinkedListImpl<>("A", "B", "C", "D", "E",
            "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
            "Y", "Z");
    SingleLinkedListImpl<String> badlist = new SingleLinkedListImpl<>("@", "B", "C", "D", "E",
            "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "o", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
            "Y", "1");
    SingleLinkedListImpl<String> emptyList = new SingleLinkedListImpl<>();
    SingleLinkedListImpl<String> list = new SingleLinkedListImpl<>("A");
    SingleLinkedListImpl<String> list1 = new SingleLinkedListImpl<>("A", "B");


}