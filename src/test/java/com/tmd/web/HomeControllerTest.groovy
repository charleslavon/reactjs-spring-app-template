package com.tmd.web

import org.springframework.context.MessageSource
import org.springframework.security.authentication.AuthenticationManager
import com.tmd.web.HomeController
import spock.lang.Specification


class HomeControllerTest extends Specification {

	HomeController testClass

	def setup() {
		testClass = new HomeController()
	}

	def "GET / should return the homepage landing view"() {
		expect:
			testClass.home() == "index"
	}
}
