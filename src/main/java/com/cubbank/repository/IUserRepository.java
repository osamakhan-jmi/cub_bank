package com.cubbank.repository;

import com.cubbank.cubentity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by osama on 18-09-2017.
 */
public interface IUserRepository extends CrudRepository<User, String> {
}
