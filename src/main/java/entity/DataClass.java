package entity;

import org.springframework.data.annotation.Id;

public class DataClass {
    @Id
    private String sensore;
    private Integer valore;

    public String getSensore() {
        return sensore;
    }

    public void setSensore(String sensore) {
        this.sensore = sensore;
    }

    public Integer getValore() {
        return valore;
    }

    public void setValore(Integer valore) {
        this.valore = valore;
    }
}
