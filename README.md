1.) Push v1 of demo app: ./gradlew cfDeploy -Pv1
2.) Make note of deployed app's route
3.) Generate generic/public route for demo app: ./gradlew cfSwapDeployed
4.) Make note of deployed app's additional public route
5.) You may now demo the app at its specific route or its public route
6.) Push v2 of demo app: ./gradlew cfDeploy -Pv2
7.) Make note of v2's route
8.) You may now switch the public route from v1 to v2: ./gradlew cfSwapDeployed