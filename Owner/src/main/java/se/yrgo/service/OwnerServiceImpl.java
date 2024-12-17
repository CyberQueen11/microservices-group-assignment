package se.yrgo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.yrgo.data.OwnerRepository;
import se.yrgo.domain.OwnerEntity;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public List<OwnerEntity> getAllOwners() {
        return ownerRepository.findAll();
    }

    @Override
    public OwnerEntity createOwner(OwnerEntity owner) {
        // Additional business logic or validation can be added here
        return ownerRepository.save(owner);
    }

    @Override
    public boolean deleteOwner(OwnerEntity owner) {
        if (ownerRepository.existsById(owner.getId())) {
            ownerRepository.deleteById(owner.getId());
            return true;
        }
        return false;
    }

    @Override
    public boolean updateOwner(OwnerEntity owner) {
        if (ownerRepository.existsById(owner.getId())) {
            ownerRepository.save(owner);
            return true;
        }
        return false;
    }
}