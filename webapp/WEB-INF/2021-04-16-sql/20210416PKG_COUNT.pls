create or replace PACKAGE PKG_COUNT AS 
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
         IN_IDX       IN    NUMBER
        ,IN_NAME     IN    VARCHAR2
        ,IN_PRICE     IN    NUMBER
        ,IN_MARKET    IN    VARCHAR2
        ,IN_QUANTITY   IN  NUMBER
        ,IN_MEMBER_NUM IN   NUMBER
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