# Sistema de Gestión de Proyectos Simple

## Descripción
Sistema simplificado desarrollado en Java para gestión básica de proyectos y empleados. **Sin uso de ArrayLists** - utiliza arrays simples para mantener el código más sencillo.

## Funcionalidades Principales

### 1. Agregar Proyecto
- Registro de nuevos proyectos con código único
- Información básica: código, descripción, precio base, tipo y mes de inicio
- Tipos disponibles: Programación, Ciencia de Datos, Redes, IA

### 2. Agregar Empleado
- Registro de empleados con DNI único
- Información completa: DNI, nombre, distrito, género, edad, función
- Funciones disponibles: Líder, Analista, Personal de planta

### 3. Mostrar Proyectos con Empleados
- Vista de todos los proyectos registrados
- Lista de empleados asignados a cada proyecto
- **Funcionalidad interactiva**: Si un proyecto no tiene empleados, ofrece asignarlos automáticamente

### 4. Mostrar Pagos por Empleado
- Consulta de pagos realizados a un empleado específico
- Cálculo de salarios según función:
  - **Líder**: 50% adicional sobre precio base
  - **Analista**: 20% adicional sobre precio base  
  - **Personal de planta**: precio base
- **Funcionalidad interactiva**: Si un empleado no tiene pagos, ofrece registrar uno automáticamente

## Características Técnicas

### Estructura Simplificada
- **Arrays simples** en lugar de ArrayLists
- **4 opciones principales** en el menú
- **Máximos configurables**:
  - 100 empleados
  - 50 proyectos
  - 500 pagos
  - 8 empleados por proyecto

### Clases Principales
```
Clases/
├── Empleado.java          # Gestión de empleados (sin ArrayList)
├── Proyecto.java          # Gestión de proyectos (arrays simples)
├── Pago.java             # Gestión de pagos
└── GestorProyectos.java  # Lógica principal (arrays en lugar de listas)
```

### Cálculo de Salarios
- **Fórmula**: `Precio base × Horas trabajadas × Factor función`
- **Factores**:
  - Líder: 1.5 (50% adicional)
  - Analista: 1.2 (20% adicional)
  - Personal de planta: 1.0 (precio base)

## Cómo Usar

### Ejecución
```bash
# Opción 1: Usar el script batch
ejecutar.bat

# Opción 2: Usar PowerShell
ejecutar.ps1

# Opción 3: Compilar y ejecutar manualmente
cd src\main\java
javac -encoding UTF-8 -d ..\..\..\target\classes Clases\*.java com\mycompany\ejercicio11_gestionproyectos\*.java
cd ..\..\..
java -cp target\classes com.mycompany.ejercicio11_gestionproyectos.Ejercicio11_GestionProyectos
```

### Flujo Recomendado
1. **Agregar empleados** → Registrar personal disponible
2. **Agregar proyectos** → Crear proyectos a desarrollar
3. **Mostrar proyectos con empleados** → Asignar equipos de trabajo
4. **Mostrar pagos por empleado** → Registrar y consultar pagos

## Validaciones
- ✅ DNI único por empleado
- ✅ Código único por proyecto
- ✅ Límite máximo de empleados por proyecto (8)
- ✅ Verificación de asignación empleado-proyecto para pagos
- ✅ Validación de datos de entrada

## Mejoras Implementadas
- **Interfaz más amigable**: Menús interactivos con confirmaciones
- **Asignación automática**: El sistema ofrece asignar empleados cuando es necesario
- **Registro automático de pagos**: Facilita el proceso de pago
- **Sin dependencias externas**: Solo usa arrays nativos de Java
- **Código más simple**: Fácil de entender y mantener

## Diferencias con la Versión Original
- ❌ **Eliminado**: ArrayLists y clases Lista*
- ❌ **Eliminado**: Menú complejo con 10 opciones
- ❌ **Eliminado**: Restricciones complejas por función
- ✅ **Agregado**: Interfaz más intuitiva
- ✅ **Agregado**: Asignación automática de empleados
- ✅ **Agregado**: Registro automático de pagos
- ✅ **Simplificado**: Solo 4 funciones principales

El sistema mantiene toda la funcionalidad esencial pero con un enfoque más simple y directo.
