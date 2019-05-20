package introducaoStream.classes;

import java.util.Arrays;
import java.util.List;

public class Pessoa {
	
	private String nome;
	private int idade;
	private double salario;	
	private Genero genero;
	
	public Pessoa(String nome, int idade, double salario) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.salario = salario;
	}
	
	public Pessoa(String nome, int idade, double salario, Genero genero) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.salario = salario;
		this.genero = genero;
	}

	public static List<Pessoa> bancoDePessoas() {
		 return Arrays.asList(
				new Pessoa("Vava", 89, 12000, Genero.MASCULINO),
				new Pessoa("Didi", 79, 23564, Genero.MASCULINO),
				new Pessoa("Romario", 53, 89876, Genero.MASCULINO),
				new Pessoa("Bebeo", 55, 78765, Genero.MASCULINO),
				new Pessoa("Careca", 60, 32412, Genero.MASCULINO),
				new Pessoa("Ronaldinho", 39, 234123, Genero.MASCULINO),
				new Pessoa("Bia", 23, 2341, Genero.FEMININO),
				new Pessoa("Julia", 17, 2356, Genero.FEMININO),
				new Pessoa("Francisca", 20, 1123, Genero.FEMININO),
				new Pessoa("Maria", 19, 1234, Genero.FEMININO),
				new Pessoa("Patricia", 18, 2412, Genero.FEMININO),
				new Pessoa("Gomes", 17, 1234, Genero.MASCULINO)
				);
	}
	
	
	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + "]";
	}

	public Pessoa() {}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public Genero getGenero() {
		return genero;
	}
	
	
	

}
