package live.kavinduj.theserenitymhtc.bo.custom;

import live.kavinduj.theserenitymhtc.bo.SuperBO;
import live.kavinduj.theserenitymhtc.dto.PatientDTO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface PatientBO extends SuperBO {
    boolean save(PatientDTO patient);
    boolean update(PatientDTO patient);
    boolean deleteByPK(String pk) throws Exception;
    List<PatientDTO> getAll();
    Optional<PatientDTO> findByPK(String pk);
    Optional<String> getLastPK();
    boolean exist(String id) throws SQLException, ClassNotFoundException;
}
