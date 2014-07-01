package com.doctorwho.com.primtive;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Test;

/**
 * project_name :reflection-util
 * @author doctorWho
 * create time :2014-7-1 上午9:31:16
 * 
 */
public class PrimitiveTest {

	/**
	 * Test method for {@link com.doctorwho.com.primtive.Primitive#getPrimitiveClass()}.
	 */
	@Test
	public void testGetPrimitiveClass() {
		assertEquals(long.class, Primitive.getPrimitiveClass(long.class));
	}

	/**
	 * Test method for {@link com.doctorwho.com.primtive.Primitive#getPrimitiveClass(java.lang.Class)}.
	 */
	@Test
	public void testGetPrimitiveClassClassOfQ() {
		assertNull(Primitive.getPrimitiveClass(String.class));
		assertNull(Primitive.getPrimitiveClass(Calendar.class));
		assertNull(Primitive.getPrimitiveClass(BigDecimal.class));
		assertNull(Primitive.getPrimitiveClass(Enum.class));
		
		assertEquals(byte.class,Primitive.getPrimitiveClass(byte.class));
		assertEquals(char.class,Primitive.getPrimitiveClass(char.class));
	}

	/**
	 * Test method for {@link com.doctorwho.com.primtive.Primitive#newInstance(java.lang.Class, java.lang.String)}.
	 */
	@Test
	public void testNewInstance() {
		Object newInstance = Primitive.newInstance(Primitive.p_long.getPrimitiveClass(), "12");
		Object result =  newInstance;
		assertEquals(12L, result);
		
		newInstance = Primitive.newInstance(Primitive.p_double.getPrimitiveClass(), "12");
		result =  newInstance;
		assertEquals(12D, result);
		
		newInstance = Primitive.newInstance(Primitive.p_int.getPrimitiveClass(), "12");
		result =  newInstance;
		assertEquals(12, result);
		
		newInstance = Primitive.newInstance(Primitive.p_boolean.getPrimitiveClass(), "true");
		result =  newInstance;
		assertEquals(true, result);
		
		newInstance = Primitive.newInstance(Primitive.p_boolean.getPrimitiveClass(), "1");
		result =  newInstance;
		assertEquals(true, result);
		
		newInstance = Primitive.newInstance(Primitive.p_boolean.getPrimitiveClass(), "s");
		result =  newInstance;
		assertEquals(false, result);
		
		try {
			newInstance = Primitive.newInstance(Primitive.p_double.getPrimitiveClass(), null);
			result =  newInstance;
		} catch (NullPointerException e) {
			System.out.println("error");
		}
	}

}
