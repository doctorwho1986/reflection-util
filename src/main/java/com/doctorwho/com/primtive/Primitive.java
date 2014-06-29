package com.doctorwho.com.primtive;

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
	private Primitive(Class<?> classt){
		this.classT = classt;
	}
}


