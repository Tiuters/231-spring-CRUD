package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
   List<User> showAllUsers();
   User showUser(Long id);
   void newUser(User user);
   void editUser(User user);
   void deleteUser(Long id);
}
