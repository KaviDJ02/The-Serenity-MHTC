package live.kavinduj.theserenitymhtc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "patients")
public class Patient implements SuperEntity{

    @Id
    private String id;
    private String name;
    private String contactInfo;
    private String gender;
    private String birthDate;

    @OneToMany(mappedBy = "patient")
    private List<TherapySession> therapySessions;
}
