package com.softtek.javatests.util;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class RomanNumeralsTest {

    @Test
    public void arabic_to_roman_1() {
        assertThat(RomanNumerals.arabicToRoman(1), is("I"));
    }

    @Test
    public void arabic_to_roman_2() {
        assertThat(RomanNumerals.arabicToRoman(2), is("II"));
    }

    @Test
    public void arabic_to_roman_3() {
        assertThat(RomanNumerals.arabicToRoman(3), is("III"));
    }

    @Test
    public void arabic_to_roman_5() {
        assertThat(RomanNumerals.arabicToRoman(5), is("V"));
    }

    @Test
    public void arabic_to_roman_6() {
        assertThat(RomanNumerals.arabicToRoman(6), is("VI"));
    }

    @Test
    public void arabic_to_roman_7() {
        assertThat(RomanNumerals.arabicToRoman(7), is("VII"));
    }

    @Test
    public void arabic_to_roman_10() {
        assertThat(RomanNumerals.arabicToRoman(10), is("X"));
    }

    @Test
    public void arabic_to_roman_11() {
        assertThat(RomanNumerals.arabicToRoman(11), is("XI"));
    }

    @Test
    public void arabic_to_roman_15() {
        assertThat(RomanNumerals.arabicToRoman(15), is("XV"));
    }

    @Test
    public void arabic_to_roman_16() {
        assertThat(RomanNumerals.arabicToRoman(16), is("XVI"));
    }

    @Test
    public void arabic_to_roman_50() {
        assertThat(RomanNumerals.arabicToRoman(50), is("L"));
    }

    @Test
    public void arabic_to_roman_51() {
        assertThat(RomanNumerals.arabicToRoman(51), is("LI"));
    }

    @Test
    public void arabic_to_roman_55() {
        assertThat(RomanNumerals.arabicToRoman(55), is("LV"));
    }

    @Test
    public void arabic_to_roman_56() {
        assertThat(RomanNumerals.arabicToRoman(56), is("LVI"));
    }

    @Test
    public void arabic_to_roman_60() {
        assertThat(RomanNumerals.arabicToRoman(60), is("LX"));
    }

    @Test
    public void arabic_to_roman_70() {
        assertThat(RomanNumerals.arabicToRoman(70), is("LXX"));
    }

    @Test
    public void arabic_to_roman_80() {
        assertThat(RomanNumerals.arabicToRoman(80), is("LXXX"));
    }

    @Test
    public void arabic_to_roman_81() {
        assertThat(RomanNumerals.arabicToRoman(81), is("LXXXI"));
    }

    @Test
    public void arabic_to_roman_85() {
        assertThat(RomanNumerals.arabicToRoman(85), is("LXXXV"));
    }

    @Test
    public void arabic_to_roman_86() {
        assertThat(RomanNumerals.arabicToRoman(86), is("LXXXVI"));
    }

    @Test
    public void arabic_to_roman_126() {
        assertThat(RomanNumerals.arabicToRoman(126), is("CXXVI"));
    }

    @Test
    public void arabic_to_roman_2507() {
        assertThat(RomanNumerals.arabicToRoman(2507), is("MMDVII"));
    }

    @Test
    public void arabic_to_roman_4() {
        assertThat(RomanNumerals.arabicToRoman(4), is("IV"));
    }

    @Test
    public void arabic_to_roman_9() {
        assertThat(RomanNumerals.arabicToRoman(9), is("IX"));
    }

    @Test
    public void arabic_to_roman_14() {
        assertThat(RomanNumerals.arabicToRoman(14), is("XIV"));
    }

    @Test
    public void arabic_to_roman_19() {
        assertThat(RomanNumerals.arabicToRoman(19), is("XIX"));
    }

    @Test
    public void arabic_to_roman_24() {
        assertThat(RomanNumerals.arabicToRoman(24), is("XXIV"));
    }

    @Test
    public void arabic_to_roman_40() {
        assertThat(RomanNumerals.arabicToRoman(40), is("XL"));
    }

    @Test
    public void arabic_to_roman_49() {
        assertThat(RomanNumerals.arabicToRoman(49), is("XLIX"));
    }

    @Test
    public void arabic_to_roman_90() {
        assertThat(RomanNumerals.arabicToRoman(90), is("XC"));
    }

    @Test
    public void arabic_to_roman_99() {
        assertThat(RomanNumerals.arabicToRoman(99), is("XCIX"));
    }

    @Test
    public void arabic_to_roman_400() {
        assertThat(RomanNumerals.arabicToRoman(400), is("CD"));
    }

    @Test
    public void arabic_to_roman_900() {
        assertThat(RomanNumerals.arabicToRoman(900), is("CM"));
    }

}