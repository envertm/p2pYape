package collection.utility;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import org.junit.jupiter.api.Test;

public class purchaseNum {

	
    private static final String URL = "jdbc:mysql://bdvisadirect01.cluster-c6yd7q2qhj6x.us-east-1.rds.amazonaws.com:3306/ecommerce";
    private static final String USER = "usrecommerce";
    private static final String PASSWORD = "Niubiz$2022";


    public static Connection getConnection() {
      
    	Connection connection = null;
        try {
         
            Class.forName("com.mysql.cj.jdbc.Driver");
        
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión establecida con éxito.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se pudo cargar el controlador.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error: No se pudo establecer la conexión.");
            e.printStackTrace();
        }
        return connection;
    }


    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada con éxito.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión.");
                e.printStackTrace();
            }
        }
    }

    
    public static String ejecutarConsulta(String consulta) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        String columna = null;
        String cc = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(consulta);
            resultSet = preparedStatement.executeQuery();
            			
            while (resultSet.next()) {
               
                 columna = resultSet.getString("purchaseNumber");
                 
                 int colum = Integer.parseInt(columna);
                 Integer va = 1;
                 
                 int suma = colum + va;
                 
                  cc = String.valueOf(suma);
                 
                System.out.println("Valor de columna: " + suma);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta.");
            e.printStackTrace();
        } finally {
         
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            closeConnection(connection);
        }
        return cc;
    }

    
    public static void update(String consulta) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
        	connection = getConnection();
        	preparedStatement = connection.prepareStatement(consulta);
          
            int filasActualizadas = preparedStatement.executeUpdate();
            System.out.println("Se han actualizado " + filasActualizadas + " filas correctamente.");
            
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta.");
            e.printStackTrace();
        } finally {
   
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            closeConnection(connection);
        }
       
    }
    
    
    public static String numPurchase(String pu) {
	
        String consulta = "select CONVERT(purchaseNumber, SIGNED) as purchaseNumber from LOG_VISA_DIRECT_TRX_HIST where merchantId = '"+pu+"' and DATE(transactionDatetime) =  CURDATE() order by purchaseNumber DESC limit 1";
        return ejecutarConsulta(consulta);   
    }
    
    @Test
	public static void flag(String flag, String com) {	
    	if(flag.equals("I")){
    	String query = "UPDATE ecommerce.OCT_CONFIG_BALANCE SET flagAntifraud = 0, isMerchantCrypto = 0, isPaymentFacilitator = 0, flagSirius = 0 where merchantId = '"+com+"'";
		update(query);
    	}else {
         String query = "UPDATE ecommerce.OCT_CONFIG_BALANCE SET flagAntifraud = 0, isMerchantCrypto = 0, isPaymentFacilitator = 0, flagSirius = 1 where merchantId = '"+com+"'";
    	 update(query); 	
    	}
	}
	
    public static String getNumber(){      
        Random random = new Random();
        // Generar un número aleatorio entre 100000 y 999999 (ambos inclusive)
        int numero = random.nextInt(800000) + 100000;
        return numero+"";
    }
    
    
}
