package com.userservice.module.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "xbnk_role_mst")
public class RoleInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "role_name",length = 50)
    private String roleName;
    @Column(name = "short_code", length = 3)
    private String roleShortCode;
    @Column(name = "role_status")
    private boolean status = false;
    @Column(name = "create_by")
    private String createBy;
    @Column(name = "create_date")
    @CreationTimestamp
    private Date createDate;
    @Column(name = "approved_by")
    private String approvedBy;
    @Column(name = "approved_Date")
    private LocalDateTime approvedDate;
}
