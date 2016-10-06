package com.connect.portal.service;

import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;

public class MockJndiContext implements InitializingBean {
		private Map<String, Object> context;

		public void setContext(Map<String, Object> context) {
			this.context = context;
		}

		public void afterPropertiesSet() throws Exception {
			SimpleNamingContextBuilder builder = SimpleNamingContextBuilder.emptyActivatedContextBuilder();
			
			for (Map.Entry<String, Object> entry : context.entrySet()) {
				builder.bind(entry.getKey(), entry.getValue());
			}
			
			builder.activate();
		}
	}

