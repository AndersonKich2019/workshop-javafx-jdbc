package model.services;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentService {
	
	private DepartmentDao dao = DaoFactory.createDepartmentDao();//injeção de dependência

	public List<Department> findAll() {

		List<Department> list = new ArrayList<Department>();
		return dao.findAll();

	}

}
