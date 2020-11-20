package teste;

import org.apache.log4j.Logger;

public class TesteLog4j {
	
	public static void main(String[] args) {
		
		Logger logger = Logger.getLogger("teste.TesteLog4j");
		
		logger.debug( "debug test" );
		logger.info( "info test" );
		logger.warn( "warn test" );
		logger.error( "error test" );
		
	}

}
