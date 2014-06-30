package com.doctorwho.com.refection;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.doctorwho.com.constant.ErrorCode;
import com.doctorwho.com.primtive.Primitive;
import com.doctorwho.com.primtive.PrimtiveUtil;
import com.doctorwho.com.primtive.WrapperType;

/**
 * 
 * @author doctorWho
 * @date  2014年6月29日
 *
 */

public final class MethodUtil {
	/**
	 * <p>获取get方法</p>
	 * <b>不存在重载现象，每个属性只有一个get方法</b>
	 * 
	 * @param beanClass
	 * @param propertyName
	 * @return
	 */
	public static Method getReadMethod(Class<?> beanClass,String propertyName){
		PropertyDescriptor[] propertyDescriptors = getPropertyDescriptors(beanClass);
		if (null == propertyDescriptors || 0 ==propertyDescriptors.length) {
			return null;
		}
		PropertyDescriptor propertyDescriptor = getPropertyDescriptor(propertyDescriptors, propertyName);
		
		if (null == propertyDescriptor) {
			return null;
		}
		
		return propertyDescriptor.getReadMethod();
	}
	
	
	/**
	 * <p>获取set方法，存在重载现在，此规定重载的都为此属性的set方法，和jdk规定不同<p>
	 * @param beanClass
	 * @param propertyName
	 * @return list
	 */
	public static List<Method> getWriteMethods(Class<?> beanClass,String propertyName){
		List<Method> writeMethods = new ArrayList<Method>();
		BeanInfo beanInfo;
		try {
			beanInfo = Introspector.getBeanInfo(beanClass);
		} catch (IntrospectionException e) {
			return writeMethods;
		}
		
		PropertyDescriptor propertyDescriptor = getPropertyDescriptor(getPropertyDescriptors(beanClass), propertyName);
		
		if (null == propertyDescriptor) {
			return writeMethods;
		}
		
		String wirteMethodName = "set"
							   +  propertyName.substring(0,1).toUpperCase()
							   +  propertyName.substring(1);
		List<Method> list = getMethodsByMethodName(beanClass.getMethods(), wirteMethodName);
		for (Method m : list) {
			if (isWriteMethod(m)) {
				writeMethods.add(m);
			}
		}
		
		return writeMethods;
	}
	
	
	/**
	 * 
	 * @param beanClass
	 * @param propertyName
	 * @return
	 */
	public static Method getWriteMethodByNoPrimParam(Class<?> beanClass, String propertyName){
		Set<Field> fields = new HashSet<Field>();
		fields.addAll(Arrays.asList(beanClass.getDeclaredFields()));
		
		Class<?> child = beanClass;
		Class<?> supper = child.getSuperclass();
		while (null != supper && Object.class != supper) {
			fields.addAll(Arrays.asList(supper.getDeclaredFields()));
			child = supper;
			supper = child.getSuperclass();
		}
		
		Class<?> paraType = null;
		for (Field f : fields) {
			if (!PrimtiveUtil.isPrimitive(f.getType()) && !PrimtiveUtil.isWrapperType(f.getType())&& propertyName.equals(f.getName())) {
				paraType = f.getType();
				break;
			}
		}
		
		if (null != paraType) {
			return getWriteMethod(beanClass, propertyName, paraType);
		}
		
		
				
		return null;
	}
	
	
	public static Method getWriteMethod(Class<?> beanClass, String propertyName,Class<?> parameterType){
		List<Method> writeMethods = getWriteMethods(beanClass, propertyName);
		if (writeMethods.isEmpty()) {
			return null;
		}
		
		for (Method m : writeMethods) {
			if (parameterType.getName().equals(m.getParameterTypes()[0].getName())) {
				return m;
			}
		}
		return null;
	}
	
	
	public static PropertyDescriptor getPropertyDescriptor(PropertyDescriptor[] propertyDescriptors, String propertyName){
		for (PropertyDescriptor p : propertyDescriptors) {
			if (propertyName.equals(p.getName())) {
				return p;
			}
		}
		
		return null;
	}
	
	public static List<Method> getMethodsByMethodName(Method[] methods, String methodName) {
		List<Method> methodsList = new ArrayList<Method>();
		for (Method method : methods) {
			if (methodName.equals(method.getName())) {
				methodsList.add(method);
			}
		}
		
		return methodsList;
	}
	
	
	public static PropertyDescriptor[] getPropertyDescriptors(Class<?> beanClass) {
		BeanInfo beanInfo;
		try {
			beanInfo = Introspector.getBeanInfo(beanClass);
		} catch (IntrospectionException e) {
			return null;
		}
		
		if (null == beanInfo) {
			return null;
		}
		PropertyDescriptor[] p = beanInfo.getPropertyDescriptors();
		PropertyDescriptor[] result = new PropertyDescriptor[p.length-1];
		for (int i = 0, length = p.length,j = 0; i < length; i++) {
			if ("class".equals(p[i].getName())) {
				continue;
			}
			result[j++] = p[i];
		}
		return result;
	}
	
	
	public static Method getWriteMethodByPrimitiveParam(Class<?> beanClass, String propertyName){
		List<Method> methods = new ArrayList<Method>();
		Primitive[] primitives = Primitive.values();
		Method writeMethod = null;
		for (Primitive primitive : primitives) {
			writeMethod = getWriteMethod(beanClass, propertyName, primitive.getPrimitiveClass());
			if (null != writeMethod) {
				methods.add(writeMethod);
			}
		}
		
		if (1 != methods.size()) {
			throw new UnsupportedOperationException("MethodUtil.getWriteMethodByPrimitiveParam" + ErrorCode.too_many_result);
		}
		return methods.get(0);
	}
	
	
	public static Method getWriteMethodByWrapperTypeParam(Class<?> beanClass, String propertyName){
		List<Method> methods = new ArrayList<Method>();
		Method writeMethod = null;
		WrapperType[] wrapperTypes = WrapperType.values();
		for (WrapperType wrapperType : wrapperTypes) {
			writeMethod = getWriteMethod(beanClass, propertyName, wrapperType.getWrapperTypeClass());
			if (null != writeMethod) {
				methods.add(writeMethod);
			}
		}
		
		if (1 != methods.size()) {
			throw new UnsupportedOperationException("MethodUtil.getWriteMethodByWrapperTypeParam" + ErrorCode.too_many_result);
		}
		return methods.get(0);		
	}
	
	public static Object invokeWriteMethod(Object obj,String propertyName ,Object... arg) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method writeMethod = getWriteMethod(obj.getClass(), propertyName,arg[0].getClass());
		if (null == writeMethod) {
			return null;
		}
		
		return writeMethod.invoke(obj, arg);
	}
	
	
	public static Object invokeWriteMethod(Object obj, String propertyName, String value) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//TODO
		Method writeMethod = getWriteMethodByNoPrimParam(obj.getClass(), propertyName);
		if (null != writeMethod  
				&&  !PrimtiveUtil.isPrimitive(writeMethod.getParameterTypes()[0])
				&&  !PrimtiveUtil.isWrapperType(writeMethod.getParameterTypes()[0]) 
				&& String.class.getName().equals(writeMethod.getParameterTypes()[0].getName())) {
			
		}
		return  writeMethod.invoke(obj, value);
	}
	
	public static boolean isWriteMethod(Method method) {
		if (1 == method.getParameterTypes().length) {
			return true;
		}
		
		return false;
	}
	
	
	private MethodUtil(){
		throw new UnsupportedOperationException("此类不能被继承和创造实体类");
	}
}
