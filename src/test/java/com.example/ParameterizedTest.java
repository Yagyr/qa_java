package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedTest {
    private String sex;
    private boolean result;
    private Lion lion;
    private Feline feline;

    @Before
    public void setUp() {
        feline = Mockito.mock(Feline.class);
    }

    public ParameterizedTest(String sex, boolean result) {
        this.sex = sex;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void checkSexLion() throws Exception {
        lion = new Lion(sex, feline);
        boolean actual = lion.doesHaveMane();

        assertEquals(result, actual);
    }
}
