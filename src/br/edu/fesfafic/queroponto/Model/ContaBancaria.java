package br.edu.fesfafic.queroponto.Model;

public class ContaBancaria {
    private String intituicaoFinanceira;
    private String titular;
    private String agencia;
    private String conta;
    private String cpf;
    private double valorNaConta;

    public ContaBancaria(String intituicaoFinanceira, String titular, String agencia, String conta, String cpf, double valorNaConta) {
        this.intituicaoFinanceira = intituicaoFinanceira;
        this.titular = titular;
        this.agencia = agencia;
        this.conta = conta;
        this.cpf = cpf;
        this.valorNaConta = valorNaConta;
        // coloquei cpf, agencia e conta como String para que o digito 0 fosse lido corretamente. Ex.: 089 != 89
    }
    public void depositarDinheiro(double dinheiro){
        setValorNaConta(getValorNaConta() + dinheiro);
    }
    public void retirarDinheiro(double dinheiro){
        depositarDinheiro(- dinheiro);
    }
    public void saldo(){
        System.out.println("Agência: " + this.agencia +
                "\nConta: " + this.conta +
                "\nTitular: " + this.titular +
                "\nCPF: " + this.cpf +
                "\nValor na conta: " + this.valorNaConta);
    }

    public String getIntituicaoFinanceira() {
        return intituicaoFinanceira;
    }

    public void setIntituicaoFinanceira(String intituicaoFinanceira) {
        this.intituicaoFinanceira = intituicaoFinanceira;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getValorNaConta() {
        return valorNaConta;
    }

    public void setValorNaConta(double valorNaConta) {
        this.valorNaConta = valorNaConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
