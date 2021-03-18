/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelConexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Aurelio Macie Junior
 */
public class ConexaoBD {
    public Statement stm;
    public ResultSet rs;
    private String driver = "com.mysql.jdbc.Driver";
    private String caminho = "jdbc:mysql://localhost:3306/projetomanengo_designdecor";
    private String usuario = "root";
    private String senha = "";
    public Connection con;
    
    public void conexao(){
        System.setProperty("jdbc.Drivers", driver);
        try {
            con=DriverManager.getConnection(caminho, usuario, senha);
            JOptionPane.showMessageDialog(null, "CONEXAO EFECTUADA COM SUCESSO!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO DE CONEXAO!\n"+ex.getMessage());
        }
    }

    public void executaSql(String sql){
        try{
        stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        rs = stm.executeQuery(sql);
        }catch(SQLException ex){
          JOptionPane.showMessageDialog(null, "Erro Ao Executar SQL!\n" +ex);  
        }
    }
    
    public void desconexao(){
        try {
            con.close();
            //JOptionPane.showMessageDialog(null, "DESCONEXAO EFECTUADA COM SUCESSO!");
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "ERRO DE DESCONEXAO!\n"+ex.getMessage());
        }
    }   
}
