package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.UserTransaction;

/**
 * Repository class for {@link com.paulopigassi.conversordemoedas.model.entity.User} entity
 * @author Paulo Pigassi
 */
@Repository
public interface UserRepository extends JpaRepository<UserTransaction, Long> {
	@Query(value = "select * from tb_user1 where username = 'pigassi'  \r\n" + 
			"			", nativeQuery = true)
	public Optional<UserTransaction> findByUsernameIgnoreCase(String username);


	@Query(value = "select distinct tb_user1.name from tb_user1  \r\n" + 
			"			where tb_user1.user_code = 1 ", nativeQuery = true)
	List<String> findPermissions(Long userCode);

	@Query(value = "select * from tb_user1 where user_code=1", nativeQuery = true)
	UserTransaction findAllByUserCode(Integer id);

	@Query(value = "select * from tb_user1 where password=?", nativeQuery = true)
	UserTransaction findAllByPassword(String password);

}
