package com.doctorwho.com.primtive;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * project_name :reflection-util
 * @author kexiang.cui
 * create time :2014-6-30 上午10:20:20
 * 
 */
public class PrimtiveUtilTest {

	/**
	 * Test method for {@link com.doctorwho.com.primtive.PrimtiveUtil#isPrimitive(java.lang.Class)}.
	 */
	
	
	@Test
	public void testIsPrimitive() {
		assertTrue(PrimtiveUtil.isPrimitive(int.class));
		assertTrue(PrimtiveUtil.isPrimitive(char.class));
		assertTrue(PrimtiveUtil.isPrimitive(boolean.class));
		assertTrue(PrimtiveUtil.isPrimitive(short.class));
		assertTrue(PrimtiveUtil.isPrimitive(long.class));
		assertTrue(PrimtiveUtil.isPrimitive(byte.class));
		assertTrue(PrimtiveUtil.isPrimitive(float.class));
		assertTrue(PrimtiveUtil.isPrimitive(double.class));
		
		assertTrue(PrimtiveUtil.isPrimitive(Double.TYPE));
		assertTrue(PrimtiveUtil.isPrimitive(Byte.TYPE));
		assertTrue(PrimtiveUtil.isPrimitive(Character.TYPE));
		assertTrue(PrimtiveUtil.isPrimitive(Boolean.TYPE));
		assertTrue(PrimtiveUtil.isPrimitive(Float.TYPE));
		assertTrue(PrimtiveUtil.isPrimitive(Integer.TYPE));
		assertTrue(PrimtiveUtil.isPrimitive(Long.TYPE));
		assertTrue(PrimtiveUtil.isPrimitive(Short.TYPE));
		
		assertFalse(PrimtiveUtil.isPrimitive(Double.class));
		assertFalse(PrimtiveUtil.isPrimitive(Byte.class));
		assertFalse(PrimtiveUtil.isPrimitive(Character.class));
		assertFalse(PrimtiveUtil.isPrimitive(Boolean.class));
		assertFalse(PrimtiveUtil.isPrimitive(Float.class));
		assertFalse(PrimtiveUtil.isPrimitive(Integer.class));
		assertFalse(PrimtiveUtil.isPrimitive(Long.class));
		assertFalse(PrimtiveUtil.isPrimitive(Short.class));
	}

	/**
	 * Test method for {@link com.doctorwho.com.primtive.PrimtiveUtil#isWrapperType(java.lang.Class)}.
	 */
	@Test
	public void testIsWrapperType() {
		assertFalse(PrimtiveUtil.isWrapperType(int.class));
		assertFalse(PrimtiveUtil.isWrapperType(char.class));
		assertFalse(PrimtiveUtil.isWrapperType(boolean.class));
		assertFalse(PrimtiveUtil.isWrapperType(short.class));
		assertFalse(PrimtiveUtil.isWrapperType(long.class));
		assertFalse(PrimtiveUtil.isWrapperType(byte.class));
		assertFalse(PrimtiveUtil.isWrapperType(float.class));
		assertFalse(PrimtiveUtil.isWrapperType(double.class));
		
		assertFalse(PrimtiveUtil.isWrapperType(Double.TYPE));
		assertFalse(PrimtiveUtil.isWrapperType(Byte.TYPE));
		assertFalse(PrimtiveUtil.isWrapperType(Character.TYPE));
		assertFalse(PrimtiveUtil.isWrapperType(Boolean.TYPE));
		assertFalse(PrimtiveUtil.isWrapperType(Float.TYPE));
		assertFalse(PrimtiveUtil.isWrapperType(Integer.TYPE));
		assertFalse(PrimtiveUtil.isWrapperType(Long.TYPE));
		assertFalse(PrimtiveUtil.isWrapperType(Short.TYPE));
		
		assertTrue(PrimtiveUtil.isWrapperType(Double.class));
		assertTrue(PrimtiveUtil.isWrapperType(Byte.class));
		assertTrue(PrimtiveUtil.isWrapperType(Character.class));
		assertTrue(PrimtiveUtil.isWrapperType(Boolean.class));
		assertTrue(PrimtiveUtil.isWrapperType(Float.class));
		assertTrue(PrimtiveUtil.isWrapperType(Integer.class));
		assertTrue(PrimtiveUtil.isWrapperType(Long.class));
		assertTrue(PrimtiveUtil.isWrapperType(Short.class));
	}

}
