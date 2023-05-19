/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Usuario;

/**
 *
 * @author 182120069
 */
public class ContUsuario {
    ArrayList<Usuario> usuario = new ArrayList<>();
    int idUsuario = 1;
    
    /**
     * Autoincrement idPessoa
     * @return 
     */
    public int geraID(){
        return this.idUsuario++;
    }

    /**
     * Método addPessoa adiciona Pessoa no ArrayList pessoas
     *
     * @param p
     */
    public void addUsuario(Usuario u) {
        this.usuario.add(u);
    }

    /**
     * Método removePessoa remove Pessoa do ArrayList pessoas
     *
     * @param pes
     */
    public void removeUsuario(Usuario usu) {
        this.usuario.remove(usu);
    }

    public ArrayList<Usuario> getUsuario() {
        return this.usuario;
    }

    /**
     * Método getPessoaCPF retorna uma Pessoa caso encontre 
     * correspondência no CPF do ArrayList pessoas, caso contrário
     * retorna null.
     * @param CPF
     * @return 
     */
    public Usuario getUsuarioCPF(String CPF) {
        Usuario u = null;
        for (Usuario usu : usuario) {
            if (usu.getCpf().equals(CPF)) {
                u = usu;
                break;
            }
        }//fim foreach
        return u;
    }
    
    public void mockUsuario(){
        Usuario u1 = new Usuario();
        u1.setIdUsuario(geraID());
        u1.setCpf("30668518006");
        u1.setNomeUsuario("Juvenal das Candongas");
        u1.setTelefone("51999889988");
        u1.setEndereco("Rua das Margaridas");
        addUsuario(u1);
        Usuario u2 = new Usuario();
        u2.setIdUsuario(geraID());
        u2.setCpf("85606196077");
        u2.setNomeUsuario("Madalena Espirito Santo");
        u2.setTelefone("51988998899");
        u2.setEndereco("Rua sem saída");
        addUsuario(u2);
        
    }
    
}//fim classe controller
