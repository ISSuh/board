package com.myboard.board.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserSecurityService {
  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername() {
    
  }
}
