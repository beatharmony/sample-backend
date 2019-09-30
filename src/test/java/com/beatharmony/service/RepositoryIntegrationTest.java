package com.beatharmony.service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.beatharmony.RestApplication;
import com.beatharmony.data.UserRepository;
import com.beatharmony.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RestApplication.class)
@WebAppConfiguration
@ActiveProfiles("local")
@TestPropertySource(properties = {
    "amazon.dynamodb.endpoint=http://localhost:8000/",
    "amazon.aws.accesskey=key",
    "amazon.aws.secretkey=key2"
})
public class RepositoryIntegrationTest {
    private DynamoDBMapper mapper;

    @Autowired
    private AmazonDynamoDB db;

    @Autowired
    UserRepository repo;

    private static final String id = "1";
    private static final String firstName = "Justin";
    private static final String lastName = "Higgins";
    private static final String username = "jhiggins";
    private static final String email = "just1higg@gmail.com";
    private static final List<User> trustedUsers = null;

    @Before
    public void setup() throws Exception {
        mapper = new DynamoDBMapper(db);
        CreateTableRequest request = mapper.generateCreateTableRequest(User.class);
        request.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
        db.createTable(request);

        //something here?

        mapper.batchDelete((List<User>)repo.findAll());
    }

    @Test
    public void test() {
        User user = new User(id, firstName, lastName, username, email, trustedUsers);
        repo.save(user);
        List<User> users = (List<User>) repo.findAll();

        assertTrue(users.size() > 0);
        assertTrue(users.get(0).getFirstName().equals("Justin"));
    }
}
