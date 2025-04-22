package live.kavinduj.theserenitymhtc.dao.custom;



import live.kavinduj.theserenitymhtc.dao.CrudDAO;
import live.kavinduj.theserenitymhtc.entity.Therapist;

import java.util.ArrayList;

public interface TherapistDAO extends CrudDAO<Therapist,String> {
    ArrayList<String> therapistList();
    Therapist getAllTherapist(String therapistName);
}
