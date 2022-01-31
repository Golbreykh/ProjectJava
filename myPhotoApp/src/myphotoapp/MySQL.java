package myphotoapp;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

//  Текст скрипта, создающего таблицу в базе для хранения изображений
//
//  Create Table dbo.pictures(
//	id    int IDENTITY(1,1) NOT NULL,
//	photo image NOT NULL,
//	name  nvarchar(50) NULL,
//  Constraint PK_pictures primary key clustered (id ASC) )

public class MySQL {
    static String url;
    static{
         url="jdbc:sqlserver://localhost\\SQLExpress;database=AdventureWorks";
         try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         }catch(ClassNotFoundException ex) { 
             System.err.println(ex.getMessage()); }
    }
    public static void putPhoto(String name, String path){
       try(Connection con=DriverManager.getConnection(url,"sa","1234")){
           
         File file=new File(path); 
         if (!file.exists()) { 
             System.out.println("File with name: "+path+" Not found!"); 
             return; 
         }
         
         int  size=(int)file.length();
         
         BufferedInputStream fis=new BufferedInputStream(
                                new FileInputStream(file));
         
         String sql="Insert into dbo.pictures (name,photo) Values(?,?)";
         PreparedStatement pst=con.prepareStatement(sql);
         pst.setString(1, name);
         pst.setBinaryStream(2, fis, size);
         pst.executeUpdate();
       }
       catch(SQLException | IOException ex) { 
           System.err.println(ex.getMessage()); } 
    }
}
