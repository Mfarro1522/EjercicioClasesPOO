# 🌟 Proyecto de Herencia - Star Wars: Usuarios de la Fuerza

Este proyecto implementa conceptos de herencia en Java usando el universo de Star Wars como temática. Está basado en la estructura del proyecto de empleados pero adaptado para usuarios de la Fuerza.

## 📋 Estructura del Proyecto

### Jerarquía de Clases

```
UsuarioFuerza (Clase Padre)
├── Jedi
├── Sith
└── PadawanJedi
```

### 🎯 Clases Implementadas

#### 1. **UsuarioFuerza** (Clase Padre)
- `codigo`: Identificador único del usuario
- `nombre`: Nombre del usuario de la fuerza
- `edad`: Edad del usuario
- `planeta`: Planeta de origen

#### 2. **Jedi** (Hereda de UsuarioFuerza)
- `rango`: Rango dentro de la orden Jedi (Padawan, Knight, Master, etc.)
- `aniosEntrenamiento`: Años de entrenamiento como Jedi
- `colorSable`: Color del sable de luz

#### 3. **Sith** (Hereda de UsuarioFuerza)
- `nivelOscuridad`: Nivel de conexión con el lado oscuro (1-10)
- `titulo`: Título Sith (Darth, Lord, etc.)
- `tieneMaestroSith`: Indica si tiene un maestro Sith

#### 4. **PadawanJedi** (Hereda de UsuarioFuerza)
- `maestroJedi`: Nombre del maestro Jedi
- `mesesEntrenamiento`: Meses de entrenamiento como Padawan
- `nivelFuerza`: Nivel de dominio de la Fuerza (1.0-10.0)

#### 5. **ListaUsuariosFuerza**
- Maneja una lista de usuarios de la fuerza
- Permite agregar usuarios y mostrar todos los datos

## 🚀 Características Implementadas

- ✅ **Herencia**: Todas las clases heredan de `UsuarioFuerza`
- ✅ **Polimorfismo**: El método `mostrarDatos()` se sobrescribe en cada clase hija
- ✅ **Encapsulación**: Atributos privados con métodos getter
- ✅ **Reutilización de código**: Uso de `super()` para llamar al constructor padre
- ✅ **Manejo de listas**: Implementación de lista para múltiples usuarios
- ✅ **Interfaz gráfica**: Uso de `JOptionPane` para mostrar resultados

## 🎮 Ejecución

El programa crea instancias de:
- 1 Usuario de la Fuerza genérico (Rey Skywalker)
- 1 Jedi (Luke Skywalker)
- 1 Sith (Darth Vader/Anakin Skywalker)
- 1 Padawan (Ahsoka Tano)

Luego muestra todos los datos usando polimorfismo y herencia.

## 🛠️ Compilación y Ejecución

```bash
# Compilar
javac -cp . com\mycompany\_ejercicioherencia\App.java Datos\*.java Listas\*.java

# Ejecutar
java -cp . com.mycompany._ejercicioherencia.App
```

## 🌟 Conceptos de POO Demostrados

1. **Herencia**: Las clases `Jedi`, `Sith` y `PadawanJedi` heredan de `UsuarioFuerza`
2. **Polimorfismo**: El método `mostrarDatos()` se comporta diferente en cada clase
3. **Encapsulación**: Atributos privados con acceso controlado
4. **Reutilización**: Uso de `super()` para aprovechar código del padre
5. **Abstracción**: Separación de responsabilidades en diferentes clases

---
*"Que la Fuerza te acompañe en tu aprendizaje de POO"* ⚔️
