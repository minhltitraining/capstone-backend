package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Vendor;
import com.repo.VendorRepo;

@Service
public class VendorService {
	@Autowired
	VendorRepo vendorRepo;
	
	public List<Vendor> getAllVendors(){
		return (List<Vendor>) vendorRepo.findAll();
	}
	public Optional<Vendor> findVendorByUserName(String vendorUserName){
		return vendorRepo.findVendorByUserName(vendorUserName);
	}
	public Optional<Vendor> findVendorById(Long id){
		return vendorRepo.findById(id);
	}
	public String addVendor(Vendor vendor) {
		if(findVendorByUserName(vendor.getUserName()).isPresent()){
			return("USERALREADYEXIST");
		}else {
			vendorRepo.save(vendor);
			return ("REGISTERED");
		}
	}
	public String deleteVendor(Long id) {
		
		if(findVendorById(id).isPresent()) {
			vendorRepo.deleteById(id);
			return "vendor deleted";
		}else {
			return "vendor not found";
		}
	}
	public Vendor logIn(String userName, String password) {
		for(Vendor vs : vendorRepo.findAll()) {
			if(userName.equals(vs.getUserName()) && password.equals(vs.getPassword())) {
				return vs;
			}
		}
		return null;
	}
	public String resetPassword(String userName, String email, String password) {
		for(Vendor vs : vendorRepo.findAll()) {
			if(userName.equals(vs.getUserName()) && email.equals(vs.getEmail())) {
				vs.setPassword(password);
				vendorRepo.save(vs);
				return "PASSWORDRESET";
			}
		}
		return "PASSWORDRESETFAILED";
	}
}
