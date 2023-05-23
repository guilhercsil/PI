/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicos;

import dao.DAOFactory;
import dao.UsuarioDAO;
import java.util.ArrayList;
import model.Usuario;

/**
 *
 * @author 182120069
 */
public class UsuarioServicos {
    public void cadastrarUsuario(Usuario uVO){
        UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();
        uDAO.cadastrarUsuarioDAO(uVO);
    }    
    
    public ArrayList<Usuario> getUsuarios(){
        UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();
        return uDAO.getUsuario();
       
    }
    public Usuario getUsuarioByDoc(String cpf){
        UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();
        return uDAO.getUsuarioByDoc(cpf);
        
    }
    
    public void atualizarUsuario(Usuario uVO){
        UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();
        uDAO.atualizarUsuarioDAO(uVO);
    }
    
    public void deletarUsuario(String cpf){
        UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();
        uDAO.deletarUsuarioDAO(cpf);
    }
}
