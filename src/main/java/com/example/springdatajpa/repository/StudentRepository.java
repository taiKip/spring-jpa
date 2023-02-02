package com.example.springdatajpa.repository;

import com.example.springdatajpa.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{
    public List<Student> findByFirstName(String firstName);

   public List<Student> findByFirstNameContaining(String name);


   List<Student> findByLastNameNotNull();
   List<Student> findByGuardianName(String guardianName);
   Student findByFirstNameAndLastNameIgnoreCase(String firstName,String lastName);
/**@desc JPQL query*/
   @Query("select s.firstName from Student s where s.email = ?1") /**@desc where s.email == first parameter*/
   String getStudentByEmailAddress(String emailId);

   /**@desc Native Query*/
   @Query(
           value = "SELECT * FROM tbl_student s where s.email_address = ?1",
           nativeQuery = true

   )
Student getStudentByEmailAddressNative(String emailId);

   @Query(
           value = "SELECT * from  tbl_student s where s.email_address = :emailId",
           nativeQuery = true
   )
   Student getStudentStudentByEmailAddressNativeNamedParam(String emailId);
   @Modifying /**@desc because it modifies the database*/
   @Transactional /**@desc should be added in service layer, but done here because of focus on repository layer*/
   @Query(value = "UPDATE tbl_student SET first_name = ?1 where email_address = ?2",
   nativeQuery = true
   )
   int updateStudentNameByEmailId(String firstName,String emailId);
}


