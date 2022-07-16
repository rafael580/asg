package com.wipro.asg.projetoasg.repository;


import com.wipro.asg.projetoasg.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDetails,Long> {
    @Query(value = "SELECT * FROM tb_user u where (u.email_Id = :emailId AND u.passcode= :passcode)", nativeQuery = true)
    public UserDetails findUserByUsernameAndPassword(@Param(value = "emailId") String emailId,
                                                  @Param(value = "passcode") String passcode);

}
