# Cloud Foundry Demo App



## Linux/OS X Instructions
The original instructions for this demo were provided for a user executing commands on Microsoft Windows. I've modified the instructions below for a Mac OS X/Linux user. 


1. Open a browser, preferably Chrome, navigate to the [demo repository](https://github.com/davidgardner11/cf-se-demo) and download the zip file. (Alternatively, you can use Github to clone the repo to your local machine)
1. Double click to unzip the file
1. Open a Terminal client (Click the search icon in upper right and type `terminal` into the finder) and follow the instructions below
1. Navigate to the folder containing the downloaded zip file (cf-se-demo.zip). In my case, I can get to the Downloads folder by typing: `$ cd /Users/davidgardner/Downloads`
1. Open the `gradle.properties` file with a simple text editor and update the properties based on your specific account and application details
1. Navigate to the `deploy.gradle` file (in the `gradle` folder) and confirm the `target` and `domain` values are correct for the Cloud Foundry platform you are using. (Currently set for AppFog running in the US East data center)
1. Push v1 of the demo app. type: `./gradlew cfLogin cfDeploy -Pv1`. This command tells Gradle to login a Cloud Foundry platform (e.g. AppFog) and deploy v1. The application route will be {appname}-green.{domain}, which is for the `green` version of the app. In my case, `cf-se-demo-green.useast.appfog.ctl.io`. Note: the appname must be unique on a given Cloud Foundry deployment
1. Now, generate the public, primary route: `./gradlew cfLogin cfSwapDeployed`. This application route will be re-assigned between the `green` and `blue` apps, depending on which one is the primary
1. Note the deployed app's additional primary route. In my case, `cf-se-demo.useast.appfog.ctl.io`
1. Now push v2 of the app, this will be the `blue` version: `./gradlew cfLogin cfDeploy -Pv2`
1. Make note of the route for the `blue` version of the app. In my case, `cf-se-demo-blue.useast.appfog.ctl.io`
1. Now both versions of the app are deployed. (The only difference between them is the version text and color above the input field). 
1. Use your browser to open the app at either route (`green` or `blue`) or its public, primary route. The primary route should open the `green` version.
1. Now that both versions of the app are deployed, test out your blue-green deployment by switching the primary route from v1 to v2: `./gradlew cfLogin cfSwapDeployed`.
1. Repeat the process by making changes and deploying new versions of the app!


## Windows Instructions
1. Use an RDP (remote desktop) client and remote into the demo user box specified in the email.
1. The following instructions should all take place on the Windows VM
1. Open a browser, preferably Chrome, navigate to the [demo repository](http://github.com/tcmartin24/cf-se-demo) and download the zip file
1. Unzip the file. You may want to use 7-zip which (may) be installed already.
1. Open Power Shell (there's a small icon for it at the bottom left of the screen near the start menu)
1. If you downloaded the zip file to the Downloads directory (default), type: cd Downloads\cf-se-demo
1. Edit the gradle.properties file with a simple text editor and update it with the account information that was given/emailed to you.
1. Push v1 of demo app: ./gradlew cfLogin cfDeploy -Pv1
1. Make note of deployed app's route (a URL like http://*-green.10.141.158.128.xip.io)
1. Generate generic/public route for demo app: ./gradlew cfLogin cfSwapDeployed
1. Make note of deployed app's additional public route
1. You may now demo the app at its specific route (*-green or *-blue) or its public route
1. Push v2 of demo app: ./gradlew cfLogin cfDeploy -Pv2
1. Make note of v2's route
1. You may now switch the public route from v1 to v2: ./gradlew cfLogin cfSwapDeployed


## Useful References
1. https://docs.cloudfoundry.org/buildpacks/java/build-tool-int.html
1. https://github.com/cloudfoundry/cf-java-client

 

