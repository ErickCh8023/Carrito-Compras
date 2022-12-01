package config;

public class GenerarSerie {
	int dato;
	String num;
	
	public String NumeroSerie(int dato) {
		this.dato=dato+1;
		if((this.dato>=10000000)&&(this.dato<=100000000)) {
			num=""+this.dato;
		}
		if((this.dato>=1000000)&&(this.dato<=10000000)) {
			num="0"+this.dato;
		}
		if((this.dato>=100000)&&(this.dato<=1000000)) {
			num="00"+this.dato;
		}
		if((this.dato>=10000)&&(this.dato<=100000)) {
			num="000"+this.dato;
		}
		if((this.dato>=1000)&&(this.dato<=10000)) {
			num="0000"+this.dato;
		}
		if((this.dato>=100)&&(this.dato<=1000)) {
			num="00000"+this.dato;
		}
		if((this.dato>=10)&&(this.dato<=100)) {
			num="000000"+this.dato;
		}
		if(this.dato<10) {
			num="0000000"+this.dato;
		}
		
		return num;
	}

}
