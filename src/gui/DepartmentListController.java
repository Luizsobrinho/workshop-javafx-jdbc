package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentListController implements Initializable {

	private DepartmentService service; // Declarando uma dependecia
	@FXML
	private TableView<Department> tableViewDepartment;
	@FXML
	private TableColumn<Department, Integer> tableColumnId;
	@FXML
	private TableColumn<Department, String> tableColumnName;
	@FXML
	private Button btNew;

	private ObservableList<Department> obsList; // Carregar o departamento nessa lista

	@FXML
	public void onBtNewAction() {
		System.out.println("onBtNewAction");
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}

	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}

	private void initializeNodes() {
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));// Inicializando o comportamento das columas
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));

		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());// Fazer o tableView acompanhr a altura da
																				// Janela
	}

	// Responsavel por acessar o serviço e carregar departameto e jogar na obsList,
	// depois ira associar ele na tableView
	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service estava nulo");

		}

		List<Department> list = service.findAll();
		obsList = FXCollections.observableArrayList(list); // Passando a lista de departamento para o obslist
		tableViewDepartment.setItems(obsList);// Carregando a lista na tableview
	}
}
