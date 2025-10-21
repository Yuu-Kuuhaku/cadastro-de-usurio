import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
    private static final String URL = "jdbc:mysql://localhost:3306/cadastro_usuarios";
    private static final String USER = "user1"; // altere se necessário
    private static final String PASSWORD = "1234"; // altere se necessário

    public static Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // 🔑 garante que o driver será carregado
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver JDBC do MySQL não encontrado.", e);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados.", e);
        }
    }
}

