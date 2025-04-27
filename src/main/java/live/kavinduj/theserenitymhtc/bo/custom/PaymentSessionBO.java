package live.kavinduj.theserenitymhtc.bo.custom;


import live.kavinduj.theserenitymhtc.bo.SuperBO;
import live.kavinduj.theserenitymhtc.dto.PaymentDTO;
import live.kavinduj.theserenitymhtc.dto.TherapySessionDTO;

public interface PaymentSessionBO extends SuperBO {
    void saveSession(TherapySessionDTO therapySessionDTO, PaymentDTO paymentDTO);
    void updateSession(String sessionId, String paymentId);
}