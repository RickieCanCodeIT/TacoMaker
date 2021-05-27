package org.wecancodeit.TacoMaker;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.annotation.Resource;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class JpaWiringTest {

    @Autowired
    private TestEntityManager entityManager;

    @Resource
    private ToppingRepository toppingRepo;

    @Resource
    private TacoRepository tacoRepo;

    @Test
    public void TacoToppingShouldReturnListofTacos() {
        Topping topping1 = new Topping("Beef");
        Topping topping2 = new Topping("Chicken");
        toppingRepo.save(topping1);
        toppingRepo.save(topping2);

        Taco taco1 = new Taco("Cheesy Gordita Crunch", "Both", topping1);
        Taco taco2 = new Taco("Regular Taco", "Hard Shell", topping1);
        Taco taco3 = new Taco("Chicken Wrap", "Soft Shell", topping2);
        tacoRepo.save(taco1);
        tacoRepo.save(taco2);
        tacoRepo.save(taco3);

        //make sure sql/dbs are clean and aligned
        entityManager.flush();
        entityManager.clear();

        //does taco toppping return list
        Optional<Topping> foundTopping = toppingRepo.findById(topping1.getId());
        Topping foundToppingType = foundTopping.get();

        assertThat(foundToppingType.getTacos()).contains(taco1, taco2);
    }
}
