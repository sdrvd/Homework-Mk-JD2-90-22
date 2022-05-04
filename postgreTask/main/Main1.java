package postgreTask.main;

import postgreTask.dao.AirportsDao;

public class Main1 {
    public static void main(String[] args) {
        AirportsDao dao = new AirportsDao();
        dao.airportsFromDataBase("Москва");
    }
}
