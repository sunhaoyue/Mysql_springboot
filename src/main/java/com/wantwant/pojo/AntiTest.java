package com.wantwant.pojo;




import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class AntiTest {

    private String computername;

    private Date createdate;

    private Long cnt;

    private Long id;

    public String getComputername() {
        return computername;
    }

    public void setComputername(String computername) {
        this.computername = computername == null ? null : computername.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Long getCnt() {
        return cnt;
    }

    public void setCnt(Long cnt) {
        this.cnt = cnt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}