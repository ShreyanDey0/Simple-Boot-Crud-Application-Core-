package com.example.demo;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.CoreRepo;
import com.example.demo.model.CoreModel;

@Component
public class CoreController{
	Scanner s = new Scanner(System.in);
	
	@Autowired
	CoreRepo repo;
	
	public int Home() {
		System.out.println("Enter 1 to Add Data");
		System.out.println("Enter 2 to Fetch Data");
		System.out.println("Enter 3 to Update Data");
		System.out.println("Enter 4 to Delete Data");
		System.out.println("Enter 0 to Terminate");
		int a = s.nextInt();
		return a;
	}

	public void FetchData() {
		List<CoreModel> s = repo.findAll();
		if(s.size() > 0) {
			for (int j = 0; j < s.size(); j++) {
				System.out.println(s.get(j));
			}
		}
		else
			System.out.println("No data Available");
	}

	public void AddData() {
		try {
			System.out.println("Enter Name:");
			String name = s.next();
			System.out.println("Enter Sex:");
			String sex = s.next();
			
			CoreModel cm = new CoreModel();
			cm.setName(name);
			cm.setSex(sex);
			
			if(repo.save(cm) != null) 
				System.out.println("1 row added");
		}
		catch(Exception e){
			System.out.println("error occoured: " + e);
		}
		
	}
	public void UpdateData() {
		try{
			this.FetchData();
			
			System.out.println("Enter Id:");
			int id = s.nextInt();
			
			System.out.println(repo.findById(id).toString());
			
			System.out.println("Enter Updated Name:");
			String name = s.next();
			System.out.println("Enter Updated Sex:");
			String sex = s.next();
			
			CoreModel cm = new CoreModel();
			cm.setId(id);
			cm.setName(name);
			cm.setSex(sex);
			
			repo.save(cm);
			
			if(repo.save(cm) != null) 
				System.out.println("row updated");
		}
		catch(Exception e) {
			System.out.println("error occoured: " + e);
		}
	}
	public void DeleteData() {
		try {
			this.FetchData();
			
			System.out.println("Enter Id:");
			int id = s.nextInt();
			
			CoreModel cm = new CoreModel();
			cm.setId(id);
			
			repo.deleteById(id);
			
			System.out.println("row deleted");
		} 
		catch (Exception e) {
			System.out.println("Some Error occured or mistake done!" + e);
		}
		
	}
	
}
