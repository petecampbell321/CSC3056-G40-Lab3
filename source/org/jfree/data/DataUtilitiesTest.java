package org.jfree.data;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class DataUtilitiesTest extends TestCase {
	
	private Values2D values2D;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	protected void setUp() throws Exception {
//		super.setUp();
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(1, 0, 0);
		testValues.addValue(4, 1, 0);
	}

	@After
	protected void tearDown() throws Exception {
//		super.tearDown();
		values2D = null;
	}

	// CALCULATECOLUMNTOTAL TEST METHODS
	@Test
	public void testCalculateColumnTotal_ValidDataWithInvalidNegativeColumn() {
		String message = "Negative value input for column so should throw IndexOutOfBoundsException";
		
		int column = -2;
		
		try {
			DataUtilities.calculateColumnTotal(values2D, column);
			fail("No exception thrown - Expected outcome was: a thrown exception of type: IndexOutOfBoundsException");
		}
		catch (Exception e) {
			assertTrue(message, e.getClass().equals(IndexOutOfBoundsException.class));
		}
	}
	@Test
	public void testCalculateColumnTotal_ValidDataWithValidColumn() {
		String message = "Sum of column did not equal expected outcome";
		
		int column = 0;
		
		double expected = 5.0;
		double actual = DataUtilities.calculateColumnTotal(values2D, column);
		
		assertEquals(message, expected, actual);
	}
	@Test
	public void testCalculateColumnTotal_ValidDataWithInvalidColumnGreaterTanDataLength() {
		String message = "Should throw IndexOutOfBoundsException";
		
		int column = 4;
		
		try {
			DataUtilities.calculateColumnTotal(values2D, column);
			fail("No exception thrown - Expected outcome was: a thrown exception of type: IndexOutOfBoundsException");
		}
		catch (Exception e) {
			assertTrue(message, e.getClass().equals(IndexOutOfBoundsException.class));
		}
	}
	@Test
	public void testCalculateColumnTotal_InvalidDataWithInvalidNegativeColumn() {
		String message = "Invalid data input so should throw InvalidParameterException";
		
		int column = -3;
		
		try {
			DataUtilities.calculateColumnTotal(null, column);
			fail("No exception thrown - Expected outcome was: a thrown exception of type: InvalidParameterException");
		}
		catch (Exception e) {
			assertTrue(message, e.getClass().equals(InvalidParameterException.class));
		}
	}
	@Test
	public void testCalculateColumnTotal_InvalidDataWithValidColumn() {
		String message = "Invalid data input so should throw InvalidParameterException";
		
		int column = 0;
		
		try {
			DataUtilities.calculateColumnTotal(null, column);
			fail("No exception thrown - Expected outcome was: a thrown exception of type: InvalidParameterException");
		}
		catch (Exception e) {
			assertTrue(message, e.getClass().equals(InvalidParameterException.class));
		}
	}
	@Test
	public void testCalculateColumnTotal_InvalidDataWithInvalidColumnGreaterTanDataLength() {
		String message = "Should throw IndexOutOfBoundsException";
		
		int column = 99;
		
		try {
			DataUtilities.calculateColumnTotal(null, column);
			fail("No exception thrown - Expected outcome was: a thrown exception of type: IndexOutOfBoundsException");
		}
		catch (Exception e) {
			assertTrue(message, e.getClass().equals(IndexOutOfBoundsException.class));
		}
	}
	
	// CALCULATEROWTOTAL TEST METHODS
	@Test
	public void testCalculateRowTotal_ValidDataWithInvalidNegativeColumn() {
		String message = "Negative value input for column so should throw IndexOutOfBoundsException";
		
		int column = -2;
		
		try {
			DataUtilities.calculateColumnTotal(values2D, column);
			fail("No exception thrown - Expected outcome was: a thrown exception of type: IndexOutOfBoundsException");
		}
		catch (Exception e) {
			assertTrue(message, e.getClass().equals(IndexOutOfBoundsException.class));
		}
	}
	@Test
	public void testCalculateRowTotal_ValidDataWithValidColumn() {
		String message = "Sum of column did not equal expected outcome";
		
		int column = 0;
		
		double expected = 5.0;
		double actual = DataUtilities.calculateColumnTotal(values2D, column);
		
		assertEquals(message, expected, actual);
	}
	@Test
	public void testCalculateRowTotal_ValidDataWithInvalidColumnGreaterTanDataLength() {
		String message = "Should throw IndexOutOfBoundsException";
		
		int column = 4;
		
		try {
			DataUtilities.calculateColumnTotal(values2D, column);
			fail("No exception thrown - Expected outcome was: a thrown exception of type: IndexOutOfBoundsException");
		}
		catch (Exception e) {
			assertTrue(message, e.getClass().equals(IndexOutOfBoundsException.class));
		}
	}
	@Test
	public void testCalculateRowTotal_InvalidDataWithInvalidNegativeColumn() {
		String message = "Invalid data input so should throw InvalidParameterException";
		
		int column = -3;
		
		try {
			DataUtilities.calculateColumnTotal(null, column);
			fail("No exception thrown - Expected outcome was: a thrown exception of type: InvalidParameterException");
		}
		catch (Exception e) {
			assertTrue(message, e.getClass().equals(InvalidParameterException.class));
		}
	}
	@Test
	public void testCalculateRowTotal_InvalidDataWithValidColumn() {
		String message = "Invalid data input so should throw InvalidParameterException";
		
		int column = 0;
		
		try {
			DataUtilities.calculateColumnTotal(null, column);
			fail("No exception thrown - Expected outcome was: a thrown exception of type: InvalidParameterException");
		}
		catch (Exception e) {
			assertTrue(message, e.getClass().equals(InvalidParameterException.class));
		}
	}
	@Test
	public void testCalculateRowTotal_InvalidDataWithInvalidColumnGreaterTanDataLength() {
		String message = "Should throw IndexOutOfBoundsException";
		
		int column = 99;
		
		try {
			DataUtilities.calculateColumnTotal(null, column);
			fail("No exception thrown - Expected outcome was: a thrown exception of type: IndexOutOfBoundsException");
		}
		catch (Exception e) {
			assertTrue(message, e.getClass().equals(IndexOutOfBoundsException.class));
		}
	}
	
	// CREATENUMBERARRAY TEST METHODS
	@Test
	public void testCreateNumberArray_ValidDoubleArray() {
		String message = "The output array is not of type Number[]";
		
		double data[] = {1.2, 3.4, 5.6};
		
		Number actual[] = DataUtilities.createNumberArray(data);
		
		assertTrue(message, actual instanceof Number[]);
	}
	@Test
	public void testCreateNumberArray_InvalidNullInput() {
		String message = "Invalid data input so should throw InvalidParameterException but didn't";
		
		double data[] = null;
		
		try {
			DataUtilities.createNumberArray(data);
			fail("No exception thrown - Expected outcome was: a thrown exception of type: InvalidParameterException");
		}
		catch (Exception e) {
			assertTrue(message, e.getClass().equals(InvalidParameterException.class));
		}
	}
	
	// CREATENUMBERARRAY2D TEST METHODS
	public void testCreateNumberArray2D_ValidDoubleArray() {
		String message = "The output array is not of type Number[][]";
		
		double data[][] = {{1.2, 3.4, 5.6},{10.5, 11.5, 12.5}};
		
		Number actual[][] = DataUtilities.createNumberArray2D(data);
		
		assertTrue(message, actual instanceof Number[][]);
	}
	@Test
	public void testCreateNumberArray2D_InvalidNullInput() {
		String message = "Invalid data input so should throw InvalidParameterException but didn't";
		
		double data[][] = null;
		
		try {
			DataUtilities.createNumberArray2D(data);
			fail("No exception thrown - Expected outcome was: a thrown exception of type: InvalidParameterException");
		}
		catch (Exception e) {
			assertTrue(message, e.getClass().equals(InvalidParameterException.class));
		}
	}
	
	// GETCUMULATIVEPERCENTAGES TEST METHODS
	@Test
	public void testGetCumulativePercentages_ValidKeyedValuesInput() {
		String message = "Actual result does not equal expected.";
		
		DefaultKeyedValues data = new DefaultKeyedValues();
		data.addValue(0, (Number)2);
		data.addValue(1, (Number)8);
		data.addValue(2, (Number)3);
		
		DefaultKeyedValues expected = new DefaultKeyedValues();
		data.addValue(0, (Number)0.15384615);
		data.addValue(1, (Number)0.76923077);
		data.addValue(2, (Number)1.0);
		
		KeyedValues actual = DataUtilities.getCumulativePercentages(data);
		
//		System.out.println(actual.getValue(0));
//		System.out.println(actual.getValue(1));
//		System.out.println(actual.getValue(2));
		
		assertEquals(message, expected, actual);
	}
	@Test
	public void testGetCumulativePercentages_NullInput() {
		String message = "InvalidParameterException was not thrown.";
		
		try {
			DataUtilities.getCumulativePercentages(null);
			fail("No exception thrown - Expected outcome was: a thrown exception of type: InvalidParameterException");
		}
		catch (Exception e) {
			System.out.println(e.getClass());
			assertTrue(message, e.getClass().equals(InvalidParameterException.class));
		}
	}
}
