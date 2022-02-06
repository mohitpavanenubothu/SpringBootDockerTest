package com.sbms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BOOT_STUDENT")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sid")
	private Integer stdId;

	@Column(name = "sname", length = 20)
	private String stdName;

	@Column(name = "sfee")
	private Double stdFee;

	@Column(name = "scourse")
	private String stdCourse;

	@Column(name = "sfeedisc")
	private Double stdFeeDisc;

	@Column(name = "sfeegst")
	private Double stdFeeGst;

}
