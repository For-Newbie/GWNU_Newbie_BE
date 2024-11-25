package kr.ac.gwnu.gwnu_newbie.community.presentation;

import kr.ac.gwnu.gwnu_newbie.community.application.PostService;
import kr.ac.gwnu.gwnu_newbie.community.domain.dto.PostRequest;
import kr.ac.gwnu.gwnu_newbie.global.dto.ResponseDto;
import kr.ac.gwnu.gwnu_newbie.global.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createPost(@RequestBody PostRequest request,
                                                  @AuthenticationPrincipal UserDetails userDetails
    ) {
        return ResponseUtil.createSuccessResponse(postService.createPost(request, userDetails.getUsername()));
    }

    @GetMapping
    public ResponseEntity<ResponseDto> getPosts(Pageable pageable,
                                                @AuthenticationPrincipal UserDetails userDetails) {
        return ResponseUtil.createSuccessResponse(
                postService.getPosts(pageable, userDetails.getUsername())
        );
    }

    @GetMapping("/category/{categoryName}")
    public ResponseEntity<ResponseDto> getPostsByCategory(@PathVariable String categoryName,
                                                          Pageable pageable,
                                                          @AuthenticationPrincipal UserDetails userDetails) {
        return ResponseUtil.createSuccessResponse(
                postService.getPostsByCategory(categoryName, pageable, userDetails.getUsername())
        );
    }

    @GetMapping("/search")
    public ResponseEntity<ResponseDto> searchPosts(@RequestParam String keyword,
                                                   Pageable pageable,
                                                   @AuthenticationPrincipal UserDetails userDetails) {
        return ResponseUtil.createSuccessResponse(
                postService.searchPosts(keyword, pageable, userDetails.getUsername())
        );
    }

    @GetMapping("/{postId}")
    public ResponseEntity<ResponseDto> getPost(@PathVariable Long postId,
                                               @AuthenticationPrincipal UserDetails userDetails) {
        return ResponseUtil.createSuccessResponse(
                postService.getPost(postId, userDetails.getUsername())
        );
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<ResponseDto> deletePost(@PathVariable Long postId,
                                                  @AuthenticationPrincipal UserDetails userDetails) {
        postService.deletePost(postId, userDetails.getUsername());
        return ResponseUtil.createSuccessResponse(null);
    }

}