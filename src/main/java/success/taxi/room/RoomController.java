package success.taxi.room;

import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.web.bind.annotation.*;

import success.taxi.user.User;
import success.taxi.user.UserRepository;



import java.util.List;

import java.util.Map;

import java.util.Optional;


// ****일단은 서비스 단에서 구현할 내용들도 controller에 적겠슴둥***

@RestController
@RequiredArgsConstructor
@RequestMapping("/room")
public class RoomController {
    @Autowired
    RoomRepository roomRepository;

    @Autowired
    UserRepository userRepository;

    //등록된 게시글들 조회
    @GetMapping("/list")
    public List<Room> list(){
        return roomRepository.findAll();
    }

    //방 확인
    @GetMapping("/{roomId}")
    public Optional<Room> findRoom(@PathVariable Long roomId){
        return roomRepository.findById(roomId);
    }

    //게시글 등록
    @PostMapping("/create")
    public Long create(@RequestBody Room room, @RequestHeader Map<String, String> headers) {

        //헤더에 저장된 hostid값 받아와서 찾기
        String num = headers.get("hostid");
        Long Hid = Long.parseLong(num);
        User user = userRepository.findById(Hid).orElse(null);

        //설정값 저장해주고 저장
        room.setHostId(user);
        room.setStatus("ACTIVE");
        roomRepository.save(room);

        return 1L;
    }

    //게시글 삭제
    @DeleteMapping(value = "/{room_id}")
    public String delete(@PathVariable Long room_id) {

        //일단 간단하게 인증없이 삭제되게함
        roomRepository.deleteById(room_id);
        return "";
    }
}
