package web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import web.dao.UserDao;


import web.model.Role;
import web.model.User;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl<piblic> implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Transactional
    @Override
    public User getUserByName(String login) {
        return userDao.getUserByName(login);
    }

    @Transactional
    @Override
    public Role getRoleByName(String name) {

        return userDao.getRoleByName(name);
    }

    @Transactional
    @Override
    public void addRole(Role role) {
        userDao.addRole(role);
    }

    @Transactional
    @Override
    // Для отображения ролей
    public Set<Role> getAllRole() {

        return userDao.getAllRoles();
    }


    @Override
    public boolean addUser(User user) {
        if (user.getLogin().trim().length() == 0 || user.getPassword().trim().length() == 0) {
            return false;
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userDao.addUser(user);
            return true;
        }
    }

}
