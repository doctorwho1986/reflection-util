package com.doctorwho.com.primtive;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * project_name :reflection-util
 * @author doctorWho
 * create time :2014-7-1 上午9:31:32
 * 
 */
public class WrapperTypeTest {

	/**
	 * Test method for {@link com.doctorwho.com.primtive.WrapperType#getWrapperTypeClass()}.
	 */
	@Test
	public void testGetWrapperTypeClass() {
		assertEquals(Long.class,WrapperType.w_Long.getWrapperTypeClass());
	}

	/**
	 * Test method for {@link com.doctorwho.com.primtive.WrapperType#getWrapperTypeClass(java.lang.Class)}.
	 */
	@Test
	public void testGetWrapperTypeClassClassOfQ() {
		assertNull(WrapperType.getWrapperTypeClass(long.class));
		assertNull(WrapperType.getWrapperTypeClass(BigDecimal.class));
		
		assertEquals(Long.class, WrapperType.getWrapperTypeClass(Long.class));
		assertEquals(Integer.class, WrapperType.getWrapperTypeClass(Integer.class));
	}

	/**
	 * Test method for {@link com.doctorwho.com.primtive.WrapperType#newIntance(java.lang.Class, java.lang.String)}.
	 */
	@Test
	public void testNewIntance() {
		Object newIntance = WrapperType.newIntance(Long.class, "1234");
		assertEquals(1234L, newIntance);
		
		newIntance = WrapperType.newIntance(Integer.class, "1234");
		assertEquals(1234, newIntance);
		
		newIntance = WrapperType.newIntance(Long.class, "1234");
		assertEquals(1234L, newIntance);
		
		newIntance = WrapperType.newIntance(Boolean.class, "1234");
		assertEquals(Boolean.FALSE, newIntance);
		
		newIntance = WrapperType.newIntance(Boolean.class, "1");
		assertEquals(Boolean.TRUE, newIntance);
		
		newIntance = WrapperType.newIntance(Boolean.class, "0");
		assertEquals(Boolean.FALSE, newIntance);
		
	}

}
