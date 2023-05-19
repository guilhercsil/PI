/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author 182120069
 */
public class DAOFactory {
    private static UsuarioDAO uDAO = new UsuarioDAO();

    public static UsuarioDAO getUsuarioDAO() {
        return uDAO;
    }

    private static ProdutoDAO pDAO = new ProdutoDAO();

    public static ProdutoDAO getProdDAO() {
        return pDAO;
    }
}
