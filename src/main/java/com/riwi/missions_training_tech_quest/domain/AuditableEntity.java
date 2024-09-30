package com.riwi.missions_training_tech_quest.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class AuditableEntity {
  @CreatedDate
  @Column(columnDefinition = "DATETIME(6) DEFAULT CURRENT_TIMESTAMP(6)")
  private LocalDateTime createdAt;

  @LastModifiedDate
  @Column(columnDefinition = "DATETIME(6) DEFAULT CURRENT_TIMESTAMP(6)")
  private LocalDateTime updatedAt;

  @CreatedBy
  @OneToOne
  private UserEntity createdBy;

  @LastModifiedBy
  @OneToOne
  private UserEntity modifiedBy;
}