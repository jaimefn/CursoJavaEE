package equalsAndHashCode;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class CadastroProdutos {

	public static void main(String[] args) {
		ArrayList<Produto> Car = new ArrayList<Produto>();
		
		
		String continuar = "s";
		
		while(continuar.equalsIgnoreCase("s") ) {
			String sku = JOptionPane.showInputDialog("Entre com o sku:");
			String nome = JOptionPane.showInputDialog("Entre com o nome:");
			
			Produto produto = new Produto();
			
			produto.setNome(nome);
			produto.setSku(sku);

			if(!Car.contains(produto)) {
				Car.add(produto);
				System.out.println("produto cadastrado com sucesso: " + produto.toString());

			}else {
				System.out.println("Não foi possível cadastrar: " + produto.toString());
			}
			
			
			
			continuar = JOptionPane.showInputDialog("Cadastrar outro produto? s/n");
		}
		

		
		System.out.println("Cadastro Finalizado");

	}

}
