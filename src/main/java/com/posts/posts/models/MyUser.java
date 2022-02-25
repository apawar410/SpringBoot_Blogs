
package com.posts.posts.models;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "users")
@Getter
@Setter
public class MyUser {
        @Id
        private String username;


        private String password;
        @Column(name = "role_code")
        private String roleCode;

        public String getRoleCode() {
            return roleCode;
        }


}

