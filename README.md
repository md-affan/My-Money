Solution for Geektrust Backend Challenge - [MyMoney](https://www.geektrust.com/coding/detailed/my-money)

Problem Statement : 
MyMoney platform lets investors consolidated portfolio value across equity, debt, and gold. We need to ensure that the desired allocation percentages are equal to the actual percentages invested. The desired allocation percentage should be derived from the initial allocation made.

The program should take as input : 
1. The money allocated in equity, debt and gold funds.
2. Monthly SIP payments.
3. Monthly change rate (loss or growth) for each type of fund.


The output should be:
1. Balanced amount of each fund for a certain month.
2. Rebalanced amount of each month if applicable.


The supported commands are :
ALLOCATE, SIP, CHANGE, BALANCE, REBALANCE



[Complete problem statement](https://www.geektrust.com/coding/detailed/my-money)

Assumptions
From Problem Statement : 

1. The money allocated in equity, debt and gold funds.
2. Monthly SIP payments.
3. Monthly change rate (loss or growth) for each type of fund.
   
Additional Assumptions Made
1. Only 3 allocation class are currently available.
2. The default input order for asset class is - EQUITY, DEBT, GOLD.
3. All the inputs must be explicitly provided, no default value as 0 is used.
4. SIP, Change percentages can be declared only once for a month.
5. The system only works for 1-year (Jan-Dec) as there is no way to distinguish between years from input.
