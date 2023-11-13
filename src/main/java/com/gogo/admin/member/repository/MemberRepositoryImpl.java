package com.gogo.admin.member.repository;

import com.gogo.admin.member.dto.request.MemberSearchCriteria;
import com.gogo.admin.member.dto.response.MemberListRes;
import com.gogo.admin.member.dto.response.QMemberListRes;
import com.gogo.admin.member.entity.MemberEntity;
import com.gogo.admin.member.entity.QMemberEntity;
import com.gogo.admin.utill.Role;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberCustomRepository {

    private final JPAQueryFactory queryFactory;

    QMemberEntity memberEntity = QMemberEntity.memberEntity;

    @Override
    public List<MemberListRes> findAllMemberByCriteria(MemberSearchCriteria criteria, Pageable page) {
        return queryFactory.select(
                        new QMemberListRes(
                                memberEntity.name,
                                memberEntity.email,
                                memberEntity.phone,
                                memberEntity.gender,
                                memberEntity.role,
                                memberEntity.id
                        )
                )
                .from(memberEntity)
                .where(
                        IdEq(criteria.getId()),
                        NameEq(criteria.getName()),
                        EmailEq(criteria.getEmail()),
                        PhoneEq(criteria.getPhone()),
                        AddressCt(criteria.getAddress()),
                        NicknameEq(criteria.getNickName()),
                        GenderEq(criteria.getGender()),
                        RoleEq(criteria.getRole())
                )
                .fetch();
    }

    private BooleanExpression RoleEq(Role role) {
        return role != null ? memberEntity.role.eq(role) : null;
    }

    private BooleanExpression GenderEq(String gender) {
        return gender != null ? memberEntity.gender.eq(gender) : null;
    }

    private BooleanExpression NicknameEq(String nickname) {
        return nickname != null ? memberEntity.nickname.eq(nickname) : null;
    }

    private BooleanExpression AddressCt(String address) {
        return address != null ? memberEntity.address.contains(address) : null;
    }

    private BooleanExpression PhoneEq(String phone) {
        return phone != null ? memberEntity.phone.eq(phone) : null;
    }

    private BooleanExpression EmailEq(String email) {
        return email != null ? memberEntity.email.eq(email) : null;
    }

    private BooleanExpression NameEq(String name) {
        return name != null ? memberEntity.name.eq(name) : null;
    }

    private BooleanExpression IdEq(Long id) {
        return id != null ? memberEntity.id.eq(id) : null;
    }

}
