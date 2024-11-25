package kr.ac.gwnu.gwnu_newbie.community.application;

import kr.ac.gwnu.gwnu_newbie.community.domain.Comment;
import kr.ac.gwnu.gwnu_newbie.community.domain.Post;
import kr.ac.gwnu.gwnu_newbie.community.domain.User;
import kr.ac.gwnu.gwnu_newbie.community.domain.dto.CommentRequest;
import kr.ac.gwnu.gwnu_newbie.community.domain.dto.CommentResponse;
import kr.ac.gwnu.gwnu_newbie.community.domain.repository.CommentRepository;
import kr.ac.gwnu.gwnu_newbie.community.domain.repository.PostRepository;
import kr.ac.gwnu.gwnu_newbie.community.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public CommentResponse createComment(CommentRequest request, String userName) {
        User user = userRepository.findByUserName(userName)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));
        Post post = postRepository.findById(request.postId())
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));

        Comment comment = Comment.builder()
                .user(user)
                .post(post)
                .commentContent(request.commentContent())
                .commentCreatedAt(LocalDateTime.now())
                .build();

        Comment savedComment = commentRepository.save(comment);
        return CommentResponse.from(savedComment, userName);
    }

    @Transactional(readOnly = true)
    public List<CommentResponse> getCommentsByPost(Long postId, String currentUserName) {
        return commentRepository.findByPostId(postId).stream()
                .map(comment -> CommentResponse.from(comment, currentUserName))
                .toList();
    }

    public void deleteComment(Long commentId, String currentUserName) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("댓글을 찾을 수 없습니다."));

        if (!comment.getUser().getUserName().equals(currentUserName)) {
            throw new RuntimeException("댓글 삭제 권한이 없습니다.");
        }

        commentRepository.deleteById(commentId);
    }
}