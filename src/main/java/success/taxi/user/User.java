package success.taxi.user;


import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import success.taxi.room.Room;

import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="\"User\"")
public class User{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long userId;

    @ColumnDefault("nickname")
    private String nickname;

    @ColumnDefault("male")
    private String gender;

}
