@echo off

if "%~1"=="test"	goto :test
if "%~1"=="doc"		goto :doc
if "%~1"=="jar"		goto :jar
if "%~1"=="run"		goto :run
if "%~1"=="preview"	goto :preview
if "%~1"=="release"	goto :release

echo "usage: %~0 test|doc|jar|run|release"
goto :EOF

:test
mvn test
goto :EOF

:doc
mvn javadoc:javadoc
goto :EOF

:jar
mvn clean compile assembly:single
goto :EOF

:run
java -jar dist/g10-iteration-X.jar
goto :EOF

:preview
mvn exec:java -Dexec.mainClass="be.ac.ulb.infof307.g10.utils.PreviewData"
goto :EOF

:release
mvn javadoc:javadoc
mvn clean compile assembly:single
git add dist doc --force
goto :EOF
