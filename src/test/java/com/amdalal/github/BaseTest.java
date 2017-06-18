package com.amdalal.github;

import org.junit.Before;

public abstract class BaseTest {

    @Before
    public void before() {
        ResultHolder.clear();
    }
}
