import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    private Connection con;
    public Conexao() throws Exception{
            // String url = "jdbc:sqlserver://LAB04PROF\\SQLEXPRESS:1433;encrypt=false;trustServerCertificate=true;"
            //             + "databaseName=bdTeste05042025;"
            //             + "user=sa;"
            //             + "password=dba;";
            // String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
            // String usuario="sa";//do banco
            // String senha="dba";
            // Class.forName(driver);
            // con = DriverManager.getConnection(url, usuario, senha);

            String url="jdbc:mysql://localhost:3306/bdTeste05042025?zeroDateTimeBehavior=CONVERT_TO_NULL";//endereço do servidor BD
            String driver="com.mysql.cj.jdbc.Driver"; //como conectar (JDBC)
            Class.forName(driver);
            con = DriverManager.getConnection(url, "root", "");
    }
    public Connection getConexao(){
        return con;
    }
    
}
