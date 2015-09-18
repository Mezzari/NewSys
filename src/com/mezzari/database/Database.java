/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mezzari.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Thiago
 */
public class Database {
    public Connection conn;
    public Statement statment = null;
    public PreparedStatement preparedStatement = null;
    public ResultSet resultSet = null;

    public Database() {
        
    }
    
    /**Realiza a conexão no banco de dados.*/
    public void connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance(); //carrega o driver do mysql
            String url = "jdbc:mysql://192.168.2.251:3306/newsys"; //acessa a tablea mysql
            String usuario = "Thiago";
            String senha = "root";
            conn = DriverManager.getConnection(url, usuario, senha); //conecta no banco de dados MySql
        }catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e){
            JOptionPane.showMessageDialog(null, "CONNECT - " + e.toString());
        }
    }
    
    public List<String> getNomesPessoas(){
        List<String> ret = new ArrayList<>();
        try {            
            preparedStatement = conn.prepareStatement("SELECT nome FROM pessoa");
            resultSet =  preparedStatement.executeQuery();
            while(resultSet.next()){
                ret.add(resultSet.getString(1));
            }
            return ret;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<String> getCpfPessoas(){
        List<String> ret = new ArrayList<>();
        try {            
            preparedStatement = conn.prepareStatement("SELECT cpf FROM pessoa");
            resultSet =  preparedStatement.executeQuery();
            while(resultSet.next()){
                ret.add(resultSet.getString(1));
            }
            return ret;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
            ex.printStackTrace();
        }
        return null;
    }
    
    public int getIdByNomePessoa(String nome){
        int ret = 0;
        try {            
            preparedStatement = conn.prepareStatement("SELECT id FROM pessoa WHERE nome =?");
            preparedStatement.setString(1, nome);
            resultSet =  preparedStatement.executeQuery();
            while(resultSet.next()){
                ret = resultSet.getInt(1);
            }
            return ret;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
            ex.printStackTrace();
        }
        return -1;
    }
    
    public int getIdByCpfPessoa(String cpf){
        int ret = 0;
        try {            
            preparedStatement = conn.prepareStatement("SELECT id FROM pessoa WHERE cpf =?");
            preparedStatement.setString(1, cpf);
            resultSet =  preparedStatement.executeQuery();
            while(resultSet.next()){
                ret = resultSet.getInt(1);
            }
            return ret;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
            ex.printStackTrace();
        }
        return -1;
    }
    
    public String getEmailByIdPessoa(int id){
        String ret = null;
        try {            
            preparedStatement = conn.prepareStatement("SELECT email FROM pessoa WHERE id =?");
            preparedStatement.setInt(1, id);
            resultSet =  preparedStatement.executeQuery();
            while(resultSet.next()){
                ret = resultSet.getString(1);
            }
            return ret;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
            ex.printStackTrace();
        }
        return null;
    }
    
    public String getTelefoneByIdPessoa(int id){
        String ret = null;
        try {            
            preparedStatement = conn.prepareStatement("SELECT fone FROM pessoa WHERE id =?");
            preparedStatement.setInt(1, id);
            resultSet =  preparedStatement.executeQuery();
            while(resultSet.next()){
                ret = resultSet.getString(1);
            }
            return ret;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
            ex.printStackTrace();
        }
        return null;
    }

    public String getCpfByIdPessoa(int id) {
        String ret = null;
        try {            
            preparedStatement = conn.prepareStatement("SELECT cpf FROM pessoa WHERE id =?");
            preparedStatement.setInt(1, id);
            resultSet =  preparedStatement.executeQuery();
            while(resultSet.next()){
                ret = resultSet.getString(1);
            }
            return ret;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
            ex.printStackTrace();
        }
        return null;
    }

    public String getNomeByIdPessoa(int id) {
        String ret = null;
        try {            
            preparedStatement = conn.prepareStatement("SELECT nome FROM pessoa WHERE id =?");
            preparedStatement.setInt(1, id);
            resultSet =  preparedStatement.executeQuery();
            while(resultSet.next()){
                ret = resultSet.getString(1);
            }
            return ret;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
            ex.printStackTrace();
        }
        return null;
    }
}
