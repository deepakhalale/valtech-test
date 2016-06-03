package com.locusintellect;

import com.locusintellect.offers.OfferCalculator;
import com.locusintellect.providers.ItemPriceProvider;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.fail;

public class CheckoutSystemTest {

    private CheckoutSystem underTest;

    @Before
    public void setUp() {
        final ItemPriceProvider itemPriceProvider = new ItemPriceProvider();
        underTest = new CheckoutSystem(itemPriceProvider, new OfferCalculator(itemPriceProvider));
    }

    @Test
    public void shouldReturnZeroPoundsForNullInput() {
        assertThat(underTest.checkout(null, null), is("£0"));
    }

    @Test
    public void shouldReturnZeroPoundsForEmptyItems() {
        assertThat(underTest.checkout(new String[0], null), is("£0"));
    }

    @Test
    public void shouldCalculateAmountForMultipleItems() {
        final String[] items = new String[4];
        items[0] = "Apple";
        items[1] = "Apple";
        items[2] = "Orange";
        items[3] = "Apple";

        assertThat(underTest.checkout(items, null), is("£2.05"));
    }

    @Test
    public void shouldCalculateAmountForSingleItem() {
        final String[] items = new String[1];
        items[0] = "Apple";

        assertThat(underTest.checkout(items, null), is("£0.60"));
    }

    @Test
    public void shouldFailWhenCostOfAnItemCouldNotBeFound() {
        final String[] items = new String[1];
        items[0] = "Banana";

        try {
            underTest.checkout(items, null);
            fail("Expected exception to be thrown");
        } catch (final MissingPriceException e) {
            assertThat(e.getMessage(), is("Price missing for item Banana"));
        }
    }
}
