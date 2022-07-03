package com.evolutionnext.generics.people;

import java.util.Objects;

public class American extends NorthAmerican {
    private String ssn;

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        American american = (American) o;
        return Objects.equals(ssn, american.ssn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ssn);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("American{");
        sb.append("ssn='").append(ssn).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
