package kr.ac.gwnu.gwnu_newbie.community.domain.repository;

import kr.ac.gwnu.gwnu_newbie.community.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    
    Page<Post> findByCategoryName(String categoryName, Pageable pageable);
    Page<Post> findByPostTitleContainingOrPostContentContaining(String title, String content, Pageable pageable);
}