import java.sql.Connection;
import java.sql.DriverManager;

public class connection {

    // user para conectar ao banco
    private static final String usr = "root";
    // senha para conectar ao banco
    private static final String psw = "";
    // url para acesso ao banco local
    private static final String url = "jdbc:mysql://localhost:3306/desafio";

    public static Connection conexao() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(url, usr, psw);

        return connection;
    }

    public static void main(String[] args) throws Exception {
        Connection con = conexao();

        if (con != null) {
            System.out.println("Conexão estabelecida!");
            con.close();
        } else
            System.out.println("Falha na conexão.");
    }

}
