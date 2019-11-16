package com.evolutionnext.functions;

import java.util.Objects;
import java.util.StringJoiner;

public class TaxRate {
    private final int year;
    private final double taxRate;

    public TaxRate(int year, double taxRate) {
        this.year = year;
        this.taxRate = taxRate;
    }

    public double apply(int subtotal) {
        return (subtotal * taxRate) + subtotal;
    }

    public int getYear() {
        return year;
    }

    public double getTaxRate() {
        return taxRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxRate taxRate1 = (TaxRate) o;
        return year == taxRate1.year &&
            Double.compare(taxRate1.taxRate, taxRate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, taxRate);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TaxRate.class.getSimpleName() + "[", "]")
            .add("year=" + year)
            .add("taxRate=" + taxRate)
            .toString();
    }
}
