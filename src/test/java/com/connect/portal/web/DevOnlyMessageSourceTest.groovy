package com.connect.portal.web;

import spock.lang.Specification;

public class DevOnlyMessageSourceTest extends Specification
{
	DevOnlyMessageSource source 
	
	def setup() {
		source = new DevOnlyMessageSource()
	}
	
	def "resolveCode methods should always return the requested message code"() {
		
		expect:
			msgCode == source.resolveCodeWithoutArguments(msgCode, Locale.US)
			msgFormatCode == source.resolveCode(msgFormatCode, Locale.US).toPattern()
		where:
			msgCode << ["foo.message.code", "system.resource.string", "portal.ui.string"]
			msgFormatCode << ["foo.message.code", "system.resource.string", "portal.ui.string"]
	}
}
