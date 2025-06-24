@echo off
echo ========================================
echo  SISTEMA DE GESTION DE PROYECTOS
echo ========================================
echo.

echo Compilando el proyecto...
cd src\main\java
javac -encoding UTF-8 -d ..\..\..\target\classes Clases\*.java com\mycompany\ejercicio11_gestionproyectos\*.java

if %ERRORLEVEL% EQU 0 (
    echo Compilacion exitosa!
    echo.
    echo Iniciando la aplicacion...
    cd ..\..\..
    java -cp target\classes com.mycompany.ejercicio11_gestionproyectos.Ejercicio11_GestionProyectos
) else (
    echo Error en la compilacion!
    pause
)
