package redis;


import cmm.ConsoleApplication;
import cmm.redis.Person;
import cmm.redis.PersonRedisRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ConsoleApplication.class)
public class RedisRepositoryTest {

    @Autowired
    private PersonRedisRepository repo;

    @Test
    void test() {
        Person person = new Person("jang", 20);

        repo.save(person);

        repo.findById(person.getId());

        repo.count();


        repo.delete(person);


    }
}
