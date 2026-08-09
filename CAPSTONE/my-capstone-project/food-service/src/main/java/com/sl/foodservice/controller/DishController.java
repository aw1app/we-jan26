package com.sl.foodservice.controller;

import com.sl.foodservice.model.Dish;
import com.sl.foodservice.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dishes")
@CrossOrigin(origins = "*")
public class DishController {

    @Autowired
    private DishRepository dishRepository;

    @GetMapping
    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    @GetMapping("/restaurant/{restaurantId}")
    public List<Dish> getDishesByRestaurant(@PathVariable String restaurantId) {
        return dishRepository.findByRestaurantId(restaurantId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dish> getDishById(@PathVariable String id) {
        return dishRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Dish addDish(@RequestBody Dish dish) {
        return dishRepository.save(dish);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dish> updateDish(@PathVariable String id, @RequestBody Dish dish) {
        return dishRepository.findById(id)
                .map(existing -> {
                    existing.setName(dish.getName());
                    existing.setDescription(dish.getDescription());
                    existing.setPrice(dish.getPrice());
                    existing.setIngredients(dish.getIngredients());
                    existing.setRating(dish.getRating());
                    return ResponseEntity.ok(dishRepository.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDish(@PathVariable String id) {
        if (dishRepository.existsById(id)) {
            dishRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

