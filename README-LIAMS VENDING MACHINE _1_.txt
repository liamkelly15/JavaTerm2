WELCOME TO LIAM'S VENDING MACHINE - THIS JAVA PROGRAM WAS DEVELOPED USING THE INTELLIJ IDE WITH JAVAFX ADD ON

THE SYSTEM HAS 2 USERS TYPES

1- ADMIN USER
	login as admin  with username="Mark" and password="999"


2- CUSTOMER USER
	login as customer  with username="Liam" and password="111"
	login as customer  with username="John" and password="222"
	login as customer  with username="Mike" and password="123"


DATA FILES

THE SYSTEM USES THE FOLLOWING DATA FILES


1-PRODUCTS.TXT 		- THIS FILES HAS DETAIL ABOUT THE PRODUCTS
2-CUSTOMERS.TXT		- THIS FILE HAS CUSTOMER DETAIL
3-ADMIN.TXT		- THIS FILE HAS ADMIN DETAIL

THE DATA FILES ARE UPDATED DURING WHILE THE USER IS ACTIVE ONLINE.

THE DATA FILES ARE READ IN THE FOLLOWING CLASSES
	
CUSTOMER CLASS 	- 		READS CUSTOMERS.TXT 	(1 OCCURANCE)
PRODUCT CLSSS	-		READS PRODUCTS.TXT 	(1 OCCURANCE)
ADMIN CLASS	-		READS ADMIN.TXT  	(1 OCCURANCE)

VENDING MACHINE CLASS	-	READS CUSTOMERS.TXT (1 OCCURANCE)  PRODUCTS.TXT(5 OCCURANCES)	



THE LOGIN INTERFACE

THE USER NAME AND PASSWORD MUST EXIST IN THE DATA FILES - THE SYSTEM WILL CHECK THE USERNAME AND PASSWORD AGAINST THE CUSTOMER DATA 
AND THE ADMIN DATA IN THE FILE.

THE LOGIN FUNCTION DETERMINES THE TYPE OF USER FROM THE LOGIN DATA PROVIDED i.e. A CUSTOMER OR AN ADMIN USER

IF THE USER IS ADMIN THE SCREEN PRESENTED IS ONE WITH ADMIN FUNCTIONS AND IF THE USER IS CUSTOMER 
THE SCREEN PRESENTED IS ONE WITH CUSTOMER FUNCTIONS


ADMIN INTERFACES

THE ADMIN IS FIRST PRESENETD WITH THE PRODUCT MANAGEMENT INTERFACE

A-THE PRODUCT MANAGEMENT SCREEN 

	A DROP DOWN MENU OF ALL ITEMS CURRENTLY IN THE VENDING MACHINE ARE PRESENTED ALONG WITH THE PRICE AND
	STOCK QUANTITY.
	
	THE ADMIN CAN SELECT ANY ITEM IN THE MACHINE AND DECIDE TO DO THE FOLLOWING:

	1- ADJUST (ADD OR REDUCE) THE QTY IN THE MACHINE FOR THE SELECTED PRODUCT
	2- SET A NEW PRICE FOR THE SELECTED PRODUCT
	3- REMOVE THE PRODUCT FROM THE VENDING MACHINE

	THE ADMIN MUST SELECT A PRODUCT FROM THE LIST - THE USE OF TRY-CATCH ON NULL DATA PREVENTS THE ADMIN FROM TRYING
	TO EXECUTE ANY OF THE FUNCTIONS WITHOUT SELECTION OF A PRODUCT.

	THE ADMIN MUST ENTER VALID DATA - - THE USE OF TRY-CATCH ON NUMBER EXCEPTIONS DATA  PREVENTS THE ADMIN FROM TRYING
	TO EXECUTE ANY OF THE FUNCTIONS WITHOUT ENTERING VALID NUMERICAL DATA FOR THE STOCK QTY ADJUST OR THE NEW PRICE.

	SYSTEM PREVENTS THE ADMIN FROM THE FOLLOWING ENTRIES:
	
	A) ADJUSTING THE NEW PRODUCT PRICE TO A NEGATIVE VALUE (Euro 0 IS ALLOWED FOR PRODUCT PROMOTION REASONS)
	B) ADJUSTING THE STOCK QTY OF A PRODUCT TO A NEGATIVE VALUE (0 IS ALLOWED)


	THE ADMINS CAN EXECUTE ANY OF THE FUNCTIONS AND THE DROP DOWN LIST IS IMMEDIATLY UPDATED WITH THE RESULT OF THE 
	ACTION REQUESTED BY THE ADMIN (STOCK QTY UPDATED, NEW PRICE SET OR PRODUCT REMOVED)

	THE SCREEN ALSO PROVIDES THE ADMIN WITH 2 OTHER FUCTIONS

	1-GOTO NEW PRODUCT SCREEN
	2-EXIT VENDING


B-THE NEW PRODUCT SCREEN
	
	IN THIS SCREEN THE ADMIN CAN ADD A NEW PRODUCT BY ENTERING THE NAME, PRICE AND STOCK QTY.

	THE ADMIN MUST ENTER VALID DATA - THE NAME CAN BE ANY STRING BUT THE PRICE MUST BE A VALID 
	PRICE IN EURO AND THE STOCK QTY MUST BE A POSITIVE INTEGER VALUE - THE 
	SYSTEM PREVENTS THE ADMIN FROM THE FOLLOWING ENTRIES:
	
	A) ADDING PRODUCTS WITH NO NAME
	B) ADDING PRODUCTS WITH NO VALID PRICE IN EURO OR ADDING NO PRICE DATA
	C) ADDING PRODUCTS WITH NEGATIVE STOCK VALUE OR NO STOCK VALUE

	

CUSTOMER INTERFACE

THE CUSTOMER IS PRESENTED WITH THE PRODUCT PURCHASE INTERFACE AND AN INITIAL ALERT MESSAGE TO INFORM THE CUSTOMER OF THEIR
CURRENT CREDIT LEVEL.

A DROP DOWN MENU OF ALL THE ITEMS CURRENTLY IN THE VENDING MACHINE IS PRESENTED ALONG WITH THE PRICE OF THE
ITEM AND THE AVAILABLE STOCK.

THE CUSTOMER CAN CLICK ON THE VIEW CREDIT BUTTON AT ANY TIME TO SEE WHAT THE CUSTOMER CREDIT LEVEL IS.

THE CUSTOMER MUST SELECT A PRODUCT BEFORE DECIDING TO CLICK ON THE BUY PRODUCT BUTTON. (THE USE OF TRY CATCH IS 
USED TO ENSURE THAT NO NULL POINTERS ARE GENERATED)

THE CUSTOMER SELECTS A PRODUCT AND PROCEEDS TO BUY THE PRODUCT - THE FOLLOWING MAY OCCUR

	A) THE CUSTOMER HAS SUFFICIENT CREDIT AND THE ITEM HAS AVAILABLE STOCK-THE UNIT IS PURCHASED
	B) THE CUSTOMER HAS SUFFICENT CREDIT BUT THE ITEM IS NOT IN STOCK - THE CUSTOMER IS INFORMED A PURCHASE CANNOT OCCUR
	C) THE CUSTOMER HAS IN-SUFFICIENT CREDIT - THE CUSTOMER IS INFORMED AND A PURCHASE CANNOT OCCUR

IF A PRODUCT PURCHASE OCCURS AN ALERT IS THEN PRESENTED TO THE CUSTOMER INFORMING THAT THE PRODUCT HAS BEEN PURCHASED AND 
OF THEIR NEW BALANCE. THE DROP DOWN LIST IS UPDATED TO ENSURE THE CORRECT STOCK LEVELS ARE PRESENTED TO THE CUSTOMER 
AFTER THE PURCHASE AND THE CUSTOMER MAY CONTINUE TO SHOP.





















