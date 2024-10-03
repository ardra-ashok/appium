# appium_learnings

{
"appium:APP": "//Users//aashok//IdeaProjects//appium_learnings//src//test//resources//ApiDemos-debug.apk",
"appium:deviceName": "Pixel_3a_testEmulator",
"platformName": "android",
"appium:automationName": "UIAutomator2"
}
command to get the package name and activity name
    adb shell dumpsys window | grep -E 'mCurrentFocus'

io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies