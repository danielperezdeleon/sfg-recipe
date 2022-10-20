package com.immutableant.sfgrecipe.repositories;

import com.immutableant.sfgrecipe.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {}
