# Repositorio de Tareas de Programación en Java

Este repositorio contiene los ejercicios y laboratorios desarrollados para el curso de Programación Orientada a Objetos (o el nombre de tu curso/asignatura).

## Estructura del Repositorio

El contenido está organizado de la siguiente manera:

*   **`/Ejercicios`**: Contiene proyectos Maven individuales correspondientes a los ejercicios realizados en clase. Están organizados generalmente por número o tema.
*   **`/Laboratorios`**: Contiene proyectos Maven individuales para los laboratorios o tareas más extensas. (Nota: Esta carpeta podría ser renombrada desde `Laboratorio` si se aplica el cambio de nomenclatura).

## ¿Cómo Empezar?

1.  **Clonar el Repositorio:**
    ```bash
    git clone https://github.com/usuario/repositorio.git
    cd repositorio
    ```
    (Reemplaza la URL con la URL real de este repositorio)

2.  **Importar Proyectos:**
    Cada subdirectorio dentro de `/Ejercicios` y `/Laboratorios` (o `/Laboratorio`) es un proyecto Maven independiente. Puedes importarlos directamente en tu IDE Java preferido (como IntelliJ IDEA, Eclipse, Apache NetBeans, VS Code con el pack de Java) como un "Existing Maven Project".

## Requisitos

*   **Java JDK:** Se recomienda JDK 17 o superior. La mayoría de los proyectos se configurarán para Java 17. Puedes verificar la propiedad `<maven.compiler.release>` en el archivo `pom.xml` de cada proyecto.
*   **Apache Maven:** Necesario para la gestión de dependencias y el ciclo de vida del proyecto. La mayoría de los IDEs lo incluyen o pueden configurarlo fácilmente.

## Sobre los Proyectos

Cada proyecto está configurado para ser independiente y fácilmente portable. El objetivo es que puedan ser clonados y utilizados sin problemas en diferentes entornos de desarrollo.

Se ha realizado un esfuerzo para:
*   Estandarizar la configuración de Maven (`groupId`, versión de Java).
*   Mejorar la nomenclatura de los proyectos para mayor claridad.
*   Asegurar que los archivos innecesarios (configuraciones de IDE, carpetas de compilación) sean ignorados por Git a través de un archivo `.gitignore` robusto.

---
*Organizado y mejorado con la ayuda de Jules.*
