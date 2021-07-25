package com.pocketvaccine.PocketVaccine;

import com.pocketvaccine.PocketVaccine.domain.Board;
import com.pocketvaccine.PocketVaccine.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class BoardRepositoryTest extends PocketVaccineApplicationTests {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void create() {

        // Create Board
        Board board = Board.builder()
                .boardNo(1001L)
                .title("Test Board")
                .content("None")
                .vaccineType("None")
                .build();

        // Created!
        Board newBoard = boardRepository.save(board);
        //log.info(newBoard.toString());
    }

    @Test
    public void read() {
        Optional<Board> board = boardRepository.findByBoardNo(1001L);

        board.ifPresent(
                selectBoard -> {
                }
        );
    }

    @Test
    public void update() {
        Optional<Board> board = boardRepository.findByBoardNo(1001L);

        board.ifPresent(
                selectBoard -> {
                    Board newBoard =
                            Board.builder()
                            .boardNo(1001L)
                            .title("Updated Board")
                            .content("None")
                            .vaccineType("pfizer")
                            .build();
                    boardRepository.save(newBoard);
                });
    }

    @Test
    public void delete() {

    }

}
