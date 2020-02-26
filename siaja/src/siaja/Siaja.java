/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siaja;

/**
 *
 * @author juanr
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class Siaja {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Connection connection = null;
        try {

            // Load the MySQL JDBC driver
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            // Create a connection to the database
            String serverName = "localhost";
            String schema = "test1";
            String url = "jdbc:mysql://" + serverName + "/" + schema;
            String username = "dbadmin";
            String password = "Doglicker1";
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Successfully Connected to the database!");           
            Statement statement = connection.createStatement();         
            ResultSet results = statement.executeQuery("SELECT * FROM customer");           
            ArrayList<Customer> customers = new ArrayList<Customer>();         
            while(results.next())
            {
                String fName = results.getString("first_name");
                String lName = results.getString("last_name");
                String phone = results.getString("phone");
                int id= Integer.parseInt(results.getString("cust_id"));
                Customer temp= new Customer(fName,lName,phone,id);
                customers.add(temp);
            }
            
            for(int i = 0; i < customers.size();i++)
            {
                System.out.println("ID:"+customers.get(i).getid()+"Fullname: "+customers.get(i).getfName()+" Lastname: "+customers.get(i).getlName()+" Phone: "+customers.get(i).getphone());
            } 
            String query = "INSERT INTO customer(first_name,last_name,phone) VALUES(\"caca\",\"popo\",\"123\")";
            PreparedStatement stmnt = connection.prepareStatement(query);
            stmnt.execute();       
            connection.close();
        } catch (SQLException e) {

            System.out.println("Could not retrieve data from the database " + e.getMessage());
        }
        catch (ClassNotFoundException e) {

            System.out.println("Could not find the database driver " + e.getMessage());
        }
    }

}
