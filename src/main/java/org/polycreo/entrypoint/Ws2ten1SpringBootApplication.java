/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.polycreo.entrypoint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AliasFor;

/**
 * Indicates a {@link Configuration configuration} class that declares one or more
 * {@link Bean @Bean} methods and also triggers {@link SpringBootApplication @SpringBootApplication}.
 *
 * <p>If the property {@code polycreo.scan-base-packages} is not defined, then Spring scans
 * components based on the class that annotated with this annotation.
 * If the property {@code polycreo.scan-base-packages} is defined, the base packages is configured
 * (the package of annotated class is not included).</p>
 *
 * @see SpringBootApplication
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootApplication
public @interface PolycreoSpringBootApplication {
	
	/**
	 * Exclude specific auto-configuration classes such that they will never be applied.
	 *
	 * @return the classes to exclude
	 */
	@AliasFor(annotation = SpringBootApplication.class)
	Class<?>[] exclude() default {};
	
	/**
	 * Exclude specific auto-configuration class names such that they will never be applied.
	 *
	 * @return the class names to exclude
	 */
	@AliasFor(annotation = SpringBootApplication.class)
	String[] excludeName() default {};
	
	/**
	 * Base packages to scan for annotated components. Use {@link #scanBasePackageClasses}
	 * for a type-safe alternative to String-based package names.
	 *
	 * @return base packages to scan
	 */
	@AliasFor(annotation = SpringBootApplication.class)
	String[] scanBasePackages() default {
		"${polycreo.scan-base-packages:}"
	};
	
	/**
	 * Type-safe alternative to {@link #scanBasePackages} for specifying the packages to
	 * scan for annotated components. The package of each class specified will be scanned.
	 *
	 * <p>Consider creating a special no-op marker class or interface in each package that
	 * serves no purpose other than being referenced by this attribute.</p>
	 *
	 * @return base packages to scan
	 */
	@AliasFor(annotation = SpringBootApplication.class)
	Class<?>[] scanBasePackageClasses() default {};
	
}
