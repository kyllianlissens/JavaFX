package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mindrot.jbcrypt.BCrypt;

import java.io.*;
import java.util.List;
import  java.util.Collections;



public class UserReaderWriter {
    public List<User> users;

    public UserReaderWriter() {
        System.out.println("-----------------------------");
        System.out.println("Loading users!");
        ObjectMapper mapper = new ObjectMapper();
        try{
            users = mapper.readValue(new File("highscores.json"), new TypeReference<List<User>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Users loaded!");
        for (User user : users){
            System.out.println(user.toString());
        }
        System.out.println("-----------------------------\n");

    }

    public User register(String username, String wachtwoord) throws Exception{

        for (User user: users) {
            if(user.getUsername().equalsIgnoreCase(username)){
                throw new Exception("Username bestaat al!");
            }

        }

        User user = new User(username, BCrypt.hashpw(wachtwoord,BCrypt.gensalt()));
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
                    throw new Exception("Incorrecte wachtwoord");
                }
            }
        }
       throw new Exception("User met " + username + " bestaat niet!");

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


