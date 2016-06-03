package com.locusintellect.providers;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ItemPriceProvider {

    private static final Map<String, BigDecimal> itemToCostInPenceMap = new HashMap<>();

    static {
        itemToCostInPenceMap.put("Apple", new BigDecimal(60));
        itemToCostInPenceMap.put("Orange", new BigDecimal(25));
    }

    public BigDecimal provideCostInPence(final String item) {
        return itemToCostInPenceMap.get(item);
    }
}
