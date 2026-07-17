package com.ticketing.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.ticketing.enums.Currency;

public class MoneyTest {

    @Test
    void testEquality() {
        Money m1 = new Money(10.50, Currency.USD);
        Money m2 = new Money(10.50, Currency.USD);
        Money m3 = new Money(10.50, Currency.EUR);

        assertEquals(m1, m2);
        assertNotEquals(m1, m3);
    }

    @Test
    void testValidationThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Money(-5.00, Currency.USD);
        });
    }

    @Test
    void testAddition() {
        Money m1 = new Money(10.00, Currency.USD);
        Money m2 = new Money(5.50, Currency.USD);
        Money result = m1.add(m2);

        assertEquals(new Money(15.50, Currency.USD), result);
        assertEquals(10.00, m1.amount());
        assertEquals(Currency.USD, m1.currency());
    }
}