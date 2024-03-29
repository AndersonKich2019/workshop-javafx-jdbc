package model.services;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentService {
	
	private DepartmentDao dao = DaoFactory.createDepartmentDao();//inje��o de depend�ncia

	public List<Department> findAll() {

		List<Department> list = new ArrayList<Department>();
		return dao.findAll();
	}
	
	public void saveOrUpdate(Department obj) {
		if(obj.getId() == null) {
		dao.insert(obj);
		
		}else {
			dao.update(obj);
		}
		
	}

}
