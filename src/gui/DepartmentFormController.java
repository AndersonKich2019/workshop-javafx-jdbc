package gui;

import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ConstraintsBase;
import model.entities.Department;

public class DepartmentFormController implements Initializable{

	private Department entity;
	
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
	public void onBtSaveAction() {
		System.out.println("onBtSaveAction");
	}
	
	@FXML
	public void onBtCancelAction() {
		System.out.println("onBtCancelAction");
	}
	
	public void setDepartment(Department entity) {
		this.entity = entity;
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
