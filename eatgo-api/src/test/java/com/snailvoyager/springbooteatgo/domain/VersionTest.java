package com.snailvoyager.springbooteatgo.domain;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.assertj.core.api.Assertions.assertThat;

public class VersionTest {
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void test1() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("version must not be null!");

        Version version = new Version(null);
    }

    @Test
    public void test2() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("version must match");

        Version version = new Version("1.k.3-SNAPSHOT");
    }

    @Test
    public void test3() {
        Version version = new Version("3.5");
    }

    @Test
    public void test4() {
        Version version = new Version("1.2.3-SNAPSHOT");
    }

    @Test
    public void test5() {
        Version version = new Version("1.2.3-SNAPSHOT");
//        Assert.assertTrue(version.isSnapshot());
        assertThat(version.isSnapshot()).isTrue();

        Version version2 = new Version("1.2.3");
//        Assert.assertFalse(version2.isSnapshot());
        assertThat(version2.isSnapshot()).isFalse();
    }

}
