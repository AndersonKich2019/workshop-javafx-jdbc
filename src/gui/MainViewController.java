package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.services.DepartmentService;

public class MainViewController implements Initializable{
	@FXML
	private MenuItem menuItemDepartment;
	
	@FXML
	private MenuItem menuItemSeller;
	
	@FXML
	private MenuItem menuItemAbout;
	
	@FXML
	public void onMenuItemDepartmentAction() {
		loadView("/gui/DepartmentList.fxml", (DepartmentListController controler)->{//Função de inicialização(Lambda). 
			controler.setDepartmentService(new DepartmentService());
			controler.updateTableView();
		});
	}

	@FXML
	public void onMenuItemSellerAction() {
		
	}
	
	@FXML
	public void onMenuItemAboutAction() {
		loadView("/gui/About.fxml", x -> {});//Função de inicialização(Lambda) vazia. 
	}
	
	public synchronized <T> void loadView(String absolutname, Consumer<T> initializingAction) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absolutname));
			VBox newVBox = loader.load();
			
			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			
			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox.getChildren());
			
			T controller = loader.getController();//inicia o consumer.
			initializingAction.accept(controller);
			
		}
		catch(IOException e) {
			Alerts.showAlert("IO Exception", "Error load view", e.getMessage(), AlertType.ERROR);
		}
	}
	
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}

	

}
