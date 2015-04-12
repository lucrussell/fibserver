package com.mycompany.myapp.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codahale.metrics.annotation.Timed;

/**
 * A service for working with Fibonacci numbers. The public interface exposes
 * results as {@link BigInteger}s, which provides arbitrary-precision integers.
 * Because the Fibonacci function grows exponentially, 32-bit signed Java
 * integers can only hold the first 46 Fibonacci numbers. The Spring "prototype"
 * scope is used to ensure multiple requests get a new instance of the service
 * and aren't writing to the same memoization cache.
 *
 * @author lrussell
 */
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class FibonacciService {

	private final Logger log = LoggerFactory.getLogger(FibonacciService.class);
	private ArrayList<BigInteger> fibCache;

	/**
	 * Returns the whole Fibonacci sequence for the supplied input.
	 * 
	 * @param input
	 *            must be greater than or equal to 0, less than 200. The 200
	 *            constraint is an arbitrary one to prevent overflowing the
	 *            stack. This could be configurable as an enhancement.
	 * @return The Fibonacci sequence for the supplied input
	 */
	@Timed
	public List<BigInteger> getFibonacciSequence(int input) {
		fibCache = new ArrayList<BigInteger>();
		fibCache.add(BigInteger.ZERO);
		fibCache.add(BigInteger.ONE);
		if (input < 0) {
			throw new IllegalArgumentException("Illegal negative number specified as input");
		} else if (input > 200) {
			throw new IllegalArgumentException("Only supports inputs up to 200");
		} else if (input == 0) {
			List<BigInteger> zeroResult = new ArrayList<BigInteger>();
			zeroResult.add(BigInteger.ZERO);
			return zeroResult;
		}

		fib(input);
		return fibCache;
	}

	/**
	 * This is a simple memoized recursion Fibonacci implementation. It uses a
	 * recursive approach rather than an iterative one, but caches results of
	 * each calculation to avoid redundant recursive calls.
	 * 
	 * @param input
	 *            An input number for which to calculate the Fibonacci result
	 * @return BigInteger result
	 */
	private BigInteger fib(int input) {
		log.trace("FibonacciService called with input: " + input);
		if (input >= fibCache.size()) {
			fibCache.add(input, fib(input - 1).add(fib(input - 2)));
		}
		return fibCache.get(input);
	}

}
