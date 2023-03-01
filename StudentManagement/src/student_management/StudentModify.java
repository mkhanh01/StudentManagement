/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_management;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class StudentModify {
    public static List<Student> findAll() { //lay tat ca ds sv
        List<Student> studentList = new ArrayList<>();
        
        Connection connection = null ;
        Statement statement = null ;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");
            
            String sql = "select * from student";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Student std = new Student(resultSet.getInt("id"), 
                        resultSet.getString("fullname"),
                        resultSet.getString("gender"),
                        resultSet.getString("email"),
                        resultSet.getString("phone_number"),
                        resultSet.getInt("age"));
                studentList.add(std);
            }
            
        }catch (SQLException ex) {
           Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null){
                 try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc ket noi
      return studentList;
    }
    
    public static void insert(Student std){
        Connection connection = null ;
        PreparedStatement statement = null ;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");

            String sql = "insert into student(fullname,gender,age,email,phone_number) values(?, ?, ?, ?, ?)";
            statement = connection.prepareCall(sql);

            statement.setString(1,std.getFullname());
            statement.setString(2,std.getGender());
            statement.setInt(3,std.getAge());
            statement.setString(4,std.getEmail());
            statement.setString(5,std.getPhoneNumber());

            statement.execute();

        }catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
    public static void update(Student std){
        Connection connection = null ;
        PreparedStatement statement = null ;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");

            String sql = "update student set fullname=?, gender=?, age=?, email=?, phone_number=?, where id = ?";
            statement = connection.prepareCall(sql);

            statement.setString(1,std.getFullname());
            statement.setString(2,std.getGender());
            statement.setInt(3,std.getAge());
            statement.setString(4,std.getEmail());
            statement.setString(5,std.getPhoneNumber());
            statement.setInt(6,std.getId());

            statement.execute();

        }catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void delete(int id){
        Connection connection = null ;
        PreparedStatement statement = null ;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");

            String sql = "delete from student where id = ?";
            statement = connection.prepareCall(sql);
            
            statement.setInt(1,id);

            statement.execute();

        }catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static List<Student> findByFullname(String fullname) { //lay tat ca ds sv
        List<Student> studentList = new ArrayList<>();
        
        Connection connection = null ;
        PreparedStatement statement = null ;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");
            
            String sql = "select * from student where fullname like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+fullname+"%");
            
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Student std = new Student(resultSet.getInt("id"), 
                        resultSet.getString("fullname"),
                        resultSet.getString("gender"),
                        resultSet.getString("email"),
                        resultSet.getString("phone_number"),
                        resultSet.getInt("age"));
                studentList.add(std);
            }
            
        }catch (SQLException ex) {
           Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null){
                 try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc ket noi
      return studentList;
    }
    
}


