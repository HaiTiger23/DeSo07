package htg.haitran.deso07;

public class Weather {
    private String city;
    private int nhietdo;

    public Weather(String city, int nhietdo) {
        this.city = city;
        this.nhietdo = nhietdo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNhietdo() {
        return nhietdo;
    }

    public void setNhietdo(int nhietdo) {
        this.nhietdo = nhietdo;
    }
}
