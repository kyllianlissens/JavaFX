package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mindrot.jbcrypt.BCrypt;

import java.io.*;
import java.util.List;

public class UserReaderWriter {
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public UserReaderWriter() {
        ObjectMapper mapper = new ObjectMapper();
        try{
            users = mapper.readValue(new File("highscores.json"), new TypeReference<List<User>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User register(String username, String password) throws Exception{
        for (User user: users) {
            if(user.getUsername().equalsIgnoreCase(username)){
                throw new Exception("Username already taken!");
            }
        }

        User user = new User(username, BCrypt.hashpw(password,BCrypt.gensalt()));
        users.add(user);
        save();
        return user;

    }

    public User login(String username, String password) throws Exception {
        for (User user: users) {
            if(user.getUsername().equalsIgnoreCase(username)){
                if(BCrypt.checkpw(password, user.getPassword())){
                    return user;
                }
                else{
                    throw new Exception("Incorrect password!");
                }
            }
        }
       throw new Exception("User " + username + " non exsisting!");

    }
    public void save(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("highscores.json"), users);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


