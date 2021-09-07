package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Simplebootappplication1Application {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(Simplebootappplication1Application.class, args);
		
		CoreController cc = context.getBean(CoreController.class);
		
		
		while(true) 
		{
			int a = cc.Home();
			switch (a) 
			{
				case 1:{
					cc.AddData();
					break;
				}
				case 2:{
					cc.FetchData();
					break;
				}
				case 3:{
					cc.UpdateData();
					break;
				}
				case 4:{
					cc.DeleteData();
					break;
				}
				default:
					break;
			}
			if (a == 0)
				break;
		}
//		System.exit(0);
	}

}
