<<<<<<< HEAD
package com.dosecerta.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    
        //string    Conexao com o banco
        //mysql     Definicação do SGBD utilizado
        //localhost O endereço do Servidor onde o banco de dados está hospedado
        //3306      A porta tcp do banco de dados
        //vacinacao  Nome do banco de dados
        final String STR_CONNECTION = "jdbc:mysql://127.0.0.1:3306/vacinacao";
        
        //Usuario para conectar no banco de dados
        final String USER = "root";

        //Senha para conectar no banco de dados
        final String PASSWORD = "Mysql123#@$";

        //Variavel para armazenar a conexao estabelecida com o banco de dados
        Connection conn = null;

        //Comandos preparados para evitar SQL Injection
        PreparedStatement psInsert = null;
        PreparedStatement psSelect = null;
        PreparedStatement psUpdate = null;
        PreparedStatement psDelete = null;

        //Variavel para armazenar as respostas do banco de dados
        ResultSet rs = null;

        //Variavel para armazenar o id gerado no bando de dados
        int idGerado = 0;

        //Cria a conexão com o banco de dados e armazena em conn
        public Connection getConnection() throws SQLException {
        System.out.println("Conexão ao banco de dados realizada com sucesso!");
        return DriverManager.getConnection(STR_CONNECTION, USER, PASSWORD);
        }
        
    
}
=======
package com.dosecerta.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    
        //string    Conexao com o banco
        //mysql     Definicação do SGBD utilizado
        //localhost O endereço do Servidor onde o banco de dados está hospedado
        //3306      A porta tcp do banco de dados
        //vacinacao  Nome do banco de dados
        final String STR_CONNECTION = "jdbc:mysql://127.0.0.1:3306/vacinacao";
        
        //Usuario para conectar no banco de dados
        final String USER = "root";

        //Senha para conectar no banco de dados
        final String PASSWORD = "Mysql123#@$";

        //Variavel para armazenar a conexao estabelecida com o banco de dados
        Connection conn = null;

        //Comandos preparados para evitar SQL Injection
        PreparedStatement psInsert = null;
        PreparedStatement psSelect = null;
        PreparedStatement psUpdate = null;
        PreparedStatement psDelete = null;

        //Variavel para armazenar as respostas do banco de dados
        ResultSet rs = null;

        //Variavel para armazenar o id gerado no bando de dados
        int idGerado = 0;

        //Cria a conexão com o banco de dados e armazena em conn
        public Connection getConnection() throws SQLException {
        System.out.println("Conexão ao banco de dados realizada com sucesso!");
        return DriverManager.getConnection(STR_CONNECTION, USER, PASSWORD);
        }
        
    
}
>>>>>>> develop
