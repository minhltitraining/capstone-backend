package com.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Vendor;
import com.service.VendorService;

@Component
@RestController
@RequestMapping("vendor")
@CrossOrigin("*")
public class VendorController {
	@Autowired
	VendorService vendorService;
	
	@PostMapping("/register")
	public String register(@RequestBody Vendor vendor) {
		return vendorService.addVendor(vendor);
	}
	
	@PostMapping("/login")
	public Vendor logIn(@RequestBody Map<String,String> vendor) {
		return vendorService.logIn(vendor.get("userName"),vendor.get("password"));
	}
	
	@GetMapping("/get/{vendorUserName}")
	public Optional<Vendor> findVendorByUserName(@PathVariable String vendorUserName){
		return vendorService.findVendorByUserName(vendorUserName);
	}
	@GetMapping("/find/{id}")
	public Optional<Vendor> findVendorById(@PathVariable Long id){
		return vendorService.findVendorById(id);
	}
	@GetMapping("/all")
	public List<Vendor> getAllVendors(){
		return vendorService.getAllVendors();
	}
	@DeleteMapping("/delete/{id}")
	public String deleteVendorById(@PathVariable Long id){
		return vendorService.deleteVendor(id);
	}
	@PutMapping("/reset/{pass}")
	public String resetPassword(@RequestBody Map<String,String> vendor,@PathVariable String pass) {
		return vendorService.resetPassword(vendor.get("userName"), vendor.get("email"),pass);
	}
}
