/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Produto;


/**
 *
 * @author 182120069
 */
public class ContProd {
    ArrayList<Produto> produtos = new ArrayList<>();
    int idProduto = 1;
    public int geraID;
    
    /**
     * Autoincrement idPessoa
     * @return 
     */
    public int geraID(){
        return this.idProduto++;
    }

    /**
     * Método addPessoa adiciona Pessoa no ArrayList pessoas
     *
     * @param p
     */
    

    public void addProduto(Produto p) {
        this.produtos.add(p);
    }

    public void removeProduto(Produto p) {
        this.produtos.remove(p);
    }

    public ArrayList<Produto> getProduto() {
        return this.produtos;
    }

    public Produto getProdNome(String NomeProd) {
        Produto p = null;
        for (Produto produto : produtos) {
            if (produto.getNomeProd().equals(NomeProd)) {
                p = produto;
                break;
            }
        }
        return p;
    }
    
    public void mockCarros(){
        Produto p1 = new Produto();
        p1.setIdProduto(geraID());
        p1.setNomeProd("1L suco naturale");
        p1.setPreco(10);
        addProduto(p1);
        Produto p2 = new Produto();
        p1.setIdProduto(geraID());
        p1.setNomeProd("500ml suco naturale");
        p1.setPreco(10);
        addProduto(p1);
        
        
        addProduto(p2);
    }

}//fim Classe CCarro

