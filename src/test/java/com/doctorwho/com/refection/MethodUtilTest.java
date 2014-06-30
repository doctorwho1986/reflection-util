package com.doctorwho.com.refection;

import static org.junit.Assert.*;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.naming.InitialContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.doctorwho.com.refection.domain.BetGroupPlan;
import com.doctorwho.com.refection.domain.BetOrder;
import com.doctorwho.com.refection.domain.BetPlan;
import com.doctorwho.com.refection.domain.Empty;

public class MethodUtilTest {
	private Class<?> classt;
	private Class<?> betGroupPlanClass;
	BeanInfo beanInfo ;
	private PropertyDescriptor[] propertyDescriptors;
	private String propertyName;
	private Method writeMethod;
	@Before
	public void init() throws Throwable{
		classt = BetPlan.class;
		betGroupPlanClass = BetGroupPlan.class;
		beanInfo = Introspector.getBeanInfo(classt);
		propertyDescriptors = beanInfo.getPropertyDescriptors();
		propertyName = "";
		writeMethod = null;
	}
	
	
	@Test
	public void testGetReadMethod() {
		String propertyName = "";
		Method readMethod = MethodUtil.getReadMethod(classt, propertyName);
		assertNull(readMethod);
		
		
		propertyName = "planNo";
		readMethod = null;
		readMethod = MethodUtil.getReadMethod(classt, propertyName);
		assertNotNull(readMethod);
		assertEquals(0, readMethod.getParameterTypes().length);
		assertEquals(String.class, readMethod.getReturnType());
		
		propertyName = "OrderId";
		readMethod = null;
		readMethod = MethodUtil.getReadMethod(classt, propertyName);
		assertNull(readMethod);
		
		propertyName = "orderId";
		readMethod = null;
		readMethod = MethodUtil.getReadMethod(classt, propertyName);
		assertNull(readMethod);
		
		propertyName = "orderId";
		readMethod = null;
		readMethod = MethodUtil.getReadMethod(betGroupPlanClass, propertyName);
		assertNull(readMethod);
		
		
		
		propertyName = "planNo";
		readMethod = null;
		readMethod = MethodUtil.getReadMethod(betGroupPlanClass, propertyName);
		assertNotNull(readMethod);
		assertEquals(0, readMethod.getParameterTypes().length);
		assertEquals(String.class, readMethod.getReturnType());
		
		propertyName = "title";
		readMethod = null;
		readMethod = MethodUtil.getReadMethod(betGroupPlanClass, propertyName);
		assertNotNull(readMethod);
		assertEquals(0, readMethod.getParameterTypes().length);
		assertEquals(String.class, readMethod.getReturnType());
		
		
		propertyName = "perAmount";
		readMethod = null;
		readMethod = MethodUtil.getReadMethod(betGroupPlanClass, propertyName);
		assertNotNull(readMethod);
		assertEquals(0, readMethod.getParameterTypes().length);
		assertEquals(BigDecimal.class, readMethod.getReturnType());
		
		propertyName = "joinEndTime";
		readMethod = null;
		readMethod = MethodUtil.getReadMethod(betGroupPlanClass, propertyName);
		assertNotNull(readMethod);
		assertEquals(0, readMethod.getParameterTypes().length);
		assertEquals(Calendar.class, readMethod.getReturnType());
	}
	
	
	@Test
	public void GetWriteMethods() {
		String propertyName = "";
		List<Method> list = MethodUtil.getWriteMethods(classt, propertyName);
		assertEquals(0, list.size());
		
		propertyName = "order";
		list.clear();
		list = MethodUtil.getWriteMethods(classt, propertyName);
		assertEquals(3, list.size());
		
		propertyName = "orderId";
		list.clear();
		list = MethodUtil.getWriteMethods(classt, propertyName);
		assertEquals(1, list.size());
		Method method = list.get(0);
		assertEquals(1, method.getParameterTypes().length);
		assertEquals(Long.class.getName(), method.getParameterTypes()[0].getName());
		
		
		
		propertyName = "orderId";
		list.clear();
		list = MethodUtil.getWriteMethods(betGroupPlanClass, propertyName);
		assertEquals(1, list.size());
		method = null;
		method = list.get(0);
		assertEquals(1, method.getParameterTypes().length);
		assertEquals(Long.class.getName(), method.getParameterTypes()[0].getName());
		
		propertyName = "joinEndTime";
		list.clear();
		list = MethodUtil.getWriteMethods(betGroupPlanClass, propertyName);
		assertEquals(1, list.size());
		method = null;
		method = list.get(0);
		assertEquals(1, method.getParameterTypes().length);
		assertEquals(Calendar.class.getName(), method.getParameterTypes()[0].getName());
		
		propertyName = "order";
		list.clear();
		list = MethodUtil.getWriteMethods(betGroupPlanClass, propertyName);
		assertEquals(3, list.size());
		
	}
	
	
	@Test
	public void GetWriteMethodByNoPrimParam(){
		
		String propertyName = "order";
		
		Method writeMethod = MethodUtil.getWriteMethodByNoPrimParam(classt, propertyName);
		assertNotNull(writeMethod);
		assertEquals(BetOrder.class.getName(), writeMethod.getParameterTypes()[0].getName());
		
		propertyName = "betCount";
		writeMethod = null;
		writeMethod = MethodUtil.getWriteMethodByNoPrimParam(classt, propertyName);
		assertNull(writeMethod);
		
		propertyName = "orderId";
		writeMethod = null;
		writeMethod = MethodUtil.getWriteMethodByNoPrimParam(classt, propertyName);
		assertNull(writeMethod);
		
		propertyName = "orderId";
		writeMethod = null;
		writeMethod = MethodUtil.getWriteMethodByNoPrimParam(betGroupPlanClass, propertyName);
		assertNull(writeMethod);
		
		propertyName = "betCount";
		writeMethod = null;
		writeMethod = MethodUtil.getWriteMethodByNoPrimParam(betGroupPlanClass, propertyName);
		assertNull(writeMethod);
		
		propertyName = "order";
		writeMethod = null;
		writeMethod = MethodUtil.getWriteMethodByNoPrimParam(betGroupPlanClass, propertyName);
		assertNotNull(writeMethod);
		assertEquals(BetOrder.class.getName(),writeMethod.getParameterTypes()[0].getName());
		assertEquals("setOrder", writeMethod.getName());

	}
	
	
	@Test
	public void GetWriteMethodByPrimitiveParam(){
		propertyName = "order";
		writeMethod = null;
		writeMethod = MethodUtil.getWriteMethodByPrimitiveParam(classt, propertyName);
		assertNotNull(writeMethod);
		assertEquals(long.class.getName(), writeMethod.getParameterTypes()[0].getName());
		
	}
	
	@Test
	public void GetWriteMethodByWrapperTypeParam(){
		propertyName = "order";
		writeMethod = null;
		writeMethod = MethodUtil.getWriteMethodByWrapperTypeParam(classt, propertyName);
		assertNotNull(writeMethod);
		assertEquals(Long.class.getName(), writeMethod.getParameterTypes()[0].getName());
	}
	
	
	
	@Test
	public void GetWriteMethod(){
		String propertyName = "order";
		
		Method writeMethod = MethodUtil.getWriteMethod(classt, propertyName,long.class);
		assertNotNull(writeMethod);
		assertEquals(long.class.getName(), writeMethod.getParameterTypes()[0].getName());
		
		propertyName = "order";
		writeMethod = null;
		writeMethod = MethodUtil.getWriteMethod(classt, propertyName,Long.class);
		assertNotNull(writeMethod);
		assertEquals(Long.class.getName(), writeMethod.getParameterTypes()[0].getName());
		
		propertyName = "order";
		writeMethod = null;
		writeMethod = MethodUtil.getWriteMethod(classt, propertyName,BetOrder.class);
		assertNotNull(writeMethod);
		assertEquals(BetOrder.class.getName(), writeMethod.getParameterTypes()[0].getName());
	}

	@Test
	public void testGetPropertyDescriptors(){
		PropertyDescriptor[] descriptors = MethodUtil.getPropertyDescriptors(BetOrder.class);
		assertEquals(7, descriptors.length);
		
		descriptors = MethodUtil.getPropertyDescriptors(BetPlan.class);
		assertEquals(10, descriptors.length);
		
		descriptors = MethodUtil.getPropertyDescriptors(BetGroupPlan.class);
		assertEquals(18, descriptors.length);
		
		descriptors = MethodUtil.getPropertyDescriptors(Empty.class);
		assertEquals(0, descriptors.length);
	}
	
	
	@Test
	public void testGetPropertyDescriptor() {
		String propertyName = "";
		PropertyDescriptor p = MethodUtil.getPropertyDescriptor(propertyDescriptors, propertyName);
		assertNull(p);
		
		propertyName = "planNo";
		p = null;
		p = MethodUtil.getPropertyDescriptor(propertyDescriptors, propertyName);
		assertNotNull(p);
		
		propertyName = "OrderId";
		p = null;
		p = MethodUtil.getPropertyDescriptor(propertyDescriptors, propertyName);
		assertNull(p);
		
		propertyName = "orderId";
		p = null;
		p = MethodUtil.getPropertyDescriptor(propertyDescriptors, propertyName);
		assertNotNull(p);
		
		propertyName = "orderId";
		p = null;
		p = MethodUtil.getPropertyDescriptor(MethodUtil.getPropertyDescriptors(BetGroupPlan.class), propertyName);
		assertNotNull(p);
	}

	@Test
	public void testGetMethodsByMethodName() {
		String methodName = "";
		List<Method> list = MethodUtil.getMethodsByMethodName(classt.getDeclaredMethods(), methodName);
		Assert.assertEquals(0, list.size());
		
		methodName = "setOrder";
		list.clear();
	    list = MethodUtil.getMethodsByMethodName(classt.getDeclaredMethods(), methodName);
		Assert.assertEquals(3, list.size());
		
		methodName = "setOrderId";
		list.clear();
	    list = MethodUtil.getMethodsByMethodName(classt.getDeclaredMethods(), methodName);
		Assert.assertEquals(1, list.size());
		
		methodName = "getMultiple";
		list.clear();
	    list = MethodUtil.getMethodsByMethodName(classt.getDeclaredMethods(), methodName);
		Assert.assertEquals(1, list.size());
		
		methodName = "setOrder";
		list.clear();
	    list = MethodUtil.getMethodsByMethodName(betGroupPlanClass.getDeclaredMethods(), methodName);
		Assert.assertEquals(0, list.size());
		
		methodName = "setOrder";
		List<Method> methodlList = new ArrayList<Method>();
		methodlList.addAll(Arrays.asList(betGroupPlanClass.getDeclaredMethods()));
		Class<?> supClass = betGroupPlanClass.getSuperclass();
		while (null != supClass) {
			methodlList.addAll(Arrays.asList(supClass.getDeclaredMethods()));
			supClass = supClass.getSuperclass();
		}
		
	    list = MethodUtil.getMethodsByMethodName(methodlList.toArray(new Method[methodlList.size()]), methodName);
		Assert.assertEquals(3, list.size());
	}
	
	@Test
	public void InvokeWriteMethod() throws Throwable{
		BetPlan betPlan = new BetPlan();
		propertyName = "";
		Object object = MethodUtil.invokeWriteMethod(betPlan, propertyName, 1);
		assertNull(object);
		
		propertyName = "id";
		object = null;
		object = MethodUtil.invokeWriteMethod(betPlan, propertyName, 1L);
		assertNull(object);
		
		propertyName = "orderId";
		object = null;
		object = MethodUtil.invokeWriteMethod(betPlan, propertyName, 1L);
		assertNull(object);
		
		propertyName = "order";
		Object newInstance = classt.newInstance();
		MethodUtil.invokeWriteMethod(newInstance, propertyName, new Object[]{2L});
		
		BetPlan plan = (BetPlan) newInstance;
		
		assertEquals(2L, plan.getOrder().getId().longValue());
		
		
		BetOrder order = new BetOrder();
		order.setId(5L);
		newInstance = classt.newInstance();
		MethodUtil.invokeWriteMethod(newInstance, propertyName, new Object[]{order});
		
		plan = null;
	    plan = (BetPlan) newInstance;
		assertEquals(order.getId(), plan.getOrder().getId());
		
		Object betGroupPlan = betGroupPlanClass.newInstance();
		BetGroupPlan before = (BetGroupPlan) betGroupPlan;
		BetGroupPlan after = new BetGroupPlan();
		after.setPlanNo("d1111");
		after.setTitle("title");
		BetOrder bOrder = new BetOrder();
		bOrder.setId(135L);
		bOrder.setSellChannel(166L);
		after.setOrder(bOrder);
	   	Object  aObject = JSON.toJSON(after);
	   	System.out.println(aObject);
		propertyName = "planNo";
		MethodUtil.invokeWriteMethod(before, propertyName, new Object[]{"d1111"});
		MethodUtil.invokeWriteMethod(before, "title", new Object[]{"title"});
		MethodUtil.invokeWriteMethod(before, "order", new Object[]{bOrder});
		Object fObject = JSON.toJSON(before);
		assertEquals(aObject, fObject);
		System.out.println(fObject);
		
	}

}
