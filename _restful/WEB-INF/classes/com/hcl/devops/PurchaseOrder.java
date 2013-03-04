package com.hcl.devops;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Enumeration;
import java.io.File;
import java.io.InputStream;
import java.net.URL;


   @Path("/purchaseorder") 
   public class PurchaseOrder {
   
     @GET
     @Path("/createpo/{poname}/{product}/{qty}/{unitprice}/{totalprice}/{shiptoaddress}")
     @Produces("application/json")
     /* poname, product, unitprice, qty, totalprice, shiptoaddress */
     public String createPO(@PathParam("poname") String poname, @PathParam("product") String product, @PathParam("qty") int qty, @PathParam("unitprice") int unitprice, @PathParam("totalprice") int totalprice, @PathParam("shiptoaddress") String shiptoaddress) 
     {
   	 
	   String JDBC_DRIVER = null;
	   String DB_URL = null;
	   String USER = null;
	   String PASS = null;
  	   Connection conn = null;
	   Statement stmt = null;
	   
	   try{
	   		
	   		InputStream in = this.getClass().getClassLoader().getResourceAsStream("com/hcl/devops/config.properties");
	   		Properties prop = new Properties();
	   		prop.load(in);
		    JDBC_DRIVER = prop.getProperty("jdbc_driver");
	   		DB_URL = prop.getProperty("db_url");
	   		USER = prop.getProperty("user");
	   		PASS = prop.getProperty("pass");
	
		   Class.forName(JDBC_DRIVER);
		   conn = DriverManager.getConnection(DB_URL, USER, PASS);
		   stmt = conn.createStatement();
		   String sql = "insert into purchaseorder values ('" + poname + "'" + ",'" + product + "'" + "," + qty + "," + unitprice + "," + totalprice + ",'" + shiptoaddress + "');";
		   
		   int result = stmt.executeUpdate(sql, Statement.NO_GENERATED_KEYS);			 		  	 

		    if(stmt!=null)
			  stmt.close();		   
		    if(conn!=null)
			   conn.close();

		   return "success";
		   
	   }
	   catch (IOException io) {
	   	io.printStackTrace();
	   }
	   catch(SQLException se){
		   se.printStackTrace();
	   }
	   catch(Exception ex){
		   ex.printStackTrace();
	   }
	   
	   return null;
	 }  


	 @GET
     @Path("/updatepo/{poname}/{product}/{qty}/{unitprice}/{totalprice}/{shiptoaddress}")
     @Produces("application/json")
     /* poname, product, unitprice, qty, totalprice, shiptoaddress */
     public String updatePO(@PathParam("poname") String poname, @PathParam("product") String product, @PathParam("qty") int qty
		   , @PathParam("unitprice") int unitprice, @PathParam("totalprice") int totalprice, @PathParam("shiptoaddress") String shiptoaddress) 
     {
   	 
	   String JDBC_DRIVER = null;
	   String DB_URL = null;
	   String USER = null;
	   String PASS = null;
  	   Connection conn = null;
	   Statement stmt = null;   	   
	   
	   try{

	   	    InputStream in = this.getClass().getClassLoader().getResourceAsStream("com/hcl/devops/config.properties");
	   		Properties prop = new Properties();
	   		prop.load(in);
		    JDBC_DRIVER = prop.getProperty("jdbc_driver");
	   		DB_URL = prop.getProperty("db_url");
	   		USER = prop.getProperty("user");
	   		PASS = prop.getProperty("pass");
	
		   Class.forName(JDBC_DRIVER);
		   conn = DriverManager.getConnection(DB_URL, USER, PASS);
		   stmt = conn.createStatement();
		   String sql = "update purchaseorder set product = '" + product + "'," + "qty = " + qty +", unitprice = " + unitprice + ", totalprice = " + totalprice + ", shiptoaddress = '" + shiptoaddress + "' where poname = '" + poname + "';";
		   int rsEnv = stmt.executeUpdate(sql, Statement.NO_GENERATED_KEYS);			 		  	 

			if(stmt!=null)
			  stmt.close();		   
		    if(conn!=null)
			   conn.close();

			return "success";
		   
	   }
	   catch (IOException io) {
	   	io.printStackTrace();
	   }
	   catch(SQLException se){
		   se.printStackTrace();
	   }
	   catch(Exception ex){
		   ex.printStackTrace();
	   }
	   
	   return null;
	}


	@GET
     @Path("/deletepo/{poname}")
     @Produces("application/json")
     /* poname, product, unitprice, qty, totalprice, shiptoaddress */
     public String deletePO(@PathParam("poname") String poname) 
     {
   	 
	   String JDBC_DRIVER = null;
	   String DB_URL = null;
	   String USER = null;
	   String PASS = null;
  	   Connection conn = null;
	   Statement stmt = null;   	   
	   

	   try{
	   	    InputStream in = this.getClass().getClassLoader().getResourceAsStream("com/hcl/devops/config.properties");
	   		Properties prop = new Properties();
	   		prop.load(in);	   		
		    JDBC_DRIVER = prop.getProperty("jdbc_driver");
	   		DB_URL = prop.getProperty("db_url");
	   		USER = prop.getProperty("user");
	   		PASS = prop.getProperty("pass");
	
		   Class.forName(JDBC_DRIVER);
		   conn = DriverManager.getConnection(DB_URL, USER, PASS);
		   stmt = conn.createStatement();
		   String sql = "delete from purchaseorder where poname = '" + poname + "'";
		   //rs = stmt.executeQuery(sql);
		   int result = stmt.executeUpdate(sql, Statement.NO_GENERATED_KEYS);			 		  	 


		    if(stmt!=null)
			  stmt.close();		   
		    if(conn!=null)
			   conn.close();

			return "success";
		   
	   }
	   catch (IOException io) {
	   	io.printStackTrace();
	   }
	   catch(SQLException se){
		   se.printStackTrace();
	   }
	   catch(Exception ex){
		   ex.printStackTrace();
	   }
	   
	   return null;
	}


	@GET
     @Path("/getpodetails/{poname}")
     @Produces("application/json")
     /* poname, product, unitprice, qty, totalprice, shiptoaddress */
     public String getPODetails(@PathParam("poname") String poname) throws SQLException
     {
   	 
	   String JDBC_DRIVER = null;
	   String DB_URL = null;
	   String USER = null;
	   String PASS = null;
  	   Connection conn = null;
	   Statement stmt = null;   	   
	   ResultSet rs = null;

	   try{
	   	    InputStream in = this.getClass().getClassLoader().getResourceAsStream("com/hcl/devops/config.properties");
	   		Properties prop = new Properties();
	   		prop.load(in);
		    JDBC_DRIVER = prop.getProperty("jdbc_driver");
	   		DB_URL = prop.getProperty("db_url");
	   		USER = prop.getProperty("user");
	   		PASS = prop.getProperty("pass");
	
		   Class.forName(JDBC_DRIVER);
		   conn = DriverManager.getConnection(DB_URL, USER, PASS);
		   stmt = conn.createStatement();
		   String sql = "select product, qty, unitprice, totalprice, shiptoaddress from purchaseorder where poname = '" + poname + "'";
		   rs = stmt.executeQuery(sql);

		   ArrayList pods = new ArrayList();
		   while (rs.next()) {
		   	 PODetails pod = new PODetails();
		     pod.setProduct(rs.getObject("product").toString());
		     pod.setQty((int)rs.getObject("qty"));
		     pod.setUnitPrice((int)rs.getObject("unitprice"));
		     pod.setTotalPrice((int)rs.getObject("totalprice"));
		     pod.setShipToAddress(rs.getObject("shiptoaddress").toString());

		     pods.add(pod);
		   }
		   
		   // convert the arraylist to JSON 
		   return new Gson().toJson(pods);
		}
	   catch (IOException io) {
	   	System.out.println("this is the issue");
	   	io.printStackTrace();
	   }
	   catch(SQLException se){
		   se.printStackTrace();
	   }
	   catch(Exception ex){
		   ex.printStackTrace();
	   }
	   
	   finally{
	   	 if (rs!= null)
				rs.close();
			if(stmt!=null)
			  stmt.close();		   
		    if(conn!=null)
			   conn.close();
	   }
	   return null;
	}
	 
}