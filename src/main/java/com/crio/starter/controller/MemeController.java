package com.crio.starter.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import com.crio.starter.exchange.GetListOfMemesResponse;
import com.crio.starter.exchange.GetMemeResponse;
import com.crio.starter.exchange.PostMemeResponse;
import com.crio.starter.exchange.PostMemeResquest;
import com.crio.starter.service.MemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(MemeController.MEMES_API)
public class MemeController {
    public static final String MEMES_API = "/memes";

    @Autowired
    private MemeService memeService;
    

        /*GET /memes
          POST /memes
          GET /memes/{id}

        */

    @GetMapping()
    public ResponseEntity<List<GetMemeResponse>> getLatestMems(){
        GetListOfMemesResponse listsOfmemes = memeService.fetchLatestMemes();
        List<GetMemeResponse> getMemesReponse = listsOfmemes.getMemesList().stream().map(meme -> {
            return new GetMemeResponse(meme);
        }).collect(Collectors.toList());
        return ResponseEntity.ok(getMemesReponse);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostMemeResponse> postMeme(@Valid @RequestBody PostMemeResquest postMemeResquest ){
        PostMemeResponse postMemeResponse = memeService.createNewMeme(postMemeResquest);
        if(postMemeResponse.getId() == null){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        else{
            return ResponseEntity.ok().body(postMemeResponse);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetMemeResponse> getMemeById(@PathVariable String id){
        GetMemeResponse meme = memeService.fetchMemeById(id);
        if(meme.getMeme().getId()==null){
           return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(meme);
    }
}
