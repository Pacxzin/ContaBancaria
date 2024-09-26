public class ContaBancaria {
    private double saldo;
    private int contadorConsultas;

    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
        this.contadorConsultas = 0;
    }

    public void deposito(double valor) {
        double taxa = valor * 0.01; // 1% de taxa
        saldo += valor - taxa;
    }

    public boolean saque(double valor) {
        double taxa = valor * 0.005; // 0.5% de taxa
        if (saldo >= valor + taxa) {
            saldo -= valor + taxa;
            return true;
        } else {
            return false; // Saldo insuficiente
        }
    }

    public double consultaSaldo() {
        contadorConsultas++;
        if (contadorConsultas % 5 == 0) {
            saldo -= 0.10; // Taxa de 0.10 a cada 5 consultas
        }
        return saldo;
    }

    // Métodos getters
    public double getSaldo() {
        return saldo;
    }

    public int getContadorConsultas() {
        return contadorConsultas;
    }
}

public class Main {         // main
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria(1000.00); // Criar conta com saldo inicial

        // Realizar depósitos
        conta.deposito(500.00);
        System.out.println("Saldo após depósito: " + conta.getSaldo());

        // Realizar saques
        if (conta.saque(200.00)) {
            System.out.println("Saque realizado com sucesso. Saldo atual: " + conta.getSaldo());
        } else {
            System.out.println("Saque não realizado. Saldo insuficiente.");
        }

        // Consultar saldo
        for (int i = 0; i < 6; i++) {
            System.out.println("Consulta " + (i + 1) + ": Saldo atual: " + conta.consultaSaldo());
        }
    }
}
