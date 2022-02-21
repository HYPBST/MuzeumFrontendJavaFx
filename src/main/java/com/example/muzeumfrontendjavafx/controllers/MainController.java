package com.example.muzeumfrontendjavafx.controllers;

import com.example.muzeumfrontendjavafx.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.List;

public class MainController extends Controller {

    @FXML
    public TableView<Festmeny> festmenyTable;
    @FXML
    public TableColumn<Festmeny,String> colCim;
    @FXML
    public TableColumn<Festmeny, Integer> colEv;
    @FXML
    public TableColumn<Festmeny, Boolean> colKiallitva;
    @FXML
    public TableView<Szobor> szoborTable;
    @FXML
    public TableColumn<Szobor,String> colAlkoto;
    @FXML
    public TableColumn<Szobor,Integer> colMagassag;
    @FXML
    public TableColumn<Szobor,Integer> colAr;

    public void initialize() {
        colCim.setCellValueFactory(new PropertyValueFactory<>("title"));
        //a tárolt objektumban egy getCim függvényt fog keresni.
        colEv.setCellValueFactory(new PropertyValueFactory<>("year"));
        colKiallitva.setCellValueFactory(new PropertyValueFactory<>("on_display"));
        colAlkoto.setCellValueFactory(new PropertyValueFactory<>("person"));
        colMagassag.setCellValueFactory(new PropertyValueFactory<>("height"));
        colAr.setCellValueFactory(new PropertyValueFactory<>("price"));

        listaFeltolt();
    }

    public void onHozzadasButtonClick(ActionEvent actionEvent) {
    }

    public void onModositasButtonClick(ActionEvent actionEvent) {
    }

    public void onTorlesButtonClick(ActionEvent actionEvent) {
    }
    private void listaFeltolt(){
        try {
            List<Festmeny> festmenyList = FestmenyApi.getFestmenyek();
            festmenyTable.getItems().clear();
            for (Festmeny festmeny : festmenyList) {
                festmenyTable.getItems().add(festmeny);
            }
            List<Szobor> szoborList = SzoborApi.getSzobrok();
            szoborTable.getItems().clear();
            for (Szobor szobor : szoborList) {
                szoborTable.getItems().add(szobor);
            }
        } catch (IOException e) {
            hibaKiir(e);
        }
    }
}