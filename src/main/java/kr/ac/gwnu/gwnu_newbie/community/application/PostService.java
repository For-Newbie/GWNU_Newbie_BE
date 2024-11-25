package kr.ac.gwnu.gwnu_newbie.community.application;

import kr.ac.gwnu.gwnu_newbie.community.domain.Post;
import kr.ac.gwnu.gwnu_newbie.community.domain.User;
import kr.ac.gwnu.gwnu_newbie.community.domain.dto.PostRequest;
import kr.ac.gwnu.gwnu_newbie.community.domain.dto.PostResponse;
import kr.ac.gwnu.gwnu_newbie.community.domain.repository.PostRepository;
import kr.ac.gwnu.gwnu_newbie.community.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostResponse createPost(PostRequest request, String userName) {
        User user = userRepository.findByUserName(userName)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));

        Post post = Post.builder()
                .user(user)
                .postTitle(request.postTitle())
                .postContent(request.postContent())
                .categoryName(request.categoryName())
                .postCreatedAt(LocalDateTime.now())
                .postUpdatedAt(LocalDateTime.now())
                .build();

        Post savedPost = postRepository.save(post);
        return PostResponse.from(savedPost, userName);
    }

    @Transactional(readOnly = true)
    public Page<PostResponse> getPosts(Pageable pageable, String currentUserName) {
        return postRepository.findAll(pageable)
                .map(post -> PostResponse.from(post, currentUserName));
    }

    @Transactional(readOnly = true)
    public Page<PostResponse> getPostsByCategory(String categoryName, Pageable pageable, String currentUserName) {
        return postRepository.findByCategoryName(categoryName, pageable)
                .map(post -> PostResponse.from(post, currentUserName));
    }

    @Transactional(readOnly = true)
    public Page<PostResponse> searchPosts(String keyword, Pageable pageable, String currentUserName) {
        return postRepository.findByPostTitleContainingOrPostContentContaining(keyword, keyword, pageable)
                .map(post -> PostResponse.from(post, currentUserName));
    }

    @Transactional(readOnly = true)
    public PostResponse getPost(Long postId, String currentUserName) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        return PostResponse.from(post, currentUserName);
    }

    public void deletePost(Long postId, String currentUserName) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));

        if (!post.getUser().getUserName().equals(currentUserName)) {
            throw new RuntimeException("게시글 삭제 권한이 없습니다.");
        }

        postRepository.deleteById(postId);
    }
}