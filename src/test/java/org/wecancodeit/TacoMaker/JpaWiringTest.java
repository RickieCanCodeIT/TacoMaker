package org.wecancodeit.TacoMaker;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class JpaWiringTest {

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void TacoToppingShouldReturnListofTacos() {
        Topping topping = new Topping("Beef");
        Taco taco = new Taco("Cheesy Gordita Crunch", "Both", topping);
    }
}
