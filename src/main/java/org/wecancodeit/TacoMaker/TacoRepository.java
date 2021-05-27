package org.wecancodeit.TacoMaker;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TacoRepository extends CrudRepository<Taco, Long> {
    Optional<Taco> findByName(String name);
}
