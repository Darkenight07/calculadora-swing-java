package swing.calculadora;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import swing.listener.KeyListenerNumeros;

public class Calculadora extends JFrame {

    private static final long serialVersionUID = 1L;

    private String titulo;
    public static JTextField resultado;

    private Calculadora(String titulo) {
        this.titulo = titulo;
    }

    private void mostrarVentana() {
        cambiarEstilo();
        setTitle(titulo);
        setSize(475, 577);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        resultado = new JTextField();
        resultado.setHorizontalAlignment(JTextField.CENTER);
        resultado.setFont(new Font("Arial",Font.PLAIN,25));
        resultado.setEditable(false);
        resultado.setPreferredSize(new Dimension(100, 100));


        JPanel panelOpciones = new JPanel();
        panelOpciones.setLayout(new GridLayout(4,4));

        JButton button1 = new JButton("1");
        button1.setFont(new Font("Arial",Font.PLAIN,25));
        button1.addActionListener(insertarNumeros());
        button1.addKeyListener(new KeyListenerNumeros());
        JButton button2 = new JButton("2");
        button2.setFont(new Font("Arial",Font.PLAIN,25));
        button2.addActionListener(insertarNumeros());
        button2.addKeyListener(new KeyListenerNumeros());
        JButton button3 = new JButton("3");
        button3.setFont(new Font("Arial",Font.PLAIN,25));
        button3.addActionListener(insertarNumeros());
        button3.addKeyListener(new KeyListenerNumeros());
        JButton button4 = new JButton("4");
        button4.setFont(new Font("Arial",Font.PLAIN,25));
        button4.addActionListener(insertarNumeros());
        button4.addKeyListener(new KeyListenerNumeros());
        JButton button5 = new JButton("5");
        button5.setFont(new Font("Arial",Font.PLAIN,25));
        button5.addActionListener(insertarNumeros());
        button5.addKeyListener(new KeyListenerNumeros());
        JButton button6 = new JButton("6");
        button6.setFont(new Font("Arial",Font.PLAIN,25));
        button6.addActionListener(insertarNumeros());
        button6.addKeyListener(new KeyListenerNumeros());
        JButton button7 = new JButton("7");
        button7.setFont(new Font("Arial",Font.PLAIN,25));
        button7.addActionListener(insertarNumeros());
        button7.addKeyListener(new KeyListenerNumeros());
        JButton button8 = new JButton("8");
        button8.setFont(new Font("Arial",Font.PLAIN,25));
        button8.addActionListener(insertarNumeros());
        button8.addKeyListener(new KeyListenerNumeros());
        JButton button9 = new JButton("9");
        button9.setFont(new Font("Arial",Font.PLAIN,25));
        button9.addActionListener(insertarNumeros());
        button9.addKeyListener(new KeyListenerNumeros());
        JButton button0 = new JButton("0");
        button0.setFont(new Font("Arial",Font.PLAIN,25));
        button0.addActionListener(insertarNumeros());
        button0.addKeyListener(new KeyListenerNumeros());
        JButton buttonSuma = new JButton("+");
        buttonSuma.setFont(new Font("Arial",Font.PLAIN,25));
        buttonSuma.addActionListener(ponerOperaciones());
        JButton buttonResta = new JButton("-");
        buttonResta.setFont(new Font("Arial",Font.PLAIN,25));
        buttonResta.addActionListener(ponerOperaciones());
        JButton buttonMultiplicacion = new JButton("X");
        buttonMultiplicacion.setFont(new Font("Arial",Font.PLAIN,25));
        buttonMultiplicacion.addActionListener(ponerOperaciones());
        JButton buttonDivision = new JButton("/");
        buttonDivision.setFont(new Font("Arial",Font.PLAIN,25));
        buttonDivision.addActionListener(ponerOperaciones());
        JButton buttonIgual = new JButton("=");
        buttonIgual.setFont(new Font("Arial",Font.PLAIN,25));
        buttonIgual.addActionListener(hacerOperaciones());
        JButton buttonBorrar = new JButton("C");
        buttonBorrar.setFont(new Font("Arial",Font.PLAIN,25));
        buttonBorrar.addActionListener(borrarNumeros());


        panelOpciones.add(button7);
        panelOpciones.add(button8);
        panelOpciones.add(button9);
        panelOpciones.add(buttonMultiplicacion);
        panelOpciones.add(button4);
        panelOpciones.add(button5);
        panelOpciones.add(button6);
        panelOpciones.add(buttonResta);
        panelOpciones.add(button1);
        panelOpciones.add(button2);
        panelOpciones.add(button3);
        panelOpciones.add(buttonSuma);
        panelOpciones.add(buttonDivision);
        panelOpciones.add(button0);
        panelOpciones.add(buttonBorrar);
        panelOpciones.add(buttonIgual);

        add(resultado,BorderLayout.NORTH);
        add(panelOpciones,BorderLayout.CENTER);

        setVisible(true);
    }

    private void cambiarEstilo() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);

        try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    private ActionListener insertarNumeros() {
        ActionListener actionlistener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String anteriorTexto = resultado.getText();

                if (anteriorTexto.equals("0")) {
                    anteriorTexto = "";
                }
                String numero = e.getActionCommand();
                resultado.setText(anteriorTexto + numero);
            }};
        return actionlistener;
    }

    private ActionListener borrarNumeros() {
        ActionListener actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                resultado.setText("");
            }};
        return actionListener;
    }

    private ActionListener hacerOperaciones() {
        ActionListener actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = resultado.getText();
                String[] numeros = texto.split("[+-/*]");
                int numero1 = Integer.parseInt(numeros[0]);
                int numero2 = Integer.parseInt(numeros[1]);
                String operacion = texto.substring(numeros[0].length(), numeros[0].length() + 1);
                int resultadoInt = 0;

                switch (operacion) {
                    case "+":
                        resultadoInt = numero1 + numero2;
                        break;
                    case "-":
                        resultadoInt = numero1 - numero2;
                        break;
                    case "*":
                        resultadoInt = numero1 * numero2;
                        break;
                    case "/":
                        resultadoInt = numero1 / numero2;
                        break;
                }
                resultado.setText(resultadoInt + "");
            }};
        return actionListener;
    }

    private ActionListener ponerOperaciones() {
        ActionListener actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String signoOperacion = "";
                if (e.getActionCommand().equals("X")) {
                    signoOperacion = "*";
                } else {
                    signoOperacion = e.getActionCommand();
                }
                String textoAnterior = resultado.getText();
                resultado.setText(textoAnterior + signoOperacion);

            }};
        return actionListener;
    }


    public static void main(String[] args) {
        new Calculadora("Calculadora").mostrarVentana();
    }

}
