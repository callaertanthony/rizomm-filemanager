package com.rizomm.filemanager.services;

import com.rizomm.filemanager.exceptions.OAuth2AuthenticationProcessingException;
import com.rizomm.filemanager.model.GithubOAuth2UserInfo;
import com.rizomm.filemanager.model.OAuth2UserInfo;
import java.util.Map;

public class OAuth2UserInfoFactory {

  public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes)
      throws OAuth2AuthenticationProcessingException {
    if(registrationId.equalsIgnoreCase("github")) {
      return new GithubOAuth2UserInfo(attributes);
    } else {
      throw new OAuth2AuthenticationProcessingException();
    }
  }
}
