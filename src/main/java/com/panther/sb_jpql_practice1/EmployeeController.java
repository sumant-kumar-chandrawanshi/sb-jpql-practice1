package com.panther.sb_jpql_practice1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/")
	public String test() {
		return "This is jpa method test";
	}
	
	@RequestMapping("/save")
	public Employee save(@RequestBody Employee employee) {
		return empRepo.save(employee);
	}
	
	@RequestMapping("/all")
	public List<Employee> alldata(){
		return empRepo.findAll(Sort.by("name"));
	}
	
	@RequestMapping("/byname/{name}")
	public List<Employee> byname(@PathVariable String name){
		return empRepo.findByName(name);
	}
	
	@RequestMapping("/byage/{age}")
	public List<Employee> byage(@PathVariable int age){
		return empRepo.findByAge(age);
	}
	
	@RequestMapping("/byid/{id}")
	public Optional<Employee> byid(@PathVariable Long id){
		return empRepo.findById(id);
	}
	
	@RequestMapping("/bycity/{city}")
	public List<Employee> bycity(@PathVariable String city){
		return empRepo.findByCity(city);
	}
	
	@RequestMapping("/bycountry/{country}")
	public List<Employee> bycountry(@PathVariable String country){
		return empRepo.findByCountry(country);
	}
	
	//two column
	@RequestMapping("/bycityandcountry/{city}{country}")
	public List<Employee> bycitybycountry(@PathVariable String city, @PathVariable String country){
		return empRepo.findByCityOrCountry(city,country);
	}
	
	//custom
	@RequestMapping("/bynamecustom/{name}")
	public List<Employee> bynamecontains(@PathVariable String name){
		return empRepo.findByNameContaining(name);
	}
	
	@RequestMapping("/bycitycustom/{city}")
	public List<Employee> getallemp(@PathVariable String city){
		return empRepo.findEmployeeByCity(city);
	}
	
	@RequestMapping("/bycityandcountry/{city}{country}")
	public List<Employee> getallempbycityandcountry(String city, String country){
		return empRepo.getEmployeeByCityAndCountry(city, country);
	}
	
//	Native Query
	@GetMapping("/native/byname/{name}")
	public List<Employee> getnativebyname(@PathVariable String name){
		return empRepo.findByNameNative(name);
	}
	
}
