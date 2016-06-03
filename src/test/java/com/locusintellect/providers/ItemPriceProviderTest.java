package com.locusintellect.providers;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class ItemPriceProviderTest {

    private ItemPriceProvider underTest = new ItemPriceProvider();

    @Test
    public void shouldProvidePriceForExistingItem() {
        assertThat(underTest.provideCostInPence("Apple"), is(new BigDecimal(60)));
    }

    @Test
    public void shouldReturnNullForNonExistingItems() {
        assertThat(underTest.provideCostInPence("SomethingNonExistent"), is(nullValue()));
    }
}
