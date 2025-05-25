package lab3;

import java.awt.Color;
import java.awt.Graphics;

public class Igrac extends Figura {
	private int sirina,visina;

	public Igrac(Scena s,int sirina,int visina) {
		super(s,(int)(s.getPreferredSize().getWidth()/2),(int)(s.getPreferredSize().getHeight()-20-visina/2), Color.BLUE);
		this.sirina=sirina;
		this.visina=visina;
		// TODO Auto-generated constructor stub
	}

	@Override
	public char getOznaka() {
		// TODO Auto-generated method stub
		return 'I';
	}
	
	

	@Override
	public void pomeri(double pomerajX,double pomerajY) {
	 if(pomerajX>=0) {
		 if(this.x+sirina/2+pomerajX>this.scena.getWidth()) return;
		 else this.x+=pomerajX;
	 }
	 else {
		 if(this.x-sirina/2+pomerajX<0) return;
		 else this.x+=pomerajX;
	 }
	 this.scena.repaint();
	 
		
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(this.color);
		 g.fillRect((int)(x - sirina / 2),(int)( y - visina / 2), sirina, visina);	

	}
	
	public int getSirina() {
		return this.sirina;
	}
	
	public int getVisina() {
		return this.visina;
	}

}
