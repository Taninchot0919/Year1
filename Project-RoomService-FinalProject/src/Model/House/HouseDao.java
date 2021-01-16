package Model.House;

import Model.Account.Account;
import java.util.ArrayList;

/**
 *
 * @author PIYATHIDATHANEEWAN
 */
public interface HouseDao {

    public int createHouse(House house);

    public House getHouseById(int house);

    public ArrayList<House> getAllHouse();

    public int updateHouse(House house);

    public int deleteHouse(int house);

}
