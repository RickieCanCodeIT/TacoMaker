package org.wecancodeit.TacoMaker;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Taco {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String shell;

    @ManyToOne
    private Topping topping;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getShell() {
        return shell;
    }

    public Topping getTopping() {
        return topping;
    }

    public Taco(String name, String shell, Topping topping) {
        this.name = name;
        this.shell = shell;
        this.topping = topping;
    }

    protected Taco() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Taco taco = (Taco) o;
        return Objects.equals(id, taco.id) && Objects.equals(name, taco.name) && Objects.equals(shell, taco.shell) && Objects.equals(topping, taco.topping);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, shell, topping);
    }
}
