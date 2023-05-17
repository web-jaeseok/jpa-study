package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        // 최초 1회만 실행 해야함
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // 트랜잭션 별 생성 계속 해야 함
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
/*
            // insert
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//            em.persist(member);

            // select
            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember = " + findMember.getId());
            System.out.println("findMember = " + findMember.getName());

            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(1)
                    .setMaxResults(10)
                    .getResultList();

            for (Member member : result) {
                System.out.println("member name = " + member.getName());
            }
            // update
//            findMember.setName("HelloJPA");
*/

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
