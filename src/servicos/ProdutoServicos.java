/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicos;

import dao.DAOFactory;
import dao.ProdutoDAO;
import java.util.ArrayList;
import model.Produto;

/**
 *
 * @author 182120069
 */
public class ProdutoServicos {
    public void cadastrarProduto(Produto pVO){
        ProdutoDAO pDAO = DAOFactory.getProdDAO();
        pDAO.cadastrarProduto(pVO);
    }    
    
    public ArrayList<Produto> getProduto(){
        ProdutoDAO pDAO = DAOFactory.getProdDAO();
        return pDAO.getProduto();
       
    }
    public Produto getProdutoByDoc(String nome){
        ProdutoDAO pDAO = DAOFactory.getProdDAO();
        return pDAO.getProdutoByDoc(nome);
        
    }
    
    public void atualizarProduto(Produto pVO){
        ProdutoDAO pDAO = DAOFactory.getProdDAO();
        pDAO.atualizarProdutoDAO(pVO);
    }
    
    public void deletarCarro(String nome){
        ProdutoDAO pDAO = DAOFactory.getProdDAO();
        pDAO.deletarProdutoDAO(nome);
    }
}
