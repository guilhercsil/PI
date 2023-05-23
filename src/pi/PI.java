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
        String codBarra = null;
        boolean pProduto = true;
        ProdutoServicos produtoS = ServicosFactory.getProdutoServicos();
        do {
            System.out.println("Informe codigo de barras: ");
            codBarra = leia.nextLine();
            pProduto = Validadores.validarCodBarra(codBarra);
            if (pProduto) {
                if (produtoS.getProdutoByDoc(codBarra).getCodBarra() != null) {
                    System.out.println("Produto já cadastrado!");
                    System.out.println("1 - Tentar novamente");
                    System.out.println("2 - Cancelar cadastro");
                    System.out.print("Digite aqui: ");
                    int op = leiaNumInt();
                    if (op == 2) {
                        return;
                    }
                } else {
                    pProduto = false;
                }
            } else {
                System.out.println("Produto inválido!");
                System.out.println("1 - Tentar novamente");
                System.out.println("2 - Cancelar cadastro");
                System.out.print("Digite aqui: ");
                int op = leiaNumInt();
                if (op == 2) {
                    return;
                }
                pProduto = true;
            }
        } while (pProduto);
        System.out.println("informe o nome do Prod: ");
        NomeProd = leia.nextLine();
        System.out.println("informe o preço do produto: ");
        preco = leiaNumInt();
        idProduto = cadProd.geraID;
        Produto p = new Produto(idProduto, NomeProd, preco, codBarra);
        System.out.println(p.getCodBarra() + " cadastrado com sucesso!");
    }

    private static void editarUsuario() {
        System.out.println("-- Editar Usuario --");
        UsuarioServicos usuarioS = ServicosFactory.getUsuarioServicos();
        boolean isCPF;
        do {
            System.out.print("Informe o CPF do Usuario a ser editado: ");
            String cpf = leia.nextLine();
            isCPF = Validadores.isCPF(cpf);
            if (isCPF) {
                Usuario u = usuarioS.getUsuarioByDoc(cpf);
                if (u.getCpf() != null) {
                    do {
                        System.out.println("Quais dados de " + u.getNomeUsuario() + " deseja alterar?");
                        System.out.println("1 - Nome");
                        System.out.println("2 - Endereço");
                        System.out.println("3 - Telefone");
                        System.out.println("4 - Todos");
                        System.out.println("0 - Voltar");
                        System.out.print("Digite aqui: ");
                        int op = leiaNumInt();
                        if (op == 1 || op == 4) {
                            System.out.print("Informe o novo nome: ");
                            u.setNomeUsuario(leia.nextLine());
                        }
                        if (op == 2 || op == 4) {
                            System.out.print("Informe o novo endereço: ");
                            u.setEndereco(leia.nextLine());
                        }
                        if (op == 3 || op == 4) {
                            System.out.print("Informe o novo telefone: ");
                            u.setTelefone(leia.nextLine());
                        }
                        if (op == 0) {
                            System.out.println("Operação cancelada pelo usuário!");
                            isCPF = false;
                        }
                        if (op < 0 || op > 4) {
                            System.out.println("Opção inválida, tente novamente!");
                        }
                        if (op > 0 && op < 4) {
                            usuarioS.atualizarUsuario(u);
                        }
                    } while (isCPF);
                } else {
                    System.out.println("CPF não cadastrado!");
                    isCPF = false;
                }
            } else {
                System.out.println("CPF inválido!");
                System.out.print("Deseja tentar novamente? \n 1 - Sim | 2 - Não: ");
                int op = leiaNumInt();
                if (op == 1) {
                    isCPF = true;
                } else {
                    isCPF = false;
                }
            }
        } while (isCPF);
    }

    private static void editarProduto() {
        System.out.println("-- Editar Produto --");
        ProdutoServicos produtoS = ServicosFactory.getProdutoServicos();
        boolean pProduto;
        do {
            System.out.print("Informe o codigo de barra: ");
            String codBarra = leia.nextLine();
            pProduto = Validadores.validarCodBarra(codBarra);
            if (pProduto) {
                Produto p = produtoS.getProdutoByDoc(codBarra);
                if (p.getCodBarra() != null) {
                    do {
                        System.out.println("Quais dados de " + p.getCodBarra() + " deseja alterar?");
                        System.out.println("1 - Nome");
                        System.out.println("2 - Preço");
                        System.out.println("3 - Todos");
                        System.out.println("0 - Voltar");
                        System.out.print("Digite aqui: ");
                        int op = leiaNumInt();
                        if (op == 1 || op == 3) {
                            System.out.print("Informe o novo nome: ");
                            p.setNomeProd(leia.nextLine());
                        }
                        if (op == 2 || op == 3) {
                            System.out.print("Informe o novo preço: ");
                            p.setPreco(leiaNumInt());
                        }
                        if (op == 0) {
                            System.out.println("Operação cancelada pelo usuário!");
                            pProduto = false;
                        }
                        if (op < 0 || op > 4) {
                            System.out.println("Opção inválida, tente novamente!");
                        }
                        if (op > 0 && op < 4) {
                            produtoS.atualizarProduto(p);
                        }
                    } while (pProduto);
                } else {
                    System.out.println("Cod. barras não cadastrado!");
                    pProduto = false;
                }
            } else {
                System.out.println("Cod. barras inválido!");
                System.out.print("Deseja tentar novamente? \n 1 - Sim | 2 - Não: ");
                int op = leiaNumInt();
                if (op == 1) {
                    pProduto = true;
                } else {
                    pProduto = false;
                }
            }
        } while (pProduto);
    }
    private static void listarUsuario() {
        System.out.println("-- Lista de Usuarios --");
        UsuarioServicos usuarioS = ServicosFactory.getUsuarioServicos();
        if (usuarioS.getUsuarios().isEmpty()) {
            System.out.println("Não tem usuarios cadastrados no sistema!");

        } else {
            for (Usuario usuario : usuarioS.getUsuarios()) {
                System.out.println(usuario.toString());
            }
        }
    }
    private static void listarProdutos() {
        System.out.println("-- Lista de Produtos --");
        ProdutoServicos produtoS = ServicosFactory.getProdutoServicos();
        if (produtoS.getProduto().isEmpty()) {
            System.out.println("Não tem produtos cadastrados no sistema!");

        } else {
            for (Produto produto : produtoS.getProduto()) {
                System.out.println(produto.toString());
            }
        }
    }
    private static void deletarUsuario() {
        UsuarioServicos usuarioS = ServicosFactory.getUsuarioServicos();
        System.out.println("-- Deletar usuario --");
        boolean delCPF = false;
        do {
            System.out.print("Informe o CPF do Usuario a ser deletado: ");
            String cpf = leia.nextLine();
            delCPF = Validadores.isCPF(cpf);
            if (delCPF) {
                Usuario u = usuarioS.getUsuarioByDoc(cpf);
                if (u.getCpf() != null) {
                    System.out.println("Deseja realmente deletar " + u.getNomeUsuario()+ "?");
                    System.out.print("1 - Sim | 2 - Não: ");
                    int op = leiaNumInt();
                    if (op == 1) {
                        usuarioS.deletarUsuario(cpf);
                        System.out.println("Usuario deletado com sucesso!");
                        delCPF = false;
                    } else {
                        System.out.println("Operação cancelada pelo usuário!");
                        delCPF = false;
                    }
                } else {
                    System.out.println("CPF não cadastrado!");
                    System.out.println("Deseja tentar novamente?");
                    System.out.print("1 - Sim | 2 - Não: ");
                    int op = leiaNumInt();
                    if (op == 1) {
                        delCPF = true;
                    } else {
                        delCPF = false;
                    }
                }
            } else {
                System.out.println("CPF inválido!"
                        + "\nTente novamente.");
                delCPF = true;
            }
        } while (delCPF);
    }//fim do deletarUsuario
    
    private static void deletarProduto() {
        ProdutoServicos produtoS = ServicosFactory.getProdutoServicos();
        System.out.println("-- Deletar Produto --");
        boolean delProd = false;
        do {
            System.out.print("Informe o Cod. barras do produto a ser deletado: ");
            String codBarra = leia.nextLine();
            delProd = Validadores.validarCodBarra(codBarra);
            if (delProd) {
                Produto p = produtoS.getProdutoByDoc(codBarra);
                if (p.getCodBarra()!= null) {
                    System.out.println("Deseja realmente deletar " + p.getCodBarra()+ "?");
                    System.out.print("1 - Sim | 2 - Não: ");
                    int op = leiaNumInt();
                    if (op == 1) {
                        produtoS.deletarProduto(codBarra);
                        System.out.println("Produto deletado com sucesso!");
                        delProd = false;
                    } else {
                        System.out.println("Operação cancelada pelo usuário!");
                        delProd = false;
                    }
                } else {
                    System.out.println("Produto não cadastrado!");
                    System.out.println("Deseja tentar novamente?");
                    System.out.print("1 - Sim | 2 - Não: ");
                    int op = leiaNumInt();
                    if (op == 1) {
                        delProd = true;
                    } else {
                        delProd = false;
                    }
                }
            } else {
                System.out.println("Cod.barra inválido!"
                        + "\nTente novamente.");
                delProd = true;
            }
        } while (delProd);
    }//fim do deletarPessoa
}
