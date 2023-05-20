/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pi;

import controller.ContProd;
import controller.ContUsuario;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.Produto;
import model.Usuario;
import servicos.ProdutoServicos;
import servicos.ServicosFactory;
import servicos.UsuarioServicos;
import util.Validadores;
import view.JFPrincipal;

/**
 *
 * @author 182120069
 */
public class PI {

    public static ContUsuario cadUsuario = new ContUsuario();
    public static ContProd cadProd = new ContProd();
    static Scanner leia = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFPrincipal janela = new JFPrincipal();
        janela.setVisible(true);
    }

    public static int leiaNumInt() {
        Scanner leiaNum = new Scanner(System.in);
        try {
            return leiaNum.nextInt();
        } catch (InputMismatchException i) {
            System.out.println("Erro: " + i.getMessage() + "\nTente novamente!");
            leiaNumInt();
        }
        return 99;
    }

    public static void menuP() {
        System.out.println("-- Menu Principal --");
        System.out.println("1 - Ger. Usuario");
        System.out.println("2 - Ger. Produto");
        System.out.println("0 - Sair");
        System.out.print("Digite aqui: ");
    }//fim menuP

    public static void subMenu(int opM) {
        String subM = null;
        if (opM == 1) {
            subM = "Usuario";
        }
        if (opM == 2) {
            subM = "Produto";
        }
        System.out.println("-- Ger. " + subM + " --");
        System.out.println("1 - Cadastrar " + subM);
        System.out.println("2 - Editar " + subM);
        System.out.println("3 - Listar " + subM + "s");
        System.out.println("4 - Deletar " + subM);
        System.out.println("0 - Voltar");
        System.out.print("Digite aqui: ");
    }// fim subMenu

    private static void cadastrarUsuario() {
        System.out.println("-- Cadastro de Usuario --");
        UsuarioServicos usuarioS = ServicosFactory.getUsuarioServicos();
        int idUsuario;
        String nome;
        String cpf;
        String endereco;
        String telefone;
        boolean tcpf = true;

        do {
            System.out.print("Informe o CPF: ");
            cpf = leia.nextLine();
            tcpf = Validadores.isCPF(cpf);
            if (tcpf) {
                if (usuarioS.getUsuarioByDoc(cpf).getCpf() != null) {
                    System.out.println("CPF já cadastrado!");
                    System.out.println("1 - Tentar novamente");
                    System.out.println("2 - Cancelar cadastro");
                    System.out.print("Digite aqui: ");
                    int op = leiaNumInt();
                    if (op == 2) {
                        return;
                    }
                } else {
                    tcpf = false;
                }
            } else {
                System.out.println("CPF inválido!");
                System.out.println("1 - Tentar novamente");
                System.out.println("2 - Cancelar cadastro");
                System.out.print("Digite aqui: ");
                int op = leiaNumInt();
                if (op == 2) {
                    return;
                }
                tcpf = true;
            }
        } while (tcpf);
        System.out.print("Informe o nome: ");
        nome = leia.nextLine();
        System.out.print("Informe o endereço: ");
        endereco = leia.nextLine();
        System.out.print("Informe o telefone: ");
        telefone = leia.nextLine();
        idUsuario = cadUsuario.geraID();
        Usuario u = new Usuario(idUsuario, nome, cpf, endereco, telefone);
        usuarioS.cadastrarUsuario(u);
        System.out.println(u.getNomeUsuario() + " cadastrado com sucesso!");
    }

    private static void cadastrarProduto() {
        System.out.println("-- Cadastro de Produto --");
        int idProduto;
        String NomeProd;
        int preco = 0;
        boolean 
    }
}
