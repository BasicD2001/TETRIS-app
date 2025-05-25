package lab3;

import java.awt.Color;
import java.awt.Graphics;

abstract  public class AktivnaFigura extends Figura implements Runnable {
	
	protected boolean pokreni,zaustavi=false;
	protected int t;
	Thread nit=new Thread(this);
	protected double pomerajX=0;
	protected double pomerajY=0;

	public AktivnaFigura(Scena s, double x, double y,int perioda,Color boja) {
		super(s, x, y,boja);
		this.t=perioda;
		// TODO Auto-generated constructor stub
	}
	
	public void pokreniJe() {
		if(!this.pokreni) {
			nit.start();
			pokreni=true;
			}
	}
	
	public void zaustaviJe() {
		if(!this.zaustavi) {
			
			nit.interrupt();
			zaustavi=true;
			}
		}
	
	
	@Override
	public void run() {
		try {
			while(!nit.interrupted()) {
					nit.sleep(t);
					this.pomeri(this.pomerajX,this.pomerajY);
					scena.repaint();
				} 
				
			} catch (InterruptedException e) {
				
			}
		
		
	
	} 
	}
	
	


