package success.taxi.paticipant;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import success.taxi.room.Room;
import success.taxi.user.User;

import java.util.Collection;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long participant_id;


    @JsonBackReference //양방향 관계에서 역방향(부모->자식) 참조로 어노테이션을 추가하면 직렬화에서 제외된다
    @ManyToOne
    @JoinColumn(name= "room_id")
    private Room room;

    //외래키
    @ManyToOne
    @JoinColumn(name= "user_id")
    private User user_id;


}
