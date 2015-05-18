package com.aoeng.anima;

import android.app.Application;
import android.test.ApplicationTestCase;

import junit.framework.Assert;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void testStr(){
        String str1 = "test";
        String str2 = "Testhhhh";

        Assert.assertEquals(str1,str2);
    }
}