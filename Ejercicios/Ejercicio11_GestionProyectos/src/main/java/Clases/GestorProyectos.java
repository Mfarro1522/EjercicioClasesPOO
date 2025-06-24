package Clases;

import javax.swing.JOptionPane;

public class GestorProyectos {
    
    private Empleado[] empleados;
    private Proyecto[] proyectos;
    private Pago[] pagos;
    private int cantidadEmpleados;
    private int cantidadProyectos;
    private int cantidadPagos;
    private final int MAX_EMPLEADOS = 100;
    private final int MAX_PROYECTOS = 50;
    private final int MAX_PAGOS = 500;
    
    public GestorProyectos() {
        empleados = new Empleado[MAX_EMPLEADOS];
        proyectos = new Proyecto[MAX_PROYECTOS];
        pagos = new Pago[MAX_PAGOS];
        cantidadEmpleados = 0;
        cantidadProyectos = 0;
        cantidadPagos = 0;
    }
    
    public void agregarProyecto() {
        try {
            String codigo = JOptionPane.showInputDialog("Ingrese el codigo del proyecto:");
            if (codigo == null || codigo.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Codigo no valido");
                return;
            }
            
            // Verificar si ya existe
            for (int i = 0; i < cantidadProyectos; i++) {
                if (proyectos[i].getCodigo().equals(codigo)) {
                    JOptionPane.showMessageDialog(null, "Ya existe un proyecto con ese codigo");
                    return;
                }
            }
            
            String descripcion = JOptionPane.showInputDialog("Ingrese la descripcion del proyecto:");
            if (descripcion == null || descripcion.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Descripcion no valida");
                return;
            }
            
            String precioStr = JOptionPane.showInputDialog("Ingrese el precio base por hora:");
            double precioBase = Double.parseDouble(precioStr);
            
            String[] tipos = {"Programacion", "Ciencia de Datos", "Redes", "IA"};
            String tipoSeleccionado = (String) JOptionPane.showInputDialog(null, 
                "Seleccione el tipo de proyecto:", "Tipo de Proyecto", 
                JOptionPane.QUESTION_MESSAGE, null, tipos, tipos[0]);
            
            int indiceTipo = 0;
            for (int i = 0; i < tipos.length; i++) {
                if (tipos[i].equals(tipoSeleccionado)) {
                    indiceTipo = i;
                    break;
                }
            }
            
            String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                             "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
            String mesSeleccionado = (String) JOptionPane.showInputDialog(null,
                "Seleccione el mes de inicio:", "Mes de Inicio",
                JOptionPane.QUESTION_MESSAGE, null, meses, meses[0]);
            
            int mesInicio = 0;
            for (int i = 0; i < meses.length; i++) {
                if (meses[i].equals(mesSeleccionado)) {
                    mesInicio = i;
                    break;
                }
            }
            
            if (cantidadProyectos < MAX_PROYECTOS) {
                proyectos[cantidadProyectos] = new Proyecto(codigo, descripcion, precioBase, indiceTipo, mesInicio);
                cantidadProyectos++;
                JOptionPane.showMessageDialog(null, "Proyecto agregado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pueden agregar mas proyectos");
            }
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Precio no valido");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar proyecto: " + e.getMessage());
        }
    }
    
    public void agregarEmpleado() {
        try {
            String dniStr = JOptionPane.showInputDialog("Ingrese el DNI del empleado:");
            int dni = Integer.parseInt(dniStr);
            
            // Verificar si ya existe
            for (int i = 0; i < cantidadEmpleados; i++) {
                if (empleados[i].getDni() == dni) {
                    JOptionPane.showMessageDialog(null, "Ya existe un empleado con ese DNI");
                    return;
                }
            }
            
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado:");
            if (nombre == null || nombre.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nombre no valido");
                return;
            }
            
            String distrito = JOptionPane.showInputDialog("Ingrese el distrito de residencia:");
            if (distrito == null || distrito.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Distrito no valido");
                return;
            }
            
            String[] generos = {"Masculino", "Femenino", "Otro"};
            String genero = (String) JOptionPane.showInputDialog(null,
                "Seleccione el genero:", "Genero",
                JOptionPane.QUESTION_MESSAGE, null, generos, generos[0]);
            
            String edadStr = JOptionPane.showInputDialog("Ingrese la edad:");
            int edad = Integer.parseInt(edadStr);
            
            String[] funciones = {"Lider", "Analista", "Personal de planta"};
            String funcionSeleccionada = (String) JOptionPane.showInputDialog(null,
                "Seleccione la funcion:", "Funcion",
                JOptionPane.QUESTION_MESSAGE, null, funciones, funciones[2]);
            
            int indiceFuncion = 0;
            for (int i = 0; i < funciones.length; i++) {
                if (funciones[i].equals(funcionSeleccionada)) {
                    indiceFuncion = i;
                    break;
                }
            }
            
            if (cantidadEmpleados < MAX_EMPLEADOS) {
                empleados[cantidadEmpleados] = new Empleado(dni, nombre, distrito, genero, edad, indiceFuncion);
                cantidadEmpleados++;
                JOptionPane.showMessageDialog(null, "Empleado agregado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pueden agregar mas empleados");
            }
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: DNI o edad no validos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar empleado: " + e.getMessage());
        }
    }
    
    public void mostrarProyectosConEmpleados() {
        if (cantidadProyectos == 0) {
            JOptionPane.showMessageDialog(null, "No hay proyectos registrados");
            return;
        }
        
        StringBuilder reporte = new StringBuilder();
        reporte.append("=== PROYECTOS CON SUS EMPLEADOS ===\n\n");
        
        for (int i = 0; i < cantidadProyectos; i++) {
            Proyecto proyecto = proyectos[i];
            reporte.append("Proyecto: ").append(proyecto.getCodigo()).append(" - ").append(proyecto.getDescripcion()).append("\n");
            reporte.append("Empleados asignados:\n");
            
            if (proyecto.getCantidadEmpleados() == 0) {
                reporte.append("  - No hay empleados asignados\n");
                reporte.append("  - ¿Desea asignar empleados a este proyecto?\n");
                
                // Opción para asignar empleados al proyecto
                int respuesta = JOptionPane.showConfirmDialog(null, 
                    "¿Desea asignar empleados al proyecto " + proyecto.getCodigo() + "?", 
                    "Asignar Empleados", JOptionPane.YES_NO_OPTION);
                
                if (respuesta == JOptionPane.YES_OPTION) {
                    asignarEmpleadoAProyecto(proyecto.getCodigo());
                }
            } else {
                int[] dnis = proyecto.getDniEmpleados();
                for (int j = 0; j < proyecto.getCantidadEmpleados(); j++) {
                    Empleado empleado = buscarEmpleado(dnis[j]);
                    if (empleado != null) {
                        reporte.append("  - ").append(empleado.getNombre()).append(" (DNI: ").append(dnis[j]).append(")\n");
                    }
                }
            }
            reporte.append("\n");
        }
        
        JOptionPane.showMessageDialog(null, reporte.toString());
    }
    
    public void mostrarPagosPorEmpleado() {
        if (cantidadEmpleados == 0) {
            JOptionPane.showMessageDialog(null, "No hay empleados registrados");
            return;
        }
        
        String dniStr = JOptionPane.showInputDialog("Ingrese el DNI del empleado:");
        if (dniStr == null) return;
        
        try {
            int dni = Integer.parseInt(dniStr);
            Empleado empleado = buscarEmpleado(dni);
            
            if (empleado == null) {
                JOptionPane.showMessageDialog(null, "Empleado no encontrado");
                return;
            }
            
            StringBuilder reporte = new StringBuilder();
            reporte.append("=== PAGOS DE ").append(empleado.getNombre()).append(" ===\n\n");
            
            double totalPagos = 0;
            boolean tienePagos = false;
            
            for (int i = 0; i < cantidadPagos; i++) {
                if (pagos[i].getDniEmpleado() == dni) {
                    reporte.append(pagos[i].toString()).append("\n");
                    totalPagos += pagos[i].getMonto();
                    tienePagos = true;
                }
            }
            
            if (!tienePagos) {
                reporte.append("No hay pagos registrados para este empleado\n");
                reporte.append("¿Desea registrar un pago para este empleado?\n");
                
                int respuesta = JOptionPane.showConfirmDialog(null, 
                    "¿Desea registrar un pago para " + empleado.getNombre() + "?", 
                    "Registrar Pago", JOptionPane.YES_NO_OPTION);
                
                if (respuesta == JOptionPane.YES_OPTION) {
                    registrarPago(dni);
                }
            } else {
                reporte.append("\nTOTAL PAGADO: $").append(totalPagos);
            }
            
            JOptionPane.showMessageDialog(null, reporte.toString());
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "DNI no valido");
        }
    }
    
    private void asignarEmpleadoAProyecto(String codigoProyecto) {
        if (cantidadEmpleados == 0) {
            JOptionPane.showMessageDialog(null, "No hay empleados registrados");
            return;
        }
        
        Proyecto proyecto = buscarProyecto(codigoProyecto);
        if (proyecto == null) {
            JOptionPane.showMessageDialog(null, "Proyecto no encontrado");
            return;
        }
        
        try {
            String dniStr = JOptionPane.showInputDialog("Ingrese el DNI del empleado a asignar:");
            if (dniStr == null) return;
            
            int dni = Integer.parseInt(dniStr);
            Empleado empleado = buscarEmpleado(dni);
            
            if (empleado == null) {
                JOptionPane.showMessageDialog(null, "Empleado no encontrado");
                return;
            }
            
            boolean asignado = proyecto.agregarEmpleado(dni);
            if (asignado) {
                JOptionPane.showMessageDialog(null, "Empleado " + empleado.getNombre() + " asignado al proyecto exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo asignar el empleado. Proyecto lleno o empleado ya asignado.");
            }
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "DNI no valido");
        }
    }
    
    private void registrarPago(int dniEmpleado) {
        if (cantidadProyectos == 0) {
            JOptionPane.showMessageDialog(null, "No hay proyectos registrados");
            return;
        }
        
        try {
            Empleado empleado = buscarEmpleado(dniEmpleado);
            if (empleado == null) {
                JOptionPane.showMessageDialog(null, "Empleado no encontrado");
                return;
            }
            
            String codigoProyecto = JOptionPane.showInputDialog("Ingrese el código del proyecto:");
            if (codigoProyecto == null) return;
            
            Proyecto proyecto = buscarProyecto(codigoProyecto);
            if (proyecto == null) {
                JOptionPane.showMessageDialog(null, "Proyecto no encontrado");
                return;
            }
            
            // Verificar si el empleado está asignado al proyecto
            boolean empleadoAsignado = false;
            int[] dnis = proyecto.getDniEmpleados();
            for (int i = 0; i < proyecto.getCantidadEmpleados(); i++) {
                if (dnis[i] == dniEmpleado) {
                    empleadoAsignado = true;
                    break;
                }
            }
            
            if (!empleadoAsignado) {
                int respuesta = JOptionPane.showConfirmDialog(null, 
                    "El empleado no está asignado a este proyecto. ¿Desea asignarlo primero?", 
                    "Asignar Empleado", JOptionPane.YES_NO_OPTION);
                
                if (respuesta == JOptionPane.YES_OPTION) {
                    boolean asignado = proyecto.agregarEmpleado(dniEmpleado);
                    if (!asignado) {
                        JOptionPane.showMessageDialog(null, "No se pudo asignar el empleado al proyecto");
                        return;
                    }
                } else {
                    return;
                }
            }
            
            String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                             "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
            String mesSeleccionado = (String) JOptionPane.showInputDialog(null,
                "Seleccione el mes del pago:", "Mes de Pago",
                JOptionPane.QUESTION_MESSAGE, null, meses, meses[0]);
            
            if (mesSeleccionado == null) return;
            
            int indiceMes = 0;
            for (int i = 0; i < meses.length; i++) {
                if (meses[i].equals(mesSeleccionado)) {
                    indiceMes = i;
                    break;
                }
            }
            
            String horasStr = JOptionPane.showInputDialog("Ingrese las horas trabajadas:");
            if (horasStr == null) return;
            
            int horas = Integer.parseInt(horasStr);
            
            double monto = proyecto.calcularSalario(empleado.getIndiceFuncion(), horas);
            
            if (cantidadPagos < MAX_PAGOS) {
                pagos[cantidadPagos] = new Pago(indiceMes, horas, monto, dniEmpleado, codigoProyecto);
                cantidadPagos++;
                JOptionPane.showMessageDialog(null, "Pago registrado exitosamente. Monto: $" + monto);
            } else {
                JOptionPane.showMessageDialog(null, "No se pueden registrar más pagos");
            }
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Horas no válidas");
        }
    }
    
    private Empleado buscarEmpleado(int dni) {
        for (int i = 0; i < cantidadEmpleados; i++) {
            if (empleados[i].getDni() == dni) {
                return empleados[i];
            }
        }
        return null;
    }
    
    private Proyecto buscarProyecto(String codigo) {
        for (int i = 0; i < cantidadProyectos; i++) {
            if (proyectos[i].getCodigo().equals(codigo)) {
                return proyectos[i];
            }
        }
        return null;
    }
}
