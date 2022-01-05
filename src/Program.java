import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidade.Empregado;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.print("Quantas pessoas deseja registrar: ");
		int n = sc.nextInt();
		
		Empregado empregado;
		List <Empregado> list = new ArrayList<>();
		for (int i=0; i<n; i++) {
			System.out.println();
			System.out.println("Empregado #"+(i+1)+":");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			while (verifId(list, id)) {
				System.out.print("Digite novamente o Id: ");
				id = sc.nextInt();
			}
			
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Salario: ");
			double salario = sc.nextDouble();
			empregado = new Empregado(id, nome, salario);
			list.add(empregado);
		}
		System.out.println();
		System.out.println("Digite o Id a sere alterado o salario: ");
		int id = sc.nextInt();
		Integer posicao = posicao(list, id);
		if (posicao != null) {
			System.out.print("Digite o porcentagem a sere aumentado:");
			double porcentual = sc.nextDouble();
			list.get(posicao).aumSalario(porcentual);
		} else {
			System.out.print("Funcionario não encontrado!");
		}
		System.out.println();
		System.out.println("Lista de Empregados");
		for (Empregado x : list) {
			System.out.println(x);
		}
		
		sc.close();

	}

	public static Integer posicao (List<Empregado>list, int id) {
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		} return null;
	}
	
	public static boolean verifId(List<Empregado> list, int id) {
		Empregado empregado = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return empregado != null;
	}
}