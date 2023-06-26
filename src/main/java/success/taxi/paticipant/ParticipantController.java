package success.taxi.paticipant;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import success.taxi.room.Room;
import success.taxi.room.RoomRepository;
import success.taxi.user.User;
import success.taxi.user.UserRepository;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/participant")
public class ParticipantController {

    @Autowired
    ParticipantRepository participantRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoomRepository roomRepository;

    //등록된 게시글들 조회
    @GetMapping("/list")
    public List<Participant> list(){
        return participantRepository.findAll();
    }


    //게시글 등록
    @PostMapping("/create")
    public Long create(@RequestHeader Map<String, String> headers){

        //헤더에 저장된 userid 받아와서 찾기
        String num1 = headers.get("userid");
        Long Uid = Long.parseLong(num1);
        User user = userRepository.findById(Uid).orElse(null);

        //헤더에 저장된 roomid 받아와서 찾기
        String num2 = headers.get("roomid");
        Long Rid = Long.parseLong(num2);
        Room room = roomRepository.findById(Rid).orElse(null);


        //설정값 저장해주고 저장
        Participant participant = new Participant();
        participant.setUser_id(user);
        participant.setRoom(room);
        participantRepository.save(participant);

        return 1L;
    }
}
