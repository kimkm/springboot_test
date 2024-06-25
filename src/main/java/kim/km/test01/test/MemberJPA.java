package kim.km.test01.test;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJPA extends JpaRepository<Member,Integer> {
}
