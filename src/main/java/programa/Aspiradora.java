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
        
        switch(opciones){
            case 1:
                JOptionPane.showMessageDialog(null, "Has elegido la opción de configurar el sistema");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Has elegido la opción de carga");
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Has elegido la opción de aspiración");
                break;
            case 4:
                JOptionPane.showMessageDialog(null, "Has elegido la opción de aspiración y fregado");
                break;
            case 5:
                JOptionPane.showMessageDialog(null, "Has elegido la opción de estado general");
                break;
            case 6:
                JOptionPane.showMessageDialog(null, "Has elegido la opción de base de carga");
                break;
            case 7:
                JOptionPane.showMessageDialog(null, "Has elegido salir del programa");
                break;
        }
    }
}
