package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@RunWith(MockitoJUnitRunner.class)
public class LionClassMockTest {
    private Lion lion;

    @Mock
    Feline feline;

    @Test
    public void testGetKittens() throws Exception {
        lion = new Lion("Самец", feline);
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void testGetFood()  throws Exception {
        lion = new Lion("Самка", feline);
        lion.getFood();
        Mockito.verify(feline).getFood(Mockito.anyString());
    }

    @Test
    public void testUnsupportedSex() {
        Throwable throwable = catchThrowable(() -> {
            lion = new Lion("unsupportedSex", feline);
        });

        assertThat(throwable).isInstanceOf(Exception.class).hasMessage("Используйте допустимые значения пола животного - самей или самка");
    }
}
