/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Produto;

/**
 *
 * @author 182120069
 */
public class ProdutoDAO {

    public void cadastrarProduto(Produto pVO) {
        try {
            //buscar conexao com BD
            Connection con = Conexao.getConexao();
            //criar script sql de insert
            String sql = "insert into produto values(null, ?,?)";
            //criar espaço para executar o script
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, pVO.getNomeProd());
            pst.setInt(2, pVO.getPreco());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar Produto.\n" + e.getMessage());
        }
    }//fim cadastroProduto

    public ArrayList<Produto> getProduto() {
        ArrayList<Produto> produto = new ArrayList<>();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from produto";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Produto p = new Produto();
                //lado do java |x| lado do banco
                p.setIdProduto(rs.getInt("idProduto"));
                p.setNomeProd(rs.getString("nome"));
                p.setPreco(rs.getInt("preco"));

                produto.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar pessoa.\n" + e.getMessage());
        }
        return produto;
    }
    public Produto getProdutoByDoc(String cpf){
        Produto p = new Produto();
        
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from produto where NomeProd = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cpf);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
               
                //lado do java |x| lado do banco
                p.setIdProduto(rs.getInt("idProduto"));
                p.setNomeProd(rs.getString("nome"));
                p.setPreco(rs.getInt("preco"));
               
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao buscar nome.\n" + e.getMessage());
        }
        
        return p;
    }
    public void atualizarProdutoDAO(Produto pVO){
        try {
            Connection con = Conexao.getConexao();
            String sql = "update produto set nome = ?, preco = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,pVO.getNomeProd());
            pst.setInt(2,pVO.getPreco());
            
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Produto.\n"+e.getMessage());
        }
    }
    public void deletarProdutoDAO(String nome){
        try {
            Connection con = Conexao.getConexao();
            String sql = "delete from produto where nome = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,nome);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar Produto.\n"+ e.getMessage());
        }
    }

    public Object getProdutoByDoc(int preco) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}