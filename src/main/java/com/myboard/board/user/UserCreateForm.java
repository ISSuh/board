package com.myboard.board.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateForm {
  
  @NotEmpty(message="need user name")
  @Size(min = 3, max = 25)
  private String username;

  @NotEmpty(message="need password")
  private String password1;

  @NotEmpty(message="check your password")
  private String password2;

  @NotEmpty(message="need email")
  @Email
  private String email;
}
