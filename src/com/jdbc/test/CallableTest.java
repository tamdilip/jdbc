package com.jdbc.test;

import java.sql.*;
public class CallableTest
{
public static void main(String[] args) 
{
Connection conn=null;

try
{
Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection( "jdbc:mysql://localhost/Company","dsomasun","csc");
CallableStatement stmt=conn.prepareCall("call getaddEmployees()");
ResultSet rs=stmt.executeQuery();
System.out.println(rs);
while(rs.next())
{
System.out.println(rs.getInt(1));
System.out.println(rs.getString(2));
}
}
catch(Exception e)
{
e.printStackTrace();
}
finally
{
try
{
conn.close();	
}
catch(SQLException e)
{
e.printStackTrace();
}
}
}
}
