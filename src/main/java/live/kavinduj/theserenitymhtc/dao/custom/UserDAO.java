package live.kavinduj.theserenitymhtc.dao.custom;

import live.kavinduj.theserenitymhtc.dao.CrudDAO;
import live.kavinduj.theserenitymhtc.entity.User;

public interface UserDAO extends CrudDAO<User,String> {
    boolean cheackUser(String email);
    User getSelectUser(String userName);
}
