package org.wecancodeit.TacoMaker;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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

    public Taco(String name, String shell, Topping topping) {
        this.name = name;
        this.shell = shell;
        this.topping = topping;
    }

    protected Taco() {}
}
