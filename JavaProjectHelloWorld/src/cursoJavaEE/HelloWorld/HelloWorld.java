package cursoJavaEE.HelloWorld;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class HelloWorld {
	public static void main(String[] args) {
		
		
		  BufferedReader bfReader = new BufferedReader(new InputStreamReader(System.in));
		 
		
		try {
			System.out.println("vc digitou: " + bfReader.readLine().toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//String NomeAnimal = JOptionPane.showInputDialog("Qual o seu animal favorito?");
		//System.out.println("vc digitou: " + NomeAnimal.toString());
		
		
		
	}

}
