package lab3;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class IgraLoptica extends Frame {
    private Scena scena;
    

    public IgraLoptica() {
        super("Simulacija");
        
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        scena = new Scena();
        scena.setSize(500, 500);
        add(scena, BorderLayout.CENTER);

        dodajNoveFigure();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
               dispose();
            }
        });

        setVisible(true);
        
        addWindowListener(new WindowAdapter() {
        	@Override
        	public void windowClosing(WindowEvent e) {
        		scena.pogasiNiti();
        		dispose();
        	}
		});
        
        addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_LEFT) {
					scena.getIgrac().pomeri(-10,0);
				}
				
				if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
					scena.getIgrac().pomeri(+10,0);
				}
				
			}
		});
        pack();
    }

    private void dodajNoveFigure() {
        // Kreiranje novih figura
        //Loptica loptica = new Loptica(scena, 200, 200, 50, 30);
       // Cigla cigla = new Cigla(scena, 100,20, 100, 50, 20);
         //new Igrac(scena, 100,20);
         System.out.println(scena.lista.size());

        //cigla.pokreniJe();
        
    }

    public static void main(String[] args) {
        new IgraLoptica();
    }
}
