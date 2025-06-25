Write-Host "========================================" -ForegroundColor Cyan
Write-Host " SISTEMA DE GESTION DE PROYECTOS" -ForegroundColor Cyan
Write-Host "========================================" -ForegroundColor Cyan
Write-Host ""

Write-Host "Compilando el proyecto..." -ForegroundColor Yellow
Set-Location "src\main\java"

$compileResult = Start-Process -FilePath "javac" -ArgumentList "-encoding", "UTF-8", "-d", "..\..\..\target\classes", "Clases\*.java", "com\mycompany\ejercicio11_gestionproyectos\*.java" -Wait -PassThru -NoNewWindow

if ($compileResult.ExitCode -eq 0) {
    Write-Host "Compilacion exitosa!" -ForegroundColor Green
    Write-Host ""
    Write-Host "Iniciando la aplicacion..." -ForegroundColor Yellow
    Set-Location "..\..\..\"
    java -cp "target\classes" "com.mycompany.ejercicio11_gestionproyectos.Ejercicio11_GestionProyectos"
} else {
    Write-Host "Error en la compilacion!" -ForegroundColor Red
    Read-Host "Presiona Enter para continuar"
}
