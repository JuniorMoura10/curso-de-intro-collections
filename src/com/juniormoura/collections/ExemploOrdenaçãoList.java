package com.juniormoura.collections;

/* Dada as seguintes informações sobre os gatos, crie uma lista
e ordene esta lista exibindo:
(nome - idade - cor)

Gato 1: nome: Jon, idade: 18, cor: preta
Gato 1: nome: Simba, idade: 6, cor: tigrado
Gato 1: nome: Jon, idade: 12, cor: amarelo
 */

import java.util.*;

public class ExemploOrdenaçãoList {
    public static void main(String[] args) {

        List<Gato> meusGatos = new ArrayList<>(){{
            add(new Gato("Jon", 18, "preto"));
            add(new Gato("Simba", 6, "tigrado"));
            add(new Gato("Jon", 12, "amarelo"));
        }};

        System.out.println("----\t Ordem de Inserção\t----");
        System.out.println(meusGatos);

        System.out.println("----\t Ordem Ateatória\t----");
        Collections.shuffle(meusGatos);
        System.out.println(meusGatos);

        System.out.println("----\t Ordem Natural\t----");
        Collections.sort(meusGatos);
        System.out.println(meusGatos);

        System.out.println("----\t Ordem Idade\t----");
        meusGatos.sort(new ComparatorIdade());
        System.out.println(meusGatos);

        System.out.println("----\t Ordem Cor\t----");
        meusGatos.sort(new ComparatorCor());
        System.out.println(meusGatos);

        System.out.println("----\t Ordem Nome/Cor/Idade\t----");
        meusGatos.sort(new ComparatorNomeCorIdade());
        System.out.println(meusGatos);


    }
}

class Gato implements Comparable<Gato>{

    private String nome;
    private Integer idade;
    private String cor;

    public Gato(String nome, Integer idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                '}';
    }

    @Override
    public int compareTo(Gato gato) {
        return this.getNome().compareToIgnoreCase(gato.getNome());
    }
}

class ComparatorIdade implements Comparator<Gato>{

    @Override
    public int compare(Gato g1, Gato g2) {
        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}

class ComparatorCor implements Comparator<Gato>{

    @Override
    public int compare(Gato g1, Gato g2) {
        return g1.getCor().compareToIgnoreCase(g2.getCor());
    }
}

class ComparatorNomeCorIdade implements Comparator<Gato>{

    @Override
    public int compare(Gato g1, Gato g2) {
        int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
        if(nome != 0) return nome;
        int cor = g1.getCor().compareToIgnoreCase(g2.getCor());
        if(cor != 0) return cor;
        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}
