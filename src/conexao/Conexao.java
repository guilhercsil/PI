/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 182120069
 */
public class Conexao {

    private static String host = "jdbc:mysql://db4free.net:3306/carrosguilherme";
    private static String user = "senacguilherme";
    private static String pass = "senacrs2023";

    public static Connection getConexao() throws SQLException {
        Connection c = null;
        try {
            c = DriverManager.getConnection(host, user, pass);
        } catch (SQLException e) {
            throw new SQLException("Erro ao conectar!\n" + e.getMessage());
        }
        return c;
    }

}
