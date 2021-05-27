package org.wecancodeit.TacoMaker;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Topping {

    @Id
    @GeneratedValue
    private Long id;

    private String toppingType;

    @OneToMany(mappedBy = "topping")
    private Collection<Taco> tacos;

    public Long getId() {
        return id;
    }

    public String getToppingType() {
        return toppingType;
    }

    public Collection<Taco> getTacos() {
        return tacos;
    }

    public Topping(String toppingType) {
        this.toppingType = toppingType;
    }

    protected Topping() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topping topping = (Topping) o;
        return Objects.equals(id, topping.id) && Objects.equals(toppingType, topping.toppingType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, toppingType);
    }
}
