@echo off

set DIR=%~dp0
set APP_BASE_DIR=%DIR:~0,-1%

set JAVA_EXE=%JAVA_HOME%\bin\java.exe

set CLASSPATH=%APP_BASE_DIR%\gradle\wrapper\gradle-wrapper.jar

"%JAVA_EXE%" -Dorg.gradle.appname=gradlew -classpath "%CLASSPATH%" org.gradle.wrapper.GradleWrapperMain %*