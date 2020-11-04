package programa;

import javax.swing.JOptionPane;

/**
 *
 * @author Jorge
 */
public class Aspiradora {

    public static void main(String[] args) {

        int opciones;

        JOptionPane.showMessageDialog(null, "Bienvenido al menú de la aspiradora");
        opciones = Integer.parseInt(JOptionPane.showInputDialog("¿Qué opción desea ver? \n"
                + "1- Configurar el sistema \n"
                + "2- Carga \n"
                + "3- Aspiración \n"
                + "4- Aspiración y fregado \n"
                + "5- Estado general \n"
                + "6- Base de carga \n"
                + "7- Salir"));
    }
}
