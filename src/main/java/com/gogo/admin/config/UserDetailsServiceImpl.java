package com.gogo.admin.config;

import com.gogo.admin.member.entity.MemberEntity;
import com.gogo.admin.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    // username -> DB 데이터를 비교
    private final MemberRepository memberRepository;

    @Override                        // username -> 사용 요청 아이디(email) ,UNIQUE
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        MemberEntity memberEntity = memberRepository.findByEmail(email).orElseThrow(() -> {
            throw new UsernameNotFoundException("이메일이 존재 하지 않습니다.");
        });


        return new UserDetails(memberEntity);

    }


}