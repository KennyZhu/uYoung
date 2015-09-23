create table tb_user_info(
	id int(4) primary key not null auto_increment,
	real_name varchar(10) comment '真实姓名',
	nick_name varchar(10) not null comment '昵称',
	password  varchar(50) not null comment '密码',
	email     varchar(50) default null comment 'Email',
	gender	  tinyint(1) default 1 comment '性别',
	avatar_url varchar(250) default null comment '头像',
	phone     varchar(20) default null comment '电话号码',
	address  int(4) default null comment '城市ID',
	company    varchar(40) comment '公司',
	position   varchar(20) comment '职位',
	equipment  varchar(20) comment '设备/器材',
	style     tinyint(2) comment '风格',
	create_time timestamp null comment '创建时间',
	update_time timestamp null default current_timestamp on update current_timestamp comment '更新时间'
);

create table tb_mobile_info(
	id int(4) primary key not null auto_increment,
	platform tinyint(1) not null comment '设备名称 ios android',
	version  varchar(10) not null comment '版本',
	token  varchar(128) not null comment '密码',
	imei     varchar(250) default null comment 'Email',
	user_id	  int not null comment '用户ID',
	validate     tinyint(2) not null comment '是否有效',
	create_time timestamp null comment '创建时间',
	update_time timestamp null default current_timestamp on update current_timestamp comment '更新时间'
);


create table tb_activity_info(
	id int(4) primary key not null auto_increment,
	title varchar(30) not null comment '主题',
	ori_user_id  int not null comment '发起人',
	begin_time  timestamp  null comment '开始时间',
	end_time    timestamp  null comment '结束时间',
	address	    varchar(100) not null comment '活动地点',
	need_num     int not null comment '要求参与人数',
	real_num     int not null comment '实际参与人数',
	activity_type tinyint(2) not null comment '活动类型',
	fee_type     tinyint(1) not null comment '费用类型',
	description varchar(500) comment '描述',
	status       tinyint(1) not null comment '活动状态',
	create_time timestamp null comment '创建时间',
	update_time timestamp null default current_timestamp on update current_timestamp comment '更新时间'
);
/*- 活动报名信息表-*/
create table tb_activity_signup(
	id int(4) primary key not null auto_increment,
	activity_id int(1) not null comment '活动报名信息表',
	user_id	  int not null comment '用户ID',
	status tinyint(4) not null comment '状态',
	create_time timestamp null comment '创建时间',
	update_time timestamp null default current_timestamp on update current_timestamp comment '更新时间'
); 


/*- 相册表-*/
create table tb_album_info(
	id int(4) primary key not null auto_increment,
	title varchar(20) not null comment '相册主题',
	create_user_id int not null comment '创建者ID',
	album_name varchar(10) not null comment '相册名称',
	album_url  varchar(250) not null comment '相册地址',
	first_photo_url varchar(250) not null comment '封面图片地址',
	create_time timestamp null comment '创建时间',
	update_time timestamp null default current_timestamp on update current_timestamp comment '更新时间'
);

/*-图片表-*/
create table tb_photo_info(
	id int(4) primary key not null auto_increment,
	photo_name varchar(10) not null comment '名称',
	photo_desc varchar(50)  comment '描述',
	photo_url varchar(250) comment '地址',
	create_user_id  int not null comment '用户ID',
	exif_camera varchar(32) comment '相机',
	exif_aperture varchar(10) comment '光圈',
	exif_facus  varchar(10) comment '焦距',
	exif_shutter  varchar(10) comment  '快门',
	exif_iso   varchar(10) comment '感光度',
	exif_other  varchar(50) comment '其他信息',
	view_count int not null comment '浏览数',
	like_count int not null comment '喜欢数',
	comment_count int null comment '评论数',
	create_time timestamp null comment '创建时间',
	update_time timestamp null default current_timestamp on update current_timestamp comment '更新时间'
);  

/*- 点赞表-*/
create table tb_photo_like(
	id int(4) primary key not null auto_increment,
	photo_id int not null comment '照片ID',
	user_id	  int not null comment '用户ID',
	create_time timestamp null comment '创建时间',
	update_time timestamp null default current_timestamp on update current_timestamp comment '更新时间'
); 




create table tb_photo_info(
	create_user_id  int not null comment '用户ID',
	exif_camera varchar(32) comment '相机',
	update_time timestamp null default current_timestamp on update current_timestamp comment '更新时间'
); 







