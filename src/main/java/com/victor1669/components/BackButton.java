package com.victor1669.components;

import com.victor1669.telas.MainForm;
import javax.swing.JButton;

public final class BackButton extends JButton {

    public BackButton() {
        super("<-");
        mountButton();
    }

    public BackButton(String texto) {
        super(texto);
        mountButton();
        
    }

    void mountButton() {
        setBounds(30, 30, 50, 30);
        addActionListener(e -> {
            MainForm.voltarTelaInicial();
        });
    }

}
