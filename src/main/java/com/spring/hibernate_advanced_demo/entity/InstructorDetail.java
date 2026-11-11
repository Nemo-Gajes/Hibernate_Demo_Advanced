package com.spring.hibernate_advanced_demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "subject")
  private String subject;

  @Column(name = "hobby")
  private String hobby;

  public InstructorDetail() {

  }

  public InstructorDetail(String subject, String hobby) {
    this.subject = subject;
    this.hobby = hobby;
  }

  // ===== 1st =====
  // @OneToOne(mappedBy = "instructorDeets", cascade = CascadeType.ALL)
  // private Instructor instructor;

  @OneToOne(mappedBy = "instructorDeets", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  private Instructor instructor;

  public Instructor getInstructor() {
    return instructor;
  }

  public void setInstructor(Instructor instructor) {
    this.instructor = instructor;
  }

  @Override
  public String toString() {
    return "InstructorDetail [id=" + id +
        ", subject=" + subject +
        ", hobby=" + hobby + "]";
  }

}
