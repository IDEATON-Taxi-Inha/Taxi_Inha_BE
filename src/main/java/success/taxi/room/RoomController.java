package success.taxi.room;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import success.taxi.user.User;

import java.util.ArrayList;
import java.util.List;

// ****일단은 서비스 단에서 구현할 내용들도 controller에 적겠슴둥***

@RestController
@RequiredArgsConstructor
@RequestMapping("/room")
public class RoomController {
    @Autowired
    RoomRepository roomRepository;

    //등록된 게시글들 조회
    @GetMapping("/list")
    public List<Room> list(){
        return roomRepository.findAll();
    }


    //게시글 등록
    @PostMapping("/create")
    public Long create(@RequestBody Room room){
        roomRepository.save(room);
        return room.getRoomId();
    }

    //게시글 삭제
    //???이것두 작성자만 삭제할 수 있게 하는 건
    @DeleteMapping(value = "/delete/{room_id}")
    public void delete(@PathVariable Long room_id) {
        roomRepository.deleteById(room_id);
    }

}
