package ma.enset.jdbc.presentation.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.enset.jdbc.dao.AdherentDaoImpl;
import ma.enset.jdbc.dao.EmpruntDaoImpl;
import ma.enset.jdbc.dao.LivreDaoImpl;
import ma.enset.jdbc.dao.entities.Adherent;
import ma.enset.jdbc.services.IBibliothequeMetier;
import ma.enset.jdbc.services.IBibliothequeMetierImpl;

import java.net.URL;


import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class AdherentController implements Initializable {
    @FXML
    private TextField textNom;
    @FXML
    private TextField textPrenom;
    @FXML
    private TextField textCin;
    @FXML
    private TextField textTel;
    @FXML
    private TextField textEmail;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField textSearch;
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn<Adherent,Integer> colId;
    @FXML
    private TableColumn<Adherent,String> colNom;
    @FXML
    private TableColumn<Adherent,String> colPrenom;
    @FXML
    private TableColumn<Adherent,String>  colTel;
    @FXML
    private TableColumn<Adherent,String>  colEmail;
    @FXML
    private TableColumn<Adherent, Date>  colDate;
    @FXML TableColumn<Adherent,String> colCin;
    private ObservableList<Adherent> observableList = FXCollections.observableArrayList();
    private IBibliothequeMetier adherent =new IBibliothequeMetierImpl(new AdherentDaoImpl() , new LivreDaoImpl() , new EmpruntDaoImpl());
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableView.setItems(observableList);
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colCin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        colTel.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date_naissance"));
        observableList.clear();
        observableList.addAll(adherent.findAllAdherent());
        textSearch.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                observableList.clear();
                try {
                    observableList.addAll(adherent.searchAdherent(newValue));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public void ajouter() {
        String nom = textNom.getText();
        String prenom = textPrenom.getText();
        String cin = textCin.getText();
        String tel = textTel.getText();
        String email = textEmail.getText();
        LocalDate localDate=datePicker.getValue();
        if(nom.isEmpty() || prenom.isEmpty() || cin.isEmpty() || tel.isEmpty() || email.isEmpty()  ){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Veuillez remplir le champs!!!!!");
            alert.show();
        }else {
            Adherent ad = new Adherent();
            ad.setNom(nom);ad.setPrenom(prenom);ad.setCin(cin);ad.setTelephone(tel);ad.setEmail(email);
            ad.setDate_naissance(java.sql.Date.valueOf(localDate));
            adherent.saveAdherent(ad);
            observableList.clear();
            observableList.addAll(adherent.findAllAdherent());
        }
        textNom.clear();textPrenom.clear();textCin.clear();textTel.clear();textEmail.clear();
    }

    public void supprimer(ActionEvent actionEvent) {
    }

}
