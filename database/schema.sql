-- MySQL adaptation of the original Oracle Data Modeler DDL.
-- All assignment attributes remain VARCHAR(40), following the source model.

CREATE TABLE association (
    association_name    VARCHAR(40) NOT NULL,
    building            VARCHAR(40) NOT NULL,
    phone_number        VARCHAR(40) NOT NULL,
    sports_count        VARCHAR(40) NOT NULL,
    sports_name         VARCHAR(40) NOT NULL,
    campus_campus_name  VARCHAR(40) NOT NULL
);

CREATE UNIQUE INDEX association__idxv1 ON
    association (
        campus_campus_name
    ASC );

ALTER TABLE association ADD CONSTRAINT association_pk PRIMARY KEY ( association_name );

CREATE TABLE campus (
    campus_name                   VARCHAR(40) NOT NULL,
    address                       VARCHAR(40) NOT NULL,
    distance_from_center          VARCHAR(40) NOT NULL,
    bus_number                    VARCHAR(40) NOT NULL,
    association_association_name  VARCHAR(40) NOT NULL
);

CREATE UNIQUE INDEX campus__idxv1 ON
    campus (
        association_association_name
    ASC );

ALTER TABLE campus ADD CONSTRAINT campus_pk PRIMARY KEY ( campus_name );

CREATE TABLE commission (
    commission_title                          VARCHAR(40) NOT NULL, 
    university_school_university_school_name  VARCHAR(40) NOT NULL
);

ALTER TABLE commission ADD CONSTRAINT commission_pk PRIMARY KEY ( commission_title );

CREATE TABLE course (
    unique_course_code                           VARCHAR(40) NOT NULL,
    course_title                                 VARCHAR(40) NOT NULL,
    core_course                                  VARCHAR(40) NOT NULL,
    elective_course                              VARCHAR(40) NOT NULL, 
    course_of_study_unique_course_of_study_code  VARCHAR(40) NOT NULL
);

ALTER TABLE course ADD CONSTRAINT course_pk PRIMARY KEY ( unique_course_code );

CREATE TABLE course_of_study (
    unique_course_of_study_code  VARCHAR(40) NOT NULL,
    course_of_study_title        VARCHAR(40) NOT NULL,
    tier                         VARCHAR(40) NOT NULL,
    duration_of_studies          VARCHAR(40) NOT NULL,
    undergraduate_schedule       VARCHAR(40) NOT NULL,
    post_graduate_schedule       VARCHAR(40) NOT NULL,
    department_department_name   VARCHAR(40) NOT NULL
);

ALTER TABLE course_of_study ADD CONSTRAINT course_of_study_pk PRIMARY KEY ( unique_course_of_study_code );

CREATE TABLE department (
    department_name                           VARCHAR(40) NOT NULL,
    building                                  VARCHAR(40) NOT NULL,
    campus_campus_name                        VARCHAR(40) NOT NULL, 
    university_school_university_school_name  VARCHAR(40) NOT NULL
);

ALTER TABLE department ADD CONSTRAINT department_pk PRIMARY KEY ( department_name );

CREATE TABLE instructor (
    instructor_identifier             VARCHAR(40) NOT NULL,
    instructor_fullname               VARCHAR(40) NOT NULL,
    title                             VARCHAR(40) NOT NULL,
    office_number                     VARCHAR(40) NOT NULL,
    department_department_name        VARCHAR(40) NOT NULL, 
    supervisor_supervisor_identifier  VARCHAR(40) NOT NULL
);

ALTER TABLE instructor ADD CONSTRAINT instructor_pk PRIMARY KEY ( instructor_identifier );

CREATE TABLE instructor_commission (
    commission_commission_title       VARCHAR(40) NOT NULL, 
    instructor_instructor_identifier  VARCHAR(40) NOT NULL
);

ALTER TABLE instructor_commission ADD CONSTRAINT instructor_commission_pk PRIMARY KEY ( commission_commission_title,
                                                                                        instructor_instructor_identifier );

CREATE TABLE instructor_course ( 
    instructor_instructor_identifier  VARCHAR(40) NOT NULL,
    course_unique_course_code         VARCHAR(40) NOT NULL
);

ALTER TABLE instructor_course ADD CONSTRAINT instructor_course_pk PRIMARY KEY ( instructor_instructor_identifier,
                                                                                course_unique_course_code );

CREATE TABLE required_course (
    unique_required_course_code  VARCHAR(40) NOT NULL,
    course_unique_course_code    VARCHAR(40) NOT NULL,
    required_course_title        VARCHAR(40) NOT NULL,
    required_core_course         VARCHAR(40) NOT NULL,
    required_elective_course     VARCHAR(40) NOT NULL
);

ALTER TABLE required_course ADD CONSTRAINT required_course_pk PRIMARY KEY ( unique_required_course_code );

CREATE TABLE supervisor (
    supervisor_identifier  VARCHAR(40) NOT NULL,
    supervisor_fullname    VARCHAR(40) NOT NULL
);

ALTER TABLE supervisor ADD CONSTRAINT supervisor_pk PRIMARY KEY ( supervisor_identifier );

CREATE TABLE university_school (
    university_school_name  VARCHAR(40) NOT NULL,
    provost                 VARCHAR(40) NOT NULL,
    building                VARCHAR(40) NOT NULL
);

ALTER TABLE university_school ADD CONSTRAINT university_school_pk PRIMARY KEY ( university_school_name );

CREATE TABLE university_student (
    registration_number                          VARCHAR(40) NOT NULL,
    university_student_fullname                  VARCHAR(40) NOT NULL,
    fathers_name                                 VARCHAR(40) NOT NULL,
    date_of_birth                                VARCHAR(40) NOT NULL,
    year_of_registration                         VARCHAR(40) NOT NULL, 
    course_of_study_unique_course_of_study_code  VARCHAR(40) NOT NULL
);

ALTER TABLE university_student ADD CONSTRAINT university_student_pk PRIMARY KEY ( registration_number );

CREATE TABLE university_student_course ( 
    university_student_registration_number  VARCHAR(40) NOT NULL,
    course_unique_course_code               VARCHAR(40) NOT NULL,
    grade                                   VARCHAR(40) NOT NULL,
    year_of_attendance                      VARCHAR(40) NOT NULL,
    year_of_declaration                     VARCHAR(40) NOT NULL
);

ALTER TABLE university_student_course ADD CONSTRAINT university_student_course_pk PRIMARY KEY ( university_student_registration_number,
                                                                                                course_unique_course_code );

ALTER TABLE association
    ADD CONSTRAINT association_campus_fk FOREIGN KEY ( campus_campus_name )
        REFERENCES campus ( campus_name );

ALTER TABLE campus
    ADD CONSTRAINT campus_association_fk FOREIGN KEY ( association_association_name )
        REFERENCES association ( association_name );

ALTER TABLE commission
    ADD CONSTRAINT commission_university_school_fk FOREIGN KEY ( university_school_university_school_name )
        REFERENCES university_school ( university_school_name );

ALTER TABLE course
    ADD CONSTRAINT course_course_of_study_fk FOREIGN KEY ( course_of_study_unique_course_of_study_code )
        REFERENCES course_of_study ( unique_course_of_study_code );

ALTER TABLE course_of_study
    ADD CONSTRAINT course_of_study_department_fk FOREIGN KEY ( department_department_name )
        REFERENCES department ( department_name );

ALTER TABLE department
    ADD CONSTRAINT department_campus_fk FOREIGN KEY ( campus_campus_name )
        REFERENCES campus ( campus_name );

ALTER TABLE department
    ADD CONSTRAINT department_university_school_fk FOREIGN KEY ( university_school_university_school_name )
        REFERENCES university_school ( university_school_name );

ALTER TABLE instructor_commission
    ADD CONSTRAINT instructor_commission_commission_fk FOREIGN KEY ( commission_commission_title )
        REFERENCES commission ( commission_title );

ALTER TABLE instructor_commission
    ADD CONSTRAINT instructor_commission_instructor_fk FOREIGN KEY ( instructor_instructor_identifier )
        REFERENCES instructor ( instructor_identifier );

ALTER TABLE instructor_course
    ADD CONSTRAINT instructor_course_course_fk FOREIGN KEY ( course_unique_course_code )
        REFERENCES course ( unique_course_code );

ALTER TABLE instructor_course
    ADD CONSTRAINT instructor_course_instructor_fk FOREIGN KEY ( instructor_instructor_identifier )
        REFERENCES instructor ( instructor_identifier );

ALTER TABLE instructor
    ADD CONSTRAINT instructor_department_fk FOREIGN KEY ( department_department_name )
        REFERENCES department ( department_name );

ALTER TABLE instructor
    ADD CONSTRAINT instructor_supervisor_fk FOREIGN KEY ( supervisor_supervisor_identifier )
        REFERENCES supervisor ( supervisor_identifier );

ALTER TABLE required_course
    ADD CONSTRAINT required_course_course_fk FOREIGN KEY ( course_unique_course_code )
        REFERENCES course ( unique_course_code );

ALTER TABLE university_student_course
    ADD CONSTRAINT university_student_course_course_fk FOREIGN KEY ( course_unique_course_code )
        REFERENCES course ( unique_course_code );

ALTER TABLE university_student
    ADD CONSTRAINT university_student_course_of_study_fk FOREIGN KEY ( course_of_study_unique_course_of_study_code )
        REFERENCES course_of_study ( unique_course_of_study_code );

ALTER TABLE university_student_course
    ADD CONSTRAINT university_student_course_university_student_fk FOREIGN KEY ( university_student_registration_number )
        REFERENCES university_student ( registration_number );

