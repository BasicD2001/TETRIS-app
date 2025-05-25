package lab3;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Loptica extends AktivnaFigura {
	private int precnik;

	private static final double minX = -1;

	private static final double maxX = +1;

	private static final double minY = 0;

	private static final double maxY = 1;

	private static final double updateSpeed = 1.1;

	private int brojPerioda;

	public Loptica(Scena s, double x, double y, int perioda, int precnik) {
		super(s, x, y, perioda, Color.green);
		this.brojPerioda = 0;
		// TODO Auto-generated constructor stub
		this.precnik = precnik;

		this.pomerajX = Math.random() * 2 - 1;
		this.pomerajY = -Math.random();

	}

	@Override
	public char getOznaka() {
		// TODO Auto-generated method stub
		return 'L';
	}

	@Override
	public void pomeri(double pomerajX, double pomerajY) {
		brojPerioda++;
		int sirinaIgraca = this.scena.getIgrac().getSirina();
		int visinaIgraca = this.scena.getIgrac().getVisina();
		double xIgraca = this.scena.getIgrac().getX();
		double yIgraca = this.scena.getIgrac().getY();
		int poluprecnik = this.precnik / 2;
		double desniKrajIgraca = xIgraca + sirinaIgraca / 2;
		double leviKrajIgraca = xIgraca - sirinaIgraca / 2;
		double vrhIgraca = yIgraca - visinaIgraca / 2;
		double dnoIgraca = yIgraca + visinaIgraca / 2;

		double leviKrajLoptice = this.x - poluprecnik;
		double desniKrajLoptice = this.x + poluprecnik;
		double dnoLoptice = this.y + poluprecnik;
		double vrhLoptice = this.y - poluprecnik;

		if (brojPerioda % 100 == 0) {
			this.pomerajX = 1.1 * this.pomerajX;
			this.pomerajY = 1.1 * this.pomerajY;
		}
		x += pomerajX;
		y += pomerajY;
		if (x - this.precnik / 2 <= 0 || x + this.precnik / 2 >= scena.getPreferredSize().getWidth())
			this.pomerajX = -pomerajX;
		if (y - this.precnik / 2 <= 0)
			this.pomerajY = -pomerajY;
		
		if(dnoLoptice>=vrhIgraca
				&& dnoLoptice<=dnoIgraca
				&& x>=leviKrajIgraca
				&& x<=desniKrajIgraca) {
				this.pomerajY = -pomerajY;
				y=y-poluprecnik-1;
				}
		else {
			if (x + poluprecnik >= xIgraca - sirinaIgraca / 2 && x - poluprecnik <= xIgraca + sirinaIgraca / 2) {

				if (y - poluprecnik / 2 < yIgraca + visinaIgraca / 2 && y + poluprecnik > yIgraca - visinaIgraca / 2) {
					if (Math.abs(x - (xIgraca - sirinaIgraca / 2)) < poluprecnik) {
						this.pomerajX = -pomerajX;
						this.x-=5;
						this.y+=5;
					} else if (Math.abs(x - (xIgraca + sirinaIgraca / 2)) < poluprecnik) {
						this.pomerajX = -pomerajX;
						this.x+=5;
						this.y+=5;
					}
							
						
						
					}
				}

			}
		

	Figura fig=null;
	for(int j = 0;(fig=scena.uzmiFiguru(j))!=null;j++)
	{
		if (fig.getOznaka() == 'C') {
			Cigla c = (Cigla) fig;
			if (!c.daLiJePogodjen() && c != null) {
				double xCigle = c.getX();
				double yCigle = c.getY();
				int visinaC = c.GetVisina();
				int sirinaC = c.GetSirina();

				if (x + poluprecnik >= xCigle - sirinaC / 2 && x - poluprecnik <= xCigle + sirinaC / 2) {

					if (y - poluprecnik / 2 < yCigle + visinaC / 2 && y + poluprecnik > yCigle - visinaC / 2) {
						if (Math.abs(x - (xCigle - sirinaC / 2)) < poluprecnik
								|| Math.abs(x - (xCigle + sirinaC / 2)) < poluprecnik) {
							this.pomerajX = -pomerajX;
							c.pogodiCiglu();
						}
					}
				}

				if (y + poluprecnik >= yCigle - visinaC / 2 && y - poluprecnik <= yCigle + visinaC / 2) {
					if (x - poluprecnik < xCigle + sirinaC / 2 && x + poluprecnik > xCigle - visinaC) {
						if (Math.abs(y - (yCigle - visinaC / 2)) < poluprecnik
								|| Math.abs(y - (yCigle + visinaC / 2)) < poluprecnik) {
							this.pomerajY = -pomerajY;
							c.pogodiCiglu();
						}

					}
				}

			}

		}
	}
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(this.color);
		g.fillOval((int) (this.x - this.precnik / 2), (int) (this.y - this.precnik / 2), precnik, precnik);

	}

}
