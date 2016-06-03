package com.locusintellect;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CheckoutSystem {

    private static final Map<String, BigDecimal> itemsToCostInPenceMap = new HashMap<>();

    static {
        itemsToCostInPenceMap.put("Apple", new BigDecimal(60));
        itemsToCostInPenceMap.put("Orange", new BigDecimal(25));
    }



    public String checkout(final String[] items) {
        BigDecimal finalAmount = new BigDecimal(0);

        if (items == null || items.length == 0) {
            return "£0";
        }

        for (String item : items) {
            finalAmount = finalAmount.add(itemsToCostInPenceMap.get(item));
        }

        return "£" + convertPenceToPounds(finalAmount).toPlainString();
    }

    private BigDecimal convertPenceToPounds(final BigDecimal amountInPence) {
        return amountInPence.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_EVEN);
    }
}
