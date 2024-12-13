package se.yrgo.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.yrgo.domain.OwnerEntity;

@Repository
public interface OwnerRepository extends JpaRepository<OwnerEntity, Long> {
    // Additional queries can be added here if needed
}