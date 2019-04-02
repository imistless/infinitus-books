package br.com.infinitusProject.infinitusProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.infinitusProject.infinitusProject.models.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long>{
	 User findByEmail(String email); 
}
