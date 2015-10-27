package com.akc.logging;

import java.io.PrintStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
public class AspectModule {

   /** Following is the definition for a pointcut to select
    *  all the methods available. So advice will be called
    *  for all the methods.
    */
	static final Logger logger = LogManager.getRootLogger();
	public AspectModule() {
		// TODO Auto-generated constructor stub
	
	//	System.setOut(createLoggingProxy(System.out));
    //    System.setErr(createLoggingProxy(System.err));
     
       
	}
	public static PrintStream createLoggingProxy(final PrintStream realPrintStream) {
        return new PrintStream(realPrintStream) {
            public void print(final String string) {
                
                logger.info(string);
            }
        };
    }
   /** 
    * This is the method which I would like to execute
    * before a selected method execution.
    */
   public void beforeAdvice(JoinPoint joinPoint){
	   String data="Start Method "+ joinPoint.getSignature() ;
	  
	   Object[] signatureArgs = joinPoint.getArgs();
	   for (Object signatureArg: signatureArgs) {
		data= data+" Method Value "+ signatureArg.toString();
	     
	   }
	   logger.info(data);
	   
   }

   /** 
    * This is the method which I would like to execute
    * after a selected method execution.
    */
   public void afterAdvice(JoinPoint joinPoint){

	  
	   logger.debug("END Method " +joinPoint.getSignature());
   }

   /** 
    * This is the method which I would like to execute
    * when any method returns.
    */
   public void afterReturningAdvice(JoinPoint joinPoint){
     
   }

   /**
    * This is the method which I would like to execute
    * if there is an exception raised by any method.
    */
   public void AfterThrowingAdvice(Exception ex){
	   String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(ex);
	  logger.error(fullStackTrace);
   }
   
}