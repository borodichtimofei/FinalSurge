package dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(exclude = {"date", "timeOfDay", "duration", "elevationGain", "elevationGainType",
        "elevationLoss", "elevationLossType", "perceivedEffort", "avgPower", "maxPower",
        "avgCadence", "maxCadence", "hrMax"})
public class Workout {
    String date;
    String timeOfDay;
    String name;
    String description;
    String distance;
    String distanceType;
    String duration;
    String elevationGain;
    String elevationGainType;
    String elevationLoss;
    String elevationLossType;
    String perceivedEffort;
    String avgPower;
    String maxPower;
    String avgCadence;
    String maxCadence;
    String hrMin;
    String hrAvg;
    String hrMax;
    String caloriesBurned;
    String howIFeltType;
}
