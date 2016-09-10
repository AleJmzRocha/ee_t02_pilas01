package AgrupadoresBalanceados;
import java.io.*;
/**"Agrupadores balanceados"

Un agrupador es considerado cualquierquiera de los siguientes carácteres: (,),{,},[, ó ].


Dos balanceadores son considerados pares si el agrupador que abre -- (, [, { -- está a la izquierda de un agrupador que cierra }, ], ) del mismo tipo. 

Hay tres tipos de pares de agrupadores: [], {} y ().

Un par de agrupadores no está balanceado si en el conjunto de éstos no hay pares que concuerden.
 Por ejemplo, {[(])} no está balanceado porque el contenido entre { y } no está balanceado. El par de agrupadores [] encierra un solo agrupador no balanceado:
 (. Y el par de paréntesis encierra un solo agrupador no balanceado: ].

Con ésta lógica, decimos que una secuencia de agrupadores está balanceada si las siguientes
 condiciones se cumplen:

- No contiene agrupadores sin par.
- El subconjunto de agrupadores encerrado dentro del confin de un par de agrupadores,
 es también un par de agrupadores.

Dadas cadenas de agrupadores, determinar si cada secuencia de ellos está balanceada.
 Si una cadena de agrupadores está balanceada, imprimir SI en una nueva línea, de lo contrario, imprimir NO en una nueva línea.

Entrada de datos:
La primer línea contiene un solo entero, denotando el número de strings.
Cada línea subsecuente, consiste en una sola cadena,
 denotando una secuencia de agrupadores.

Restricciones:

1<=n<=10^3
1<=len(secuencia)<=10^3, donde len(secuencia) es la longitud de la secuendia.

Cada carácter en la secuencia será un agrupador (i.e., {, }, (, ), [, and ]).


Formato de salida:

Para cada string, imprimir si la secuencia de agrupadores está balanceada en una nueva línea.
 Si la secuencia de agrupadores está balanaceada, imprimir SI, de lo contrario imprimir NO.



Ejemplo:
========

Entrada de datos:

3
{[()]}
{[(])}
{{[[(())]]}}

Salida de datos:

SI
NO
SI


Explicación

La cadena {[()]} está balanceada, por lo tanto imprimimos SI.

La cadena {[(])} no está balanceada, porque los agrupadores [(] y (]) no están balanceados.
La cadena {{[[(())]]}} está balanceada, por lo tanto imprimimos SI.
**/

public class Agrupadores {
	private Boolean band = false; //Bandera que controla si tiene par o no, inicia con falso porque no hay elementos
	
	//Método que tendrá los agrupadores como parámetro y la pila en donde se almacenará
	public void verificar(String exp, Pila p){ 
		//Se recorre la longitud de la cadena
		for(int i = 0; i < exp.length(); i++){
			//Se valida si el agrupador en la posición dada abres
			if(exp.charAt(i) == '('){
				//Si se cumple, ese agrupador se mete a la pila
				p.push(exp.charAt(i));
			}else{//si no se cumple se pregunta si es un agrupador que cierra
				if(exp.charAt(i) == ')'){
					//Si lo es se verifica que la pila tenga algún elemento
					if(p.tope == -1){
						//si no tiene elementos, la bandera se pone en falso, quiere decir que hay subdesbordamiento
						band = false;
					}
					else{
					//si no, se pregunta que si lo que se saca de la pila es igual al agrupador del mismo tipo pero que abre
						if(p.pop() == '('){
							//si es verdadero, quiere decir que es su par
							band = true;
						}else//si no, no es par
							band = false;
					}
				}
			}
			
//De igual manera se hace para el agrupador: {}
			if(exp.charAt(i) == '{'){
				p.push(exp.charAt(i));
			}else{
				if(exp.charAt(i) == '}'){
					if(p.tope == -1){
						band = false;
					}
					else{
						if(p.pop() == '{'){
							band = true;
						}else{
							band = false;
						}
					}
				}
			}

//Y también de igual manera se hace para el agrupador: []
			if(exp.charAt(i) == '['){
				p.push(exp.charAt(i));
			}else{
				if(exp.charAt(i) == ']'){
					if(p.tope == -1){
						band = false;
					}
					else{
						if(p.pop() == '['){
							band = true;
						}else{
							band = false;
						}
					}
				}
			}
		}

//Finalmente se evalua la bandera porque ya se guardaron todos los cambios
		if(band)
			//si es verdadera, quiere decir que todos tienen sus pares
			System.out.println("SI");
		else
			//De lo contrario, no está balanceado 
			System.out.println("NO");
	}

	public static void main(String[] args) throws IOException{
		Pila p = new Pila(1000);
		Agrupadores a = new Agrupadores();
		a.verificar("{[()]}", p);
		a.verificar("{[(])}", p);
		a.verificar("{{[[(())]]}}", p);
	}
}
