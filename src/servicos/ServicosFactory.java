/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicos;

/**
 *
 * @author 182120069
 */
public class ServicosFactory {
    private static ProdutoServicos produtoS = new ProdutoServicos();
    
    public static ProdutoServicos getProdutoServicos(){
        return produtoS;
    }
    public static UsuarioServicos usuarioS = new UsuarioServicos ();
    
    public static UsuarioServicos getUsuarioServicos(){
        return usuarioS;
    }
}
