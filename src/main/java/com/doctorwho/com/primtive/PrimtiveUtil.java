package com.doctorwho.com.primtive;


public final class PrimtiveUtil {
	
	public static boolean isPrimitive(Class<?> classType) {
		if (null != Primitive.getPrimitiveClass(classType)) {
			return true;
		}
		
		return false;
	}
	
	
	public static boolean isWrapperType(Class<?> classType) {
		if (null != WrapperType.getWrapperTypeClass(classType)) {
			return true;
		}
		
		return false;
	}
	
	public static Object newIntance(Class<?> classType, String value) {
		if (!isPrimitive(classType) && !isWrapperType(classType)) {
			throw new IllegalArgumentException();
		}
		
		return null;
	}
	
	private PrimtiveUtil(){
		throw new UnsupportedOperationException("操作非法");
	}
}
