create or replace PACKAGE PKG_IM AS 

  PROCEDURE PROC_IM_INSERT(
    IN_NAME IN VARCHAR2 
,   IN_PRICE IN NUMBER
,   IN_MARKET IN VARCHAR2
    ,   IN_REMARKS IN VARCHAR2 
    ,   IN_MEMBER_NUM IN NUMBER
    ,   IN_MEMBER_TABLE IN NUMBER
  );
  
  PROCEDURE PROC_IM_LIST(
    IN_MEMBER_NUM IN NUMBER
 ,   O_CUR OUT SYS_REFCURSOR
  );

END PKG_IM;