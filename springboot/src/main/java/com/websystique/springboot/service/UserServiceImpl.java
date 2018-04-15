package com.websystique.springboot.service;

import com.websystique.springboot.model.User;
import com.websystique.springboot.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service("UserService")
public class UserServiceImpl implements UserService {

    private static final AtomicLong connter = new AtomicLong();

    private static List<User> users;

    static {
        users = populateDummyUsers();
    }

    private static List<User> populateDummyUsers() {

        List<User> users = new ArrayList<User>();
        users.add(new User(connter.incrementAndGet(),"Sam",30,7000000));
        users.add(new User(connter.incrementAndGet(),"Jannay",40,5000000));
        users.add(new User(connter.incrementAndGet(),"Smith",45,6000000));
        users.add(new User(connter.incrementAndGet(),"Danny",50,1000000));
        users.add(new User(connter.incrementAndGet(),"Silvia",33,3000000));
        users.add(new User(connter.incrementAndGet(),"Jerome",28,9000000));
        users.add(new User(connter.incrementAndGet(),"Lucy",32,4000000));
        users.add(new User(connter.incrementAndGet(),"Tom",64,2000000));

        return users;
    }

    @Override
    public User findById(long id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User findByName(String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void saveUser(User user) {
        user.setId(connter.incrementAndGet());
        users.add(user);
    }

    @Override
    public void updateUser(User user) {
        int index = users.indexOf(user);
        users.set(index, user);
    }

    @Override
    public void deleteUserById(long id) {
        for (Iterator<User> iterator = users.iterator();iterator.hasNext();){
            User user = iterator.next();
            if(user.getId() == id){
                iterator.remove();
            }
        }
    }

    @Override
    public List<User> findAllUsers() {
        return users;
    }

    @Override
    public void deleteAllUsers() {
        users.clear();
    }

    @Override
    public boolean isUserExist(User user) {
        return findByName(user.getName())!=null;
    }
}