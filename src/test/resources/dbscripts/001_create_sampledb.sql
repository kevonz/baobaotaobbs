CREATE TABLE `t_board` (
  `board_id`   INT(11)      NOT NULL AUTO_INCREMENT COMMENT '论坛版块ID',
  `board_name` VARCHAR(150) NOT NULL DEFAULT ''
  COMMENT '论坛版块名',
  `board_desc` VARCHAR(255) DEFAULT NULL
  COMMENT '论坛版块描述',
  `topic_num`  INT(11)      NOT NULL DEFAULT '0'
  COMMENT '帖子数目',
  PRIMARY KEY (`board_id`),
  KEY `AK_Board_NAME` (`board_name`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 9
  DEFAULT CHARSET = utf8;
CREATE TABLE `t_board_manager` (
  `board_id` INT(11) NOT NULL,
  `user_id`  INT(11) NOT NULL,
  PRIMARY KEY (`board_id`, `user_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT = '论坛管理员';
CREATE TABLE `t_login_log` (
  `login_log_id`   INT(11)     NOT NULL AUTO_INCREMENT,
  `user_id`        INT(11) DEFAULT NULL,
  `ip`             VARCHAR(30) NOT NULL DEFAULT '',
  `login_datetime` VARCHAR(14) NOT NULL,
  PRIMARY KEY (`login_log_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
CREATE TABLE `t_post` (
  `post_id`     INT(11)     NOT NULL AUTO_INCREMENT COMMENT '帖子ID',
  `board_id`    INT(11)     NOT NULL DEFAULT '0'
  COMMENT '论坛ID',
  `topic_id`    INT(11)     NOT NULL DEFAULT '0'
  COMMENT '话题ID',
  `user_id`     INT(11)     NOT NULL DEFAULT '0'
  COMMENT '发表者ID',
  `post_type`   TINYINT(4)  NOT NULL DEFAULT '2'
  COMMENT '帖子类型 1:主帖子 2:回复帖子',
  `post_title`  VARCHAR(50) NOT NULL
  COMMENT '帖子标题',
  `post_text`   TEXT        NOT NULL
  COMMENT '帖子内容',
  `create_time` DATE        NOT NULL
  COMMENT '创建时间',
  PRIMARY KEY (`post_id`),
  KEY `IDX_POST_TOPIC_ID` (`topic_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 25
  DEFAULT CHARSET = utf8
  COMMENT = '帖子';
CREATE TABLE `t_topic` (
  `topic_id`      INT(11)      NOT NULL AUTO_INCREMENT COMMENT '帖子ID',
  `board_id`      INT(11)      NOT NULL
  COMMENT '所属论坛',
  `topic_title`   VARCHAR(100) NOT NULL DEFAULT ''
  COMMENT '帖子标题',
  `user_id`       INT(11)      NOT NULL DEFAULT '0'
  COMMENT '发表用户',
  `create_time`   DATE         NOT NULL
  COMMENT '发表时间',
  `last_post`     DATE         NOT NULL
  COMMENT '最后回复时间',
  `topic_views`   INT(11)      NOT NULL DEFAULT '1'
  COMMENT '浏览数',
  `topic_replies` INT(11)      NOT NULL DEFAULT '0'
  COMMENT '回复数',
  `digest`        INT(11)      NOT NULL
  COMMENT '0:不是精华话题 1:是精华话题',
  PRIMARY KEY (`topic_id`),
  KEY `IDX_TOPIC_USER_ID` (`user_id`),
  KEY `IDX_TOPIC_TITLE` (`topic_title`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 24
  DEFAULT CHARSET = utf8
  COMMENT = '话题';
CREATE TABLE `t_user` (
  `user_id`    INT(11)     NOT NULL AUTO_INCREMENT COMMENT '用户Id',
  `user_name`  VARCHAR(30) NOT NULL
  COMMENT '用户名',
  `password`   VARCHAR(30) NOT NULL DEFAULT ''
  COMMENT '密码',
  `user_type`  TINYINT(4)  NOT NULL DEFAULT '1'
  COMMENT '1:普通用户 2:管理员',
  `locked`     TINYINT(4)  NOT NULL DEFAULT '0'
  COMMENT '0:未锁定 1:锁定',
  `credit`     INT(11) DEFAULT NULL
  COMMENT '积分',
  `last_visit` DATETIME DEFAULT NULL
  COMMENT '最后登陆时间',
  `last_ip`    VARCHAR(20) DEFAULT NULL
  COMMENT '最后登陆IP',
  PRIMARY KEY (`user_id`),
  KEY `AK_AK_USER_USER_NAME` (`user_name`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8;