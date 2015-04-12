package com.mycompany.myapp.web.rest;

import java.math.BigInteger;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.mycompany.myapp.service.FibonacciService;

/**
 * REST controller for managing Fibonacci calculations.
 */
@RestController
@RequestMapping("/api")
public class FibonacciResource {
    @Inject
    private FibonacciService fibonacciService;
    
	private final Logger log = LoggerFactory.getLogger(FibonacciResource.class);

	/**
	 * POST /fibonacci/:number -> calculate the sequence up to "number".
	 */
	@RequestMapping(value = "/fibonacci", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@Timed
	ResponseEntity<List<BigInteger>> calculateFibonacci(@RequestBody Integer number) {
		log.debug("REST request to get fibonnaci : {}", number);
		List<BigInteger> fibonacciSequence = fibonacciService.getFibonacciSequence(number);
		return new ResponseEntity<List<BigInteger>>(
                fibonacciSequence,
                HttpStatus.OK);
		 
	}
}
