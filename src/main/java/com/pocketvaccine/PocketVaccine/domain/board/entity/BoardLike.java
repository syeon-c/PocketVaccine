package com.pocketvaccine.PocketVaccine.domain.board.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pocketvaccine.PocketVaccine.domain.user.entity.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "board_like")
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BoardLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "board_id")
    private Board board;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public BoardLike(Board board, User user) {
        this.board = board;
        this.user = user;
    }
}
