package com.ailpha.test;

import java.io.IOException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * This is test demo of resource interface of spring.
 * @author ys
 *
 */
public class SpringResourceTest {
	
	private Resource[] resources;
	
	private Resource resource;
	
	public Resource[] getResources() {
		return resources;
	}

	public void setResources(Resource[] resources) {
		this.resources = resources;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	private static Logger logger = LoggerFactory.getLogger(SpringResourceTest.class);

	/**
	 * operate byte array from memory
	 * @param str
	 * @throws IOException 
	 */
	public static void readAndDisplayByteArray(String str) throws IOException{
		Resource resource = new ByteArrayResource(str.getBytes());
		if(resource.exists()){
			Scanner scanner = new Scanner(resource.getInputStream());
			while(scanner.hasNext()){
				logger.info(scanner.nextLine());
			}
			scanner.close();
		}
	}
	
	/**
	 * operate file inputstream
	 * @param filePath
	 * @throws IOException 
	 */
	public static void readFile(String filePath) throws IOException{
		Resource resource = new FileSystemResource(filePath);
		if(resource.exists()){
			Scanner scanner = new Scanner(resource.getInputStream());
			while(scanner.hasNext()){
				logger.info(scanner.nextLine());
			}
			scanner.close();
		}
	}
	
	/**
	 * read file under classpath directory
	 * @param fileNameOrRelativeFilePath
	 * @throws IOException 
	 */
	public static void readFileFromClassPath(String fileNameOrRelativeFilePath) throws IOException{
		Resource resource = new ClassPathResource(fileNameOrRelativeFilePath);
		if(resource.exists()){
			Scanner scanner = new Scanner(resource.getInputStream());
			while(scanner.hasNext()){
				logger.info(scanner.nextLine());
			}
			scanner.close();
		}
	}
	
	/**
	 * use resourceloader interface to operate file
	 * @param file
	 * @throws IOException 
	 */
	public static void readFileByResourceLoader(String file) throws IOException{
		
		ResourceLoader resourceLoader = new DefaultResourceLoader();
		Resource resource = resourceLoader.getResource(file);
		if(resource.exists()){
			Scanner scanner = new Scanner(resource.getInputStream());
			while(scanner.hasNext()){
				logger.info(scanner.nextLine());
			}
			scanner.close();
		}
	}
	
	/**
	 * read internet resource
	 * @param file
	 * @throws IOException 
	 */
	public static void readInternetResource(String file) throws IOException{
		ResourceLoader resourceLoader = new DefaultResourceLoader();
		Resource resource = resourceLoader.getResource(file);
		if(resource.exists()){
			Scanner scanner = new Scanner(resource.getInputStream());
			while(scanner.hasNext()){
				logger.info(scanner.nextLine());
			}
			scanner.close();
		}
	}
	
	/**
	 * resource injection
	 * @throws IOException
	 */
	public static void testResourceInject() throws IOException{
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		if(context.containsBean("springResourceTest")){
			SpringResourceTest test = context.getBean("springResourceTest",SpringResourceTest.class);
			if(test.getResource() instanceof ResourceLoader){
				logger.info("****"+test.getResource().toString());
			}else {
				logger.info("%%%%%"+test.getResource().getClass().getName());
			}
			if(test.getResource()!=null){
				Scanner scanner = new Scanner(test.getResource().getInputStream());
				while(scanner.hasNext()){
					logger.info(scanner.nextLine());
				}
				scanner.close();
			}
		}
	}
	
	public static void testResourcesArrayInject() throws IOException{
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		if(context.containsBean("springResourceTest")){
			SpringResourceTest test = context.getBean("springResourceTest",SpringResourceTest.class);
			if(test.getResources().length>0){
				for(int x=0;x<test.getResources().length;x++){
					if(test.getResources()[x] instanceof DefaultResourceLoader){
						logger.info("@@@@@"+test.getResources()[x].toString());
					}else {
						logger.info("^^^^^^"+test.getResources()[x].getClass().getName());
					}
					if(test.getResources()[x]!=null){
						Scanner scanner = new Scanner(test.getResources()[x].getInputStream());
						while(scanner.hasNext()){
							logger.info(scanner.nextLine());
						}
						scanner.close();
					}
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		// test resource inject
		//testResourceInject();
		
		// test resource array inject
//		testResourcesArrayInject();
		
		//test read internet resource
//		String file = "http://www.springframework.org/schema/beans/spring-beans.xsd";
//		readInternetResource(file);
		
		//test file by using resourceloader
//		String file = "classpath:applicationContext.xml";
//		readFileByResourceLoader(file);
		
		//test file under classpath
		//String fileName = "log4j.properties";
		//readFileFromClassPath(fileName);
		
		//test file
		//String filePath = "C:"+File.separator+"Users"+File.separator+"ys"+
		//File.separator+"Desktop"+File.separator+"Java Architect.pdf";
		
		//readFile(filePath);
		// test byteArrayResource class
		//String str = "spring.io";
		//readAndDisplayByteArray(str);
		
	}
}
