package com.doctorwho.com.primtive;

/**
 * 
 * project_name :reflection-util
 * @author doctorWho
 *
 */

public enum Primitive {
	p_byte(byte.class),
	p_char(char.class),
	p_double(double.class),
	p_float(float.class),
	p_int(int.class),
	p_long(long.class),
	p_short(short.class),
	p_boolean(boolean.class);
	
	private Class<?> classT;
	public Class<?> getPrimitiveClass() {
		return this.classT;
	}
	
	public static Class<?> getPrimitiveClass(Class<?> classType) {
		Primitive[] primitives = Primitive.values();
		for (Primitive primitive : primitives) {
			if (classType.getName().equals(primitive.getPrimitiveClass().getName()) ) {
				return primitive.getPrimitiveClass();
			}
		}
		
		return null;
	}
	
	public static Object newInstance(Class<?> classType,String value) {
		if (classType == byte.class || classType == char.class ) {
			throw new UnsupportedOperationException();
		}
		
		if (classType == double.class) {
			return Double.parseDouble(value);
		}
		
		if (classType == float.class) {
			return Float.parseFloat(value);
		}
		
		if (classType == int.class) {
			return Integer.parseInt(value);
		}
		
		if (classType == long.class) {
			return Long.parseLong(value);
		}
		
		if (classType == short.class) {
			return Short.parseShort(value);
		}
		
		if (classType == boolean.class) {
			if ("1".equals(value)) {
				return true;
			}
			if ("0".equals(value)) {
				return false;
			}
			return Boolean.parseBoolean(value);
		}
		
		return null;
	}
	private Primitive(Class<?> classt){
		this.classT = classt;
	}
}


