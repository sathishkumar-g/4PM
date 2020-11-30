package bot.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bot.model.LuckyNumber;

@Repository
public interface LuckyNumberRepository extends CrudRepository<LuckyNumber, String>{
	LuckyNumber save(LuckyNumber lNumber);
	Optional<LuckyNumber> findById(String date);
}
