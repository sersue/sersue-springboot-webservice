package com.sersue.book.springboot.domain;

import jdk.vm.ci.meta.Local;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//JPA Auditing으로 entity 데이터의 생성시간,수정시간 포함하기
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/*
* @MappedSuperclass: JAP Entity 클래스들이 BaseTimeEntity을 상속할 경우 필드들 (createdDate,modifiedDate)도 칼럼으로 인힉
* @EntityListeners : BaseTimeEntity 클래스에 Auditing 기능 포함
* @CreatedDate : Entity 생성되어 저장될때 시간 자동저장
* @LastModifiedDate :조회한 Entity 값을 변경할때 시간 자동저
 */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {
    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

}
