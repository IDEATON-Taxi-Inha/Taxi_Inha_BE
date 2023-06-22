package success.taxi.room;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import static jakarta.persistence.GenerationType.IDENTITY;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import success.taxi.user.User;

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
    @ColumnDefault("")
    private Long hostId;

    //외래키
    @ColumnDefault("")
    private Integer participantId;

    //몇명까지 가능인지
    @ColumnDefault("4")
    private Integer maxNum;

    @ColumnDefault("ACTIVE")
    private String status;

    @ColumnDefault("주안역")
    private String start;

    @ColumnDefault("인하대후문")
    private String destination;


}
