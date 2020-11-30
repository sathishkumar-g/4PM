package bot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bot.model.LuckyNumber;
import bot.model.Result;
import bot.model.UserDetails;
import bot.repository.LuckyNumberRepository;
import bot.repository.UserDetailsRepository;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST,
		RequestMethod.DELETE })
@RequestMapping(path = "/bot")
public class AppController {
	@Autowired
	UserDetailsRepository userDetailsRepository;

	@Autowired
	LuckyNumberRepository luckyNumberRepository;

	@PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> login(@RequestBody UserDetails user) {
		System.out.println("Inside login method!! " + user.getName() + " " + user.getPassword());
		UserDetails userDetails = (UserDetails) userDetailsRepository.findById(user.getName()).orElse(null);
		if (null != userDetails && userDetails.getName().equals(user.getName())
				&& userDetails.getPassword().equals(user.getPassword()))
			// return new ResponseEntity<>(userDetails, HttpStatus.OK);
			return new ResponseEntity<>(new Result("Success"), HttpStatus.OK);
		else
			return new ResponseEntity<>(new Result("Fail"), HttpStatus.OK);
	}

	@PostMapping(path = "/save", consumes = "application/json")
	public ResponseEntity<Object> save(@RequestBody LuckyNumber lNumber) {
		System.out.println("Inside Save Method " + lNumber.getNumber() + " " + lNumber.getDate());
		luckyNumberRepository.deleteAll();
		LuckyNumber luckyNumber = luckyNumberRepository.save(lNumber);
		return new ResponseEntity<>(luckyNumber, HttpStatus.OK);
	}

	@GetMapping(path = "/get", produces = "application/json")
	//public ResponseEntity<Object> get(@RequestParam(value = "date") String date) {
	public ResponseEntity<Object> get() {	
		System.out.println("Inside get method ");
		List<LuckyNumber> lNumberList = (List<LuckyNumber>) luckyNumberRepository.findAll();
		return new ResponseEntity<>(lNumberList.get(0), HttpStatus.OK);
	}
}