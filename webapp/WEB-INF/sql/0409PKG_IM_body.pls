CREATE OR REPLACE
PACKAGE BODY PKG_IM AS

  PROCEDURE PROC_IM_INSERT(
    IN_NAME IN VARCHAR2 
,   IN_PRICE IN NUMBER
,   IN_MARKET IN VARCHAR2 
,   IN_REMARKS IN VARCHAR2
  ) AS 
  V_CODE  VARCHAR2(300);
  BEGIN
       SELECT  'CODE' || TRIM( TO_CHAR( TO_NUMBER(
        SUBSTR( NVL(MAX(CODE), 'CODE000'), 6, 3) ) + 1, '000' ))
        INTO V_CODE
       FROM   IM; 
  
    INSERT INTO IM(IDX, CODE, NAME, PRICE, MARKET, REMARKS)
    VALUES((SELECT NVL(MAX(IDX),0)+1 FROM IM), V_CODE, IN_NAME, IN_PRICE, IN_MARKET,IN_REMARKS);
    COMMIT;
  END PROC_IM_INSERT; 

  PROCEDURE PROC_IM_LIST(
    O_CUR OUT SYS_REFCURSOR
  ) AS
  BEGIN
     OPEN O_CUR FOR
     SELECT * FROM IM;
  END PROC_IM_LIST;

END PKG_IM;