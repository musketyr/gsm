package org.gaelyk.gsm;

import java.lang.annotation.Documented
import java.lang.annotation.ElementType
import java.lang.annotation.Inherited
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

import org.codehaus.groovy.transform.GroovyASTTransformationClass

/**
 * Generates script class based on this method
 * 
 * @author Vladimir Orany
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@Inherited
@GroovyASTTransformationClass("org.gaelyk.gsm.ScriptMethodTransformation")
public @interface ScriptMethod {
}
