package com.teamnet.examples;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Claudiu.Marinescu on 7/10/2017.
 */
public class MyUnitTest {

    @Test
    public void testConcatenate() {
        MyUnit myUnit = new MyUnit();

        String result = myUnit.concatenate("one", "two");

        assertEquals("onetwo", result);

    }

    @Test
    public void testConcatenateNull() {
        MyUnit myUnit = new MyUnit();

        String result = myUnit.concatenate(null, null);

        assertEquals(null, result);

        result = myUnit.concatenate("one", null);

        assertNotNull(result);
        assertEquals("one", result);

        result = myUnit.concatenate(null, "one");

        assertNotNull(result);
        assertEquals("one", result);
    }

    @Test
    public void testGetBoolean() {
        MyUnit myUnit = new MyUnit();
        assertNotNull(myUnit.getBoolean());

        assertTrue((Boolean)myUnit.getBoolean() instanceof Boolean);

//        assertThat(myUnit.getBoolean(), is(true));
    }
}
