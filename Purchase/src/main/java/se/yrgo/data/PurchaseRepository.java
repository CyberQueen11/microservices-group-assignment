package se.yrgo.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.yrgo.domain.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {


}