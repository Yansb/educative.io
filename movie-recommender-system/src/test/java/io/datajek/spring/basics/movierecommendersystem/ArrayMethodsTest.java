package io.datajek.spring.basics.movierecommendersystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayMethodsTest {

    @Test
    public void testfindIndex_numberInArray() {
        final var arrayMethods = new ArrayMethods();
        int result = arrayMethods.findIndex(new int[]{1, 2, 3}, 3);
        assertEquals(2, result);
    }


    @Test
    public void testfindIndex_numberNotInArray() {
        ArrayMethods arrayMethods = new ArrayMethods();
        assertEquals(-1, arrayMethods.findIndex(new int[]{8, 4, 5}, 1));
    }

    @Test
    public void testfindIndex_emptyArray() {
        ArrayMethods arrayMethods = new ArrayMethods();
        assertEquals(-1, arrayMethods.findIndex(new int[]{}, 1));
    }
}