package com.company;

import org.mindrot.jbcrypt.BCrypt;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import  java.util.Collections;



public class UserReaderWriter {
     private List<User> users;
     private final String seperator = ",";
     private final String fileName = "highscores.txt";

    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }

    public UserReaderWriter() { //kan traag zijn
        users = new ArrayList<>();
        try
        {
            File file=new File("highscores.txt");    //creates a new file instance
            FileReader fr=new FileReader(file);   //reads the file
            BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream
            String line;
            while((line=br.readLine())!=null)
            {
                /*
                Split on seperator returns array of:
                - index 0: username
                - index 1: wachtwoord
                - index 2: highscore
                 */
                try{
                    String[] input = line.split(seperator);
                    User user = new User();
                    user.setUsername(input[0]);
                    user.setWachtwoord(input[1]);
                    user.setHighscore(Integer.parseInt(input[2]));
                    users.add(user);
                }
                catch(Exception ignored){}
                
            }
            fr.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public User register(String username, String wachtwoord) throws Exception{

        for (User user: users
             ) {
            if(user.getUsername().equalsIgnoreCase(username)){
                throw new Exception("Username bestaat al!");
            }

        }

        User user = new User();
        user.setUsername(username);
        user.setWachtwoord(BCrypt.hashpw(wachtwoord,BCrypt.gensalt()));
        users.add(user);
        return user;

    }

    public User login(String username, String wachtwoord) throws Exception {
        for (User user: users
             ) {
            if(user.getUsername().equalsIgnoreCase(username)){
                if(BCrypt.checkpw(wachtwoord, user.getWachtwoord())){
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
        try{
            File fout = new File("highscores.txt");
            FileOutputStream fos = new FileOutputStream(fout);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            for (User user: users
                 ) {
                bw.write(user.toCSV(seperator));
                bw.newLine();
            }

            bw.close();
        }
        catch(Exception ignored){

        }

    }
}


