package edu.utd.ecs.db.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.utd.ecs.db.DTO.ValidBorrowerDTO;
import edu.utd.ecs.db.model.Borrower;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, String>{
		
	@Query("select new edu.utd.ecs.db.DTO.ValidBorrowerDTO(u.cardid, u.ssn) from Borrower as u where u.cardid = :cardId")
	ValidBorrowerDTO isValidBorrower(@Param("cardId") String cardId);
	
	@Query("select count(*) from Borrower where ssn=:search_ssn")
	int checkIfSSNExists(@Param("search_ssn") String search_ssn);
	
	@Query("select max(id) from Borrower")
	long getMaxIDFromBorrower();

}
