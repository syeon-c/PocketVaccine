package com.pocketvaccine.PocketVaccine.domain.board.specification;

import com.pocketvaccine.PocketVaccine.domain.board.dto.BoardDto;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;

public class BoardSpecification {
    public static Specification<BoardDto> findByBoardId(Long BoardId) {
        return new Specification<BoardDto>() {
            @Override
            public Predicate toPredicate(Root<BoardDto> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("BoardId"), BoardId);
            }
        };
    }

    public static Specification<BoardDto> findByContents(String contents) {
        return new Specification<BoardDto>() {
            @Override
            public Predicate toPredicate(Root<BoardDto> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                // 2) like
                return criteriaBuilder.like(root.get("contents"), "%" + contents + "%");
            }
        };
    }

    public static Specification<BoardDto> findByCreatedTime(LocalDateTime startDatetime, LocalDateTime endDatetime) {
        return new Specification<BoardDto>() {
            @Override
            public Predicate toPredicate(Root<BoardDto> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                // 3) between
                return criteriaBuilder.between(root.get("createdDatetime"), startDatetime, endDatetime);
            }
        };
    }
}

