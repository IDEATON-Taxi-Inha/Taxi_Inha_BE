package success.taxi.room;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import success.taxi.paticipant.Participant;
import success.taxi.user.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    @GeneratedValue(strategy = IDENTITY)
    @Id
    private Long roomId;

    //외래키
    @OneToOne
    @JoinColumn(name= "host_id")
    private User hostId;

    //몇명까지 가능인지
    @ColumnDefault("4")
    private Integer maxnum;

    @ColumnDefault("INACTIVE")
    private String status;

    @ColumnDefault("주안역")
    private String start;

    @ColumnDefault("인하대후문")
    private String destination;

    @JsonManagedReference //양방향 관계에서 정방향(자식->부모) 참조할 변수에 어노테이션을 추가하면 직렬화에 포함된다
    @OneToMany(mappedBy = "room")
    private List<Participant> participants = new ArrayList<>();
}
