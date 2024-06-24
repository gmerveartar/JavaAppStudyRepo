package org.csystem.util.string;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

// @Ignore("Tested before and passed")
public class StringUtilAreAnagramNullPointerExceptionTest {

    @Test
    public void test1()
    {
        Assert.assertThrows(NullPointerException.class, () -> StringUtil.areAnagram(null,"ankara"));
    }
    @Test
    public void test2()
    {
        Assert.assertThrows(NullPointerException.class, () -> StringUtil.areAnagram("ankara",null));
    }
    @Test
    public void test3()
    {
        Assert.assertThrows(NullPointerException.class, () -> StringUtil.areAnagram(null, null));
    }
}
