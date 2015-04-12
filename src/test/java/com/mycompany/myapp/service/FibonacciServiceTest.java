package com.mycompany.myapp.service;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class FibonacciServiceTest {
	
    private FibonacciService fibonacciService;
	
    @Before
    public void setup(){
    	fibonacciService = new FibonacciService();
    }
    
    
	@Test
	public void testGetFibonacciSequenceReturnsCorrectResult() {
		List<BigInteger> expectedResult = new ArrayList<BigInteger>();
		expectedResult.add(BigInteger.ZERO);
		expectedResult.add(BigInteger.ONE);
		expectedResult.add(BigInteger.ONE);
		expectedResult.add(BigInteger.valueOf(2));
		expectedResult.add(BigInteger.valueOf(3));
		expectedResult.add(BigInteger.valueOf(5));
		assertEquals(expectedResult, fibonacciService.getFibonacciSequence(5));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetFibonacciSequenceReturnsErrorForNegativeInput() {
		fibonacciService.getFibonacciSequence(-5);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetFibonacciSequenceReturnsErrorForTooLargeInput() {
		fibonacciService.getFibonacciSequence(201);
	}
	
	@Test
	public void testGetFibonacciSequenceReturnsZeroForZeroInput() {
		List<BigInteger> expectedResult = new ArrayList<BigInteger>();
		expectedResult.add(BigInteger.ZERO);
		assertEquals(expectedResult, fibonacciService.getFibonacciSequence(0));
	}
	

}
