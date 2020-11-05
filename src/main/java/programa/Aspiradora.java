package programa;

import javax.swing.JOptionPane;

/**
 *
 * @author Jorge
 */
public class Aspiradora {

    public static void main(String[] args) {

        int opciones;
        double metrosCocina = 0, metrosSalon = 0, metrosBanio = 0, metrosDormitorio = 0, metrosDormitorio2 = 0;

        JOptionPane.showMessageDialog(null, "Bienvenido al menú de la aspiradora");
        JOptionPane.showMessageDialog(null, "Primero vamos a indicar cuantos metros tiene cada sala de la vivienda");

        do {
            metrosCocina = Double.parseDouble(JOptionPane.showInputDialog("Cuantos metros tiene la cocina:"));
        } while (metrosCocina < 1 || metrosCocina > 100);

        do {
            metrosSalon = Double.parseDouble(JOptionPane.showInputDialog("Cuantos metros tiene el salón:"));
        } while (metrosSalon < 1 || metrosSalon > 100);

        do {
            metrosBanio = Double.parseDouble(JOptionPane.showInputDialog("Cuantos metros tiene el baño:"));
        } while (metrosBanio < 1 || metrosBanio > 100);

        do {
            metrosDormitorio = Double.parseDouble(JOptionPane.showInputDialog("Cuantos metros tiene el dormitorio:"));
        } while (metrosDormitorio < 1 || metrosDormitorio > 100);

        do {
            metrosDormitorio2 = Double.parseDouble(JOptionPane.showInputDialog("Cuantos metros tiene el segundo dormitorio:"));
        } while (metrosDormitorio2 < 1 || metrosDormitorio2 > 100);

        opciones = Integer.parseInt(JOptionPane.showInputDialog("¿Qué opción desea ver? \n"
                + "1- Carga \n"
                + "2- Aspiración \n"
                + "3- Aspiración y fregado \n"
                + "4- Estado general \n"
                + "5- Base de carga \n"
                + "6- Salir"));

        switch (opciones) {
            case 1:
                JOptionPane.showMessageDialog(null, "Has elegido la opción de carga");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Has elegido la opción de aspiración");
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
                JOptionPane.showMessageDialog(null, "Has elegido salir del programa");
                break;
        }
    }
}
