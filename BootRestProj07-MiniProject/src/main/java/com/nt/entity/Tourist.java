package com.nt.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name="REST_TOURIST")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Tourist {
	
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "TID_SEQ",allocationSize = 1,initialValue =1000)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE )
	private Integer tid;
	@NonNull
	@Column(length = 20)
	private String tname;
	
	@NonNull
	@Column(length = 20)
	private String city;
	
	@NonNull
	@Column(length = 20)
	private String packageType;
	
	@NonNull
	private Double budget;
	@NonNull
	private LocalDate startsFrom;
	@NonNull
	private LocalDate endsOn;
	
	
	

}
