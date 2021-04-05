package trangchuadmin.donghohanquoc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trangchuadmin.donghohanquoc.Model.Entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

        UserEntity findByEmailAndPassWord(String userName,String passWord);
        UserEntity findByUserName(String userName);
        UserEntity findByEmail(String email);
}
