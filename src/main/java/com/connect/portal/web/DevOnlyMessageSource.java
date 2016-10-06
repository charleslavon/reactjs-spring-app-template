package com.connect.portal.web;

import java.text.MessageFormat;
import java.util.Locale;

import org.springframework.context.support.AbstractMessageSource;

public class DevOnlyMessageSource extends AbstractMessageSource 
{
	
	@Override
	protected MessageFormat resolveCode(String code, Locale locale) {
		MessageFormat result = new MessageFormat(code);
		result.setLocale(locale);

		return result;
	}

	@Override
	protected String resolveCodeWithoutArguments(String code, Locale locale) {
		return code;
	}
}
