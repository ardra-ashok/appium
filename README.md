# appium_learnings

{
"appium:APP": "//Users//aashok//IdeaProjects//appium_learnings//src//test//resources//ApiDemos-debug.apk",
"appium:deviceName": "Pixel_3a_testEmulator",
"platformName": "android",
"appium:automationName": "UIAutomator2"
}
command to get the package name and activity name
    adb shell dumpsys window | grep -E 'mCurrentFocus'

io.appium.android.apis(package name)/io.appium.android.apis.preference.PreferenceDependencies(activity name)

export JAVA_HOME=$(/usr/libexec/java_home)
export PATH=$PATH:/usr/local/git/bin:/usr/local/bin
export ANDROID_HOME=/Users/aashok/Library/Android/sdk
export ANDROID_SDK_ROOT=/Users/aashok/Library/Android/sdk
export PATH=$PATH:$ANDROID_HOME/platform-tools
export PATH=$PATH:$ANDROID_HOME/tools
export PATH=$PATH:$ANDROID_HOME/tools/bin
export PATH=$PATH:$ANDROID_HOME/emulator
export M2_HOME=/usr/local/opt/maven/libexec
export PATH=$M2_HOME/bin:$PATH