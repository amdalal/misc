package com.amdalal.github.problems.majorityelement;

import org.junit.Test;

import com.amdalal.github.BaseTest;
import com.amdalal.github.problems.majorityelement.impl.MajorityElementHashtableImpl;

import junit.framework.Assert;

public class TestMajorityElementHashtableImpl extends BaseTest {

    @Test
    public void test1() {
        int[] data = { 1, 1, 2, 3, 1, 1 };
        Assert.assertEquals(Integer.valueOf(1), new MajorityElementHashtableImpl().getMajorityElement(data));
    }

    @Test
    public void test2() {
        int[] data = { 1, 1, 2, 3 };
        Assert.assertEquals(null, new MajorityElementHashtableImpl().getMajorityElement(data));
    }

    @Test
    public void test3() {
        int[] data = { 1, 2, 3 };
        Assert.assertEquals(null, new MajorityElementHashtableImpl().getMajorityElement(data));
    }
}
