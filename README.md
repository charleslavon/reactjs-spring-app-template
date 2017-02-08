//TODO - update the java configs to be a bit more streamline and use SpringBoot

This ReactJS SpringFramework boilerplate app is to be used for quickly spinning up web applications with all the necessary configs to support dev and production builds.


## Clone the project
1. create a directory for your new app, mkdir my-new-app & cd my-new-app
2. git clone {repoURL} my-new-app
3. reinitialize the git settings, git init


You have 3 options regarding how to configure and run this application.


# Option 1 - with Eclipse/STS or other Java IDE

A benefit of this option is that is closer to how the app would acutally be deployed in the real world (via a servlet container) and it allows you app to fully interact with Java backend services (if any). One downside is that you have to deal with the bloat of your Java IDE.

1. Import the project into your IDE

2. Update the Eclipse deployment assembly config so it knows where it find your web resources
	2.1 Edit .settings/org.eclipse.wst.common.component  to contain the following

<?xml version="1.0" encoding="UTF-8"?><project-modules id="moduleCoreId" project-version="1.5.0">
    <wb-module deploy-name="APPNAME">
        <wb-resource deploy-path="/META-INF" source-path="/src/main/resources"/>
        <wb-resource deploy-path="/" source-path="/target/m2e-wtp/web-resources"/>
        <wb-resource deploy-path="/" source-path="/src/main/webapp" tag="defaultRootSource"/>
        <wb-resource deploy-path="/WEB-INF/classes" source-path="/src/main/java"/>
        <wb-resource deploy-path="/WEB-INF/classes" source-path="/src/main/resources"/>
        <property name="java-output-path" value="/APPNAME/target/classes"/>
        <property name="context-root" value="app-name"/>
    </wb-module>
</project-modules>

3. Run Maven build
	3.1 Right click on the project -> Run As -> Maven build... -> enter 'clean package' as the goal -> Run
	3.2 why: this resolves maven (java) dependencies and gulp (javascript) dependences, and also runs the webpack build
	3.3 what does it do: adds the maven java dependencies to WEB-INF/classes/lib and the webpack build compiles the front-end resources and copies them into the directory where the server expects to find them (webapps)
	3.4 what are the implications: when running the app from sts if you make changes to any front-end resources (JS/HTML/CSS), you'll need to stop the server, Run a Maven build, right-click on the project and refresh (so STS will refresh it's copy and pick up all the changes made by the maven build), then restart the server.

4. If Step 3 fails, cd into src/main and run 'sudo npm install' then try 3 again

5. Refresh the project, deploy on the server and run

6. The server should start without any errors and should be available @ localhost:{port}/{appName}



# Option 2 - without STS

The benefit here is that is really quick to setup and focus on the front-end of the application (HTML, JS, CSS, etc). This option is probably ideal in the initial dev phases when there is much work to be done on the front end. With this option any calls to backend Java services will fail, as you're running only the font-end javasript context, not the fullly backed java servlet application.

1. cd to src/main

2. npm start

3. localhost:3001/



# Option 3 - use both 1 & 2

Complete both setups and use whichever  one is more appropriate given the specific task you are working on
