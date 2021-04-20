CREATE OR REPLACE PACKAGE PKG_MEMBERS AS 

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
/


CREATE OR REPLACE PACKAGE BODY PKG_MEMBERS AS

  PROCEDURE PROC_MEMBER_INSERT(
    IN_MEMBER_NAME  IN VARCHAR2
,   IN_MEMBER_EMAIL IN VARCHAR2
,   IN_MEMBER_PWD   IN VARCHAR2
 ) AS 
  BEGIN
     INSERT INTO MEMBERS (MEMBER_NUM, MEMBER_NAME, MEMBER_EMAIL, MEMBER_PWD)
     VALUES( (SELECT (NVL(MAX(MEMBER_NUM), 0 ) + 1) FROM MEMBERS),
             IN_MEMBER_NAME, IN_MEMBER_EMAIL, IN_MEMBER_PWD);
     COMMIT;
   
  END PROC_MEMBER_INSERT;



 


  PROCEDURE PROC_MEMBER_INFO(
    IN_MEMBER_NUM IN NUMBER
    ,O_CUR OUT SYS_REFCURSOR
 ) AS
  BEGIN
    OPEN O_CUR FOR
    SELECT *
    FROM MEMBERS
    WHERE MEMBER_NUM = IN_MEMBER_NUM;
  END PROC_MEMBER_INFO;

  PROCEDURE PROC_MEMBER_UPDATE(
    IN_MEMBER_NUM IN NUMBER
,   IN_MEMBER_NAME IN VARCHAR2
,   IN_MEMBER_EMAIL IN VARCHAR2
 ) AS
  BEGIN
    UPDATE MEMBERS
    SET    MEMBER_NAME  = IN_MEMBER_NAME
,          MEMBER_EMAIL = IN_MEMBER_EMAIL
    WHERE  MEMBER_NUM   = IN_MEMBER_NUM;
    COMMIT;
  END PROC_MEMBER_UPDATE;

  PROCEDURE PROC_MEMBER_UPDATE_PASSWORD (
    IN_MEMBER_NUM IN NUMBER
,   IN_MEMBER_PWD IN VARCHAR2
 ) AS
  BEGIN
    UPDATE MEMBERS
    SET    MEMBER_PWD = IN_MEMBER_PWD
    WHERE  MEMBER_NUM = IN_MEMBER_NUM;
    COMMIT;
  END PROC_MEMBER_UPDATE_PASSWORD;

END PKG_MEMBERS;
/
