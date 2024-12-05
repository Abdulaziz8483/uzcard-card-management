package com.uzcard.cardmanagement.repository;

import com.uzcard.cardmanagement.entity.ProfileEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<ProfileEntity, String> {
}
