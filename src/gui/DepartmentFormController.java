package gui;

import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

import db.DbException;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ConstraintsBase;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentFormController implements Initializable{

	private Department entity;
	
	private DepartmentService service;
	
	@FXML
	private TextField txtId;
	
	@FXML
	private TextField txtName;
	
	@FXML
	private Label labelErrorName;
	
	@FXML
	private Button btSave;
	
	@FXML
	private Button btCancel;
	
	
	@FXML
	public void onBtSaveAction(ActionEvent event) {
		if(entity == null) {
			throw new IllegalStateException("Entity was null");
		}
		if(service == null) {
			throw new IllegalStateException("Service was null");
		}
		try {
			entity = getFormData();
			service.saveOrUpdate(entity);
		}
		catch(DbException e) {
			Alerts.showAlert("Error saving object", null, e.getMessage(), AlertType.ERROR);
		}
		
		Utils.currentStage(event).close();//Fechar janela
		
	}
	
	private Department getFormData() {
		Department obj = new Department();
		obj.setId(Utils.tryParseToInt(txtId.getText()));
		obj.setName(txtName.getText());
		return obj;
	}

	@FXML
	public void onBtCancelAction(ActionEvent event) {
		Utils.currentStage(event).close();//Fechar janela
	}
	
	public void setDepartment(Department entity) {
		this.entity = entity;
	}
	
	public void DepartmentService(DepartmentService service) {
		this.service = service;
	}
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initilizeNodes();		
	}

	private void initilizeNodes() {//Restrições
		Constraints.setTextFieldInteger(txtId);//só aceita inteiros
		Constraints.setTextFieldMaxLength(txtName, 30);//Nome max 30 caracteres
		
	}

	public void updateFormData() {
		if(entity == null) {
			throw new IllegalStateException("Entity was null");
		}
		txtId.setText(String.valueOf(entity.getId()));//Converte numeros para string
		txtName.setText(entity.getName());
	}
	
	
	
	
}
