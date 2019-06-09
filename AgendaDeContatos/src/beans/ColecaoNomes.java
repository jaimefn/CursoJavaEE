package beans;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class ColecaoNomes implements Serializable {
	private static final long serialVersionUID = 1L;

	private Collection nomes = new ArrayList();
	
	public ColecaoNomes() {
		nomes.add("maria");
		nomes.add("jose");
		nomes.add("joao");
	}
	
	public Collection getNomes() {
				return nomes;
	}
	
}
