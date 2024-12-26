package DAO;

import java.util.List;

import com.test.Beans.User;

public interface UserInterface {
public List<User> getAll();
public void addUser(User user);
public User findUser(int id);
public boolean deleteUser(int id);
boolean added(User user);
}
