package primero.boletos;
import java.util.Scanner;

public class Abraham_Enamorado_proyecto_1_2025 {
    public static void main(String[] args) {
        Scanner leer_datos = new Scanner(System.in).useDelimiter("\n");

        double dinero_en_caja = 0;
        double dinero_en_banco = 0;
        String opcion_menu_principal = "";
        double inventario_azucar = 0;
        double inventario_avena = 0;
        double inventario_trigo = 0;
        double inventario_maiz = 0;
        double precio_venta_azucar = 30;
        double precio_compra_azucar = 25;
        double precio_venta_avena = 25;
        double precio_compra_avena = 20;
        double precio_venta_trigo = 32;
        double precio_compra_trigo = 30;
        double precio_venta_maiz = 20;
        double precio_compra_maiz = 18;
        double total_ventas_dia = 0;
        double total_compras_dia = 0;
        int contador_ventas_dia = 0;
        int contador_compras_dia = 0;
        double mayor_ganancia_venta = 0;
        double mayor_gasto_compra = 0;
        double ventas_azucar_dia = 0;
        double ventas_avena_dia = 0;
        double ventas_trigo_dia = 0;
        double ventas_maiz_dia = 0;
        boolean caja_cerrada = false; 
        int dia_actual = 1;

        while (!opcion_menu_principal.equalsIgnoreCase("salir")) {
            System.out.println("\n=== Sistema de Caja Automatica ===");
            System.out.println("Dia actual: " + dia_actual);
            System.out.println("Dinero en el banco: " + dinero_en_banco + " Lps");
            System.out.println("Dinero en caja: " + dinero_en_caja + " Lps");
            System.out.println("Estado de la caja: " + (caja_cerrada ? "Cerrada" : "Abierta"));
            System.out.println("Inventario:");
            System.out.printf("%-6s | %-8s | %-15s | %-20s%n", "Codigo", "Producto", "Inventario (kg)", "Precio Venta (Lps/kg)");
            System.out.printf("%-6s | %-8s | %-15.2f | %-20.2f%n", "1", "Azucar", inventario_azucar, precio_venta_azucar);
            System.out.printf("%-6s | %-8s | %-15.2f | %-20.2f%n", "2", "Avena", inventario_avena, precio_venta_avena);
            System.out.printf("%-6s | %-8s | %-15.2f | %-20.2f%n", "3", "Trigo", inventario_trigo, precio_venta_trigo);
            System.out.printf("%-6s | %-8s | %-15.2f | %-20.2f%n", "4", "Maiz", inventario_maiz, precio_venta_maiz);
            System.out.println("Seleccione una opcion:");
            System.out.println("1. Ingresar dinero en caja / Abrir caja");
            System.out.println("2. Realizar ventas");
            System.out.println("3. Realizar compras");
            System.out.println("4. Ver reportes");
            System.out.println("5. Cierre de caja");
            System.out.println("6. Salir del sistema");
            System.out.print("Opcion: ");
            opcion_menu_principal = leer_datos.nextLine().trim().toLowerCase();

            while (!(opcion_menu_principal.contains("1") || opcion_menu_principal.contains("ingresar") || opcion_menu_principal.contains("abrir") ||
                     opcion_menu_principal.contains("2") || opcion_menu_principal.contains("ventas") ||
                     opcion_menu_principal.contains("3") || opcion_menu_principal.contains("compras") ||
                     opcion_menu_principal.contains("4") || opcion_menu_principal.contains("reportes") ||
                     opcion_menu_principal.contains("5") || opcion_menu_principal.contains("cierre") ||
                     opcion_menu_principal.contains("6") || opcion_menu_principal.contains("salir"))) {
                System.out.println("Error: Opcion no valida. Por favor, ingrese un numero del 1 al 6 o una palabra relacionada con la opcion deseada.");
                System.out.print("Opcion: ");
                opcion_menu_principal = leer_datos.nextLine().trim().toLowerCase();
            }

            if (opcion_menu_principal.contains("1") || opcion_menu_principal.contains("ingresar") || opcion_menu_principal.contains("abrir")) {
                if (caja_cerrada) {
                    caja_cerrada = false;
                    total_ventas_dia = 0;
                    total_compras_dia = 0;
                    contador_ventas_dia = 0;
                    contador_compras_dia = 0;
                    mayor_ganancia_venta = 0;
                    mayor_gasto_compra = 0;
                    ventas_azucar_dia = 0;
                    ventas_avena_dia = 0;
                    ventas_trigo_dia = 0;
                    ventas_maiz_dia = 0;
                    System.out.println("La caja ha sido abierta para el dia " + dia_actual + " con " + dinero_en_caja + " Lps restantes del dia anterior.");
                } else {
                    System.out.println("\n=== Ingresar Dinero en Caja ===");
                    System.out.print("Por favor, ingrese la cantidad de dinero a adicionar en caja (o 'salir' para cancelar): ");
                    String entrada_dinero = leer_datos.nextLine().trim().toLowerCase();
                    while (!entrada_dinero.equals("salir") && !entrada_dinero.matches("^\\d+(\\.\\d+)?$")) {
                        System.out.println("Error: Ingrese un numero valido mayor a 0 (ejemplo: 100.50) o 'salir' para cancelar la operacion.");
                        System.out.print("Cantidad a ingresar: ");
                        entrada_dinero = leer_datos.nextLine().trim().toLowerCase();
                    }
                    if (!entrada_dinero.equals("salir")) {
                        double monto_ingresado = Double.parseDouble(entrada_dinero);
                        if (monto_ingresado > 0) {
                            dinero_en_caja += monto_ingresado;
                            System.out.println("Monto de " + monto_ingresado + " Lps ingresado correctamente.");
                            System.out.println("Nuevo total en caja: " + dinero_en_caja + " Lps");
                        } else {
                            System.out.println("Error: El monto debe ser mayor a 0. No se realizo ningun cambio.");
                        }
                    } else {
                        System.out.println("Operacion cancelada. No se ingreso dinero.");
                    }
                }
            }

            else if (opcion_menu_principal.contains("2") || opcion_menu_principal.contains("ventas")) {
                if (caja_cerrada) {
                    System.out.println("Error: La caja esta cerrada. Por favor, abra la caja usando la opcion 1.");
                    continue;
                }
                if (inventario_azucar <= 0 && inventario_avena <= 0 && inventario_trigo <= 0 && inventario_maiz <= 0) {
                    System.out.println("Error: No hay productos en inventario. Realice compras primero usando la opcion 3.");
                    continue;
                }
                    double venta_actual_azucar = 0;
                    double venta_actual_avena = 0;
                    double venta_actual_trigo = 0;
                    double venta_actual_maiz = 0;
                    double subtotal_venta = 0;

                    System.out.println("\n=== Realizar Venta ===");
                    System.out.println("Seleccione el tipo de cliente:");
                    System.out.println("A - Puede comprar cualquier producto");
                    System.out.println("B - Solo productos con codigo 1, 2 y 3 (Azucar, Avena, Trigo)");
                    System.out.println("C - Solo producto con codigo 4 (Maiz)");
                    System.out.print("Tipo de cliente (A, B, C) o 'salir' para cancelar: ");
                    String tipo_cliente = leer_datos.nextLine().toUpperCase();
                    while (!tipo_cliente.equals("salir") && !(tipo_cliente.contains("A") || tipo_cliente.contains("B") || tipo_cliente.contains("C"))) {
                        System.out.println("Error: Tipo de cliente no valido. Ingrese A, B, C o 'salir' para cancelar.");
                        System.out.print("Tipo de cliente (A, B, C) o 'salir' para cancelar: ");
                        tipo_cliente = leer_datos.nextLine().toUpperCase();
                    }
                    if (tipo_cliente.equals("salir")) {
                        System.out.println("Operacion cancelada.");
                        continue;
                    }

                    String continuar_venta = "si";
                    while (continuar_venta.equalsIgnoreCase("si")) {
                        System.out.println("\nInventario disponible:");
                        System.out.println("1. Azucar: " + inventario_azucar + " kg - " + precio_venta_azucar + " Lps/kg");
                        System.out.println("2. Avena: " + inventario_avena + " kg - " + precio_venta_avena + " Lps/kg");
                        System.out.println("3. Trigo: " + inventario_trigo + " kg - " + precio_venta_trigo + " Lps/kg");
                        System.out.println("4. Maiz: " + inventario_maiz + " kg - " + precio_venta_maiz + " Lps/kg");
                        System.out.println("Seleccione el producto a vender:");
                        if (tipo_cliente.equals("A")) {
                            System.out.println("1. Azucar - " + precio_venta_azucar + " Lps/kg");
                            System.out.println("2. Avena - " + precio_venta_avena + " Lps/kg");
                            System.out.println("3. Trigo - " + precio_venta_trigo + " Lps/kg");
                            System.out.println("4. Maiz - " + precio_venta_maiz + " Lps/kg");
                        } else if (tipo_cliente.equals("B")) {
                            System.out.println("1. Azucar - " + precio_venta_azucar + " Lps/kg");
                            System.out.println("2. Avena - " + precio_venta_avena + " Lps/kg");
                            System.out.println("3. Trigo - " + precio_venta_trigo + " Lps/kg");
                        } else if (tipo_cliente.equals("C")) {
                            System.out.println("4. Maiz - " + precio_venta_maiz + " Lps/kg");
                        }
                        System.out.print("Codigo del producto (o 'salir' para finalizar la venta): ");
                        String codigo_producto = leer_datos.nextLine().toLowerCase();
                        if (codigo_producto.equals("salir")) {
                            if (subtotal_venta > 0) {
                                break;
                            } else {
                                System.out.println("Operacion cancelada.");
                                continue;
                            }
                        }
                        boolean cliente_puede_comprar = false;
                        if (tipo_cliente.equals("A")) {
                            cliente_puede_comprar = true;
                        } else if (tipo_cliente.equals("B") && (codigo_producto.contains("1") || codigo_producto.contains("2") || codigo_producto.contains("3"))) {
                            cliente_puede_comprar = true;
                        } else if (tipo_cliente.equals("C") && codigo_producto.contains("4")) {
                            cliente_puede_comprar = true;
                        }
                        if (!cliente_puede_comprar) {
                            System.out.println("Error: Este cliente no puede comprar el producto seleccionado segun su tipo.");
                            System.out.print("Desea vender otro producto? (si/no): ");
                            continuar_venta = leer_datos.nextLine().toLowerCase();
                            while (!(continuar_venta.contains("si") || continuar_venta.contains("no"))) {
                                System.out.println("Error: Responda con 'si' o 'no'.");
                                System.out.print("Desea vender otro producto? (si/no): ");
                                continuar_venta = leer_datos.nextLine().toLowerCase();
                            }
                            continue;
                        }
                        double inventario_disponible = 0;
                        String nombre_producto = "";
                        double precio_venta = 0;
                        double precio_compra = 0;
                        if (codigo_producto.contains("1")) {
                            inventario_disponible = inventario_azucar;
                            nombre_producto = "Azucar";
                            precio_venta = precio_venta_azucar;
                            precio_compra = precio_compra_azucar;
                        } else if (codigo_producto.contains("2")) {
                            inventario_disponible = inventario_avena;
                            nombre_producto = "Avena";
                            precio_venta = precio_venta_avena;
                            precio_compra = precio_compra_avena;
                        } else if (codigo_producto.contains("3")) {
                            inventario_disponible = inventario_trigo;
                            nombre_producto = "Trigo";
                            precio_venta = precio_venta_trigo;
                            precio_compra = precio_compra_trigo;
                        } else if (codigo_producto.contains("4")) {
                            inventario_disponible = inventario_maiz;
                            nombre_producto = "Maiz";
                            precio_venta = precio_venta_maiz;
                            precio_compra = precio_compra_maiz;
                        } else {
                            System.out.println("Error: Codigo de producto no valido. Use 1, 2, 3 o 4.");
                            continue;
                        }
                        if (inventario_disponible <= 0) {
                            System.out.println("Error: No hay " + nombre_producto + " disponible en inventario.");
                            continue;
                        }
                        System.out.print("Ingrese la cantidad en kg a vender (maximo " + inventario_disponible + " kg) o 'salir' para cancelar: ");
                        String cantidad_str = leer_datos.nextLine().trim().toLowerCase();
                        while (!cantidad_str.equals("salir") && !cantidad_str.matches("^\\d+(\\.\\d+)?$")) {
                            System.out.println("Error: Ingrese un numero valido mayor a 0 (ejemplo: 2.5) o 'salir' para cancelar.");
                            System.out.print("Cantidad (kg): ");
                            cantidad_str = leer_datos.nextLine().trim().toLowerCase();
                        }
                        if (cantidad_str.equals("salir")) {
                            if (subtotal_venta > 0) {
                                break;
                            } else {
                                System.out.println("Operacion cancelada.");
                                continue;
                            }
                        }
                        double cantidad_venta = Double.parseDouble(cantidad_str);
                        while (cantidad_venta <= 0 || cantidad_venta > inventario_disponible) {
                            System.out.println("Error: La cantidad debe ser mayor a 0 y menor o igual a " + inventario_disponible + " kg.");
                            System.out.print("Cantidad (kg) o 'salir' para cancelar: ");
                            cantidad_str = leer_datos.nextLine().trim().toLowerCase();
                            if (cantidad_str.equals("salir")) {
                                if (subtotal_venta > 0) {
                                    break;
                                } else {
                                    System.out.println("Operacion cancelada.");
                                    continue;
                                }
                            }
                            while (!cantidad_str.matches("^\\d+(\\.\\d+)?$")) {
                                System.out.println("Error: Ingrese un numero valido mayor a 0 (ejemplo: 2.5) o 'salir' para cancelar.");
                                System.out.print("Cantidad (kg): ");
                                cantidad_str = leer_datos.nextLine().trim().toLowerCase();
                                if (cantidad_str.equals("salir")) {
                                    if (subtotal_venta > 0) {
                                        break;
                                    } else {
                                        System.out.println("Operacion cancelada.");
                                        continue;
                                    }
                                }
                            }
                            cantidad_venta = Double.parseDouble(cantidad_str);
                        }
                        double total_venta = cantidad_venta * precio_venta;
                        double ganancia_venta = cantidad_venta * (precio_venta - precio_compra);
                        subtotal_venta += total_venta;
                        if (ganancia_venta > mayor_ganancia_venta) {
                            mayor_ganancia_venta = ganancia_venta;
                        }
                        if (codigo_producto.contains("1")) {
                            inventario_azucar -= cantidad_venta;
                            venta_actual_azucar += cantidad_venta;
                            ventas_azucar_dia += cantidad_venta;
                        } else if (codigo_producto.contains("2")) {
                            inventario_avena -= cantidad_venta;
                            venta_actual_avena += cantidad_venta;
                            ventas_avena_dia += cantidad_venta;
                        } else if (codigo_producto.contains("3")) {
                            inventario_trigo -= cantidad_venta;
                            venta_actual_trigo += cantidad_venta;
                            ventas_trigo_dia += cantidad_venta;
                        } else if (codigo_producto.contains("4")) {
                            inventario_maiz -= cantidad_venta;
                            venta_actual_maiz += cantidad_venta;
                            ventas_maiz_dia += cantidad_venta;
                        }
                        System.out.println("Venta registrada: " + cantidad_venta + " kg de " + nombre_producto + " por " + total_venta + " Lps");
                        System.out.print("Desea vender otro producto? (si/no): ");
                        continuar_venta = leer_datos.nextLine().toLowerCase();
                        while (!(continuar_venta.contains("si") || continuar_venta.contains("no"))) {
                            System.out.println("Error: Responda con 'si' o 'no'.");
                            System.out.print("Desea vender otro producto? (si/no): ");
                            continuar_venta = leer_datos.nextLine().toLowerCase();
                        }
                    }

                    if (subtotal_venta > 0) {
                        System.out.println("\n=== Factura de Venta ===");
                        System.out.println("Detalle de productos:");
                        if (venta_actual_azucar > 0) {
                            System.out.printf("%-10s | %-15.2f kg | %-10.2f Lps/kg | %-10.2f Lps%n", "Azucar", venta_actual_azucar, precio_venta_azucar, venta_actual_azucar * precio_venta_azucar);
                        }
                        if (venta_actual_avena > 0) {
                            System.out.printf("%-10s | %-15.2f kg | %-10.2f Lps/kg | %-10.2f Lps%n", "Avena", venta_actual_avena, precio_venta_avena, venta_actual_avena * precio_venta_avena);
                        }
                        if (venta_actual_trigo > 0) {
                            System.out.printf("%-10s | %-15.2f kg | %-10.2f Lps/kg | %-10.2f Lps%n", "Trigo", venta_actual_trigo, precio_venta_trigo, venta_actual_trigo * precio_venta_trigo);
                        }
                        if (venta_actual_maiz > 0) {
                            System.out.printf("%-10s | %-15.2f kg | %-10.2f Lps/kg | %-10.2f Lps%n", "Maiz", venta_actual_maiz, precio_venta_maiz, venta_actual_maiz * precio_venta_maiz);
                        }
                        System.out.println("Subtotal: " + subtotal_venta + " Lps");
                        double descuento_venta = 0;
                        if (subtotal_venta >= 5000) {
                            descuento_venta = subtotal_venta * 0.10;
                            System.out.println("Descuento (10%): " + descuento_venta + " Lps");
                        } else if (subtotal_venta >= 1000) {
                            descuento_venta = subtotal_venta * 0.05;
                            System.out.println("Descuento (5%): " + descuento_venta + " Lps");
                        } else {
                            System.out.println("Descuento: No aplica");
                        }
                        double impuesto_venta = subtotal_venta * 0.07;
                        System.out.println("Impuesto (7%): " + impuesto_venta + " Lps");
                        double total_pagar = subtotal_venta - descuento_venta + impuesto_venta;
                        System.out.println("Total a pagar: " + total_pagar + " Lps");
                        dinero_en_caja += total_pagar;
                        total_ventas_dia += total_pagar;
                        contador_ventas_dia++;
                        System.out.println("Venta procesada correctamente. Nuevo total en caja: " + dinero_en_caja + " Lps");
                    }
            }

            else if (opcion_menu_principal.contains("3") || opcion_menu_principal.contains("compras")) {
                if (caja_cerrada) {
                    System.out.println("Error: La caja esta cerrada. Por favor, abra la caja usando la opcion 1.");
                    continue;
                }
                if (dinero_en_caja <= 0) {
                    System.out.println("Error: No hay dinero suficiente en caja para realizar compras. Ingrese dinero usando la opcion 1.");
                    continue;
                }
                System.out.println("\n=== Realizar Compra ===");
                System.out.println("Dinero disponible en caja: " + dinero_en_caja + " Lps");
                System.out.println("Seleccione el tipo de proveedor:");
                System.out.println("A - Productos con codigo 1 y 4 (1.Azucar=(lps. 25.00/kg) y 4.Maiz=(lps. 18.00/kg))");
                System.out.println("B - Productos con codigo 2 y 3 (2.Avena=(lps. 20.00/kg) y 3.Trigo=(lps. 30.00/kg))");
                System.out.println("C - Producto con codigo 2 (2.Avena=(lps. 22.00/kg))");
                System.out.print("Tipo de proveedor (A, B, C) o 'salir' para cancelar: ");
                String tipo_proveedor = leer_datos.nextLine().toUpperCase();
                while (!tipo_proveedor.equals("salir") && !(tipo_proveedor.contains("A") || tipo_proveedor.contains("B") || tipo_proveedor.contains("C"))) {
                    System.out.println("Error: Tipo de proveedor no valido. Ingrese A, B, C o 'salir' para cancelar.");
                    System.out.print("Tipo de proveedor (A, B, C) o 'salir' para cancelar: ");
                    tipo_proveedor = leer_datos.nextLine().toUpperCase();
                }
                if (tipo_proveedor.equals("salir")) {
                    System.out.println("Operacion cancelada.");
                    continue;
                }
                System.out.println("Seleccione el producto a comprar:");
                if (tipo_proveedor.equals("A")) {
                    System.out.println("1. Azucar - " + precio_compra_azucar + " Lps/kg");
                    System.out.println("4. Maiz - " + precio_compra_maiz + " Lps/kg");
                } else if (tipo_proveedor.equals("B")) {
                    System.out.println("2. Avena - " + precio_compra_avena + " Lps/kg");
                    System.out.println("3. Trigo - " + precio_compra_trigo + " Lps/kg");
                } else if (tipo_proveedor.equals("C")) {
                    System.out.println("2. Avena - " + (precio_compra_avena+2) + " Lps/kg");
                }
                System.out.print("Codigo del producto (o 'salir' para cancelar): ");
                String codigo_producto = leer_datos.nextLine().toLowerCase();
                if (codigo_producto.equals("salir")) {
                    System.out.println("Operacion cancelada.");
                    continue;
                }
                boolean proveedor_puede_vender = false;
                if (tipo_proveedor.equals("A") && (codigo_producto.contains("1") || codigo_producto.contains("4"))) {
                    proveedor_puede_vender = true;
                } else if (tipo_proveedor.equals("B") && (codigo_producto.contains("2") || codigo_producto.contains("3"))) {
                    proveedor_puede_vender = true;
                } else if (tipo_proveedor.equals("C") && codigo_producto.contains("2")) {
                    proveedor_puede_vender = true;
                }
                while (!proveedor_puede_vender && !codigo_producto.equals("salir")) {
                    System.out.println("Error: El proveedor seleccionado no vende este producto.");
                    System.out.print("Codigo del producto (o 'salir' para cancelar): ");
                    codigo_producto = leer_datos.nextLine().toLowerCase();
                    if (tipo_proveedor.equals("A") && (codigo_producto.contains("1") || codigo_producto.contains("4"))) {
                        proveedor_puede_vender = true;
                    } else if (tipo_proveedor.equals("B") && (codigo_producto.contains("2") || codigo_producto.contains("3"))) {
                        proveedor_puede_vender = true;
                    } else if (tipo_proveedor.equals("C") && codigo_producto.contains("2")) {
                        proveedor_puede_vender = true;
                    }
                }
                if (codigo_producto.equals("salir")) {
                    System.out.println("Operacion cancelada.");
                    continue;
                }
                double precio_compra = 0;
                String nombre_producto = "";
                if (codigo_producto.contains("1")) {
                    precio_compra = precio_compra_azucar;
                    nombre_producto = "Azucar";
                } else if (codigo_producto.contains("2")&&tipo_proveedor.equals("C")) {
                    precio_compra = precio_compra_avena+2;
                    nombre_producto = "Avena";
                } else if (codigo_producto.contains("2")) {
                    precio_compra = precio_compra_avena;
                    nombre_producto = "Avena";
                } else if (codigo_producto.contains("3")) {
                    precio_compra = precio_compra_trigo;
                    nombre_producto = "Trigo";
                } else if (codigo_producto.contains("4")) {
                    precio_compra = precio_compra_maiz;
                    nombre_producto = "Maiz";
                }
                System.out.print("Ingrese la cantidad en kg a comprar (o 'salir' para cancelar): ");
                String cantidad_str = leer_datos.nextLine().trim().toLowerCase();
                while (!cantidad_str.equals("salir") && !cantidad_str.matches("^\\d+(\\.\\d+)?$")) {
                    System.out.println("Error: Ingrese un numero valido mayor a 0 (ejemplo: 5.75) o 'salir' para cancelar.");
                    System.out.print("Cantidad (kg): ");
                    cantidad_str = leer_datos.nextLine().trim().toLowerCase();
                }
                if (cantidad_str.equals("salir")) {
                    System.out.println("Operacion cancelada.");
                    continue;
                }
                double cantidad_compra = Double.parseDouble(cantidad_str);
                while (cantidad_compra <= 0) {
                    System.out.println("Error: La cantidad debe ser mayor a 0.");
                    System.out.print("Cantidad (kg) o 'salir' para cancelar: ");
                    cantidad_str = leer_datos.nextLine().trim().toLowerCase();
                    if (cantidad_str.equals("salir")) {
                        break;
                    }
                    while (!cantidad_str.matches("^\\d+(\\.\\d+)?$")) {
                        System.out.println("Error: Ingrese un numero valido mayor a 0 (ejemplo: 5.75) o 'salir' para cancelar.");
                        System.out.print("Cantidad (kg): ");
                        cantidad_str = leer_datos.nextLine().trim().toLowerCase();
                        if (cantidad_str.equals("salir")) {
                            break;
                        }
                    }
                    if (cantidad_str.equals("salir")) {
                        break;
                    }
                    cantidad_compra = Double.parseDouble(cantidad_str);
                }
                if (cantidad_str.equals("salir")) {
                    System.out.println("Operacion cancelada.");
                    continue;
                }
                double total_compra = cantidad_compra * precio_compra;
                if (total_compra > dinero_en_caja) {
                    System.out.println("Error: No hay suficiente dinero en caja para esta compra.");
                    System.out.println("Total requerido: " + total_compra + " Lps, Disponible: " + dinero_en_caja + " Lps");
                    continue;
                }
                dinero_en_caja -= total_compra;
                if (total_compra > mayor_gasto_compra) {
                    mayor_gasto_compra = total_compra;
                }
                if (codigo_producto.contains("1")) {
                    inventario_azucar += cantidad_compra;
                } else if (codigo_producto.contains("2")) {
                    inventario_avena += cantidad_compra;
                } else if (codigo_producto.contains("3")) {
                    inventario_trigo += cantidad_compra;
                } else if (codigo_producto.contains("4")) {
                    inventario_maiz += cantidad_compra;
                }
                total_compras_dia += total_compra;
                contador_compras_dia++;
                System.out.println("\n=== Factura de Compra ===");
                System.out.println("Producto: " + nombre_producto);
                System.out.println("Cantidad: " + cantidad_compra + " kg");
                System.out.println("Precio por kg: " + precio_compra + " Lps");
                System.out.println("Total: " + total_compra + " Lps");
                System.out.println("Compra procesada correctamente. Nuevo total en caja: " + dinero_en_caja + " Lps");
            }

            else if (opcion_menu_principal.contains("4") || opcion_menu_principal.contains("reportes")) {
                System.out.println("\n=== Reportes del Dia " + dia_actual + " ===");
                System.out.println("a. Cantidad actual en caja: " + dinero_en_caja + " Lps");
                System.out.println("b. Numero de compras realizadas: " + contador_compras_dia + ", Numero de ventas realizadas: " + contador_ventas_dia);
                System.out.println("c. Volumen total de compras: " + total_compras_dia + " Lps");
                System.out.println("   Volumen total de ventas: " + total_ventas_dia + " Lps");
                System.out.println("   Margen de ganancia: " + (total_ventas_dia - total_compras_dia) + " Lps");
                double promedio_compras = contador_compras_dia > 0 ? total_compras_dia / contador_compras_dia : 0;
                double promedio_ventas = contador_ventas_dia > 0 ? total_ventas_dia / contador_ventas_dia : 0;
                System.out.println("d. Valor medio de compras: " + promedio_compras + " Lps");
                System.out.println("   Valor medio de ventas: " + promedio_ventas + " Lps");
                System.out.println("e. Venta con mayor ganancia: " + mayor_ganancia_venta + " Lps");
                System.out.println("   Compra con mayor gasto: " + mayor_gasto_compra + " Lps");
                String producto_estrella = "Ninguno";
                double max_ventas = Math.max(Math.max(ventas_azucar_dia, ventas_avena_dia), Math.max(ventas_trigo_dia, ventas_maiz_dia));
                if (max_ventas == ventas_azucar_dia && max_ventas > 0) {
                    producto_estrella = "Azucar";
                } else if (max_ventas == ventas_avena_dia && max_ventas > 0) {
                    producto_estrella = "Avena";
                } else if (max_ventas == ventas_trigo_dia && max_ventas > 0) {
                    producto_estrella = "Trigo";
                } else if (max_ventas == ventas_maiz_dia && max_ventas > 0) {
                    producto_estrella = "Maiz";
                }
                System.out.println("f. Producto estrella: " + producto_estrella + " (" + max_ventas + " kg vendidos)");
            }

            else if (opcion_menu_principal.contains("5") || opcion_menu_principal.contains("cierre")) {
                if (caja_cerrada) {
                    System.out.println("Error: La caja ya esta cerrada. Use la opcion 1 para abrirla.");
                    continue;
                }
                System.out.println("\n=== Cierre de Caja ===");
                System.out.println("Total ventas del dia: " + total_ventas_dia + " Lps");
                System.out.println("Total compras del dia: " + total_compras_dia + " Lps");
                double ganancia_dia = total_ventas_dia - total_compras_dia;
                if (ganancia_dia >= 0) {
                    System.out.println("Ganancia del dia: " + ganancia_dia + " Lps");
                } else {
                    System.out.println("Perdida del dia: " + (-ganancia_dia) + " Lps");
                }
                System.out.println("Total en caja: " + dinero_en_caja + " Lps");
                double max_deposito = dinero_en_caja * 0.60;
                System.out.println("Cantidad maxima a depositar en el banco: " + max_deposito + " Lps (60% del total)");
                System.out.print("Ingrese la cantidad a depositar (0 a " + max_deposito + ") o 'salir' para no depositar: ");
                String deposito_str = leer_datos.nextLine().trim().toLowerCase();
                while (!deposito_str.equals("salir") && !deposito_str.matches("^\\d+(\\.\\d+)?$")) {
                    System.out.println("Error: Ingrese un numero valido entre 0 y " + max_deposito + " (ejemplo: 150.75) o 'salir' para no depositar.");
                    System.out.print("Cantidad a depositar: ");
                    deposito_str = leer_datos.nextLine().trim().toLowerCase();
                }
                if (!deposito_str.equals("salir")) {
                    double cantidad_deposito = Double.parseDouble(deposito_str);
                    if (cantidad_deposito >= 0 && cantidad_deposito <= max_deposito) {
                        dinero_en_caja -= cantidad_deposito;
                        dinero_en_banco += cantidad_deposito;
                        System.out.println("Deposito de " + cantidad_deposito + " Lps realizado correctamente al banco.");
                        System.out.println("Dinero restante en caja: " + dinero_en_caja + " Lps");
                        System.out.println("Nuevo total en banco: " + dinero_en_banco + " Lps");
                    } else {
                        System.out.println("Error: La cantidad debe estar entre 0 y " + max_deposito + " Lps. No se realizo deposito.");
                    }
                } else {
                    System.out.println("No se realizo deposito al banco.");
                }
                caja_cerrada = true;
                dia_actual++;
                System.out.println("Caja cerrada exitosamente. Dia " + (dia_actual - 1) + " finalizado.");
            }

            else if (opcion_menu_principal.contains("6") || opcion_menu_principal.contains("salir")) {
                System.out.println("Gracias por usar el sistema de caja automatica. Hasta pronto!");
                break;
            }
        }
    }
}