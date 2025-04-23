package live.kavinduj.theserenitymhtc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TherapyProgramDTO {
    private String programId;
    private String name;
    private String duration;
    private double fee;

}
