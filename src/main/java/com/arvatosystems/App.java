package com.arvatosystems;

import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.arvatosystems.console.CommandProcessor;
import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.CacheFactory;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.RegionShortcut;
import com.gemstone.gemfire.cache.query.FunctionDomainException;
import com.gemstone.gemfire.cache.query.NameResolutionException;
import com.gemstone.gemfire.cache.query.QueryInvocationTargetException;
import com.gemstone.gemfire.cache.query.TypeMismatchException;

/**
 * Hello world!
 *
 */
public class App 
{
//    public static void main( String[] args ) throws FunctionDomainException, TypeMismatchException, NameResolutionException, QueryInvocationTargetException
//    {
//    	Cache cache = new CacheFactory()
//        .set("locators", "10.201.55.47[55221]")
//        .set("mcast-port", "0")
//        .set("log-level", "error")
//        .create();   
//    
//    	Region region = cache.createRegionFactory(RegionShortcut.REPLICATE).create("users");
//    	Set entrySet = region.entrySet();
//    	System.out.println(entrySet);
//    	region.get("123");
//    }
    	
	private static final String[] CONFIGS = new String[] { "applicationContext.xml" };

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(CONFIGS);
		// shutdown the context along with the VM
		ctx.registerShutdownHook();
		
		CommandProcessor processor = ctx.getBean(CommandProcessor.class);
		processor.start();
	}
	



}
