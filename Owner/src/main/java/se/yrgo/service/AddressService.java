package se.yrgo.service;

import se.yrgo.domain.AddressEntity;
import se.yrgo.domain.OwnerEntity;

import java.util.List;


public interface AddressService {
    List<AddressEntity> getAllAddresses();

    public AddressEntity registerAddress(AddressEntity address);
}
