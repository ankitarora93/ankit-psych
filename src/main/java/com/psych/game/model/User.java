package com.psych.game.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.lang.annotation.Inherited;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User extends Auditable {
    @Email
    @NotBlank
    @Column(unique = true)
    @Getter
    @Setter
    private String email;

    @NotBlank
    @Getter
    @Setter
    private String saltedHashedPassword;

    @ManyToMany
    @Getter
    @Setter
    Set<Role> roles = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @Getter
    @Setter
    private Stat stat = new Stat();

    @ManyToMany(mappedBy = "players")
    @Getter
    @Setter
    private Set<Game> games = new HashSet<>();
}
