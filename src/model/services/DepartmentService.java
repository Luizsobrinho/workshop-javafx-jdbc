package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entities.Department;

public class DepartmentService {

	public List<Department> findAll(){
		//mock os dados 
		List<Department> list = new ArrayList<>();
		list.add(new Department(1,"Books"));
		list.add(new Department(2,"Music"));
		list.add(new Department(3,"Eletronics"));
		list.add(new Department(4,"Computers"));
		return list;
	}
}
