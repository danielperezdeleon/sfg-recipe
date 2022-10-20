package com.immutableant.sfgrecipe.repositories;

import com.immutableant.sfgrecipe.domain.Category;
import com.immutableant.sfgrecipe.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
    Optional<UnitOfMeasure> findByUom(String uom);
}
