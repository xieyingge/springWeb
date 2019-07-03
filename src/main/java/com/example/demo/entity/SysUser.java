package com.example.demo.entity;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class SysUser {
    private Long id;

    private String userName;

    private String password;

}
