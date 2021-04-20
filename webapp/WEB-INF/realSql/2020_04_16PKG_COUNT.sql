CREATE OR REPLACE PACKAGE PKG_COUNT AS 
----CREATE TABLE INOUTCOUNT(
--    IDX           NUMBER(5,0)         
--,   CODE          VARCHAR2(30)   
--,   NAME          VARCHAR2(30)      
--,   PRICE         NUMBER(5,0)
--,   MARKET        VARCHAR2(40)
--,   QUANTITY      NUMBER(5,0)
--,   REGDATE       DATE             DEFAULT SYSDATE
--,   MEMBER_NUM    NUMBER(5, 0)
--,   COUNT_NUM     NUMBER(5,0)
--);
----

    PROCEDURE PROC_CO_INSERT(
         IN_IDX           NUMBER
        ,IN_NAME         VARCHAR2
        ,IN_PRICE        NUMBER
        ,IN_MARKET       VARCHAR2
        ,IN_QUANTITY     NUMBER
        ,IN_MEMBER_NUM   NUMBER
   );
    
    PROCEDURE PROC_CO_VIEWINCOUNT(
        IN_MEMBER_NUM    NUMBER
       ,OUT_CUR          OUT SYS_REFCURSOR
    );
    
    PROCEDURE PROC_CO_VIEWOUTCOUNT(
        IN_MEMBER_NUM    NUMBER
       ,OUT_CUR          OUT SYS_REFCURSOR
    );
    
    PROCEDURE PROC_CO_UPDATECOUNT(
        IN_IDX          NUMBER
       ,IN_CODE         VARCHAR2
       ,IN_NAME         VARCHAR2
       ,IN_PRICE        NUMBER
       ,IN_MARKET       VARCHAR2  
       ,IN_QUANTITY     NUMBER
       ,IN_MEMBER_NUM   NUMBER
       ,IN_COUNT_NUM    NUMBER
    );
    
    PROCEDURE PROC_CO_DELETECOUNT(  
        IN_IDX          NUMBER
       ,IN_MEMBER_NUM   NUMBER
       ,IN_COUNT_NUM    NUMBER
    );

END PKG_COUNT;
/


CREATE OR REPLACE PACKAGE BODY PKG_COUNT AS
  PROCEDURE PROC_CO_VIEWINCOUNT(
        IN_MEMBER_NUM    NUMBER
       ,OUT_CUR          OUT     SYS_REFCURSOR
    ) AS
  BEGIN  
    OPEN OUT_CUR FOR 
     SELECT  IDX
            ,CODE  
            ,NAME
            ,PRICE
            ,MARKET
            ,REGDATE
            ,QUANTITY
            ,MEMBER_NUM
     FROM  INOUTCOUNT 
     WHERE MEMBER_NUM = IN_MEMBER_NUM
     AND   COUNT_NUM  = 0;
   
    
  END PROC_CO_VIEWINCOUNT;

  PROCEDURE PROC_CO_VIEWOUTCOUNT(
        IN_MEMBER_NUM    NUMBER
       ,OUT_CUR          OUT   SYS_REFCURSOR
    ) AS
  BEGIN
     OPEN OUT_CUR FOR
     SELECT  
             IDX
            ,CODE
            ,NAME
            ,PRICE
            ,MARKET
            ,REGDATE
            ,QUANTITY
            ,MEMBER_NUM
     FROM  INOUTCOUNT 
     WHERE MEMBER_NUM = IN_MEMBER_NUM
     AND   COUNT_NUM  = 1;
     
     
  END PROC_CO_VIEWOUTCOUNT;

  PROCEDURE PROC_CO_UPDATECOUNT(
        IN_IDX          NUMBER
       ,IN_CODE         VARCHAR2
       ,IN_NAME         VARCHAR2
       ,IN_PRICE        NUMBER
       ,IN_MARKET       VARCHAR2
       ,IN_QUANTITY     NUMBER
       ,IN_MEMBER_NUM   NUMBER
       ,IN_COUNT_NUM    NUMBER
    ) AS
  BEGIN
    UPDATE INOUTCOUNT
      SET   CODE  = IN_CODE
           ,NAME  = IN_NAME
           ,PRICE = IN_PRICE
           ,MARKET = IN_MARKET
           ,QUANTITY = IN_QUANTITY
     WHERE MEMBER_NUM =  IN_MEMBER_NUM
     AND   COUNT_NUM   = IN_COUNT_NUM;
    
  END PROC_CO_UPDATECOUNT;

  PROCEDURE PROC_CO_DELETECOUNT(
        IN_IDX          NUMBER
       ,IN_MEMBER_NUM   NUMBER
       ,IN_COUNT_NUM    NUMBER  
    ) AS
  BEGIN
    DELETE FROM INOUTCOUNT  
    WHERE  IDX = IN_IDX  
    AND    MEMBER_NUM = IN_MEMBER_NUM;
  END PROC_CO_DELETECOUNT;

  PROCEDURE PROC_CO_INSERT(
         IN_IDX           NUMBER
        ,IN_NAME         VARCHAR2
        ,IN_PRICE        NUMBER
        ,IN_MARKET       VARCHAR2
        ,IN_QUANTITY     NUMBER
        ,IN_MEMBER_NUM   NUMBER
   ) AS
   V_IDX NUMBER(5,0);
  BEGIN
    SELECT NVL(MAX(IDX),0)+1
    INTO   V_IDX
    FROM   INOUTCOUNT;
  
     INSERT INTO INOUTCOUNT(IDX,NAME,PRICE,MARKET,QUANTITY,
                            REGDATE,MEMBER_NUM,COUNT_NUM) 
     VALUES(V_IDX, IN_NAME,IN_PRICE,IN_MARKET,IN_QUANTITY,SYSDATE,IN_MEMBER_NUM,0);
     
     DELETE FROM BASKET
     WHERE  IDX = IN_IDX
     AND    NAME = IN_NAME
     AND    MARKET = IN_MARKET
     AND    MEMBER_NUM = IN_MEMBER_NUM;
     
     COMMIT;
  END PROC_CO_INSERT;

END PKG_COUNT;
/
