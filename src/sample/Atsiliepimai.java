package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Atsiliepimai {

    private BorderPane bpRoot;
    private Scene scene;
    private Stage primaryStage;

    private TextField tfId;
    private TextField tfMiestas;
    private TextField tfVardas;
    private TextField tfElPastas;
    private TextField tfAtsiliepimas;

    private GridPane gpAtsiliepimuInfo;

    private TableView<Atsiliepimas> table = new TableView<Atsiliepimas>();

    Atsiliepimai(Stage primaryStage) {
        this.bpRoot = new BorderPane();
        scene = new Scene(this.bpRoot, 800, 750);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        this.primaryStage = primaryStage;
        this.primaryStage.setScene(scene);
        this.primaryStage.setTitle("Atsiliepimai");
        this.primaryStage.setResizable(false);
        this.primaryStage.centerOnScreen();
        addElementsToScene();
        this.primaryStage.show();
    }

    private void addElementsToScene() {

        Label lblId = new Label("Atsiliepimo ID");
        Label lblMiestas = new Label("Miestas");
        Label lblVardas = new Label("Vardas");
        Label lblElPastas = new Label("El. paštas");
        Label lblAtsiliepimas = new Label("Atsiliepimas");

        this.tfId = new TextField();
        this.tfMiestas = new TextField();
        this.tfVardas = new TextField();
        tfVardas.setPromptText("Paieška");
        this.tfElPastas = new TextField();
        this.tfAtsiliepimas = new TextField();

        //lenteles pradzia
        TableColumn idCol = new TableColumn("ID");
        idCol.setMinWidth(5);
        idCol.setStyle("-fx-alignment: center-right");
        idCol.setCellValueFactory(
                new PropertyValueFactory<Atsiliepimas, Integer>("id"));

        TableColumn miestasCol = new TableColumn("Miestas");
        miestasCol.setMinWidth(5);
        miestasCol.setStyle("-fx-alignment: center-right");
        miestasCol.setCellValueFactory(
                new PropertyValueFactory<Atsiliepimas, String>("Miestas"));
        miestasCol.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn vardasCol = new TableColumn("Vardas");
        vardasCol.setMinWidth(5);
        vardasCol.setStyle("-fx-alignment: center-right");
        vardasCol.setCellValueFactory(
                new PropertyValueFactory<Atsiliepimas, String>("Vardas"));
        vardasCol.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn elpastasCol = new TableColumn("El. paštas");
        elpastasCol.setMinWidth(5);
        elpastasCol.setStyle("-fx-alignment: center-right");
        elpastasCol.setCellValueFactory(
                new PropertyValueFactory<Atsiliepimas, String>("elpastas"));
        elpastasCol.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn atsiliepimasCol = new TableColumn("Atsiliepimas");
        atsiliepimasCol.setMinWidth(5);
        atsiliepimasCol.setStyle("-fx-alignment: center-right");
        atsiliepimasCol.setCellValueFactory(
                new PropertyValueFactory<Atsiliepimas, String>("Atsiliepimas"));
        atsiliepimasCol.setCellFactory(TextFieldTableCell.forTableColumn());


        ObservableList<Atsiliepimas> data = FXCollections.observableArrayList();
        AtsiliepimaiDao atsiliepimaiDao = new AtsiliepimaiDao();
        atsiliepimaiDao.showAtsiliepimai(data);
        table.setItems(data);


        table.getColumns().addAll(idCol, miestasCol, vardasCol, elpastasCol, atsiliepimasCol);
//lenteles pabaiga

        //patys mygtukai
        Button btnAdd = new Button("Pridėti");
        btnAdd.setMinWidth(80);
        Button btnDelete = new Button("Ištrinti");
        btnDelete.setMinWidth(80);
        Button btnUpdate = new Button("Atnaujinti");
        btnUpdate.setMinWidth(80);
        Button btnSearch = new Button("Ieškoti");
        btnSearch.setMinWidth(80);

        //mygtuku Gridpane
        GridPane gpAtsiliepimuMygtukai = new GridPane();
        gpAtsiliepimuMygtukai.add(btnAdd, 0, 0);
        gpAtsiliepimuMygtukai.add(btnDelete, 1, 0);
        gpAtsiliepimuMygtukai.add(btnUpdate, 2, 0);
        gpAtsiliepimuMygtukai.add(btnSearch, 3, 0);

        HBox hbDashboardText = new HBox();//pavadinimo eilute virsuje
        //hbDashboardText.setPadding(new Insets(10, 10, 10, 10));

        //drop shadow efektas tik antrastes tekstui apsirasomas
        DropShadow dropshadow = new DropShadow();
        dropshadow.setOffsetX(5);
        dropshadow.setOffsetY(5);

        hbDashboardText.setPadding(new Insets(10, 10, 10, 10));
        hbDashboardText.setAlignment(Pos.CENTER);
        Text txtDashboard = new Text("Atsiliepimų registracijos ir paieskos sistema");
        txtDashboard.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        txtDashboard.setEffect(dropshadow);//dropshadow efektas panaudojamas

        hbDashboardText.getChildren().add(txtDashboard);
        // sonine ivedimo lenta
        this.gpAtsiliepimuInfo = new GridPane();
        gpAtsiliepimuInfo.add(lblId, 0, 0);
        gpAtsiliepimuInfo.add(tfId, 1, 0);
        gpAtsiliepimuInfo.add(lblMiestas, 0, 1);
        gpAtsiliepimuInfo.add(tfMiestas, 1, 1);
        gpAtsiliepimuInfo.add(lblVardas, 0, 2);
        gpAtsiliepimuInfo.add(tfVardas, 1, 2);
        gpAtsiliepimuInfo.add(lblElPastas, 0, 3);
        gpAtsiliepimuInfo.add(tfElPastas, 1, 3);
        gpAtsiliepimuInfo.add(lblAtsiliepimas, 0, 4);
        gpAtsiliepimuInfo.add(tfAtsiliepimas, 1, 4);

        gpAtsiliepimuInfo.add(gpAtsiliepimuMygtukai, 0, 7, 2, 1);
        gpAtsiliepimuInfo.setPadding(new Insets(10, 10, 10, 10));
        gpAtsiliepimuInfo.setVgap(10);
        gpAtsiliepimuInfo.setHgap(10);

        bpRoot.setTop(hbDashboardText);
        bpRoot.setCenter(gpAtsiliepimuInfo);
        bpRoot.setRight(table);


        //susiejimas su style.css
        gpAtsiliepimuInfo.setId("gridPane");
        bpRoot.setId("borderPane");
        btnAdd.setId("buttons");
        btnDelete.setId("buttons");
        btnSearch.setId("buttons");
        btnUpdate.setId("buttons");


        //mygtuku action
        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (isValidInput("add")) {
                    Atsiliepimas atsiliepimai = new Atsiliepimas(tfMiestas.getText().toString(),
                            tfVardas.getText().toString(),
                            tfElPastas.getText().toString(), tfAtsiliepimas.getText().toString());
                    atsiliepimaiDao.addAtsiliepimas(atsiliepimai);
                    // isvalyti table ir sudeti is duombazes su naujai ideta reiksme
                    table.getItems().clear();
                    atsiliepimaiDao.showAtsiliepimai(data);
                }
            }
        });

        btnUpdate.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (isValidInput("update")) {
                    Atsiliepimas atsiliepimai = new Atsiliepimas(Integer.parseInt(tfId.getText().toString()),
                            tfMiestas.getText().toString(), tfVardas.getText().toString(),
                            tfElPastas.getText().toString(), tfAtsiliepimas.getText().toString());
                    for (int i = 0; i < data.size(); i++) {
                        if (atsiliepimai.getId() == data.get(i).getId()) {
                            atsiliepimaiDao.updateAtsiliepimai(atsiliepimai);
                            table.getItems().clear();
                            atsiliepimaiDao.showAtsiliepimai(data);
                        }
                    }
                }
            }
        });

            btnSearch.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event){
                    if(isValidInput("search")){
                        ObservableList<Atsiliepimas> dataSearch =
                                FXCollections.observableArrayList();

                        for(Atsiliepimas atsiliepimai : data){
                            if(atsiliepimai.getVardas().matches(".*"+tfVardas.getText().toString()+".*")){
                                dataSearch.add(atsiliepimai);
                            }
                        }
                        data.clear();
                        data.addAll(dataSearch);
                    }
                }
            });


        btnDelete.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
               isValidInput("delete");
                for (int i = 0; i < data.size(); i++) {
                    if (data.get(i).getId() == Integer.parseInt(tfId.getText())) {
                        atsiliepimaiDao.deleteAtsiliepimas(Integer.parseInt(tfId.getText()));
                        table.getItems().clear();
                        atsiliepimaiDao.showAtsiliepimai(data);
                    }
                }
            }
        });
    }


    private boolean isValidInput(String action) {
        switch (action) {
            case "delete":
                if (!Validation.isValidID(tfId.getText().toString())) {
                    showAlert(Alert.AlertType.ERROR, gpAtsiliepimuInfo.getScene().getWindow(), "Form Klaida!", "Neteisingas ID formatas");
                    return false;
                } else {
                    return true;
                }

            case "search":
                if (!Validation.isValidMiestas(tfVardas.getText().toString())) {
                    showAlert(Alert.AlertType.ERROR, gpAtsiliepimuInfo.getScene().getWindow(), "Form Klaida!", "Blogai įvestas miestas,\n" +
                            "Pavadinima gali sudaryti tik raides");
                    return false;
                } else {
                    return true;
                }

            default: // updatui ir naujo kurimui
                if (!Validation.isValidMiestas(tfMiestas.getText().toString())) {
                    showAlert(Alert.AlertType.ERROR, gpAtsiliepimuInfo.getScene().getWindow(), "Form Klaida!", "Blogai įvestas miesto pavadinimas \n" +
                            "Pavadinima gali sudaryti tik raides");
                    return false;
                } else if (!Validation.isValidVardas(tfVardas.getText().toString())) {
                    showAlert(Alert.AlertType.ERROR, gpAtsiliepimuInfo.getScene().getWindow(), "Form Klaida!", "Nurodykite savo varda");
                    return false;
                } else if (!Validation.isValidElPastas(tfElPastas.getText().toString())) {
                    showAlert(Alert.AlertType.ERROR, gpAtsiliepimuInfo.getScene().getWindow(), "Form Klaida!", "Nurodykite gera el. pašto adresą");
                    return false;
                } else if (!Validation.isValidAtsiliepimas(tfAtsiliepimas.getText().toString())) {
                    showAlert(Alert.AlertType.ERROR, gpAtsiliepimuInfo.getScene().getWindow(), "Form Klaida!", "Įrašykite savo atsiliepimą");
                    return false;
                } else
                return true;
        }
    }

    private void showAlert(Alert.AlertType alerType, Window owner, String title, String message){
        Alert alert = new Alert(alerType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}
