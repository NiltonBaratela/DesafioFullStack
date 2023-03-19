import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        // classe para processar os dados
        EmpresaDao empresaDao = new EmpresaDao();
        fornecedorDao fornecedorDao = new fornecedorDao();
        Scanner s = new Scanner(System.in);

        int menu = 0;
        System.out.println("##################################");
        System.out.println("Bem vindo ao Sistema");
        System.out.println("##################################");

        while (menu != 9) {
            System.out.println("Escolha uma das opções do Menu:");
            System.out.println("1 - Cadastrar Empresa");
            System.out.println("2 - Consultar Empresas");
            System.out.println("3 - Atualizar Empresa");
            System.out.println("4 - Excluir Empresa");
            System.out.println("5 - Cadastrar Fornecedor");
            System.out.println("6 - Consultar Fornecedor");
            System.out.println("7 - Atualizar Fornecedor");
            System.out.println("8 - Excluir Fornecedor");
            System.out.println("9 - Sair");

            switch (menu) {
                case 1:
                    // INSERIR nova empresa
                    Empresa empresa = new Empresa();
                    System.out.println("Digite o Nome da Empresa que deseja cadastrar: ");
                    String nome = s.nextLine();
                    empresa.setNomeFantasia(nome);
                    System.out.println("Digite o CNPJ da Empresa: ");
                    String cnpj = s.nextLine();
                    empresa.setCnpj(cnpj);
                    System.out.println("Digite o CEP da Empresa: ");
                    String cep = s.nextLine();
                    empresa.setCep(cep);

                    // enviando dados empresa para realizar a inserção
                    empresaDao.save(empresa);
                    break;
                case 2:
                    for (Empresa e : empresaDao.getEmpresas()) {
                        System.out.println("CNPJ: " + e.getCnpj());
                        System.out.println("Empresa: " + e.getNomeFantasia());
                        System.out.println("CEP: " + e.getCep() + "\n\n");
                    }
                    break;
                case 3:
                    System.out.println("Digite o CNPJ da empresa que deseja atualizar: ");
                    // ATUALIZAR empresa
                    Empresa e1 = new Empresa();
                    String cpj = s.nextLine();
                    e1.setCnpj(cpj);
                    System.out.println("Deseja alterar o nome: (sim/nao)");
                    String alt = s.nextLine();
                    if (alt == "sim" || alt == "Sim") {
                        System.out.println("Digite o novo nome:");
                        String nomeF = s.nextLine();
                        e1.setNomeFantasia(nomeF);
                    }
                    System.out.println("Deseja alterar o CEP: (sim/nao)");
                    String altC = s.nextLine();
                    if (altC == "sim" || altC == "Sim") {
                        System.out.println("Digite o novo CEP:");
                        String cep2 = s.nextLine();
                        e1.setCep(cep2);
                    }

                    // enviando dados empresa para realizar a atualização
                    empresaDao.update(e1);

                    break;
                case 4:
                    System.out.println("Digite o CNPJ da empresa que deseja excluir:");
                    String delCnpj = s.nextLine();
                    // DELETAR a empresa pelo CNPJ
                    empresaDao.delete(delCnpj);
                    break;
                case 5:
                    // INSERIR novo Fornecedor

                    Fornecedor fornecedor = new Fornecedor();
                    System.out.println("Digite o nome da Fornecedor que deseja cadastrar: ");
                    String nomeF = s.nextLine();
                    fornecedor.setNome(nomeF);
                    System.out.println("Digite o E=mail do Fornecedor: ");
                    String email = s.nextLine();
                    fornecedor.setEmail(email);
                    System.out.println("Digite o CPF do Fornecedor: ");
                    String cpf = s.nextLine();
                    fornecedor.setCpf(cpf);
                    System.out.println("Digite o CEP do Fornecedor: ");
                    String cepF = s.nextLine();
                    fornecedor.setCep(cepF);
                    System.out.println("Digite o RG do Fornecedor: ");
                    String rgF = s.nextLine();
                    fornecedor.setRg(rgF);
                    System.out.println("Digite a data de nascimento do Fornecedor: (dd/MM/yyyy) ");
                    String nasc = s.nextLine();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = formatter.parse(nasc);
                    fornecedor.setDataNasc(date);

                    // enviando dados empresa para realizar a inserção
                    fornecedorDao.save(fornecedor);
                    break;
                case 6:
                    for (Fornecedor f : fornecedorDao.getFornecedores()) {
                        System.out.println("Empresa: " + e.getNomeFantasia());
                    }
                    break;
                case 7:
                    System.out.println("Digite o CNPJ da empresa que deseja atualizar: ");
                    // ATUALIZAR empresa
                    Empresa e1 = new Empresa();
                    String cpj = s.nextLine();
                    e1.setCnpj(cpj);
                    System.out.println("Deseja alterar o nome: (sim/nao)");
                    String alt = s.nextLine();
                    if (alt == "sim" || alt == "Sim") {
                        System.out.println("Digite o novo nome:");
                        String nomeF = s.nextLine();
                        e1.setNomeFantasia(nomeF);
                    }
                    System.out.println("Deseja alterar o CEP: (sim/nao)");
                    String altC = s.nextLine();
                    if (altC == "sim" || altC == "Sim") {
                        System.out.println("Digite o novo CEP:");
                        String cep2 = s.nextLine();
                        e1.setCep(cep2);
                    }

                    // enviando dados empresa para realizar a atualização
                    empresaDao.update(e1);
                    break;
                case 8:
                    System.out.println("Digite o CNPJ da empresa que deseja excluir:");
                    String delCnpj = s.nextLine();
                    // DELETAR a empresa pelo CNPJ
                    empresaDao.delete(delCnpj);
                    break;
                default:
                    break;
            }
        }

        // ATUALIZAR empresa
        Empresa e1 = new Empresa();
        e1.setNomeFantasia("Binance");
        e1.setCep("87654321");
        e1.setCnpj("1234567890125");
        // enviando dados empresa para realizar a atualização
        // empresaDao.update(e1);

        // DELETAR a empresa pelo CNPJ
        // empresaDao.delete("1234567890123");

        // INSERIR novo fornecedor
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setCpf("12345678909");
        fornecedor.setNome("Nilton Baratela");
        fornecedor.setEmail("niltonbaratela@gmail.com");
        fornecedor.setCep("13069090");
        fornecedor.setRg("532509018");
        fornecedor.setDataNasc(new Date(2000 - 12 - 8));

        // enviando dados fornecedor para realizar a inserção
        // fornecedorDao.save(fornecedor);

        // DELETAR a fornecedor pelo CPF
        // fornecedorDao.delete("12345678909");
    }

}
