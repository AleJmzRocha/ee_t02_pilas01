package AgrupadoresBalanceados;
//public class Pila<T extends Comparable<T>>{
public class Pila{
	Character[] pila;
	Integer tope;
	Integer tam;
	
	public Pila(Integer tamanio){
		tope = -1;
		pila = new Character[tamanio];
		tam = tamanio;
	}
	
	public void push(Character dato){
		if(tope < tam-1){
			tope++;
			pila[tope] = dato;
		}else
			System.out.println("Desbordamiento");
	}
	
	public Character pop(){
		Character resultado = ' ';
		if(tope > -1){
			resultado = pila[tope];
			tope--;
		}
		return resultado;
	}
	
	public Character peek(){
		Character res = ' ';
		if(tope > -1)
			res = pila[tope];
		else
			System.out.println("Subdesbordamiento");
		return res;
	}
	
//	public static void main(String[] args){
//		Pila pila = new Pila(5);
//		pila.push("A");
//		pila.push("l");
//		pila.push("e");
//		pila.push("x");
//		pila.push("D");
//		pila.push("D");
//		System.out.println(pila.peek());
//		System.out.println(pila.pop());
//		pila.pop();
//		pila.pop();
//		System.out.println(pila.peek());
//	}
}