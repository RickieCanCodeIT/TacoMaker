package org.wecancodeit.TacoMaker;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ToppingRepository extends CrudRepository<Topping,Long> {

    Optional<Topping> findById(Long id);

    Optional<Topping> findByToppingType(String toppingType);
}
