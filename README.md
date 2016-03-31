# Cloud Foundry Demo App

## For this to work, you will need to VPN into the se-demo cf cluster
## Requirements
+ Java 8 JDK (http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
+ VPN client that can open ovpn files. Here's a list of some portable VPN clients for Windows
    - [OpenVPN Portable - Windows](https://sourceforge.net/projects/ovpnp/files/latest/download)
    - [TunnelBlick - Mac](https://tunnelblick.net/release/Tunnelblick_3.6.0a_build_4543.4546.dmg)

## Instructions
1. Unzip the GitHub sales demo project
1. Edit the gradle.properties file with a simple text editor and update it with the account information that was given/emailed to you.
1. Push v1 of demo app: ./gradlew cfLogin cfDeploy -Pv1
1. Make note of deployed app's route (a URL like http://*-green.10.141.158.128.xip.io)
1. Generate generic/public route for demo app: ./gradlew cfLogin cfSwapDeployed
1. Make note of deployed app's additional public route
1. You may now demo the app at its specific route (*-green or *-blue) or its public route
1. Push v2 of demo app: ./gradlew cfLogin cfDeploy -Pv2
1. Make note of v2's route
1. You may now switch the public route from v1 to v2: ./gradlew cfLogin cfSwapDeployed
