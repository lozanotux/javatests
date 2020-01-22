package com.softtek.javatests.util;

import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;

public class StringUtilTest {

    @Test
    public void repeat_string_once() {
        Assert.assertEquals("hola", StringUtil.repeat("hola", 1));
    }

    @Test
    public void repeat_string_multiple_times() {
        Assert.assertEquals("holaholahola", StringUtil.repeat("hola", 3));
    }

    @Test
    public void repeat_string_zero_times() {
        Assert.assertEquals("", StringUtil.repeat("hola", 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void repeat_string_negative_times() {
        StringUtil.repeat("hola", -1);
    }

    @Test
    public void string_is_not_empty() {
        assertFalse(StringUtil.isEmpty("string cualquiera"));
    }

    @Test
    public void string_quoted_is_empty() {
        assertTrue(StringUtil.isEmpty(""));
    }

    @Test
    public void string_with_space_is_empty() {
        assertTrue(StringUtil.isEmpty(" "));
    }

    @Test
    public void string_null_is_empty() {
        assertTrue(StringUtil.isEmpty(new String()));
    }

}