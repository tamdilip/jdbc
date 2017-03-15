package com.jdbc.test;


import java.sql.*;

public class StatementSample {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/Company";

   //  Database credentials
   static final String USER = "dsomasun";
   static final String PASS = "csc";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   ResultSet rs = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT emp_id,name FROM Employee";
      rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         int id  = rs.getInt("emp_id");
         String name = rs.getString("name");

         //Display values
         System.out.print("ID: " + id);
         System.out.println(", Name: " + name);
      }

   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      //STEP 6: Clean-up environment
      try{
         if(stmt!=null)
            stmt.close();
	 if(rs!=null)
	    rs.close();
      }catch(SQLException se2){
      }
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
 }//end main
}