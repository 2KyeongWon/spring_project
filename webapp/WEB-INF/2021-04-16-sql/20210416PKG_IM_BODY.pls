create or replace PACKAGE BODY PKG_IM AS

  PROCEDURE PROC_IM_INSERT(
    IN_NAME IN VARCHAR2 
,   IN_CODE  IN VARCHAR2
,   IN_PRICE IN NUMBER
,   IN_MARKET IN VARCHAR2 
,   IN_REMARKS IN VARCHAR2
,   IN_MEMBER_NUM IN NUMBER
  ) AS 
  V_IDX   NUMBER(5,0); 
  BEGIN 
   
    
    SELECT NVL(MAX(IDX),0)+1
    INTO   V_IDX
    FROM   IM
    WHERE  MEMBER_NUM = IN_MEMBER_NUM;
    
    
   
  
    INSERT INTO IM(IDX, CODE, NAME, PRICE, MARKET, REMARKS, MEMBER_NUM,QUANTITY,REGDATE )
    VALUES(V_IDX, IN_CODE, IN_NAME, IN_PRICE, IN_MARKET,IN_REMARKS,IN_MEMBER_NUM,1,'regdate' );
    

    
    COMMIT;
  END PROC_IM_INSERT; 

  PROCEDURE PROC_IM_LIST(
    IN_MEMBER_NUM NUMBER,
    O_CUR OUT SYS_REFCURSOR
  ) AS
  BEGIN
     OPEN O_CUR FOR
     SELECT  MEMBER_NUM
,IDX
,CODE
,NAME
,PRICE
,MARKET
,REMARKS
     FROM IM 
     WHERE MEMBER_NUM = IN_MEMBER_NUM;
  END PROC_IM_LIST;

  PROCEDURE PROC_BASKET_INSERT(
    IN_IDX IN NUMBER
,   IN_CODE IN VARCHAR2
,   IN_NAME IN VARCHAR2
,   IN_PRICE IN NUMBER
,   IN_MARKET IN VARCHAR2
,   IN_MEMBER_NUM IN NUMBER
  ) AS
  BEGIN
        INSERT INTO BASKET(IDX, CODE, NAME, PRICE, MARKET, MEMBER_NUM)
		VALUES( IN_IDX, IN_CODE, IN_NAME, IN_PRICE, IN_MARKET, IN_MEMBER_NUM);
        
        UPDATE MEMBERS
        SET    MEMBER_BASKET = MEMBER_BASKET + 1
        WHERE  MEMBER_NUM = IN_MEMBER_NUM;
        
        COMMIT;
  END PROC_BASKET_INSERT;

END PKG_IM;