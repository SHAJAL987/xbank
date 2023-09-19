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
        name = "xbnk_user_role_mst"
)
public class UserRoleInfo {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_role_id"
    )
    @SequenceGenerator(
            name = "user_role_id",
            sequenceName = "user_role_id_seq",
            allocationSize = 1
    )
    private Long id;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "role_id")
    private int roleId;
    @Column(name = "create_by")
    private String createBy;
    @Column(name = "create_date")
    @CreationTimestamp
    private Date createDate;
}
