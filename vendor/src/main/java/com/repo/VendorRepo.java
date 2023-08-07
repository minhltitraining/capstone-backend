package com.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.Vendor;

@Repository
public interface VendorRepo extends CrudRepository<Vendor, Long> {
	public Optional<Vendor> findVendorByUserName(String userName);
}
