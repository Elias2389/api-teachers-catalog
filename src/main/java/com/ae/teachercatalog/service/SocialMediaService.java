package com.ae.teachercatalog.service;

import com.ae.teachercatalog.model.SocialMedia;
import com.ae.teachercatalog.model.TeacherSocialMedia;

import java.util.List;

public interface SocialMediaService {

    void saveSocialMedia(final SocialMedia socialMedia);

    List<SocialMedia> findAllSocialMedias();

    void deleteSocialMedia(final Long idSocialMedia);

    void updateSocialMedia(final SocialMedia socialMedia);

    SocialMedia findSocialMediaByName(final String name);

    SocialMedia findSocialMediaById(final Long idSocialMedia);

    TeacherSocialMedia findSocialMediaByIdAndName(final Long idSocialMedia, final String nickname);
}
