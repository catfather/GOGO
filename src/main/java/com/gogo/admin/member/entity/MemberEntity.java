package com.gogo.admin.member.entity;


import com.gogo.admin.member.dto.request.CreateMember;
import com.gogo.admin.utill.BaseEntity;
import com.gogo.admin.utill.Role;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "member_tb")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MemberEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    @Column(unique = true)
    private String phone;

    private String address;

    @Column(unique = true)
    private String nickname;

    private String gender;

    private String birth;

    @Enumerated(EnumType.STRING)
    private Role role;

    public MemberEntity(Long memberId) {
        this.id = memberId;
    }

    //회원 가입
    public MemberEntity(CreateMember member) {
        this.name = member.getName();
        this.email = member.getEmail();
        this.password = member.getPassword();
        this.phone = member.getPhone();
        this.address = member.getAddress();
        this.birth = member.getBirth();
        this.nickname = member.getNickname();
        this.role = member.getRole();
        this.gender = member.getGender();
    }
}
