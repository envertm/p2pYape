package collection.api;

import collection.helpers.Hook;
import collection.params.UsersParam;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.json.simple.JSONObject;

public class User extends Hook {

    private static UsersParam up;
    
    public static JSONObject data(String cp) throws Throwable {
        String CHANNEL = getData().get(Integer.parseInt(cp) - 1).get(up.COL_CHANNEL);
        String TERMINALID = getData().get(Integer.parseInt(cp) - 1).get(up.COL_TERMINALID);
        String APPLICATIONID = getData().get(Integer.parseInt(cp) - 1).get(up.COL_APPLICATIONID);
        
        String PURCHASENUMBER = getData().get(Integer.parseInt(cp) - 1).get(up.COL_PURCHASENUMBER);
        String PURCHASENUMBEROCT = getData().get(Integer.parseInt(cp) - 1).get(up.COL_PURCHASENUMBEROCT);
        String AMOUNT = getData().get(Integer.parseInt(cp) - 1).get(up.COL_AMOUNT);        
        String CURRENCY = getData().get(Integer.parseInt(cp) - 1).get(up.COL_CURRENCY);
        String EXTERNALTRANSACTIONID = getData().get(Integer.parseInt(cp) - 1).get(up.COL_EXTERNALTRANSACTIONID);
        String TRANSACTIONIDENTIFIER = getData().get(Integer.parseInt(cp) - 1).get(up.COL_TRANSACTIONIDENTIFIER);

        String NAME = getData().get(Integer.parseInt(cp) - 1).get(up.COL_NAME);
        String NAMEOCT = getData().get(Integer.parseInt(cp) - 1).get(up.COL_NAMEOCT);
        String CATEGORYCODE = getData().get(Integer.parseInt(cp) - 1).get(up.COL_CATEGORYCODE);
        String CATEGORYCODE2 = getData().get(Integer.parseInt(cp) - 1).get(up.COL_CATEGORYCODE2);

        String SUBMERCHANTID = getData().get(Integer.parseInt(cp) - 1).get(up.COL_SUBMERCHANTID);
        
        String CARDNUMBER = getData().get(Integer.parseInt(cp) - 1).get(up.COL_CARDNUMBER);
        String EXPIRATIONMONTH = getData().get(Integer.parseInt(cp) - 1).get(up.COL_EXPIRATIONMONTH);
        String EXPIRATIONYEAR = getData().get(Integer.parseInt(cp) - 1).get(up.COL_EXPIRATIONYEAR);      
        String EMAIL = getData().get(Integer.parseInt(cp) - 1).get(up.COL_EMAIL);
        String CAPTURETYPE = getData().get(Integer.parseInt(cp) - 1).get(up.COL_CAPTURETYPE);
        String FIRSTNAME = getData().get(Integer.parseInt(cp) - 1).get(up.COL_FIRSTNAME);
        String LASTNAME = getData().get(Integer.parseInt(cp) - 1).get(up.COL_LASTNAME);       
        String ADDRESS = getData().get(Integer.parseInt(cp) - 1).get(up.COL_ADDRESS);
        String CITY = getData().get(Integer.parseInt(cp) - 1).get(up.COL_CITY);
        String STATECODE = getData().get(Integer.parseInt(cp) - 1).get(up.COL_STATECODE);
        String COUNTRYCODE = getData().get(Integer.parseInt(cp) - 1).get(up.COL_COUNTRYCODE);
        String REFERENCE = getData().get(Integer.parseInt(cp) - 1).get(up.COL_REFERENCE);
        
        String CARDNUMBER2 = getData().get(Integer.parseInt(cp) - 1).get(up.COL_CARDNUMBER2);
        String EXPIRATIONMONTH2 = getData().get(Integer.parseInt(cp) - 1).get(up.COL_EXPIRATIONMONTH2);
        String EXPIRATIONYEAR2 = getData().get(Integer.parseInt(cp) - 1).get(up.COL_EXPIRATIONYEAR2);      
        String CAPTURETYPE2 = getData().get(Integer.parseInt(cp) - 1).get(up.COL_CAPTURETYPE2);
        String FIRSTNAME2 = getData().get(Integer.parseInt(cp) - 1).get(up.COL_FIRSTNAME2);
        String LASTNAME2 = getData().get(Integer.parseInt(cp) - 1).get(up.COL_LASTNAME2);      
        String ADDRESS2 = getData().get(Integer.parseInt(cp) - 1).get(up.COL_ADDRESS2);
        String CITY2 = getData().get(Integer.parseInt(cp) - 1).get(up.COL_CITY2);
        String STATECODE2 = getData().get(Integer.parseInt(cp) - 1).get(up.COL_STATECODE2);
        String COUNTRYCODE2 = getData().get(Integer.parseInt(cp) - 1).get(up.COL_COUNTRYCODE2);
        String REFERENCE2 = getData().get(Integer.parseInt(cp) - 1).get(up.COL_REFERENCE2);
        String EMAIL2 = getData().get(Integer.parseInt(cp) - 1).get(up.COL_EMAIL2);
        String DNI2 = getData().get(Integer.parseInt(cp) - 1).get(up.COL_DNI2);
        String CARDALIASNAME2 = getData().get(Integer.parseInt(cp) - 1).get(up.COL_CARDALIASNAME2);
        String TRANSACTIONIDENTIFIER2 = getData().get(Integer.parseInt(cp) - 1).get(up.COL_TRANSACTIONIDENTIFIER2);
        
        String TOKEN = getData().get(Integer.parseInt(cp) - 1).get(up.COL_TOKEN);
         
        String DNI = getData().get(Integer.parseInt(cp) - 1).get(up.COL_DNI);
        String CARDALIASNAME = getData().get(Integer.parseInt(cp) - 1).get(up.COL_CARDALIASNAME);
        String TOKEN2 = getData().get(Integer.parseInt(cp) - 1).get(up.COL_TOKEN2);
        
           
        JSONObject jo = new JSONObject();
        jo.put("channel", CHANNEL);
        jo.put("terminalId", TERMINALID);
        jo.put("applicationId", APPLICATIONID);

        Map m = new HashMap<>();
        m.put("purchaseNumber", PURCHASENUMBER);
        m.put("purchaseNumberOCT", PURCHASENUMBEROCT);
        m.put("amount", Double.parseDouble(AMOUNT));
        m.put("currency", CURRENCY);
        m.put("externalTransactionId", EXTERNALTRANSACTIONID);
        m.put("transactionIdentifier", new BigInteger(TRANSACTIONIDENTIFIER));

        jo.put("order", m);
        
        Map n = new HashMap<>();
        n.put("name", NAME);
        n.put("nameOCT", NAMEOCT);
        n.put("categoryCode", CATEGORYCODE);
        
        Map t = new HashMap<>();
        t.put("country", CATEGORYCODE2);
        n.put("address", t);
        jo.put("merchant",n);
 
        Map s = new HashMap<>();
        s.put("subMerchantId", SUBMERCHANTID);
        
        jo.put("sponsored", s);
        
        Map rec = new HashMap<>();
        if(cp.equals("4") || cp.equals("5") || cp.equals("6") || cp.equals("10") || cp.equals("11") || cp.equals("12") || cp.equals("16") || cp.equals("17") || cp.equals("18") || cp.equals("22") || cp.equals("23") || cp.equals("24")) {
        	rec.put("tokenId", TOKEN);
        }else {
        rec.put("cardNumber", CARDNUMBER);
        rec.put("expirationMonth", Integer.parseInt(EXPIRATIONMONTH));
        rec.put("expirationYear", Integer.parseInt(EXPIRATIONYEAR));
        }
        rec.put("email", EMAIL);
        rec.put("captureType", CAPTURETYPE);
        rec.put("firstName", FIRSTNAME);
        rec.put("lastName", LASTNAME);
        rec.put("address", ADDRESS);
        rec.put("city", CITY);
        rec.put("stateCode", STATECODE);
        rec.put("countryCode", COUNTRYCODE);
        rec.put("reference", REFERENCE);
        
        if(cp.equals("7") || cp.equals("8") || cp.equals("9") || cp.equals("10") || cp.equals("11") || cp.equals("12") || cp.equals("13") || cp.equals("14") || cp.equals("15") || cp.equals("16") || cp.equals("17") || cp.equals("18") || cp.equals("19") || cp.equals("20") || cp.equals("21") || cp.equals("22") || cp.equals("23") || cp.equals("24")) {
        rec.put("dni", DNI);
        rec.put("cardAliasName", CARDALIASNAME);
        } 
           
        jo.put("recipient", rec);
                
        Map sen = new HashMap<>();
        if(cp.equals("7") || cp.equals("8") || cp.equals("9") || cp.equals("10") || cp.equals("11") || cp.equals("12") || cp.equals("19") || cp.equals("20") || cp.equals("21") || cp.equals("22") || cp.equals("23") || cp.equals("24")) {
        	sen.put("tokenId", TOKEN2);
        }else {
        	  sen.put("cardNumber", CARDNUMBER2);
              sen.put("expirationMonth", Integer.parseInt(EXPIRATIONMONTH2));
              sen.put("expirationYear",  Integer.parseInt(EXPIRATIONYEAR2));  	
        	
        }
        sen.put("captureType", CAPTURETYPE2);
        sen.put("firstName", FIRSTNAME2);
        sen.put("lastName", LASTNAME2);
        sen.put("address", ADDRESS2);
        sen.put("city", CITY2);
        sen.put("stateCode", STATECODE2);
        sen.put("countryCode", COUNTRYCODE2);
        sen.put("reference", REFERENCE2);
        sen.put("email", EMAIL2);
        sen.put("dni", DNI2);
        sen.put("cardAliasName", CARDALIASNAME2);
        sen.put("transactionIdentifier", new BigInteger(TRANSACTIONIDENTIFIER2));        
        jo.put("sender", sen);
        
        return jo;
    }
   
    public static void main(String[] args) throws Throwable {
    	String valor = Integer.toString(1);
		data(valor);
		System.out.println(data(valor));
    	
		
//    	String inputString = "6621446332";
//    	BigInteger result = new BigInteger(inputString);
//   
		
		
//    	Double price = 32.00;
//    	DecimalFormat decim = new DecimalFormat("#.00");
//    	decim.setMaximumFractionDigits(2);
//    	Double price2 = Double.parseDouble(decim.format(price));
//    	
//    	System.out.println(price2);
//	
//    	 String numeroConCeros = "00123.00";
//         double numero = Double.parseDouble(numeroConCeros);
//         System.out.printf("Número parseado: %.2f%n", numero);
//    
  }
    

    
 
}
