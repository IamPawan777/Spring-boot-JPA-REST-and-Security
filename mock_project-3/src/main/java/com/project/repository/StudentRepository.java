package com.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.dto.ResponseDto;
import com.project.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	@Query("""
			SELECT new com.project.dto.ResponseDto(
				s.name,
				s.fees,
				s.address
			)
			FROM Student s
	""")
	List<ResponseDto> getAllStudent();

	List<Student> findByEmail(String email);

//	void deleteByEmail(String email);

}
