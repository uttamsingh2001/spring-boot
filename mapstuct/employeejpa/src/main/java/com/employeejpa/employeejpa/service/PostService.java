package com.employeejpa.employeejpa.service;

import com.employeejpa.employeejpa.model.Post;
import com.employeejpa.employeejpa.model.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class PostService {

    private final RestTemplate restTemplate;

    @Value("${test.url}")
    private String fakeUrl;

    @Autowired
    public PostService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        System.out.println(fakeUrl);
    }



        public PostResponse createPost(Post post){
            HttpEntity<Post> postHttpEntity = new HttpEntity<>(post) ;  // HttpEntity to wrap the request object
            PostResponse postResponse = restTemplate.exchange(fakeUrl+"/posts", HttpMethod.POST, postHttpEntity, PostResponse.class).getBody();

            return postResponse;
        }

//    public PostResponse[] getAllPosts() {
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//         HttpEntity<PostResponse> postHttpEntity = new HttpEntity<>(headers) ;  // HttpEntity to wrap the request objectity
//        return restTemplate.exchange(fakeUrl+"/posts", HttpMethod.GET, postHttpEntity, PostResponse[].class).getBody();
//    }

    public PostResponse[] getAllPosts()
    {
        PostResponse[] postResponse = restTemplate.getForObject(fakeUrl+"/posts",PostResponse[].class);

        return  postResponse;
    }

    public PostResponse getPost(Long id) {
        PostResponse postResponse = restTemplate.getForObject(fakeUrl+"/posts/{id}",PostResponse.class,id);
        return postResponse;
    }

    public void deletePost(Long id) {
        restTemplate.delete(fakeUrl+"/posts/{id}",id);

    }

    public PostResponse updatePost(Long id, PostResponse postResponse) {
        HttpEntity http = new HttpEntity<>(postResponse);
        ResponseEntity<PostResponse> response = restTemplate.exchange(fakeUrl + "/posts/"+id, HttpMethod.PUT, http,PostResponse.class,id);
        return response.getBody();
    }
}






