'use strict';

describeComponent('component/user_auth', function () {

  // Initialize the component and attach it to the DOM
  beforeEach(function () {
    this.setupComponent();
  });


it('verify the expected initial state of the default attributes', function() {

      expect(this.component.attr.loginSelector).toBe("#tpl-login");
      expect(this.component.attr.breadcrumbSelector).toBe("#user_details");
      expect(this.component.attr.logoutBtnSelector).toBe("#logout");
      expect(this.component.attr.loginBtnSelector).toBe("#Login_Btn");
      expect(this.component.attr.loginFormSelector).toBe("#userLogin_Form");
  });

it('should have only the expected attributes', function() {
    expect(hasUnexpectedAttributes(this.component.attr)).toBe(false);
});

it('should render the  login page',function(){
	
	 var fnSpy=spyOn(this.component,'renderView')
     this.component.handleLoginPage(null);
	 expect(fnSpy).toHaveBeenCalledWith('login',null,'loginSelector');
	
});


it('should be defined', function () {
    expect(this.component).toBeDefined();
  });

  it('should exist',function(){
	  expect(this.component).toExist();
  });


});

function hasUnexpectedAttributes(attrObj) {
    var expectedAttrs = {
    	loginSelector: 1,
        breadcrumbSelector: 1,
        logoutBtnSelector: 1,
        loginBtnSelector: 1,
        loginFormSelector: 1
    };

    var containsUnexpected = false;

    Object.getOwnPropertyNames(attrObj).forEach(function(attr) {
        containsUnexpected = expectedAttrs[attr] == undefined ? true : false;
    });

    return containsUnexpected;
}