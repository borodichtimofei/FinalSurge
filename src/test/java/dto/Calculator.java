package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Calculator {
    String distance;
    String typeDistance;
    String raceDistance;
    String hours;
    String minutes;
    String seconds;
}
