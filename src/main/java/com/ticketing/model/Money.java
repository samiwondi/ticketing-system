package com.ticketing.model;

import com.ticketing.enums.Currency;

public record Money(double amount, Currency currency) {

    public Money {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative: " + amount);
        }
    }

    public Money add(Money other) {
        if (this.currency != other.currency) {
            throw new IllegalArgumentException("Cannot add different currencies: "
                    + this.currency + " and " + other.currency);
        }
        return new Money(this.amount + other.amount, this.currency);
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", amount, currency.name());
    }
}