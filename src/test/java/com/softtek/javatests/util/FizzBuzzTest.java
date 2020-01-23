package com.softtek.javatests.util;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class FizzBuzzTest {

    @Test
    public void fizz_if_number_is_divisible_by_3() {
        assertThat(FizzBuzz.fizzBuzz(9), is("Fizz"));
    }

    @Test
    public void buzz_if_number_is_divisible_by_5() {
        assertThat(FizzBuzz.fizzBuzz(25), is("Buzz"));
    }

    @Test
    public void fizzbuzz_if_number_is_divisible_by_3_and_5() {
        assertThat(FizzBuzz.fizzBuzz(15), is("FizzBuzz"));
    }

    @Test
    public void number_if_not_divisible_by_3_or_5() {
        assertThat(FizzBuzz.fizzBuzz(7), is("7"));
    }

}