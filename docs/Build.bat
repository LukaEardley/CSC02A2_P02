@echo off
cls
setlocal enabledelayedexpansion

REM Paths for Java
echo Change JAVA_HOME path
REM SET JAVA_HOME=
set path="C:\Program Files\jdk-11.0.10+9\bin";%path%
rem SET PATH=%PATH%;%JAVA_HOME%

REM Move to correct folder
echo Build script set to run in Project folder
cd ..

REM Variables for batch
set ERRMSG=
set PRAC_BIN=.\bin
set PRAC_DOCS=.\docs
set PRAC_LIB=.\lib\*
set PRAC_SRC=.\src

REM Clean all class files from bin folder
:CLEAN
echo ~~~ Cleaning project ~~~
DEL /S %PRAC_BIN%\*.class
RMDIR /Q /S %PRAC_DOCS%\JavaDoc
IF /I "%ERRORLEVEL%" NEQ "0" (
    echo !!! Error cleaning project !!!
)

REM Compile project by compiling just Main. Main will reference required classes
:COMPILE
echo ~~~ Compiling project ~~~
javac -sourcepath %PRAC_SRC% -cp "%PRAC_BIN%;%PRAC_LIB%" -d %PRAC_BIN% %PRAC_SRC%\Main.java
IF /I "%ERRORLEVEL%" NEQ "0" (
    set ERRMSG=!!! Error compiling project !!!
    GOTO ERROR
)

REM Generate JavaDoc for project for only acsse subpackage
:JAVADOC
echo ~~~ Generate JavaDoc for project ~~~
javadoc -sourcepath %PRAC_SRC% -classpath %PRAC_BIN%;%PRAC_LIB% -use -version -author -d %PRAC_DOCS%\JavaDoc -subpackages acsse
IF /I "%ERRORLEVEL%" NEQ "0" (
    echo !!! Error generating JavaDoc for project !!!
)
cls
REM Run project by running Main
:RUN
echo ~~~ Running project ~~~
java -cp %PRAC_BIN%;%PRAC_LIB% Main
IF /I "%ERRORLEVEL%" NEQ "0" (
    set ERRMSG=!!! Error running project !!!
    GOTO ERROR
)
GOTO END

REM Something went wrong, display error
:ERROR
echo !!! Fatal error with project !!!
echo %ERRMSG%

REM Move back to docs folder and wait
:END
echo ~~~ End ~~~
cd %PRAC_DOCS%
pause