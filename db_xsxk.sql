/*
Navicat MySQL Data Transfer

Source Server         : Test
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : db_xsxk

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2017-04-18 22:01:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_bxxx
-- ----------------------------
DROP TABLE IF EXISTS `t_bxxx`;
CREATE TABLE `t_bxxx` (
  `ID` int(20) NOT NULL auto_increment,
  `BXSS` varchar(20) default NULL,
  `BXNR` varchar(50) default NULL,
  `LXFS` varchar(20) default NULL,
  `BXDD` varchar(20) default NULL,
  `BXR` varchar(20) default NULL,
  `BXZT` varchar(10) default NULL,
  `BXSJ` datetime default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_bxxx
-- ----------------------------
INSERT INTO `t_bxxx` VALUES ('1', '3-202', '灯坏了', '13222781820', '文园3栋', '宋籽锐', '未处理', '2017-04-18 00:00:00');

-- ----------------------------
-- Table structure for t_fkxx
-- ----------------------------
DROP TABLE IF EXISTS `t_fkxx`;
CREATE TABLE `t_fkxx` (
  `ID` int(20) NOT NULL auto_increment,
  `FKXM` varchar(20) default NULL,
  `SFZH` varchar(50) default NULL,
  `SFR` varchar(20) default NULL,
  `SFSS` varchar(20) default NULL,
  `KSSJ` datetime default NULL,
  `JSSJ` datetime default NULL,
  `ZT` varchar(20) default NULL,
  `LXFS` varchar(20) default NULL,
  `FWYY` varchar(100) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_fkxx
-- ----------------------------
INSERT INTO `t_fkxx` VALUES ('1', '马云', '320721', '宋籽锐', '3-203', '2017-04-17 00:00:00', '2017-05-05 00:00:00', '已出宿舍', '132000', '谈生意');
INSERT INTO `t_fkxx` VALUES ('2', '刘德华', '320821', '宋籽锐', '3-202', '2017-04-17 00:00:00', '2017-04-17 00:00:00', '已出宿舍', '132000', '请教问题');

-- ----------------------------
-- Table structure for t_ssxx
-- ----------------------------
DROP TABLE IF EXISTS `t_ssxx`;
CREATE TABLE `t_ssxx` (
  `SSXH` int(100) NOT NULL auto_increment,
  `SSH` varchar(20) default NULL,
  `SSLX` varchar(20) default NULL,
  `SSDD` varchar(20) default NULL,
  `CWS` varchar(20) default NULL,
  `XZRS` varchar(20) default NULL,
  `SSZ` varchar(20) default NULL,
  `JCQK` varchar(20) default NULL,
  `SSPF` varchar(20) default NULL,
  PRIMARY KEY  (`SSXH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_ssxx
-- ----------------------------
INSERT INTO `t_ssxx` VALUES ('2', '3-203', '男', '文园3栋', '4', '4', '宋籽锐', '文明宿舍', '4');
INSERT INTO `t_ssxx` VALUES ('3', '3-204', '男', '文园3栋', '4', '4', '宋籽锐', '文明宿舍', '2');
INSERT INTO `t_ssxx` VALUES ('4', '3-205', '男', '文园3栋', '4', '4', '宋籽锐', '文明宿舍', '2');
INSERT INTO `t_ssxx` VALUES ('5', '3-206', '男', '文园3栋', '4', '4', '宋籽锐', '无', null);
INSERT INTO `t_ssxx` VALUES ('6', '3-207', '男', '文园3栋', '4', '4', '宋籽锐', '无', null);
INSERT INTO `t_ssxx` VALUES ('7', '3-208', '男', '文园3栋', '4', '4', '宋籽锐', '无', null);
INSERT INTO `t_ssxx` VALUES ('8', '3-209', '男', '文园3栋', '4', '4', '宋籽锐', '无', null);
INSERT INTO `t_ssxx` VALUES ('9', '3-210', '男', '文园3栋', '4', '4', '宋籽锐', '无', null);
INSERT INTO `t_ssxx` VALUES ('10', '3-211', '男', '文园3栋', '4', '4', '宋籽锐', '无', null);
INSERT INTO `t_ssxx` VALUES ('11', '3-212', '男', '文园3栋', '4', '4', '宋籽锐', '无', null);
INSERT INTO `t_ssxx` VALUES ('12', '3-213', '男', '文园3栋', '4', '4', '宋籽锐', '无', null);
INSERT INTO `t_ssxx` VALUES ('13', '3-214', '男', '文园3栋', '4', '4', '宋籽锐', '无', null);
INSERT INTO `t_ssxx` VALUES ('14', '3-215', '男', '文园3栋', '4', '4', '宋籽锐', '无', null);
INSERT INTO `t_ssxx` VALUES ('15', '3-216', '男', '文园3栋', '4', '4', '宋籽锐', '无', null);
INSERT INTO `t_ssxx` VALUES ('16', '3-217', '男', '文园3栋', '4', '4', '宋籽锐', '无', null);
INSERT INTO `t_ssxx` VALUES ('17', '3-218', '男', '文园3栋', '4', '4', '宋籽锐', '无', null);
INSERT INTO `t_ssxx` VALUES ('18', '3-219', '男', '文园3栋', '4', '4', '宋籽锐', '无', null);
INSERT INTO `t_ssxx` VALUES ('19', '3-220', '男', '文园3栋', '4', '4', '宋籽锐', '无', null);
INSERT INTO `t_ssxx` VALUES ('20', '3-221', '男', '文园3栋', '4', '4', '宋籽锐', '无', null);
INSERT INTO `t_ssxx` VALUES ('21', '3-222', '男', '文园3栋', '4', '4', '宋籽锐', '无', null);
INSERT INTO `t_ssxx` VALUES ('22', '3-223', '男', '文园3栋', '4', '4', '宋籽锐', '无', null);
INSERT INTO `t_ssxx` VALUES ('23', '3-224', '男', '文园3栋', '4', '4', '宋籽锐', '无', null);
INSERT INTO `t_ssxx` VALUES ('24', '3-225', '男', '文园3栋', '4', '4', '宋籽锐', '无', null);
INSERT INTO `t_ssxx` VALUES ('25', '3-226', '男', '文园3栋', '4', '4', '宋籽锐', '无', null);
INSERT INTO `t_ssxx` VALUES ('26', '3-227', '男', '文园3栋', '4', '4', '宋籽锐', '无', null);
INSERT INTO `t_ssxx` VALUES ('27', '3-228', '男', '文园3栋', '4', '4', '宋籽锐', '无', null);
INSERT INTO `t_ssxx` VALUES ('28', '18-404', '女', '文园18栋', '4', '4', '宋籽锐', '文明宿舍', '10');

-- ----------------------------
-- Table structure for t_xsxx
-- ----------------------------
DROP TABLE IF EXISTS `t_xsxx`;
CREATE TABLE `t_xsxx` (
  `XM` varchar(20) NOT NULL,
  `XH` varchar(20) NOT NULL,
  `XB` varchar(10) default NULL,
  `MZ` varchar(10) default NULL,
  `CS` varchar(20) default NULL,
  `ZY` varchar(20) default NULL,
  `JTDZ` varchar(100) default NULL,
  `YZBM` varchar(20) default NULL,
  `SFZHM` varchar(50) default NULL,
  `JZXM` varchar(20) default NULL,
  `SSH` varchar(20) default NULL,
  `SJH` varchar(20) default NULL,
  `BZ` varchar(255) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_xsxx
-- ----------------------------
INSERT INTO `t_xsxx` VALUES ('陈洋', '20132308001', '女', '汉', '乐山市', '计算机科学与技术', '四川省犍为县清溪镇龙兴村五组17号', '624404', '51112319941027068X', '陈兆晶', '7-609', '15195772936', '');
INSERT INTO `t_xsxx` VALUES ('池洛滨', '20132308002', '男', '汉', '南京市', '计算机科学与技术', '江苏省南京市玄武区北门桥5幢704室', '210018', '330324199502012971', '池苗晓', '3-201', '13851581664', '');
INSERT INTO `t_xsxx` VALUES ('次珍', '20132308003', '女', '藏', '拉萨市', '计算机科学与技术', '西藏省拉萨市纳金路邮运新村', '850000', '540102199505081024', '次仁', '7-528', '15996372877', '');
INSERT INTO `t_xsxx` VALUES ('顾勇祥', '20132308004', '男', '汉', '泰州市', '计算机科学与技术', '江苏省泰州市兴化市陶庄镇14组424号', '225733', '321281199412166652', '顾往林', '3-201', '18751905580', '');
INSERT INTO `t_xsxx` VALUES ('何生', '20132308005', '男', '汉', '盐城市', '计算机科学与技术', '江苏省盐城市东台市富安镇沙港村一组116号', '224223', '320981199412194976', '何永东', '3-203', '18751905732', '');
INSERT INTO `t_xsxx` VALUES ('贺新', '20132308006', '男', '汉', '连云港市', '计算机科学与技术', '江苏省连云港市赣榆县青口镇二沟村三组130号', '222100', '320721199503200430', '贺从波', '3-202', '18751905657', '');
INSERT INTO `t_xsxx` VALUES ('纪晓俊', '20132308007', '男', '汉', '南京市', '计算机科学与技术', '江苏省南京市浦口区象山花园1幢302室', '211800', '320122199310273258', '纪圣民', '3-204', '13276601529', '');
INSERT INTO `t_xsxx` VALUES ('姜陈洋', '20132308008', '女', '汉', '如皋市', '计算机科学与技术', '江苏省如皋市白蒲镇前进村24组6号', '226500', '320682199411052220', '刘炳生', '7-528', '15751838079', '');
INSERT INTO `t_xsxx` VALUES ('李明嘉', '20132308009', '男', '汉', '无锡市', '计算机科学与技术', '江苏省江阴市徐霞客镇上东村低冲里村5号', '214407', '320281199411282271', '李志强', '3-201', '18751905579', '');
INSERT INTO `t_xsxx` VALUES ('李日升', '20132308010', '男', '汉', '泰州市', '计算机科学与技术', '上海市浦东新区南泉北路166号', '200120', '321281199403308452', '李广腾', '3-204', '18751905681', '');
INSERT INTO `t_xsxx` VALUES ('李艳蓉', '20132308011', '女', '汉', '泰州市', '计算机科学与技术', '江苏省泰州市姜堰市中天清华园14幢502室', '225500', '321284199407238024', '李余祥', '7-609', '18751905627', '');
INSERT INTO `t_xsxx` VALUES ('李泽儒', '20132308012', '男', '汉', '泰州市', '计算机科学与技术', '江苏省泰州市高港区口岸镇水岸帝景27幢502室', '225300', '321201199411300037', '李伯和', '3-203', '18751905659', '');
INSERT INTO `t_xsxx` VALUES ('刘九良', '20132308013', '男', '汉', '宿迁市', '计算机科学与技术', '江苏省宿迁市洋河新城区仓集镇仓集村朱庄组28号', '223800', '321323199509023115', '刘金东', '3-207', '18759505682', '');
INSERT INTO `t_xsxx` VALUES ('陆鼎承', '20132308014', '男', '汉', '扬州市', '计算机科学与技术', '江苏省扬州市邗江区公道镇九龙路131号', '225119', '321027199505020311', '陆万宝', '3-203', '18751905712', '');
INSERT INTO `t_xsxx` VALUES ('倪成功', '20132308015', '男', '汉', '南京市', '计算机科学与技术', '江苏省南京市六合区雄州街道文峰路47号3单元405室', '211500', '320123199308282610', '倪庆年', '3-204', '18751905587', '');
INSERT INTO `t_xsxx` VALUES ('邱慧', '20132308016', '女', '汉', '盐城市', '计算机科学与技术', '江苏省盐城市射阳县合德镇浦港村5组44号', '224300', '320924199504283821', '邱焕生', '7-610', '18751905593', '');
INSERT INTO `t_xsxx` VALUES ('邱建华', '20132308017', '男', '汉', '哈尔滨市', '计算机科学与技术', '黑龙江省哈尔滨市巴彦县西集镇向荣村小韩泥沟屯', '151800', '232126199408111615', '邱利', '3-206', '18795807601', '');
INSERT INTO `t_xsxx` VALUES ('沈生成', '20132308018', '男', '汉', '苏州市', '计算机科学与技术', '江苏省昆山市木越城花园57幢607', '512300', '320583199502019419', '沈鑫龙', '3-206', '18751905706', '');
INSERT INTO `t_xsxx` VALUES ('盛嫣然', '20132308019', '女', '汉', '南通市', '计算机科学与技术', '江苏省南通市御林华府41幢103', '226100', '320684199405168721', '盛建平', '7-528', '18751905723', '');
INSERT INTO `t_xsxx` VALUES ('宋籽锐', '20132308020', '男', '汉', '连云港市', '计算机科学与技术', '江苏省连云港市赣榆县班庄镇古城村888号', '222100', '320721199412212815', '宋庆江', '3-202', '18751905735', '');
INSERT INTO `t_xsxx` VALUES ('孙刘坤', '20132308021', '男', '汉', '盐城市', '计算机科学与技术', '江苏省阜宁县益林镇人民北路136路', '224400', '320923199510095417', '殷梅芳', '3-203', '15195811892', '');
INSERT INTO `t_xsxx` VALUES ('汪雪', '20132308022', '女', '汉', '淮安市', '计算机科学与技术', '江苏省淮安市涟水县国子家园8幢101', '223400', '320826199509140421', '汪卫东', '7-528', '18751905572', '');
INSERT INTO `t_xsxx` VALUES ('王洁', '20132308023', '女', '汉', '句容市', '计算机科学与技术', '江苏省句容市后白镇阴桥头自然村15号', '212400', '321183199502204429', '王修鹏', '7-609', '18751905695', '');
INSERT INTO `t_xsxx` VALUES ('文辉祥', '20132308024', '男', '汉', '信阳市', '计算机科学与技术', '河南省信阳市淮滨县城美镇正义街', '464400', '411527199408220038', '文晓云', '3-205', '18751902107', '');
INSERT INTO `t_xsxx` VALUES ('杨安凯', '20132308025', '男', '汉', '溧阳市', '计算机科学与技术', '江苏省溧阳市社渚镇新华后街', '213341', '320481199408277632', '杨保友', '3-205', '18751905739', '');
INSERT INTO `t_xsxx` VALUES ('应义正', '20132308026', '男', '汉', '无锡市', '计算机科学与技术', '江苏省江阴市周庄镇华宏建材市场材料区1号', '214423', '350702199412023017', '应仁锡', '3-205', '18751905653', '');
INSERT INTO `t_xsxx` VALUES ('扎西顿珠', '20132308027', '男', '汉', '曲松县', '计算机科学与技术', '西藏省南山地区曲松县4组', '856300', '542226199503180019', '洛桑群塔', '3-207', '18076931885', '');
INSERT INTO `t_xsxx` VALUES ('张慈', '20132308028', '男', '汉', '徐州市', '计算机科学与技术', '江苏省铜山县区湖农场前样楼64号', '221164', '32032319930213081X', '张学习', '3-201', '18652287275', '');
INSERT INTO `t_xsxx` VALUES ('张俊', '20132308029', '男', '汉', '扬州市', '计算机科学与技术', '江苏省扬州市高邮市临泽镇东沟村一组54号', '225600', '321084199507215814', '张美洪', '3-206', '18751905713', '');
INSERT INTO `t_xsxx` VALUES ('张宇', '20132308030', '男', '汉', '南京市', '计算机科学与技术', '江苏省南京市金山花苑13幢4单元407室', '210028', '320113199502172412', '张跃贵', '3-204', '13801592086', '');
INSERT INTO `t_xsxx` VALUES ('赵兴炜', '20132308031', '男', '汉', '宜兴市', '计算机科学与技术', '江苏省宜兴市新街镇新乐村荷花巷35号', '214200', '320282199405283573', '赵平', '3-205', '18751905635', '');
INSERT INTO `t_xsxx` VALUES ('赵旋', '20132308032', '男', '汉', '徐州市', '计算机科学与技术', '江苏省徐州市铜山县房村镇菜园村3组108室', '221115', '320323199212033039', '赵爱龙', '3-202', '18751905576', '');
INSERT INTO `t_xsxx` VALUES ('赵毅', '20132308033', '男', '汉', '淮安市', '计算机科学与技术', '江苏省淮安市盱眙县古桑乡石龙村刘观组', '211700', '320830199405193216', '赵勇', '3-206', '18751905630', '');
INSERT INTO `t_xsxx` VALUES ('周玮', '20132308034', '女', '汉', '常州市', '计算机科学与技术', '江苏省溧阳市南渡镇强阜村269-204号', '213300', '320481199411026244', '周建平', '7-609', '18751905632', '');
INSERT INTO `t_xsxx` VALUES ('周渭东', '20132308035', '男', '汉', '舟山市', '计算机科学与技术', '浙江省舟山市定海区弄口村弄口路12号', '316012', '330902199507032917', '周志龙', '3-202', '18795803165', '');

-- ----------------------------
-- Table structure for t_yhb
-- ----------------------------
DROP TABLE IF EXISTS `t_yhb`;
CREATE TABLE `t_yhb` (
  `ID` int(20) NOT NULL auto_increment,
  `DLM` varchar(20) NOT NULL,
  `DLMM` varchar(20) NOT NULL,
  `YHSF` varchar(20) default NULL,
  `LXFS` varchar(20) default NULL,
  `YHZT` varchar(30) default NULL,
  `YX` varchar(10) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_yhb
-- ----------------------------
INSERT INTO `t_yhb` VALUES ('1', 'super', '123', '管理员', '001', '1', '100@qq.com');
INSERT INTO `t_yhb` VALUES ('2', 'admin', '123', '管理员', '002', '1', '101@qq.com');
INSERT INTO `t_yhb` VALUES ('3', 'super', 'super', '学生', '003', '1', '102@qq.com');
INSERT INTO `t_yhb` VALUES ('4', '20132308020', '001221', '学生', '004', '1', '103@qq.com');
