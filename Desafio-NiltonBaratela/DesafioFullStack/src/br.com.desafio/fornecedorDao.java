import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mysql.cj.protocol.Resultset;

public class fornecedorDao {
    /*
     * CRUD
     * c: CREATE
     * r: READ
     * u: UPDATE
     * d: DELETE
     */

    public void save(Fornecedor fornecedor) {

        // String que irei inserir os valores no banco
        String insert = "INSERT INTO fornecedor(cpf, nome, email, cep, rg, dataNasc ) VALUES (?, ?, ?, ?, ?, ?)";

        // nulo pois a conexão ainda não foi realizada
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            // criar uma conexão com o banco de dados
            conn = connection.conexao();
            // criei um PreparableStatement para executar a query
            pstm = conn.prepareStatement(insert);

            // adicionando os valores ao insert
            ((PreparedStatement) pstm).setString(1, fornecedor.getCpf());
            ((PreparedStatement) pstm).setString(2, fornecedor.getNome());
            ((PreparedStatement) pstm).setString(3, fornecedor.getEmail());
            ((PreparedStatement) pstm).setString(4, fornecedor.getCep());
            ((PreparedStatement) pstm).setString(5, fornecedor.getRg());
            ((PreparedStatement) pstm).setDate(6, new Date(fornecedor.getDataNasc().getTime()));

            // executar insert
            pstm.execute();
            System.out.println("Fornecedor cadastrado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            // fechando conexao
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public void update(Fornecedor fornecedor) {

        // String que irei fazer o update dos valores no banco
        String update = "UPDATE fornecedor SET nome = ?, email = ?, cep = ?, rg = ?, dataNasc = ? WHERE cpf = ?";

        // nulo pois a conexão ainda não foi realizada
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            // criar uma conexão com o banco de dados
            conn = connection.conexao();
            // criei um PreparableStatement para executar a query
            pstm = conn.prepareStatement(update);

            // adicionar os valores para atualizar
            ((PreparedStatement) pstm).setString(1, fornecedor.getNome());
            ((PreparedStatement) pstm).setString(2, fornecedor.getEmail());
            ((PreparedStatement) pstm).setString(3, fornecedor.getCep());
            ((PreparedStatement) pstm).setString(4, fornecedor.getRg());
            ((PreparedStatement) pstm).setDate(5, (Date) fornecedor.getDataNasc());
            // Chave Primaria
            ((PreparedStatement) pstm).setString(6, fornecedor.getCpf());

            // executar o update
            pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            // fechando conexao
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void delete(String cpf) {

        // String que irei fazer o delete dos valores no banco
        String del = "DELETE FROM fornecedor WHERE cpf = ?";

        // nulo pois a conexão ainda não foi realizada
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            // criar uma conexão com o banco de dados
            conn = connection.conexao();
            // criei um PreparableStatement para executar a query
            pstm = conn.prepareStatement(del);

            // selecionar a primary key para deletar
            ((PreparedStatement) pstm).setString(1, cpf);

            // executar o update
            pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            // fechando conexao
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public List<Fornecedor> getFornecedores() {

        // select para trazer a lista de fornecedor cadastrados
        String select = "SELECT * FROM fornecedor";

        // declarando lista para trazer os dados dos fornecedores
        List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();

        // nulo pois a conexão ainda não foi realizada
        Connection conn = null;
        PreparedStatement pstm = null;

        // classe que recupera os dados do banco
        Resultset rset = null;

        try {
            // criar uma conexão com o banco de dados
            conn = connection.conexao();
            // criei um PreparableStatement para executar a query
            pstm = conn.prepareStatement(select);

            // trazendo informações
            rset = (Resultset) pstm.executeQuery();

            // vetor para executar enquanto houver dados
            while (((ResultSet) rset).next()) {

                // declarar o novo fornecedor
                Fornecedor fornecedor = new Fornecedor();

                // recuperar o CPF
                fornecedor.setCpf(((ResultSet) rset).getString("cpf"));
                // recuperar o Nome
                fornecedor.setNome(((ResultSet) rset).getString("nome"));
                // recuperar o EMAIL
                fornecedor.setEmail(((ResultSet) rset).getString("email"));
                // recuperar o CEP
                fornecedor.setCep(((ResultSet) rset).getString("cep"));
                // recuperar o RG
                fornecedor.setRg(((ResultSet) rset).getString("rg"));
                // recuperar o DataNascimento
                fornecedor.setDataNasc(((ResultSet) rset).getDate("dataNasc"));

                // adicionar fornecedor a lista
                fornecedores.add(fornecedor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // fechando conexoes
            try {
                // if (rset != null) {
                // rset.close();
                // }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return fornecedores;

    }
}
