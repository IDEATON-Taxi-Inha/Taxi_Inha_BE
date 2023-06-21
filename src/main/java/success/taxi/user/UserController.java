package success.taxi.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import success.taxi.user.User;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/room")
public class UserController {
    private final UserRepository userRepository;

    //등록된 게시글들
    @GetMapping("/list")
    public List<User> list(){
        return userRepository.findAll();
    }

    //user가입
    @PostMapping(value = "/join")
    public String join(User user) {
        userRepository.save(user);
        return user.getNickName();
    }

    //유저 탈퇴 및 학생 신분 아니면 탈퇴
    @DeleteMapping(value = "/delete")
    public String delete(Long user_id) {
        User user = userRepository.findById(user_id).orElse(null);
        if(user == null){
            return "존재하지 않는 아이디입니다.";
        }
        else{
            userRepository.delete(user);
            return "삭제";
        }
    }
}