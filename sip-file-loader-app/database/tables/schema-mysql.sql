DROP TABLE  IF EXISTS people;
CREATE  TABLE people (
  person_id BIGINT AUTO_INCREMENT PRIMARY KEY ,
  first_name VARCHAR (20),
  last_name VARCHAR (20)
);


DROP TABLE  IF EXISTS provider;
CREATE  TABLE provider (
  prv_id INT AUTO_INCREMENT PRIMARY KEY,
  prv_npi VARCHAR(30)  NOT NULL,
  prv_tin VARCHAR(30)  NOT NULL,
  prv_title_degree VARCHAR (30),
  prv_first_name VARCHAR (30) NOT NULL,
  prv_middle_name VARCHAR (30),
  prv_last_name VARCHAR (30) NOT NULL,
  prv_network_name VARCHAR (100) NOT NULL,
  Network_start_date DATE NOT NULL,
  Network_end_date DATE NOT NULL,
  prv_phone VARCHAR(30),
  prv_PCP_status VARCHAR(30) NOT NULL,
  prv_speciality_1_code VARCHAR(30) NOT NULL,
  prv_specialty_1_desc VARCHAR(30) NOT NULL,
  prv_street_1 VARCHAR(30) NOT NULL,
  prv_street_2 VARCHAR(30) ,
  prv_city VARCHAR(30) NOT NULL,
  prv_county VARCHAR(30) NOT NULL,
  prv_state VARCHAR(30) NOT NULL,
  prv_zip INT NOT NULL,
  prv_new_patients VARCHAR(30),
  prv_practice_Name VARCHAR(30) NOT NULL,
  prv_practice_Tin VARCHAR(30) NOT NULL
);

DROP TABLE  IF EXISTS claims;

CREATE TABLE claims (
  claim_No INT AUTO_INCREMENT PRIMARY KEY,
  claim_id VARCHAR(20)  NOT NULL,
  claim_line_id VARCHAR(20)  NOT NULL,
  mbr_id VARCHAR(20) NOT NULL,
  prv_npi VARCHAR(20) NOT NULL,
  prv_type_desc VARCHAR(20) NOT NULL,
  prv_tin VARCHAR(20) NOT NULL,
  prv_in_network_flag VARCHAR(20),
  svc_pos_code VARCHAR(20) ,
  svc_diag_1_code VARCHAR(20),
  svc_diag_2_code VARCHAR(20),
  svc_diag_3_code VARCHAR(20),
  svc_diag_4_code VARCHAR(20),
  svc_diag_5_code VARCHAR(20),
  svc_diag_6_code VARCHAR(20),
  svc_diag_7_code VARCHAR(20),
  svc_procedure_type VARCHAR(20),
  svc_procedure_code VARCHAR(20) ,
  svc_rev_code VARCHAR(20) NOT NULL,
  svc_cpt_code VARCHAR(20) NOT NULL,
  svc_icd_proc_1_code VARCHAR(20),
  svc_icd_proc_2_code VARCHAR(20),
  svc_icd_proc_3_code VARCHAR(20),
  svc_icd_proc_4_code VARCHAR(20),
  svc_icd_proc_5_code VARCHAR(20),
  svc_modifier_code VARCHAR(20) ,
  svc_tos_code VARCHAR(20) NOT NULL,
  svc_ip_days VARCHAR(20) NOT NULL,
  svc_admit_type VARCHAR(20) NOT NULL,
  svc_service_frm_date VARCHAR(20) NOT NULL,
  svc_service_to_date VARCHAR(20) NOT NULL,
  Paid_date VARCHAR(20) NOT NULL,
  Allowed_amt VARCHAR(20) NOT NULL,
  Paid_amt VARCHAR(20) NOT NULL,
  Pay_type VARCHAR(20),
  bill_type_code VARCHAR(20) NOT NULL
);

DROP TABLE  IF EXISTS member;
CREATE TABLE member(
  member_id INT AUTO_INCREMENT PRIMARY KEY,
  person_id VARCHAR(20),
  mbr_gender VARCHAR(20),
  mbr_birthyear VARCHAR(20),
  mbr_county VARCHAR(20),
  mbr_zip VARCHAR(20),
  mbr_state VARCHAR(20),
  plan_type_code VARCHAR(20) NOT NULL,
  plan_type_desc VARCHAR(250) NOT NULL,
  med_eff_date VARCHAR(20) NOT NULL,
  med_term_date VARCHAR(20) NOT NULL,
  prv_pcp_npi VARCHAR(20) NOT NULL,
  mbr_Riskscore VARCHAR(20) NOT NULL

);

DROP TABLE  IF EXISTS provider_network;
CREATE TABLE provider_network(
  prv_network_id INT AUTO_INCREMENT PRIMARY KEY,
  prv_npi VARCHAR(20) NOT NULL,
  prv_tin VARCHAR(20) NOT NULL,
  prov_spec VARCHAR(20) NOT NULL,
  prv_network_name VARCHAR(30) NOT NULL,
  network_start_date DATE NOT NULL,
  network_end_date DATE NOT NULL
);