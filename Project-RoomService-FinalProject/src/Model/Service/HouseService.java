package Model.Service;

import Model.House.House;
import Model.House.HouseDao;
import Model.House.HouseDaoImpl;
import java.util.ArrayList;

/**
 *
 * @author PIYATHIDATHANEEWAN
 */
public class HouseService {

    private final HouseDao houseDaoImpl = new HouseDaoImpl();

    public int createHouse(House house) {
        return houseDaoImpl.createHouse(house);
    }

    public House getHouseById(int houseId) {
        return houseDaoImpl.getHouseById(houseId);
    }

    public ArrayList<House> getAllHouse() {
        return houseDaoImpl.getAllHouse();
    }

    public int updateHouse(House house) {
        return houseDaoImpl.updateHouse(house);
    }

    public int deleteHouse(int houseId) {
        return houseDaoImpl.deleteHouse(houseId);
    }

}
