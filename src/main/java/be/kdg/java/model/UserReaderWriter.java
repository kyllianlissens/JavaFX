package be.kdg.java.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mindrot.jbcrypt.BCrypt;

import java.io.*;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserReaderWriter {
    private List<User> users;

    public UserReaderWriter() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(Objects.requireNonNull(classLoader.getResource("highscores.json")).getFile());

            BufferedReader br = new BufferedReader(new FileReader(file));
            users = mapper.readValue(br.lines().collect(Collectors.joining()), new TypeReference<List<User>>() {
            });
        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }


    }

    public List<User> getUsers() {
        return users;
    }

    public User register(String username, String password) throws Exception {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                throw new Exception("Username already taken!");
            }
        }

        User user = new User(username, BCrypt.hashpw(password, BCrypt.gensalt()));
        users.add(user);
        save();
        return user;

    }

    public User login(String username, String password) throws Exception {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                if (BCrypt.checkpw(password, user.getPassword())) {
                    return user;
                } else {
                    throw new Exception("Incorrect password!");
                }
            }
        }
        throw new Exception("User " + username + " non existing!");

    }

    public void save() {
        ObjectMapper mapper = new ObjectMapper();
        try (FileWriter writer = new FileWriter(Objects.requireNonNull(getClass().getClassLoader().getResource("highscores.json")).getPath());
             BufferedWriter bw = new BufferedWriter(writer)) {
            bw.write(mapper.writeValueAsString(users));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


