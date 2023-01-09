package ru.ifmo.cloudproject.model.entites;

import lombok.*;

import javax.persistence.*;

@Table(name = "docs2tags")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Builder
@AllArgsConstructor
public class Docs2TagsPG {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "docId", referencedColumnName = "id", nullable = false)
    private DocumentPG docId;
    @ManyToOne
    @JoinColumn(name = "tagId", referencedColumnName = "id", nullable = false)
    private TagPG tagId;
}
