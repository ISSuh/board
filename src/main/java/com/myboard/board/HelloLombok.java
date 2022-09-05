package com.myboard.board;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HelloLombok {
  final String hello;
  final int count;

  public static void main(String[] args) {
    HelloLombok helloLombok = new HelloLombok("Helllo World!", 11);

    System.out.println("hello : " + helloLombok.getHello());
    System.out.println("count : " + helloLombok.getCount());
  }
}
