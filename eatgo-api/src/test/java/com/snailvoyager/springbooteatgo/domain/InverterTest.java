package com.snailvoyager.springbooteatgo.domain;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class InverterTest {

    @Test
    public void shouldInvert() {
        String inverted = Inverter.invert(null);

//        Assert.assertEquals("", Inverter.invert(null));
//        Assert.assertEquals( "a", Inverter.invert("a"));
//        Assert.assertEquals("dcba", Inverter.invert("abcd"));

        assertThat(Inverter.invert(null)).isEqualTo("");
        assertThat(Inverter.invert("a")).isEqualTo("a");
        assertThat(Inverter.invert("abcd")).isEqualTo("dcba");
    }
}
