@ECHO OFF
set path="C:\Users\Arlo\Desktop\jdk-11.0.10+9\bin";%path%
echo %cd%
set PRAC_BIN=.\bin
set PRAC_DOCS=.\docs
set PRAC_SRC=.\src

javac .\src\Main.java .\src\Drones.java .\src\Sensor.java
PAUSE
cd .\src
java Main
PAUSE