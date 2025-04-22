package live.kavinduj.theserenitymhtc.dao.custom;

import live.kavinduj.theserenitymhtc.dao.CrudDAO;
import live.kavinduj.theserenitymhtc.entity.Patient;

import java.util.ArrayList;

public interface PatientDAO extends CrudDAO<Patient,String> {
    ArrayList<String> patientList();
    Patient getAllPatient(String patientName);
}
