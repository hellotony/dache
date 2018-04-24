package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author luogeng.szq
 * @version $$Id:Comment.java, v0.1 2018/2/6 下午4:51 Exp$$
 **/

@Entity
public class Comment implements Serializable{

    private static final long serialVersionUID = -1659134747445487455L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String content;

    @Column(name = "creator_name")
    private String creatorName;

    @Column(name = "creator_id")
    private Long creatorId;

    @Column(name = "community_id")
    private Long communityId;

    @Column
    private String label;

    @Column
    private String nick;

    @Column
    private String signature;

    @Column
    private String level;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modify")
    private Date gmtModify;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "Comment{" +
            "id=" + id +
            ", content='" + content + '\'' +
            ", creatorName='" + creatorName + '\'' +
            ", creatorId=" + creatorId +
            ", communityId=" + communityId +
            ", label='" + label + '\'' +
            ", nick='" + nick + '\'' +
            ", signature='" + signature + '\'' +
            ", level='" + level + '\'' +
            ", gmtCreate=" + gmtCreate +
            ", gmtModify=" + gmtModify +
            '}';
    }
}
