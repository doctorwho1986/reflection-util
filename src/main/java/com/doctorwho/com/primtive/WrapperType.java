package com.doctorwho.com.primtive;

public enum WrapperType {
	w_Byte(Byte.class),
	w_Char(Character.class),
	w_Double(Double.class),
	w_Float(Float.class),
	w_Int(Integer.class),
	w_Long(Long.class),
	w_Short(Short.class),
	w_Boolean(Boolean.class);
	
	public Class<?> getWrapperTypeClass() {
		return this.classT;
	}
	
	public static Class<?> getWrapperTypeClass(Class<?> classType) {
		WrapperType[] wrapperTypes = WrapperType.values();
		for (WrapperType wrapperType : wrapperTypes) {
			if (classType.getName().equals(wrapperType.getWrapperTypeClass().getName())) {
				return wrapperType.getWrapperTypeClass();
			}
		}
		return null;
	}
	
	public static Object newIntance(Class<?> classType, String value) {
		if (classType == Byte.class || classType == Character.class) {
			throw new UnsupportedOperationException();
		}
		
		if (classType == Double.class) {
			return Double.valueOf(value);
		}
		
		if (classType == Float.class) {
			return Float.valueOf(value);
		}
		
		if (classType == Integer.class) {
			return Integer.valueOf(value);
		}
		
		if (classType == Long.class) {
			return Long.valueOf(value);
		}
		
		if (classType == Short.class) {
			return Short.valueOf(value);
		}
		
		if (classType == Boolean.class) {
			if ("1".equals(value)) {
				return Boolean.TRUE;
			}
			
			if ("0".equals(value)) {
				return Boolean.FALSE;
			}
			
			return Boolean.valueOf(value);
		}
		return null;
	}
	
	private Class<?> classT;
	private WrapperType(Class<?> classt){
		this.classT = classt;
	}
}
