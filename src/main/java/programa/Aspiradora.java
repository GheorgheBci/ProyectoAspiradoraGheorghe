package programa;

import javax.swing.JOptionPane;

/**
 *
 * @author Jorge
 */
public class Aspiradora {

    public static void main(String[] args) {

        // Constantes que usaremos como credenciales para acceder al programa
        final String USUARIO = "George";
        final int CONTRASENIA = 12345;

        int opciones; // Variable que almacenara las distintas opciones del menú principal (entre 1 y 6)
        int salir; // Variable que almacenara un valor entero (0 o 1) en función de si pulsa Si o No en la opción de salir del programa
        int opcionesAspiracion; // Variable que almacenara las opciones del menú de aspiración (1 o 2)
        int opcionesAspiracionFregado; // Variable que almacenara las opciones del menú de aspiración y fregado (1 o 2)
        int opcionesDependencias; // Variable que almacenara las opciones del menú del modo dependencias de aspiración (entre 0 o 4)
        int opcionesDependencias2; // Variable que almacenara las opciones del menú del modo dependencias de aspiración y fregado (entre 0 o 4)
        boolean repetir = true; // Con esta variable controlamos si salir o no del programa
        String usuarioCorrecto; // Con esta variable tenemos que indicar el usuario correcto
        int contraseniaCorrecto; // Con esta variable tenemos que indicar la contraseña correcta
        double nivelBateria = 0; // Almacenara el nivel de batería que tendrá la aspiradora
        String dependencia = ""; // Almacenara un nombre de dependencia que le indiquemos
        int contador = 0; // Este contador nos servira para contar cada vez que se ha limpiado una habitación
        double carga = 0; // Variable que almacenara un valor que luego se restara al nivel de la batería

        double[] metrosDepen = new double[5]; // Array que guardara cada metros cuadrado de cada dependencia 

        String[] dependencias = new String[5]; // Array que guardara cada dependencia 
        dependencias[0] = "la cocina";
        dependencias[1] = "el salón";
        dependencias[2] = "el cuarto de baño";
        dependencias[3] = "el primer dormitorio";
        dependencias[4] = "el segundo dormitorio";

        JOptionPane.showMessageDialog(null, "Bienvenido al menú de la aspiradora");
        // El usuario tendra que escribir el usuario y contraseña correcta para poder acceder al programa
        usuarioCorrecto = JOptionPane.showInputDialog("Indica el usuario");

        // Este bucle controla si el usuario escribe mal el usuario
        while (!usuarioCorrecto.equals(USUARIO)) {
            usuarioCorrecto = JOptionPane.showInputDialog("Usuario incorrecto, prueba de nuevo");
        }

        contraseniaCorrecto = Integer.parseInt(JOptionPane.showInputDialog("Indica la contraseña"));

        // Este bucle controla si el usuario escribe mal la contraseña
        while (contraseniaCorrecto != CONTRASENIA) {
            contraseniaCorrecto = Integer.parseInt(JOptionPane.showInputDialog("Contraseña incorrecta, prueba de nuevo"));
        }

        // Una vez dentro del programa se muestra un mensaje de bienvenida
        JOptionPane.showMessageDialog(null, "Has accedido con exito al programa");
        JOptionPane.showMessageDialog(null, "Primero vamos a indicar cuantos metros tiene cada sala de la vivienda");

        // Mediante un bucle for iremos indicando el tamaño (metros cuadrado) que tendrá cada dependencia
        for (int i = 0; i < metrosDepen.length; i++) {
            // Con este bucle controlamos que el tamaño que se indique se encuentra entre los valores correctos (entre 1 y 100)
            do {
                // Cada tamaño que le indiquemos se almacenara en una posición del array
                metrosDepen[i] = Double.parseDouble(JOptionPane.showInputDialog("Cuantos metros tiene " + dependencias[i]));
            } while (metrosDepen[i] < 1 || metrosDepen[i] > 100);
        }

        do { // Este bucle controla si salir o no del programa

            // Se muestra el menú con las distintas opciones de la aspiradora y con el bucle do while controlamos que se indique un
            // valor correcto (entre 1 y 6)
            do {
                opciones = Integer.parseInt(JOptionPane.showInputDialog("¿Qué opción desea ver? \n"
                        + "1- Carga \n"
                        + "2- Aspiración \n"
                        + "3- Aspiración y fregado \n"
                        + "4- Estado general \n"
                        + "5- Base de carga \n"
                        + "6- Salir"));
            } while (opciones < 1 || opciones > 6);

            // Dependiendo del valor que hayamos indicado entrara en su case correspondiente
            switch (opciones) {
                case 1: // En el case 1 vamos a indicar la batería que tiene la aspiradora en ese momento
                    JOptionPane.showMessageDialog(null, "Has elegido la opción de carga");

                    // Con este bucle controlamos que el valor que introduzcamos sea el correcto (entre 0 y 100)
                    do {
                        nivelBateria = Integer.parseInt(JOptionPane.showInputDialog("Indica el nivel de batería que tiene la aspiradora"));
                    } while (nivelBateria < 0 || nivelBateria > 100);
                    break;

                case 2: // En el case 2 la aspiradora empezara a limpiar dependiendo del modo que le hayamos indicado a continuación
                    JOptionPane.showMessageDialog(null, "Has elegido la opción de aspiración");

                    // El usuario escogera que opción de aspiración quiere hacer. Con el bucle do while controlamos que el valor indicado
                    // sea el correcto (1 o 2)
                    do {
                        opcionesAspiracion = Integer.parseInt(JOptionPane.showInputDialog("¿Qué opción desea hacer? \n"
                                + "1- Modo completo \n"
                                + "2- Modo dependencias \n"));
                    } while (opcionesAspiracion < 1 || opcionesAspiracion > 2);

                    // Dependiento de que valor hayamos introducido entrará en el case correspodiente
                    switch (opcionesAspiracion) {
                        case 1: // En el modo completo la aspiradora limpiara todas las habitaciones mientra tenga batería suficiente
                            JOptionPane.showMessageDialog(null, "Modo completo");

                            // En el bucle for la aspiradora empezara a limpiar cada dependencia
                            for (int i = 0; i < metrosDepen.length; i++) {
                                carga = (1.5 * metrosDepen[i]) / 1; // Calculo para ver cuanta batería consume según el tamaño de la dependencia
                                nivelBateria = nivelBateria - carga; // Luego restamos el valor de la carga a la batería que tenga en ese momento

                                // Si el nivel de batería es menor de 3
                                if (nivelBateria < 3) {
                                    // Se muestra un mensaje de que la aspiradora no tiene suficiente batería para limpiar la siguiente
                                    // dependencia, además también te indica en que dependencia está parada
                                    JOptionPane.showMessageDialog(null, "La aspiradora no tiene suficiente batería para limpiar y esta "
                                            + "parado en " + dependencias[i] + ", por favor cargue la aspiradora en la base de carga");

                                    // Mientras j sea diferente al valor de contador se muestra que dependencias ha limpiado
                                    for (int j = 0; j != contador; j++) {

                                        // El try catch nos servira para controlar la excepción ArrayIndexOutOfBoundsException
                                        try {
                                            JOptionPane.showMessageDialog(null, "La aspiradora ha limpiado " + dependencias[j]);
                                        } catch (ArrayIndexOutOfBoundsException aiooe) {
                                            JOptionPane.showMessageDialog(null, "La aspiradora ha limpiado todas las habitaciones y le queda de batería"
                                                    + " un " + (nivelBateria = Math.abs(nivelBateria)) + "%");
                                        }
                                    }

                                    // Si el contador es igual a 0 muestra que la aspiradora no ha limpiado ninguna habitación
                                    // En este caso es cuando el tamaño de una dependencia es demasiado grande
                                    if (contador == 0) {
                                        JOptionPane.showMessageDialog(null, "La aspiradora no ha limpiado ninguna habitación");
                                    }
                                    break;
                                }
                                contador++; // Este contador es para contar cada vez que se limpia una dependencia
                            }

                            // En este if solo entrara si ha llegado a limpiar todas las dependencias y la batería sea mayor de 3
                            if (nivelBateria > 3) {

                                // Si el valor de la batería es un número negativo lo convierte en positivo
                                if (nivelBateria < 0) {
                                    nivelBateria = Math.abs(nivelBateria);
                                }

                                // Se muestra que la aspiradora ha limpiado todas las habitaciones y cuanto % de batería le queda
                                JOptionPane.showMessageDialog(null, "La aspiradora ha limpiado todas las habitaciones y le queda de batería"
                                        + " un " + nivelBateria + "%");
                            }
                            break;

                        case 2: // En el modo dependencias la aspiradora limpiara la habitación que le indiquemos
                            JOptionPane.showMessageDialog(null, "Modo dependencias");

                            // Mostramos la lista de dependencias que queremos limpiar y con el bucle do while controlamos que el valor
                            // que introduzcamos sea correcto
                            do {
                                opcionesDependencias = Integer.parseInt(JOptionPane.showInputDialog("¿Qué dependencia quieres limpiar? \n"
                                        + "0- La cocina \n"
                                        + "1- El salón \n"
                                        + "2- El cuarto de baño \n"
                                        + "3- El primer dormitorio \n"
                                        + "4- El segundo dormitorio"));
                            } while (opcionesDependencias < 0 || opcionesDependencias > 4);

                            // Dependiendo del valor que hemos indicado entrara en su case correspondiente
                            switch (opcionesDependencias) {
                                case 0: // Limpia la cocina
                                    dependencia = "la cocina";
                                    carga = (1.5 * metrosDepen[0]) / 1;
                                    nivelBateria = nivelBateria - carga;
                                    break;

                                case 1: // Limpia el salón
                                    dependencia = "el salón";
                                    carga = (1.5 * metrosDepen[1]) / 1;
                                    nivelBateria = nivelBateria - carga;
                                    break;

                                case 2: // Limpia el cuarto de baño
                                    dependencia = "el cuarto de baño";
                                    carga = (1.5 * metrosDepen[2]) / 1;
                                    nivelBateria = nivelBateria - carga;
                                    break;

                                case 3: // Limpia el primer dormitorio
                                    dependencia = "el primer dormitorio";
                                    carga = (1.5 * metrosDepen[3]) / 1;
                                    nivelBateria = nivelBateria - carga;
                                    break;

                                case 4: // Limpia el segundo dormitorio
                                    dependencia = "el segundo dormitorio";
                                    carga = (1.5 * metrosDepen[4]) / 1;
                                    nivelBateria = nivelBateria - carga;
                                    break;
                            }

                            // Despues de limpiar una dependencia controlamos si tiene suficiente batería para limpiar la siguiente habitación
                            // que le indiquemos
                            if (nivelBateria < 3) { // Si no tiene suficiente batería muestra un mensaje que no tiene batería
                                JOptionPane.showMessageDialog(null, "La aspiradora no tiene suficiente batería para limpiar " + dependencia
                                        + ", por favor ve a la base de carga");
                            } else { // Si el nivel de batería es mayor de 3 muestra que la dependencia que hemos indicado para limpiar se ha limpiado correctamente
                                JOptionPane.showMessageDialog(null, "La aspiradora ha limpiado " + dependencia);
                            }
                            break;
                    }
                    break;

                case 3: // El case 3 es lo mismo que el 2 pero a la batería se le quitara un 2.25 por cada metro cuadrado
                    JOptionPane.showMessageDialog(null, "Has elegido la opción de aspiración y fregado");

                    do {
                        opcionesAspiracionFregado = Integer.parseInt(JOptionPane.showInputDialog("¿Qué opción desea hacer? \n"
                                + "1- Modo completo \n"
                                + "2- Modo dependencias \n"));
                    } while (opcionesAspiracionFregado < 1 || opcionesAspiracionFregado > 2);

                    switch (opcionesAspiracionFregado) {
                        case 1:
                            JOptionPane.showMessageDialog(null, "Modo completo");

                            for (int i = 0; i < metrosDepen.length; i++) {
                                carga = (2.25 * metrosDepen[i]) / 1;
                                nivelBateria = nivelBateria - carga;

                                if (nivelBateria < 0) {
                                    nivelBateria = Math.abs(nivelBateria);
                                }
                                System.out.println(nivelBateria);

                                if (nivelBateria < 3) {
                                    JOptionPane.showMessageDialog(null, "La aspiradora no tiene suficiente batería para limpiar y esta "
                                            + "parado en " + dependencias[i] + ", por favor cargue la aspiradora en la base de carga");

                                    for (int j = 0; j != contador; j++) {

                                        try {
                                            JOptionPane.showMessageDialog(null, "La aspiradora ha limpiado " + dependencias[j]);
                                        } catch (ArrayIndexOutOfBoundsException aiooe) {
                                            JOptionPane.showMessageDialog(null, "La aspiradora ha limpiado todas las habitaciones y le queda de batería"
                                                    + " un " + (nivelBateria = Math.abs(nivelBateria)) + "%");
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
                                JOptionPane.showMessageDialog(null, "La aspiradora ha limpiado todas las habitaciones y le queda de batería"
                                        + " un " + nivelBateria + "%");
                            }
                            break;

                        case 2:
                            JOptionPane.showMessageDialog(null, "Modo dependencias");

                            do {
                                opcionesDependencias2 = Integer.parseInt(JOptionPane.showInputDialog("¿Qué dependencia quieres limpiar? \n"
                                        + "0- La cocina \n"
                                        + "1- El salón \n"
                                        + "2- El cuarto de baño \n"
                                        + "3- El primer dormitorio \n"
                                        + "4- El segundo dormitorio"));
                            } while (opcionesDependencias2 < 0 || opcionesDependencias2 > 4);

                            switch (opcionesDependencias2) {
                                case 0:
                                    dependencia = "la cocina";
                                    carga = (2.25 * metrosDepen[0]) / 1;
                                    nivelBateria = nivelBateria - carga;
                                    break;

                                case 1:
                                    dependencia = "el salón";
                                    carga = (2.25 * metrosDepen[1]) / 1;
                                    nivelBateria = nivelBateria - carga;
                                    break;

                                case 2:
                                    dependencia = "el cuarto de baño";
                                    carga = (2.25 * metrosDepen[2]) / 1;
                                    nivelBateria = nivelBateria - carga;
                                    break;

                                case 3:
                                    dependencia = "el primer dormitorio";
                                    carga = (2.25 * metrosDepen[3]) / 1;
                                    nivelBateria = nivelBateria - carga;
                                    break;

                                case 4:
                                    dependencia = "el segundo dormitorio";
                                    carga = (2.25 * metrosDepen[4]) / 1;
                                    nivelBateria = nivelBateria - carga;
                                    break;
                            }

                            if (nivelBateria < 3) {
                                JOptionPane.showMessageDialog(null, "La aspiradora no tiene suficiente batería para limpiar " + dependencia
                                        + ", por favor ve a la base de carga");
                            } else {
                                JOptionPane.showMessageDialog(null, "La aspiradora ha limpiado " + dependencia);
                            }
                            break;
                    }

                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Has elegido la opción de estado general");
                    break;

                case 5: // En el case 5 cargaremos la batería hasta el 100
                    JOptionPane.showMessageDialog(null, "Has elegido la opción de base de carga");

                    if (nivelBateria == 100) { // En el caso de que ya tengamos al 100% la batería lo muestra por mensaje
                        JOptionPane.showMessageDialog(null, "La batería ya está al 100%");
                    } else { // En otro caso cargara hasta el 100%
                        JOptionPane.showMessageDialog(null, "Cargando la aspiradora al 100%...");
                    }
                    nivelBateria = 100; // El nivel de batería se establece a 100 
                    break;

                case 6: // En el case 6 decidimos si salir o no del programa
                    // El programa nos pregunta si queremos salir 
                    salir = JOptionPane.showConfirmDialog(null,
                            "¿Deseas salir?", "Salida del programa", JOptionPane.YES_NO_OPTION);

                    // Si pulsamos el botón Si el programa termina 
                    if (salir == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Saliendo con exito");
                        repetir = false;
                    }
                    break;
            }
        } while (repetir);
    }
}
