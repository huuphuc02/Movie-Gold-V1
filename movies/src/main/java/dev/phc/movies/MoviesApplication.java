package dev.phc.movies;

import dev.phc.movies.model.Authority;
import dev.phc.movies.model.User;
import dev.phc.movies.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MoviesApplication {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

//	@PostConstruct
//	protected void init(){
//		List<Authority> authorityList = new ArrayList<>();
//
//		authorityList.add(createAuthority("USER","User role",1));
//	//	authorityList.add(createAuthority("ADMIN","Admin role"));
//
//		User user = new User();
//		user.setId(2);
//		user.setUsername("chuhuuphuc");
//		user.setFirstName("huu");
//		user.setLastName("chu");
//
//		user.setPassword(passwordEncoder.encode("huuphuc1802"));
//		user.setEnabled(true);
//		user.setAuthorities(authorityList);
//
//		userRepository.save(user);
//	}
//
//	private Authority createAuthority(String roleCode,String roleDescription,int id) {
//		Authority authority=new Authority();
//		authority.setId(id);
//		authority.setRoleCode(roleCode);
//		authority.setRoleDescription(roleDescription);
//		return authority;
//	}
}
