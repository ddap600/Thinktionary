package com.thinktionary.thinktionary_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "page_components")
public class PageComponent {

    // TODO: Some of this might, unsure yet what the frontend implementation will require

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "page_id", nullable = false)
    private Page page;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "content")
    private String content;

    @Column(name = "position", nullable = false)
    private Integer position;

    @Column(name = "column_index")
    private Integer columnIndex;
}
