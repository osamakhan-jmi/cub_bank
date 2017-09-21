package com.cubbank.repository;

import com.cubbank.cubentity.CubUser;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository  extends CrudRepository<CubUser, String> {
}
