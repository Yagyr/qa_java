package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineClassMockTest {

    @Spy
    Feline feline;

    @Test
    public void testEatMeat() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void testGetFamily() {
        String actual = feline.getFamily();
        Mockito.verify(feline, Mockito.times(1)).getFamily();

        assertEquals("Кошачьи", actual);
    }

    @Test
    public void testGetKittens() {
        int actual = feline.getKittens();
        Mockito.verify(feline).getKittens(1);

        assertEquals(1, actual);
    }

    @Test
    public void testGetKittensWithParameters() {
        int actual = feline.getKittens(5);
        Mockito.verify(feline).getKittens(Mockito.anyInt());

        assertEquals(5, actual);
    }
}
