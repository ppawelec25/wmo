/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package demo.projects.ui;

import demo.projects.dao.DyscyplinaRepository;
import demo.projects.dao.FazaRepository;
import demo.projects.dao.RolaRepository;
import demo.projects.domain.rupWmo.*;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javafx.util.Callback;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Thomas Darimont
 */
@Component
public class ProjectsPresenter {

	@FXML TableView<Dyscyplina> projectsTable;

	@FXML TableColumn<Dyscyplina, String> projectNameColumn;
//	@FXML TableColumn<Dyscyplina, String> projectDescriptionColumn;

	@FXML TableView<Rola> tasksTable;
	@FXML TableColumn<Rola, String> taskNameColumn;
	@FXML TableView<SlownikCzynnosc> czynnosci;
	@FXML TableColumn<SlownikCzynnosc, String> czynnosc;
	@FXML TableView<SlownikProdukt> produkty;
	@FXML TableColumn<SlownikProdukt, String> produkt;
	@FXML TableColumn<Rola, String> taskDescriptionColumn;
	@FXML TableColumn<Rola, Long> taskStatusColumn;
//	@FXML Button deleteColumn;

	@FXML
	TableView<SlownikFaza> faza;

	@FXML
	TableColumn<SlownikFaza,String> fazaName;

	@FXML
	Button dopasuj;
	@FXML
	TextField wymagania;
	@FXML
	TextField typ;
	@FXML
	TextField ileTrwa;
	@FXML
	TextField zawnetrzne;
	@FXML
	TextField ux;
	@FXML
	TextField security;
	@FXML
	TextField bazadanych;

	@FXML
	CheckBox tRok;
	@FXML
	CheckBox t2;
	@FXML
	CheckBox t3;
	@FXML
	CheckBox nowy;
	@FXML
	CheckBox utrzymaniowy;
	@FXML
	CheckBox rozwojowy;
	@FXML
	CheckBox BD;
	@FXML
	CheckBox liczbaWymagan;
	@FXML
	CheckBox testy;
	@FXML
	CheckBox ile;
	@FXML
	CheckBox integracja;
	@FXML
	CheckBox fundusz;
	@FXML
	CheckBox bezpieczenstwo;
	@FXML
	CheckBox gui;

	@Autowired ProjectsView projectsView;

	@Autowired
	DyscyplinaRepository dyscyplinaRepository;
	@Autowired
	RolaRepository rolaRepository;
	@Autowired
	FazaRepository fazaRepository;

	@FXML
	public void initialize() {

		configureProjectsTable();
		configureTasksTable();

		for (SlownikFaza project : fazaRepository.findAll()) {
			faza.getItems().add(project);
		}

		faza.getSelectionModel().selectFirst();


	}

	private void configureTasksTable() {

		taskNameColumn.setCellValueFactory(new PropertyValueFactory<Rola, String>("nazwa"));
//		taskDescriptionColumn.setCellValueFactory(new PropertyValueFactory<Rola, String>("nazwa"));


		Callback<TableColumn<Rola, String>, TableCell<Rola, String>> call = new Callback<TableColumn<Rola, String>, TableCell<Rola, String>>() {
			@Override
			public TableCell call(final TableColumn<Rola, String> param) {
				final TableCell<Rola, String> cell = new TableCell<Rola, String>() {

					final Button btn = new Button("Usun");

					@Override
					public void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						if (empty) {
							setGraphic(null);
							setText(null);
						} else {
							btn.setOnAction((ActionEvent event) ->
							{
								Rola person = getTableView().getItems().get(getIndex());
								rolaRepository.delete(person);
							});
							setGraphic(btn);
							setText(null);
						}
					}
				};
				return cell; }
		};


	}

	private void configureProjectsTable() {

		projectNameColumn.setCellValueFactory(new PropertyValueFactory<Dyscyplina, String>("nazwa"));
//		projectDescriptionColumn.setCellValueFactory(new PropertyValueFactory<Dyscyplina, String>("nazwa"));
		czynnosc.setCellValueFactory(new PropertyValueFactory<SlownikCzynnosc, String>("nazwa"));
		produkt.setCellValueFactory(new PropertyValueFactory<SlownikProdukt, String>("nazwa"));
		fazaName.setCellValueFactory(new PropertyValueFactory<SlownikFaza, String>("nazwa"));
		ChangeListener<Dyscyplina> projectSelectionChanged = (observable, oldValue, newValue) -> {
			tasksTable.getItems().clear();
			for (Rola task : newValue.getRolas()) {
				tasksTable.getItems().add(task);
			}
		};

		ChangeListener<Rola> rolaSelectionChanged = (observable, oldValue, newValue) -> {
			czynnosci.getItems().clear();
			produkty.getItems().clear();
			Set<SlownikCzynnosc> setC = new HashSet<>();
			Set<SlownikProdukt> setP = new HashSet<>();
			for (ZaleznoscRolaCzynnosc task : newValue.getZaleznoscRolaCzynnoscs()) {
				  setC.add(task.getSlownikCzynnosc());
			}
			for (ZaleznoscRolaProdukt task : newValue.getZaleznoscRolaProdukts()) {
				setP.add(task.getSlownikProdukt());
			}
			czynnosci.getItems().addAll(setC);
			produkty.getItems().addAll(setP);
		};

		ChangeListener<SlownikFaza> fazaSelectionChanged = (observable, oldValue, newValue) -> {
			czynnosci.getItems().clear();
			produkty.getItems().clear();
			projectsTable.getItems().clear();
			for (ZaleznoscDyscyplinaFaza task : newValue.getZaleznoscDyscyplinaFazas()) {
				projectsTable.getItems().add(task.getDyscyplina());
			}
		};

		projectsTable.getSelectionModel().selectedItemProperty().addListener(projectSelectionChanged);
		tasksTable.getSelectionModel().selectedItemProperty().addListener(rolaSelectionChanged);
		faza.getSelectionModel().selectedItemProperty().addListener(fazaSelectionChanged);
	}
	@FXML
	private void handleButtonAction(ActionEvent event) throws IOException {
		Stage stage;
		Parent root;
		if(event.getSource()==dopasuj){
			//get reference to the button's stage

			List<CheckBox> pytania = new ArrayList<CheckBox>();
				pytania.add(tRok);
				pytania.add(t2);
				pytania.add(t3);
				pytania.add(nowy);
				pytania.add(utrzymaniowy);
				pytania.add(rozwojowy);
				pytania.add(BD);

			pytania.add(liczbaWymagan);
			pytania.add(testy);
			pytania.add(ile);
			pytania.add(integracja);
			pytania.add(fundusz);
			pytania.add(bezpieczenstwo);
			pytania.add(gui);

			List<String> istotne =pytania.stream().filter(checkBox -> checkBox.isSelected()).map(checkBox1 -> checkBox1.getText()).collect(Collectors.toList());

			Set<Rola> role = new HashSet<Rola>();

			for(Rola rola : rolaRepository.findAll()) {
			 for( ZaleznoscPytaniaRola pytRola : rola.getZaleznoscPytaniaRolas()) {
				if(istotne.contains(pytRola.getPytania().getNazwa())) {
					role.add(rola);
				}
			 }
			}
			tasksTable.getItems().clear();

			for (Rola task : role) {
				tasksTable.getItems().add(task);
			}
			czynnosci.getItems().clear();
			produkty.getItems().clear();


		}
	}
}
