package com.beatharmony;

import com.beatharmony.data.UserRepository;
import com.beatharmony.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class RestApplication implements CommandLineRunner {

	private User rishma = new User("2", "Rishma", "Mendhekar", "rmendhekar", "rishma@gmail.com", (List<User>) null);
	private User ankit = new User("3", "Ankit", "Verma", "averma", "ankit@gmail.com", (List<User>) null);
	private User pradyumna = new User("4", "Pradyumna", "Mukunda", "pmukunda", "pradyumna@gmail.com", (List<User>) null);
	private User christian = new User("5", "Christian", "Graham", "cgraham", "christian@gmail.com", (List<User>) null);

	List<User> trusted = new ArrayList<>(Arrays.asList(rishma, ankit, pradyumna, christian));
	private User justin = new User("1", "Justin", "Higgins", "jhiggins", "just1higg@gmail.com", trusted);

	private List<User> users = new ArrayList<>(Arrays.asList(justin, rishma, ankit, pradyumna, christian));

	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();

		repository.saveAll(users);
	}
}
