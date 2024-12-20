package se.yrgo.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.yrgo.domain.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}