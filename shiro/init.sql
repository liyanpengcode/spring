-- 权限表 --
CREATE TABLE  permission(

  permissionId INTEGER (20) NOT  NULL  AUTO_INCREMENt,

  name VARCHAR (20) NOT NULL DEFAULT '',

  url VARCHAR (255) DEFAULT '',

  PRIMARY KEY (permissionId)

) ENGINE = InnoDB DEFAULT  CHARSET=utf8;

INSERT INTO permission VALUES ('1','add','');
INSERT INTO permission VALUES ('2','delete','');
INSERT INTO permission VALUES ('3','update','');
INSERT INTO permission VALUES ('4','find','');



-- 用户表--
CREATE  TABLE  user(

  userId INTEGER (20) NOT NULL AUTO_INCREMENT,

  username VARCHAR (20) NOT NULL DEFAULT '',

  password VARCHAR (20) NOT NULL DEFAULT '',

  PRIMARY KEY (userId)

) ENGINE = InnoDB DEFAULT  ChARSET = utf8;

INSERT INTO user VALUES ('1','admin','admin');
INSERT INTO user VALUES ('2','user','user');

-- 角色表 --
CREATE TABLE role(

  roleId INTEGER (20) NOT NULL AUTO_INCREMENT,

  name  VARCHAR (20) NOT NULL  DEFAULT '',

  PRIMARY KEY (roleId)

) engine = InnoDB DEFAULT  CHARSET = utf8;


INSERT INTO role VALUES ('1','admin');
INSERT INTO role VALUES ('2','consumer');

-- 权限角色关系表 --
CREATE  TABLE  permission_role(

  roleId INTEGER  NOT NULL ,

  permissionId INTEGER  NOT NULL ,

  KEY roleId (roleId),

  KEY permissionId (permissionId),

) ENGINE = InnoDB  DEFAULT CHARSET= utf8;

INSERT INTO permission_role VALUES ('1','1');
INSERT INTO permission_role VALUES ('1','2');
INSERT INTO permission_role VALUES ('1','3');
INSERT INTO permission_role VALUES ('1','4');
INSERT INTO permission_role VALUES ('2','1');
INSERT INTO permission_role VALUES ('2','4');


-- 用户和角色关系表 --
CREATE TABLE user_role(

  userId INTEGER (20) NOT NULL ,

  roleId INTEGER (20) NOT NULL ,

  KEY userId (userId),

  KEY roleId (roleId)

) ENGINE=InnoDB DEFAULT  CHARSET=utf8;

INSERT INTO user_role VALUES ('1','1');
INSERT INTO user_role VALUES ('2','2');
