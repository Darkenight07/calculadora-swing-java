package swing.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.apache.commons.lang3.math.NumberUtils;
import swing.calculadora.Calculadora;

public class KeyListenerNumeros implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (NumberUtils.isCreatable(KeyEvent.getKeyText(e.getKeyCode()))) {
            String textoAnterior = Calculadora.resultado.getText();
            Calculadora.resultado.setText(textoAnterior + KeyEvent.getKeyText(e.getKeyCode()));
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

}
