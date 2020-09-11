package web.dao;


import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
import web.model.Role;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.*;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List getAllUsers() {
        return entityManager.createQuery("from User").getResultList();

    }

    @Override
     // Для отображения ролей
    public Set<Role> getAllRoles() {
        List<Role> roles = entityManager.createQuery("from Role").getResultList();
        return (Set<Role>) new HashSet(roles);
    }

    @Override
    public User getUserById(Long id) {
        TypedQuery<User> typedQuery = entityManager.createQuery("select u from User u where u.id = :id", User.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getResultList().stream().findAny().orElse(null);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.remove(getUserById(id));

    }

    @Override
    public User getUserByName(String login) {
        TypedQuery<User> typedQuery = entityManager.createQuery("select u from User u where u.login = :login", User.class);
        typedQuery.setParameter("login", login);
        return typedQuery.getResultList().stream().findAny().orElse(null);

    }

    @Override
    public Role getRoleByName(String name) {
        TypedQuery<Role> typedQuery = entityManager.createQuery("select r from Role r where r.name = :name", Role.class);
        typedQuery.setParameter("name", name);
        return typedQuery.getResultList().stream().findAny().orElse(null);

    }

    @Override
    public void addRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

}