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
@Table(name = "xbnk_feature_mst")
public class FeatureInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "feature_name",length = 50)
    private String featureName;
    @Column(name = "parent_feature")
    private Long parentFeatureId;
    @Column(name = "parent_or_child",length = 1)
    private String parentOrChild;
    @Column(name = "level")
    private int level;
    @Column(name = "url",length = 200)
    private String url;
    @Column(name = "is_root")
    private boolean isRoot;
    @Column(name = "create_by")
    private String createBy;
    @Column(name = "create_date")
    @CreationTimestamp
    private Date createDate;
}
