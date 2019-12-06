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
package org.ws2ten1.entrypoint;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ws2ten1.module1.Module1;
import org.ws2ten1.module2.Module2;
import org.ws2ten1.module3.Module3;

/**
 * Test for {@link TestEntrypoint}.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class Ws2ten1SpringBootApplicationTest_WithoutProperty {
	
	@Autowired
	ApplicationContext context;
	
	
	@Test
	public void testBeanRegistration() {
		context.getBean(Module0.class);
		assertThatThrownBy(() -> context.getBean(Module1.class))
			.isInstanceOfAny(NoSuchBeanDefinitionException.class);
		assertThatThrownBy(() -> context.getBean(Module2.class))
			.isInstanceOfAny(NoSuchBeanDefinitionException.class);
		assertThatThrownBy(() -> context.getBean(Module3.class))
			.isInstanceOfAny(NoSuchBeanDefinitionException.class);
	}
}
