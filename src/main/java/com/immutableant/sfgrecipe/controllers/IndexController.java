package com.immutableant.sfgrecipe.controllers;

import com.immutableant.sfgrecipe.domain.Category;
import com.immutableant.sfgrecipe.domain.UnitOfMeasure;
import com.immutableant.sfgrecipe.repositories.CategoryRepository;
import com.immutableant.sfgrecipe.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"","/","/index"})
    public String getindexPage() {
        System.out.println("Some Message to say... ");

        Optional<Category> categoryOptional =categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional =unitOfMeasureRepository.findByUom("Teaspoon");

        System.out.println("Category id is: " + categoryOptional.get().getId());
        System.out.println("UOM id is: " + unitOfMeasureOptional.get().getId());

        return "index";
    }
}
