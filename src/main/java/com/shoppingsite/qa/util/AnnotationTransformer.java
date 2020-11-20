package com.shoppingsite.qa.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

import com.sun.net.httpserver.Authenticator.Retry;


public class AnnotationTransformer implements IAnnotationTransformer {
	 
	@Override
	    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
	        annotation.setRetryAnalyzer((Class<? extends IRetryAnalyzer>) Retry.class);
	    }
}
