package cn.stt.cloud.study.repository;

import cn.stt.cloud.study.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author shitongtong
 * <p>
 * Created by shitongtong on 2017/12/5.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>{
}
