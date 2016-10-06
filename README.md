# Template-portal


## Clone the project
1. create a directory for your new app, mkdir my-new-app & cd my-new-app
2. git clone git@git.labs.nuance.com:dcs-webteam/reactjs-springmvc-app-template.git /my-new-app
3. reinitialize the git settings, git init


You have 3 options regarding how to configure and run this application. 


# Option 1 - with STS

A benefit of this option is that is closer to how the app would acutally be deployed in the real world and it allows you app to fully interact with the back-end SPROCs. One downside is that you have to deal with the bloat of STS. 

1. Import -> Checkout MVN project from SVN  - https://subversion.assembla.com/svn/uieauto_mycar/Server/Portals/[APPNAME]/Trunk

2. Edit the sts deployment assembly
	2.1 Edit .settings/org.eclipse.wst.common.component  to contain the following

<?xml version="1.0" encoding="UTF-8"?><project-modules id="moduleCoreId" project-version="1.5.0">
    <wb-module deploy-name="APPNAME">
        <wb-resource deploy-path="/META-INF" source-path="/src/main/resources"/>
        <wb-resource deploy-path="/" source-path="/target/m2e-wtp/web-resources"/>
        <wb-resource deploy-path="/WEB-INF/classes" source-path="/src/main/java"/>
        <wb-resource deploy-path="/WEB-INF/classes" source-path="/src/main/resources"/>
        <wb-resource deploy-path="/" source-path="/src/main/webapp/WEB-INF"/>
        <wb-resource deploy-path="/" source-path="/src/main/webapp" tag="defaultRootSource"/>
        <property name="java-output-path" value="/APPNAME/target/classes"/>
        <property name="context-root" value="app-name"/>
    </wb-module>
</project-modules>

3. Run Maven build
	3.1 Right click on the project -> Run As -> Maven build... -> enter 'clean package' as the goal -> Run
	3.2 why: this resolves maven (java) dependencies and gulp (javascript) dependences, and also runs the gulp build tasks outlined in gulp.js
	3.3 what does it do: adds the maven java dependencies to WEB-INF/classes/lib and the gulp build task copies the front-end resources into the directory where the server expects to find them (WEB-INF)
	3.4 what are the implications: when running the app from sts if you make changes to any front-end resources (JS/HTML/CSS), you'll need to stop the server, Run a Maven build, right-click on the project and refresh (so STS will refresh it's copy and pick up all the changes made by the maven build), then restart the server.

4. If Step 3 fails, cd into src/main and run 'sudo npm install' then try 3 again

5. Refresh the project, deploy on the server and run 

6. The server should start without any errors, and the CSE portal (using CSE as a base application for now) should be displayed when you hit localhost:{port}/{appName}

7. Ping me if you're unable to get the app to run. 


# Option 2 - without STS

The benefit here is that is really quick to setup and focus on the front-end of the application (HTML, JS, CSS, etc). This option is probably ideal in the initial dev phases when there is much work to be done on the front end. With this option all calls to SPROCs will fail, as there is no back-end java service to support them. 

1. cd to src/main

2. npm run watch

3. localhost:{port}/



# Option 3 - use both 1 & 2

Complete both setups and use whichever  one is more appropriate given the specific task you are working on 

# General Deployment instructions

 This instruction is common to all our apps. Each app that is churned out of this template will likely have its own unique deployment instruction.
 The template app is deployed via RPM by using yum commands 
 
 step 1 : Run 'yum list available' to look for available packages that are ready to be installed 
 step 2 : Run 'yum info [package name]' to display a detailed information regarding the app you are about to install.
        This ensures that you are deploying the right package
 step 3 : Run 'yum remove or erase [package name]' this will remove the previous package that was installed
 step 4 : Run 'yum install [package name]' this installs the application, install dependencies 
 step 5 : Run 'yum help' if you need further assistance on the deployment 
 

