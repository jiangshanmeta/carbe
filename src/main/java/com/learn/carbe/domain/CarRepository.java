package com.learn.carbe.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
    List<Car> findByBrand(String brand);

    List<Car> findByColor(String color);

    List<Car> findByModelYear(int modelYear);

    List<Car> findByBrandAndColor(String brand, String color);

    List<Car> findByBrandOrColor(String brand, String color);
}
