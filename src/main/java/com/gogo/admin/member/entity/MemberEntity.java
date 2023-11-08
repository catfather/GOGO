package com.gogo.admin.member.entity;


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
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    private String phone;

    private String address;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String profileImage;

    public MemberEntity(Long memberId) {
    }
}
