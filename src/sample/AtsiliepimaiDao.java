package sample;

import javafx.collections.ObservableList;

import java.sql.*;


public class AtsiliepimaiDao {

        public void addAtsiliepimas(Atsiliepimas atsiliepimas) {
            String sql = "INSERT INTO `atsiliepimai`"
                    + "(`miestas`, `vardas`, `elpastas`, `atsiliepimas`)"
                    + " VALUES (?, ?, ?, ?)";
            try {
                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atsiliepimai", "root", "");
                PreparedStatement add = myConn.prepareStatement(sql);
                add.setString(1, atsiliepimas.getMiestas());
                add.setString(2, atsiliepimas.getVardas());
                add.setString(3, atsiliepimas.getElpastas());
                add.setString(4, atsiliepimas.getAtsiliepimas());

                add.execute();
                add.close();
            } catch (Exception exc) {
                exc.printStackTrace();

            }
        }

        public void showAtsiliepimai(ObservableList<Atsiliepimas> data) {
            String query = "SELECT * FROM atsiliepimai";
            try {
                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atsiliepimai", "root", "");
                PreparedStatement add = myConn.prepareStatement(query);
                ResultSet rs = add.executeQuery();
                while (rs.next()) {
                    data.add(new Atsiliepimas(
                            rs.getInt("ID"),
                            rs.getString("Miestas"),
                            rs.getString("Vardas"),
                            rs.getString("elpastas"),
                            rs.getString("Atsiliepimas")
                    ));
                }

            } catch (Exception exc) {
                exc.printStackTrace();

            }
        }

        public void updateAtsiliepimai(Atsiliepimas atsiliepimas) {
            try {
                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atsiliepimai",
                        "root", "");
                PreparedStatement upd = myConn.prepareStatement("UPDATE atsiliepimai SET miestas = ?, vardas = ?, elpastas= ?, atsiliepimas = ? WHERE id = ?");
                upd.setString(1, atsiliepimas.getMiestas());
                upd.setString(2, atsiliepimas.getVardas());
                upd.setString(3, atsiliepimas.getElpastas());
                upd.setString(4, atsiliepimas.getAtsiliepimas());
                upd.setInt(5, atsiliepimas.getId());
                upd.executeUpdate();
                upd.close();
            } catch (Exception exc) {
                exc.printStackTrace();

            }
        }


        public void deleteAtsiliepimas(int id) {
            try {
                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atsiliepimai", "root", "");
                PreparedStatement del = myConn.prepareStatement("delete FROM atsiliepimai WHERE id = ?");
                del.setInt(1, id);
                del.executeUpdate();
            } catch (Exception exc) {
                exc.printStackTrace();

            }
        }
    }

