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
@Table(name = "xbnk_user_mst")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "user_code", length = 10)
    private String userCode;
    @Column(name = "user_name", length = 100)
    private String userName;
    @Column(name="user_email")
    private String userEmail;
    @Column(name = "user_phone", length = 11)
    private String userPhone;
    @Column(name = "user_password")
    private String userPass;
    @Column(name = "user_status")
    private boolean userStatus = false;
    @Column(name = "user_type")
    private String userType;
    @Column(name = "create_by")
    private String createBy;
    @Column(name = "create_date")
    @CreationTimestamp
    private Date createDate;
    @Column(name = "approved_by")
    private String approvedBy;
    @Column(name = "approved_Date")
    private Date approvedDate;
}
