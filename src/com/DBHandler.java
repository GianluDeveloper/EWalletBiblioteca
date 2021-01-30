package com;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import exceptions.NotHandledTypeException;

public class DBHandler {
	   private static final String DBName = "ewallet";

	   private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	   private static final String DB_URL =
	   "jdbc:mysql://dbWallet:3306/"+DBName
		+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";


	   private static final String USER = "ewallet";
	   private static final String PASS = "ewallet";
	   private List<Object> res=new ArrayList<>();
	   
	   public List<Object> getResponse(){
		   return this.res;
	   }
	   
	   public boolean sql(String sql, Object[] objs) throws ClassNotFoundException, SQLException, NotHandledTypeException   {
		   boolean success=false;
		   Connection conn = null;
		   PreparedStatement stmt = null;
	   
	   
	      //STEP 2: Register JDBC driver
	      Class.forName(JDBC_DRIVER);

	      //STEP 3: Open a connection
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);

	      stmt = conn.prepareStatement(sql);;
	      int counter=1;
	      for(Object obj:objs) {
	    	  if(obj.getClass().getTypeName().toString().matches(".*String.*")) {
	    		  stmt.setString(counter++,(String)obj);
	    	  }else if(obj.getClass().getTypeName().toString().matches(".*Integer.*")) {
	    		  stmt.setInt(counter++,(Integer)obj);
	    	  }else if(obj.getClass().getTypeName().toString().matches(".*Boolean.*")) {
	    		  stmt.setBoolean(counter++,(Boolean)obj);
	    	  }else if(obj.getClass().getTypeName().toString().matches(".*Float.*")) {
	    		  stmt.setFloat(counter++,(Float)obj);
	    	  }else if(obj.getClass().getTypeName().toString().matches(".*java\\.sql\\.Date.*")) {
	    		  stmt.setDate(counter++,(java.sql.Date)obj);
	    	  }else {
	    		  throw new NotHandledTypeException(obj.getClass().getTypeName().toString());
	    	  }
	      }
	      
	      stmt.execute();
	      ResultSet rs = stmt.getResultSet();

	      //STEP 5: Extract data from result set
	      if(rs!=null) {
	    	  ResultSetMetaData md = rs.getMetaData();
	    	  Integer colonne = md.getColumnCount();
	    	  while(rs.next()){
	    		  	Object []oggetto = new Object[colonne];
					for(int i = 1;i<=colonne;i++) {
						oggetto[i-1]=rs.getObject(i);
					}
					res.add(oggetto);
	    	  }
	    	  rs.close();
	      }
	      
	       
	      
	      //STEP 6: Clean-up environment
	      
	      stmt.close();
	      conn.close();
	      success=true;
	   
	         if(stmt!=null) {
	            stmt.close();
	      		}
	      
	         if(conn!=null)
	            conn.close();
	     
	   return success;
	}//end main
}
