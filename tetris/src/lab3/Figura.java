package lab3;

import java.awt.Color;
import java.awt.Graphics;

public abstract  class Figura {
	 
	 protected double x,y;
	 protected Color color;
	 protected Scena scena;
	 
	 public double getX() {
		 return this.x;
	 }
	 
	 public double getY() {
		 return this.y;
	 }
	 
	 
	 
	
	public Figura(Scena s,double x,double y,Color boja) {
		this.x=x;
		this.y=y;
		this.scena=s;
		this.color=boja;
		scena.addFigure(this);
	}
	
	 abstract public char getOznaka();
	 
	  abstract public void pomeri(double pomerajx,double pomerajY);
	  
	  abstract  public void draw(Graphics g);
	  
	  
	  @Override
	public boolean equals(Object obj) {
		  if(!(obj instanceof Figura)) return false;
		  Figura f=(Figura) obj;
		  return this.x==f.x && this.y==f.y && this.getOznaka()==f.getOznaka();
		  
	
	}
	  
	  

}
