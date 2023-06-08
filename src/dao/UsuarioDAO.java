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
import model.Usuario;
import servicos.ServicosFactory;

/**
 *
 * @author 182120069
 */
public class UsuarioDAO {
    public void cadastrarUsuarioDAO(Usuario uVO) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "insert into usuario values (null,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, uVO.getNomeUsuario());
            pst.setString(2, uVO.getCpf());
            pst.setString(4, uVO.getEndereco());
            pst.setString(3, uVO.getTelefone());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar Usuario.\n" + e.getMessage());
        }
    }

    public ArrayList<Usuario> getUsuario() {
        ArrayList<Usuario> usuario = new ArrayList<>();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from usuario";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Usuario u = new Usuario();
                //lado do java |x| lado do banco
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setNomeUsuario(rs.getString("nome"));
                u.setCpf(rs.getString("cpf"));
                u.setEndereco(rs.getString("endereco"));
                u.setTelefone(rs.getString("telefone"));
                usuario.add(u);
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao listar usuario.\n" + e.getMessage());
        }
        return usuario;
    }
    public Usuario getUsuarioByDoc(String cpf){
        Usuario u = new Usuario();
        
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from usuario where cpf = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cpf);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
               
                //lado do java |x| lado do banco
                u.setIdUsuario(rs.getInt("idPessoa"));
                u.setNomeUsuario(rs.getString("nome"));
                u.setCpf(rs.getString("cpf"));
                u.setEndereco(rs.getString("endereco"));
                u.setTelefone(rs.getString("telefone"));
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao buscar CPF.\n" + e.getMessage());
        }
        
        return u;
    }
    public void atualizarUsuarioDAO(Usuario uVO){
        try {
            Connection con = Conexao.getConexao();
            String sql = "update pessoas set nome = ?, endereco = ?, telefone = ?"+ "where cpf = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,uVO.getNomeUsuario());
            pst.setString(2,uVO.getEndereco());
            pst.setString(3,uVO.getTelefone());
            pst.setString(4,uVO.getCpf());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Usuario.\n"+e.getMessage());
        }
    }
    public void deletarUsuarioDAO(String cpf){
        try {
            Connection con = Conexao.getConexao();
            String sql = "delete from usuario where cpf = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,cpf);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar Usuario.\n"+ e.getMessage());
        }
    }
}
