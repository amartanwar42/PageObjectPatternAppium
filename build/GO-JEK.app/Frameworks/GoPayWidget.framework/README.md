## GoPayWidget

--------------
** v3.31 ** `07 June, 2019`
=========================



--------------
** v3.30 ** `24 May, 2019`
=========================
- Support Ride Edit Booking in Payment Widge


**Fixes:**
- Fetched latest balance for PL and Wallet while open the payment selector 

--------------
** v3.29 ** `10 May, 2019`
=========================
- Integrate PayLah! in Payment Widget behind remote config
- Show Payment Option Based on array elements from Backend 
- Fetch PL and GP-Wallet profile on widget launch and selector view opens
- Added Cashback feature with UI layout change to option list


**Fixes:**
-Fixed weird height-change displacement while switching while loading to pricing info displayed and vice-versa

Remote config keys:
>  `feature_pay_pw_{payment_method_identifier}`  Enable respective payment type if it exist


----------------------------
** v3.28 ** `25 April, 2019`
=========================
- Fixed crash on getting range
- Changed deployment and swift version of gopaywidget tests to 10.0 and 4.0
- Added rawType in decode token

** v3.24 ** `1 March, 2019`
=========================
- Added Payment selector
- Using same payment options model for older cards api response
- Added states according to payment method status
- Added entry point for widget-setting through GoPay behind remote config
- Made required paylater changes to their repos

** v3.22 ** `14 February, 2019`
=========================
- Started working on PaymentOption api which will replace existing /card/ apis
- Added PayLater and Wallet as payment option (WIP)
- Added serviceType dependacy for PayLater SDK
- Filtered the payment options w.r.t availabilty of paylater for product 

** v3.22 ** `31 January, 2019`
=========================
- Started working on PaymentOption api which will replace existing /card/ apis


** v3.21 ** `17 January, 2019`
=========================
- Added card-header view in card detail page 
- Made Cash as optional paymant method


** v3.20 ** `3 January, 2019`
=========================
- Added card setting section for singapore
- Added luhn algorithm to validate card upfront
- Card number digit count should be to 13 -19
- Added some UI fixes from older release
- Added Empty state view for card list 


** v3.19 ** `Not Participated`
=========================
-


** v3.18 ** `05 December, 2018`
=========================
- Added API calls for update card name, delete card


Fixes:
- Changed expiry month and year from integer to string for API parameter usage
- Changed CVV integer to string for API parameter
- Fixed Primary card sorting


** v3.17 ** `22 November, 2018`
=========================
- Create separate module for widget
- Added first drafted flow for add card
- Write down required apis
- Added card images  


** v3.16 ** `24 October, 2018`
=========================
- Started work on Pay Widget for Singapore 

