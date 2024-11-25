package kr.ac.gwnu.gwnu_newbie.community.presentation;

import kr.ac.gwnu.gwnu_newbie.community.application.CommentService;
import kr.ac.gwnu.gwnu_newbie.community.domain.dto.CommentRequest;
import kr.ac.gwnu.gwnu_newbie.global.dto.ResponseDto;
import kr.ac.gwnu.gwnu_newbie.global.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<ResponseDto> createComment(@RequestBody CommentRequest request,
                                                     @AuthenticationPrincipal UserDetails userDetails
    ) {
        return ResponseUtil.createSuccessResponse(commentService.createComment(request, userDetails.getUsername()));
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<ResponseDto> getCommentsByPost(@PathVariable Long postId,
                                                         @AuthenticationPrincipal UserDetails userDetails) {
        return ResponseUtil.createSuccessResponse(
                commentService.getCommentsByPost(postId, userDetails.getUsername())
        );
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<ResponseDto> deleteComment(@PathVariable Long commentId,
                                                     @AuthenticationPrincipal UserDetails userDetails) {
        commentService.deleteComment(commentId, userDetails.getUsername());
        return ResponseUtil.createSuccessResponse(null);
    }
}