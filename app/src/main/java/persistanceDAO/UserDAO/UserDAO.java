package persistanceDAO.UserDAO;

import java.util.List;

import model.user.User;
import persistanceDAO.DAO;

/**
 * Created by boscalent on 04/11/2016.
 */

public interface UserDAO extends DAO {
    public long insertUser(User user);
    public boolean updateUser(User user);
    public boolean deleteUser(User user);

    public List<User> findUsersByProperty(UserSearchType searchType, Object user);
    public List<User> findAll();
}
