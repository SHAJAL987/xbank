package com.userservice.module.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "xbnk_role_feature_mst",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "role feature unique constraint",
                        columnNames = {
                                "role_id",
                                "feature_id"
                        }
                )
        }
)

public class RoleFeatureInfo {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "role_feature_id"
    )
    @SequenceGenerator(
            name = "role_feature_id",
            sequenceName = "role_feature_id_seq",
            allocationSize = 1
    )
    private Long id;
    @Column(name = "role_id")
    private int roleId;
    @Column(name = "feature_id")
    private int featureId;
    @Column(name = "create_by")
    private String createBy;
    @Column(name = "create_date")
    @CreationTimestamp
    private Date createDate;
}
