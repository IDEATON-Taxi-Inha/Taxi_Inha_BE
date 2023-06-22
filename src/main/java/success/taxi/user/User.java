package success.taxi.user;


import jakarta.persistence.Entity;
import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long userId;


    @ColumnDefault("nickname")
    private String nickname;

    @ColumnDefault("male")
    private String gender;
}
