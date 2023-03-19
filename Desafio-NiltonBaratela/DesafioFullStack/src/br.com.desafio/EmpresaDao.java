import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

public class EmpresaDao {

    /*
     * CRUD
     * c: CREATE
     * r: READ
     * u: UPDATE
     * d: DELETE
     */

    public void save(Empresa empresa) {

        // String que irei inserir os valores no banco
        String insert = "INSERT INTO empresa(nomeFantasia, cnpj, cep) VALUES (?, ?, ?)";

        // nulo pois a conexão ainda não foi realizada
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            // criar uma conexão com o banco de dados
            conn = connection.conexao();
            // criei um PreparableStatement para executar a query
            pstm = conn.prepareStatement(insert);

            // adicionando os valores ao insert
            ((PreparedStatement) pstm).setString(1, empresa.getNomeFantasia());
            ((PreparedStatement) pstm).setString(2, empresa.getCnpj());
            ((PreparedStatement) pstm).setString(3, empresa.getCep());

            // executar insert
            pstm.execute();
            System.out.println("Empresa cadastrada com sucesso!");
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

    public void update(Empresa empresa) {

        // String que irei fazer o update dos valores no banco
        String update = "UPDATE empresa SET nomeFantasia = ?, cep = ? WHERE cnpj = ?";

        // nulo pois a conexão ainda não foi realizada
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            // criar uma conexão com o banco de dados
            conn = connection.conexao();
            // criei um PreparableStatement para executar a query
            pstm = conn.prepareStatement(update);

            // adicionar os valores para atualizar
            ((PreparedStatement) pstm).setString(1, empresa.getNomeFantasia());
            ((PreparedStatement) pstm).setString(2, empresa.getCep());
            // Chave Primaria
            ((PreparedStatement) pstm).setString(3, empresa.getCnpj());

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

    public void delete(String cnpj) {

        // String que irei fazer o delete dos valores no banco
        String del = "DELETE FROM empresa WHERE cnpj = ?";

        // nulo pois a conexão ainda não foi realizada
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            // criar uma conexão com o banco de dados
            conn = connection.conexao();
            // criei um PreparableStatement para executar a query
            pstm = conn.prepareStatement(del);

            // selecionar a primary key para deletar
            ((PreparedStatement) pstm).setString(1, cnpj);

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

    public List<Empresa> getEmpresas() {

        // select para trazer a lista de empresas cadastradas
        String select = "SELECT * FROM empresa WHERE 1";

        // declarando lista para trazer os dados das empresas
        List<Empresa> empresas = new ArrayList<Empresa>();

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

                // declarar o nova empresa
                Empresa empresa = new Empresa();

                // recuperar o CNPJ
                empresa.setCnpj(((ResultSet) rset).getString("cnpj"));
                // recuperar o Nome
                empresa.setNomeFantasia(((ResultSet) rset).getString("nomeFantasia"));
                // recuperar o CEP
                empresa.setCep(((ResultSet) rset).getString("cep"));

                // adicionar empresa a lista
                empresas.add(empresa);
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
        return empresas;

    }
}
