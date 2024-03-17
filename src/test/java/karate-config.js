function fn() {
	//variables de entorno
	var env = karate.env
	karate.log('el valor de env es :' , env);
	
	if(!env){
		env = 'dev'
	}

	
	var config = {
		//env: env,
		user : 'usrecommerce',
		pass : 'Niubiz$2022',
		urls : 'jdbc:mysql://bdvisadirect01.cluster-c6yd7q2qhj6x.us-east-1.rds.amazonaws.com:3306/ecommerce',
		driver : 'com.mysql.cj.jdbc.Driver',
		update : "UPDATE ecommerce.OCT_CONFIG_BALANCE SET flagAntifraud = 0, isMerchantCrypto = 0, isPaymentFacilitator = 0, flagSirius = 0 where merchantId = '341198214'",
		QueryPurchase : "SELECT CONVERT(a.purchaseNumber, SIGNED) as purchaseNumber from ecommerce.LOG_VISA_DIRECT_TRX_HIST a where merchantId = '341198214' and DATE(transactionDatetime) = CURDATE() order by purchaseNumber DESC limit 1",
     	QuerySelect : "select a.recipientAccountBin ,a.senderAccountBin ,a.* from ecommerce.LOG_VISA_DIRECT_TRX_HIST a where purchaseNumber  = '168500' and recipientAccountBin  = '428082'",
     	baseURL : 'https://visadirect.vnforappstest.com/api.visadirect/v2/p2p',
     	comercio : '341198214',
     	ruta : '../../resources/fixtures/Data.csv'  
     			
	}
	
	if(env == 'dev'){
		
	}else if(env == 'e2e'){
		
	}
	//    * def tokenAPI = callonce read('../../token/token.feature')
	var accessToken = karate.callSingle('classpath:token/token.feature', config).token
	karate.configure('headers', {Authorization: accessToken })
	
	karate.configure('connectTimeout', 20000);
	karate.configure('readTimeout', 20000);
	return config;
}
