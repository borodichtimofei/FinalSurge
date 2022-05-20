package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
    String firstName;
    String lastName;
    String emailAddress;
    String timeZone;
    String password;
    String reTypePassword;
}
