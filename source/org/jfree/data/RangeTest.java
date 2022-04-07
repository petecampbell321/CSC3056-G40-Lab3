package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class RangeTest extends TestCase {
	
	private Range rangeObjectUnderTest;
	private Range rangeContains;
	private Range rangeConstrain;
	private Range rangeIntersects;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		rangeObjectUnderTest = new Range(-1, 1);
		rangeContains = new Range(1,5);
		rangeConstrain = new Range(1,5);
		rangeIntersects = new Range(-1, 4);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCentralValueShouldBeZero() {
		assertEquals("The central value of -1 and 1 should be 0", 0, rangeObjectUnderTest.getCentralValue(), 0.000000001d);
	}

	// CONTAINS TESTING METHODS
	@Test
	public void testContainsInRange() {
		assertEquals("Range should contain 3 and return True", true, rangeContains.contains(3));		assertEquals("Range shouldn't contain 20 and return false", false, rangeContains.contains(20));
	}
	@Test
	public void testContainsOutsideRange() {				
		assertEquals("Range shouldn't contain 20 and return false", false, rangeContains.contains(20));
	}
	@Test
	public void testContainsAboveRange() {		
		assertEquals("Range shouldn't contain 6 and return false", false, rangeContains.contains(6));
	}
	@Test
	public void testContainsBelowRange() {
		assertEquals("Range shouldn't contain 0 and return false", false, rangeContains.contains(0));
    }
	// CONSTRAIN TESTING METHODS
	@Test
	public void testConstrainInRange() {
		assertEquals("Range should contain 3 and return 3", 3, rangeConstrain.constrain(3),0.000000001d);	
	}
	@Test
	public void testConstrainAboveRange() {	
		assertEquals("Range shouldnt contain 20 but return clostest value in range with 5", 5, rangeConstrain.constrain(20),0.000000001d);
	}
	@Test
	public void testConstrainBelowRange() {
		assertEquals("Range shouldnt contain -20 but return clostest value in range with 1", 1, rangeConstrain.constrain(-20),0.000000001d);
	}
	
	// INTERSECTS TESTING METHODS
	@Test
	public void testIntersects_BothInputsLessThanLowerBound() {
		String message = "Input values are both less than given range so shouldn't intersect";
		
		double lower = -5.0;
		double upper = -2.0;
		
		boolean expected = false;
		boolean actual = rangeIntersects.intersects(lower, upper);
		
		assertEquals(message, expected, actual);
	}
	@Test
	public void testIntersects_LowerLessThanRangeUpperInsideRange() {
		String message = "Lower input is less than range, upper input is within range so should intersect";
		
		double lower = -3.0;
		double upper = 2.0;
		
		boolean expected = true;
		boolean actual = rangeIntersects.intersects(lower, upper);
		
		assertEquals(message, expected, actual);
	}
	@Test
	public void testIntersects_BothInputsInsideRange() {
		String message = "Both inputs are within range so should intersect";
		
		double lower = 1.0;
		double upper = 3.0;
		
		boolean expected = true;
		boolean actual = rangeIntersects.intersects(lower, upper);
		
		assertEquals(message, expected, actual);
	}
	@Test
	public void testIntersects_LowerInputInsideRangeUpperInputGreaterThanRange() {
		String message = "Lower input is within range and upper input is greater than range so should intersect";
		
		double lower = 2.0;
		double upper = 6.0;
		
		boolean expected = true;
		boolean actual = rangeIntersects.intersects(lower, upper);
		
		assertEquals(message, expected, actual);
	}
	@Test
	public void testIntersects_BothInputsGreaterThanRange() {
		String message = "Both inputs are greater than range so shouldn't intersect";
		
		double lower = 6.0;
		double upper = 8.0;
		
		boolean expected = false;
		boolean actual = rangeIntersects.intersects(lower, upper);
		
		assertEquals(message, expected, actual);
	}
	@Test
	public void testIntersects_LowerInputLessThanRangeUpperInputGreaterThanRange() {
		String message = "Lower input is less than range and upper input is greater than range so should intersect";
		
		double lower = -3.0;
		double upper = 7.0;
		
		boolean expected = true;
		boolean actual = rangeIntersects.intersects(lower, upper);
		
		assertEquals(message, expected, actual);
	}
	@Test
	public void testIntersects_LowerInputGreaterThanUpper() {
		String message = "Lower input is greater than upper input and therefore is invalid so shouldn't intersect";
		
		double lower = 7.0;
		double upper = 2.0;
		
		boolean expected = false;
		boolean actual = rangeIntersects.intersects(lower, upper);
		
		assertEquals(message, expected, actual);
	}
	
	// COMBINE TESTING METHODS
	@Test
	public void testCombine_BothInputsValidRanges() {
		String message = "Both valid range inputs combine to make new range";
		
		Range range1 = new Range(-3,2);
		Range range2 = new Range(1,5);
		
		Range expected = new Range(-3,5);
		
		// throws IllegalArgumentException if parameters arranged the other way round, the upper range has to go first
		Range actual = Range.combine(range2, range1);
		
		assertEquals(message, expected, actual);
	}
	@Test
	public void testCombine_FirstInputIsValidRangeSecondIsNull() {
		String message = "First input is a valid range, second is null so should return input range";
		
		Range range1 = new Range(-3,2);
		Range range2 = null;
		
		Range expected = new Range(-3,2);
		Range actual = Range.combine(range1, range2);
		
		assertEquals(message, expected, actual);
	}
	@Test
	public void testCombine_FirstInputIsNullSecondInputIsValidRange() {
		String message = "First input is null, second input is a valid Range so should return the second input value";
		
		Range range1 = null;
		Range range2 = null;
		
		Range expected = null;
		Range actual = Range.combine(range1, range2);
		
		assertEquals(message, expected, actual);
	}
	
	// GETLENGTH TESTING METHODS
	@Test
	public void testGetLength_SamePositiveValue() {
		String message = "Both lower and upper bounds of the range are the same positive value so length should be 0";
		
		Range target = new Range(5,5);
		
		double expected = 0;
		double actual = target.getLength();
		
		assertEquals(message, expected, actual);
	}
	@Test
	public void testGetLength_LowerLessThanUpperBothPositiveValues() {
		String message = "Lower and upper bounds of the range are positive values, lower is less than upper so length should be 3";
		
		Range target = new Range(1,4);
		
		double expected = 3;
		double actual = target.getLength();
		
		assertEquals(message, expected, actual);
	}
	@Test
	public void testGetLength_SameNegativeValue() {
		String message = "Both lower and upper bounds of the range are the same negative value so length should be 0";
		
		Range target = new Range(-2,-2);
		
		double expected = 0;
		double actual = target.getLength();
		
		assertEquals(message, expected, actual);
	}
	@Test
	public void testGetLength_LowerLessThanUpperBothNegaitveValues() {
		String message = "Lower and upper bounds of the range are negative values, lower is less than upper so length should be 5";
		
		Range target = new Range(-8,-3);
		
		double expected = 5;
		double actual = target.getLength();
		
		assertEquals(message, expected, actual);
	}
	@Test
	public void testGetLength_LowerIsNegativeUpperIsPositive() {
		String message = "Lower is a negative value and upper as a positive value";
		
		Range target = new Range(-7,2);
		
		double expected = 9;
		double actual = target.getLength();
		
		assertEquals(message, expected, actual);
	}
	// EXPAND TESTING METHODS
	@Test
	public void testPositiveExpand() {
		Range target = new Range(2,6);
		double lowerMargin = 0.25;
		double upperMargin = 0.5;
		
		Range expected = new Range(1.0,8.0);
		Range actual = Range.expand(target, lowerMargin, upperMargin);
		
		assertEquals("Range should expand and return new range", expected, actual);
		
	}
	@Test
	public void testNegativeExpand() {
		Range target = new Range(2,6);
		double lowerMargin = -0.25;
		double upperMargin = -0.5;
		
		Range expected = new Range(3.0,4.0);
		Range actual = Range.expand(target, lowerMargin, upperMargin);
		assertEquals("Range should reduce and return new range", expected, actual);
		
	}
	@Test
	public void testZeroExpand() {
		Range target = new Range(2,6);
		double lowerMargin = 0;
		double upperMargin = 0;
		
		Range expected = new Range(2.0,6.0);
		Range actual = Range.expand(target, lowerMargin, upperMargin);
		assertEquals("Range should not expand", expected, actual);
		
	}
	// EXPAND TO INCLUDE TESTING METHODS
	@Test
	public void testExpandToIncludeNull() {
		Range target = null;
		double value = 19;
		Range expected = new Range(19.0,19.0);
		if (target == null) {
			Range actual = Range.expandToInclude(target, value);
			assertEquals("new range created with lower & upper = value", expected, actual);	
		}
	}
	@Test
	public void testExpandToIncludeValueLessThanLower() {
		Range target = new Range(5,12);
		Range expected = new Range(3.0,12.0);
		double value = 3;
		if (value < target.getLowerBound()) {
			Range actual = Range.expandToInclude(target, value);
			assertEquals("Range should expand and include value in new range", expected, actual);
		}
		
	}
	@Test
	public void testExpandToIncludeValueGreaterThanUpper() {
		Range target = new Range(5,12);
		Range expected = new Range(5.0,19.0);
		double value = 19;
		if (value > target.getUpperBound()) {
			Range actual = Range.expandToInclude(target, value);
			assertEquals("Range should expand and include value in new range", expected, actual);	
		}
	}
}
