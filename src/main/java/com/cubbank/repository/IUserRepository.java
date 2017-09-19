package com.cubbank.repository;

import com.cubbank.cubentity.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository  extends CrudRepository<User, String> {
}
