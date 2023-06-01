package com.book.project.domain.Service;

import com.book.project.domain.Entity.Member;
import com.book.project.domain.Repository.UserRepository;
import org.springframework.stereotype.Service;
import org.mindrot.jbcrypt.BCrypt;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Member getUserById(String id) {
        return userRepository.findById(id);
    }

    public boolean authenticateUser(String id, String pw) {
        // 사용자의 아이디와 비밀번호를 확인하여 인증 여부를 판단하는 로직을 구현합니다.
        // 예를 들어, 데이터베이스에서 사용자 정보를 조회하여 비밀번호를 확인할 수 있습니다.

        // 사용자 정보 조회
        Member user = this.getUserById(id);

        // 사용자가 존재하고, 비밀번호가 일치하는지 확인
        if (user != null && checkPassword(pw, user.getPw())) {
            return true; // 인증 성공
        }

        return false; // 인증 실패
    }

    private boolean checkPassword(String plainPassword, String hashedPassword) {
        // 비밀번호 해싱 알고리즘을 사용하여 입력된 비밀번호와 저장된 해시된 비밀번호를 비교합니다.
        // 예를 들어, BCrypt 해시 알고리즘을 사용할 수 있습니다.
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }

    public Member createUser(Member member) {
        // 입력값의 유효성 검사
        if (!isValidUser(member)) {
            throw new IllegalArgumentException("Invalid member information.");
        }

        // 동일한 ID의 회원이 이미 존재하는지 확인
        if (userRepository.existsById(member.getId())) {
            throw new IllegalArgumentException("This member already exists.");
        }

        // 비밀번호를 해싱하여 저장
        String hashedPw = hashPw(member.getPw());
        member.setPw(hashedPw);

        // 회원 저장
        return userRepository.save(member);
    }

    public boolean isValidUser(Member user) {
        // 유효성 검사 로직을 구현합니다.
        // 예를 들어, 비밀번호의 길이를 확인할 수 있습니다.
        return isValidPw(user.getPw());
    }

    public boolean isValidPw(String pw) {
        // 비밀번호의 최소 길이와 특수 문자 포함 여부를 확인합니다.
        return pw.length() >= 8 && pw.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");
    }

    public String hashPw(String pw) {
        // 비밀번호를 해싱하여 반환하는 로직을 구현합니다.
        // 예를 들어, BCrypt 알고리즘 등을 사용하여 비밀번호를 해싱할 수 있습니다.
        return BCrypt.hashpw(pw, BCrypt.gensalt());
    }

}