package live.kavinduj.theserenitymhtc.bo.custom.impl;



import live.kavinduj.theserenitymhtc.bo.custom.TherapySessionBO;
import live.kavinduj.theserenitymhtc.dto.TherapySessionDTO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TherapySessionBOImpl implements TherapySessionBO {


    @Override
    public boolean save(TherapySessionDTO therapySession) {
        return false;
    }

    @Override
    public boolean update(TherapySessionDTO therapySession) {
        return false;
    }

    @Override
    public boolean deleteByPK(String pk) throws Exception {
        return false;
    }

    @Override
    public List<TherapySessionDTO> getAll() {
        return List.of();
    }

    @Override
    public Optional<TherapySessionDTO> findByPK(String pk) {
        return Optional.empty();
    }

    @Override
    public Optional<String> getLastPK() {
        return Optional.empty();
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
