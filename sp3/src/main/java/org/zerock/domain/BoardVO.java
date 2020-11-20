package org.zerock.domain;

import lombok.Data;
import org.springframework.context.annotation.Description;

import java.util.Date;

@Data
public class BoardVO {
    private Long bno;
    private String title;
    private String content;
    private String writer;
    private Date regdate;
    private Date updatedate;
}
