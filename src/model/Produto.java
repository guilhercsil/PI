/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 182120069
 */
public class Produto {
    private int idProduto;
    private String nomeProd;
    private int preco;
    private String codBarra;
    public Produto() {
    }

    public Produto(int idProduto, String nomeProd, int preco, String codBarra) {
        this.idProduto = idProduto;
        this.nomeProd = nomeProd;
        this.preco = preco;
        this.codBarra = codBarra;
    }

    public String getCodBarra() {
        return codBarra;
    }

    public void setCodBarra(String codBarra) {
        this.codBarra = codBarra;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" + "idProduto=" + idProduto + ", nomeProd=" + nomeProd + ", preco=" + preco + ", codBarra=" + codBarra + '}';
    }

    
    
    
    
}
