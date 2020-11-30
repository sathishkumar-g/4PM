package bot.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bot.model.UserDetails;

@Repository
public interface UserDetailsRepository extends CrudRepository<UserDetails, String>{
	Optional<UserDetails> findById(String name);
}
