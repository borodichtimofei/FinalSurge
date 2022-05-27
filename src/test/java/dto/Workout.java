package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Workout {
    String date;
    String timeOfDay;
    String name;
    String description;
    String minHR;
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
