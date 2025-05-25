package lab3;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

public class Scena extends Canvas {
	
	private Igrac igrac;
	
	 ArrayList<Figura> lista=new ArrayList();
	
	

	public Scena() {
		setPreferredSize(new Dimension(500,500));
		
		igrac=new  Igrac(this, 100,20);
		 (new Cigla(this, 70,20, 100, 100, 20)).pokreniJe();
		 (new Cigla(this, 190,20, 100, 100, 20)).pokreniJe();
		 (new Cigla(this, 310,20, 100, 100, 20)).pokreniJe();
		 (new Cigla(this, 430,20, 100, 100, 20)).pokreniJe();
		
		
		
		addMouseListener(new MouseAdapter() {
		
            public void mouseClicked(MouseEvent e) {
            	getParent().requestFocus();
            	(new Loptica(Scena.this,Scena.this.igrac.getX(),Scena.this.igrac.getY()-2*Scena.this.igrac.getVisina()-10 ,10, igrac.getVisina()*2)).pokreniJe();
            	//new Loptica(Scena.this,Scena.this.igrac.getX(),Scena.this.igrac.getY()-2*Scena.this.igrac.getVisina() ,10, igrac.getVisina()*2);
            	
                
            }
        });
		

	}
	
	public Igrac getIgrac() {
		return this.igrac;
	}
	
	
	
	
	public void addFigure(Figura f) {
		if(!lista.contains(f)) lista.add(f);
		repaint();
	}
	
	@Override
	public synchronized void addMouseListener(MouseListener l) {
		// TODO Auto-generated method stub
		super.addMouseListener(l);
	}
	
	
	
	 synchronized public void paint(Graphics g) {
		ArrayList<AktivnaFigura> figureZaBrisanje=new  ArrayList<AktivnaFigura>();
		for(Figura f:lista) {
			if( f.y>=this.getHeight())
			{
				AktivnaFigura figura=(AktivnaFigura) f;
				figura.zaustaviJe();
				figureZaBrisanje.add(figura);
				
			} else {
				f.draw(g);
			}
		}
		for(AktivnaFigura brisi:figureZaBrisanje) {
			lista.remove(brisi);
		}
	}
	
	public void ukloniFiguru(Figura figura) {
		lista.remove(figura);
	}
	
	public Figura uzmiFiguru(int index) {
	    if (index < 0 || index >= lista.size()) {
	        return null;
	    }
	    return lista.get(index);
	}
	
	public void pogasiNiti() {
		for(Figura fig:lista) {
			if(fig instanceof AktivnaFigura) {
				AktivnaFigura af=(AktivnaFigura) fig;
				af.zaustaviJe();
				}
			}
	}
		
	
	
	
	
	

	

}
