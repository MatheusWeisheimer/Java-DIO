import java.util.Scanner;

public class ContaTerminal {
    private int numero;
    private String agencia;
    private String nome;
    private double saldo;

    public void initConta() {
        Scanner scanner = new Scanner(System.in);

        setNumero(scanner);
        setAgencia(scanner);
        setNome(scanner);
        setSaldo(scanner);

        imprimeMensagem();

        scanner.close();
    }

    public void setNumero(Scanner scanner) {
        String input;
        boolean matches = false;

        do {
            System.out.print("Insira o número da conta (formato: 1234): ");
            input = scanner.nextLine();

            if (input.matches("^\\d{4}")) {
                matches = true;
            } else {
                imprimeErro();
            }

        } while (!matches);

        agencia = input;
    }

    public void setAgencia(Scanner scanner) {
        String input;
        boolean matches = false;

        do {
            System.out.print("Insira a agência (formato: 123-4): ");
            input = scanner.nextLine();

            if (input.matches("^\\d{3}-\\d$")) {
                matches = true;
            } else {
                imprimeErro();
            }

        } while (!matches);

        agencia = input;
    }

    public void setNome(Scanner scanner) {
        String input;
        boolean matches = false;

        do {
            System.out.print("Insira seu nome (apenas letras, sem acentos): ");
            input = scanner.nextLine();

            if (input.matches("[a-zA-Z ]+")) {
                matches = true;
            } else {
                imprimeErro();
            }

        } while (!matches);

        nome = input.toUpperCase();
    }

    public void setSaldo(Scanner scanner) {
        System.out.print("Insira o saldo: ");                 

        while (!scanner.hasNextDouble()) {
            imprimeErro();
            scanner.next();
        }

        saldo = scanner.nextDouble();
        scanner.nextLine();
    }

    public int getNumero() {
        return numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNome() {
        return nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void imprimeMensagem() {
        System.out.println("Olá " + nome + ", obrigado por criar uma conta em nosso banco, sua agência é " + agencia + ", conta " + numero + " e seu saldo " + saldo + " já está disponível para saque");
    }

    public void imprimeErro() {
        System.out.println("Valor inválido inserido! Tente novamente.");
    }

    public static void main(String[] args) throws Exception {
        ContaTerminal conta = new ContaTerminal();
        conta.initConta();
    }
}
