package se.yrgo.service;

import se.yrgo.domain.OwnerEntity;

import java.util.List;


public interface OwnerService {
    List<OwnerEntity> getAllOwners();

    public OwnerEntity createOwner(OwnerEntity user);
}
