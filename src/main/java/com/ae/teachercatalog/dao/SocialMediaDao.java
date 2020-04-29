package com.ae.teachercatalog.dao;


import com.ae.teachercatalog.model.SocialMedia;
import com.ae.teachercatalog.model.TeacherSocialMedia;

import java.util.List;

public interface SocialMediaDao {

    void saveSocialMedia(final SocialMedia socialMedia);

    List<SocialMedia> findAllSocialMedias();

    void deleteSocialMedia(final Long idSocialMedia);

    void updateSocialMedia(final SocialMedia socialMedia);

    SocialMedia findSocialMediaByName(final String name);

    SocialMedia findSocialMediaById(final Long idSocialMedia);

    TeacherSocialMedia findSocialMediaByIdAndName(final Long idSocialMedia, final String nickname);
}
