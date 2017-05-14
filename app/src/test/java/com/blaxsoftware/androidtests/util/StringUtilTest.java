package com.blaxsoftware.androidtests.util;

import com.blaxsoftware.androidtests.util.rule.StringTestRule;

import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author fpalonso
 */
public class StringUtilTest {

    @Rule
    public StringTestRule testRule = new StringTestRule();

    @Test
    public void concat_returnsGreeting() {
        assertThat(StringUtil.concat("Hey guys, ", "what is going on"),
                is("Hey guys, what is going on"));
        System.out.println("By the way... this is running within the StringTestRule");
    }

}