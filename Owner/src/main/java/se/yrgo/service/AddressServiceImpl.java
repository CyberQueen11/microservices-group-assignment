package se.yrgo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.yrgo.data.AddressRepository;
import se.yrgo.domain.AddressEntity;
import se.yrgo.domain.OwnerEntity;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<AddressEntity> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public AddressEntity registerAddress(AddressEntity address) {
        // Additional business logic or validation can be added here
        return addressRepository.save(address);
    }

    @Override
    public boolean deleteAddress(AddressEntity address) {
        if (addressRepository.existsById(address.getId())) {
            addressRepository.deleteById(address.getId());
            return true;
        }
        return false;
    }

    @Override
    public boolean updateAddress(AddressEntity address) {
        if (addressRepository.existsById(address.getId())) {
            addressRepository.save(address);
            return true;
        }
        return false;
    }
}