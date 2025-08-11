#!/usr/bin/env sh

##############################################################################
## Gradle start up script for UN*X
##############################################################################

# Attempt to locate JAVA_HOME, then run the wrapper jar

DIR="$0"
# Resolve symlinks
while [ -h "$DIR" ] ; do
  ls=`ls -ld "$DIR"`
  link=`expr "$ls" : '.*-> \(.*\)$'`
  if expr "$link" : '/.*' > /dev/null; then
    DIR="$link"
  else
    DIR=`dirname "$DIR"`/"$link"
  fi
done
APP_BASE_DIR=`cd "`dirname "$DIR"`"; pwd`

JAVA_EXE="${JAVA_HOME:+$JAVA_HOME/bin/}java"

CLASSPATH=$APP_BASE_DIR/gradle/wrapper/gradle-wrapper.jar

exec "$JAVA_EXE" -Dorg.gradle.appname=gradlew -classpath "$CLASSPATH" org.gradle.wrapper.GradleWrapperMain "$@"