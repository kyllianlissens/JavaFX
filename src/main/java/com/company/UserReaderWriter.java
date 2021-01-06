package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mindrot.jbcrypt.BCrypt;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class UserReaderWriter {
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public UserReaderWriter() {
        ObjectMapper mapper = new ObjectMapper();
        try{

            File file = new File("highscores.json");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String fileContent = br.lines().collect(Collectors.joining());
            users = mapper.readValue(fileContent, new TypeReference<List<User>>(){});
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
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
       throw new Exception("User " + username + " non existing!");

    }
    public void save(){
        ObjectMapper mapper = new ObjectMapper();
        try (FileWriter writer = new FileWriter("highscores.json");
             BufferedWriter bw = new BufferedWriter(writer)) {
            String fileContentToWrite = mapper.writeValueAsString(users);
            bw.write(fileContentToWrite);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


