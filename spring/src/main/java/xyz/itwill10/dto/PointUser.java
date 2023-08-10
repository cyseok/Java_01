package xyz.itwill10.dto;
import lombok.Builder;
/*
create table pointuser (id varchar2( 20) primary key, name VARCHAR2(30), point NUMBER);

create table pointboard (idx number PRIMARY key, writer VARCHAR2(20), subject VARCHAR2(100));
create SEQUENCE pointboard_seq;
 */
import lombok.Data;

@Data
@Builder
public class PointUser {
	private String id;
	private String name;
	private int point;
}