package com.example.mongo;

import com.example.Example;
import net.bytebuddy.asm.Advice;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Example.class)
public class Test3 {

    @Autowired
    private MongoOperations mongoOperations;

}
