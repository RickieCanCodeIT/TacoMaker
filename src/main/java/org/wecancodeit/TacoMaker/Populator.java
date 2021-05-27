package org.wecancodeit.TacoMaker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Populator implements CommandLineRunner {

    @Resource
    private ToppingRepository toppingRepo;

    @Resource
    private TacoRepository tacoRepo;


    @Override
    public void run(String... args) throws Exception {
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
    }
}
