package success.taxi.paticipant;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/participant")
public class ParticipantController {

    @Autowired
    ParticipantRepository participantRepository;

    //등록된 게시글들 조회
    @GetMapping("/list")
    public List<Participant> list(){
        return participantRepository.findAll();
    }


    //게시글 등록
    @PostMapping("/create")
    public Long create(Participant participant){
        participantRepository.save(participant);
        return participant.getParticipant_id();
    }
}
