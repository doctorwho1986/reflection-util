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
	private Class<?> classT;
	private WrapperType(Class<?> classt){
		this.classT = classt;
	}
}
