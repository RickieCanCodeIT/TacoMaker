package org.wecancodeit.TacoMaker;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

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

    public Topping(String toppingType) {
        this.toppingType = toppingType;
    }

    protected Topping() {}
}
