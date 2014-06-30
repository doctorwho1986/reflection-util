package com.doctorwho.com.primtive;


public final class PrimtiveUtil {
	
	public static boolean isPrimitive(Class<?> classType) {
		Primitive[] primitives = Primitive.values();
		for (Primitive primitive : primitives) {
			if (classType.getName().equals(primitive.getPrimitiveClass().getName()) ) {
				return true;
			}
		}
		
		return false;
	}
	
	
	public static boolean isWrapperType(Class<?> classType) {
		WrapperType[] wrapperTypes = WrapperType.values();
		for (WrapperType wrapperType : wrapperTypes) {
			if (classType.getName().equals(wrapperType.getWrapperTypeClass().getName())) {
				return true;
			}
		}
		return false;
	}
	
	private PrimtiveUtil(){
		throw new UnsupportedOperationException("操作非法");
	}
}
