package live.kavinduj.theserenitymhtc.dao.custom;

import live.kavinduj.theserenitymhtc.dao.CrudDAO;
import live.kavinduj.theserenitymhtc.entity.TherapyProgram;

import java.util.ArrayList;

public interface TherapyProgramDAO extends CrudDAO<TherapyProgram,String> {
    ArrayList<String> getProgramList();
    TherapyProgram getAllTherapyProgram(String programName);
}
