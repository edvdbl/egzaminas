package sample;

public class Atsiliepimas {
    private Integer id;
    private String miestas;
    private String vardas;
    private String elpastas;
    private String atsiliepimas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMiestas() {
        return miestas;
    }

    public void setMiestas(String miestas) {
        this.miestas = miestas;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getElpastas() {
        return elpastas;
    }

    public void setElpastas(String elpastas) {
        this.elpastas = elpastas;
    }

    public String getAtsiliepimas() {
        return atsiliepimas;
    }

    public void setAtsiliepimas(String atsiliepimas) {
        this.atsiliepimas = atsiliepimas;
    }

    public Atsiliepimas (int id, String miestas, String vardas, String elpastas, String atsiliepimas){
        this.id = id;
        this.miestas = miestas;
        this.vardas = vardas;
        this.elpastas = elpastas;
        this.atsiliepimas = atsiliepimas;
    }

    public Atsiliepimas (String miestas, String vardas, String elpastas, String atsiliepimas){
        this.miestas = miestas;
        this.vardas = vardas;
        this.elpastas = elpastas;
        this.atsiliepimas = atsiliepimas;
    }
    public Atsiliepimas(){

    }
}
