package com.ae.teachercatalog.controller;

import com.ae.teachercatalog.model.SocialMedia;
import com.ae.teachercatalog.service.SocialMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/v1")
public class SocialMediaController {

    @Autowired
    SocialMediaService socialMediaService;

    /**
     * @return GET of social medias
     */
    @RequestMapping(value = "/socialMedias", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<List<SocialMedia>> getSocialMedias() {
        List<SocialMedia> socialMedias = new ArrayList<>();
        socialMedias = socialMediaService.findAllSocialMedias();
        if (socialMedias.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<List<SocialMedia>>(socialMedias, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/socialMedias/{idSocialMedia}", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<SocialMedia> getSocialMediaById(@PathVariable("idSocialMedia") Long idSocialMedia) {
        if (idSocialMedia == null || idSocialMedia <= 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        SocialMedia socialMedia = socialMediaService.findSocialMediaById(idSocialMedia);
        if (socialMedia == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<SocialMedia>(socialMedia, HttpStatus.OK);
    }

    @RequestMapping(value = "/socialMedias", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<?> createSocialMedia(@RequestBody SocialMedia socialMedia,
                                               UriComponentsBuilder uriComponentsBuilder) {
        if (socialMedia.getName() == null || socialMedia.getName().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        if (socialMediaService.findSocialMediaByName(socialMedia.getName()) != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        socialMediaService.saveSocialMedia(socialMedia);
        SocialMedia socialMedia2 = socialMediaService.findSocialMediaByName(socialMedia.getName());

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder
                .path("/v1/socialMedias/{id}")
                .buildAndExpand(socialMedia2.getIdSocialMedia())
                .toUri());

        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/socialMedias/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
    public ResponseEntity<?> updateSocialMedia(@PathVariable("id") Long idSocialMedia,
                                              @RequestBody SocialMedia socialMedia) {
        final SocialMedia currentSocialMedia = socialMediaService.findSocialMediaById(idSocialMedia);
        if (currentSocialMedia == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        currentSocialMedia.setName(socialMedia.getName());
        currentSocialMedia.setIcon(socialMedia.getIcon());
        socialMediaService.updateSocialMedia(currentSocialMedia);

        return new ResponseEntity<SocialMedia>(currentSocialMedia, HttpStatus.OK);
    }

    @RequestMapping(value = "/socialMedias/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<?> deleteSocialMedia(@PathVariable("id") Long idSocialMedia) {
        if (idSocialMedia == null || idSocialMedia <= 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        SocialMedia socialMedia = socialMediaService.findSocialMediaById(idSocialMedia);
        if (socialMedia == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        socialMediaService.deleteSocialMedia(idSocialMedia);
        return new ResponseEntity<SocialMedia>(HttpStatus.OK);
    }

}
