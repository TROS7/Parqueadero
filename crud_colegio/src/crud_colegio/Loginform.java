package crud_colegio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Loginform extends JFrame implements ActionListener {
    // Componentes de la interfaz
    private JLabel lblUsuario, lblContraseña;
    private JTextField txtUsuario;
    private JPasswordField txtContraseña;
    private JButton btnIniciarSesion;

    public LoginForm() {
        // Configuración de la ventana
        setTitle("Inicio de Sesión");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Crear componentes
        lblUsuario = new JLabel("Usuario:");
        lblContraseña = new JLabel("Contraseña:");
        txtUsuario = new JTextField(20);
        txtContraseña = new JPasswordField(20);
        btnIniciarSesion = new JButton("Iniciar Sesión");

        // Agregar componentes al contenedor
        Container container = getContentPane();
        container.setLayout(new GridLayout(3, 2));
        container.add(lblUsuario);
        container.add(txtUsuario);
        container.add(lblContraseña);
        container.add(txtContraseña);
        container.add(new JLabel()); // Espacio en blanco
        container.add(btnIniciarSesion);

        // Asociar el botón con el ActionListener
        btnIniciarSesion.addActionListener(this);

        // Hacer visible la ventana
        setVisible(true);
    }

    // Método para manejar el evento del botón
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnIniciarSesion) {
            // Obtener el nombre de usuario y contraseña ingresados
            String usuario = txtUsuario.getText();
            String contraseña = new String(txtContraseña.getPassword());

            // Aquí debes agregar la lógica de autenticación y redireccionamiento según los roles
            // Por ahora, simplemente imprime los valores ingresados
            System.out.println("Usuario: " + usuario);
            System.out.println("Contraseña: " + contraseña);

            // Ejemplo de redirección a otra ventana después del inicio de sesión
            // Debes implementar la lógica real de redirección aquí
            // Ejemplo: new VentanaPrincipal(usuario);
        }
    }

    public static void main(String[] args) {
        // Crear una instancia de la ventana de inicio de sesión
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginForm();
            }
        });
    }
}