package com.locusintellect;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CheckoutSystemTest {

    private CheckoutSystem underTest = new CheckoutSystem();

    @Test
    public void shouldReturnZeroPoundsForNullInput() {
        assertThat(underTest.checkout(null), is("£0"));
    }

    @Test
    public void shouldReturnZeroPoundsForEmptyItems() {
        assertThat(underTest.checkout(new String[0]), is("£0"));
    }

    @Test
    public void shouldCalculateAmountForMultipleItems() {
        final String[] items = new String[4];
        items[0] = "Apple";
        items[1] = "Apple";
        items[2] = "Orange";
        items[3] = "Apple";

        assertThat(underTest.checkout(items), is("£2.05"));
    }

    @Test
    public void shouldCalculateAmountForSingleItem() {
        final String[] items = new String[1];
        items[0] = "Apple";

        assertThat(underTest.checkout(items), is("£0.60"));
    }
}
