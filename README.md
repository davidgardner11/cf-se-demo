# Cloud Foundry Demo App

## For this to work, you will need to VPN into the se-demo cf cluster

## Instructions
1. Use an RDP (remote desktop) client and remote into the demo user box specified in the email.
1. The following instructions should all take place on the Windows VM
1. Open a browser, preferably Chrom, navigate to the [demo repository](http://github.com/tcmartin24/cf-se-demo) and download the zip file
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
