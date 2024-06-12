package timski.proekt.backend.Service;

import timski.proekt.backend.Model.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    public List<User> listAll();

    User update(Long id, String email, String password);

    //todo: create / update
}