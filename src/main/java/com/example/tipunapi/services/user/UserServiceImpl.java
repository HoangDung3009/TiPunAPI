package com.example.tipunapi.services.user;

import com.example.tipunapi.models.User;
import com.example.tipunapi.repositories.UserRepository;
import com.example.tipunapi.security.JwtProvider;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.gson.Gson;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncrypt;

    @Autowired
    private JwtProvider jwtProvider;

    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    public static final String CLIENT_ID = "1002741513057-96glclnhaktlt5qdf08brkeqt95flf15.apps.googleusercontent.com";
    @Override
    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null){
            if(passwordEncrypt.matches(password, user.getPassword())){
                return user;
            }
        }
        return null;
    }

    @Override
    public User signup(User user) {
        user.setPassword(passwordEncrypt.encode(user.getPassword()));
        return userRepository.saveAndFlush(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public User favorite(User user) {
        return userRepository.save(user);
    }

    @Override
    public ResponseEntity<User> googleLogin(String googleAccessToken) {
        String fullname = "";
        String email = "";
        String token = "";
        googleAccessToken = googleAccessToken.substring(1, googleAccessToken.length() - 1);
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new GsonFactory())
                // Specify the CLIENT_ID of the app that accesses the backend:
                .setAudience(Collections.singletonList(CLIENT_ID))
                // Or, if multiple clients access the backend:
                //.setAudience(Arrays.asList(CLIENT_ID_1, CLIENT_ID_2, CLIENT_ID_3))
                .build();

        try {
            GoogleIdToken idToken = verifier.verify(googleAccessToken);
            if (idToken != null) {
                Payload payload = idToken.getPayload();

                // Print user identifier

                // Get profile information from payload
                email = payload.getEmail();
                fullname = (String) payload.get("name");

                // Use or store profile information
                // ...

            } else {
                System.out.println("Invalid ID token.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        User user = userRepository.findUserByEmail(email);
        if (user != null){

        }
        else {
            User user1 = User.builder()
                    .username(email)
                    .email(email)
                    .gender("")
                    .phone("")
                    .dob(new Date(System.currentTimeMillis()))
                    .password(passwordEncrypt.encode("12345678"))
                    .fullname(fullname)
                    .build();
            user = userRepository.saveAndFlush(user1);

        }

        return ResponseEntity.ok().body(user);
    }


    private String createToken(User user) {
        Long now = System.currentTimeMillis();
        JwtProvider jwtConfig = null;
        String token = Jwts.builder().setSubject(user.getEmail())
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + jwtConfig.getExpiration()*1000))
                .signWith(SignatureAlgorithm.HS512, jwtConfig.getSecret().getBytes())
                .compact();
        return jwtConfig.getPrefix() + token;
    }
}
