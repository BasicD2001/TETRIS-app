package lab3;

import java.awt.Color;
import java.awt.Graphics;

public class Cigla extends AktivnaFigura {
	private boolean pogodjen=false;
	private int sirina,visina;

	public Cigla(Scena s, int x, int y, int perioda,int sirina,int visina) {
		super(s, x, y, perioda,Color.red);
		this.pomerajY=5;
		this.sirina=sirina;
		this.visina=visina;
	}

	@Override
	public char getOznaka() {
		// TODO Auto-generated method stub
		return 'C';
	}

	@Override
	public void pomeri(double pomerajX,double pomerajY) {
		if(pogodjen) this.y+=pomerajY;
		
		
	}

	@Override
	public void draw(Graphics g) {
		if(pogodjen) this.color=color.GRAY;
		g.setColor(this.color);
		 g.fillRect((int)(x - sirina / 2),(int)( y - visina / 2), sirina, visina);		
		
	}
	
	public boolean daLiJePogodjen() {
		return this.pogodjen;
	}
	
	public int GetSirina() {
		return sirina;
	}
	
	public int GetVisina() {
		return visina;
	}
	
	public void pogodiCiglu() {
		pogodjen=true;
	}

	

}
