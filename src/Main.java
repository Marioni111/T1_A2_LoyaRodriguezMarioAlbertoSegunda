import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

class TDACadenaEspecialConString{
	
	private String cadena;
	
	public TDACadenaEspecialConString() {

	}

	public TDACadenaEspecialConString(String cadena) {
		super();
		this.cadena = cadena;
	}

	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}
	
	//Operaciones
		public String invertirCadenaPorLetras() {
			int x = cadena.length();
			int y = 0;
			
			String invertida[] = new String[cadena.length()];
				
			while (x>0) {
					
				invertida[y] = cadena.substring(x-1, x);
				y++;
				x--;
				
			}
				String palabara = "";
				
			for (int i = 0; i < invertida.length; i++) {
				
				palabara = palabara+invertida[i];
			}
			
			return palabara;
		}
		
		public String invertirCadenaPorPalabra() {
			String inversa = "";
			String sub = "";
			String cadena = getCadena() + " ";
			int x = 0;
			int y = 0;
			
			for(int i = 0; i<cadena.length(); i++) {
				
				sub = cadena.substring(i, i+1);
				
				if(sub.equalsIgnoreCase(" ") || i+1 == cadena.length()) {
					y = i;
					inversa = getCadena().substring(x, y) + " " + inversa;
					x = y;
				}
			}
			
			return inversa;
		}
		public String agregarCaracteresEnPocicionEspecifica(String caracter,int posicion) {
			
			String palabraNueva = getCadena().substring(0, posicion) + caracter + getCadena().substring(posicion);
			
			return palabraNueva;
		}
		
		public String agregarCadenaEnPocicionEspecifica(String caracter,int posicion) {
			
			String palabraNueva = getCadena().substring(0, posicion) + caracter + getCadena().substring(posicion);
			
			return palabraNueva;
		}
		
		public void numerosControl() {
			
			int rn = 0;
			
			File archivo = null;
			FileWriter fichero = null;
	        PrintWriter pw = null;
	        FileReader fr = null;
	        BufferedReader br = null;
	        
	        try
	        {
	        	archivo = new File ("numeros de control.txt");
	        	fichero = new FileWriter(archivo);
	        	pw = new PrintWriter(fichero);
	        	fr = new FileReader (archivo);
	            br = new BufferedReader(fr);
	         
	            for(int i = 0; i<5000; i++) {
					pw.println((rn = (int) (Math.random() * 4999) + 1)+18070000);
				}
	            
	            String linea = "";
	            String sub = "";
	            while((linea=br.readLine())!=null){
	            	sub = linea.substring(4, 5);
	            	if(sub.equals("0")) {
	            		System.out.println("S" + linea);
	            	}else if(sub.equalsIgnoreCase("1")) {
	            		System.out.println("M" + linea);
	            	}else if(sub.equals("2")) {
	            		System.out.println("I" + linea);
	            	}else if(sub.equals("3")) {
	            		System.out.println("A" + linea);
	            	}else if(sub.equals("4")) {
	            		System.out.println("C" + linea);
	            	}
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           try {
	           if (null != fichero)
	              fichero.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
	        }
		}
}
public class Main {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in); 
		
		System.out.println("Ingresa una cadena");
		
		String cadena = entrada.nextLine();
		TDACadenaEspecialConString obj = new TDACadenaEspecialConString(cadena);
		int salir = 0;	
	
	do{
		System.out.println("1) invertir cadena");
		System.out.println("2) Invertir cadena por palabras");
		System.out.println("3) Agregar un caracter en una pocicion");
		System.out.println("4) Agregar un cadena en una pocicion");
		System.out.println("5) Numeros de control");
		System.out.println("6) Salir");
		
		byte op = entrada.nextByte();
		
		if(op == 1) {
			System.out.println(obj.invertirCadenaPorLetras());
		}
		else if (op==2) {
			System.out.println(obj.invertirCadenaPorPalabra());
		}
		else if (op==3) {
			boolean b = false;
			String car = "";
			while(b == false) {
				System.out.println("ingresa caracter");
				car=entrada.next();
				if(car.length() == 1) {
					b = true;
				}else {
					b = false;
				}
				
			}
			System.out.println("ingresa posicion");
			int pos = entrada.nextInt();
			
			System.out.println(obj.agregarCaracteresEnPocicionEspecifica(car, pos));
		}
		else if (op == 4) {
			System.out.println("ingresa cadena");
			String car;
			car=entrada.next();
			
			System.out.println("ingresa posicion");
			int pos;
			pos=entrada.nextInt();
			
			if (pos==0) {
				pos++;
			}
			System.out.println(obj.agregarCadenaEnPocicionEspecifica(car, pos));
		}
		else if (op == 5) {
			obj.numerosControl();
		}
		else if (op == 6) {
			salir = 1;
		}
	}while(salir!=1);
	
	System.out.println("Nos vemos!");
	
entrada.close();
	}
}