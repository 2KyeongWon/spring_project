create or replace PACKAGE PKG_MEMBERS AS 

 PROCEDURE PROC_MEMBER_INSERT(
    IN_MEMBER_NAME  IN VARCHAR2
,   IN_MEMBER_EMAIL IN VARCHAR2
,   IN_MEMBER_PWD   IN VARCHAR2
 ); 
   
 PROCEDURE PROC_MEMBER_INFO(
    IN_MEMBER_NUM IN NUMBER
    ,O_CUR OUT SYS_REFCURSOR
 );
 
 PROCEDURE PROC_MEMBER_UPDATE(
    IN_MEMBER_NUM IN NUMBER
,   IN_MEMBER_NAME IN VARCHAR2
,   IN_MEMBER_EMAIL IN VARCHAR2
 );

 PROCEDURE PROC_MEMBER_UPDATE_PASSWORD (
    IN_MEMBER_NUM IN NUMBER
,   IN_MEMBER_PWD IN VARCHAR2
 );

END PKG_MEMBERS;