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

        double[] metrosDepen = new double[5];

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
            switch (i) {
                case 0:
                    dependencia = "la cocina";
                    break;
                case 1:
                    dependencia = "el salón";
                    break;
                case 2:
                    dependencia = "el cuarto de baño";
                    break;
                case 3:
                    dependencia = "el primer dormitorio";
                    break;
                case 4:
                    dependencia = "el segundo dormitorio";
                    break;
            }

            do {
                metrosDepen[i] = Double.parseDouble(JOptionPane.showInputDialog("Cuantos metros tiene " + dependencia));
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
