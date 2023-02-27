package cmm.redis;


import lombok.Getter;
import org.springframework.cglib.core.Local;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@RedisHash(value = "people", timeToLive = 30)
public class Person {

    @Id
    private String id;
    private String name;
    private Integer age;
    private LocalDateTime createAt;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
        this.createAt = LocalDateTime.now();
    }


}
