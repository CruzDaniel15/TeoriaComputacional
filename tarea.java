/*
Autor:Daniel Gutierrez de la Cruz 
Matricula: 130212
Expresion Regular AFD  1(00*)* 
La logica que se implemento en el siguente programa fue pedir una cadena al usuario posteriormente esa cadena guardarla en un arreglo de caracteres y apoyandonos de las  funciones como estado del automata,utilizando una funcion por cada estado para comprobar cada uno caracter de los caracteres de la cadena y determina si es valida en el automata por medio de condicionales.
  si el caracter se encuentra en un estado valido continua la ejecutando con el siguiente caracter de la cadena si no regresa y imprime un mensaje que indica que la cadena no es valida para los caracteres no establecidos en el alfabeto del automata se declaro una funcion llamar la funcion qError() la cual directamente determina que la cadena no es valida porque incluye caracteres no establecidos en el alfabeto del automata.
En el automata existe dos estados valido donde si se acaba la verificasion en esas funciones la cadena es valida y manda un mensaje. 

*/
import java.util.Scanner; 

public class Automata {

	int cont;
	char[]car;
	boolean aceptado;
 
	public static void main(String[] args) {		
	while(true)
	{
        	Automata aut=new Automata();
        	String cadena="";
        	cadena=introducir();
        	aut.car= cadena.toCharArray();
        	 
        	
        	aut.inicio();
        	if(aut.aceptado)
        	{
        		System.out.println ("Cadena Valida");	
        	}
        	else
        	{
        		System.out.println ("Cadena no Valida");	
        	}
        }
        	   
		
	}
	
	public void inicio(){
	
	cont=0;
	aceptado=false;
	q0();
	}
	
	public void q0()
	{
	
		if(cont<=car.length)
		{
		
			if(car[cont]=='1')
			{
			cont++;
			
			q1();
			
			}
			else if(car[cont]=='0'){
			cont++;
			aceptado=false;
			}
			else
			{
			qerror();
			}
		} 
	
	}
	
	public void q1()
	{
		aceptado=true;
		if(cont<car.length)
		{
			if(car[cont]=='0')
			{
			cont++;
			q2();
			}
			else if(car[cont]=='1')
			{
			cont++;
			aceptado=false;
			} 
			else
			{
			qerror();
			}
		}
	
	}
	public void q2()
	{
		aceptado=true;
		if(cont<car.length)
		{
			if(car[cont]=='0')
			{
			cont++;
			q2();
			}
			else if(car[cont]=='1')
			{
			cont++;
			aceptado=false;
			} 
			
			else
			{
			qerror();
			}
		}
	
	}
	
	public void qerror()
	{
		System.out.println ("Valores no validos dentro del alfabeto");
		aceptado=false;
	}
	
	public static String introducir()
	{
		System.out.println ("introduzca una cadena: ");
        String entradaTeclado = "";
        Scanner entradaEscaner = new Scanner (System.in);
        entradaTeclado = entradaEscaner.nextLine (); 
        return entradaTeclado ;
        
	} 
 
}