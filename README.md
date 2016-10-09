# `ios10Test`

## `About`

Autmates an iOS app running in an iOS 10 iPhone Simulator using appium and the appium-java-client. The app is Test.app.zip and comes from the appium-java-client unit test

See 
[appium](https://github.com/appium/appium)
[appium-java-client](https://github.com/appium/java-client)

## `Setup`

Xcode 10 installed

Accept the xcode license 

```bash
sudo xcodebuild -license
```

Install [Homebrew](http://brew.sh/)

Install node using homebrew and appium using npm
```bash
brew install node
npm install -g appium@beta
```

## `Runnign the Test`
```bash
./gradlew clean test
```
The test use the Appium server, and uses the AppiumDriverLocalService to start and stop the Appium server within the tests without having to manage Appium manually.

If Appium is installed in a location other than **/usr/local/lib/node_modules/appium**, edit TestBase::28
```java
.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
```







