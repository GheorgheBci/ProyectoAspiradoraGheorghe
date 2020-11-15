package programa;

import javax.swing.JOptionPane;

/**
 *
 * @author Jorge
 */
public class Aspiradora {
    
    public static void main(String[] args) {
        
        final String USUARIO = "George";
        final int CONTRASENIA = 12345;
        
        int opciones, salir;
        int opcionesAspiracion;
        boolean repetir = true;
        String usuarioCorrecto;
        int contraseniaCorrecto;
        double nivelBateria = 0;
        String dependencia = "";
        int contador = 0;
        double carga = 0;
        
        double[] metrosDepen = new double[5];
        
        String[] dependencias = new String[5];
        dependencias[0] = "la cocina";
        dependencias[1] = "el salón";
        dependencias[2] = "el cuarto de baño";
        dependencias[3] = "el primer dormitorio";
        dependencias[4] = "el segundo dormitorio";
        
        JOptionPane.showMessageDialog(null, "Bienvenido al menú de la aspiradora");
        usuarioCorrecto = JOptionPane.showInputDialog("Indica el usuario");
        
        while (!usuarioCorrecto.equals(USUARIO)) {
            usuarioCorrecto = JOptionPane.showInputDialog("Usuario incorrecto, prueba de nuevo");
        }
        
        contraseniaCorrecto = Integer.parseInt(JOptionPane.showInputDialog("Indica la contraseña"));
        
        while (contraseniaCorrecto != CONTRASENIA) {
            contraseniaCorrecto = Integer.parseInt(JOptionPane.showInputDialog("Contraseña incorrecta, prueba de nuevo"));
        }
        
        JOptionPane.showMessageDialog(null, "Has accedido con exito al programa");
        JOptionPane.showMessageDialog(null, "Primero vamos a indicar cuantos metros tiene cada sala de la vivienda");
        
        for (int i = 0; i < metrosDepen.length; i++) {
            do {
                metrosDepen[i] = Double.parseDouble(JOptionPane.showInputDialog("Cuantos metros tiene " + dependencias[i]));
            } while (metrosDepen[i] < 1 || metrosDepen[i] > 100);
        }
        
        do {
            
            do {
                opciones = Integer.parseInt(JOptionPane.showInputDialog("¿Qué opción desea ver? \n"
                        + "1- Carga \n"
                        + "2- Aspiración \n"
                        + "3- Aspiración y fregado \n"
                        + "4- Estado general \n"
                        + "5- Base de carga \n"
                        + "6- Salir"));
            } while (opciones < 1 || opciones > 6);
            
            switch (opciones) {
                case 1:
                    JOptionPane.showMessageDialog(null, "Has elegido la opción de carga");
                    
                    do {
                        nivelBateria = Integer.parseInt(JOptionPane.showInputDialog("Indica el nivel de batería que tiene la aspiradora"));
                    } while (nivelBateria < 0 || nivelBateria > 100);
                    break;
                
                case 2:
                    JOptionPane.showMessageDialog(null, "Has elegido la opción de aspiración");
                    
                    do {
                        opcionesAspiracion = Integer.parseInt(JOptionPane.showInputDialog("¿Qué opción desea hacer? \n"
                                + "1- Modo completo \n"
                                + "2- Modo dependencias \n"));
                    } while (opcionesAspiracion < 1 || opcionesAspiracion > 2);
                    
                    switch (opcionesAspiracion) {
                        case 1:
                            JOptionPane.showMessageDialog(null, "Modo completo");
                            
                            for (int i = 0; i < metrosDepen.length; i++) {
                                carga = (1.5 * metrosDepen[i]) / 1;
                                nivelBateria = nivelBateria - carga;
                                
                                if (nivelBateria < 3) {
                                    JOptionPane.showMessageDialog(null, "La aspiradora no tiene suficiente batería para limpiar y esta "
                                            + "parado en " + dependencias[i] + ", por favor cargue la aspiradora en la base de carga");
                                    
                                    for (int j = 0; j != contador; j++) {
                                        
                                        try {
                                            JOptionPane.showMessageDialog(null, "La aspiradora ha limpiado " + dependencias[j]);
                                        } catch (ArrayIndexOutOfBoundsException aiooe) {
                                            
                                            JOptionPane.showMessageDialog(null, "La aspiradora ha limpiado todas las habitaciones y le queda de batería"
                                                    + " un " + (nivelBateria = Math.abs(nivelBateria)) + "%");
                                            break;
                                        }
                                    }
                                    
                                    if (contador == 0) {
                                        JOptionPane.showMessageDialog(null, "La aspiradora no ha limpiado ninguna habitación");
                                    }
                                    break;
                                }
                                contador++;
                            }
                            
                            if (nivelBateria > 3) {
                                
                                if (nivelBateria < 0) {
                                    nivelBateria = Math.abs(nivelBateria);
                                }
                                
                                JOptionPane.showMessageDialog(null, "La aspiradora ha limpiado todas las habitaciones y le queda de batería"
                                        + " un " + nivelBateria + "%");
                            }
                            break;
                        
                        case 2:
                            break;
                    }
                    break;
                
                case 3:
                    JOptionPane.showMessageDialog(null, "Has elegido la opción de aspiración y fregado");
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Has elegido la opción de estado general");
                    break;
                
                case 5:
                    JOptionPane.showMessageDialog(null, "Has elegido la opción de base de carga");
                    
                    if (nivelBateria == 100) {
                        JOptionPane.showMessageDialog(null, "La batería ya está al 100%");
                    } else {
                        JOptionPane.showMessageDialog(null, "Cargando la aspiradora al 100%...");
                    }
                    nivelBateria = 100;
                    break;
                
                case 6:
                    salir = JOptionPane.showConfirmDialog(null,
                            "¿Deseas salir?", "Salida del programa", JOptionPane.YES_NO_OPTION);
                    
                    if (salir == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Saliendo con exito");
                        repetir = false;
                    }
                    break;
            }
        } while (repetir);
    }
}
