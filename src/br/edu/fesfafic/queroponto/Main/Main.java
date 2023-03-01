package br.edu.fesfafic.queroponto.Main;
import br.edu.fesfafic.queroponto.Model.ContaBancaria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        List<ContaBancaria> contas = new ArrayList<>(){};
        ContaBancaria conta1 = new ContaBancaria("Bradesco", "Leontiev Ramalho Diniz Quirino",
                "12345","123456789", "123456789", 1000);
        ContaBancaria conta2 = new ContaBancaria("Itaú", "Josefino Giano Sousa",
                "54321","987654321", "987654321", 1000);
        contas.add(conta1);
        contas.add(conta2);
        while(true) {
            System.out.println("""
                    Seja Bem-Vindo. O que deseja fazer?
                    1 - Transferência
                    2 - Consultar Saldo
                    3 - Sair""");
            int resposta = scan.nextInt();
            if(resposta==1)
                transferencia(contas);
            else if(resposta==2)
                consultarSaldo(contas);
            else if(resposta==3) {
                System.out.print("Programa encerrado.");
                break;
            } else
                System.out.println("Opção inválida, tente novamente!");
        }
    }

    public static void consultarSaldo(List<ContaBancaria> contas){
        ContaBancaria conta = pesquisarConta(contas);
        conta.saldo();
    }
    public static void transferencia(List<ContaBancaria> contas){
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("-- Digite os dados da conta originária --");
            ContaBancaria originaria = pesquisarConta(contas);
            if(originaria == null){
                System.out.println("Não foi possível realizar a transferência. " +
                        "Não foi possível localizar nenhuma conta com esses dados.");
                continue;
            }
            System.out.println("-- Digite os dados da conta destinatária --");
            ContaBancaria destinataria = pesquisarConta(contas);
            if(destinataria == null){
                System.out.println("Não foi possível realizar a transferência. " +
                        "Não foi possível localizar nenhuma conta com esses dados.");
                continue;
            }
            if(destinataria.equals(originaria)){
                System.out.println("Não é possível realizar uma transferência de uma conta para si própria.");
                continue;
            }
            System.out.print("Qual o valor da transferência? R$ ");
            double valor = scan.nextDouble();
            // coloquei esse scan.nextLine() para resolver um problema em que o cursor
            // ficava depois do double digitado no scan.nextDouble() anterior e bugava a leitura do scan.nextLine().
            // Mais informações em:
            // https://acervolima.com/por-que-scanner-esta-pulando-nextline-apos-o-uso-de-outras-funcoes-next/
            scan.nextLine();
            originaria.retirarDinheiro(valor);
            destinataria.depositarDinheiro(valor);
            System.out.println("Transferência realizada com sucesso!");
            String resposta = "";
            while(!resposta.equals("S") && !resposta.equals("N")) {
                System.out.print("Deseja realizar uma nova transferência? [S/N] ");
                resposta = scan.nextLine();
                resposta = resposta.toUpperCase().trim().substring(0, 1);
            }
            if(resposta.equals("N"))
                break;
        }
    }
    public static ContaBancaria pesquisarConta(List<ContaBancaria> contas){
        Scanner scan = new Scanner(System.in);
        System.out.print("Agência: ");
        String agencia1 = scan.nextLine();
        System.out.print("Conta: ");
        String numConta1 = scan.nextLine();
        System.out.print("cpf: ");
        String cpf1 = scan.nextLine();
        ContaBancaria resultado = null;
        for(ContaBancaria conta : contas) {
            if (agencia1.equals(conta.getAgencia()) && numConta1.equals(conta.getConta())
                    && cpf1.equals(conta.getCpf()))
                resultado = conta;
        }
        return resultado;
    }
}
